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

package com.liferay.portlet.asset.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * The utility for the asset tag property local service. This utility wraps {@link com.liferay.portlet.asset.service.impl.AssetTagPropertyLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.asset.service.impl.AssetTagPropertyLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssetTagPropertyLocalService
 * @see com.liferay.portlet.asset.service.base.AssetTagPropertyLocalServiceBaseImpl
 * @see com.liferay.portlet.asset.service.impl.AssetTagPropertyLocalServiceImpl
 * @generated
 */
public class AssetTagPropertyLocalServiceUtil {
	/**
	* Adds the asset tag property to the database. Also notifies the appropriate model listeners.
	*
	* @param assetTagProperty the asset tag property to add
	* @return the asset tag property that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.asset.model.AssetTagProperty addAssetTagProperty(
		com.liferay.portlet.asset.model.AssetTagProperty assetTagProperty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addAssetTagProperty(assetTagProperty);
	}

	/**
	* Creates a new asset tag property with the primary key. Does not add the asset tag property to the database.
	*
	* @param tagPropertyId the primary key for the new asset tag property
	* @return the new asset tag property
	*/
	public static com.liferay.portlet.asset.model.AssetTagProperty createAssetTagProperty(
		long tagPropertyId) {
		return getService().createAssetTagProperty(tagPropertyId);
	}

	/**
	* Deletes the asset tag property with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tagPropertyId the primary key of the asset tag property to delete
	* @throws PortalException if a asset tag property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteAssetTagProperty(long tagPropertyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteAssetTagProperty(tagPropertyId);
	}

	/**
	* Deletes the asset tag property from the database. Also notifies the appropriate model listeners.
	*
	* @param assetTagProperty the asset tag property to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteAssetTagProperty(
		com.liferay.portlet.asset.model.AssetTagProperty assetTagProperty)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteAssetTagProperty(assetTagProperty);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the asset tag property with the primary key.
	*
	* @param tagPropertyId the primary key of the asset tag property to get
	* @return the asset tag property
	* @throws PortalException if a asset tag property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.asset.model.AssetTagProperty getAssetTagProperty(
		long tagPropertyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getAssetTagProperty(tagPropertyId);
	}

	/**
	* Gets a range of all the asset tag properties.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of asset tag properties to return
	* @param end the upper bound of the range of asset tag properties to return (not inclusive)
	* @return the range of asset tag properties
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portlet.asset.model.AssetTagProperty> getAssetTagProperties(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAssetTagProperties(start, end);
	}

	/**
	* Gets the number of asset tag properties.
	*
	* @return the number of asset tag properties
	* @throws SystemException if a system exception occurred
	*/
	public static int getAssetTagPropertiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAssetTagPropertiesCount();
	}

	/**
	* Updates the asset tag property in the database. Also notifies the appropriate model listeners.
	*
	* @param assetTagProperty the asset tag property to update
	* @return the asset tag property that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.asset.model.AssetTagProperty updateAssetTagProperty(
		com.liferay.portlet.asset.model.AssetTagProperty assetTagProperty)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAssetTagProperty(assetTagProperty);
	}

	/**
	* Updates the asset tag property in the database. Also notifies the appropriate model listeners.
	*
	* @param assetTagProperty the asset tag property to update
	* @param merge whether to merge the asset tag property with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the asset tag property that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portlet.asset.model.AssetTagProperty updateAssetTagProperty(
		com.liferay.portlet.asset.model.AssetTagProperty assetTagProperty,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateAssetTagProperty(assetTagProperty, merge);
	}

	public static com.liferay.portlet.asset.model.AssetTagProperty addTagProperty(
		long userId, long tagId, java.lang.String key, java.lang.String value)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addTagProperty(userId, tagId, key, value);
	}

	public static void deleteTagProperties(long tagId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTagProperties(tagId);
	}

	public static void deleteTagProperty(
		com.liferay.portlet.asset.model.AssetTagProperty tagProperty)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTagProperty(tagProperty);
	}

	public static void deleteTagProperty(long tagPropertyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTagProperty(tagPropertyId);
	}

	public static java.util.List<com.liferay.portlet.asset.model.AssetTagProperty> getTagProperties()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTagProperties();
	}

	public static java.util.List<com.liferay.portlet.asset.model.AssetTagProperty> getTagProperties(
		long tagId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTagProperties(tagId);
	}

	public static com.liferay.portlet.asset.model.AssetTagProperty getTagProperty(
		long tagPropertyId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTagProperty(tagPropertyId);
	}

	public static com.liferay.portlet.asset.model.AssetTagProperty getTagProperty(
		long tagId, java.lang.String key)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTagProperty(tagId, key);
	}

	public static java.lang.String[] getTagPropertyKeys(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTagPropertyKeys(groupId);
	}

	public static java.util.List<com.liferay.portlet.asset.model.AssetTagProperty> getTagPropertyValues(
		long groupId, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTagPropertyValues(groupId, key);
	}

	public static com.liferay.portlet.asset.model.AssetTagProperty updateTagProperty(
		long tagPropertyId, java.lang.String key, java.lang.String value)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTagProperty(tagPropertyId, key, value);
	}

	public static AssetTagPropertyLocalService getService() {
		if (_service == null) {
			_service = (AssetTagPropertyLocalService)PortalBeanLocatorUtil.locate(AssetTagPropertyLocalService.class.getName());
		}

		return _service;
	}

	public void setService(AssetTagPropertyLocalService service) {
		_service = service;
	}

	private static AssetTagPropertyLocalService _service;
}