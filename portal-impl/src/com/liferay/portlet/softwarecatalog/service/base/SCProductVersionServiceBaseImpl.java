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

package com.liferay.portlet.softwarecatalog.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.service.persistence.ResourceFinder;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserFinder;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.portlet.softwarecatalog.service.SCFrameworkVersionLocalService;
import com.liferay.portlet.softwarecatalog.service.SCFrameworkVersionService;
import com.liferay.portlet.softwarecatalog.service.SCLicenseLocalService;
import com.liferay.portlet.softwarecatalog.service.SCLicenseService;
import com.liferay.portlet.softwarecatalog.service.SCProductEntryLocalService;
import com.liferay.portlet.softwarecatalog.service.SCProductEntryService;
import com.liferay.portlet.softwarecatalog.service.SCProductScreenshotLocalService;
import com.liferay.portlet.softwarecatalog.service.SCProductVersionLocalService;
import com.liferay.portlet.softwarecatalog.service.SCProductVersionService;
import com.liferay.portlet.softwarecatalog.service.persistence.SCFrameworkVersionPersistence;
import com.liferay.portlet.softwarecatalog.service.persistence.SCLicensePersistence;
import com.liferay.portlet.softwarecatalog.service.persistence.SCProductEntryPersistence;
import com.liferay.portlet.softwarecatalog.service.persistence.SCProductScreenshotPersistence;
import com.liferay.portlet.softwarecatalog.service.persistence.SCProductVersionPersistence;

import javax.sql.DataSource;

/**
 * The base implementation of the s c product version remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.portlet.softwarecatalog.service.impl.SCProductVersionServiceImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link com.liferay.portlet.softwarecatalog.service.SCProductVersionServiceUtil} to access the s c product version remote service.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portlet.softwarecatalog.service.impl.SCProductVersionServiceImpl
 * @see com.liferay.portlet.softwarecatalog.service.SCProductVersionServiceUtil
 * @generated
 */
