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

package com.liferay.portlet.announcements.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;

/**
 * The utility for the announcements flag remote service. This utility wraps {@link com.liferay.portlet.announcements.service.impl.AnnouncementsFlagServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.announcements.service.impl.AnnouncementsFlagServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnnouncementsFlagService
 * @see com.liferay.portlet.announcements.service.base.AnnouncementsFlagServiceBaseImpl
 * @see com.liferay.portlet.announcements.service.impl.AnnouncementsFlagServiceImpl
 * @generated
 */
public class AnnouncementsFlagServiceUtil {
	public static void addFlag(long entryId, int value)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().addFlag(entryId, value);
	}

	public static void deleteFlag(long flagId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteFlag(flagId);
	}

	public static com.liferay.portlet.announcements.model.AnnouncementsFlag getFlag(
		long entryId, int value)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getFlag(entryId, value);
	}

	public static AnnouncementsFlagService getService() {
		if (_service == null) {
			_service = (AnnouncementsFlagService)PortalBeanLocatorUtil.locate(AnnouncementsFlagService.class.getName());
		}

		return _service;
	}

	public void setService(AnnouncementsFlagService service) {
		_service = service;
	}

	private static AnnouncementsFlagService _service;
}