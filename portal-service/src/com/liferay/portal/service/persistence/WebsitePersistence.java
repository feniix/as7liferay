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

package com.liferay.portal.service.persistence;

import com.liferay.portal.model.Website;

/**
 * The persistence interface for the website service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link WebsiteUtil} to access the website persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WebsitePersistenceImpl
 * @see WebsiteUtil
 * @generated
 */
public interface WebsitePersistence extends BasePersistence<Website> {
	/**
	* Caches the website in the entity cache if it is enabled.
	*
	* @param website the website to cache
	*/
	public void cacheResult(com.liferay.portal.model.Website website);

	/**
	* Caches the websites in the entity cache if it is enabled.
	*
	* @param websites the websites to cache
	*/
	public void cacheResult(
		java.util.List<com.liferay.portal.model.Website> websites);

	/**
	* Creates a new website with the primary key. Does not add the website to the database.
	*
	* @param websiteId the primary key for the new website
	* @return the new website
	*/
	public com.liferay.portal.model.Website create(long websiteId);

	/**
	* Removes the website with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param websiteId the primary key of the website to remove
	* @return the website that was removed
	* @throws com.liferay.portal.NoSuchWebsiteException if a website with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Website remove(long websiteId)
		throws com.liferay.portal.NoSuchWebsiteException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.Website updateImpl(
		com.liferay.portal.model.Website website, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the website with the primary key or throws a {@link com.liferay.portal.NoSuchWebsiteException} if it could not be found.
	*
	* @param websiteId the primary key of the website to find
	* @return the website
	* @throws com.liferay.portal.NoSuchWebsiteException if a website with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Website findByPrimaryKey(long websiteId)
		throws com.liferay.portal.NoSuchWebsiteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the website with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param websiteId the primary key of the website to find
	* @return the website, or <code>null</code> if a website with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Website fetchByPrimaryKey(long websiteId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the websites where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the matching websites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Website> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the websites where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of websites to return
	* @param end the upper bound of the range of websites to return (not inclusive)
	* @return the range of matching websites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Website> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the websites where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of websites to return
	* @param end the upper bound of the range of websites to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching websites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Website> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first website in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching website
	* @throws com.liferay.portal.NoSuchWebsiteException if a matching website could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Website findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchWebsiteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last website in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching website
	* @throws com.liferay.portal.NoSuchWebsiteException if a matching website could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Website findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchWebsiteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the websites before and after the current website in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param websiteId the primary key of the current website
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next website
	* @throws com.liferay.portal.NoSuchWebsiteException if a website with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Website[] findByCompanyId_PrevAndNext(
		long websiteId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchWebsiteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the websites where userId = &#63;.
	*
	* @param userId the user id to search with
	* @return the matching websites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Website> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the websites where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param start the lower bound of the range of websites to return
	* @param end the upper bound of the range of websites to return (not inclusive)
	* @return the range of matching websites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Website> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the websites where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param start the lower bound of the range of websites to return
	* @param end the upper bound of the range of websites to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching websites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Website> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first website in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching website
	* @throws com.liferay.portal.NoSuchWebsiteException if a matching website could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Website findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchWebsiteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last website in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching website
	* @throws com.liferay.portal.NoSuchWebsiteException if a matching website could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Website findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchWebsiteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the websites before and after the current website in the ordered set where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param websiteId the primary key of the current website
	* @param userId the user id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next website
	* @throws com.liferay.portal.NoSuchWebsiteException if a website with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Website[] findByUserId_PrevAndNext(
		long websiteId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchWebsiteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the websites where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @return the matching websites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Website> findByC_C(
		long companyId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the websites where companyId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param start the lower bound of the range of websites to return
	* @param end the upper bound of the range of websites to return (not inclusive)
	* @return the range of matching websites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Website> findByC_C(
		long companyId, long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the websites where companyId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param start the lower bound of the range of websites to return
	* @param end the upper bound of the range of websites to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching websites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Website> findByC_C(
		long companyId, long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first website in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching website
	* @throws com.liferay.portal.NoSuchWebsiteException if a matching website could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Website findByC_C_First(long companyId,
		long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchWebsiteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last website in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching website
	* @throws com.liferay.portal.NoSuchWebsiteException if a matching website could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Website findByC_C_Last(long companyId,
		long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchWebsiteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the websites before and after the current website in the ordered set where companyId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param websiteId the primary key of the current website
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next website
	* @throws com.liferay.portal.NoSuchWebsiteException if a website with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Website[] findByC_C_PrevAndNext(
		long websiteId, long companyId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchWebsiteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the websites where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the matching websites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Website> findByC_C_C(
		long companyId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the websites where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param start the lower bound of the range of websites to return
	* @param end the upper bound of the range of websites to return (not inclusive)
	* @return the range of matching websites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Website> findByC_C_C(
		long companyId, long classNameId, long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the websites where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param start the lower bound of the range of websites to return
	* @param end the upper bound of the range of websites to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching websites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Website> findByC_C_C(
		long companyId, long classNameId, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first website in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching website
	* @throws com.liferay.portal.NoSuchWebsiteException if a matching website could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Website findByC_C_C_First(long companyId,
		long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchWebsiteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last website in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching website
	* @throws com.liferay.portal.NoSuchWebsiteException if a matching website could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Website findByC_C_C_Last(long companyId,
		long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchWebsiteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the websites before and after the current website in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param websiteId the primary key of the current website
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next website
	* @throws com.liferay.portal.NoSuchWebsiteException if a website with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Website[] findByC_C_C_PrevAndNext(
		long websiteId, long companyId, long classNameId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchWebsiteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the websites where companyId = &#63; and classNameId = &#63; and classPK = &#63; and primary = &#63;.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param primary the primary to search with
	* @return the matching websites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Website> findByC_C_C_P(
		long companyId, long classNameId, long classPK, boolean primary)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the websites where companyId = &#63; and classNameId = &#63; and classPK = &#63; and primary = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param primary the primary to search with
	* @param start the lower bound of the range of websites to return
	* @param end the upper bound of the range of websites to return (not inclusive)
	* @return the range of matching websites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Website> findByC_C_C_P(
		long companyId, long classNameId, long classPK, boolean primary,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the websites where companyId = &#63; and classNameId = &#63; and classPK = &#63; and primary = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param primary the primary to search with
	* @param start the lower bound of the range of websites to return
	* @param end the upper bound of the range of websites to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching websites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Website> findByC_C_C_P(
		long companyId, long classNameId, long classPK, boolean primary,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first website in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and primary = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param primary the primary to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching website
	* @throws com.liferay.portal.NoSuchWebsiteException if a matching website could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Website findByC_C_C_P_First(
		long companyId, long classNameId, long classPK, boolean primary,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchWebsiteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last website in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and primary = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param primary the primary to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching website
	* @throws com.liferay.portal.NoSuchWebsiteException if a matching website could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Website findByC_C_C_P_Last(long companyId,
		long classNameId, long classPK, boolean primary,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchWebsiteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the websites before and after the current website in the ordered set where companyId = &#63; and classNameId = &#63; and classPK = &#63; and primary = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param websiteId the primary key of the current website
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param primary the primary to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next website
	* @throws com.liferay.portal.NoSuchWebsiteException if a website with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Website[] findByC_C_C_P_PrevAndNext(
		long websiteId, long companyId, long classNameId, long classPK,
		boolean primary,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchWebsiteException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the websites.
	*
	* @return the websites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Website> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the websites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of websites to return
	* @param end the upper bound of the range of websites to return (not inclusive)
	* @return the range of websites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Website> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the websites.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of websites to return
	* @param end the upper bound of the range of websites to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of websites
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Website> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the websites where companyId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the websites where userId = &#63; from the database.
	*
	* @param userId the user id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the websites where companyId = &#63; and classNameId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_C(long companyId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the websites where companyId = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_C_C(long companyId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the websites where companyId = &#63; and classNameId = &#63; and classPK = &#63; and primary = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param primary the primary to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_C_C_P(long companyId, long classNameId, long classPK,
		boolean primary)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the websites from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the websites where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the number of matching websites
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the websites where userId = &#63;.
	*
	* @param userId the user id to search with
	* @return the number of matching websites
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the websites where companyId = &#63; and classNameId = &#63;.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @return the number of matching websites
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_C(long companyId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the websites where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the number of matching websites
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_C_C(long companyId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the websites where companyId = &#63; and classNameId = &#63; and classPK = &#63; and primary = &#63;.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @param primary the primary to search with
	* @return the number of matching websites
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_C_C_P(long companyId, long classNameId, long classPK,
		boolean primary)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the websites.
	*
	* @return the number of websites
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}