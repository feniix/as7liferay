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

package com.liferay.portlet.journal.model;

import com.liferay.portal.kernel.annotation.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the JournalArticle service. Represents a row in the &quot;JournalArticle&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.portlet.journal.model.impl.JournalArticleModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.portlet.journal.model.impl.JournalArticleImpl}.
 * </p>
 *
 * <p>
 * Never modify or reference this interface directly. All methods that expect a journal article model instance should use the {@link JournalArticle} interface instead.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see JournalArticle
 * @see com.liferay.portlet.journal.model.impl.JournalArticleImpl
 * @see com.liferay.portlet.journal.model.impl.JournalArticleModelImpl
 * @generated
 */
public interface JournalArticleModel extends BaseModel<JournalArticle> {
	/**
	 * Gets the primary key of this journal article.
	 *
	 * @return the primary key of this journal article
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this journal article
	 *
	 * @param pk the primary key of this journal article
	 */
	public void setPrimaryKey(long pk);

	/**
	 * Gets the uuid of this journal article.
	 *
	 * @return the uuid of this journal article
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this journal article.
	 *
	 * @param uuid the uuid of this journal article
	 */
	public void setUuid(String uuid);

	/**
	 * Gets the id of this journal article.
	 *
	 * @return the id of this journal article
	 */
	public long getId();

	/**
	 * Sets the id of this journal article.
	 *
	 * @param id the id of this journal article
	 */
	public void setId(long id);

	/**
	 * Gets the resource prim key of this journal article.
	 *
	 * @return the resource prim key of this journal article
	 */
	public long getResourcePrimKey();

	/**
	 * Sets the resource prim key of this journal article.
	 *
	 * @param resourcePrimKey the resource prim key of this journal article
	 */
	public void setResourcePrimKey(long resourcePrimKey);

	/**
	 * Gets the group id of this journal article.
	 *
	 * @return the group id of this journal article
	 */
	public long getGroupId();

	/**
	 * Sets the group id of this journal article.
	 *
	 * @param groupId the group id of this journal article
	 */
	public void setGroupId(long groupId);

	/**
	 * Gets the company id of this journal article.
	 *
	 * @return the company id of this journal article
	 */
	public long getCompanyId();

	/**
	 * Sets the company id of this journal article.
	 *
	 * @param companyId the company id of this journal article
	 */
	public void setCompanyId(long companyId);

	/**
	 * Gets the user id of this journal article.
	 *
	 * @return the user id of this journal article
	 */
	public long getUserId();

	/**
	 * Sets the user id of this journal article.
	 *
	 * @param userId the user id of this journal article
	 */
	public void setUserId(long userId);

	/**
	 * Gets the user uuid of this journal article.
	 *
	 * @return the user uuid of this journal article
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this journal article.
	 *
	 * @param userUuid the user uuid of this journal article
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Gets the user name of this journal article.
	 *
	 * @return the user name of this journal article
	 */
	@AutoEscape
	public String getUserName();

	/**
	 * Sets the user name of this journal article.
	 *
	 * @param userName the user name of this journal article
	 */
	public void setUserName(String userName);

	/**
	 * Gets the create date of this journal article.
	 *
	 * @return the create date of this journal article
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this journal article.
	 *
	 * @param createDate the create date of this journal article
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Gets the modified date of this journal article.
	 *
	 * @return the modified date of this journal article
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this journal article.
	 *
	 * @param modifiedDate the modified date of this journal article
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Gets the article id of this journal article.
	 *
	 * @return the article id of this journal article
	 */
	public String getArticleId();

	/**
	 * Sets the article id of this journal article.
	 *
	 * @param articleId the article id of this journal article
	 */
	public void setArticleId(String articleId);

	/**
	 * Gets the version of this journal article.
	 *
	 * @return the version of this journal article
	 */
	public double getVersion();

	/**
	 * Sets the version of this journal article.
	 *
	 * @param version the version of this journal article
	 */
	public void setVersion(double version);

	/**
	 * Gets the title of this journal article.
	 *
	 * @return the title of this journal article
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this journal article.
	 *
	 * @param title the title of this journal article
	 */
	public void setTitle(String title);

	/**
	 * Gets the url title of this journal article.
	 *
	 * @return the url title of this journal article
	 */
	@AutoEscape
	public String getUrlTitle();

	/**
	 * Sets the url title of this journal article.
	 *
	 * @param urlTitle the url title of this journal article
	 */
	public void setUrlTitle(String urlTitle);

	/**
	 * Gets the description of this journal article.
	 *
	 * @return the description of this journal article
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this journal article.
	 *
	 * @param description the description of this journal article
	 */
	public void setDescription(String description);

	/**
	 * Gets the content of this journal article.
	 *
	 * @return the content of this journal article
	 */
	@AutoEscape
	public String getContent();

	/**
	 * Sets the content of this journal article.
	 *
	 * @param content the content of this journal article
	 */
	public void setContent(String content);

	/**
	 * Gets the type of this journal article.
	 *
	 * @return the type of this journal article
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this journal article.
	 *
	 * @param type the type of this journal article
	 */
	public void setType(String type);

	/**
	 * Gets the structure id of this journal article.
	 *
	 * @return the structure id of this journal article
	 */
	public String getStructureId();

	/**
	 * Sets the structure id of this journal article.
	 *
	 * @param structureId the structure id of this journal article
	 */
	public void setStructureId(String structureId);

