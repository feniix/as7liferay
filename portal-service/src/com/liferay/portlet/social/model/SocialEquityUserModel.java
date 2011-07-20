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

package com.liferay.portlet.social.model;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the SocialEquityUser service. Represents a row in the &quot;SocialEquityUser&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.social.model.impl.SocialEquityUserModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.social.model.impl.SocialEquityUserImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a social equity user model instance should use the {@link SocialEquityUser} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialEquityUser
 * @see com.liferay.portlet.social.model.impl.SocialEquityUserImpl
 * @see com.liferay.portlet.social.model.impl.SocialEquityUserModelImpl
 * @generated
 */
public interface SocialEquityUserModel extends BaseModel<SocialEquityUser> {
	/**
	 * Gets the primary key of this social equity user.
	 *
	 * @return the primary key of this social equity user
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this social equity user
	 *
	 * @param pk the primary key of this social equity user
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the equity user id of this social equity user.
	 *
	 * @return the equity user id of this social equity user
	 */
	public long getEquityUserId();

	/**
	 * Sets the equity user id of this social equity user.
	 *
	 * @param equityUserId the equity user id of this social equity user
	 */
	public void setEquityUserId(long equityUserId);

	/**
	 * Gets the equity user uuid of this social equity user.
	 *
	 * @return the equity user uuid of this social equity user
	 * @throws SystemException if a system exception occurred
	 */
	public String getEquityUserUuid() throws SystemException;

	/**
	 * Sets the equity user uuid of this social equity user.
	 *
	 * @param equityUserUuid the equity user uuid of this social equity user
	 */
	public void setEquityUserUuid(String equityUserUuid);

	/**
	 * Gets the group id of this social equity user.
	 *
	 * @return the group id of this social equity user
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this social equity user.
	 *
	 * @param groupId the group id of this social equity user
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the company id of this social equity user.
	 *
	 * @return the company id of this social equity user
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this social equity user.
	 *
	 * @param companyId the company id of this social equity user
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user id of this social equity user.
	 *
	 * @return the user id of this social equity user
	 */
	public long getUserId();

	/**
	 * Sets the user id of this social equity user.
	 *
	 * @param userId the user id of this social equity user
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this social equity user.
	 *
	 * @return the user uuid of this social equity user
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this social equity user.
	 *
	 * @param userUuid the user uuid of this social equity user
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the contribution k of this social equity user.
	 *
	 * @return the contribution k of this social equity user
	 */
	public double getContributionK();

	/**
	 * Sets the contribution k of this social equity user.
	 *
	 * @param contributionK the contribution k of this social equity user
	 */
	public void setContributionK(double contributionK);

	/**
	 * Gets the contribution b of this social equity user.
	 *
	 * @return the contribution b of this social equity user
	 */
	public double getContributionB();

	/**
	 * Sets the contribution b of this social equity user.
	 *
	 * @param contributionB the contribution b of this social equity user
	 */
	public void setContributionB(double contributionB);

	/**
	 * Gets the participation k of this social equity user.
	 *
	 * @return the participation k of this social equity user
	 */
	public double getParticipationK();

	/**
	 * Sets the participation k of this social equity user.
	 *
	 * @param participationK the participation k of this social equity user
	 */
	public void setParticipationK(double participationK);

	/**
	 * Gets the participation b of this social equity user.
	 *
	 * @return the participation b of this social equity user
	 */
	public double getParticipationB();

	/**
	 * Sets the participation b of this social equity user.
	 *
	 * @param participationB the participation b of this social equity user
	 */
	public void setParticipationB(double participationB);

	/**
	 * Gets the rank of this social equity user.
	 *
	 * @return the rank of this social equity user
	 */
	public int getRank();

	/**
	 * Sets the rank of this social equity user.
	 *
	 * @param rank the rank of this social equity user
	 */
	public void setRank(int rank);

	/**
	 * Gets a copy of this social equity user as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public SocialEquityUser toEscapedModel();

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

	public int compareTo(SocialEquityUser socialEquityUser);

	public int hashCode();

	public String toString();

	public String toXmlString();
}