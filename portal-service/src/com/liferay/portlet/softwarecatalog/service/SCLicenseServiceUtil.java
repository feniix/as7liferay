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

package com.liferay.portlet.softwarecatalog.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * The utility for the s c license remote service. This utility wraps {@link com.liferay.portlet.softwarecatalog.service.impl.SCLicenseServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.softwarecatalog.service.impl.SCLicenseServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SCLicenseService
 * @see com.liferay.portlet.softwarecatalog.service.base.SCLicenseServiceBaseImpl
 * @see com.liferay.portlet.softwarecatalog.service.impl.SCLicenseServiceImpl
 * @generated
 */
public class SCLicenseServiceUtil {
	public static com.liferay.portlet.softwarecatalog.model.SCLicense addLicense(
		java.lang.String name, java.lang.String url, boolean openSource,
		boolean active, boolean recommended)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addLicense(name, url, openSource, active, recommended);
	}

	public static void deleteLicense(long licenseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLicense(licenseId);
	}

	public static com.liferay.portlet.softwarecatalog.model.SCLicense getLicense(
		long licenseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLicense(licenseId);
	}

	public static com.liferay.portlet.softwarecatalog.model.SCLicense updateLicense(
		long licenseId, java.lang.String name, java.lang.String url,
		boolean openSource, boolean active, boolean recommended)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateLicense(licenseId, name, url, openSource, active,
			recommended);
	}

	public static SCLicenseService getService() {
		if (_service == null) {
			_service = (SCLicenseService)PortalBeanLocatorUtil.locate(SCLicenseService.class.getName());
		}

		return _service;
	}

	public void setService(SCLicenseService service) {
		_service = service;
	}

	private static SCLicenseService _service;
}