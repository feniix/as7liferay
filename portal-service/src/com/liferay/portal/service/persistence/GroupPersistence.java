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

import com.liferay.portal.model.Group;

/**
 * The persistence interface for the group service.
 *
 * <p>
 * Never modify or reference this interface directly. Always use {@link GroupUtil} to access the group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GroupPersistenceImpl
 * @see GroupUtil
 * @generated
 */
public interface GroupPersistence extends BasePersistence<Group> {
	/**
	* Caches the group in the entity cache if it is enabled.
	*
	* @param group the group to cache
	*/
	public void cacheResult(com.liferay.portal.model.Group group);

	/**
	* Caches the groups in the entity cache if it is enabled.
	*
	* @param groups the groups to cache
	*/
	public void cacheResult(
		java.util.List<com.liferay.portal.model.Group> groups);

	/**
	* Creates a new group with the primary key. Does not add the group to the database.
	*
	* @param groupId the primary key for the new group
	* @return the new group
	*/
	public com.liferay.portal.model.Group create(long groupId);

	/**
	* Removes the group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param groupId the primary key of the group to remove
	* @return the group that was removed
	* @throws com.liferay.portal.NoSuchGroupException if a group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group remove(long groupId)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.model.Group updateImpl(
		com.liferay.portal.model.Group group, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the group with the primary key or throws a {@link com.liferay.portal.NoSuchGroupException} if it could not be found.
	*
	* @param groupId the primary key of the group to find
	* @return the group
	* @throws com.liferay.portal.NoSuchGroupException if a group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group findByPrimaryKey(long groupId)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param groupId the primary key of the group to find
	* @return the group, or <code>null</code> if a group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group fetchByPrimaryKey(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the groups where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the matching groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Group> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the groups where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @return the range of matching groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Group> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the groups where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Group> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first group in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching group
	* @throws com.liferay.portal.NoSuchGroupException if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last group in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching group
	* @throws com.liferay.portal.NoSuchGroupException if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group findByCompanyId_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the groups before and after the current group in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the primary key of the current group
	* @param companyId the company id to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next group
	* @throws com.liferay.portal.NoSuchGroupException if a group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group[] findByCompanyId_PrevAndNext(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the group where liveGroupId = &#63; or throws a {@link com.liferay.portal.NoSuchGroupException} if it could not be found.
	*
	* @param liveGroupId the live group id to search with
	* @return the matching group
	* @throws com.liferay.portal.NoSuchGroupException if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group findByLiveGroupId(long liveGroupId)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the group where liveGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param liveGroupId the live group id to search with
	* @return the matching group, or <code>null</code> if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group fetchByLiveGroupId(long liveGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the group where liveGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param liveGroupId the live group id to search with
	* @return the matching group, or <code>null</code> if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group fetchByLiveGroupId(long liveGroupId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the group where companyId = &#63; and name = &#63; or throws a {@link com.liferay.portal.NoSuchGroupException} if it could not be found.
	*
	* @param companyId the company id to search with
	* @param name the name to search with
	* @return the matching group
	* @throws com.liferay.portal.NoSuchGroupException if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group findByC_N(long companyId,
		java.lang.String name)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the group where companyId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company id to search with
	* @param name the name to search with
	* @return the matching group, or <code>null</code> if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group fetchByC_N(long companyId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the group where companyId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company id to search with
	* @param name the name to search with
	* @return the matching group, or <code>null</code> if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group fetchByC_N(long companyId,
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the group where companyId = &#63; and friendlyURL = &#63; or throws a {@link com.liferay.portal.NoSuchGroupException} if it could not be found.
	*
	* @param companyId the company id to search with
	* @param friendlyURL the friendly u r l to search with
	* @return the matching group
	* @throws com.liferay.portal.NoSuchGroupException if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group findByC_F(long companyId,
		java.lang.String friendlyURL)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the group where companyId = &#63; and friendlyURL = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company id to search with
	* @param friendlyURL the friendly u r l to search with
	* @return the matching group, or <code>null</code> if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group fetchByC_F(long companyId,
		java.lang.String friendlyURL)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the group where companyId = &#63; and friendlyURL = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company id to search with
	* @param friendlyURL the friendly u r l to search with
	* @return the matching group, or <code>null</code> if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group fetchByC_F(long companyId,
		java.lang.String friendlyURL, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the groups where type = &#63; and active = &#63;.
	*
	* @param type the type to search with
	* @param active the active to search with
	* @return the matching groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Group> findByT_A(int type,
		boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the groups where type = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param type the type to search with
	* @param active the active to search with
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @return the range of matching groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Group> findByT_A(int type,
		boolean active, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the groups where type = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param type the type to search with
	* @param active the active to search with
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Group> findByT_A(int type,
		boolean active, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the first group in the ordered set where type = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param type the type to search with
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the first matching group
	* @throws com.liferay.portal.NoSuchGroupException if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group findByT_A_First(int type,
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the last group in the ordered set where type = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param type the type to search with
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the last matching group
	* @throws com.liferay.portal.NoSuchGroupException if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group findByT_A_Last(int type,
		boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the groups before and after the current group in the ordered set where type = &#63; and active = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the primary key of the current group
	* @param type the type to search with
	* @param active the active to search with
	* @param orderByComparator the comparator to order the set by
	* @return the previous, current, and next group
	* @throws com.liferay.portal.NoSuchGroupException if a group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group[] findByT_A_PrevAndNext(
		long groupId, int type, boolean active,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the group where companyId = &#63; and classNameId = &#63; and classPK = &#63; or throws a {@link com.liferay.portal.NoSuchGroupException} if it could not be found.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the matching group
	* @throws com.liferay.portal.NoSuchGroupException if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group findByC_C_C(long companyId,
		long classNameId, long classPK)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the group where companyId = &#63; and classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the matching group, or <code>null</code> if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group fetchByC_C_C(long companyId,
		long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the group where companyId = &#63; and classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the matching group, or <code>null</code> if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group fetchByC_C_C(long companyId,
		long classNameId, long classPK, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the group where companyId = &#63; and liveGroupId = &#63; and name = &#63; or throws a {@link com.liferay.portal.NoSuchGroupException} if it could not be found.
	*
	* @param companyId the company id to search with
	* @param liveGroupId the live group id to search with
	* @param name the name to search with
	* @return the matching group
	* @throws com.liferay.portal.NoSuchGroupException if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group findByC_L_N(long companyId,
		long liveGroupId, java.lang.String name)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the group where companyId = &#63; and liveGroupId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company id to search with
	* @param liveGroupId the live group id to search with
	* @param name the name to search with
	* @return the matching group, or <code>null</code> if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group fetchByC_L_N(long companyId,
		long liveGroupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the group where companyId = &#63; and liveGroupId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company id to search with
	* @param liveGroupId the live group id to search with
	* @param name the name to search with
	* @return the matching group, or <code>null</code> if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group fetchByC_L_N(long companyId,
		long liveGroupId, java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the group where companyId = &#63; and classNameId = &#63; and liveGroupId = &#63; and name = &#63; or throws a {@link com.liferay.portal.NoSuchGroupException} if it could not be found.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param liveGroupId the live group id to search with
	* @param name the name to search with
	* @return the matching group
	* @throws com.liferay.portal.NoSuchGroupException if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group findByC_C_L_N(long companyId,
		long classNameId, long liveGroupId, java.lang.String name)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the group where companyId = &#63; and classNameId = &#63; and liveGroupId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param liveGroupId the live group id to search with
	* @param name the name to search with
	* @return the matching group, or <code>null</code> if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group fetchByC_C_L_N(long companyId,
		long classNameId, long liveGroupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds the group where companyId = &#63; and classNameId = &#63; and liveGroupId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param liveGroupId the live group id to search with
	* @param name the name to search with
	* @return the matching group, or <code>null</code> if a matching group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.Group fetchByC_C_L_N(long companyId,
		long classNameId, long liveGroupId, java.lang.String name,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds all the groups.
	*
	* @return the groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Group> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds a range of all the groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @return the range of groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Group> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Finds an ordered range of all the groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Group> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the groups where companyId = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the group where liveGroupId = &#63; from the database.
	*
	* @param liveGroupId the live group id to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLiveGroupId(long liveGroupId)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the group where companyId = &#63; and name = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param name the name to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_N(long companyId, java.lang.String name)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the group where companyId = &#63; and friendlyURL = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param friendlyURL the friendly u r l to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_F(long companyId, java.lang.String friendlyURL)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the groups where type = &#63; and active = &#63; from the database.
	*
	* @param type the type to search with
	* @param active the active to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByT_A(int type, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the group where companyId = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_C_C(long companyId, long classNameId, long classPK)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the group where companyId = &#63; and liveGroupId = &#63; and name = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param liveGroupId the live group id to search with
	* @param name the name to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_L_N(long companyId, long liveGroupId,
		java.lang.String name)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the group where companyId = &#63; and classNameId = &#63; and liveGroupId = &#63; and name = &#63; from the database.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param liveGroupId the live group id to search with
	* @param name the name to search with
	* @throws SystemException if a system exception occurred
	*/
	public void removeByC_C_L_N(long companyId, long classNameId,
		long liveGroupId, java.lang.String name)
		throws com.liferay.portal.NoSuchGroupException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the groups from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the groups where companyId = &#63;.
	*
	* @param companyId the company id to search with
	* @return the number of matching groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the groups where liveGroupId = &#63;.
	*
	* @param liveGroupId the live group id to search with
	* @return the number of matching groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByLiveGroupId(long liveGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the groups where companyId = &#63; and name = &#63;.
	*
	* @param companyId the company id to search with
	* @param name the name to search with
	* @return the number of matching groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_N(long companyId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the groups where companyId = &#63; and friendlyURL = &#63;.
	*
	* @param companyId the company id to search with
	* @param friendlyURL the friendly u r l to search with
	* @return the number of matching groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_F(long companyId, java.lang.String friendlyURL)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the groups where type = &#63; and active = &#63;.
	*
	* @param type the type to search with
	* @param active the active to search with
	* @return the number of matching groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByT_A(int type, boolean active)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the groups where companyId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param classPK the class p k to search with
	* @return the number of matching groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_C_C(long companyId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the groups where companyId = &#63; and liveGroupId = &#63; and name = &#63;.
	*
	* @param companyId the company id to search with
	* @param liveGroupId the live group id to search with
	* @param name the name to search with
	* @return the number of matching groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_L_N(long companyId, long liveGroupId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the groups where companyId = &#63; and classNameId = &#63; and liveGroupId = &#63; and name = &#63;.
	*
	* @param companyId the company id to search with
	* @param classNameId the class name id to search with
	* @param liveGroupId the live group id to search with
	* @param name the name to search with
	* @return the number of matching groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByC_C_L_N(long companyId, long classNameId,
		long liveGroupId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Counts all the groups.
	*
	* @return the number of groups
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets all the organizations associated with the group.
	*
	* @param pk the primary key of the group to get the associated organizations for
	* @return the organizations associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Organization> getOrganizations(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a range of all the organizations associated with the group.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the group to get the associated organizations for
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @return the range of organizations associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Organization> getOrganizations(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets an ordered range of all the organizations associated with the group.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the group to get the associated organizations for
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of organizations associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Organization> getOrganizations(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of organizations associated with the group.
	*
	* @param pk the primary key of the group to get the number of associated organizations for
	* @return the number of organizations associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public int getOrganizationsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines whether the organization is associated with the group.
	*
	* @param pk the primary key of the group
	* @param organizationPK the primary key of the organization
	* @return whether the organization is associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsOrganization(long pk, long organizationPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines whether the group has any organizations associated with it.
	*
	* @param pk the primary key of the group to check for associations with organizations
	* @return whether the group has any organizations associated with it
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsOrganizations(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the group and the organization. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param organizationPK the primary key of the organization
	* @throws SystemException if a system exception occurred
	*/
	public void addOrganization(long pk, long organizationPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the group and the organization. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param organization the organization
	* @throws SystemException if a system exception occurred
	*/
	public void addOrganization(long pk,
		com.liferay.portal.model.Organization organization)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the group and the organizations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param organizationPKs the primary keys of the organizations
	* @throws SystemException if a system exception occurred
	*/
	public void addOrganizations(long pk, long[] organizationPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the group and the organizations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param organizations the organizations
	* @throws SystemException if a system exception occurred
	*/
	public void addOrganizations(long pk,
		java.util.List<com.liferay.portal.model.Organization> organizations)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the group and its organizations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to clear the associated organizations from
	* @throws SystemException if a system exception occurred
	*/
	public void clearOrganizations(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the group and the organization. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param organizationPK the primary key of the organization
	* @throws SystemException if a system exception occurred
	*/
	public void removeOrganization(long pk, long organizationPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the group and the organization. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param organization the organization
	* @throws SystemException if a system exception occurred
	*/
	public void removeOrganization(long pk,
		com.liferay.portal.model.Organization organization)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the group and the organizations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param organizationPKs the primary keys of the organizations
	* @throws SystemException if a system exception occurred
	*/
	public void removeOrganizations(long pk, long[] organizationPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the group and the organizations. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param organizations the organizations
	* @throws SystemException if a system exception occurred
	*/
	public void removeOrganizations(long pk,
		java.util.List<com.liferay.portal.model.Organization> organizations)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the organizations associated with the group, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to set the associations for
	* @param organizationPKs the primary keys of the organizations to be associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public void setOrganizations(long pk, long[] organizationPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the organizations associated with the group, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to set the associations for
	* @param organizations the organizations to be associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public void setOrganizations(long pk,
		java.util.List<com.liferay.portal.model.Organization> organizations)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets all the permissions associated with the group.
	*
	* @param pk the primary key of the group to get the associated permissions for
	* @return the permissions associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Permission> getPermissions(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a range of all the permissions associated with the group.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the group to get the associated permissions for
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @return the range of permissions associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Permission> getPermissions(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets an ordered range of all the permissions associated with the group.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the group to get the associated permissions for
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of permissions associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Permission> getPermissions(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of permissions associated with the group.
	*
	* @param pk the primary key of the group to get the number of associated permissions for
	* @return the number of permissions associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public int getPermissionsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines whether the permission is associated with the group.
	*
	* @param pk the primary key of the group
	* @param permissionPK the primary key of the permission
	* @return whether the permission is associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsPermission(long pk, long permissionPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines whether the group has any permissions associated with it.
	*
	* @param pk the primary key of the group to check for associations with permissions
	* @return whether the group has any permissions associated with it
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsPermissions(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the group and the permission. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param permissionPK the primary key of the permission
	* @throws SystemException if a system exception occurred
	*/
	public void addPermission(long pk, long permissionPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the group and the permission. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param permission the permission
	* @throws SystemException if a system exception occurred
	*/
	public void addPermission(long pk,
		com.liferay.portal.model.Permission permission)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the group and the permissions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param permissionPKs the primary keys of the permissions
	* @throws SystemException if a system exception occurred
	*/
	public void addPermissions(long pk, long[] permissionPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the group and the permissions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param permissions the permissions
	* @throws SystemException if a system exception occurred
	*/
	public void addPermissions(long pk,
		java.util.List<com.liferay.portal.model.Permission> permissions)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the group and its permissions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to clear the associated permissions from
	* @throws SystemException if a system exception occurred
	*/
	public void clearPermissions(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the group and the permission. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param permissionPK the primary key of the permission
	* @throws SystemException if a system exception occurred
	*/
	public void removePermission(long pk, long permissionPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the group and the permission. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param permission the permission
	* @throws SystemException if a system exception occurred
	*/
	public void removePermission(long pk,
		com.liferay.portal.model.Permission permission)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the group and the permissions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param permissionPKs the primary keys of the permissions
	* @throws SystemException if a system exception occurred
	*/
	public void removePermissions(long pk, long[] permissionPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the group and the permissions. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param permissions the permissions
	* @throws SystemException if a system exception occurred
	*/
	public void removePermissions(long pk,
		java.util.List<com.liferay.portal.model.Permission> permissions)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the permissions associated with the group, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to set the associations for
	* @param permissionPKs the primary keys of the permissions to be associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public void setPermissions(long pk, long[] permissionPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the permissions associated with the group, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to set the associations for
	* @param permissions the permissions to be associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public void setPermissions(long pk,
		java.util.List<com.liferay.portal.model.Permission> permissions)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets all the roles associated with the group.
	*
	* @param pk the primary key of the group to get the associated roles for
	* @return the roles associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Role> getRoles(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a range of all the roles associated with the group.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the group to get the associated roles for
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @return the range of roles associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Role> getRoles(long pk,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets an ordered range of all the roles associated with the group.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the group to get the associated roles for
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of roles associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.Role> getRoles(long pk,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of roles associated with the group.
	*
	* @param pk the primary key of the group to get the number of associated roles for
	* @return the number of roles associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public int getRolesSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines whether the role is associated with the group.
	*
	* @param pk the primary key of the group
	* @param rolePK the primary key of the role
	* @return whether the role is associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsRole(long pk, long rolePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines whether the group has any roles associated with it.
	*
	* @param pk the primary key of the group to check for associations with roles
	* @return whether the group has any roles associated with it
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsRoles(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the group and the role. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param rolePK the primary key of the role
	* @throws SystemException if a system exception occurred
	*/
	public void addRole(long pk, long rolePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the group and the role. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param role the role
	* @throws SystemException if a system exception occurred
	*/
	public void addRole(long pk, com.liferay.portal.model.Role role)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the group and the roles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param rolePKs the primary keys of the roles
	* @throws SystemException if a system exception occurred
	*/
	public void addRoles(long pk, long[] rolePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the group and the roles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param roles the roles
	* @throws SystemException if a system exception occurred
	*/
	public void addRoles(long pk,
		java.util.List<com.liferay.portal.model.Role> roles)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the group and its roles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to clear the associated roles from
	* @throws SystemException if a system exception occurred
	*/
	public void clearRoles(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the group and the role. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param rolePK the primary key of the role
	* @throws SystemException if a system exception occurred
	*/
	public void removeRole(long pk, long rolePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the group and the role. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param role the role
	* @throws SystemException if a system exception occurred
	*/
	public void removeRole(long pk, com.liferay.portal.model.Role role)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the group and the roles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param rolePKs the primary keys of the roles
	* @throws SystemException if a system exception occurred
	*/
	public void removeRoles(long pk, long[] rolePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the group and the roles. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param roles the roles
	* @throws SystemException if a system exception occurred
	*/
	public void removeRoles(long pk,
		java.util.List<com.liferay.portal.model.Role> roles)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the roles associated with the group, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to set the associations for
	* @param rolePKs the primary keys of the roles to be associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public void setRoles(long pk, long[] rolePKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the roles associated with the group, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to set the associations for
	* @param roles the roles to be associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public void setRoles(long pk,
		java.util.List<com.liferay.portal.model.Role> roles)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets all the user groups associated with the group.
	*
	* @param pk the primary key of the group to get the associated user groups for
	* @return the user groups associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.UserGroup> getUserGroups(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a range of all the user groups associated with the group.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the group to get the associated user groups for
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @return the range of user groups associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.UserGroup> getUserGroups(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets an ordered range of all the user groups associated with the group.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the group to get the associated user groups for
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of user groups associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.UserGroup> getUserGroups(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of user groups associated with the group.
	*
	* @param pk the primary key of the group to get the number of associated user groups for
	* @return the number of user groups associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public int getUserGroupsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines whether the user group is associated with the group.
	*
	* @param pk the primary key of the group
	* @param userGroupPK the primary key of the user group
	* @return whether the user group is associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsUserGroup(long pk, long userGroupPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines whether the group has any user groups associated with it.
	*
	* @param pk the primary key of the group to check for associations with user groups
	* @return whether the group has any user groups associated with it
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsUserGroups(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the group and the user group. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param userGroupPK the primary key of the user group
	* @throws SystemException if a system exception occurred
	*/
	public void addUserGroup(long pk, long userGroupPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the group and the user group. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param userGroup the user group
	* @throws SystemException if a system exception occurred
	*/
	public void addUserGroup(long pk,
		com.liferay.portal.model.UserGroup userGroup)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the group and the user groups. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param userGroupPKs the primary keys of the user groups
	* @throws SystemException if a system exception occurred
	*/
	public void addUserGroups(long pk, long[] userGroupPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the group and the user groups. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param userGroups the user groups
	* @throws SystemException if a system exception occurred
	*/
	public void addUserGroups(long pk,
		java.util.List<com.liferay.portal.model.UserGroup> userGroups)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the group and its user groups. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to clear the associated user groups from
	* @throws SystemException if a system exception occurred
	*/
	public void clearUserGroups(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the group and the user group. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param userGroupPK the primary key of the user group
	* @throws SystemException if a system exception occurred
	*/
	public void removeUserGroup(long pk, long userGroupPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the group and the user group. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param userGroup the user group
	* @throws SystemException if a system exception occurred
	*/
	public void removeUserGroup(long pk,
		com.liferay.portal.model.UserGroup userGroup)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the group and the user groups. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param userGroupPKs the primary keys of the user groups
	* @throws SystemException if a system exception occurred
	*/
	public void removeUserGroups(long pk, long[] userGroupPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the group and the user groups. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param userGroups the user groups
	* @throws SystemException if a system exception occurred
	*/
	public void removeUserGroups(long pk,
		java.util.List<com.liferay.portal.model.UserGroup> userGroups)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the user groups associated with the group, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to set the associations for
	* @param userGroupPKs the primary keys of the user groups to be associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public void setUserGroups(long pk, long[] userGroupPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the user groups associated with the group, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to set the associations for
	* @param userGroups the user groups to be associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public void setUserGroups(long pk,
		java.util.List<com.liferay.portal.model.UserGroup> userGroups)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets all the users associated with the group.
	*
	* @param pk the primary key of the group to get the associated users for
	* @return the users associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.User> getUsers(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets a range of all the users associated with the group.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the group to get the associated users for
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @return the range of users associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.User> getUsers(long pk,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets an ordered range of all the users associated with the group.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the group to get the associated users for
	* @param start the lower bound of the range of groups to return
	* @param end the upper bound of the range of groups to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of users associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.User> getUsers(long pk,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Gets the number of users associated with the group.
	*
	* @param pk the primary key of the group to get the number of associated users for
	* @return the number of users associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public int getUsersSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines whether the user is associated with the group.
	*
	* @param pk the primary key of the group
	* @param userPK the primary key of the user
	* @return whether the user is associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsUser(long pk, long userPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Determines whether the group has any users associated with it.
	*
	* @param pk the primary key of the group to check for associations with users
	* @return whether the group has any users associated with it
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsUsers(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the group and the user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param userPK the primary key of the user
	* @throws SystemException if a system exception occurred
	*/
	public void addUser(long pk, long userPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the group and the user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param user the user
	* @throws SystemException if a system exception occurred
	*/
	public void addUser(long pk, com.liferay.portal.model.User user)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the group and the users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param userPKs the primary keys of the users
	* @throws SystemException if a system exception occurred
	*/
	public void addUsers(long pk, long[] userPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Adds an association between the group and the users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param users the users
	* @throws SystemException if a system exception occurred
	*/
	public void addUsers(long pk,
		java.util.List<com.liferay.portal.model.User> users)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Clears all associations between the group and its users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to clear the associated users from
	* @throws SystemException if a system exception occurred
	*/
	public void clearUsers(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the group and the user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param userPK the primary key of the user
	* @throws SystemException if a system exception occurred
	*/
	public void removeUser(long pk, long userPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the group and the user. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param user the user
	* @throws SystemException if a system exception occurred
	*/
	public void removeUser(long pk, com.liferay.portal.model.User user)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the group and the users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param userPKs the primary keys of the users
	* @throws SystemException if a system exception occurred
	*/
	public void removeUsers(long pk, long[] userPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the association between the group and the users. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group
	* @param users the users
	* @throws SystemException if a system exception occurred
	*/
	public void removeUsers(long pk,
		java.util.List<com.liferay.portal.model.User> users)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the users associated with the group, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to set the associations for
	* @param userPKs the primary keys of the users to be associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public void setUsers(long pk, long[] userPKs)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Sets the users associated with the group, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the group to set the associations for
	* @param users the users to be associated with the group
	* @throws SystemException if a system exception occurred
	*/
	public void setUsers(long pk,
		java.util.List<com.liferay.portal.model.User> users)
		throws com.liferay.portal.kernel.exception.SystemException;
}