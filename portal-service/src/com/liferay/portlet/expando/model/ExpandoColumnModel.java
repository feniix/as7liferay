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

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the ExpandoColumn service. Represents a row in the &quot;ExpandoColumn&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.expando.model.impl.ExpandoColumnModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.expando.model.impl.ExpandoColumnImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a expando column model instance should use the {@link ExpandoColumn} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExpandoColumn
 * @see com.liferay.portlet.expando.model.impl.ExpandoColumnImpl
 * @see com.liferay.portlet.expando.model.impl.ExpandoColumnModelImpl
 * @generated
 */
public interface ExpandoColumnModel extends BaseModel<ExpandoColumn> {
	/**
	 * Gets the primary key of this expando column.
	 *
	 * @return the primary key of this expando column
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this expando column
	 *
	 * @param pk the primary key of this expando column
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the column id of this expando column.
	 *
	 * @return the column id of this expando column
	 */
	public long getColumnId();

	/**
	 * Sets the column id of this expando column.
	 *
	 * @param columnId the column id of this expando column
	 */
	public void setColumnId(long columnId);

	/**
	 * Gets the company id of this expando column.
	 *
	 * @return the company id of this expando column
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this expando column.
	 *
	 * @param companyId the company id of this expando column
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the table id of this expando column.
	 *
	 * @return the table id of this expando column
	 */
	public long getTableId();

	/**
	 * Sets the table id of this expando column.
	 *
	 * @param tableId the table id of this expando column
	 */
	public void setTableId(long tableId);

	/**
	 * Gets the name of this expando column.
	 *
	 * @return the name of this expando column
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this expando column.
	 *
	 * @param name the name of this expando column
	 */
	public void setName(String name);

	/**
	 * Gets the type of this expando column.
	 *
	 * @return the type of this expando column
	 */
	public int getType();

	/**
	 * Sets the type of this expando column.
	 *
	 * @param type the type of this expando column
	 */
	public void setType(int type);

	/**
	 * Gets the default data of this expando column.
	 *
	 * @return the default data of this expando column
	 */
	@AutoEscape
	public String getDefaultData();

	/**
	 * Sets the default data of this expando column.
	 *
	 * @param defaultData the default data of this expando column
	 */
	public void setDefaultData(String defaultData);

	/**
	 * Gets the type settings of this expando column.
	 *
	 * @return the type settings of this expando column
	 */
	@AutoEscape
	public String getTypeSettings();

	/**
	 * Sets the type settings of this expando column.
	 *
	 * @param typeSettings the type settings of this expando column
	 */
	public void setTypeSettings(String typeSettings);

	/**
	 * Gets a copy of this expando column as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public ExpandoColumn toEscapedModel();

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public void setEscapedModel(boolean escapedModel);

	public Serializable getPrimaryKeyObj();

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(ExpandoColumn expandoColumn);

	public int hashCode();

	public String toString();

	public String toXmlString();
}