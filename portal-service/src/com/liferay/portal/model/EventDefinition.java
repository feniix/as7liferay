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

package com.liferay.portal.model;

import com.liferay.portal.kernel.xml.QName;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 */
public interface EventDefinition extends Serializable {

	public QName getQName();

	public void setQName(QName qName);

	public String getValueType();

	public void setValueType(String valueType);

	public PortletApp getPortletApp();

	public void setPortletApp(PortletApp portletApp);

}