public abstract class SCProductVersionServiceBaseImpl extends PrincipalBean
	implements SCProductVersionService {
	/**
	 * Gets the s c license local service.
	 *
	 * @return the s c license local service
	 */
	public SCLicenseLocalService getSCLicenseLocalService() {
		return scLicenseLocalService;
	}

	/**
	 * Sets the s c license local service.
	 *
	 * @param scLicenseLocalService the s c license local service
	 */
	public void setSCLicenseLocalService(
		SCLicenseLocalService scLicenseLocalService) {
		this.scLicenseLocalService = scLicenseLocalService;
	}

	/**
	 * Gets the s c license remote service.
	 *
	 * @return the s c license remote service
	 */
	public SCLicenseService getSCLicenseService() {
		return scLicenseService;
	}

	/**
	 * Sets the s c license remote service.
	 *
	 * @param scLicenseService the s c license remote service
	 */
	public void setSCLicenseService(SCLicenseService scLicenseService) {
		this.scLicenseService = scLicenseService;
	}

	/**
	 * Gets the s c license persistence.
	 *
	 * @return the s c license persistence
	 */
	public SCLicensePersistence getSCLicensePersistence() {
		return scLicensePersistence;
	}

	/**
	 * Sets the s c license persistence.
	 *
	 * @param scLicensePersistence the s c license persistence
	 */
	public void setSCLicensePersistence(
		SCLicensePersistence scLicensePersistence) {
		this.scLicensePersistence = scLicensePersistence;
	}

	/**
	 * Gets the s c framework version local service.
	 *
	 * @return the s c framework version local service
	 */
	public SCFrameworkVersionLocalService getSCFrameworkVersionLocalService() {
		return scFrameworkVersionLocalService;
	}

	/**
	 * Sets the s c framework version local service.
	 *
	 * @param scFrameworkVersionLocalService the s c framework version local service
	 */
	public void setSCFrameworkVersionLocalService(
		SCFrameworkVersionLocalService scFrameworkVersionLocalService) {
		this.scFrameworkVersionLocalService = scFrameworkVersionLocalService;
	}

	/**
	 * Gets the s c framework version remote service.
	 *
	 * @return the s c framework version remote service
	 */
	public SCFrameworkVersionService getSCFrameworkVersionService() {
		return scFrameworkVersionService;
	}

	/**
	 * Sets the s c framework version remote service.
	 *
	 * @param scFrameworkVersionService the s c framework version remote service
	 */
	public void setSCFrameworkVersionService(
		SCFrameworkVersionService scFrameworkVersionService) {
		this.scFrameworkVersionService = scFrameworkVersionService;
	}

	/**
	 * Gets the s c framework version persistence.
	 *
	 * @return the s c framework version persistence
	 */
	public SCFrameworkVersionPersistence getSCFrameworkVersionPersistence() {
		return scFrameworkVersionPersistence;
	}

	/**
	 * Sets the s c framework version persistence.
	 *
	 * @param scFrameworkVersionPersistence the s c framework version persistence
	 */
	public void setSCFrameworkVersionPersistence(
		SCFrameworkVersionPersistence scFrameworkVersionPersistence) {
		this.scFrameworkVersionPersistence = scFrameworkVersionPersistence;
	}

	/**
	 * Gets the s c product entry local service.
	 *
	 * @return the s c product entry local service
	 */
	public SCProductEntryLocalService getSCProductEntryLocalService() {
		return scProductEntryLocalService;
	}

	/**
	 * Sets the s c product entry local service.
	 *
	 * @param scProductEntryLocalService the s c product entry local service
	 */
	public void setSCProductEntryLocalService(
		SCProductEntryLocalService scProductEntryLocalService) {
		this.scProductEntryLocalService = scProductEntryLocalService;
	}

	/**
	 * Gets the s c product entry remote service.
	 *
	 * @return the s c product entry remote service
	 */
	public SCProductEntryService getSCProductEntryService() {
		return scProductEntryService;
	}

	/**
	 * Sets the s c product entry remote service.
	 *
	 * @param scProductEntryService the s c product entry remote service
	 */
	public void setSCProductEntryService(
		SCProductEntryService scProductEntryService) {
		this.scProductEntryService = scProductEntryService;
	}

	/**
	 * Gets the s c product entry persistence.
	 *
	 * @return the s c product entry persistence
	 */
	public SCProductEntryPersistence getSCProductEntryPersistence() {
		return scProductEntryPersistence;
	}

	/**
	 * Sets the s c product entry persistence.
	 *
	 * @param scProductEntryPersistence the s c product entry persistence
	 */
	public void setSCProductEntryPersistence(
		SCProductEntryPersistence scProductEntryPersistence) {
		this.scProductEntryPersistence = scProductEntryPersistence;
	}

	/**
	 * Gets the s c product screenshot local service.
	 *
	 * @return the s c product screenshot local service
	 */
	public SCProductScreenshotLocalService getSCProductScreenshotLocalService() {
		return scProductScreenshotLocalService;
	}

	/**
	 * Sets the s c product screenshot local service.
	 *
	 * @param scProductScreenshotLocalService the s c product screenshot local service
	 */
	public void setSCProductScreenshotLocalService(
		SCProductScreenshotLocalService scProductScreenshotLocalService) {
		this.scProductScreenshotLocalService = scProductScreenshotLocalService;
	}

	/**
	 * Gets the s c product screenshot persistence.
	 *
	 * @return the s c product screenshot persistence
	 */
	public SCProductScreenshotPersistence getSCProductScreenshotPersistence() {
		return scProductScreenshotPersistence;
	}

	/**
	 * Sets the s c product screenshot persistence.
	 *
	 * @param scProductScreenshotPersistence the s c product screenshot persistence
	 */
	public void setSCProductScreenshotPersistence(
		SCProductScreenshotPersistence scProductScreenshotPersistence) {
		this.scProductScreenshotPersistence = scProductScreenshotPersistence;
	}

	/**
	 * Gets the s c product version local service.
	 *
	 * @return the s c product version local service
	 */
	public SCProductVersionLocalService getSCProductVersionLocalService() {
		return scProductVersionLocalService;
	}

	/**
	 * Sets the s c product version local service.
	 *
	 * @param scProductVersionLocalService the s c product version local service
	 */
	public void setSCProductVersionLocalService(
		SCProductVersionLocalService scProductVersionLocalService) {
		this.scProductVersionLocalService = scProductVersionLocalService;
	}

	/**
	 * Gets the s c product version remote service.
	 *
	 * @return the s c product version remote service
	 */
	public SCProductVersionService getSCProductVersionService() {
		return scProductVersionService;
	}

	/**
	 * Sets the s c product version remote service.
	 *
	 * @param scProductVersionService the s c product version remote service
	 */
	public void setSCProductVersionService(
		SCProductVersionService scProductVersionService) {
		this.scProductVersionService = scProductVersionService;
	}

	/**
	 * Gets the s c product version persistence.
	 *
	 * @return the s c product version persistence
	 */
	public SCProductVersionPersistence getSCProductVersionPersistence() {
		return scProductVersionPersistence;
	}

	/**
	 * Sets the s c product version persistence.
	 *
	 * @param scProductVersionPersistence the s c product version persistence
	 */
	public void setSCProductVersionPersistence(
		SCProductVersionPersistence scProductVersionPersistence) {
		this.scProductVersionPersistence = scProductVersionPersistence;
	}

	/**
	 * Gets the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Gets the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Gets the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Gets the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Gets the resource finder.
	 *
	 * @return the resource finder
	 */
	public ResourceFinder getResourceFinder() {
		return resourceFinder;
	}

	/**
	 * Sets the resource finder.
	 *
	 * @param resourceFinder the resource finder
	 */
	public void setResourceFinder(ResourceFinder resourceFinder) {
		this.resourceFinder = resourceFinder;
	}

	/**
	 * Gets the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Gets the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Gets the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	/**
	 * Gets the user finder.
	 *
	 * @return the user finder
	 */
	public UserFinder getUserFinder() {
		return userFinder;
	}

	/**
	 * Sets the user finder.
	 *
	 * @param userFinder the user finder
	 */
	public void setUserFinder(UserFinder userFinder) {
		this.userFinder = userFinder;
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query to perform
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = scProductVersionPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = SCLicenseLocalService.class)
	protected SCLicenseLocalService scLicenseLocalService;
	@BeanReference(type = SCLicenseService.class)
	protected SCLicenseService scLicenseService;
	@BeanReference(type = SCLicensePersistence.class)
	protected SCLicensePersistence scLicensePersistence;
	@BeanReference(type = SCFrameworkVersionLocalService.class)
	protected SCFrameworkVersionLocalService scFrameworkVersionLocalService;
	@BeanReference(type = SCFrameworkVersionService.class)
	protected SCFrameworkVersionService scFrameworkVersionService;
	@BeanReference(type = SCFrameworkVersionPersistence.class)
	protected SCFrameworkVersionPersistence scFrameworkVersionPersistence;
	@BeanReference(type = SCProductEntryLocalService.class)
	protected SCProductEntryLocalService scProductEntryLocalService;
	@BeanReference(type = SCProductEntryService.class)
	protected SCProductEntryService scProductEntryService;
	@BeanReference(type = SCProductEntryPersistence.class)
	protected SCProductEntryPersistence scProductEntryPersistence;
	@BeanReference(type = SCProductScreenshotLocalService.class)
	protected SCProductScreenshotLocalService scProductScreenshotLocalService;
	@BeanReference(type = SCProductScreenshotPersistence.class)
	protected SCProductScreenshotPersistence scProductScreenshotPersistence;
	@BeanReference(type = SCProductVersionLocalService.class)
	protected SCProductVersionLocalService scProductVersionLocalService;
	@BeanReference(type = SCProductVersionService.class)
	protected SCProductVersionService scProductVersionService;
	@BeanReference(type = SCProductVersionPersistence.class)
	protected SCProductVersionPersistence scProductVersionPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = ResourceFinder.class)
	protected ResourceFinder resourceFinder;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = UserFinder.class)
	protected UserFinder userFinder;
}