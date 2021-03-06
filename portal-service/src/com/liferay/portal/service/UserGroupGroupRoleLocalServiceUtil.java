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

package com.liferay.portal.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * The utility for the user group group role local service. This utility wraps {@link com.liferay.portal.service.impl.UserGroupGroupRoleLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.liferay.portal.service.impl.UserGroupGroupRoleLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserGroupGroupRoleLocalService
 * @see com.liferay.portal.service.base.UserGroupGroupRoleLocalServiceBaseImpl
 * @see com.liferay.portal.service.impl.UserGroupGroupRoleLocalServiceImpl
 * @generated
 */
public class UserGroupGroupRoleLocalServiceUtil {
	/**
	* Adds the user group group role to the database. Also notifies the appropriate model listeners.
	*
	* @param userGroupGroupRole the user group group role to add
	* @return the user group group role that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserGroupGroupRole addUserGroupGroupRole(
		com.liferay.portal.model.UserGroupGroupRole userGroupGroupRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addUserGroupGroupRole(userGroupGroupRole);
	}

	/**
	* Creates a new user group group role with the primary key. Does not add the user group group role to the database.
	*
	* @param userGroupGroupRolePK the primary key for the new user group group role
	* @return the new user group group role
	*/
	public static com.liferay.portal.model.UserGroupGroupRole createUserGroupGroupRole(
		com.liferay.portal.service.persistence.UserGroupGroupRolePK userGroupGroupRolePK) {
		return getService().createUserGroupGroupRole(userGroupGroupRolePK);
	}

	/**
	* Deletes the user group group role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userGroupGroupRolePK the primary key of the user group group role to delete
	* @throws PortalException if a user group group role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteUserGroupGroupRole(
		com.liferay.portal.service.persistence.UserGroupGroupRolePK userGroupGroupRolePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserGroupGroupRole(userGroupGroupRolePK);
	}

	/**
	* Deletes the user group group role from the database. Also notifies the appropriate model listeners.
	*
	* @param userGroupGroupRole the user group group role to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteUserGroupGroupRole(
		com.liferay.portal.model.UserGroupGroupRole userGroupGroupRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserGroupGroupRole(userGroupGroupRole);
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
	* Gets the user group group role with the primary key.
	*
	* @param userGroupGroupRolePK the primary key of the user group group role to get
	* @return the user group group role
	* @throws PortalException if a user group group role with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserGroupGroupRole getUserGroupGroupRole(
		com.liferay.portal.service.persistence.UserGroupGroupRolePK userGroupGroupRolePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserGroupGroupRole(userGroupGroupRolePK);
	}

	/**
	* Gets a range of all the user group group roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of user group group roles to return
	* @param end the upper bound of the range of user group group roles to return (not inclusive)
	* @return the range of user group group roles
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.UserGroupGroupRole> getUserGroupGroupRoles(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserGroupGroupRoles(start, end);
	}

	/**
	* Gets the number of user group group roles.
	*
	* @return the number of user group group roles
	* @throws SystemException if a system exception occurred
	*/
	public static int getUserGroupGroupRolesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserGroupGroupRolesCount();
	}

	/**
	* Updates the user group group role in the database. Also notifies the appropriate model listeners.
	*
	* @param userGroupGroupRole the user group group role to update
	* @return the user group group role that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserGroupGroupRole updateUserGroupGroupRole(
		com.liferay.portal.model.UserGroupGroupRole userGroupGroupRole)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserGroupGroupRole(userGroupGroupRole);
	}

	/**
	* Updates the user group group role in the database. Also notifies the appropriate model listeners.
	*
	* @param userGroupGroupRole the user group group role to update
	* @param merge whether to merge the user group group role with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the user group group role that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.UserGroupGroupRole updateUserGroupGroupRole(
		com.liferay.portal.model.UserGroupGroupRole userGroupGroupRole,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateUserGroupGroupRole(userGroupGroupRole, merge);
	}

	public static void addUserGroupGroupRoles(long userGroupId, long groupId,
		long[] roleIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().addUserGroupGroupRoles(userGroupId, groupId, roleIds);
	}

	public static void addUserGroupGroupRoles(long[] userGroupIds,
		long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().addUserGroupGroupRoles(userGroupIds, groupId, roleId);
	}

	public static void deleteUserGroupGroupRoles(long userGroupId,
		long groupId, long[] roleIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserGroupGroupRoles(userGroupId, groupId, roleIds);
	}

	public static void deleteUserGroupGroupRoles(long userGroupId,
		long[] groupIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserGroupGroupRoles(userGroupId, groupIds);
	}

	public static void deleteUserGroupGroupRoles(long[] userGroupIds,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserGroupGroupRoles(userGroupIds, groupId);
	}

	public static void deleteUserGroupGroupRoles(long[] userGroupIds,
		long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserGroupGroupRoles(userGroupIds, groupId, roleId);
	}

	public static void deleteUserGroupGroupRolesByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserGroupGroupRolesByGroupId(groupId);
	}

	public static void deleteUserGroupGroupRolesByRoleId(long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserGroupGroupRolesByRoleId(roleId);
	}

	public static void deleteUserGroupGroupRolesByUserGroupId(long userGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserGroupGroupRolesByUserGroupId(userGroupId);
	}

	public static java.util.List<com.liferay.portal.model.UserGroupGroupRole> getUserGroupGroupRoles(
		long userGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserGroupGroupRoles(userGroupId);
	}

	public static java.util.List<com.liferay.portal.model.UserGroupGroupRole> getUserGroupGroupRoles(
		long userGroupId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserGroupGroupRoles(userGroupId, groupId);
	}

	public static java.util.List<com.liferay.portal.model.UserGroupGroupRole> getUserGroupGroupRolesByGroupAndRole(
		long groupId, long roleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserGroupGroupRolesByGroupAndRole(groupId, roleId);
	}

	public static boolean hasUserGroupGroupRole(long userGroupId, long groupId,
		long roleId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasUserGroupGroupRole(userGroupId, groupId, roleId);
	}

	public static boolean hasUserGroupGroupRole(long userGroupId, long groupId,
		java.lang.String roleName)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().hasUserGroupGroupRole(userGroupId, groupId, roleName);
	}

	public static UserGroupGroupRoleLocalService getService() {
		if (_service == null) {
			_service = (UserGroupGroupRoleLocalService)PortalBeanLocatorUtil.locate(UserGroupGroupRoleLocalService.class.getName());
		}

		return _service;
	}

	public void setService(UserGroupGroupRoleLocalService service) {
		_service = service;
	}

	private static UserGroupGroupRoleLocalService _service;
}