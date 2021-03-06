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
 * The utility for the layout set prototype remote service. This utility wraps {@link com.liferay.portal.service.impl.LayoutSetPrototypeServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * Never modify this class directly. Add custom service methods to {@link com.liferay.portal.service.impl.LayoutSetPrototypeServiceImpl} and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LayoutSetPrototypeService
 * @see com.liferay.portal.service.base.LayoutSetPrototypeServiceBaseImpl
 * @see com.liferay.portal.service.impl.LayoutSetPrototypeServiceImpl
 * @generated
 */
public class LayoutSetPrototypeServiceUtil {
	public static com.liferay.portal.model.LayoutSetPrototype addLayoutSetPrototype(
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.lang.String description, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addLayoutSetPrototype(nameMap, description, active);
	}

	public static void deleteLayoutSetPrototype(long layoutSetPrototypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteLayoutSetPrototype(layoutSetPrototypeId);
	}

	public static com.liferay.portal.model.LayoutSetPrototype getLayoutSetPrototype(
		long layoutSetPrototypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLayoutSetPrototype(layoutSetPrototypeId);
	}

	public static java.util.List<com.liferay.portal.model.LayoutSetPrototype> search(
		long companyId, java.lang.Boolean active,
		com.liferay.portal.kernel.util.OrderByComparator obc)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().search(companyId, active, obc);
	}

	public static com.liferay.portal.model.LayoutSetPrototype updateLayoutSetPrototype(
		long layoutSetPrototypeId,
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.lang.String description, boolean active)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateLayoutSetPrototype(layoutSetPrototypeId, nameMap,
			description, active);
	}

	public static LayoutSetPrototypeService getService() {
		if (_service == null) {
			_service = (LayoutSetPrototypeService)PortalBeanLocatorUtil.locate(LayoutSetPrototypeService.class.getName());
		}

		return _service;
	}

	public void setService(LayoutSetPrototypeService service) {
		_service = service;
	}

	private static LayoutSetPrototypeService _service;
}