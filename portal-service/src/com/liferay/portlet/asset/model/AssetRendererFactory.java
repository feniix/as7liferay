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

package com.liferay.portlet.asset.model;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.security.permission.PermissionChecker;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

/**
 * @author Jorge Ferrer
 * @author Juan Fernández
 * @author Raymond Augé
 */
public interface AssetRendererFactory {

	public static int TYPE_LATEST = 0;

	public static int TYPE_LATEST_APPROVED = 1;

	public AssetRenderer getAssetRenderer(long classPK)
		throws PortalException, SystemException;

	public AssetRenderer getAssetRenderer(long classPK, int type)
		throws PortalException, SystemException;

	public AssetRenderer getAssetRenderer(long groupId, String urlTitle)
		throws PortalException, SystemException;

	public String getClassName();

	public long getClassNameId();

	public String getIconPath(PortletRequest portletRequest);

	public String getPortletId();

	public String getType();

	public PortletURL getURLAdd(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse);

	public boolean hasPermission(
			PermissionChecker permissionChecker, long entryClassPK,
			String actionId)
		throws Exception;

	public boolean isSelectable();

	public void setClassNameId(long classNameId);

	public void setPortletId(String portletId);

}