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

package com.liferay.portlet.expando.service.persistence;

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
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.expando.NoSuchValueException;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.model.impl.ExpandoValueImpl;
import com.liferay.portlet.expando.model.impl.ExpandoValueModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the expando value service.
 *
 * <p>
 * Never modify or reference this class directly. Always use {@link ExpandoValueUtil} to access the expando value persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
 * </p>
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExpandoValuePersistence
 * @see ExpandoValueUtil
 * @generated
 */
public class ExpandoValuePersistenceImpl extends BasePersistenceImpl<ExpandoValue>
	implements ExpandoValuePersistence {
	public static final String FINDER_CLASS_NAME_ENTITY = ExpandoValueImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST = FINDER_CLASS_NAME_ENTITY +
		".List";
	public static final FinderPath FINDER_PATH_FIND_BY_TABLEID = new FinderPath(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
			ExpandoValueModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByTableId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_TABLEID = new FinderPath(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
			ExpandoValueModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByTableId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_COLUMNID = new FinderPath(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
			ExpandoValueModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByColumnId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_COLUMNID = new FinderPath(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
			ExpandoValueModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByColumnId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_ROWID = new FinderPath(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
			ExpandoValueModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByRowId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_ROWID = new FinderPath(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
			ExpandoValueModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByRowId", new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_T_C = new FinderPath(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
			ExpandoValueModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByT_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_T_C = new FinderPath(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
			ExpandoValueModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByT_C",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_T_CPK = new FinderPath(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
			ExpandoValueModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByT_CPK",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_T_CPK = new FinderPath(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
			ExpandoValueModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByT_CPK",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_T_R = new FinderPath(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
			ExpandoValueModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByT_R",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_T_R = new FinderPath(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
			ExpandoValueModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByT_R",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_C_R = new FinderPath(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
			ExpandoValueModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_R",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_COUNT_BY_C_R = new FinderPath(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
			ExpandoValueModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByC_R",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FIND_BY_C_C = new FinderPath(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
			ExpandoValueModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByC_C",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C = new FinderPath(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
			ExpandoValueModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByC_C",
			new String[] { Long.class.getName(), Long.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_T_C_C = new FinderPath(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
			ExpandoValueModelImpl.FINDER_CACHE_ENABLED,
			FINDER_CLASS_NAME_ENTITY, "fetchByT_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_T_C_C = new FinderPath(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
			ExpandoValueModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByT_C_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});
	public static final FinderPath FINDER_PATH_FIND_BY_T_C_D = new FinderPath(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
			ExpandoValueModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findByT_C_D",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_COUNT_BY_T_C_D = new FinderPath(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
			ExpandoValueModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countByT_C_D",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});
	public static final FinderPath FINDER_PATH_FIND_ALL = new FinderPath(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
			ExpandoValueModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
			ExpandoValueModelImpl.FINDER_CACHE_ENABLED, FINDER_CLASS_NAME_LIST,
			"countAll", new String[0]);

	/**
	 * Caches the expando value in the entity cache if it is enabled.
	 *
	 * @param expandoValue the expando value to cache
	 */
	public void cacheResult(ExpandoValue expandoValue) {
		EntityCacheUtil.putResult(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
			ExpandoValueImpl.class, expandoValue.getPrimaryKey(), expandoValue);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_R,
			new Object[] {
				new Long(expandoValue.getColumnId()),
				new Long(expandoValue.getRowId())
			}, expandoValue);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_T_C_C,
			new Object[] {
				new Long(expandoValue.getTableId()),
				new Long(expandoValue.getColumnId()),
				new Long(expandoValue.getClassPK())
			}, expandoValue);
	}

	/**
	 * Caches the expando values in the entity cache if it is enabled.
	 *
	 * @param expandoValues the expando values to cache
	 */
	public void cacheResult(List<ExpandoValue> expandoValues) {
		for (ExpandoValue expandoValue : expandoValues) {
			if (EntityCacheUtil.getResult(
						ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
						ExpandoValueImpl.class, expandoValue.getPrimaryKey(),
						this) == null) {
				cacheResult(expandoValue);
			}
		}
	}

	/**
	 * Clears the cache for all expando values.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache() {
		CacheRegistryUtil.clear(ExpandoValueImpl.class.getName());
		EntityCacheUtil.clearCache(ExpandoValueImpl.class.getName());
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);
	}

	/**
	 * Clears the cache for the expando value.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	public void clearCache(ExpandoValue expandoValue) {
		EntityCacheUtil.removeResult(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
			ExpandoValueImpl.class, expandoValue.getPrimaryKey());

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_R,
			new Object[] {
				new Long(expandoValue.getColumnId()),
				new Long(expandoValue.getRowId())
			});

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_T_C_C,
			new Object[] {
				new Long(expandoValue.getTableId()),
				new Long(expandoValue.getColumnId()),
				new Long(expandoValue.getClassPK())
			});
	}

	/**
	 * Creates a new expando value with the primary key. Does not add the expando value to the database.
	 *
	 * @param valueId the primary key for the new expando value
	 * @return the new expando value
	 */
	public ExpandoValue create(long valueId) {
		ExpandoValue expandoValue = new ExpandoValueImpl();

		expandoValue.setNew(true);
		expandoValue.setPrimaryKey(valueId);

		return expandoValue;
	}

	/**
	 * Removes the expando value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the expando value to remove
	 * @return the expando value that was removed
	 * @throws com.liferay.portal.NoSuchModelException if a expando value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue remove(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return remove(((Long)primaryKey).longValue());
	}

	/**
	 * Removes the expando value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param valueId the primary key of the expando value to remove
	 * @return the expando value that was removed
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a expando value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue remove(long valueId)
		throws NoSuchValueException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ExpandoValue expandoValue = (ExpandoValue)session.get(ExpandoValueImpl.class,
					new Long(valueId));

			if (expandoValue == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + valueId);
				}

				throw new NoSuchValueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					valueId);
			}

			return remove(expandoValue);
		}
		catch (NoSuchValueException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ExpandoValue removeImpl(ExpandoValue expandoValue)
		throws SystemException {
		expandoValue = toUnwrappedModel(expandoValue);

		Session session = null;

		try {
			session = openSession();

			if (expandoValue.isCachedModel() || BatchSessionUtil.isEnabled()) {
				Object staleObject = session.get(ExpandoValueImpl.class,
						expandoValue.getPrimaryKeyObj());

				if (staleObject != null) {
					session.evict(staleObject);
				}
			}

			session.delete(expandoValue);

			session.flush();
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		ExpandoValueModelImpl expandoValueModelImpl = (ExpandoValueModelImpl)expandoValue;

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_R,
			new Object[] {
				new Long(expandoValueModelImpl.getOriginalColumnId()),
				new Long(expandoValueModelImpl.getOriginalRowId())
			});

		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_T_C_C,
			new Object[] {
				new Long(expandoValueModelImpl.getOriginalTableId()),
				new Long(expandoValueModelImpl.getOriginalColumnId()),
				new Long(expandoValueModelImpl.getOriginalClassPK())
			});

		EntityCacheUtil.removeResult(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
			ExpandoValueImpl.class, expandoValue.getPrimaryKey());

		return expandoValue;
	}

	public ExpandoValue updateImpl(
		com.liferay.portlet.expando.model.ExpandoValue expandoValue,
		boolean merge) throws SystemException {
		expandoValue = toUnwrappedModel(expandoValue);

		boolean isNew = expandoValue.isNew();

		ExpandoValueModelImpl expandoValueModelImpl = (ExpandoValueModelImpl)expandoValue;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, expandoValue, merge);

			expandoValue.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST);

		EntityCacheUtil.putResult(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
			ExpandoValueImpl.class, expandoValue.getPrimaryKey(), expandoValue);

		if (!isNew &&
				((expandoValue.getColumnId() != expandoValueModelImpl.getOriginalColumnId()) ||
				(expandoValue.getRowId() != expandoValueModelImpl.getOriginalRowId()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_C_R,
				new Object[] {
					new Long(expandoValueModelImpl.getOriginalColumnId()),
					new Long(expandoValueModelImpl.getOriginalRowId())
				});
		}

		if (isNew ||
				((expandoValue.getColumnId() != expandoValueModelImpl.getOriginalColumnId()) ||
				(expandoValue.getRowId() != expandoValueModelImpl.getOriginalRowId()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_R,
				new Object[] {
					new Long(expandoValue.getColumnId()),
					new Long(expandoValue.getRowId())
				}, expandoValue);
		}

		if (!isNew &&
				((expandoValue.getTableId() != expandoValueModelImpl.getOriginalTableId()) ||
				(expandoValue.getColumnId() != expandoValueModelImpl.getOriginalColumnId()) ||
				(expandoValue.getClassPK() != expandoValueModelImpl.getOriginalClassPK()))) {
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_T_C_C,
				new Object[] {
					new Long(expandoValueModelImpl.getOriginalTableId()),
					new Long(expandoValueModelImpl.getOriginalColumnId()),
					new Long(expandoValueModelImpl.getOriginalClassPK())
				});
		}

		if (isNew ||
				((expandoValue.getTableId() != expandoValueModelImpl.getOriginalTableId()) ||
				(expandoValue.getColumnId() != expandoValueModelImpl.getOriginalColumnId()) ||
				(expandoValue.getClassPK() != expandoValueModelImpl.getOriginalClassPK()))) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_T_C_C,
				new Object[] {
					new Long(expandoValue.getTableId()),
					new Long(expandoValue.getColumnId()),
					new Long(expandoValue.getClassPK())
				}, expandoValue);
		}

		return expandoValue;
	}

	protected ExpandoValue toUnwrappedModel(ExpandoValue expandoValue) {
		if (expandoValue instanceof ExpandoValueImpl) {
			return expandoValue;
		}

		ExpandoValueImpl expandoValueImpl = new ExpandoValueImpl();

		expandoValueImpl.setNew(expandoValue.isNew());
		expandoValueImpl.setPrimaryKey(expandoValue.getPrimaryKey());

		expandoValueImpl.setValueId(expandoValue.getValueId());
		expandoValueImpl.setCompanyId(expandoValue.getCompanyId());
		expandoValueImpl.setTableId(expandoValue.getTableId());
		expandoValueImpl.setColumnId(expandoValue.getColumnId());
		expandoValueImpl.setRowId(expandoValue.getRowId());
		expandoValueImpl.setClassNameId(expandoValue.getClassNameId());
		expandoValueImpl.setClassPK(expandoValue.getClassPK());
		expandoValueImpl.setData(expandoValue.getData());

		return expandoValueImpl;
	}

	/**
	 * Finds the expando value with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the expando value to find
	 * @return the expando value
	 * @throws com.liferay.portal.NoSuchModelException if a expando value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the expando value with the primary key or throws a {@link com.liferay.portlet.expando.NoSuchValueException} if it could not be found.
	 *
	 * @param valueId the primary key of the expando value to find
	 * @return the expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a expando value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue findByPrimaryKey(long valueId)
		throws NoSuchValueException, SystemException {
		ExpandoValue expandoValue = fetchByPrimaryKey(valueId);

		if (expandoValue == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + valueId);
			}

			throw new NoSuchValueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				valueId);
		}

		return expandoValue;
	}

	/**
	 * Finds the expando value with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the expando value to find
	 * @return the expando value, or <code>null</code> if a expando value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Finds the expando value with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param valueId the primary key of the expando value to find
	 * @return the expando value, or <code>null</code> if a expando value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue fetchByPrimaryKey(long valueId)
		throws SystemException {
		ExpandoValue expandoValue = (ExpandoValue)EntityCacheUtil.getResult(ExpandoValueModelImpl.ENTITY_CACHE_ENABLED,
				ExpandoValueImpl.class, valueId, this);

		if (expandoValue == null) {
			Session session = null;

			try {
				session = openSession();

				expandoValue = (ExpandoValue)session.get(ExpandoValueImpl.class,
						new Long(valueId));
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (expandoValue != null) {
					cacheResult(expandoValue);
				}

				closeSession(session);
			}
		}

		return expandoValue;
	}

	/**
	 * Finds all the expando values where tableId = &#63;.
	 *
	 * @param tableId the table id to search with
	 * @return the matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findByTableId(long tableId)
		throws SystemException {
		return findByTableId(tableId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the expando values where tableId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tableId the table id to search with
	 * @param start the lower bound of the range of expando values to return
	 * @param end the upper bound of the range of expando values to return (not inclusive)
	 * @return the range of matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findByTableId(long tableId, int start, int end)
		throws SystemException {
		return findByTableId(tableId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the expando values where tableId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tableId the table id to search with
	 * @param start the lower bound of the range of expando values to return
	 * @param end the upper bound of the range of expando values to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findByTableId(long tableId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				tableId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ExpandoValue> list = (List<ExpandoValue>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_TABLEID,
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
					query = new StringBundler(3);
				}

				query.append(_SQL_SELECT_EXPANDOVALUE_WHERE);

				query.append(_FINDER_COLUMN_TABLEID_TABLEID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(ExpandoValueModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tableId);

				list = (List<ExpandoValue>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ExpandoValue>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_TABLEID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first expando value in the ordered set where tableId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tableId the table id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a matching expando value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue findByTableId_First(long tableId,
		OrderByComparator orderByComparator)
		throws NoSuchValueException, SystemException {
		List<ExpandoValue> list = findByTableId(tableId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tableId=");
			msg.append(tableId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchValueException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last expando value in the ordered set where tableId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tableId the table id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a matching expando value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue findByTableId_Last(long tableId,
		OrderByComparator orderByComparator)
		throws NoSuchValueException, SystemException {
		int count = countByTableId(tableId);

		List<ExpandoValue> list = findByTableId(tableId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tableId=");
			msg.append(tableId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchValueException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the expando values before and after the current expando value in the ordered set where tableId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param valueId the primary key of the current expando value
	 * @param tableId the table id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a expando value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue[] findByTableId_PrevAndNext(long valueId, long tableId,
		OrderByComparator orderByComparator)
		throws NoSuchValueException, SystemException {
		ExpandoValue expandoValue = findByPrimaryKey(valueId);

		Session session = null;

		try {
			session = openSession();

			ExpandoValue[] array = new ExpandoValueImpl[3];

			array[0] = getByTableId_PrevAndNext(session, expandoValue, tableId,
					orderByComparator, true);

			array[1] = expandoValue;

			array[2] = getByTableId_PrevAndNext(session, expandoValue, tableId,
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

	protected ExpandoValue getByTableId_PrevAndNext(Session session,
		ExpandoValue expandoValue, long tableId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EXPANDOVALUE_WHERE);

		query.append(_FINDER_COLUMN_TABLEID_TABLEID_2);

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

		else {
			query.append(ExpandoValueModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(tableId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(expandoValue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ExpandoValue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the expando values where columnId = &#63;.
	 *
	 * @param columnId the column id to search with
	 * @return the matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findByColumnId(long columnId)
		throws SystemException {
		return findByColumnId(columnId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Finds a range of all the expando values where columnId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param columnId the column id to search with
	 * @param start the lower bound of the range of expando values to return
	 * @param end the upper bound of the range of expando values to return (not inclusive)
	 * @return the range of matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findByColumnId(long columnId, int start, int end)
		throws SystemException {
		return findByColumnId(columnId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the expando values where columnId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param columnId the column id to search with
	 * @param start the lower bound of the range of expando values to return
	 * @param end the upper bound of the range of expando values to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findByColumnId(long columnId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				columnId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ExpandoValue> list = (List<ExpandoValue>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_COLUMNID,
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
					query = new StringBundler(3);
				}

				query.append(_SQL_SELECT_EXPANDOVALUE_WHERE);

				query.append(_FINDER_COLUMN_COLUMNID_COLUMNID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(ExpandoValueModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(columnId);

				list = (List<ExpandoValue>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ExpandoValue>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_COLUMNID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first expando value in the ordered set where columnId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param columnId the column id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a matching expando value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue findByColumnId_First(long columnId,
		OrderByComparator orderByComparator)
		throws NoSuchValueException, SystemException {
		List<ExpandoValue> list = findByColumnId(columnId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("columnId=");
			msg.append(columnId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchValueException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last expando value in the ordered set where columnId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param columnId the column id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a matching expando value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue findByColumnId_Last(long columnId,
		OrderByComparator orderByComparator)
		throws NoSuchValueException, SystemException {
		int count = countByColumnId(columnId);

		List<ExpandoValue> list = findByColumnId(columnId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("columnId=");
			msg.append(columnId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchValueException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the expando values before and after the current expando value in the ordered set where columnId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param valueId the primary key of the current expando value
	 * @param columnId the column id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a expando value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue[] findByColumnId_PrevAndNext(long valueId,
		long columnId, OrderByComparator orderByComparator)
		throws NoSuchValueException, SystemException {
		ExpandoValue expandoValue = findByPrimaryKey(valueId);

		Session session = null;

		try {
			session = openSession();

			ExpandoValue[] array = new ExpandoValueImpl[3];

			array[0] = getByColumnId_PrevAndNext(session, expandoValue,
					columnId, orderByComparator, true);

			array[1] = expandoValue;

			array[2] = getByColumnId_PrevAndNext(session, expandoValue,
					columnId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ExpandoValue getByColumnId_PrevAndNext(Session session,
		ExpandoValue expandoValue, long columnId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EXPANDOVALUE_WHERE);

		query.append(_FINDER_COLUMN_COLUMNID_COLUMNID_2);

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

		else {
			query.append(ExpandoValueModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(columnId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(expandoValue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ExpandoValue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the expando values where rowId = &#63;.
	 *
	 * @param rowId the row id to search with
	 * @return the matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findByRowId(long rowId) throws SystemException {
		return findByRowId(rowId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the expando values where rowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param rowId the row id to search with
	 * @param start the lower bound of the range of expando values to return
	 * @param end the upper bound of the range of expando values to return (not inclusive)
	 * @return the range of matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findByRowId(long rowId, int start, int end)
		throws SystemException {
		return findByRowId(rowId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the expando values where rowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param rowId the row id to search with
	 * @param start the lower bound of the range of expando values to return
	 * @param end the upper bound of the range of expando values to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findByRowId(long rowId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				rowId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ExpandoValue> list = (List<ExpandoValue>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_ROWID,
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
					query = new StringBundler(3);
				}

				query.append(_SQL_SELECT_EXPANDOVALUE_WHERE);

				query.append(_FINDER_COLUMN_ROWID_ROWID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(ExpandoValueModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rowId);

				list = (List<ExpandoValue>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ExpandoValue>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_ROWID,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first expando value in the ordered set where rowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param rowId the row id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a matching expando value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue findByRowId_First(long rowId,
		OrderByComparator orderByComparator)
		throws NoSuchValueException, SystemException {
		List<ExpandoValue> list = findByRowId(rowId, 0, 1, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("rowId=");
			msg.append(rowId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchValueException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last expando value in the ordered set where rowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param rowId the row id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a matching expando value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue findByRowId_Last(long rowId,
		OrderByComparator orderByComparator)
		throws NoSuchValueException, SystemException {
		int count = countByRowId(rowId);

		List<ExpandoValue> list = findByRowId(rowId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("rowId=");
			msg.append(rowId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchValueException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the expando values before and after the current expando value in the ordered set where rowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param valueId the primary key of the current expando value
	 * @param rowId the row id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a expando value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue[] findByRowId_PrevAndNext(long valueId, long rowId,
		OrderByComparator orderByComparator)
		throws NoSuchValueException, SystemException {
		ExpandoValue expandoValue = findByPrimaryKey(valueId);

		Session session = null;

		try {
			session = openSession();

			ExpandoValue[] array = new ExpandoValueImpl[3];

			array[0] = getByRowId_PrevAndNext(session, expandoValue, rowId,
					orderByComparator, true);

			array[1] = expandoValue;

			array[2] = getByRowId_PrevAndNext(session, expandoValue, rowId,
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

	protected ExpandoValue getByRowId_PrevAndNext(Session session,
		ExpandoValue expandoValue, long rowId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EXPANDOVALUE_WHERE);

		query.append(_FINDER_COLUMN_ROWID_ROWID_2);

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

		else {
			query.append(ExpandoValueModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(rowId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(expandoValue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ExpandoValue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the expando values where tableId = &#63; and columnId = &#63;.
	 *
	 * @param tableId the table id to search with
	 * @param columnId the column id to search with
	 * @return the matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findByT_C(long tableId, long columnId)
		throws SystemException {
		return findByT_C(tableId, columnId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the expando values where tableId = &#63; and columnId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tableId the table id to search with
	 * @param columnId the column id to search with
	 * @param start the lower bound of the range of expando values to return
	 * @param end the upper bound of the range of expando values to return (not inclusive)
	 * @return the range of matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findByT_C(long tableId, long columnId, int start,
		int end) throws SystemException {
		return findByT_C(tableId, columnId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the expando values where tableId = &#63; and columnId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tableId the table id to search with
	 * @param columnId the column id to search with
	 * @param start the lower bound of the range of expando values to return
	 * @param end the upper bound of the range of expando values to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findByT_C(long tableId, long columnId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				tableId, columnId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ExpandoValue> list = (List<ExpandoValue>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_T_C,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(4 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(4);
				}

				query.append(_SQL_SELECT_EXPANDOVALUE_WHERE);

				query.append(_FINDER_COLUMN_T_C_TABLEID_2);

				query.append(_FINDER_COLUMN_T_C_COLUMNID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(ExpandoValueModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tableId);

				qPos.add(columnId);

				list = (List<ExpandoValue>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ExpandoValue>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_T_C, finderArgs,
					list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first expando value in the ordered set where tableId = &#63; and columnId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tableId the table id to search with
	 * @param columnId the column id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a matching expando value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue findByT_C_First(long tableId, long columnId,
		OrderByComparator orderByComparator)
		throws NoSuchValueException, SystemException {
		List<ExpandoValue> list = findByT_C(tableId, columnId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tableId=");
			msg.append(tableId);

			msg.append(", columnId=");
			msg.append(columnId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchValueException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last expando value in the ordered set where tableId = &#63; and columnId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tableId the table id to search with
	 * @param columnId the column id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a matching expando value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue findByT_C_Last(long tableId, long columnId,
		OrderByComparator orderByComparator)
		throws NoSuchValueException, SystemException {
		int count = countByT_C(tableId, columnId);

		List<ExpandoValue> list = findByT_C(tableId, columnId, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tableId=");
			msg.append(tableId);

			msg.append(", columnId=");
			msg.append(columnId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchValueException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the expando values before and after the current expando value in the ordered set where tableId = &#63; and columnId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param valueId the primary key of the current expando value
	 * @param tableId the table id to search with
	 * @param columnId the column id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a expando value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue[] findByT_C_PrevAndNext(long valueId, long tableId,
		long columnId, OrderByComparator orderByComparator)
		throws NoSuchValueException, SystemException {
		ExpandoValue expandoValue = findByPrimaryKey(valueId);

		Session session = null;

		try {
			session = openSession();

			ExpandoValue[] array = new ExpandoValueImpl[3];

			array[0] = getByT_C_PrevAndNext(session, expandoValue, tableId,
					columnId, orderByComparator, true);

			array[1] = expandoValue;

			array[2] = getByT_C_PrevAndNext(session, expandoValue, tableId,
					columnId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ExpandoValue getByT_C_PrevAndNext(Session session,
		ExpandoValue expandoValue, long tableId, long columnId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EXPANDOVALUE_WHERE);

		query.append(_FINDER_COLUMN_T_C_TABLEID_2);

		query.append(_FINDER_COLUMN_T_C_COLUMNID_2);

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

		else {
			query.append(ExpandoValueModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(tableId);

		qPos.add(columnId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(expandoValue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ExpandoValue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the expando values where tableId = &#63; and classPK = &#63;.
	 *
	 * @param tableId the table id to search with
	 * @param classPK the class p k to search with
	 * @return the matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findByT_CPK(long tableId, long classPK)
		throws SystemException {
		return findByT_CPK(tableId, classPK, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the expando values where tableId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tableId the table id to search with
	 * @param classPK the class p k to search with
	 * @param start the lower bound of the range of expando values to return
	 * @param end the upper bound of the range of expando values to return (not inclusive)
	 * @return the range of matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findByT_CPK(long tableId, long classPK,
		int start, int end) throws SystemException {
		return findByT_CPK(tableId, classPK, start, end, null);
	}

	/**
	 * Finds an ordered range of all the expando values where tableId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tableId the table id to search with
	 * @param classPK the class p k to search with
	 * @param start the lower bound of the range of expando values to return
	 * @param end the upper bound of the range of expando values to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findByT_CPK(long tableId, long classPK,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				tableId, classPK,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ExpandoValue> list = (List<ExpandoValue>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_T_CPK,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(4 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(4);
				}

				query.append(_SQL_SELECT_EXPANDOVALUE_WHERE);

				query.append(_FINDER_COLUMN_T_CPK_TABLEID_2);

				query.append(_FINDER_COLUMN_T_CPK_CLASSPK_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(ExpandoValueModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tableId);

				qPos.add(classPK);

				list = (List<ExpandoValue>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ExpandoValue>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_T_CPK,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first expando value in the ordered set where tableId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tableId the table id to search with
	 * @param classPK the class p k to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a matching expando value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue findByT_CPK_First(long tableId, long classPK,
		OrderByComparator orderByComparator)
		throws NoSuchValueException, SystemException {
		List<ExpandoValue> list = findByT_CPK(tableId, classPK, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tableId=");
			msg.append(tableId);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchValueException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last expando value in the ordered set where tableId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tableId the table id to search with
	 * @param classPK the class p k to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a matching expando value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue findByT_CPK_Last(long tableId, long classPK,
		OrderByComparator orderByComparator)
		throws NoSuchValueException, SystemException {
		int count = countByT_CPK(tableId, classPK);

		List<ExpandoValue> list = findByT_CPK(tableId, classPK, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tableId=");
			msg.append(tableId);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchValueException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the expando values before and after the current expando value in the ordered set where tableId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param valueId the primary key of the current expando value
	 * @param tableId the table id to search with
	 * @param classPK the class p k to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a expando value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue[] findByT_CPK_PrevAndNext(long valueId, long tableId,
		long classPK, OrderByComparator orderByComparator)
		throws NoSuchValueException, SystemException {
		ExpandoValue expandoValue = findByPrimaryKey(valueId);

		Session session = null;

		try {
			session = openSession();

			ExpandoValue[] array = new ExpandoValueImpl[3];

			array[0] = getByT_CPK_PrevAndNext(session, expandoValue, tableId,
					classPK, orderByComparator, true);

			array[1] = expandoValue;

			array[2] = getByT_CPK_PrevAndNext(session, expandoValue, tableId,
					classPK, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ExpandoValue getByT_CPK_PrevAndNext(Session session,
		ExpandoValue expandoValue, long tableId, long classPK,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EXPANDOVALUE_WHERE);

		query.append(_FINDER_COLUMN_T_CPK_TABLEID_2);

		query.append(_FINDER_COLUMN_T_CPK_CLASSPK_2);

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

		else {
			query.append(ExpandoValueModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(tableId);

		qPos.add(classPK);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(expandoValue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ExpandoValue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the expando values where tableId = &#63; and rowId = &#63;.
	 *
	 * @param tableId the table id to search with
	 * @param rowId the row id to search with
	 * @return the matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findByT_R(long tableId, long rowId)
		throws SystemException {
		return findByT_R(tableId, rowId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Finds a range of all the expando values where tableId = &#63; and rowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tableId the table id to search with
	 * @param rowId the row id to search with
	 * @param start the lower bound of the range of expando values to return
	 * @param end the upper bound of the range of expando values to return (not inclusive)
	 * @return the range of matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findByT_R(long tableId, long rowId, int start,
		int end) throws SystemException {
		return findByT_R(tableId, rowId, start, end, null);
	}

	/**
	 * Finds an ordered range of all the expando values where tableId = &#63; and rowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tableId the table id to search with
	 * @param rowId the row id to search with
	 * @param start the lower bound of the range of expando values to return
	 * @param end the upper bound of the range of expando values to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findByT_R(long tableId, long rowId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				tableId, rowId,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ExpandoValue> list = (List<ExpandoValue>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_T_R,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(4 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(4);
				}

				query.append(_SQL_SELECT_EXPANDOVALUE_WHERE);

				query.append(_FINDER_COLUMN_T_R_TABLEID_2);

				query.append(_FINDER_COLUMN_T_R_ROWID_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(ExpandoValueModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tableId);

				qPos.add(rowId);

				list = (List<ExpandoValue>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ExpandoValue>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_T_R, finderArgs,
					list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first expando value in the ordered set where tableId = &#63; and rowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tableId the table id to search with
	 * @param rowId the row id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a matching expando value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue findByT_R_First(long tableId, long rowId,
		OrderByComparator orderByComparator)
		throws NoSuchValueException, SystemException {
		List<ExpandoValue> list = findByT_R(tableId, rowId, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tableId=");
			msg.append(tableId);

			msg.append(", rowId=");
			msg.append(rowId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchValueException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last expando value in the ordered set where tableId = &#63; and rowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tableId the table id to search with
	 * @param rowId the row id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a matching expando value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue findByT_R_Last(long tableId, long rowId,
		OrderByComparator orderByComparator)
		throws NoSuchValueException, SystemException {
		int count = countByT_R(tableId, rowId);

		List<ExpandoValue> list = findByT_R(tableId, rowId, count - 1, count,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tableId=");
			msg.append(tableId);

			msg.append(", rowId=");
			msg.append(rowId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchValueException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the expando values before and after the current expando value in the ordered set where tableId = &#63; and rowId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param valueId the primary key of the current expando value
	 * @param tableId the table id to search with
	 * @param rowId the row id to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a expando value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue[] findByT_R_PrevAndNext(long valueId, long tableId,
		long rowId, OrderByComparator orderByComparator)
		throws NoSuchValueException, SystemException {
		ExpandoValue expandoValue = findByPrimaryKey(valueId);

		Session session = null;

		try {
			session = openSession();

			ExpandoValue[] array = new ExpandoValueImpl[3];

			array[0] = getByT_R_PrevAndNext(session, expandoValue, tableId,
					rowId, orderByComparator, true);

			array[1] = expandoValue;

			array[2] = getByT_R_PrevAndNext(session, expandoValue, tableId,
					rowId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ExpandoValue getByT_R_PrevAndNext(Session session,
		ExpandoValue expandoValue, long tableId, long rowId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EXPANDOVALUE_WHERE);

		query.append(_FINDER_COLUMN_T_R_TABLEID_2);

		query.append(_FINDER_COLUMN_T_R_ROWID_2);

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

		else {
			query.append(ExpandoValueModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(tableId);

		qPos.add(rowId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(expandoValue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ExpandoValue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds the expando value where columnId = &#63; and rowId = &#63; or throws a {@link com.liferay.portlet.expando.NoSuchValueException} if it could not be found.
	 *
	 * @param columnId the column id to search with
	 * @param rowId the row id to search with
	 * @return the matching expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a matching expando value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue findByC_R(long columnId, long rowId)
		throws NoSuchValueException, SystemException {
		ExpandoValue expandoValue = fetchByC_R(columnId, rowId);

		if (expandoValue == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("columnId=");
			msg.append(columnId);

			msg.append(", rowId=");
			msg.append(rowId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchValueException(msg.toString());
		}

		return expandoValue;
	}

	/**
	 * Finds the expando value where columnId = &#63; and rowId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param columnId the column id to search with
	 * @param rowId the row id to search with
	 * @return the matching expando value, or <code>null</code> if a matching expando value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue fetchByC_R(long columnId, long rowId)
		throws SystemException {
		return fetchByC_R(columnId, rowId, true);
	}

	/**
	 * Finds the expando value where columnId = &#63; and rowId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param columnId the column id to search with
	 * @param rowId the row id to search with
	 * @return the matching expando value, or <code>null</code> if a matching expando value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue fetchByC_R(long columnId, long rowId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { columnId, rowId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_C_R,
					finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(4);

				query.append(_SQL_SELECT_EXPANDOVALUE_WHERE);

				query.append(_FINDER_COLUMN_C_R_COLUMNID_2);

				query.append(_FINDER_COLUMN_C_R_ROWID_2);

				query.append(ExpandoValueModelImpl.ORDER_BY_JPQL);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(columnId);

				qPos.add(rowId);

				List<ExpandoValue> list = q.list();

				result = list;

				ExpandoValue expandoValue = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_R,
						finderArgs, list);
				}
				else {
					expandoValue = list.get(0);

					cacheResult(expandoValue);

					if ((expandoValue.getColumnId() != columnId) ||
							(expandoValue.getRowId() != rowId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_R,
							finderArgs, expandoValue);
					}
				}

				return expandoValue;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_C_R,
						finderArgs, new ArrayList<ExpandoValue>());
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (ExpandoValue)result;
			}
		}
	}

	/**
	 * Finds all the expando values where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name id to search with
	 * @param classPK the class p k to search with
	 * @return the matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findByC_C(long classNameId, long classPK)
		throws SystemException {
		return findByC_C(classNameId, classPK, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the expando values where classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param classNameId the class name id to search with
	 * @param classPK the class p k to search with
	 * @param start the lower bound of the range of expando values to return
	 * @param end the upper bound of the range of expando values to return (not inclusive)
	 * @return the range of matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findByC_C(long classNameId, long classPK,
		int start, int end) throws SystemException {
		return findByC_C(classNameId, classPK, start, end, null);
	}

	/**
	 * Finds an ordered range of all the expando values where classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param classNameId the class name id to search with
	 * @param classPK the class p k to search with
	 * @param start the lower bound of the range of expando values to return
	 * @param end the upper bound of the range of expando values to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findByC_C(long classNameId, long classPK,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				classNameId, classPK,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ExpandoValue> list = (List<ExpandoValue>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_C_C,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(4 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(4);
				}

				query.append(_SQL_SELECT_EXPANDOVALUE_WHERE);

				query.append(_FINDER_COLUMN_C_C_CLASSNAMEID_2);

				query.append(_FINDER_COLUMN_C_C_CLASSPK_2);

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(ExpandoValueModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(classPK);

				list = (List<ExpandoValue>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ExpandoValue>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_C_C, finderArgs,
					list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first expando value in the ordered set where classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param classNameId the class name id to search with
	 * @param classPK the class p k to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a matching expando value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue findByC_C_First(long classNameId, long classPK,
		OrderByComparator orderByComparator)
		throws NoSuchValueException, SystemException {
		List<ExpandoValue> list = findByC_C(classNameId, classPK, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("classNameId=");
			msg.append(classNameId);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchValueException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last expando value in the ordered set where classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param classNameId the class name id to search with
	 * @param classPK the class p k to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a matching expando value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue findByC_C_Last(long classNameId, long classPK,
		OrderByComparator orderByComparator)
		throws NoSuchValueException, SystemException {
		int count = countByC_C(classNameId, classPK);

		List<ExpandoValue> list = findByC_C(classNameId, classPK, count - 1,
				count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("classNameId=");
			msg.append(classNameId);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchValueException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the expando values before and after the current expando value in the ordered set where classNameId = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param valueId the primary key of the current expando value
	 * @param classNameId the class name id to search with
	 * @param classPK the class p k to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a expando value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue[] findByC_C_PrevAndNext(long valueId, long classNameId,
		long classPK, OrderByComparator orderByComparator)
		throws NoSuchValueException, SystemException {
		ExpandoValue expandoValue = findByPrimaryKey(valueId);

		Session session = null;

		try {
			session = openSession();

			ExpandoValue[] array = new ExpandoValueImpl[3];

			array[0] = getByC_C_PrevAndNext(session, expandoValue, classNameId,
					classPK, orderByComparator, true);

			array[1] = expandoValue;

			array[2] = getByC_C_PrevAndNext(session, expandoValue, classNameId,
					classPK, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ExpandoValue getByC_C_PrevAndNext(Session session,
		ExpandoValue expandoValue, long classNameId, long classPK,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EXPANDOVALUE_WHERE);

		query.append(_FINDER_COLUMN_C_C_CLASSNAMEID_2);

		query.append(_FINDER_COLUMN_C_C_CLASSPK_2);

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

		else {
			query.append(ExpandoValueModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(classNameId);

		qPos.add(classPK);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(expandoValue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ExpandoValue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds the expando value where tableId = &#63; and columnId = &#63; and classPK = &#63; or throws a {@link com.liferay.portlet.expando.NoSuchValueException} if it could not be found.
	 *
	 * @param tableId the table id to search with
	 * @param columnId the column id to search with
	 * @param classPK the class p k to search with
	 * @return the matching expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a matching expando value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue findByT_C_C(long tableId, long columnId, long classPK)
		throws NoSuchValueException, SystemException {
		ExpandoValue expandoValue = fetchByT_C_C(tableId, columnId, classPK);

		if (expandoValue == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tableId=");
			msg.append(tableId);

			msg.append(", columnId=");
			msg.append(columnId);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchValueException(msg.toString());
		}

		return expandoValue;
	}

	/**
	 * Finds the expando value where tableId = &#63; and columnId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param tableId the table id to search with
	 * @param columnId the column id to search with
	 * @param classPK the class p k to search with
	 * @return the matching expando value, or <code>null</code> if a matching expando value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue fetchByT_C_C(long tableId, long columnId, long classPK)
		throws SystemException {
		return fetchByT_C_C(tableId, columnId, classPK, true);
	}

	/**
	 * Finds the expando value where tableId = &#63; and columnId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param tableId the table id to search with
	 * @param columnId the column id to search with
	 * @param classPK the class p k to search with
	 * @return the matching expando value, or <code>null</code> if a matching expando value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue fetchByT_C_C(long tableId, long columnId, long classPK,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { tableId, columnId, classPK };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_T_C_C,
					finderArgs, this);
		}

		if (result == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(5);

				query.append(_SQL_SELECT_EXPANDOVALUE_WHERE);

				query.append(_FINDER_COLUMN_T_C_C_TABLEID_2);

				query.append(_FINDER_COLUMN_T_C_C_COLUMNID_2);

				query.append(_FINDER_COLUMN_T_C_C_CLASSPK_2);

				query.append(ExpandoValueModelImpl.ORDER_BY_JPQL);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tableId);

				qPos.add(columnId);

				qPos.add(classPK);

				List<ExpandoValue> list = q.list();

				result = list;

				ExpandoValue expandoValue = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_T_C_C,
						finderArgs, list);
				}
				else {
					expandoValue = list.get(0);

					cacheResult(expandoValue);

					if ((expandoValue.getTableId() != tableId) ||
							(expandoValue.getColumnId() != columnId) ||
							(expandoValue.getClassPK() != classPK)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_T_C_C,
							finderArgs, expandoValue);
					}
				}

				return expandoValue;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_T_C_C,
						finderArgs, new ArrayList<ExpandoValue>());
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (ExpandoValue)result;
			}
		}
	}

	/**
	 * Finds all the expando values where tableId = &#63; and columnId = &#63; and data = &#63;.
	 *
	 * @param tableId the table id to search with
	 * @param columnId the column id to search with
	 * @param data the data to search with
	 * @return the matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findByT_C_D(long tableId, long columnId,
		String data) throws SystemException {
		return findByT_C_D(tableId, columnId, data, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the expando values where tableId = &#63; and columnId = &#63; and data = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tableId the table id to search with
	 * @param columnId the column id to search with
	 * @param data the data to search with
	 * @param start the lower bound of the range of expando values to return
	 * @param end the upper bound of the range of expando values to return (not inclusive)
	 * @return the range of matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findByT_C_D(long tableId, long columnId,
		String data, int start, int end) throws SystemException {
		return findByT_C_D(tableId, columnId, data, start, end, null);
	}

	/**
	 * Finds an ordered range of all the expando values where tableId = &#63; and columnId = &#63; and data = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tableId the table id to search with
	 * @param columnId the column id to search with
	 * @param data the data to search with
	 * @param start the lower bound of the range of expando values to return
	 * @param end the upper bound of the range of expando values to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findByT_C_D(long tableId, long columnId,
		String data, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		Object[] finderArgs = new Object[] {
				tableId, columnId, data,
				
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ExpandoValue> list = (List<ExpandoValue>)FinderCacheUtil.getResult(FINDER_PATH_FIND_BY_T_C_D,
				finderArgs, this);

		if (list == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = null;

				if (orderByComparator != null) {
					query = new StringBundler(5 +
							(orderByComparator.getOrderByFields().length * 3));
				}
				else {
					query = new StringBundler(5);
				}

				query.append(_SQL_SELECT_EXPANDOVALUE_WHERE);

				query.append(_FINDER_COLUMN_T_C_D_TABLEID_2);

				query.append(_FINDER_COLUMN_T_C_D_COLUMNID_2);

				if (data == null) {
					query.append(_FINDER_COLUMN_T_C_D_DATA_1);
				}
				else {
					if (data.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_T_C_D_DATA_3);
					}
					else {
						query.append(_FINDER_COLUMN_T_C_D_DATA_2);
					}
				}

				if (orderByComparator != null) {
					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);
				}

				else {
					query.append(ExpandoValueModelImpl.ORDER_BY_JPQL);
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tableId);

				qPos.add(columnId);

				if (data != null) {
					qPos.add(data);
				}

				list = (List<ExpandoValue>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ExpandoValue>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_BY_T_C_D,
					finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Finds the first expando value in the ordered set where tableId = &#63; and columnId = &#63; and data = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tableId the table id to search with
	 * @param columnId the column id to search with
	 * @param data the data to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the first matching expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a matching expando value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue findByT_C_D_First(long tableId, long columnId,
		String data, OrderByComparator orderByComparator)
		throws NoSuchValueException, SystemException {
		List<ExpandoValue> list = findByT_C_D(tableId, columnId, data, 0, 1,
				orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tableId=");
			msg.append(tableId);

			msg.append(", columnId=");
			msg.append(columnId);

			msg.append(", data=");
			msg.append(data);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchValueException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the last expando value in the ordered set where tableId = &#63; and columnId = &#63; and data = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param tableId the table id to search with
	 * @param columnId the column id to search with
	 * @param data the data to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the last matching expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a matching expando value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue findByT_C_D_Last(long tableId, long columnId,
		String data, OrderByComparator orderByComparator)
		throws NoSuchValueException, SystemException {
		int count = countByT_C_D(tableId, columnId, data);

		List<ExpandoValue> list = findByT_C_D(tableId, columnId, data,
				count - 1, count, orderByComparator);

		if (list.isEmpty()) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("tableId=");
			msg.append(tableId);

			msg.append(", columnId=");
			msg.append(columnId);

			msg.append(", data=");
			msg.append(data);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			throw new NoSuchValueException(msg.toString());
		}
		else {
			return list.get(0);
		}
	}

	/**
	 * Finds the expando values before and after the current expando value in the ordered set where tableId = &#63; and columnId = &#63; and data = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param valueId the primary key of the current expando value
	 * @param tableId the table id to search with
	 * @param columnId the column id to search with
	 * @param data the data to search with
	 * @param orderByComparator the comparator to order the set by
	 * @return the previous, current, and next expando value
	 * @throws com.liferay.portlet.expando.NoSuchValueException if a expando value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ExpandoValue[] findByT_C_D_PrevAndNext(long valueId, long tableId,
		long columnId, String data, OrderByComparator orderByComparator)
		throws NoSuchValueException, SystemException {
		ExpandoValue expandoValue = findByPrimaryKey(valueId);

		Session session = null;

		try {
			session = openSession();

			ExpandoValue[] array = new ExpandoValueImpl[3];

			array[0] = getByT_C_D_PrevAndNext(session, expandoValue, tableId,
					columnId, data, orderByComparator, true);

			array[1] = expandoValue;

			array[2] = getByT_C_D_PrevAndNext(session, expandoValue, tableId,
					columnId, data, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ExpandoValue getByT_C_D_PrevAndNext(Session session,
		ExpandoValue expandoValue, long tableId, long columnId, String data,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EXPANDOVALUE_WHERE);

		query.append(_FINDER_COLUMN_T_C_D_TABLEID_2);

		query.append(_FINDER_COLUMN_T_C_D_COLUMNID_2);

		if (data == null) {
			query.append(_FINDER_COLUMN_T_C_D_DATA_1);
		}
		else {
			if (data.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_T_C_D_DATA_3);
			}
			else {
				query.append(_FINDER_COLUMN_T_C_D_DATA_2);
			}
		}

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

		else {
			query.append(ExpandoValueModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(tableId);

		qPos.add(columnId);

		if (data != null) {
			qPos.add(data);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByValues(expandoValue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ExpandoValue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Finds all the expando values.
	 *
	 * @return the expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Finds a range of all the expando values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of expando values to return
	 * @param end the upper bound of the range of expando values to return (not inclusive)
	 * @return the range of expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Finds an ordered range of all the expando values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param start the lower bound of the range of expando values to return
	 * @param end the upper bound of the range of expando values to return (not inclusive)
	 * @param orderByComparator the comparator to order the results by
	 * @return the ordered range of expando values
	 * @throws SystemException if a system exception occurred
	 */
	public List<ExpandoValue> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		Object[] finderArgs = new Object[] {
				String.valueOf(start), String.valueOf(end),
				String.valueOf(orderByComparator)
			};

		List<ExpandoValue> list = (List<ExpandoValue>)FinderCacheUtil.getResult(FINDER_PATH_FIND_ALL,
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

					query.append(_SQL_SELECT_EXPANDOVALUE);

					appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
						orderByComparator);

					sql = query.toString();
				}
				else {
					sql = _SQL_SELECT_EXPANDOVALUE.concat(ExpandoValueModelImpl.ORDER_BY_JPQL);
				}

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ExpandoValue>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ExpandoValue>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					list = new ArrayList<ExpandoValue>();
				}

				cacheResult(list);

				FinderCacheUtil.putResult(FINDER_PATH_FIND_ALL, finderArgs, list);

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the expando values where tableId = &#63; from the database.
	 *
	 * @param tableId the table id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByTableId(long tableId) throws SystemException {
		for (ExpandoValue expandoValue : findByTableId(tableId)) {
			remove(expandoValue);
		}
	}

	/**
	 * Removes all the expando values where columnId = &#63; from the database.
	 *
	 * @param columnId the column id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByColumnId(long columnId) throws SystemException {
		for (ExpandoValue expandoValue : findByColumnId(columnId)) {
			remove(expandoValue);
		}
	}

	/**
	 * Removes all the expando values where rowId = &#63; from the database.
	 *
	 * @param rowId the row id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByRowId(long rowId) throws SystemException {
		for (ExpandoValue expandoValue : findByRowId(rowId)) {
			remove(expandoValue);
		}
	}

	/**
	 * Removes all the expando values where tableId = &#63; and columnId = &#63; from the database.
	 *
	 * @param tableId the table id to search with
	 * @param columnId the column id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByT_C(long tableId, long columnId)
		throws SystemException {
		for (ExpandoValue expandoValue : findByT_C(tableId, columnId)) {
			remove(expandoValue);
		}
	}

	/**
	 * Removes all the expando values where tableId = &#63; and classPK = &#63; from the database.
	 *
	 * @param tableId the table id to search with
	 * @param classPK the class p k to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByT_CPK(long tableId, long classPK)
		throws SystemException {
		for (ExpandoValue expandoValue : findByT_CPK(tableId, classPK)) {
			remove(expandoValue);
		}
	}

	/**
	 * Removes all the expando values where tableId = &#63; and rowId = &#63; from the database.
	 *
	 * @param tableId the table id to search with
	 * @param rowId the row id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByT_R(long tableId, long rowId) throws SystemException {
		for (ExpandoValue expandoValue : findByT_R(tableId, rowId)) {
			remove(expandoValue);
		}
	}

	/**
	 * Removes the expando value where columnId = &#63; and rowId = &#63; from the database.
	 *
	 * @param columnId the column id to search with
	 * @param rowId the row id to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByC_R(long columnId, long rowId)
		throws NoSuchValueException, SystemException {
		ExpandoValue expandoValue = findByC_R(columnId, rowId);

		remove(expandoValue);
	}

	/**
	 * Removes all the expando values where classNameId = &#63; and classPK = &#63; from the database.
	 *
	 * @param classNameId the class name id to search with
	 * @param classPK the class p k to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByC_C(long classNameId, long classPK)
		throws SystemException {
		for (ExpandoValue expandoValue : findByC_C(classNameId, classPK)) {
			remove(expandoValue);
		}
	}

	/**
	 * Removes the expando value where tableId = &#63; and columnId = &#63; and classPK = &#63; from the database.
	 *
	 * @param tableId the table id to search with
	 * @param columnId the column id to search with
	 * @param classPK the class p k to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByT_C_C(long tableId, long columnId, long classPK)
		throws NoSuchValueException, SystemException {
		ExpandoValue expandoValue = findByT_C_C(tableId, columnId, classPK);

		remove(expandoValue);
	}

	/**
	 * Removes all the expando values where tableId = &#63; and columnId = &#63; and data = &#63; from the database.
	 *
	 * @param tableId the table id to search with
	 * @param columnId the column id to search with
	 * @param data the data to search with
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByT_C_D(long tableId, long columnId, String data)
		throws SystemException {
		for (ExpandoValue expandoValue : findByT_C_D(tableId, columnId, data)) {
			remove(expandoValue);
		}
	}

	/**
	 * Removes all the expando values from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ExpandoValue expandoValue : findAll()) {
			remove(expandoValue);
		}
	}

	/**
	 * Counts all the expando values where tableId = &#63;.
	 *
	 * @param tableId the table id to search with
	 * @return the number of matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public int countByTableId(long tableId) throws SystemException {
		Object[] finderArgs = new Object[] { tableId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TABLEID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_EXPANDOVALUE_WHERE);

				query.append(_FINDER_COLUMN_TABLEID_TABLEID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tableId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TABLEID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the expando values where columnId = &#63;.
	 *
	 * @param columnId the column id to search with
	 * @return the number of matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public int countByColumnId(long columnId) throws SystemException {
		Object[] finderArgs = new Object[] { columnId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_COLUMNID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_EXPANDOVALUE_WHERE);

				query.append(_FINDER_COLUMN_COLUMNID_COLUMNID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(columnId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_COLUMNID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the expando values where rowId = &#63;.
	 *
	 * @param rowId the row id to search with
	 * @return the number of matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public int countByRowId(long rowId) throws SystemException {
		Object[] finderArgs = new Object[] { rowId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ROWID,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(2);

				query.append(_SQL_COUNT_EXPANDOVALUE_WHERE);

				query.append(_FINDER_COLUMN_ROWID_ROWID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(rowId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ROWID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the expando values where tableId = &#63; and columnId = &#63;.
	 *
	 * @param tableId the table id to search with
	 * @param columnId the column id to search with
	 * @return the number of matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public int countByT_C(long tableId, long columnId)
		throws SystemException {
		Object[] finderArgs = new Object[] { tableId, columnId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_T_C,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(3);

				query.append(_SQL_COUNT_EXPANDOVALUE_WHERE);

				query.append(_FINDER_COLUMN_T_C_TABLEID_2);

				query.append(_FINDER_COLUMN_T_C_COLUMNID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tableId);

				qPos.add(columnId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_T_C, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the expando values where tableId = &#63; and classPK = &#63;.
	 *
	 * @param tableId the table id to search with
	 * @param classPK the class p k to search with
	 * @return the number of matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public int countByT_CPK(long tableId, long classPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { tableId, classPK };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_T_CPK,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(3);

				query.append(_SQL_COUNT_EXPANDOVALUE_WHERE);

				query.append(_FINDER_COLUMN_T_CPK_TABLEID_2);

				query.append(_FINDER_COLUMN_T_CPK_CLASSPK_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tableId);

				qPos.add(classPK);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_T_CPK,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the expando values where tableId = &#63; and rowId = &#63;.
	 *
	 * @param tableId the table id to search with
	 * @param rowId the row id to search with
	 * @return the number of matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public int countByT_R(long tableId, long rowId) throws SystemException {
		Object[] finderArgs = new Object[] { tableId, rowId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_T_R,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(3);

				query.append(_SQL_COUNT_EXPANDOVALUE_WHERE);

				query.append(_FINDER_COLUMN_T_R_TABLEID_2);

				query.append(_FINDER_COLUMN_T_R_ROWID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tableId);

				qPos.add(rowId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_T_R, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the expando values where columnId = &#63; and rowId = &#63;.
	 *
	 * @param columnId the column id to search with
	 * @param rowId the row id to search with
	 * @return the number of matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public int countByC_R(long columnId, long rowId) throws SystemException {
		Object[] finderArgs = new Object[] { columnId, rowId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_R,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(3);

				query.append(_SQL_COUNT_EXPANDOVALUE_WHERE);

				query.append(_FINDER_COLUMN_C_R_COLUMNID_2);

				query.append(_FINDER_COLUMN_C_R_ROWID_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(columnId);

				qPos.add(rowId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_R, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the expando values where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name id to search with
	 * @param classPK the class p k to search with
	 * @return the number of matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public int countByC_C(long classNameId, long classPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { classNameId, classPK };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_C_C,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(3);

				query.append(_SQL_COUNT_EXPANDOVALUE_WHERE);

				query.append(_FINDER_COLUMN_C_C_CLASSNAMEID_2);

				query.append(_FINDER_COLUMN_C_C_CLASSPK_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(classPK);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_C_C, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the expando values where tableId = &#63; and columnId = &#63; and classPK = &#63;.
	 *
	 * @param tableId the table id to search with
	 * @param columnId the column id to search with
	 * @param classPK the class p k to search with
	 * @return the number of matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public int countByT_C_C(long tableId, long columnId, long classPK)
		throws SystemException {
		Object[] finderArgs = new Object[] { tableId, columnId, classPK };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_T_C_C,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(4);

				query.append(_SQL_COUNT_EXPANDOVALUE_WHERE);

				query.append(_FINDER_COLUMN_T_C_C_TABLEID_2);

				query.append(_FINDER_COLUMN_T_C_C_COLUMNID_2);

				query.append(_FINDER_COLUMN_T_C_C_CLASSPK_2);

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tableId);

				qPos.add(columnId);

				qPos.add(classPK);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_T_C_C,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the expando values where tableId = &#63; and columnId = &#63; and data = &#63;.
	 *
	 * @param tableId the table id to search with
	 * @param columnId the column id to search with
	 * @param data the data to search with
	 * @return the number of matching expando values
	 * @throws SystemException if a system exception occurred
	 */
	public int countByT_C_D(long tableId, long columnId, String data)
		throws SystemException {
		Object[] finderArgs = new Object[] { tableId, columnId, data };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_T_C_D,
				finderArgs, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				StringBundler query = new StringBundler(4);

				query.append(_SQL_COUNT_EXPANDOVALUE_WHERE);

				query.append(_FINDER_COLUMN_T_C_D_TABLEID_2);

				query.append(_FINDER_COLUMN_T_C_D_COLUMNID_2);

				if (data == null) {
					query.append(_FINDER_COLUMN_T_C_D_DATA_1);
				}
				else {
					if (data.equals(StringPool.BLANK)) {
						query.append(_FINDER_COLUMN_T_C_D_DATA_3);
					}
					else {
						query.append(_FINDER_COLUMN_T_C_D_DATA_2);
					}
				}

				String sql = query.toString();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(tableId);

				qPos.add(columnId);

				if (data != null) {
					qPos.add(data);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_T_C_D,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Counts all the expando values.
	 *
	 * @return the number of expando values
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

				Query q = session.createQuery(_SQL_COUNT_EXPANDOVALUE);

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
	 * Initializes the expando value persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.portal.util.PropsUtil.get(
						"value.object.listener.com.liferay.portlet.expando.model.ExpandoValue")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ExpandoValue>> listenersList = new ArrayList<ModelListener<ExpandoValue>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ExpandoValue>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	@BeanReference(type = ExpandoColumnPersistence.class)
	protected ExpandoColumnPersistence expandoColumnPersistence;
	@BeanReference(type = ExpandoRowPersistence.class)
	protected ExpandoRowPersistence expandoRowPersistence;
	@BeanReference(type = ExpandoTablePersistence.class)
	protected ExpandoTablePersistence expandoTablePersistence;
	@BeanReference(type = ExpandoValuePersistence.class)
	protected ExpandoValuePersistence expandoValuePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_EXPANDOVALUE = "SELECT expandoValue FROM ExpandoValue expandoValue";
	private static final String _SQL_SELECT_EXPANDOVALUE_WHERE = "SELECT expandoValue FROM ExpandoValue expandoValue WHERE ";
	private static final String _SQL_COUNT_EXPANDOVALUE = "SELECT COUNT(expandoValue) FROM ExpandoValue expandoValue";
	private static final String _SQL_COUNT_EXPANDOVALUE_WHERE = "SELECT COUNT(expandoValue) FROM ExpandoValue expandoValue WHERE ";
	private static final String _FINDER_COLUMN_TABLEID_TABLEID_2 = "expandoValue.tableId = ?";
	private static final String _FINDER_COLUMN_COLUMNID_COLUMNID_2 = "expandoValue.columnId = ?";
	private static final String _FINDER_COLUMN_ROWID_ROWID_2 = "expandoValue.rowId = ?";
	private static final String _FINDER_COLUMN_T_C_TABLEID_2 = "expandoValue.tableId = ? AND ";
	private static final String _FINDER_COLUMN_T_C_COLUMNID_2 = "expandoValue.columnId = ?";
	private static final String _FINDER_COLUMN_T_CPK_TABLEID_2 = "expandoValue.tableId = ? AND ";
	private static final String _FINDER_COLUMN_T_CPK_CLASSPK_2 = "expandoValue.classPK = ?";
	private static final String _FINDER_COLUMN_T_R_TABLEID_2 = "expandoValue.tableId = ? AND ";
	private static final String _FINDER_COLUMN_T_R_ROWID_2 = "expandoValue.rowId = ?";
	private static final String _FINDER_COLUMN_C_R_COLUMNID_2 = "expandoValue.columnId = ? AND ";
	private static final String _FINDER_COLUMN_C_R_ROWID_2 = "expandoValue.rowId = ?";
	private static final String _FINDER_COLUMN_C_C_CLASSNAMEID_2 = "expandoValue.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_CLASSPK_2 = "expandoValue.classPK = ?";
	private static final String _FINDER_COLUMN_T_C_C_TABLEID_2 = "expandoValue.tableId = ? AND ";
	private static final String _FINDER_COLUMN_T_C_C_COLUMNID_2 = "expandoValue.columnId = ? AND ";
	private static final String _FINDER_COLUMN_T_C_C_CLASSPK_2 = "expandoValue.classPK = ?";
	private static final String _FINDER_COLUMN_T_C_D_TABLEID_2 = "expandoValue.tableId = ? AND ";
	private static final String _FINDER_COLUMN_T_C_D_COLUMNID_2 = "expandoValue.columnId = ? AND ";
	private static final String _FINDER_COLUMN_T_C_D_DATA_1 = "expandoValue.data IS NULL";
	private static final String _FINDER_COLUMN_T_C_D_DATA_2 = "expandoValue.data = ?";
	private static final String _FINDER_COLUMN_T_C_D_DATA_3 = "(expandoValue.data IS NULL OR expandoValue.data = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "expandoValue.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ExpandoValue exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ExpandoValue exists with the key {";
	private static Log _log = LogFactoryUtil.getLog(ExpandoValuePersistenceImpl.class);
}