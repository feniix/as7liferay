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

package com.liferay.portlet.expando.model;

/**
 * The model interface for the ExpandoColumn service. Represents a row in the &quot;ExpandoColumn&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Never modify this interface directly. Add methods to {@link com.liferay.portlet.expando.model.impl.ExpandoColumnImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
 * </p>
 *
 * <p>
 * Never reference this interface directly. All methods that expect a expando column model instance should use the {@link ExpandoColumn} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExpandoColumnModel
 * @see com.liferay.portlet.expando.model.impl.ExpandoColumnImpl
 * @see com.liferay.portlet.expando.model.impl.ExpandoColumnModelImpl
 * @generated
 */
public interface ExpandoColumn extends ExpandoColumnModel {
	public java.io.Serializable getDefaultValue();

	public java.lang.String getDisplayName(java.util.Locale locale);

	public java.lang.String getTypeSettings();

	public com.liferay.portal.kernel.util.UnicodeProperties getTypeSettingsProperties();

	public void setTypeSettings(java.lang.String typeSettings);

	public void setTypeSettingsProperties(
		com.liferay.portal.kernel.util.UnicodeProperties typeSettingsProperties);
}