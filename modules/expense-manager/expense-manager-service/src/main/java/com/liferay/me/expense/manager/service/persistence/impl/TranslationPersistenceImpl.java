/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.me.expense.manager.service.persistence.impl;

import com.liferay.me.expense.manager.exception.NoSuchTranslationException;
import com.liferay.me.expense.manager.model.Translation;
import com.liferay.me.expense.manager.model.impl.TranslationImpl;
import com.liferay.me.expense.manager.model.impl.TranslationModelImpl;
import com.liferay.me.expense.manager.service.persistence.TranslationPersistence;
import com.liferay.me.expense.manager.service.persistence.impl.constants.ExpenseManagerPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the translation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @generated
 */
@Component(service = TranslationPersistence.class)
public class TranslationPersistenceImpl
	extends BasePersistenceImpl<Translation> implements TranslationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TranslationUtil</code> to access the translation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TranslationImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByTranslationId;
	private FinderPath _finderPathCountByTranslationId;

	/**
	 * Returns the translation where translationId = &#63; or throws a <code>NoSuchTranslationException</code> if it could not be found.
	 *
	 * @param translationId the translation ID
	 * @return the matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	@Override
	public Translation findByTranslationId(long translationId)
		throws NoSuchTranslationException {

		Translation translation = fetchByTranslationId(translationId);

		if (translation == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("translationId=");
			sb.append(translationId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTranslationException(sb.toString());
		}

		return translation;
	}

	/**
	 * Returns the translation where translationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param translationId the translation ID
	 * @return the matching translation, or <code>null</code> if a matching translation could not be found
	 */
	@Override
	public Translation fetchByTranslationId(long translationId) {
		return fetchByTranslationId(translationId, true);
	}

	/**
	 * Returns the translation where translationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param translationId the translation ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching translation, or <code>null</code> if a matching translation could not be found
	 */
	@Override
	public Translation fetchByTranslationId(
		long translationId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {translationId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByTranslationId, finderArgs, this);
		}

		if (result instanceof Translation) {
			Translation translation = (Translation)result;

			if (translationId != translation.getTranslationId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_TRANSLATION_WHERE);

			sb.append(_FINDER_COLUMN_TRANSLATIONID_TRANSLATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(translationId);

				List<Translation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByTranslationId, finderArgs, list);
					}
				}
				else {
					Translation translation = list.get(0);

					result = translation;

					cacheResult(translation);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Translation)result;
		}
	}

	/**
	 * Removes the translation where translationId = &#63; from the database.
	 *
	 * @param translationId the translation ID
	 * @return the translation that was removed
	 */
	@Override
	public Translation removeByTranslationId(long translationId)
		throws NoSuchTranslationException {

		Translation translation = findByTranslationId(translationId);

		return remove(translation);
	}

	/**
	 * Returns the number of translations where translationId = &#63;.
	 *
	 * @param translationId the translation ID
	 * @return the number of matching translations
	 */
	@Override
	public int countByTranslationId(long translationId) {
		FinderPath finderPath = _finderPathCountByTranslationId;

		Object[] finderArgs = new Object[] {translationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRANSLATION_WHERE);

			sb.append(_FINDER_COLUMN_TRANSLATIONID_TRANSLATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(translationId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TRANSLATIONID_TRANSLATIONID_2 =
		"translation.translationId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the translations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching translations
	 */
	@Override
	public List<Translation> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the translations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @return the range of matching translations
	 */
	@Override
	public List<Translation> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the translations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching translations
	 */
	@Override
	public List<Translation> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Translation> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the translations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching translations
	 */
	@Override
	public List<Translation> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Translation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<Translation> list = null;

		if (useFinderCache) {
			list = (List<Translation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Translation translation : list) {
					if (groupId != translation.getGroupId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_TRANSLATION_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TranslationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Translation>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first translation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	@Override
	public Translation findByGroupId_First(
			long groupId, OrderByComparator<Translation> orderByComparator)
		throws NoSuchTranslationException {

		Translation translation = fetchByGroupId_First(
			groupId, orderByComparator);

		if (translation != null) {
			return translation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchTranslationException(sb.toString());
	}

	/**
	 * Returns the first translation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation, or <code>null</code> if a matching translation could not be found
	 */
	@Override
	public Translation fetchByGroupId_First(
		long groupId, OrderByComparator<Translation> orderByComparator) {

		List<Translation> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last translation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	@Override
	public Translation findByGroupId_Last(
			long groupId, OrderByComparator<Translation> orderByComparator)
		throws NoSuchTranslationException {

		Translation translation = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (translation != null) {
			return translation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchTranslationException(sb.toString());
	}

	/**
	 * Returns the last translation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation, or <code>null</code> if a matching translation could not be found
	 */
	@Override
	public Translation fetchByGroupId_Last(
		long groupId, OrderByComparator<Translation> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Translation> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the translations before and after the current translation in the ordered set where groupId = &#63;.
	 *
	 * @param translationId the primary key of the current translation
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	@Override
	public Translation[] findByGroupId_PrevAndNext(
			long translationId, long groupId,
			OrderByComparator<Translation> orderByComparator)
		throws NoSuchTranslationException {

		Translation translation = findByPrimaryKey(translationId);

		Session session = null;

		try {
			session = openSession();

			Translation[] array = new TranslationImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, translation, groupId, orderByComparator, true);

			array[1] = translation;

			array[2] = getByGroupId_PrevAndNext(
				session, translation, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Translation getByGroupId_PrevAndNext(
		Session session, Translation translation, long groupId,
		OrderByComparator<Translation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TRANSLATION_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TranslationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(translation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Translation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the translations that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching translations that the user has permission to view
	 */
	@Override
	public List<Translation> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the translations that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @return the range of matching translations that the user has permission to view
	 */
	@Override
	public List<Translation> filterFindByGroupId(
		long groupId, int start, int end) {

		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the translations that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching translations that the user has permission to view
	 */
	@Override
	public List<Translation> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Translation> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				3 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_TRANSLATION_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_TRANSLATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_TRANSLATION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(TranslationModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(TranslationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), Translation.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, TranslationImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, TranslationImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			return (List<Translation>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the translations before and after the current translation in the ordered set of translations that the user has permission to view where groupId = &#63;.
	 *
	 * @param translationId the primary key of the current translation
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	@Override
	public Translation[] filterFindByGroupId_PrevAndNext(
			long translationId, long groupId,
			OrderByComparator<Translation> orderByComparator)
		throws NoSuchTranslationException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(
				translationId, groupId, orderByComparator);
		}

		Translation translation = findByPrimaryKey(translationId);

		Session session = null;

		try {
			session = openSession();

			Translation[] array = new TranslationImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(
				session, translation, groupId, orderByComparator, true);

			array[1] = translation;

			array[2] = filterGetByGroupId_PrevAndNext(
				session, translation, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Translation filterGetByGroupId_PrevAndNext(
		Session session, Translation translation, long groupId,
		OrderByComparator<Translation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_TRANSLATION_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_TRANSLATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_TRANSLATION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(TranslationModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(TranslationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), Translation.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, TranslationImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, TranslationImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(translation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Translation> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the translations where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Translation translation :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(translation);
		}
	}

	/**
	 * Returns the number of translations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching translations
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRANSLATION_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of translations that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching translations that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler sb = new StringBundler(2);

		sb.append(_FILTER_SQL_COUNT_TRANSLATION_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), Translation.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"translation.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByPortletIdAndCultureCode;
	private FinderPath
		_finderPathWithoutPaginationFindByPortletIdAndCultureCode;
	private FinderPath _finderPathCountByPortletIdAndCultureCode;

	/**
	 * Returns all the translations where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @return the matching translations
	 */
	@Override
	public List<Translation> findByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode) {

		return findByPortletIdAndCultureCode(
			groupId, portletId, cultureCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the translations where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @return the range of matching translations
	 */
	@Override
	public List<Translation> findByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode, int start,
		int end) {

		return findByPortletIdAndCultureCode(
			groupId, portletId, cultureCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the translations where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching translations
	 */
	@Override
	public List<Translation> findByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode, int start, int end,
		OrderByComparator<Translation> orderByComparator) {

		return findByPortletIdAndCultureCode(
			groupId, portletId, cultureCode, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the translations where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching translations
	 */
	@Override
	public List<Translation> findByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode, int start, int end,
		OrderByComparator<Translation> orderByComparator,
		boolean useFinderCache) {

		portletId = Objects.toString(portletId, "");
		cultureCode = Objects.toString(cultureCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByPortletIdAndCultureCode;
				finderArgs = new Object[] {groupId, portletId, cultureCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPortletIdAndCultureCode;
			finderArgs = new Object[] {
				groupId, portletId, cultureCode, start, end, orderByComparator
			};
		}

		List<Translation> list = null;

		if (useFinderCache) {
			list = (List<Translation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Translation translation : list) {
					if ((groupId != translation.getGroupId()) ||
						!portletId.equals(translation.getPortletId()) ||
						!cultureCode.equals(translation.getCultureCode())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_TRANSLATION_WHERE);

			sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_GROUPID_2);

			boolean bindPortletId = false;

			if (portletId.isEmpty()) {
				sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_PORTLETID_3);
			}
			else {
				bindPortletId = true;

				sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_PORTLETID_2);
			}

			boolean bindCultureCode = false;

			if (cultureCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_CULTURECODE_3);
			}
			else {
				bindCultureCode = true;

				sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_CULTURECODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TranslationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindPortletId) {
					queryPos.add(portletId);
				}

				if (bindCultureCode) {
					queryPos.add(cultureCode);
				}

				list = (List<Translation>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first translation in the ordered set where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	@Override
	public Translation findByPortletIdAndCultureCode_First(
			long groupId, String portletId, String cultureCode,
			OrderByComparator<Translation> orderByComparator)
		throws NoSuchTranslationException {

		Translation translation = fetchByPortletIdAndCultureCode_First(
			groupId, portletId, cultureCode, orderByComparator);

		if (translation != null) {
			return translation;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", portletId=");
		sb.append(portletId);

		sb.append(", cultureCode=");
		sb.append(cultureCode);

		sb.append("}");

		throw new NoSuchTranslationException(sb.toString());
	}

	/**
	 * Returns the first translation in the ordered set where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation, or <code>null</code> if a matching translation could not be found
	 */
	@Override
	public Translation fetchByPortletIdAndCultureCode_First(
		long groupId, String portletId, String cultureCode,
		OrderByComparator<Translation> orderByComparator) {

		List<Translation> list = findByPortletIdAndCultureCode(
			groupId, portletId, cultureCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last translation in the ordered set where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	@Override
	public Translation findByPortletIdAndCultureCode_Last(
			long groupId, String portletId, String cultureCode,
			OrderByComparator<Translation> orderByComparator)
		throws NoSuchTranslationException {

		Translation translation = fetchByPortletIdAndCultureCode_Last(
			groupId, portletId, cultureCode, orderByComparator);

		if (translation != null) {
			return translation;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", portletId=");
		sb.append(portletId);

		sb.append(", cultureCode=");
		sb.append(cultureCode);

		sb.append("}");

		throw new NoSuchTranslationException(sb.toString());
	}

	/**
	 * Returns the last translation in the ordered set where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation, or <code>null</code> if a matching translation could not be found
	 */
	@Override
	public Translation fetchByPortletIdAndCultureCode_Last(
		long groupId, String portletId, String cultureCode,
		OrderByComparator<Translation> orderByComparator) {

		int count = countByPortletIdAndCultureCode(
			groupId, portletId, cultureCode);

		if (count == 0) {
			return null;
		}

		List<Translation> list = findByPortletIdAndCultureCode(
			groupId, portletId, cultureCode, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the translations before and after the current translation in the ordered set where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * @param translationId the primary key of the current translation
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	@Override
	public Translation[] findByPortletIdAndCultureCode_PrevAndNext(
			long translationId, long groupId, String portletId,
			String cultureCode,
			OrderByComparator<Translation> orderByComparator)
		throws NoSuchTranslationException {

		portletId = Objects.toString(portletId, "");
		cultureCode = Objects.toString(cultureCode, "");

		Translation translation = findByPrimaryKey(translationId);

		Session session = null;

		try {
			session = openSession();

			Translation[] array = new TranslationImpl[3];

			array[0] = getByPortletIdAndCultureCode_PrevAndNext(
				session, translation, groupId, portletId, cultureCode,
				orderByComparator, true);

			array[1] = translation;

			array[2] = getByPortletIdAndCultureCode_PrevAndNext(
				session, translation, groupId, portletId, cultureCode,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Translation getByPortletIdAndCultureCode_PrevAndNext(
		Session session, Translation translation, long groupId,
		String portletId, String cultureCode,
		OrderByComparator<Translation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_TRANSLATION_WHERE);

		sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_GROUPID_2);

		boolean bindPortletId = false;

		if (portletId.isEmpty()) {
			sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_PORTLETID_3);
		}
		else {
			bindPortletId = true;

			sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_PORTLETID_2);
		}

		boolean bindCultureCode = false;

		if (cultureCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_CULTURECODE_3);
		}
		else {
			bindCultureCode = true;

			sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_CULTURECODE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TranslationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (bindPortletId) {
			queryPos.add(portletId);
		}

		if (bindCultureCode) {
			queryPos.add(cultureCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(translation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Translation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the translations that the user has permission to view where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @return the matching translations that the user has permission to view
	 */
	@Override
	public List<Translation> filterFindByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode) {

		return filterFindByPortletIdAndCultureCode(
			groupId, portletId, cultureCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the translations that the user has permission to view where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @return the range of matching translations that the user has permission to view
	 */
	@Override
	public List<Translation> filterFindByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode, int start,
		int end) {

		return filterFindByPortletIdAndCultureCode(
			groupId, portletId, cultureCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the translations that the user has permissions to view where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching translations that the user has permission to view
	 */
	@Override
	public List<Translation> filterFindByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode, int start, int end,
		OrderByComparator<Translation> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByPortletIdAndCultureCode(
				groupId, portletId, cultureCode, start, end, orderByComparator);
		}

		portletId = Objects.toString(portletId, "");
		cultureCode = Objects.toString(cultureCode, "");

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_TRANSLATION_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_TRANSLATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_GROUPID_2);

		boolean bindPortletId = false;

		if (portletId.isEmpty()) {
			sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_PORTLETID_3);
		}
		else {
			bindPortletId = true;

			sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_PORTLETID_2);
		}

		boolean bindCultureCode = false;

		if (cultureCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_CULTURECODE_3);
		}
		else {
			bindCultureCode = true;

			sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_CULTURECODE_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_TRANSLATION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(TranslationModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(TranslationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), Translation.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, TranslationImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, TranslationImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			if (bindPortletId) {
				queryPos.add(portletId);
			}

			if (bindCultureCode) {
				queryPos.add(cultureCode);
			}

			return (List<Translation>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the translations before and after the current translation in the ordered set of translations that the user has permission to view where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * @param translationId the primary key of the current translation
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	@Override
	public Translation[] filterFindByPortletIdAndCultureCode_PrevAndNext(
			long translationId, long groupId, String portletId,
			String cultureCode,
			OrderByComparator<Translation> orderByComparator)
		throws NoSuchTranslationException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByPortletIdAndCultureCode_PrevAndNext(
				translationId, groupId, portletId, cultureCode,
				orderByComparator);
		}

		portletId = Objects.toString(portletId, "");
		cultureCode = Objects.toString(cultureCode, "");

		Translation translation = findByPrimaryKey(translationId);

		Session session = null;

		try {
			session = openSession();

			Translation[] array = new TranslationImpl[3];

			array[0] = filterGetByPortletIdAndCultureCode_PrevAndNext(
				session, translation, groupId, portletId, cultureCode,
				orderByComparator, true);

			array[1] = translation;

			array[2] = filterGetByPortletIdAndCultureCode_PrevAndNext(
				session, translation, groupId, portletId, cultureCode,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Translation filterGetByPortletIdAndCultureCode_PrevAndNext(
		Session session, Translation translation, long groupId,
		String portletId, String cultureCode,
		OrderByComparator<Translation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_TRANSLATION_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_TRANSLATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_GROUPID_2);

		boolean bindPortletId = false;

		if (portletId.isEmpty()) {
			sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_PORTLETID_3);
		}
		else {
			bindPortletId = true;

			sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_PORTLETID_2);
		}

		boolean bindCultureCode = false;

		if (cultureCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_CULTURECODE_3);
		}
		else {
			bindCultureCode = true;

			sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_CULTURECODE_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_TRANSLATION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(TranslationModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(TranslationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), Translation.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, TranslationImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, TranslationImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (bindPortletId) {
			queryPos.add(portletId);
		}

		if (bindCultureCode) {
			queryPos.add(cultureCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(translation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Translation> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the translations where groupId = &#63; and portletId = &#63; and cultureCode = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 */
	@Override
	public void removeByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode) {

		for (Translation translation :
				findByPortletIdAndCultureCode(
					groupId, portletId, cultureCode, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(translation);
		}
	}

	/**
	 * Returns the number of translations where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @return the number of matching translations
	 */
	@Override
	public int countByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode) {

		portletId = Objects.toString(portletId, "");
		cultureCode = Objects.toString(cultureCode, "");

		FinderPath finderPath = _finderPathCountByPortletIdAndCultureCode;

		Object[] finderArgs = new Object[] {groupId, portletId, cultureCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_TRANSLATION_WHERE);

			sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_GROUPID_2);

			boolean bindPortletId = false;

			if (portletId.isEmpty()) {
				sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_PORTLETID_3);
			}
			else {
				bindPortletId = true;

				sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_PORTLETID_2);
			}

			boolean bindCultureCode = false;

			if (cultureCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_CULTURECODE_3);
			}
			else {
				bindCultureCode = true;

				sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_CULTURECODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindPortletId) {
					queryPos.add(portletId);
				}

				if (bindCultureCode) {
					queryPos.add(cultureCode);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of translations that the user has permission to view where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @return the number of matching translations that the user has permission to view
	 */
	@Override
	public int filterCountByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByPortletIdAndCultureCode(
				groupId, portletId, cultureCode);
		}

		portletId = Objects.toString(portletId, "");
		cultureCode = Objects.toString(cultureCode, "");

		StringBundler sb = new StringBundler(4);

		sb.append(_FILTER_SQL_COUNT_TRANSLATION_WHERE);

		sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_GROUPID_2);

		boolean bindPortletId = false;

		if (portletId.isEmpty()) {
			sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_PORTLETID_3);
		}
		else {
			bindPortletId = true;

			sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_PORTLETID_2);
		}

		boolean bindCultureCode = false;

		if (cultureCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_CULTURECODE_3);
		}
		else {
			bindCultureCode = true;

			sb.append(_FINDER_COLUMN_PORTLETIDANDCULTURECODE_CULTURECODE_2);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), Translation.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			if (bindPortletId) {
				queryPos.add(portletId);
			}

			if (bindCultureCode) {
				queryPos.add(cultureCode);
			}

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String
		_FINDER_COLUMN_PORTLETIDANDCULTURECODE_GROUPID_2 =
			"translation.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_PORTLETIDANDCULTURECODE_PORTLETID_2 =
			"translation.portletId = ? AND ";

	private static final String
		_FINDER_COLUMN_PORTLETIDANDCULTURECODE_PORTLETID_3 =
			"(translation.portletId IS NULL OR translation.portletId = '') AND ";

	private static final String
		_FINDER_COLUMN_PORTLETIDANDCULTURECODE_CULTURECODE_2 =
			"translation.cultureCode = ?";

	private static final String
		_FINDER_COLUMN_PORTLETIDANDCULTURECODE_CULTURECODE_3 =
			"(translation.cultureCode IS NULL OR translation.cultureCode = '')";

	private FinderPath _finderPathWithPaginationFindByGroupIdAndPortletId;
	private FinderPath _finderPathWithoutPaginationFindByGroupIdAndPortletId;
	private FinderPath _finderPathCountByGroupIdAndPortletId;

	/**
	 * Returns all the translations where groupId = &#63; and portletId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @return the matching translations
	 */
	@Override
	public List<Translation> findByGroupIdAndPortletId(
		long groupId, String portletId) {

		return findByGroupIdAndPortletId(
			groupId, portletId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the translations where groupId = &#63; and portletId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @return the range of matching translations
	 */
	@Override
	public List<Translation> findByGroupIdAndPortletId(
		long groupId, String portletId, int start, int end) {

		return findByGroupIdAndPortletId(groupId, portletId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the translations where groupId = &#63; and portletId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching translations
	 */
	@Override
	public List<Translation> findByGroupIdAndPortletId(
		long groupId, String portletId, int start, int end,
		OrderByComparator<Translation> orderByComparator) {

		return findByGroupIdAndPortletId(
			groupId, portletId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the translations where groupId = &#63; and portletId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching translations
	 */
	@Override
	public List<Translation> findByGroupIdAndPortletId(
		long groupId, String portletId, int start, int end,
		OrderByComparator<Translation> orderByComparator,
		boolean useFinderCache) {

		portletId = Objects.toString(portletId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGroupIdAndPortletId;
				finderArgs = new Object[] {groupId, portletId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupIdAndPortletId;
			finderArgs = new Object[] {
				groupId, portletId, start, end, orderByComparator
			};
		}

		List<Translation> list = null;

		if (useFinderCache) {
			list = (List<Translation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Translation translation : list) {
					if ((groupId != translation.getGroupId()) ||
						!portletId.equals(translation.getPortletId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_TRANSLATION_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDANDPORTLETID_GROUPID_2);

			boolean bindPortletId = false;

			if (portletId.isEmpty()) {
				sb.append(_FINDER_COLUMN_GROUPIDANDPORTLETID_PORTLETID_3);
			}
			else {
				bindPortletId = true;

				sb.append(_FINDER_COLUMN_GROUPIDANDPORTLETID_PORTLETID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TranslationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindPortletId) {
					queryPos.add(portletId);
				}

				list = (List<Translation>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first translation in the ordered set where groupId = &#63; and portletId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	@Override
	public Translation findByGroupIdAndPortletId_First(
			long groupId, String portletId,
			OrderByComparator<Translation> orderByComparator)
		throws NoSuchTranslationException {

		Translation translation = fetchByGroupIdAndPortletId_First(
			groupId, portletId, orderByComparator);

		if (translation != null) {
			return translation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", portletId=");
		sb.append(portletId);

		sb.append("}");

		throw new NoSuchTranslationException(sb.toString());
	}

	/**
	 * Returns the first translation in the ordered set where groupId = &#63; and portletId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation, or <code>null</code> if a matching translation could not be found
	 */
	@Override
	public Translation fetchByGroupIdAndPortletId_First(
		long groupId, String portletId,
		OrderByComparator<Translation> orderByComparator) {

		List<Translation> list = findByGroupIdAndPortletId(
			groupId, portletId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last translation in the ordered set where groupId = &#63; and portletId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	@Override
	public Translation findByGroupIdAndPortletId_Last(
			long groupId, String portletId,
			OrderByComparator<Translation> orderByComparator)
		throws NoSuchTranslationException {

		Translation translation = fetchByGroupIdAndPortletId_Last(
			groupId, portletId, orderByComparator);

		if (translation != null) {
			return translation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", portletId=");
		sb.append(portletId);

		sb.append("}");

		throw new NoSuchTranslationException(sb.toString());
	}

	/**
	 * Returns the last translation in the ordered set where groupId = &#63; and portletId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation, or <code>null</code> if a matching translation could not be found
	 */
	@Override
	public Translation fetchByGroupIdAndPortletId_Last(
		long groupId, String portletId,
		OrderByComparator<Translation> orderByComparator) {

		int count = countByGroupIdAndPortletId(groupId, portletId);

		if (count == 0) {
			return null;
		}

		List<Translation> list = findByGroupIdAndPortletId(
			groupId, portletId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the translations before and after the current translation in the ordered set where groupId = &#63; and portletId = &#63;.
	 *
	 * @param translationId the primary key of the current translation
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	@Override
	public Translation[] findByGroupIdAndPortletId_PrevAndNext(
			long translationId, long groupId, String portletId,
			OrderByComparator<Translation> orderByComparator)
		throws NoSuchTranslationException {

		portletId = Objects.toString(portletId, "");

		Translation translation = findByPrimaryKey(translationId);

		Session session = null;

		try {
			session = openSession();

			Translation[] array = new TranslationImpl[3];

			array[0] = getByGroupIdAndPortletId_PrevAndNext(
				session, translation, groupId, portletId, orderByComparator,
				true);

			array[1] = translation;

			array[2] = getByGroupIdAndPortletId_PrevAndNext(
				session, translation, groupId, portletId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Translation getByGroupIdAndPortletId_PrevAndNext(
		Session session, Translation translation, long groupId,
		String portletId, OrderByComparator<Translation> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TRANSLATION_WHERE);

		sb.append(_FINDER_COLUMN_GROUPIDANDPORTLETID_GROUPID_2);

		boolean bindPortletId = false;

		if (portletId.isEmpty()) {
			sb.append(_FINDER_COLUMN_GROUPIDANDPORTLETID_PORTLETID_3);
		}
		else {
			bindPortletId = true;

			sb.append(_FINDER_COLUMN_GROUPIDANDPORTLETID_PORTLETID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TranslationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (bindPortletId) {
			queryPos.add(portletId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(translation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Translation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the translations that the user has permission to view where groupId = &#63; and portletId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @return the matching translations that the user has permission to view
	 */
	@Override
	public List<Translation> filterFindByGroupIdAndPortletId(
		long groupId, String portletId) {

		return filterFindByGroupIdAndPortletId(
			groupId, portletId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the translations that the user has permission to view where groupId = &#63; and portletId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @return the range of matching translations that the user has permission to view
	 */
	@Override
	public List<Translation> filterFindByGroupIdAndPortletId(
		long groupId, String portletId, int start, int end) {

		return filterFindByGroupIdAndPortletId(
			groupId, portletId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the translations that the user has permissions to view where groupId = &#63; and portletId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching translations that the user has permission to view
	 */
	@Override
	public List<Translation> filterFindByGroupIdAndPortletId(
		long groupId, String portletId, int start, int end,
		OrderByComparator<Translation> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupIdAndPortletId(
				groupId, portletId, start, end, orderByComparator);
		}

		portletId = Objects.toString(portletId, "");

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_TRANSLATION_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_TRANSLATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPIDANDPORTLETID_GROUPID_2);

		boolean bindPortletId = false;

		if (portletId.isEmpty()) {
			sb.append(_FINDER_COLUMN_GROUPIDANDPORTLETID_PORTLETID_3);
		}
		else {
			bindPortletId = true;

			sb.append(_FINDER_COLUMN_GROUPIDANDPORTLETID_PORTLETID_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_TRANSLATION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(TranslationModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(TranslationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), Translation.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, TranslationImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, TranslationImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			if (bindPortletId) {
				queryPos.add(portletId);
			}

			return (List<Translation>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the translations before and after the current translation in the ordered set of translations that the user has permission to view where groupId = &#63; and portletId = &#63;.
	 *
	 * @param translationId the primary key of the current translation
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	@Override
	public Translation[] filterFindByGroupIdAndPortletId_PrevAndNext(
			long translationId, long groupId, String portletId,
			OrderByComparator<Translation> orderByComparator)
		throws NoSuchTranslationException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupIdAndPortletId_PrevAndNext(
				translationId, groupId, portletId, orderByComparator);
		}

		portletId = Objects.toString(portletId, "");

		Translation translation = findByPrimaryKey(translationId);

		Session session = null;

		try {
			session = openSession();

			Translation[] array = new TranslationImpl[3];

			array[0] = filterGetByGroupIdAndPortletId_PrevAndNext(
				session, translation, groupId, portletId, orderByComparator,
				true);

			array[1] = translation;

			array[2] = filterGetByGroupIdAndPortletId_PrevAndNext(
				session, translation, groupId, portletId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Translation filterGetByGroupIdAndPortletId_PrevAndNext(
		Session session, Translation translation, long groupId,
		String portletId, OrderByComparator<Translation> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_TRANSLATION_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_TRANSLATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPIDANDPORTLETID_GROUPID_2);

		boolean bindPortletId = false;

		if (portletId.isEmpty()) {
			sb.append(_FINDER_COLUMN_GROUPIDANDPORTLETID_PORTLETID_3);
		}
		else {
			bindPortletId = true;

			sb.append(_FINDER_COLUMN_GROUPIDANDPORTLETID_PORTLETID_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_TRANSLATION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(TranslationModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(TranslationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), Translation.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, TranslationImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, TranslationImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (bindPortletId) {
			queryPos.add(portletId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(translation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Translation> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the translations where groupId = &#63; and portletId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 */
	@Override
	public void removeByGroupIdAndPortletId(long groupId, String portletId) {
		for (Translation translation :
				findByGroupIdAndPortletId(
					groupId, portletId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(translation);
		}
	}

	/**
	 * Returns the number of translations where groupId = &#63; and portletId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @return the number of matching translations
	 */
	@Override
	public int countByGroupIdAndPortletId(long groupId, String portletId) {
		portletId = Objects.toString(portletId, "");

		FinderPath finderPath = _finderPathCountByGroupIdAndPortletId;

		Object[] finderArgs = new Object[] {groupId, portletId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRANSLATION_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDANDPORTLETID_GROUPID_2);

			boolean bindPortletId = false;

			if (portletId.isEmpty()) {
				sb.append(_FINDER_COLUMN_GROUPIDANDPORTLETID_PORTLETID_3);
			}
			else {
				bindPortletId = true;

				sb.append(_FINDER_COLUMN_GROUPIDANDPORTLETID_PORTLETID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindPortletId) {
					queryPos.add(portletId);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of translations that the user has permission to view where groupId = &#63; and portletId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @return the number of matching translations that the user has permission to view
	 */
	@Override
	public int filterCountByGroupIdAndPortletId(
		long groupId, String portletId) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupIdAndPortletId(groupId, portletId);
		}

		portletId = Objects.toString(portletId, "");

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_TRANSLATION_WHERE);

		sb.append(_FINDER_COLUMN_GROUPIDANDPORTLETID_GROUPID_2);

		boolean bindPortletId = false;

		if (portletId.isEmpty()) {
			sb.append(_FINDER_COLUMN_GROUPIDANDPORTLETID_PORTLETID_3);
		}
		else {
			bindPortletId = true;

			sb.append(_FINDER_COLUMN_GROUPIDANDPORTLETID_PORTLETID_2);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), Translation.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			if (bindPortletId) {
				queryPos.add(portletId);
			}

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPIDANDPORTLETID_GROUPID_2 =
		"translation.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUPIDANDPORTLETID_PORTLETID_2 =
		"translation.portletId = ?";

	private static final String _FINDER_COLUMN_GROUPIDANDPORTLETID_PORTLETID_3 =
		"(translation.portletId IS NULL OR translation.portletId = '')";

	private FinderPath
		_finderPathWithPaginationFindByPortletIdComponentIdCultureCode;
	private FinderPath
		_finderPathWithoutPaginationFindByPortletIdComponentIdCultureCode;
	private FinderPath _finderPathCountByPortletIdComponentIdCultureCode;

	/**
	 * Returns all the translations where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @return the matching translations
	 */
	@Override
	public List<Translation> findByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId,
		String cultureCode) {

		return findByPortletIdComponentIdCultureCode(
			groupId, portletId, componentId, cultureCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the translations where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @return the range of matching translations
	 */
	@Override
	public List<Translation> findByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId, String cultureCode,
		int start, int end) {

		return findByPortletIdComponentIdCultureCode(
			groupId, portletId, componentId, cultureCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the translations where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching translations
	 */
	@Override
	public List<Translation> findByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId, String cultureCode,
		int start, int end, OrderByComparator<Translation> orderByComparator) {

		return findByPortletIdComponentIdCultureCode(
			groupId, portletId, componentId, cultureCode, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the translations where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching translations
	 */
	@Override
	public List<Translation> findByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId, String cultureCode,
		int start, int end, OrderByComparator<Translation> orderByComparator,
		boolean useFinderCache) {

		portletId = Objects.toString(portletId, "");
		componentId = Objects.toString(componentId, "");
		cultureCode = Objects.toString(cultureCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByPortletIdComponentIdCultureCode;
				finderArgs = new Object[] {
					groupId, portletId, componentId, cultureCode
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByPortletIdComponentIdCultureCode;
			finderArgs = new Object[] {
				groupId, portletId, componentId, cultureCode, start, end,
				orderByComparator
			};
		}

		List<Translation> list = null;

		if (useFinderCache) {
			list = (List<Translation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Translation translation : list) {
					if ((groupId != translation.getGroupId()) ||
						!portletId.equals(translation.getPortletId()) ||
						!componentId.equals(translation.getComponentId()) ||
						!cultureCode.equals(translation.getCultureCode())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(6);
			}

			sb.append(_SQL_SELECT_TRANSLATION_WHERE);

			sb.append(_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_GROUPID_2);

			boolean bindPortletId = false;

			if (portletId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_PORTLETID_3);
			}
			else {
				bindPortletId = true;

				sb.append(
					_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_PORTLETID_2);
			}

			boolean bindComponentId = false;

			if (componentId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_COMPONENTID_3);
			}
			else {
				bindComponentId = true;

				sb.append(
					_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_COMPONENTID_2);
			}

			boolean bindCultureCode = false;

			if (cultureCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_CULTURECODE_3);
			}
			else {
				bindCultureCode = true;

				sb.append(
					_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_CULTURECODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TranslationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindPortletId) {
					queryPos.add(portletId);
				}

				if (bindComponentId) {
					queryPos.add(componentId);
				}

				if (bindCultureCode) {
					queryPos.add(cultureCode);
				}

				list = (List<Translation>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first translation in the ordered set where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	@Override
	public Translation findByPortletIdComponentIdCultureCode_First(
			long groupId, String portletId, String componentId,
			String cultureCode,
			OrderByComparator<Translation> orderByComparator)
		throws NoSuchTranslationException {

		Translation translation = fetchByPortletIdComponentIdCultureCode_First(
			groupId, portletId, componentId, cultureCode, orderByComparator);

		if (translation != null) {
			return translation;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", portletId=");
		sb.append(portletId);

		sb.append(", componentId=");
		sb.append(componentId);

		sb.append(", cultureCode=");
		sb.append(cultureCode);

		sb.append("}");

		throw new NoSuchTranslationException(sb.toString());
	}

	/**
	 * Returns the first translation in the ordered set where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation, or <code>null</code> if a matching translation could not be found
	 */
	@Override
	public Translation fetchByPortletIdComponentIdCultureCode_First(
		long groupId, String portletId, String componentId, String cultureCode,
		OrderByComparator<Translation> orderByComparator) {

		List<Translation> list = findByPortletIdComponentIdCultureCode(
			groupId, portletId, componentId, cultureCode, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last translation in the ordered set where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	@Override
	public Translation findByPortletIdComponentIdCultureCode_Last(
			long groupId, String portletId, String componentId,
			String cultureCode,
			OrderByComparator<Translation> orderByComparator)
		throws NoSuchTranslationException {

		Translation translation = fetchByPortletIdComponentIdCultureCode_Last(
			groupId, portletId, componentId, cultureCode, orderByComparator);

		if (translation != null) {
			return translation;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", portletId=");
		sb.append(portletId);

		sb.append(", componentId=");
		sb.append(componentId);

		sb.append(", cultureCode=");
		sb.append(cultureCode);

		sb.append("}");

		throw new NoSuchTranslationException(sb.toString());
	}

	/**
	 * Returns the last translation in the ordered set where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation, or <code>null</code> if a matching translation could not be found
	 */
	@Override
	public Translation fetchByPortletIdComponentIdCultureCode_Last(
		long groupId, String portletId, String componentId, String cultureCode,
		OrderByComparator<Translation> orderByComparator) {

		int count = countByPortletIdComponentIdCultureCode(
			groupId, portletId, componentId, cultureCode);

		if (count == 0) {
			return null;
		}

		List<Translation> list = findByPortletIdComponentIdCultureCode(
			groupId, portletId, componentId, cultureCode, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the translations before and after the current translation in the ordered set where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * @param translationId the primary key of the current translation
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	@Override
	public Translation[] findByPortletIdComponentIdCultureCode_PrevAndNext(
			long translationId, long groupId, String portletId,
			String componentId, String cultureCode,
			OrderByComparator<Translation> orderByComparator)
		throws NoSuchTranslationException {

		portletId = Objects.toString(portletId, "");
		componentId = Objects.toString(componentId, "");
		cultureCode = Objects.toString(cultureCode, "");

		Translation translation = findByPrimaryKey(translationId);

		Session session = null;

		try {
			session = openSession();

			Translation[] array = new TranslationImpl[3];

			array[0] = getByPortletIdComponentIdCultureCode_PrevAndNext(
				session, translation, groupId, portletId, componentId,
				cultureCode, orderByComparator, true);

			array[1] = translation;

			array[2] = getByPortletIdComponentIdCultureCode_PrevAndNext(
				session, translation, groupId, portletId, componentId,
				cultureCode, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Translation getByPortletIdComponentIdCultureCode_PrevAndNext(
		Session session, Translation translation, long groupId,
		String portletId, String componentId, String cultureCode,
		OrderByComparator<Translation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		sb.append(_SQL_SELECT_TRANSLATION_WHERE);

		sb.append(_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_GROUPID_2);

		boolean bindPortletId = false;

		if (portletId.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_PORTLETID_3);
		}
		else {
			bindPortletId = true;

			sb.append(
				_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_PORTLETID_2);
		}

		boolean bindComponentId = false;

		if (componentId.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_COMPONENTID_3);
		}
		else {
			bindComponentId = true;

			sb.append(
				_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_COMPONENTID_2);
		}

		boolean bindCultureCode = false;

		if (cultureCode.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_CULTURECODE_3);
		}
		else {
			bindCultureCode = true;

			sb.append(
				_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_CULTURECODE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(TranslationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (bindPortletId) {
			queryPos.add(portletId);
		}

		if (bindComponentId) {
			queryPos.add(componentId);
		}

		if (bindCultureCode) {
			queryPos.add(cultureCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(translation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Translation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the translations that the user has permission to view where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @return the matching translations that the user has permission to view
	 */
	@Override
	public List<Translation> filterFindByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId,
		String cultureCode) {

		return filterFindByPortletIdComponentIdCultureCode(
			groupId, portletId, componentId, cultureCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the translations that the user has permission to view where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @return the range of matching translations that the user has permission to view
	 */
	@Override
	public List<Translation> filterFindByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId, String cultureCode,
		int start, int end) {

		return filterFindByPortletIdComponentIdCultureCode(
			groupId, portletId, componentId, cultureCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the translations that the user has permissions to view where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching translations that the user has permission to view
	 */
	@Override
	public List<Translation> filterFindByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId, String cultureCode,
		int start, int end, OrderByComparator<Translation> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByPortletIdComponentIdCultureCode(
				groupId, portletId, componentId, cultureCode, start, end,
				orderByComparator);
		}

		portletId = Objects.toString(portletId, "");
		componentId = Objects.toString(componentId, "");
		cultureCode = Objects.toString(cultureCode, "");

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(7);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_TRANSLATION_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_TRANSLATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_GROUPID_2);

		boolean bindPortletId = false;

		if (portletId.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_PORTLETID_3);
		}
		else {
			bindPortletId = true;

			sb.append(
				_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_PORTLETID_2);
		}

		boolean bindComponentId = false;

		if (componentId.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_COMPONENTID_3);
		}
		else {
			bindComponentId = true;

			sb.append(
				_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_COMPONENTID_2);
		}

		boolean bindCultureCode = false;

		if (cultureCode.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_CULTURECODE_3);
		}
		else {
			bindCultureCode = true;

			sb.append(
				_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_CULTURECODE_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_TRANSLATION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(TranslationModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(TranslationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), Translation.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, TranslationImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, TranslationImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			if (bindPortletId) {
				queryPos.add(portletId);
			}

			if (bindComponentId) {
				queryPos.add(componentId);
			}

			if (bindCultureCode) {
				queryPos.add(cultureCode);
			}

			return (List<Translation>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the translations before and after the current translation in the ordered set of translations that the user has permission to view where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * @param translationId the primary key of the current translation
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	@Override
	public Translation[]
			filterFindByPortletIdComponentIdCultureCode_PrevAndNext(
				long translationId, long groupId, String portletId,
				String componentId, String cultureCode,
				OrderByComparator<Translation> orderByComparator)
		throws NoSuchTranslationException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByPortletIdComponentIdCultureCode_PrevAndNext(
				translationId, groupId, portletId, componentId, cultureCode,
				orderByComparator);
		}

		portletId = Objects.toString(portletId, "");
		componentId = Objects.toString(componentId, "");
		cultureCode = Objects.toString(cultureCode, "");

		Translation translation = findByPrimaryKey(translationId);

		Session session = null;

		try {
			session = openSession();

			Translation[] array = new TranslationImpl[3];

			array[0] = filterGetByPortletIdComponentIdCultureCode_PrevAndNext(
				session, translation, groupId, portletId, componentId,
				cultureCode, orderByComparator, true);

			array[1] = translation;

			array[2] = filterGetByPortletIdComponentIdCultureCode_PrevAndNext(
				session, translation, groupId, portletId, componentId,
				cultureCode, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Translation
		filterGetByPortletIdComponentIdCultureCode_PrevAndNext(
			Session session, Translation translation, long groupId,
			String portletId, String componentId, String cultureCode,
			OrderByComparator<Translation> orderByComparator,
			boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				8 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(7);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_TRANSLATION_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_TRANSLATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_GROUPID_2);

		boolean bindPortletId = false;

		if (portletId.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_PORTLETID_3);
		}
		else {
			bindPortletId = true;

			sb.append(
				_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_PORTLETID_2);
		}

		boolean bindComponentId = false;

		if (componentId.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_COMPONENTID_3);
		}
		else {
			bindComponentId = true;

			sb.append(
				_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_COMPONENTID_2);
		}

		boolean bindCultureCode = false;

		if (cultureCode.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_CULTURECODE_3);
		}
		else {
			bindCultureCode = true;

			sb.append(
				_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_CULTURECODE_2);
		}

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_TRANSLATION_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(TranslationModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(TranslationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), Translation.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, TranslationImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, TranslationImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (bindPortletId) {
			queryPos.add(portletId);
		}

		if (bindComponentId) {
			queryPos.add(componentId);
		}

		if (bindCultureCode) {
			queryPos.add(cultureCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(translation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Translation> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the translations where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 */
	@Override
	public void removeByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId,
		String cultureCode) {

		for (Translation translation :
				findByPortletIdComponentIdCultureCode(
					groupId, portletId, componentId, cultureCode,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(translation);
		}
	}

	/**
	 * Returns the number of translations where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @return the number of matching translations
	 */
	@Override
	public int countByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId,
		String cultureCode) {

		portletId = Objects.toString(portletId, "");
		componentId = Objects.toString(componentId, "");
		cultureCode = Objects.toString(cultureCode, "");

		FinderPath finderPath =
			_finderPathCountByPortletIdComponentIdCultureCode;

		Object[] finderArgs = new Object[] {
			groupId, portletId, componentId, cultureCode
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_TRANSLATION_WHERE);

			sb.append(_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_GROUPID_2);

			boolean bindPortletId = false;

			if (portletId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_PORTLETID_3);
			}
			else {
				bindPortletId = true;

				sb.append(
					_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_PORTLETID_2);
			}

			boolean bindComponentId = false;

			if (componentId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_COMPONENTID_3);
			}
			else {
				bindComponentId = true;

				sb.append(
					_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_COMPONENTID_2);
			}

			boolean bindCultureCode = false;

			if (cultureCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_CULTURECODE_3);
			}
			else {
				bindCultureCode = true;

				sb.append(
					_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_CULTURECODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				if (bindPortletId) {
					queryPos.add(portletId);
				}

				if (bindComponentId) {
					queryPos.add(componentId);
				}

				if (bindCultureCode) {
					queryPos.add(cultureCode);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of translations that the user has permission to view where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @return the number of matching translations that the user has permission to view
	 */
	@Override
	public int filterCountByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId,
		String cultureCode) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByPortletIdComponentIdCultureCode(
				groupId, portletId, componentId, cultureCode);
		}

		portletId = Objects.toString(portletId, "");
		componentId = Objects.toString(componentId, "");
		cultureCode = Objects.toString(cultureCode, "");

		StringBundler sb = new StringBundler(5);

		sb.append(_FILTER_SQL_COUNT_TRANSLATION_WHERE);

		sb.append(_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_GROUPID_2);

		boolean bindPortletId = false;

		if (portletId.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_PORTLETID_3);
		}
		else {
			bindPortletId = true;

			sb.append(
				_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_PORTLETID_2);
		}

		boolean bindComponentId = false;

		if (componentId.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_COMPONENTID_3);
		}
		else {
			bindComponentId = true;

			sb.append(
				_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_COMPONENTID_2);
		}

		boolean bindCultureCode = false;

		if (cultureCode.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_CULTURECODE_3);
		}
		else {
			bindCultureCode = true;

			sb.append(
				_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_CULTURECODE_2);
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), Translation.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			if (bindPortletId) {
				queryPos.add(portletId);
			}

			if (bindComponentId) {
				queryPos.add(componentId);
			}

			if (bindCultureCode) {
				queryPos.add(cultureCode);
			}

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String
		_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_GROUPID_2 =
			"translation.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_PORTLETID_2 =
			"translation.portletId = ? AND ";

	private static final String
		_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_PORTLETID_3 =
			"(translation.portletId IS NULL OR translation.portletId = '') AND ";

	private static final String
		_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_COMPONENTID_2 =
			"translation.componentId = ? AND ";

	private static final String
		_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_COMPONENTID_3 =
			"(translation.componentId IS NULL OR translation.componentId = '') AND ";

	private static final String
		_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_CULTURECODE_2 =
			"translation.cultureCode = ?";

	private static final String
		_FINDER_COLUMN_PORTLETIDCOMPONENTIDCULTURECODE_CULTURECODE_3 =
			"(translation.cultureCode IS NULL OR translation.cultureCode = '')";

	public TranslationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("key", "key_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Translation.class);

		setModelImplClass(TranslationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the translation in the entity cache if it is enabled.
	 *
	 * @param translation the translation
	 */
	@Override
	public void cacheResult(Translation translation) {
		entityCache.putResult(
			TranslationImpl.class, translation.getPrimaryKey(), translation);

		finderCache.putResult(
			_finderPathFetchByTranslationId,
			new Object[] {translation.getTranslationId()}, translation);
	}

	/**
	 * Caches the translations in the entity cache if it is enabled.
	 *
	 * @param translations the translations
	 */
	@Override
	public void cacheResult(List<Translation> translations) {
		for (Translation translation : translations) {
			if (entityCache.getResult(
					TranslationImpl.class, translation.getPrimaryKey()) ==
						null) {

				cacheResult(translation);
			}
		}
	}

	/**
	 * Clears the cache for all translations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TranslationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the translation.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Translation translation) {
		entityCache.removeResult(TranslationImpl.class, translation);
	}

	@Override
	public void clearCache(List<Translation> translations) {
		for (Translation translation : translations) {
			entityCache.removeResult(TranslationImpl.class, translation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TranslationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TranslationModelImpl translationModelImpl) {

		Object[] args = new Object[] {translationModelImpl.getTranslationId()};

		finderCache.putResult(
			_finderPathCountByTranslationId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByTranslationId, args, translationModelImpl, false);
	}

	/**
	 * Creates a new translation with the primary key. Does not add the translation to the database.
	 *
	 * @param translationId the primary key for the new translation
	 * @return the new translation
	 */
	@Override
	public Translation create(long translationId) {
		Translation translation = new TranslationImpl();

		translation.setNew(true);
		translation.setPrimaryKey(translationId);

		translation.setCompanyId(CompanyThreadLocal.getCompanyId());

		return translation;
	}

	/**
	 * Removes the translation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param translationId the primary key of the translation
	 * @return the translation that was removed
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	@Override
	public Translation remove(long translationId)
		throws NoSuchTranslationException {

		return remove((Serializable)translationId);
	}

	/**
	 * Removes the translation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the translation
	 * @return the translation that was removed
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	@Override
	public Translation remove(Serializable primaryKey)
		throws NoSuchTranslationException {

		Session session = null;

		try {
			session = openSession();

			Translation translation = (Translation)session.get(
				TranslationImpl.class, primaryKey);

			if (translation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTranslationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(translation);
		}
		catch (NoSuchTranslationException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Translation removeImpl(Translation translation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(translation)) {
				translation = (Translation)session.get(
					TranslationImpl.class, translation.getPrimaryKeyObj());
			}

			if (translation != null) {
				session.delete(translation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (translation != null) {
			clearCache(translation);
		}

		return translation;
	}

	@Override
	public Translation updateImpl(Translation translation) {
		boolean isNew = translation.isNew();

		if (!(translation instanceof TranslationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(translation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(translation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in translation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Translation implementation " +
					translation.getClass());
		}

		TranslationModelImpl translationModelImpl =
			(TranslationModelImpl)translation;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (translation.getCreateDate() == null)) {
			if (serviceContext == null) {
				translation.setCreateDate(date);
			}
			else {
				translation.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!translationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				translation.setModifiedDate(date);
			}
			else {
				translation.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(translation);
			}
			else {
				translation = (Translation)session.merge(translation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TranslationImpl.class, translationModelImpl, false, true);

		cacheUniqueFindersCache(translationModelImpl);

		if (isNew) {
			translation.setNew(false);
		}

		translation.resetOriginalValues();

		return translation;
	}

	/**
	 * Returns the translation with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the translation
	 * @return the translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	@Override
	public Translation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTranslationException {

		Translation translation = fetchByPrimaryKey(primaryKey);

		if (translation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTranslationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return translation;
	}

	/**
	 * Returns the translation with the primary key or throws a <code>NoSuchTranslationException</code> if it could not be found.
	 *
	 * @param translationId the primary key of the translation
	 * @return the translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	@Override
	public Translation findByPrimaryKey(long translationId)
		throws NoSuchTranslationException {

		return findByPrimaryKey((Serializable)translationId);
	}

	/**
	 * Returns the translation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param translationId the primary key of the translation
	 * @return the translation, or <code>null</code> if a translation with the primary key could not be found
	 */
	@Override
	public Translation fetchByPrimaryKey(long translationId) {
		return fetchByPrimaryKey((Serializable)translationId);
	}

	/**
	 * Returns all the translations.
	 *
	 * @return the translations
	 */
	@Override
	public List<Translation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the translations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @return the range of translations
	 */
	@Override
	public List<Translation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the translations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of translations
	 */
	@Override
	public List<Translation> findAll(
		int start, int end, OrderByComparator<Translation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the translations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of translations
	 */
	@Override
	public List<Translation> findAll(
		int start, int end, OrderByComparator<Translation> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Translation> list = null;

		if (useFinderCache) {
			list = (List<Translation>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TRANSLATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TRANSLATION;

				sql = sql.concat(TranslationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Translation>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the translations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Translation translation : findAll()) {
			remove(translation);
		}
	}

	/**
	 * Returns the number of translations.
	 *
	 * @return the number of translations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TRANSLATION);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "translationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRANSLATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TranslationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the translation persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new TranslationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Translation.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByTranslationId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByTranslationId",
			new String[] {Long.class.getName()}, new String[] {"translationId"},
			true);

		_finderPathCountByTranslationId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTranslationId",
			new String[] {Long.class.getName()}, new String[] {"translationId"},
			false);

		_finderPathWithPaginationFindByGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId"}, true);

		_finderPathWithoutPaginationFindByGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			true);

		_finderPathCountByGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			false);

		_finderPathWithPaginationFindByPortletIdAndCultureCode =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByPortletIdAndCultureCode",
				new String[] {
					Long.class.getName(), String.class.getName(),
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"groupId", "portletId", "cultureCode"}, true);

		_finderPathWithoutPaginationFindByPortletIdAndCultureCode =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByPortletIdAndCultureCode",
				new String[] {
					Long.class.getName(), String.class.getName(),
					String.class.getName()
				},
				new String[] {"groupId", "portletId", "cultureCode"}, true);

		_finderPathCountByPortletIdAndCultureCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPortletIdAndCultureCode",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"groupId", "portletId", "cultureCode"}, false);

		_finderPathWithPaginationFindByGroupIdAndPortletId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupIdAndPortletId",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"groupId", "portletId"}, true);

		_finderPathWithoutPaginationFindByGroupIdAndPortletId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByGroupIdAndPortletId",
				new String[] {Long.class.getName(), String.class.getName()},
				new String[] {"groupId", "portletId"}, true);

		_finderPathCountByGroupIdAndPortletId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdAndPortletId",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"groupId", "portletId"}, false);

		_finderPathWithPaginationFindByPortletIdComponentIdCultureCode =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByPortletIdComponentIdCultureCode",
				new String[] {
					Long.class.getName(), String.class.getName(),
					String.class.getName(), String.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {
					"groupId", "portletId", "componentId", "cultureCode"
				},
				true);

		_finderPathWithoutPaginationFindByPortletIdComponentIdCultureCode =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByPortletIdComponentIdCultureCode",
				new String[] {
					Long.class.getName(), String.class.getName(),
					String.class.getName(), String.class.getName()
				},
				new String[] {
					"groupId", "portletId", "componentId", "cultureCode"
				},
				true);

		_finderPathCountByPortletIdComponentIdCultureCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPortletIdComponentIdCultureCode",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			},
			new String[] {"groupId", "portletId", "componentId", "cultureCode"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(TranslationImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = ExpenseManagerPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = ExpenseManagerPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ExpenseManagerPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_TRANSLATION =
		"SELECT translation FROM Translation translation";

	private static final String _SQL_SELECT_TRANSLATION_WHERE =
		"SELECT translation FROM Translation translation WHERE ";

	private static final String _SQL_COUNT_TRANSLATION =
		"SELECT COUNT(translation) FROM Translation translation";

	private static final String _SQL_COUNT_TRANSLATION_WHERE =
		"SELECT COUNT(translation) FROM Translation translation WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"translation.translationId";

	private static final String _FILTER_SQL_SELECT_TRANSLATION_WHERE =
		"SELECT DISTINCT {translation.*} FROM ExpenseManager_Translation translation WHERE ";

	private static final String
		_FILTER_SQL_SELECT_TRANSLATION_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {ExpenseManager_Translation.*} FROM (SELECT DISTINCT translation.translationId FROM ExpenseManager_Translation translation WHERE ";

	private static final String
		_FILTER_SQL_SELECT_TRANSLATION_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN ExpenseManager_Translation ON TEMP_TABLE.translationId = ExpenseManager_Translation.translationId";

	private static final String _FILTER_SQL_COUNT_TRANSLATION_WHERE =
		"SELECT COUNT(DISTINCT translation.translationId) AS COUNT_VALUE FROM ExpenseManager_Translation translation WHERE ";

	private static final String _FILTER_ENTITY_ALIAS = "translation";

	private static final String _FILTER_ENTITY_TABLE =
		"ExpenseManager_Translation";

	private static final String _ORDER_BY_ENTITY_ALIAS = "translation.";

	private static final String _ORDER_BY_ENTITY_TABLE =
		"ExpenseManager_Translation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Translation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Translation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TranslationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"key"});

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class TranslationModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			TranslationModelImpl translationModelImpl =
				(TranslationModelImpl)baseModel;

			long columnBitmask = translationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(translationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						translationModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(translationModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			TranslationModelImpl translationModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = translationModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = translationModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}