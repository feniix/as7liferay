/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.shopping.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PrefsPropsUtil;
import com.liferay.portlet.amazonrankings.model.AmazonRankings;
import com.liferay.portlet.amazonrankings.util.AmazonRankingsUtil;
import com.liferay.portlet.shopping.DuplicateItemSKUException;
import com.liferay.portlet.shopping.ItemLargeImageNameException;
import com.liferay.portlet.shopping.ItemLargeImageSizeException;
import com.liferay.portlet.shopping.ItemMediumImageNameException;
import com.liferay.portlet.shopping.ItemMediumImageSizeException;
import com.liferay.portlet.shopping.ItemNameException;
import com.liferay.portlet.shopping.ItemSKUException;
import com.liferay.portlet.shopping.ItemSmallImageNameException;
import com.liferay.portlet.shopping.ItemSmallImageSizeException;
import com.liferay.portlet.shopping.model.ShoppingCategory;
import com.liferay.portlet.shopping.model.ShoppingCategoryConstants;
import com.liferay.portlet.shopping.model.ShoppingItem;
import com.liferay.portlet.shopping.model.ShoppingItemField;
import com.liferay.portlet.shopping.model.ShoppingItemPrice;
import com.liferay.portlet.shopping.model.ShoppingItemPriceConstants;
import com.liferay.portlet.shopping.service.base.ShoppingItemLocalServiceBaseImpl;
import com.liferay.util.PwdGenerator;
import com.liferay.util.SystemProperties;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ShoppingItemLocalServiceImpl
	extends ShoppingItemLocalServiceBaseImpl {

	public void addBookItems(
			long userId, long groupId, long categoryId, String[] isbns)
		throws PortalException, SystemException {

		try {
			doAddBookItems(userId, groupId, categoryId, isbns);
		}
		catch (IOException ioe) {
			throw new SystemException(ioe);
		}
	}

	public ShoppingItem addItem(
			long userId, long groupId, long categoryId, String sku, String name,
			String description, String properties, String fieldsQuantities,
			boolean requiresShipping, int stockQuantity, boolean featured,
			Boolean sale, boolean smallImage, String smallImageURL,
			File smallFile, boolean mediumImage, String mediumImageURL,
			File mediumFile, boolean largeImage, String largeImageURL,
			File largeFile, List<ShoppingItemField> itemFields,
			List<ShoppingItemPrice> itemPrices, ServiceContext serviceContext)
		throws PortalException, SystemException {

		// Item

		User user = userPersistence.findByPrimaryKey(userId);
		sku = sku.trim().toUpperCase();

		byte[] smallBytes = null;
		byte[] mediumBytes = null;
		byte[] largeBytes = null;

		try {
			smallBytes = FileUtil.getBytes(smallFile);
			mediumBytes = FileUtil.getBytes(mediumFile);
			largeBytes = FileUtil.getBytes(largeFile);
		}
		catch (IOException ioe) {
		}

		Date now = new Date();

		validate(
			user.getCompanyId(), 0, sku, name, smallImage, smallImageURL,
			smallFile, smallBytes, mediumImage, mediumImageURL, mediumFile,
			mediumBytes, largeImage, largeImageURL, largeFile, largeBytes);

		long itemId = counterLocalService.increment();

		ShoppingItem item = shoppingItemPersistence.create(itemId);

		item.setGroupId(groupId);
		item.setCompanyId(user.getCompanyId());
		item.setUserId(user.getUserId());
		item.setUserName(user.getFullName());
		item.setCreateDate(now);
		item.setModifiedDate(now);
		item.setCategoryId(categoryId);
		item.setSku(sku);
		item.setName(name);
		item.setDescription(description);
		item.setProperties(properties);
		item.setFields(itemFields.size() > 0);
		item.setFieldsQuantities(fieldsQuantities);

		for (ShoppingItemPrice itemPrice : itemPrices) {
			if (itemPrice.getStatus() ==
					ShoppingItemPriceConstants.STATUS_ACTIVE_DEFAULT) {

				item.setMinQuantity(itemPrice.getMinQuantity());
				item.setMaxQuantity(itemPrice.getMaxQuantity());
				item.setPrice(itemPrice.getPrice());
				item.setDiscount(itemPrice.getDiscount());
				item.setTaxable(itemPrice.getTaxable());
				item.setShipping(itemPrice.getShipping());
				item.setUseShippingFormula(
					itemPrice.getUseShippingFormula());
			}

			if ((sale == null) && (itemPrice.getDiscount() > 0) &&
				((itemPrice.getStatus() ==
					ShoppingItemPriceConstants.STATUS_ACTIVE_DEFAULT) ||
				(itemPrice.getStatus() ==
					ShoppingItemPriceConstants.STATUS_ACTIVE))) {

				sale = Boolean.TRUE;
			}
		}

		item.setRequiresShipping(requiresShipping);
		item.setStockQuantity(stockQuantity);
		item.setFeatured(featured);
		item.setSale((sale != null) ? sale.booleanValue() : false);
		item.setSmallImage(smallImage);
		item.setSmallImageId(counterLocalService.increment());
		item.setSmallImageURL(smallImageURL);
		item.setMediumImage(mediumImage);
		item.setMediumImageId(counterLocalService.increment());
		item.setMediumImageURL(mediumImageURL);
		item.setLargeImage(largeImage);
		item.setLargeImageId(counterLocalService.increment());
		item.setLargeImageURL(largeImageURL);

		shoppingItemPersistence.update(item, false);

		// Resources

		if (serviceContext.getAddCommunityPermissions() ||
			serviceContext.getAddGuestPermissions()) {

			addItemResources(
				item, serviceContext.getAddCommunityPermissions(),
				serviceContext.getAddGuestPermissions());
		}
		else {
			addItemResources(
				item, serviceContext.getCommunityPermissions(),
				serviceContext.getGuestPermissions());
		}

		// Images

		saveImages(
			smallImage, item.getSmallImageId(), smallFile, smallBytes,
			mediumImage, item.getMediumImageId(), mediumFile, mediumBytes,
			largeImage, item.getLargeImageId(), largeFile, largeBytes);

		// Item fields

		for (ShoppingItemField itemField : itemFields) {
			long itemFieldId = counterLocalService.increment();

			itemField.setItemFieldId(itemFieldId);
			itemField.setItemId(itemId);
			itemField.setName(checkItemField(itemField.getName()));
			itemField.setValues(checkItemField(itemField.getValues()));

			shoppingItemFieldPersistence.update(itemField, false);
		}

		// Item prices

		if (itemPrices.size() > 1) {
			for (ShoppingItemPrice itemPrice : itemPrices) {
				long itemPriceId = counterLocalService.increment();

				itemPrice.setItemPriceId(itemPriceId);
				itemPrice.setItemId(itemId);

				shoppingItemPricePersistence.update(itemPrice, false);
			}
		}

		return item;
	}

	public void addItemResources(
			long itemId, boolean addCommunityPermissions,
			boolean addGuestPermissions)
		throws PortalException, SystemException {

		ShoppingItem item = shoppingItemPersistence.findByPrimaryKey(itemId);

		addItemResources(
			item, addCommunityPermissions, addGuestPermissions);
	}

	public void addItemResources(
			long itemId, String[] communityPermissions,
			String[] guestPermissions)
		throws PortalException, SystemException {

		ShoppingItem item = shoppingItemPersistence.findByPrimaryKey(itemId);

		addItemResources(item, communityPermissions, guestPermissions);
	}

	public void addItemResources(
			ShoppingItem item, boolean addCommunityPermissions,
			boolean addGuestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.addResources(
			item.getCompanyId(), item.getGroupId(), item.getUserId(),
			ShoppingItem.class.getName(), item.getItemId(), false,
			addCommunityPermissions, addGuestPermissions);
	}

	public void addItemResources(
			ShoppingItem item, String[] communityPermissions,
			String[] guestPermissions)
		throws PortalException, SystemException {

		resourceLocalService.addModelResources(
			item.getCompanyId(), item.getGroupId(), item.getUserId(),
			ShoppingItem.class.getName(), item.getItemId(),
			communityPermissions, guestPermissions);
	}

	public void deleteItem(long itemId)
		throws PortalException, SystemException {

		ShoppingItem item = shoppingItemPersistence.findByPrimaryKey(itemId);

		deleteItem(item);
	}

	public void deleteItem(ShoppingItem item)
		throws PortalException, SystemException {

		// Item

		shoppingItemPersistence.remove(item);

		// Resources

		resourceLocalService.deleteResource(
			item.getCompanyId(), ShoppingItem.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL, item.getItemId());

		// Images

		imageLocalService.deleteImage(item.getSmallImageId());
		imageLocalService.deleteImage(item.getMediumImageId());
		imageLocalService.deleteImage(item.getLargeImageId());

		// Item fields

		shoppingItemFieldPersistence.removeByItemId(item.getItemId());

		// Item prices

		shoppingItemPricePersistence.removeByItemId(item.getItemId());
	}

	public void deleteItems(long groupId, long categoryId)
		throws PortalException, SystemException {

		List<ShoppingItem> items = shoppingItemPersistence.findByG_C(
			groupId, categoryId);

		for (ShoppingItem item : items) {
			deleteItem(item);
		}
	}

	public int getCategoriesItemsCount(long groupId, List<Long> categoryIds)
		throws SystemException {

		return shoppingItemFinder.countByG_C(groupId, categoryIds);
	}

	public List<ShoppingItem> getFeaturedItems(
			long groupId, long categoryId, int numOfItems)
		throws SystemException {

		List<ShoppingItem> featuredItems = shoppingItemFinder.findByFeatured(
			groupId, new long[] {categoryId}, numOfItems);

		if (featuredItems.size() == 0) {
			List<ShoppingCategory> childCategories =
				shoppingCategoryPersistence.findByG_P(groupId, categoryId);

			if (childCategories.size() > 0) {
				long[] categoryIds = new long[childCategories.size()];

				for (int i = 0; i < childCategories.size(); i++) {
					ShoppingCategory childCategory = childCategories.get(i);

					categoryIds[i] = childCategory.getCategoryId();
				}

				featuredItems = shoppingItemFinder.findByFeatured(
					groupId, categoryIds, numOfItems);
			}
		}

		return featuredItems;
	}

	public ShoppingItem getItem(long itemId)
		throws PortalException, SystemException {

		return shoppingItemPersistence.findByPrimaryKey(itemId);
	}

	public ShoppingItem getItem(long companyId, String sku)
		throws PortalException, SystemException {

		return shoppingItemPersistence.findByC_S(companyId, sku);
	}

	public ShoppingItem getItemByLargeImageId(long largeImageId)
		throws PortalException, SystemException {

		return shoppingItemPersistence.findByLargeImageId(largeImageId);
	}

	public ShoppingItem getItemByMediumImageId(long mediumImageId)
		throws PortalException, SystemException {

		return shoppingItemPersistence.findByMediumImageId(mediumImageId);
	}

	public ShoppingItem getItemBySmallImageId(long smallImageId)
		throws PortalException, SystemException {

		return shoppingItemPersistence.findBySmallImageId(smallImageId);
	}

	public List<ShoppingItem> getItems(long groupId, long categoryId)
		throws SystemException {

		return shoppingItemPersistence.findByG_C(groupId, categoryId);
	}

	public List<ShoppingItem> getItems(
			long groupId, long categoryId, int start, int end,
			OrderByComparator obc)
		throws SystemException {

		return shoppingItemPersistence.findByG_C(
			groupId, categoryId, start, end, obc);
	}

	public int getItemsCount(long groupId, long categoryId)
		throws SystemException {

		return shoppingItemPersistence.countByG_C(groupId, categoryId);
	}

	public ShoppingItem[] getItemsPrevAndNext(
			long itemId, OrderByComparator obc)
		throws PortalException, SystemException {

		ShoppingItem item = shoppingItemPersistence.findByPrimaryKey(itemId);

		return shoppingItemPersistence.findByG_C_PrevAndNext(
			item.getItemId(), item.getGroupId(), item.getCategoryId(), obc);
	}

	public List<ShoppingItem> getSaleItems(
			long groupId, long categoryId, int numOfItems)
		throws SystemException {

		List<ShoppingItem> saleItems = shoppingItemFinder.findBySale(
			groupId, new long[] {categoryId}, numOfItems);

		if (saleItems.size() == 0) {
			List<ShoppingCategory> childCategories =
				shoppingCategoryPersistence.findByG_P(groupId, categoryId);

			if (childCategories.size() > 0) {
				long[] categoryIds = new long[childCategories.size()];

				for (int i = 0; i < childCategories.size(); i++) {
					ShoppingCategory childCategory = childCategories.get(i);

					categoryIds[i] = childCategory.getCategoryId();
				}

				saleItems = shoppingItemFinder.findBySale(
					groupId, categoryIds, numOfItems);
			}
		}

		return saleItems;
	}

	public List<ShoppingItem> search(
			long groupId, long[] categoryIds, String keywords, int start,
			int end)
		throws SystemException {

		return shoppingItemFinder.findByKeywords(
			groupId, categoryIds, keywords, start, end);
	}

	public int searchCount(long groupId, long[] categoryIds, String keywords)
		throws SystemException {

		return shoppingItemFinder.countByKeywords(
			groupId, categoryIds, keywords);
	}

	public ShoppingItem updateItem(
			long userId, long itemId, long groupId, long categoryId, String sku,
			String name, String description, String properties,
			String fieldsQuantities, boolean requiresShipping,
			int stockQuantity, boolean featured, Boolean sale,
			boolean smallImage, String smallImageURL, File smallFile,
			boolean mediumImage, String mediumImageURL, File mediumFile,
			boolean largeImage, String largeImageURL, File largeFile,
			List<ShoppingItemField> itemFields,
			List<ShoppingItemPrice> itemPrices, ServiceContext serviceContext)
		throws PortalException, SystemException {

		// Item

		ShoppingItem item = shoppingItemPersistence.findByPrimaryKey(itemId);

		User user = userPersistence.findByPrimaryKey(userId);
		categoryId = getCategory(item, categoryId);
		sku = sku.trim().toUpperCase();

		byte[] smallBytes = null;
		byte[] mediumBytes = null;
		byte[] largeBytes = null;

		try {
			smallBytes = FileUtil.getBytes(smallFile);
			mediumBytes = FileUtil.getBytes(mediumFile);
			largeBytes = FileUtil.getBytes(largeFile);
		}
		catch (IOException ioe) {
		}

		validate(
			user.getCompanyId(), itemId, sku, name, smallImage, smallImageURL,
			smallFile, smallBytes, mediumImage, mediumImageURL, mediumFile,
			mediumBytes, largeImage, largeImageURL, largeFile, largeBytes);

		item.setModifiedDate(new Date());
		item.setCategoryId(categoryId);
		item.setSku(sku);
		item.setName(name);
		item.setDescription(description);
		item.setProperties(properties);
		item.setFields(itemFields.size() > 0);
		item.setFieldsQuantities(fieldsQuantities);

		for (ShoppingItemPrice itemPrice : itemPrices) {
			if (itemPrice.getStatus() ==
					ShoppingItemPriceConstants.STATUS_ACTIVE_DEFAULT) {

				item.setMinQuantity(itemPrice.getMinQuantity());
				item.setMaxQuantity(itemPrice.getMaxQuantity());
				item.setPrice(itemPrice.getPrice());
				item.setDiscount(itemPrice.getDiscount());
				item.setTaxable(itemPrice.getTaxable());
				item.setShipping(itemPrice.getShipping());
				item.setUseShippingFormula(
					itemPrice.getUseShippingFormula());
			}

			if ((sale == null) && (itemPrice.getDiscount() > 0) &&
				((itemPrice.getStatus() ==
					ShoppingItemPriceConstants.STATUS_ACTIVE_DEFAULT) ||
				(itemPrice.getStatus() ==
					ShoppingItemPriceConstants.STATUS_ACTIVE))) {

				sale = Boolean.TRUE;
			}
		}

		item.setRequiresShipping(requiresShipping);
		item.setStockQuantity(stockQuantity);
		item.setFeatured(featured);
		item.setSale((sale != null) ? sale.booleanValue() : false);
		item.setSmallImage(smallImage);
		item.setSmallImageURL(smallImageURL);
		item.setMediumImage(mediumImage);
		item.setMediumImageURL(mediumImageURL);
		item.setLargeImage(largeImage);
		item.setLargeImageURL(largeImageURL);

		shoppingItemPersistence.update(item, false);

		// Images

		saveImages(
			smallImage, item.getSmallImageId(), smallFile, smallBytes,
			mediumImage, item.getMediumImageId(), mediumFile, mediumBytes,
			largeImage, item.getLargeImageId(), largeFile, largeBytes);

		// Item fields

		shoppingItemFieldPersistence.removeByItemId(itemId);

		for (ShoppingItemField itemField : itemFields) {
			long itemFieldId = counterLocalService.increment();

			itemField.setItemFieldId(itemFieldId);
			itemField.setItemId(itemId);
			itemField.setName(checkItemField(itemField.getName()));
			itemField.setValues(checkItemField(itemField.getValues()));

			shoppingItemFieldPersistence.update(itemField, false);
		}

		// Item prices

		shoppingItemPricePersistence.removeByItemId(itemId);

		if (itemPrices.size() > 1) {
			for (ShoppingItemPrice itemPrice : itemPrices) {
				long itemPriceId = counterLocalService.increment();

				itemPrice.setItemPriceId(itemPriceId);
				itemPrice.setItemId(itemId);

				shoppingItemPricePersistence.update(itemPrice, false);
			}
		}

		return item;
	}

	protected String checkItemField(String value) {
		return StringUtil.replace(
			value,
			new String[] {
				"\"", "&", "'", ".", "=", "|"
			},
			new String[] {
				StringPool.BLANK,
				StringPool.BLANK,
				StringPool.BLANK,
				StringPool.BLANK,
				StringPool.BLANK,
				StringPool.BLANK
			}
		);
	}

	protected void doAddBookItems(
			long userId, long groupId, long categoryId, String[] isbns)
		throws IOException, PortalException, SystemException {

		String tmpDir = SystemProperties.get(SystemProperties.TMP_DIR);

		for (int i = 0; (i < isbns.length) && (i < 50); i++) {
			String isbn = isbns[i];

			AmazonRankings amazonRankings =
				AmazonRankingsUtil.getAmazonRankings(isbn);

			if (amazonRankings == null) {
				continue;
			}

			String name = amazonRankings.getProductName();
			String description = StringPool.BLANK;
			String properties = getBookProperties(amazonRankings);

			int minQuantity = 0;
			int maxQuantity = 0;
			double price = amazonRankings.getListPrice();
			double discount = 1 - amazonRankings.getOurPrice() / price;
			boolean taxable = true;
			double shipping = 0.0;
			boolean useShippingFormula = true;

			ShoppingItemPrice itemPrice =
				shoppingItemPricePersistence.create(0);

			itemPrice.setMinQuantity(minQuantity);
			itemPrice.setMaxQuantity(maxQuantity);
			itemPrice.setPrice(price);
			itemPrice.setDiscount(discount);
			itemPrice.setTaxable(taxable);
			itemPrice.setShipping(shipping);
			itemPrice.setUseShippingFormula(useShippingFormula);
			itemPrice.setStatus(
				ShoppingItemPriceConstants.STATUS_ACTIVE_DEFAULT);

			boolean requiresShipping = true;
			int stockQuantity = 0;
			boolean featured = false;
			Boolean sale = null;

			// Small image

			boolean smallImage = true;
			String smallImageURL = StringPool.BLANK;
			File smallFile = new File(
				tmpDir + File.separatorChar +
				PwdGenerator.getPassword(
					PwdGenerator.KEY1 + PwdGenerator.KEY2, 12) + ".jpg");

			byte[] smallBytes = HttpUtil.URLtoByteArray(
				amazonRankings.getSmallImageURL());

			if (smallBytes.length < 1024) {
				smallImage = false;
			}
			else {
				OutputStream os = new FileOutputStream(smallFile);

				os.write(smallBytes);

				os.close();
			}

			// Medium image

			boolean mediumImage = true;
			String mediumImageURL = StringPool.BLANK;
			File mediumFile = new File(
				tmpDir + File.separatorChar +
				PwdGenerator.getPassword(
					PwdGenerator.KEY1 + PwdGenerator.KEY2, 12) + ".jpg");

			byte[] mediumBytes = HttpUtil.URLtoByteArray(
				amazonRankings.getMediumImageURL());

			if (mediumBytes.length < 1024) {
				mediumImage = false;
			}
			else {
				OutputStream os = new FileOutputStream(mediumFile);

				os.write(mediumBytes);

				os.close();
			}

			// Large image

			boolean largeImage = true;
			String largeImageURL = StringPool.BLANK;
			File largeFile = new File(
				tmpDir + File.separatorChar +
				PwdGenerator.getPassword(
					PwdGenerator.KEY1 + PwdGenerator.KEY2, 12) + ".jpg");

			byte[] largeBytes = HttpUtil.URLtoByteArray(
				amazonRankings.getLargeImageURL());

			if (largeBytes.length < 1024) {
				largeImage = false;
			}
			else {
				OutputStream os = new FileOutputStream(largeFile);

				os.write(largeBytes);

				os.close();
			}

			List<ShoppingItemField> itemFields =
				new ArrayList<ShoppingItemField>();

			List<ShoppingItemPrice> itemPrices =
				new ArrayList<ShoppingItemPrice>();

			itemPrices.add(itemPrice);

			ServiceContext serviceContext = new ServiceContext();

			serviceContext.setAddCommunityPermissions(true);
			serviceContext.setAddGuestPermissions(true);

			addItem(
				userId, groupId, categoryId, isbn, name, description,
				properties, StringPool.BLANK, requiresShipping, stockQuantity,
				featured, sale, smallImage, smallImageURL, smallFile,
				mediumImage, mediumImageURL, mediumFile, largeImage,
				largeImageURL, largeFile, itemFields, itemPrices,
				serviceContext);

			smallFile.delete();
			mediumFile.delete();
			largeFile.delete();
		}
	}

	protected String getBookProperties(AmazonRankings amazonRankings) {
		String isbn = amazonRankings.getISBN();

		String authors = StringUtil.merge(amazonRankings.getAuthors(), ", ");

		String publisher =
			amazonRankings.getManufacturer() + "; (" +
			amazonRankings.getReleaseDateAsString() + ")";

		String properties =
			"ISBN=" + isbn + "\nAuthor=" + authors + "\nPublisher=" + publisher;

		return properties;
	}

	protected long getCategory(ShoppingItem item, long categoryId)
		throws SystemException {

		if ((item.getCategoryId() != categoryId) &&
			(categoryId !=
				ShoppingCategoryConstants.DEFAULT_PARENT_CATEGORY_ID)) {

			ShoppingCategory newCategory =
				shoppingCategoryPersistence.fetchByPrimaryKey(categoryId);

			if ((newCategory == null) ||
				(item.getGroupId() != newCategory.getGroupId())) {

				categoryId = item.getCategoryId();
			}
		}

		return categoryId;
	}

	protected void saveImages(
			boolean smallImage, long smallImageId, File smallFile,
			byte[] smallBytes, boolean mediumImage, long mediumImageId,
			File mediumFile, byte[] mediumBytes, boolean largeImage,
			long largeImageId, File largeFile, byte[] largeBytes)
		throws PortalException, SystemException {

		// Small image

		if (smallImage) {
			if ((smallFile != null) && (smallBytes != null)) {
				imageLocalService.updateImage(smallImageId, smallBytes);
			}
		}
		else {
			imageLocalService.deleteImage(smallImageId);
		}

		// Medium image

		if (mediumImage) {
			if ((mediumFile != null) && (mediumBytes != null)) {
				imageLocalService.updateImage(mediumImageId, mediumBytes);
			}
		}
		else {
			imageLocalService.deleteImage(mediumImageId);
		}

		// Large image

		if (largeImage) {
			if ((largeFile != null) && (largeBytes != null)) {
				imageLocalService.updateImage(largeImageId, largeBytes);
			}
		}
		else {
			imageLocalService.deleteImage(largeImageId);
		}
	}

	protected void validate(
			long companyId, long itemId, String sku, String name,
			boolean smallImage, String smallImageURL, File smallFile,
			byte[] smallBytes, boolean mediumImage, String mediumImageURL,
			File mediumFile, byte[] mediumBytes, boolean largeImage,
			String largeImageURL, File largeFile, byte[] largeBytes)
		throws PortalException, SystemException {

		if (Validator.isNull(sku)) {
			throw new ItemSKUException();
		}

		ShoppingItem item = shoppingItemPersistence.fetchByC_S(
			companyId, sku);

		if (item != null) {
			if (itemId > 0) {
				if (item.getItemId() != itemId) {
					throw new DuplicateItemSKUException();
				}
			}
			else {
				throw new DuplicateItemSKUException();
			}
		}

		if (Validator.isNull(name)) {
			throw new ItemNameException();
		}

		String[] imageExtensions = PrefsPropsUtil.getStringArray(
			PropsKeys.SHOPPING_IMAGE_EXTENSIONS, StringPool.COMMA);

		// Small image

		if (smallImage && Validator.isNull(smallImageURL) &&
			smallFile != null && smallBytes != null) {

			String smallImageName = smallFile.getName();

			if (smallImageName != null) {
				boolean validSmallImageExtension = false;

				for (int i = 0; i < imageExtensions.length; i++) {
					if (StringPool.STAR.equals(imageExtensions[i]) ||
						StringUtil.endsWith(
							smallImageName, imageExtensions[i])) {

						validSmallImageExtension = true;

						break;
					}
				}

				if (!validSmallImageExtension) {
					throw new ItemSmallImageNameException(smallImageName);
				}
			}

			long smallImageMaxSize = PrefsPropsUtil.getLong(
				PropsKeys.SHOPPING_IMAGE_MEDIUM_MAX_SIZE);

			if ((smallImageMaxSize > 0) &&
				((smallBytes == null) ||
					(smallBytes.length > smallImageMaxSize))) {

				throw new ItemSmallImageSizeException();
			}
		}

		// Medium image

		if (mediumImage && Validator.isNull(mediumImageURL) &&
			mediumFile != null && mediumBytes != null) {

			String mediumImageName = mediumFile.getName();

			if (mediumImageName != null) {
				boolean validMediumImageExtension = false;

				for (int i = 0; i < imageExtensions.length; i++) {
					if (StringPool.STAR.equals(imageExtensions[i]) ||
						StringUtil.endsWith(
							mediumImageName, imageExtensions[i])) {

						validMediumImageExtension = true;

						break;
					}
				}

				if (!validMediumImageExtension) {
					throw new ItemMediumImageNameException(mediumImageName);
				}
			}

			long mediumImageMaxSize = PrefsPropsUtil.getLong(
				PropsKeys.SHOPPING_IMAGE_MEDIUM_MAX_SIZE);

			if ((mediumImageMaxSize > 0) &&
				((mediumBytes == null) ||
					(mediumBytes.length > mediumImageMaxSize))) {

				throw new ItemMediumImageSizeException();
			}
		}

		// Large image

		if (largeImage && Validator.isNull(largeImageURL) &&
			largeFile != null && largeBytes != null) {

			String largeImageName = largeFile.getName();

			if (largeImageName != null) {
				boolean validLargeImageExtension = false;

				for (int i = 0; i < imageExtensions.length; i++) {
					if (StringPool.STAR.equals(imageExtensions[i]) ||
						StringUtil.endsWith(
							largeImageName, imageExtensions[i])) {

						validLargeImageExtension = true;

						break;
					}
				}

				if (!validLargeImageExtension) {
					throw new ItemLargeImageNameException(largeImageName);
				}
			}

			long largeImageMaxSize = PrefsPropsUtil.getLong(
				PropsKeys.SHOPPING_IMAGE_LARGE_MAX_SIZE);

			if ((largeImageMaxSize > 0) &&
				((largeBytes == null) ||
					(largeBytes.length > largeImageMaxSize))) {

				throw new ItemLargeImageSizeException();
			}
		}
	}

}