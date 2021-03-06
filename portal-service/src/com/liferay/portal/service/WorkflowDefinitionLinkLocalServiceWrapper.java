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

/**
 * <p>
 * This class is a wrapper for {@link WorkflowDefinitionLinkLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       WorkflowDefinitionLinkLocalService
 * @generated
 */
public class WorkflowDefinitionLinkLocalServiceWrapper
	implements WorkflowDefinitionLinkLocalService {
	public WorkflowDefinitionLinkLocalServiceWrapper(
		WorkflowDefinitionLinkLocalService workflowDefinitionLinkLocalService) {
		_workflowDefinitionLinkLocalService = workflowDefinitionLinkLocalService;
	}

	/**
	* Adds the workflow definition link to the database. Also notifies the appropriate model listeners.
	*
	* @param workflowDefinitionLink the workflow definition link to add
	* @return the workflow definition link that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.WorkflowDefinitionLink addWorkflowDefinitionLink(
		com.liferay.portal.model.WorkflowDefinitionLink workflowDefinitionLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowDefinitionLinkLocalService.addWorkflowDefinitionLink(workflowDefinitionLink);
	}

	/**
	* Creates a new workflow definition link with the primary key. Does not add the workflow definition link to the database.
	*
	* @param workflowDefinitionLinkId the primary key for the new workflow definition link
	* @return the new workflow definition link
	*/
	public com.liferay.portal.model.WorkflowDefinitionLink createWorkflowDefinitionLink(
		long workflowDefinitionLinkId) {
		return _workflowDefinitionLinkLocalService.createWorkflowDefinitionLink(workflowDefinitionLinkId);
	}

	/**
	* Deletes the workflow definition link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workflowDefinitionLinkId the primary key of the workflow definition link to delete
	* @throws PortalException if a workflow definition link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteWorkflowDefinitionLink(long workflowDefinitionLinkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_workflowDefinitionLinkLocalService.deleteWorkflowDefinitionLink(workflowDefinitionLinkId);
	}

	/**
	* Deletes the workflow definition link from the database. Also notifies the appropriate model listeners.
	*
	* @param workflowDefinitionLink the workflow definition link to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deleteWorkflowDefinitionLink(
		com.liferay.portal.model.WorkflowDefinitionLink workflowDefinitionLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		_workflowDefinitionLinkLocalService.deleteWorkflowDefinitionLink(workflowDefinitionLink);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowDefinitionLinkLocalService.dynamicQuery(dynamicQuery);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowDefinitionLinkLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowDefinitionLinkLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowDefinitionLinkLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the workflow definition link with the primary key.
	*
	* @param workflowDefinitionLinkId the primary key of the workflow definition link to get
	* @return the workflow definition link
	* @throws PortalException if a workflow definition link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.WorkflowDefinitionLink getWorkflowDefinitionLink(
		long workflowDefinitionLinkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workflowDefinitionLinkLocalService.getWorkflowDefinitionLink(workflowDefinitionLinkId);
	}

	/**
	* Gets a range of all the workflow definition links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of workflow definition links to return
	* @param end the upper bound of the range of workflow definition links to return (not inclusive)
	* @return the range of workflow definition links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portal.model.WorkflowDefinitionLink> getWorkflowDefinitionLinks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowDefinitionLinkLocalService.getWorkflowDefinitionLinks(start,
			end);
	}

	/**
	* Gets the number of workflow definition links.
	*
	* @return the number of workflow definition links
	* @throws SystemException if a system exception occurred
	*/
	public int getWorkflowDefinitionLinksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowDefinitionLinkLocalService.getWorkflowDefinitionLinksCount();
	}

	/**
	* Updates the workflow definition link in the database. Also notifies the appropriate model listeners.
	*
	* @param workflowDefinitionLink the workflow definition link to update
	* @return the workflow definition link that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.WorkflowDefinitionLink updateWorkflowDefinitionLink(
		com.liferay.portal.model.WorkflowDefinitionLink workflowDefinitionLink)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowDefinitionLinkLocalService.updateWorkflowDefinitionLink(workflowDefinitionLink);
	}

	/**
	* Updates the workflow definition link in the database. Also notifies the appropriate model listeners.
	*
	* @param workflowDefinitionLink the workflow definition link to update
	* @param merge whether to merge the workflow definition link with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the workflow definition link that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portal.model.WorkflowDefinitionLink updateWorkflowDefinitionLink(
		com.liferay.portal.model.WorkflowDefinitionLink workflowDefinitionLink,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowDefinitionLinkLocalService.updateWorkflowDefinitionLink(workflowDefinitionLink,
			merge);
	}

	public com.liferay.portal.model.WorkflowDefinitionLink addWorkflowDefinitionLink(
		long userId, long companyId, long groupId, java.lang.String className,
		java.lang.String workflowDefinitionName, int workflowDefinitionVersion)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workflowDefinitionLinkLocalService.addWorkflowDefinitionLink(userId,
			companyId, groupId, className, workflowDefinitionName,
			workflowDefinitionVersion);
	}

	public void deleteWorkflowDefinitionLink(long companyId, long groupId,
		java.lang.String className)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_workflowDefinitionLinkLocalService.deleteWorkflowDefinitionLink(companyId,
			groupId, className);
	}

	public com.liferay.portal.model.WorkflowDefinitionLink getDefaultWorkflowDefinitionLink(
		long companyId, java.lang.String className)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workflowDefinitionLinkLocalService.getDefaultWorkflowDefinitionLink(companyId,
			className);
	}

	public com.liferay.portal.model.WorkflowDefinitionLink getWorkflowDefinitionLink(
		long companyId, long groupId, java.lang.String className)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workflowDefinitionLinkLocalService.getWorkflowDefinitionLink(companyId,
			groupId, className);
	}

	public com.liferay.portal.model.WorkflowDefinitionLink getWorkflowDefinitionLink(
		long companyId, long groupId, java.lang.String className, boolean strict)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workflowDefinitionLinkLocalService.getWorkflowDefinitionLink(companyId,
			groupId, className, strict);
	}

	public int getWorkflowDefinitionLinksCount(long companyId,
		java.lang.String workflowDefinitionName, int workflowDefinitionVersion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workflowDefinitionLinkLocalService.getWorkflowDefinitionLinksCount(companyId,
			workflowDefinitionName, workflowDefinitionVersion);
	}

	public boolean hasWorkflowDefinitionLink(long companyId, long groupId,
		java.lang.String className)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workflowDefinitionLinkLocalService.hasWorkflowDefinitionLink(companyId,
			groupId, className);
	}

	public com.liferay.portal.model.WorkflowDefinitionLink updateWorkflowDefinitionLink(
		long userId, long companyId, long groupId, java.lang.String className,
		java.lang.String workflowDefinitionName, int workflowDefinitionVersion)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workflowDefinitionLinkLocalService.updateWorkflowDefinitionLink(userId,
			companyId, groupId, className, workflowDefinitionName,
			workflowDefinitionVersion);
	}

	public WorkflowDefinitionLinkLocalService getWrappedWorkflowDefinitionLinkLocalService() {
		return _workflowDefinitionLinkLocalService;
	}

	private WorkflowDefinitionLinkLocalService _workflowDefinitionLinkLocalService;
}