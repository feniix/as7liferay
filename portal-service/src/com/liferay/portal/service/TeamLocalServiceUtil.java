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
 * The utility for the team local service. This utility wraps {@link com.liferay.portal.service.impl.TeamLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.liferay.portal.service.impl.TeamLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TeamLocalService
 * @see com.liferay.portal.service.base.TeamLocalServiceBaseImpl
 * @see com.liferay.portal.service.impl.TeamLocalServiceImpl
 * @generated
 */
public class TeamLocalServiceUtil {
	/**
	* Adds the team to the database. Also notifies the appropriate model listeners.
	*
	* @param team the team to add
	* @return the team that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Team addTeam(
		com.liferay.portal.model.Team team)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTeam(team);
	}

	/**
	* Creates a new team with the primary key. Does not add the team to the database.
	*
	* @param teamId the primary key for the new team
	* @return the new team
	*/
	public static com.liferay.portal.model.Team createTeam(long teamId) {
		return getService().createTeam(teamId);
	}

	/**
	* Deletes the team with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param teamId the primary key of the team to delete
	* @throws PortalException if a team with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTeam(long teamId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTeam(teamId);
	}

	/**
	* Deletes the team from the database. Also notifies the appropriate model listeners.
	*
	* @param team the team to delete
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteTeam(com.liferay.portal.model.Team team)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTeam(team);
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
	* Gets the team with the primary key.
	*
	* @param teamId the primary key of the team to get
	* @return the team
	* @throws PortalException if a team with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Team getTeam(long teamId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTeam(teamId);
	}

	/**
	* Gets a range of all the teams.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of teams to return
	* @param end the upper bound of the range of teams to return (not inclusive)
	* @return the range of teams
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.portal.model.Team> getTeams(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTeams(start, end);
	}

	/**
	* Gets the number of teams.
	*
	* @return the number of teams
	* @throws SystemException if a system exception occurred
	*/
	public static int getTeamsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTeamsCount();
	}

	/**
	* Updates the team in the database. Also notifies the appropriate model listeners.
	*
	* @param team the team to update
	* @return the team that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Team updateTeam(
		com.liferay.portal.model.Team team)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTeam(team);
	}

	/**
	* Updates the team in the database. Also notifies the appropriate model listeners.
	*
	* @param team the team to update
	* @param merge whether to merge the team with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the team that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.portal.model.Team updateTeam(
		com.liferay.portal.model.Team team, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTeam(team, merge);
	}

	public static com.liferay.portal.model.Team addTeam(long userId,
		long groupId, java.lang.String name, java.lang.String description)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addTeam(userId, groupId, name, description);
	}

	public static void deleteTeams(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteTeams(groupId);
	}

	public static java.util.List<com.liferay.portal.model.Team> getGroupTeams(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGroupTeams(groupId);
	}

	public static java.util.List<com.liferay.portal.model.Team> getUserTeams(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserTeams(userId);
	}

	public static java.util.List<com.liferay.portal.model.Team> getUserTeams(
		long userId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserTeams(userId, groupId);
	}

	public static boolean hasUserTeam(long userId, long teamId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().hasUserTeam(userId, teamId);
	}

	public static java.util.List<com.liferay.portal.model.Team> search(
		long groupId, java.lang.String name, java.lang.String description,
		java.util.LinkedHashMap<java.lang.String, java.lang.Object> params,
		int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .search(groupId, name, description, params, start, end, obc);
	}

	public static int searchCount(long groupId, java.lang.String name,
		java.lang.String description,
		java.util.LinkedHashMap<java.lang.String, java.lang.Object> params)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().searchCount(groupId, name, description, params);
	}

	public static com.liferay.portal.model.Team updateTeam(long teamId,
		java.lang.String name, java.lang.String description)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTeam(teamId, name, description);
	}

	public static TeamLocalService getService() {
		if (_service == null) {
			_service = (TeamLocalService)PortalBeanLocatorUtil.locate(TeamLocalService.class.getName());
		}

		return _service;
	}

	public void setService(TeamLocalService service) {
		_service = service;
	}

	private static TeamLocalService _service;
}