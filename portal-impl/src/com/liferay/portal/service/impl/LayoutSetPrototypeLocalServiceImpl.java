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

package com.liferay.portal.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.LayoutSetPrototype;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.security.permission.PermissionCacheUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.base.LayoutSetPrototypeLocalServiceBaseImpl;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class LayoutSetPrototypeLocalServiceImpl
	extends LayoutSetPrototypeLocalServiceBaseImpl {

	public LayoutSetPrototype addLayoutSetPrototype(
			long userId, long companyId, Map<Locale, String> nameMap,
			String description, boolean active)
		throws PortalException, SystemException {

		// Layout set prototype

		long layoutSetPrototypeId = counterLocalService.increment();

		LayoutSetPrototype layoutSetPrototype =
			layoutSetPrototypePersistence.create(layoutSetPrototypeId);

		layoutSetPrototype.setCompanyId(companyId);
		layoutSetPrototype.setNameMap(nameMap);
		layoutSetPrototype.setDescription(description);
		layoutSetPrototype.setActive(active);

		layoutSetPrototypePersistence.update(layoutSetPrototype, false);

		// Resources

		if (userId > 0) {
			resourceLocalService.addResources(
				companyId, 0, userId, LayoutSetPrototype.class.getName(),
				layoutSetPrototype.getLayoutSetPrototypeId(), false, false,
				false);
		}

		// Group

		String friendlyURL =
			"/template-" + layoutSetPrototype.getLayoutSetPrototypeId();

		Group group = groupLocalService.addGroup(
			userId, LayoutSetPrototype.class.getName(),
			layoutSetPrototype.getLayoutSetPrototypeId(),
			layoutSetPrototype.getName(LocaleUtil.getDefault()), null, 0,
			friendlyURL, true, null);

		ServiceContext serviceContext = new ServiceContext();

		layoutLocalService.addLayout(
			userId, group.getGroupId(), true,
			LayoutConstants.DEFAULT_PARENT_LAYOUT_ID, "home", null, null,
			LayoutConstants.TYPE_PORTLET, false, "/home", serviceContext);

		return layoutSetPrototype;
	}

	public void deleteLayoutSetPrototype(long layoutSetPrototypeId)
		throws PortalException, SystemException {

		LayoutSetPrototype layoutSetPrototype =
			layoutSetPrototypePersistence.findByPrimaryKey(
				layoutSetPrototypeId);

		// Group

		Group group = layoutSetPrototype.getGroup();

		groupLocalService.deleteGroup(group.getGroupId());

		// Resources

		resourceLocalService.deleteResource(
			layoutSetPrototype.getCompanyId(),
			LayoutSetPrototype.class.getName(),
			ResourceConstants.SCOPE_INDIVIDUAL,
			layoutSetPrototype.getLayoutSetPrototypeId());

		// Layout set prototype

		layoutSetPrototypePersistence.remove(layoutSetPrototype);

		// Permission cache

		PermissionCacheUtil.clearCache();
	}

	public List<LayoutSetPrototype> search(
			long companyId, Boolean active, int start, int end,
			OrderByComparator obc)
		throws SystemException {

		if (active != null) {
			return layoutSetPrototypePersistence.findByC_A(
				companyId, active, start, end, obc);
		}
		else {
			return layoutSetPrototypePersistence.findByCompanyId(
				companyId, start, end, obc);
		}
	}

	public int searchCount(long companyId, Boolean active)
		throws SystemException {

		if (active != null) {
			return layoutSetPrototypePersistence.countByC_A(companyId, active);
		}
		else {
			return layoutSetPrototypePersistence.countByCompanyId(companyId);
		}
	}

	public LayoutSetPrototype updateLayoutSetPrototype(
			long layoutSetPrototypeId, Map<Locale, String> nameMap,
			String description, boolean active)
		throws PortalException, SystemException {

		// Layout set prototype

		LayoutSetPrototype layoutSetPrototype =
			layoutSetPrototypePersistence.findByPrimaryKey(
				layoutSetPrototypeId);

		layoutSetPrototype.setNameMap(nameMap);
		layoutSetPrototype.setDescription(description);
		layoutSetPrototype.setActive(active);

		layoutSetPrototypePersistence.update(layoutSetPrototype, false);

		// Group

		Group group = groupLocalService.getLayoutSetPrototypeGroup(
			layoutSetPrototype.getCompanyId(), layoutSetPrototypeId);

		group.setName(layoutSetPrototype.getName(LocaleUtil.getDefault()));

		groupPersistence.update(group, false);

		return layoutSetPrototype;
	}

}