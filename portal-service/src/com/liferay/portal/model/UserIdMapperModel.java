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

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the UserIdMapper service. Represents a row in the &quot;UserIdMapper&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portal.model.impl.UserIdMapperModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portal.model.impl.UserIdMapperImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a user id mapper model instance should use the {@link UserIdMapper} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserIdMapper
 * @see com.liferay.portal.model.impl.UserIdMapperImpl
 * @see com.liferay.portal.model.impl.UserIdMapperModelImpl
 * @generated
 */
public interface UserIdMapperModel extends BaseModel<UserIdMapper> {
	/**
	 * Gets the primary key of this user id mapper.
	 *
	 * @return the primary key of this user id mapper
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this user id mapper
	 *
	 * @param pk the primary key of this user id mapper
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the user id mapper id of this user id mapper.
	 *
	 * @return the user id mapper id of this user id mapper
	 */
	public long getUserIdMapperId();

	/**
	 * Sets the user id mapper id of this user id mapper.
	 *
	 * @param userIdMapperId the user id mapper id of this user id mapper
	 */
	public void setUserIdMapperId(long userIdMapperId);

	/**
	 * Gets the user id of this user id mapper.
	 *
	 * @return the user id of this user id mapper
	 */
	public long getUserId();

	/**
	 * Sets the user id of this user id mapper.
	 *
	 * @param userId the user id of this user id mapper
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this user id mapper.
	 *
	 * @return the user uuid of this user id mapper
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this user id mapper.
	 *
	 * @param userUuid the user uuid of this user id mapper
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the type of this user id mapper.
	 *
	 * @return the type of this user id mapper
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this user id mapper.
	 *
	 * @param type the type of this user id mapper
	 */
	public void setType(String type);

	/**
	 * Gets the description of this user id mapper.
	 *
	 * @return the description of this user id mapper
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this user id mapper.
	 *
	 * @param description the description of this user id mapper
	 */
	public void setDescription(String description);

	/**
	 * Gets the external user id of this user id mapper.
	 *
	 * @return the external user id of this user id mapper
	 */
	@AutoEscape
	public String getExternalUserId();

	/**
	 * Sets the external user id of this user id mapper.
	 *
	 * @param externalUserId the external user id of this user id mapper
	 */
	public void setExternalUserId(String externalUserId);

	/**
	 * Gets a copy of this user id mapper as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public UserIdMapper toEscapedModel();

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

	public int compareTo(UserIdMapper userIdMapper);

	public int hashCode();

	public String toString();

	public String toXmlString();
}