	/**
	 * Gets the template id of this journal article.
	 *
	 * @return the template id of this journal article
	 */
	public String getTemplateId();

	/**
	 * Sets the template id of this journal article.
	 *
	 * @param templateId the template id of this journal article
	 */
	public void setTemplateId(String templateId);

	/**
	 * Gets the display date of this journal article.
	 *
	 * @return the display date of this journal article
	 */
	public Date getDisplayDate();

	/**
	 * Sets the display date of this journal article.
	 *
	 * @param displayDate the display date of this journal article
	 */
	public void setDisplayDate(Date displayDate);

	/**
	 * Gets the expiration date of this journal article.
	 *
	 * @return the expiration date of this journal article
	 */
	public Date getExpirationDate();

	/**
	 * Sets the expiration date of this journal article.
	 *
	 * @param expirationDate the expiration date of this journal article
	 */
	public void setExpirationDate(Date expirationDate);

	/**
	 * Gets the review date of this journal article.
	 *
	 * @return the review date of this journal article
	 */
	public Date getReviewDate();

	/**
	 * Sets the review date of this journal article.
	 *
	 * @param reviewDate the review date of this journal article
	 */
	public void setReviewDate(Date reviewDate);

	/**
	 * Gets the indexable of this journal article.
	 *
	 * @return the indexable of this journal article
	 */
	public boolean getIndexable();

	/**
	 * Determines whether this journal article is indexable.
	 *
	 * @return whether this journal article is indexable
	 */
	public boolean isIndexable();

	/**
	 * Sets whether this {$entity.humanName} is indexable.
	 *
	 * @param indexable the indexable of this journal article
	 */
	public void setIndexable(boolean indexable);

	/**
	 * Gets the small image of this journal article.
	 *
	 * @return the small image of this journal article
	 */
	public boolean getSmallImage();

	/**
	 * Determines whether this journal article is small image.
	 *
	 * @return whether this journal article is small image
	 */
	public boolean isSmallImage();

	/**
	 * Sets whether this {$entity.humanName} is small image.
	 *
	 * @param smallImage the small image of this journal article
	 */
	public void setSmallImage(boolean smallImage);

	/**
	 * Gets the small image id of this journal article.
	 *
	 * @return the small image id of this journal article
	 */
	public long getSmallImageId();

	/**
	 * Sets the small image id of this journal article.
	 *
	 * @param smallImageId the small image id of this journal article
	 */
	public void setSmallImageId(long smallImageId);

	/**
	 * Gets the small image u r l of this journal article.
	 *
	 * @return the small image u r l of this journal article
	 */
	@AutoEscape
	public String getSmallImageURL();

	/**
	 * Sets the small image u r l of this journal article.
	 *
	 * @param smallImageURL the small image u r l of this journal article
	 */
	public void setSmallImageURL(String smallImageURL);

	/**
	 * Gets the status of this journal article.
	 *
	 * @return the status of this journal article
	 */
	public int getStatus();

	/**
	 * Sets the status of this journal article.
	 *
	 * @param status the status of this journal article
	 */
	public void setStatus(int status);

	/**
	 * Gets the status by user id of this journal article.
	 *
	 * @return the status by user id of this journal article
	 */
	public long getStatusByUserId();

	/**
	 * Sets the status by user id of this journal article.
	 *
	 * @param statusByUserId the status by user id of this journal article
	 */
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Gets the status by user uuid of this journal article.
	 *
	 * @return the status by user uuid of this journal article
	 * @throws SystemException if a system exception occurred
	 */
	public String getStatusByUserUuid() throws SystemException;

	/**
	 * Sets the status by user uuid of this journal article.
	 *
	 * @param statusByUserUuid the status by user uuid of this journal article
	 */
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Gets the status by user name of this journal article.
	 *
	 * @return the status by user name of this journal article
	 */
	@AutoEscape
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this journal article.
	 *
	 * @param statusByUserName the status by user name of this journal article
	 */
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Gets the status date of this journal article.
	 *
	 * @return the status date of this journal article
	 */
	public Date getStatusDate();

	/**
	 * Sets the status date of this journal article.
	 *
	 * @param statusDate the status date of this journal article
	 */
	public void setStatusDate(Date statusDate);

	/**
	 * Determines whether this journal article is approved.
	 *
	 * @return true if this journal article is approved; false otherwise
	 */
	public boolean isApproved();

	/**
	 * Determines whether this journal article is a draft.
	 *
	 * @return true if this journal article is a draft; false otherwise
	 */
	public boolean isDraft();

	/**
	 * Determines whether this journal article is expired.
	 *
	 * @return true if this journal article is expired; false otherwise
	 */
	public boolean isExpired();

	/**
	 * Determines whether this journal article is pending.
	 *
	 * @return true if this journal article is pending; false otherwise
	 */
	public boolean isPending();

	/**
	 * Gets a copy of this journal article as an escaped model instance by wrapping it with an {@link com.liferay.portal.kernel.bean.AutoEscapeBeanHandler}.
	 *
	 * @return the escaped model instance
	 * @see com.liferay.portal.kernel.bean.AutoEscapeBeanHandler
	 */
	public JournalArticle toEscapedModel();

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

	public int compareTo(JournalArticle journalArticle);

	public int hashCode();

	public String toString();

	public String toXmlString();
}