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

package com.liferay.portal.service.persistence.impl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.dao.orm.Dialect;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextThreadLocal;
import com.liferay.portal.service.persistence.BasePersistence;

import java.io.Serializable;

import java.sql.Connection;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation for all persistence classes. This class should never
 * need to be used directly.
 *
 * <p>
 * Caching information and settings can be found in
 * <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @author Shuyang Zhou
 */
public class BasePersistenceImpl<T extends BaseModel<T>>
	implements BasePersistence<T>, SessionFactory {

	public static final String COUNT_COLUMN_NAME = "COUNT_VALUE";

	public void clearCache() {
	}

	public void clearCache(T model) {
	}

	public void closeSession(Session session) {
		_sessionFactory.closeSession(session);
	}

	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {

		dynamicQuery.setProjection(ProjectionFactoryUtil.rowCount());

		List<Long> results = findWithDynamicQuery(dynamicQuery);

		if (results.isEmpty()) {
			return 0;
		}
		else {
			return (results.get(0)).longValue();
		}
	}

	/**
	 * @throws SystemException
	 */
	public T fetchByPrimaryKey(Serializable primaryKey) throws SystemException {
		throw new UnsupportedOperationException();
	}

	/**
	 * @throws NoSuchModelException
	 * @throws SystemException
	 */
	public T findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {

		throw new UnsupportedOperationException();
	}

	@SuppressWarnings("rawtypes")
	public List findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			dynamicQuery.compile(session);

			return dynamicQuery.list();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@SuppressWarnings("rawtypes")
	public List findWithDynamicQuery(
			DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {

		Session session = null;

		try {
			session = openSession();

			dynamicQuery.setLimit(start, end);

			dynamicQuery.compile(session);

			return dynamicQuery.list();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@SuppressWarnings("rawtypes")
	public List findWithDynamicQuery(
			DynamicQuery dynamicQuery, int start, int end,
			OrderByComparator orderByComparator)
		throws SystemException {

		OrderFactoryUtil.addOrderByComparator(dynamicQuery, orderByComparator);

		return findWithDynamicQuery(dynamicQuery, start, end);
	}

	public DataSource getDataSource() {
		return _dataSource;
	}

	public Dialect getDialect() {
		return _dialect;
	}

	public ModelListener<T>[] getListeners() {
		return listeners;
	}

	public Session openNewSession(Connection connection) throws ORMException {
		return _sessionFactory.openNewSession(connection);
	}

	public Session openSession() throws ORMException {
		return _sessionFactory.openSession();
	}

	public SystemException processException(Exception e) {
		if (!(e instanceof ORMException)) {
			_log.error("Caught unexpected exception " + e.getClass().getName());
		}

		if (_log.isDebugEnabled()) {
			_log.debug(e, e);
		}

		return new SystemException(e);
	}

	public void registerListener(ModelListener<T> listener) {
		List<ModelListener<T>> listenersList = ListUtil.fromArray(listeners);

		listenersList.add(listener);

		listeners = listenersList.toArray(
			new ModelListener[listenersList.size()]);
	}

	/**
	 * @throws NoSuchModelException
	 * @throws SystemException
	 */
	public T remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {

		throw new UnsupportedOperationException();
	}

	public T remove(T model) throws SystemException {
		for (ModelListener<T> listener : listeners) {
			listener.onBeforeRemove(model);
		}

		model = removeImpl(model);

		for (ModelListener<T> listener : listeners) {
			listener.onAfterRemove(model);
		}

		return model;
	}

	public void setDataSource(DataSource dataSource) {
		_dataSource = dataSource;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		_sessionFactory = sessionFactory;
		_dialect = _sessionFactory.getDialect();
	}

	public void unregisterListener(ModelListener<T> listener) {
		List<ModelListener<T>> listenersList = ListUtil.fromArray(listeners);

		ListUtil.remove(listenersList, listener);

		listeners = listenersList.toArray(
			new ModelListener[listenersList.size()]);
	}

	public T update(T model, boolean merge) throws SystemException {
		boolean isNew = model.isNew();

		for (ModelListener<T> listener : listeners) {
			if (isNew) {
				listener.onBeforeCreate(model);
			}
			else {
				listener.onBeforeUpdate(model);
			}
		}

		model = updateImpl(model, merge);

		for (ModelListener<T> listener : listeners) {
			if (isNew) {
				listener.onAfterCreate(model);
			}
			else {
				listener.onAfterUpdate(model);
			}
		}

		return model;
	}

	public T update(T model, boolean merge, ServiceContext serviceContext)
		throws SystemException {

		ServiceContext previousServiceContext =
			ServiceContextThreadLocal.getServiceContext();

		try {
			ServiceContextThreadLocal.setServiceContext(serviceContext);

			update(model, merge);

			return model;
		}
		finally {
			ServiceContextThreadLocal.setServiceContext(previousServiceContext);
		}
	}

	protected void appendOrderByComparator(
		StringBundler query, String entityAlias,
		OrderByComparator orderByComparator) {

		query.append(ORDER_BY_CLAUSE);

		String[] orderByFields = orderByComparator.getOrderByFields();

		for (int i = 0; i < orderByFields.length; i++) {
			query.append(entityAlias);
			query.append(orderByFields[i]);

			if ((i + 1) < orderByFields.length) {
				if (orderByComparator.isAscending()) {
					query.append(ORDER_BY_ASC_HAS_NEXT);
				}
				else {
					query.append(ORDER_BY_DESC_HAS_NEXT);
				}
			}
			else {
				if (orderByComparator.isAscending()) {
					query.append(ORDER_BY_ASC);
				}
				else {
					query.append(ORDER_BY_DESC);
				}
			}
		}
	}

	/**
	 * Removes the model instance from the database. {@link #update(BaseModel,
	 * boolean)} depends on this method to implement the remove operation; it
	 * only notifies the model listeners.
	 *
	 * @param  model the model instance to remove
	 * @return the model instance that was removed
	 * @throws SystemException if a system exception occurred
	 */
	protected T removeImpl(T model) throws SystemException {
		throw new UnsupportedOperationException();
	}

	/**
	 * Updates the model instance in the database or adds it if it does not yet
	 * exist. {@link #remove(BaseModel)} depends on this method to implement the
	 * update operation; it only notifies the model listeners.
	 *
	 * @param  model the model instance to update
	 * @param  merge whether to merge the model instance with the current
	 *		   session. See {@link
	 *		   com.liferay.portal.service.persistence.BatchSession#update(
	 *		   com.liferay.portal.kernel.dao.orm.Session, BaseModel, boolean)}
	 *		   for an explanation.
	 * @return the model instance that was updated
	 * @throws SystemException if a system exception occurred
	 */
	protected T updateImpl(T model, boolean merge) throws SystemException {
		throw new UnsupportedOperationException();
	}

	protected static final String ORDER_BY_ASC = " ASC";

	protected static final String ORDER_BY_ASC_HAS_NEXT = " ASC, ";

	protected static final String ORDER_BY_CLAUSE = " ORDER BY ";

	protected static final String ORDER_BY_DESC = " DESC";

	protected static final String ORDER_BY_DESC_HAS_NEXT = " DESC, ";

	protected static final String WHERE_AND = " AND ";

	protected static final String WHERE_LESSER_THAN = " <= ? ";

	protected static final String WHERE_LESSER_THAN_HAS_NEXT = " <= ? AND ";

	protected static final String WHERE_GREATER_THAN = " >= ? ";

	protected static final String WHERE_GREATER_THAN_HAS_NEXT = " >= ? AND ";

	protected static final String WHERE_OR = " OR ";

	protected ModelListener<T>[] listeners = new ModelListener[0];

	private static Log _log = LogFactoryUtil.getLog(BasePersistenceImpl.class);

	private DataSource _dataSource;
	private Dialect _dialect;
	private SessionFactory _sessionFactory;

}