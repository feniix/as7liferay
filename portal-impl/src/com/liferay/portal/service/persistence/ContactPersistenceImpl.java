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

package com.liferay.portal.service.persistence;

import com.liferay.portal.NoSuchContactException;
import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Contact;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.model.impl.ContactImpl;
import com.liferay.portal.model.impl.ContactModelImpl;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the contact service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link ContactUtil} to access the contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ContactPersistence
 * @see ContactUtil
 * @generated
 */
public class ContactPersistenceImpl extends BasePersistenceImpl<Contact>
	implements ContactPersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ContactImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_COMPANYID = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
			ContactModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
			ContactModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByCompanyId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
			ContactModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ContactModelImpl.ENTITY_CACHE_ENABLED,
			ContactModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the contact in the entity cache if it is enabled.
	 *
	 * @param contact the contact to cache
	 */
	public void cacheResult(Contact contact) {
		EntityCacheUtil.putResult(ContactModelImpl.ENTITY_CACHE_ENABLED,
			ContactImpl.class, contact.getPrimaryKey(), contact);
	}

	/**
	 * Caches the contacts in the entity cache if it is enabled.
	 *
	 * @param contacts the contacts to cache
	 */
	public void cacheResult(List<Contact> contacts) {
		for (Contact contact : contacts) {
			if (EntityCacheUtil.getResult(
						ContactModelImpl.ENTITY_CACHE_ENABLED,
						ContactImpl.class, contact.getPrimaryKey(), this) == null) {
				cacheResult(contact);
			}
		}
	}

	/**
	 * Clears the cache for all contacts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(ContactImpl.class.getName());
		EntityCacheUtil.clearCache(ContactImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the contact.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(Contact contact) {
		EntityCacheUtil.removeResult(ContactModelImpl.ENTITY_CACHE_ENABLED,
			ContactImpl.class, contact.getPrimaryKey());
	}

	/**
	 * Creates a new contact with the primary key. Does not add the contact to the database.
	 *
	 * @param contactId the primary key for the new contact
	 * @return the new contact
	 */
	public Contact create(long contactId) {
		Contact contact = new ContactImpl();

		contact.setNew(true);
		contact.setPrimaryKey(contactId);

		return contact;
	}

	/**
	 * Removes the contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the contact to remove
	 * @return the contact that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contact remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the contact with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param contactId the primary key of the contact to remove
	 * @return the contact that was removed
	 * @throws com.liferay.portal.NoSuchContactException if a contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contact remove(long contactId)
		throws NoSuchContactException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Contact contact = (Contact)session.get(ContactImpl.class,
					new Long(contactId));

			if (contact == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + contactId);
				}

				throw new NoSuchContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					contactId);
			}

			return remove(contact);
		}
		catch (NoSuchContactException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Contact removeImpl(Contact contact) throws SystemException {
		contact = toUnwrappedModel(contact);

		Session session = null;

		try {
			session = openSession();

			if (contact.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ContactImpl.class,
						contact.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(contact);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.removeResult(ContactModelImpl.ENTITY_CACHE_ENABLED,
			ContactImpl.class, contact.getPrimaryKey());

		return contact;
	}

	public Contact updateImpl(com.liferay.portal.model.Contact contact,
		boolean merge) throws SystemException {
		contact = toUnwrappedModel(contact);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, contact, merge);

			contact.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ContactModelImpl.ENTITY_CACHE_ENABLED,
			ContactImpl.class, contact.getPrimaryKey(), contact);

		return contact;
	}

	protected Contact toUnwrappedModel(Contact contact) {
		if (contact instanceof ContactImpl) {
			return contact;
		}

		ContactImpl contactImpl = new ContactImpl();

		contactImpl.setNew(contact.isNew());
		contactImpl.setPrimaryKey(contact.getPrimaryKey());

		contactImpl.setContactId(contact.getContactId());
		contactImpl.setCompanyId(contact.getCompanyId());
		contactImpl.setUserId(contact.getUserId());
		contactImpl.setUserName(contact.getUserName());
		contactImpl.setCreateDate(contact.getCreateDate());
		contactImpl.setModifiedDate(contact.getModifiedDate());
		contactImpl.setAccountId(contact.getAccountId());
		contactImpl.setParentContactId(contact.getParentContactId());
		contactImpl.setFirstName(contact.getFirstName());
		contactImpl.setMiddleName(contact.getMiddleName());
		contactImpl.setLastName(contact.getLastName());
		contactImpl.setPrefixId(contact.getPrefixId());
		contactImpl.setSuffixId(contact.getSuffixId());
		contactImpl.setMale(contact.isMale());
		contactImpl.setBirthday(contact.getBirthday());
		contactImpl.setSmsSn(contact.getSmsSn());
		contactImpl.setAimSn(contact.getAimSn());
		contactImpl.setFacebookSn(contact.getFacebookSn());
		contactImpl.setIcqSn(contact.getIcqSn());
		contactImpl.setJabberSn(contact.getJabberSn());
		contactImpl.setMsnSn(contact.getMsnSn());
		contactImpl.setMySpaceSn(contact.getMySpaceSn());
		contactImpl.setSkypeSn(contact.getSkypeSn());
		contactImpl.setTwitterSn(contact.getTwitterSn());
		contactImpl.setYmSn(contact.getYmSn());
		contactImpl.setEmployeeStatusId(contact.getEmployeeStatusId());
		contactImpl.setEmployeeNumber(contact.getEmployeeNumber());
		contactImpl.setJobTitle(contact.getJobTitle());
		contactImpl.setJobClass(contact.getJobClass());
		contactImpl.setHoursOfOperation(contact.getHoursOfOperation());

		return contactImpl;
	}

	/**
	 * Finds the contact with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact to find
	 * @return the contact
	 * @throws com.liferay.portal.NoSuchModelException if a contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contact findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the contact with the primary key or throws a {@link com.liferay.portal.NoSuchContactException} if it could not be found.
	 *
	 * @param contactId the primary key of the contact to find
	 * @return the contact
	 * @throws com.liferay.portal.NoSuchContactException if a contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contact findByPrimaryKey(long contactId)
		throws NoSuchContactException, SystemException {
		Contact contact = fetchByPrimaryKey(contactId);

		if (contact == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + contactId);
			}

			throw new NoSuchContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				contactId);
		}

		return contact;
	}

	/**
	 * Finds the contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the contact to find
	 * @return the contact, or <code>null</code> if a contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contact fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the contact with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param contactId the primary key of the contact to find
	 * @return the contact, or <code>null</code> if a contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contact fetchByPrimaryKey(long contactId) throws SystemException {
		Contact contact = (Contact)EntityCacheUtil.getResult(ContactModelImpl.ENTITY_CACHE_ENABLED,
				ContactImpl.class, contactId, this);

		if (contact == null) {
			Session session = null;

			try {
				session = openSession();

				contact = (Contact)session.get(ContactImpl.class,
						new Long(contactId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (contact != null) {
					cacheResult(contact);
				}

				closeSession(session);
			}
		}

		return contact;
	}

	/**
	 * Finds all the contacts where companyId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @return the matching contacts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contact> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Finds a range of all the contacts where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param start the lower bound of the range of contacts to return
	 * @param end the upper bound of the range of contacts to return (not inclusive)
	 * @return the range of matching contacts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contact> findByCompanyId(long companyId, int start, int end)
		throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the contacts where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param start the lower bound of the range of contacts to return
	 * @param end the upper bound of the range of contacts to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching contacts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contact> findByCompanyId(long companyId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				companyId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Contact> list = (List<Contact>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_COMPANYID,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(3 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(2);
				}

				query.append(_SQL_SELECT_CONTACT_WHERE);

				query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				list = (List<Contact>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Contact>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_COMPANYID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first contact in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching contact
	 * @throws com.liferay.portal.NoSuchContactException if a matching contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contact findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchContactException, SystemException {
		List<Contact> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchContactException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last contact in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param companyId the company id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching contact
	 * @throws com.liferay.portal.NoSuchContactException if a matching contact could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contact findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchContactException, SystemException {
		int count = countByCompanyId(companyId);

		List<Contact> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchContactException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the contacts before and after the current contact in the ordered set where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param contactId the primary key of the current contact
	 * @param companyId the company id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next contact
	 * @throws com.liferay.portal.NoSuchContactException if a contact with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Contact[] findByCompanyId_PrevAndNext(long contactId,
		long companyId, OrderByComparator orderByComparator)
		throws NoSuchContactException, SystemException {
		Contact contact = findByPrimaryKey(contactId);

		Session session = null;

		try {
			session = openSession();

			Contact[] array = new ContactImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, contact, companyId,
					orderByComparator, true);

			array[1] = contact;

			array[2] = getByCompanyId_PrevAndNext(session, contact, companyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Contact getByCompanyId_PrevAndNext(Session session,
		Contact contact, long companyId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CONTACT_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByFields = orderByComparator.getOrderByFields();

			if (orderByFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(contact);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Contact> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the contacts.
	 *
	 * @return the contacts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contact> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of contacts to return
	 * @param end the upper bound of the range of contacts to return (not inclusive)
	 * @return the range of contacts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contact> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the contacts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of contacts to return
	 * @param end the upper bound of the range of contacts to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of contacts
	 * @throws SystemException if a system exception occurred
	 */
	public List<Contact> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<Contact> list = (List<Contact>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;
				String sql = null;

				if (orderByComparator != null) {
					query = new StringBundler(2 +
							(orderByComparator.getOrderByFields().length * 3));

					query.append(_SQL_SELECT_CONTACT);

					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);

					sql = query.toString();
				}
				else {
					sql = _SQL_SELECT_CONTACT;
				}

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Contact>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Contact>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<Contact>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the contacts where companyId = &#63; from the database.
	 *
	 * @param companyId the company id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByCompanyId(long companyId) throws SystemException {
		for (Contact contact : findByCompanyId(companyId)) {
			remove(contact);
		}
	}

	/**
	 * Removes all the contacts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Contact contact : findAll()) {
			remove(contact);
		}
	}

	/**
	 * Counts all the contacts where companyId = &#63;.
	 *
	 * @param companyId the company id to search with
	 * @return the number of matching contacts
	 * @throws SystemException if a system exception occurred
	 */
	public int countByCompanyId(long companyId) throws SystemException {
		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COMPANYID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_CONTACT_WHERE);

				query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COMPANYID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the contacts.
	 *
	 * @return the number of contacts
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Object[] finderArgs = new Object[0];

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CONTACT);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the contact persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.portal.util.PropsUtil.get(
						"value.object.listener.com.liferay.portal.model.Contact")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Contact>> listenersList = new ArrayList<ModelListener<Contact>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Contact>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(type = AccountPersistence.class)
	protected AccountPersistence accountPersistence;
	@BeanReference(type = AddressPersistence.class)
	protected AddressPersistence addressPersistence;
	@BeanReference(type = BrowserTrackerPersistence.class)
	protected BrowserTrackerPersistence browserTrackerPersistence;
	@BeanReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@BeanReference(type = ClusterGroupPersistence.class)
	protected ClusterGroupPersistence clusterGroupPersistence;
	@BeanReference(type = CompanyPersistence.class)
	protected CompanyPersistence companyPersistence;
	@BeanReference(type = ContactPersistence.class)
	protected ContactPersistence contactPersistence;
	@BeanReference(type = CountryPersistence.class)
	protected CountryPersistence countryPersistence;
	@BeanReference(type = EmailAddressPersistence.class)
	protected EmailAddressPersistence emailAddressPersistence;
	@BeanReference(type = GroupPersistence.class)
	protected GroupPersistence groupPersistence;
	@BeanReference(type = ImagePersistence.class)
	protected ImagePersistence imagePersistence;
	@BeanReference(type = LayoutPersistence.class)
	protected LayoutPersistence layoutPersistence;
	@BeanReference(type = LayoutPrototypePersistence.class)
	protected LayoutPrototypePersistence layoutPrototypePersistence;
	@BeanReference(type = LayoutSetPersistence.class)
	protected LayoutSetPersistence layoutSetPersistence;
	@BeanReference(type = LayoutSetPrototypePersistence.class)
	protected LayoutSetPrototypePersistence layoutSetPrototypePersistence;
	@BeanReference(type = ListTypePersistence.class)
	protected ListTypePersistence listTypePersistence;
	@BeanReference(type = LockPersistence.class)
	protected LockPersistence lockPersistence;
	@BeanReference(type = MembershipRequestPersistence.class)
	protected MembershipRequestPersistence membershipRequestPersistence;
	@BeanReference(type = OrganizationPersistence.class)
	protected OrganizationPersistence organizationPersistence;
	@BeanReference(type = OrgGroupPermissionPersistence.class)
	protected OrgGroupPermissionPersistence orgGroupPermissionPersistence;
	@BeanReference(type = OrgGroupRolePersistence.class)
	protected OrgGroupRolePersistence orgGroupRolePersistence;
	@BeanReference(type = OrgLaborPersistence.class)
	protected OrgLaborPersistence orgLaborPersistence;
	@BeanReference(type = PasswordPolicyPersistence.class)
	protected PasswordPolicyPersistence passwordPolicyPersistence;
	@BeanReference(type = PasswordPolicyRelPersistence.class)
	protected PasswordPolicyRelPersistence passwordPolicyRelPersistence;
	@BeanReference(type = PasswordTrackerPersistence.class)
	protected PasswordTrackerPersistence passwordTrackerPersistence;
	@BeanReference(type = PermissionPersistence.class)
	protected PermissionPersistence permissionPersistence;
	@BeanReference(type = PhonePersistence.class)
	protected PhonePersistence phonePersistence;
	@BeanReference(type = PluginSettingPersistence.class)
	protected PluginSettingPersistence pluginSettingPersistence;
	@BeanReference(type = PortletPersistence.class)
	protected PortletPersistence portletPersistence;
	@BeanReference(type = PortletItemPersistence.class)
	protected PortletItemPersistence portletItemPersistence;
	@BeanReference(type = PortletPreferencesPersistence.class)
	protected PortletPreferencesPersistence portletPreferencesPersistence;
	@BeanReference(type = RegionPersistence.class)
	protected RegionPersistence regionPersistence;
	@BeanReference(type = ReleasePersistence.class)
	protected ReleasePersistence releasePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = ResourceActionPersistence.class)
	protected ResourceActionPersistence resourceActionPersistence;
	@BeanReference(type = ResourceCodePersistence.class)
	protected ResourceCodePersistence resourceCodePersistence;
	@BeanReference(type = ResourcePermissionPersistence.class)
	protected ResourcePermissionPersistence resourcePermissionPersistence;
	@BeanReference(type = RolePersistence.class)
	protected RolePersistence rolePersistence;
	@BeanReference(type = ServiceComponentPersistence.class)
	protected ServiceComponentPersistence serviceComponentPersistence;
	@BeanReference(type = ShardPersistence.class)
	protected ShardPersistence shardPersistence;
	@BeanReference(type = SubscriptionPersistence.class)
	protected SubscriptionPersistence subscriptionPersistence;
	@BeanReference(type = TicketPersistence.class)
	protected TicketPersistence ticketPersistence;
	@BeanReference(type = TeamPersistence.class)
	protected TeamPersistence teamPersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@BeanReference(type = UserGroupPersistence.class)
	protected UserGroupPersistence userGroupPersistence;
	@BeanReference(type = UserGroupGroupRolePersistence.class)
	protected UserGroupGroupRolePersistence userGroupGroupRolePersistence;
	@BeanReference(type = UserGroupRolePersistence.class)
	protected UserGroupRolePersistence userGroupRolePersistence;
	@BeanReference(type = UserIdMapperPersistence.class)
	protected UserIdMapperPersistence userIdMapperPersistence;
	@BeanReference(type = UserTrackerPersistence.class)
	protected UserTrackerPersistence userTrackerPersistence;
	@BeanReference(type = UserTrackerPathPersistence.class)
	protected UserTrackerPathPersistence userTrackerPathPersistence;
	@BeanReference(type = WebDAVPropsPersistence.class)
	protected WebDAVPropsPersistence webDAVPropsPersistence;
	@BeanReference(type = WebsitePersistence.class)
	protected WebsitePersistence websitePersistence;
	@BeanReference(type = WorkflowDefinitionLinkPersistence.class)
	protected WorkflowDefinitionLinkPersistence workflowDefinitionLinkPersistence;
	@BeanReference(type = WorkflowInstanceLinkPersistence.class)
	protected WorkflowInstanceLinkPersistence workflowInstanceLinkPersistence;
	private static final String _SQL_SELECT_CONTACT = "SELECT contact FROM Contact contact";
	private static final String _SQL_SELECT_CONTACT_WHERE = "SELECT contact FROM Contact contact WHERE ";
	private static final String _SQL_COUNT_CONTACT = "SELECT COUNT(contact) FROM Contact contact";
	private static final String _SQL_COUNT_CONTACT_WHERE = "SELECT COUNT(contact) FROM Contact contact WHERE ";
	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "contact.companyId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "contact.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Contact exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Contact exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(ContactPersistenceImpl.class);
}