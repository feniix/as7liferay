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

package com.liferay.taglib.ui;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.taglib.util.IncludeTag;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Brian Wing Shun Chan
 */
public class WriteTag extends IncludeTag {

	public void setBean(Object bean) {
		_bean = bean;
	}

	public void setProperty(String property) {
		_property = property;
	}

	protected void cleanUp() {
		_bean = null;
		_property = null;
	}

	protected String getPage() {
		if ((_bean == null) || Validator.isNull(_property)) {
			return null;
		}
		else {
			return _PAGE;
		}
	}

	protected void setAttributes(HttpServletRequest request) {
		request.setAttribute("liferay-ui:write:bean", _bean);
		request.setAttribute("liferay-ui:write:property", _property);
	}

	private static final String _PAGE = "/html/taglib/ui/write/page.jsp";

	private Object _bean;
	private String _property;

}