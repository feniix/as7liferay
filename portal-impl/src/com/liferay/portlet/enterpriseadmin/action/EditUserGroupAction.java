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

package com.liferay.portlet.enterpriseadmin.action;

import com.liferay.portal.DuplicateUserGroupException;
import com.liferay.portal.NoSuchUserGroupException;
import com.liferay.portal.RequiredUserGroupException;
import com.liferay.portal.UserGroupNameException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.UserGroupServiceUtil;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portlet.communities.util.CommunitiesUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Charles May
 */
public class EditUserGroupAction extends PortletAction {

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				updateUserGroup(actionRequest);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteUserGroups(actionRequest);
			}

			sendRedirect(actionRequest, actionResponse);
		}
		catch (Exception e) {
			if (e instanceof PrincipalException) {
				SessionErrors.add(actionRequest, e.getClass().getName());

				setForward(actionRequest, "portlet.enterprise_admin.error");
			}
			else if (e instanceof DuplicateUserGroupException ||
					 e instanceof NoSuchUserGroupException ||
					 e instanceof RequiredUserGroupException ||
					 e instanceof UserGroupNameException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				if (cmd.equals(Constants.DELETE)) {
					actionResponse.sendRedirect(
						ParamUtil.getString(actionRequest, "redirect"));
				}
			}
			else {
				throw e;
			}
		}
	}

	public ActionForward render(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		try {
			ActionUtil.getUserGroup(renderRequest);
		}
		catch (Exception e) {
			if (e instanceof NoSuchUserGroupException ||
				e instanceof PrincipalException) {

				SessionErrors.add(renderRequest, e.getClass().getName());

				return mapping.findForward("portlet.enterprise_admin.error");
			}
			else {
				throw e;
			}
		}

		return mapping.findForward(getForward(
			renderRequest, "portlet.enterprise_admin.edit_user_group"));
	}

	protected void deleteUserGroups(ActionRequest actionRequest)
		throws Exception {

		long[] deleteUserGroupIds = StringUtil.split(
			ParamUtil.getString(actionRequest, "deleteUserGroupIds"), 0L);

		for (int i = 0; i < deleteUserGroupIds.length; i++) {
			UserGroupServiceUtil.deleteUserGroup(deleteUserGroupIds[i]);
		}
	}

	protected void updateUserGroup(ActionRequest actionRequest)
		throws Exception {

		long userGroupId = ParamUtil.getLong(actionRequest, "userGroupId");

		String name = ParamUtil.getString(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");

		UserGroup userGroup = null;

		if (userGroupId <= 0) {

			// Add user group

			userGroup = UserGroupServiceUtil.addUserGroup(name, description);
		}
		else {

			// Update user group

			userGroup = UserGroupServiceUtil.updateUserGroup(
				userGroupId, name, description);
		}

		// Layout set prototypes

		long publicLayoutSetPrototypeId = ParamUtil.getLong(
			actionRequest, "publicLayoutSetPrototypeId");
		long privateLayoutSetPrototypeId = ParamUtil.getLong(
			actionRequest, "privateLayoutSetPrototypeId");

		CommunitiesUtil.applyLayoutSetPrototypes(
			userGroup.getGroup(), publicLayoutSetPrototypeId,
			privateLayoutSetPrototypeId);
	}

}