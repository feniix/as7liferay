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

package com.liferay.portlet.polls.service;

/**
 * <p>
 * This class is a wrapper for {@link PollsQuestionLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       PollsQuestionLocalService
 * @generated
 */
public class PollsQuestionLocalServiceWrapper
	implements PollsQuestionLocalService {
	public PollsQuestionLocalServiceWrapper(
		PollsQuestionLocalService pollsQuestionLocalService) {
		_pollsQuestionLocalService = pollsQuestionLocalService;
	}

	/**
	* Adds the polls question to the database. Also notifies the appropriate model listeners.
	*
	* @param pollsQuestion the polls question to add
	* @return the polls question that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.polls.model.PollsQuestion addPollsQuestion(
		com.liferay.portlet.polls.model.PollsQuestion pollsQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pollsQuestionLocalService.addPollsQuestion(pollsQuestion);
	}

	/**
	* Creates a new polls question with the primary key. Does not add the polls question to the database.
	*
	* @param questionId the primary key for the new polls question
	* @return the new polls question
	*/
	public com.liferay.portlet.polls.model.PollsQuestion createPollsQuestion(
		long questionId) {
		return _pollsQuestionLocalService.createPollsQuestion(questionId);
	}

	/**
	* Deletes the polls question with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param questionId the primary key of the polls question to delete
	* @throws PortalException if a polls question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deletePollsQuestion(long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_pollsQuestionLocalService.deletePollsQuestion(questionId);
	}

	/**
	* Deletes the polls question from the database. Also notifies the appropriate model listeners.
	*
	* @param pollsQuestion the polls question to delete
	* @throws SystemException if a system exception occurred
	*/
	public void deletePollsQuestion(
		com.liferay.portlet.polls.model.PollsQuestion pollsQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		_pollsQuestionLocalService.deletePollsQuestion(pollsQuestion);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pollsQuestionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _pollsQuestionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query to search with
	* @param start the lower bound of the range of model instances to return
	* @param end the upper bound of the range of model instances to return (not inclusive)
	* @param orderByComparator the comparator to order the results by
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pollsQuestionLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Counts the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query to search with
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pollsQuestionLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Gets the polls question with the primary key.
	*
	* @param questionId the primary key of the polls question to get
	* @return the polls question
	* @throws PortalException if a polls question with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.polls.model.PollsQuestion getPollsQuestion(
		long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pollsQuestionLocalService.getPollsQuestion(questionId);
	}

	/**
	* Gets the polls question with the UUID and group id.
	*
	* @param uuid the UUID of polls question to get
	* @param groupId the group id of the polls question to get
	* @return the polls question
	* @throws PortalException if a polls question with the UUID and group id could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.polls.model.PollsQuestion getPollsQuestionByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pollsQuestionLocalService.getPollsQuestionByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Gets a range of all the polls questions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of polls questions to return
	* @param end the upper bound of the range of polls questions to return (not inclusive)
	* @return the range of polls questions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.portlet.polls.model.PollsQuestion> getPollsQuestions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pollsQuestionLocalService.getPollsQuestions(start, end);
	}

	/**
	* Gets the number of polls questions.
	*
	* @return the number of polls questions
	* @throws SystemException if a system exception occurred
	*/
	public int getPollsQuestionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pollsQuestionLocalService.getPollsQuestionsCount();
	}

	/**
	* Updates the polls question in the database. Also notifies the appropriate model listeners.
	*
	* @param pollsQuestion the polls question to update
	* @return the polls question that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.polls.model.PollsQuestion updatePollsQuestion(
		com.liferay.portlet.polls.model.PollsQuestion pollsQuestion)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pollsQuestionLocalService.updatePollsQuestion(pollsQuestion);
	}

	/**
	* Updates the polls question in the database. Also notifies the appropriate model listeners.
	*
	* @param pollsQuestion the polls question to update
	* @param merge whether to merge the polls question with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the polls question that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.portlet.polls.model.PollsQuestion updatePollsQuestion(
		com.liferay.portlet.polls.model.PollsQuestion pollsQuestion,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pollsQuestionLocalService.updatePollsQuestion(pollsQuestion,
			merge);
	}

	public com.liferay.portlet.polls.model.PollsQuestion addQuestion(
		long userId,
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		int expirationDateMonth, int expirationDateDay, int expirationDateYear,
		int expirationDateHour, int expirationDateMinute, boolean neverExpire,
		java.util.List<com.liferay.portlet.polls.model.PollsChoice> choices,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pollsQuestionLocalService.addQuestion(userId, titleMap,
			descriptionMap, expirationDateMonth, expirationDateDay,
			expirationDateYear, expirationDateHour, expirationDateMinute,
			neverExpire, choices, serviceContext);
	}

	public void addQuestionResources(long questionId,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_pollsQuestionLocalService.addQuestionResources(questionId,
			addCommunityPermissions, addGuestPermissions);
	}

	public void addQuestionResources(long questionId,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_pollsQuestionLocalService.addQuestionResources(questionId,
			communityPermissions, guestPermissions);
	}

	public void addQuestionResources(
		com.liferay.portlet.polls.model.PollsQuestion question,
		boolean addCommunityPermissions, boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_pollsQuestionLocalService.addQuestionResources(question,
			addCommunityPermissions, addGuestPermissions);
	}

	public void addQuestionResources(
		com.liferay.portlet.polls.model.PollsQuestion question,
		java.lang.String[] communityPermissions,
		java.lang.String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_pollsQuestionLocalService.addQuestionResources(question,
			communityPermissions, guestPermissions);
	}

	public void deleteQuestion(long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_pollsQuestionLocalService.deleteQuestion(questionId);
	}

	public void deleteQuestion(
		com.liferay.portlet.polls.model.PollsQuestion question)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_pollsQuestionLocalService.deleteQuestion(question);
	}

	public void deleteQuestions(long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_pollsQuestionLocalService.deleteQuestions(groupId);
	}

	public com.liferay.portlet.polls.model.PollsQuestion getQuestion(
		long questionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pollsQuestionLocalService.getQuestion(questionId);
	}

	public java.util.List<com.liferay.portlet.polls.model.PollsQuestion> getQuestions(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pollsQuestionLocalService.getQuestions(groupId);
	}

	public java.util.List<com.liferay.portlet.polls.model.PollsQuestion> getQuestions(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pollsQuestionLocalService.getQuestions(groupId, start, end);
	}

	public int getQuestionsCount(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _pollsQuestionLocalService.getQuestionsCount(groupId);
	}

	public com.liferay.portlet.polls.model.PollsQuestion updateQuestion(
		long userId, long questionId,
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		int expirationDateMonth, int expirationDateDay, int expirationDateYear,
		int expirationDateHour, int expirationDateMinute, boolean neverExpire,
		java.util.List<com.liferay.portlet.polls.model.PollsChoice> choices,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _pollsQuestionLocalService.updateQuestion(userId, questionId,
			titleMap, descriptionMap, expirationDateMonth, expirationDateDay,
			expirationDateYear, expirationDateHour, expirationDateMinute,
			neverExpire, choices, serviceContext);
	}

	public PollsQuestionLocalService getWrappedPollsQuestionLocalService() {
		return _pollsQuestionLocalService;
	}

	private PollsQuestionLocalService _pollsQuestionLocalService;
}