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

package com.liferay.portlet.flags.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * The utility for the flags entry remote service. This utility wraps {@link com.liferay.portlet.flags.service.impl.FlagsEntryServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.flags.service.impl.FlagsEntryServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FlagsEntryService
 * @see com.liferay.portlet.flags.service.base.FlagsEntryServiceBaseImpl
 * @see com.liferay.portlet.flags.service.impl.FlagsEntryServiceImpl
 * @generated
 */
public class FlagsEntryServiceUtil {
	public static void addEntry(java.lang.String className, long classPK,
		java.lang.String reporterEmailAddress, long reportedUserId,
		java.lang.String contentTitle, java.lang.String contentURL,
		java.lang.String reason,
		com.liferay.portal.service.ServiceContext serviceContext) {
		getService()
			.addEntry(className, classPK, reporterEmailAddress, reportedUserId,
			contentTitle, contentURL, reason, serviceContext);
	}

	public static FlagsEntryService getService() {
		if (_service == null) {
			_service = (FlagsEntryService)PortalBeanLocatorUtil.locate(FlagsEntryService.class.getName());
		}

		return _service;
	}

	public void setService(FlagsEntryService service) {
		_service = service;
	}

	private static FlagsEntryService _service;
}