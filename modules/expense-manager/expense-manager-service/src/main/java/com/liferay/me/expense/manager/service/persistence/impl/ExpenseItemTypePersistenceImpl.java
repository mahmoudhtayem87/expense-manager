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

import com.liferay.me.expense.manager.exception.NoSuchExpenseItemTypeException;
import com.liferay.me.expense.manager.model.ExpenseItemType;
import com.liferay.me.expense.manager.model.impl.ExpenseItemTypeImpl;
import com.liferay.me.expense.manager.model.impl.ExpenseItemTypeModelImpl;
import com.liferay.me.expense.manager.service.persistence.ExpenseItemTypePersistence;
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

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
 * The persistence implementation for the expense item type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @generated
 */
@Component(service = ExpenseItemTypePersistence.class)
public class ExpenseItemTypePersistenceImpl
	extends BasePersistenceImpl<ExpenseItemType>
	implements ExpenseItemTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ExpenseItemTypeUtil</code> to access the expense item type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ExpenseItemTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the expense item types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching expense item types
	 */
	@Override
	public List<ExpenseItemType> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the expense item types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of expense item types
	 * @param end the upper bound of the range of expense item types (not inclusive)
	 * @return the range of matching expense item types
	 */
	@Override
	public List<ExpenseItemType> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the expense item types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of expense item types
	 * @param end the upper bound of the range of expense item types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expense item types
	 */
	@Override
	public List<ExpenseItemType> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ExpenseItemType> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the expense item types where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of expense item types
	 * @param end the upper bound of the range of expense item types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching expense item types
	 */
	@Override
	public List<ExpenseItemType> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ExpenseItemType> orderByComparator,
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

		List<ExpenseItemType> list = null;

		if (useFinderCache) {
			list = (List<ExpenseItemType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ExpenseItemType expenseItemType : list) {
					if (groupId != expenseItemType.getGroupId()) {
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

			sb.append(_SQL_SELECT_EXPENSEITEMTYPE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ExpenseItemTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<ExpenseItemType>)QueryUtil.list(
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
	 * Returns the first expense item type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item type
	 * @throws NoSuchExpenseItemTypeException if a matching expense item type could not be found
	 */
	@Override
	public ExpenseItemType findByGroupId_First(
			long groupId, OrderByComparator<ExpenseItemType> orderByComparator)
		throws NoSuchExpenseItemTypeException {

		ExpenseItemType expenseItemType = fetchByGroupId_First(
			groupId, orderByComparator);

		if (expenseItemType != null) {
			return expenseItemType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchExpenseItemTypeException(sb.toString());
	}

	/**
	 * Returns the first expense item type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item type, or <code>null</code> if a matching expense item type could not be found
	 */
	@Override
	public ExpenseItemType fetchByGroupId_First(
		long groupId, OrderByComparator<ExpenseItemType> orderByComparator) {

		List<ExpenseItemType> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last expense item type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item type
	 * @throws NoSuchExpenseItemTypeException if a matching expense item type could not be found
	 */
	@Override
	public ExpenseItemType findByGroupId_Last(
			long groupId, OrderByComparator<ExpenseItemType> orderByComparator)
		throws NoSuchExpenseItemTypeException {

		ExpenseItemType expenseItemType = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (expenseItemType != null) {
			return expenseItemType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchExpenseItemTypeException(sb.toString());
	}

	/**
	 * Returns the last expense item type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item type, or <code>null</code> if a matching expense item type could not be found
	 */
	@Override
	public ExpenseItemType fetchByGroupId_Last(
		long groupId, OrderByComparator<ExpenseItemType> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ExpenseItemType> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the expense item types before and after the current expense item type in the ordered set where groupId = &#63;.
	 *
	 * @param expenseItemTypeId the primary key of the current expense item type
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense item type
	 * @throws NoSuchExpenseItemTypeException if a expense item type with the primary key could not be found
	 */
	@Override
	public ExpenseItemType[] findByGroupId_PrevAndNext(
			long expenseItemTypeId, long groupId,
			OrderByComparator<ExpenseItemType> orderByComparator)
		throws NoSuchExpenseItemTypeException {

		ExpenseItemType expenseItemType = findByPrimaryKey(expenseItemTypeId);

		Session session = null;

		try {
			session = openSession();

			ExpenseItemType[] array = new ExpenseItemTypeImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, expenseItemType, groupId, orderByComparator, true);

			array[1] = expenseItemType;

			array[2] = getByGroupId_PrevAndNext(
				session, expenseItemType, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ExpenseItemType getByGroupId_PrevAndNext(
		Session session, ExpenseItemType expenseItemType, long groupId,
		OrderByComparator<ExpenseItemType> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EXPENSEITEMTYPE_WHERE);

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
			sb.append(ExpenseItemTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						expenseItemType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ExpenseItemType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the expense item types that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching expense item types that the user has permission to view
	 */
	@Override
	public List<ExpenseItemType> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the expense item types that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of expense item types
	 * @param end the upper bound of the range of expense item types (not inclusive)
	 * @return the range of matching expense item types that the user has permission to view
	 */
	@Override
	public List<ExpenseItemType> filterFindByGroupId(
		long groupId, int start, int end) {

		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the expense item types that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of expense item types
	 * @param end the upper bound of the range of expense item types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expense item types that the user has permission to view
	 */
	@Override
	public List<ExpenseItemType> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ExpenseItemType> orderByComparator) {

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
			sb.append(_FILTER_SQL_SELECT_EXPENSEITEMTYPE_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_EXPENSEITEMTYPE_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_EXPENSEITEMTYPE_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(ExpenseItemTypeModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(ExpenseItemTypeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ExpenseItemType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(
					_FILTER_ENTITY_ALIAS, ExpenseItemTypeImpl.class);
			}
			else {
				sqlQuery.addEntity(
					_FILTER_ENTITY_TABLE, ExpenseItemTypeImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			return (List<ExpenseItemType>)QueryUtil.list(
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
	 * Returns the expense item types before and after the current expense item type in the ordered set of expense item types that the user has permission to view where groupId = &#63;.
	 *
	 * @param expenseItemTypeId the primary key of the current expense item type
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense item type
	 * @throws NoSuchExpenseItemTypeException if a expense item type with the primary key could not be found
	 */
	@Override
	public ExpenseItemType[] filterFindByGroupId_PrevAndNext(
			long expenseItemTypeId, long groupId,
			OrderByComparator<ExpenseItemType> orderByComparator)
		throws NoSuchExpenseItemTypeException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(
				expenseItemTypeId, groupId, orderByComparator);
		}

		ExpenseItemType expenseItemType = findByPrimaryKey(expenseItemTypeId);

		Session session = null;

		try {
			session = openSession();

			ExpenseItemType[] array = new ExpenseItemTypeImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(
				session, expenseItemType, groupId, orderByComparator, true);

			array[1] = expenseItemType;

			array[2] = filterGetByGroupId_PrevAndNext(
				session, expenseItemType, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ExpenseItemType filterGetByGroupId_PrevAndNext(
		Session session, ExpenseItemType expenseItemType, long groupId,
		OrderByComparator<ExpenseItemType> orderByComparator,
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

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_EXPENSEITEMTYPE_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_EXPENSEITEMTYPE_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_EXPENSEITEMTYPE_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(ExpenseItemTypeModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(ExpenseItemTypeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ExpenseItemType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, ExpenseItemTypeImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, ExpenseItemTypeImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						expenseItemType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ExpenseItemType> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the expense item types where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (ExpenseItemType expenseItemType :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(expenseItemType);
		}
	}

	/**
	 * Returns the number of expense item types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching expense item types
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EXPENSEITEMTYPE_WHERE);

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
	 * Returns the number of expense item types that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching expense item types that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler sb = new StringBundler(2);

		sb.append(_FILTER_SQL_COUNT_EXPENSEITEMTYPE_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ExpenseItemType.class.getName(),
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
		"expenseItemType.groupId = ?";

	private FinderPath _finderPathFetchByExpenseItemTypeId;
	private FinderPath _finderPathCountByExpenseItemTypeId;

	/**
	 * Returns the expense item type where expenseItemTypeId = &#63; or throws a <code>NoSuchExpenseItemTypeException</code> if it could not be found.
	 *
	 * @param expenseItemTypeId the expense item type ID
	 * @return the matching expense item type
	 * @throws NoSuchExpenseItemTypeException if a matching expense item type could not be found
	 */
	@Override
	public ExpenseItemType findByExpenseItemTypeId(long expenseItemTypeId)
		throws NoSuchExpenseItemTypeException {

		ExpenseItemType expenseItemType = fetchByExpenseItemTypeId(
			expenseItemTypeId);

		if (expenseItemType == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("expenseItemTypeId=");
			sb.append(expenseItemTypeId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchExpenseItemTypeException(sb.toString());
		}

		return expenseItemType;
	}

	/**
	 * Returns the expense item type where expenseItemTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param expenseItemTypeId the expense item type ID
	 * @return the matching expense item type, or <code>null</code> if a matching expense item type could not be found
	 */
	@Override
	public ExpenseItemType fetchByExpenseItemTypeId(long expenseItemTypeId) {
		return fetchByExpenseItemTypeId(expenseItemTypeId, true);
	}

	/**
	 * Returns the expense item type where expenseItemTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param expenseItemTypeId the expense item type ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching expense item type, or <code>null</code> if a matching expense item type could not be found
	 */
	@Override
	public ExpenseItemType fetchByExpenseItemTypeId(
		long expenseItemTypeId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {expenseItemTypeId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByExpenseItemTypeId, finderArgs, this);
		}

		if (result instanceof ExpenseItemType) {
			ExpenseItemType expenseItemType = (ExpenseItemType)result;

			if (expenseItemTypeId != expenseItemType.getExpenseItemTypeId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_EXPENSEITEMTYPE_WHERE);

			sb.append(_FINDER_COLUMN_EXPENSEITEMTYPEID_EXPENSEITEMTYPEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(expenseItemTypeId);

				List<ExpenseItemType> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByExpenseItemTypeId, finderArgs,
							list);
					}
				}
				else {
					ExpenseItemType expenseItemType = list.get(0);

					result = expenseItemType;

					cacheResult(expenseItemType);
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
			return (ExpenseItemType)result;
		}
	}

	/**
	 * Removes the expense item type where expenseItemTypeId = &#63; from the database.
	 *
	 * @param expenseItemTypeId the expense item type ID
	 * @return the expense item type that was removed
	 */
	@Override
	public ExpenseItemType removeByExpenseItemTypeId(long expenseItemTypeId)
		throws NoSuchExpenseItemTypeException {

		ExpenseItemType expenseItemType = findByExpenseItemTypeId(
			expenseItemTypeId);

		return remove(expenseItemType);
	}

	/**
	 * Returns the number of expense item types where expenseItemTypeId = &#63;.
	 *
	 * @param expenseItemTypeId the expense item type ID
	 * @return the number of matching expense item types
	 */
	@Override
	public int countByExpenseItemTypeId(long expenseItemTypeId) {
		FinderPath finderPath = _finderPathCountByExpenseItemTypeId;

		Object[] finderArgs = new Object[] {expenseItemTypeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EXPENSEITEMTYPE_WHERE);

			sb.append(_FINDER_COLUMN_EXPENSEITEMTYPEID_EXPENSEITEMTYPEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(expenseItemTypeId);

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

	private static final String
		_FINDER_COLUMN_EXPENSEITEMTYPEID_EXPENSEITEMTYPEID_2 =
			"expenseItemType.expenseItemTypeId = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the expense item types where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching expense item types
	 */
	@Override
	public List<ExpenseItemType> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the expense item types where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemTypeModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of expense item types
	 * @param end the upper bound of the range of expense item types (not inclusive)
	 * @return the range of matching expense item types
	 */
	@Override
	public List<ExpenseItemType> findByStatus(int status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the expense item types where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemTypeModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of expense item types
	 * @param end the upper bound of the range of expense item types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expense item types
	 */
	@Override
	public List<ExpenseItemType> findByStatus(
		int status, int start, int end,
		OrderByComparator<ExpenseItemType> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the expense item types where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemTypeModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of expense item types
	 * @param end the upper bound of the range of expense item types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching expense item types
	 */
	@Override
	public List<ExpenseItemType> findByStatus(
		int status, int start, int end,
		OrderByComparator<ExpenseItemType> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<ExpenseItemType> list = null;

		if (useFinderCache) {
			list = (List<ExpenseItemType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ExpenseItemType expenseItemType : list) {
					if (status != expenseItemType.getStatus()) {
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

			sb.append(_SQL_SELECT_EXPENSEITEMTYPE_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ExpenseItemTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<ExpenseItemType>)QueryUtil.list(
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
	 * Returns the first expense item type in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item type
	 * @throws NoSuchExpenseItemTypeException if a matching expense item type could not be found
	 */
	@Override
	public ExpenseItemType findByStatus_First(
			int status, OrderByComparator<ExpenseItemType> orderByComparator)
		throws NoSuchExpenseItemTypeException {

		ExpenseItemType expenseItemType = fetchByStatus_First(
			status, orderByComparator);

		if (expenseItemType != null) {
			return expenseItemType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchExpenseItemTypeException(sb.toString());
	}

	/**
	 * Returns the first expense item type in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item type, or <code>null</code> if a matching expense item type could not be found
	 */
	@Override
	public ExpenseItemType fetchByStatus_First(
		int status, OrderByComparator<ExpenseItemType> orderByComparator) {

		List<ExpenseItemType> list = findByStatus(
			status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last expense item type in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item type
	 * @throws NoSuchExpenseItemTypeException if a matching expense item type could not be found
	 */
	@Override
	public ExpenseItemType findByStatus_Last(
			int status, OrderByComparator<ExpenseItemType> orderByComparator)
		throws NoSuchExpenseItemTypeException {

		ExpenseItemType expenseItemType = fetchByStatus_Last(
			status, orderByComparator);

		if (expenseItemType != null) {
			return expenseItemType;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchExpenseItemTypeException(sb.toString());
	}

	/**
	 * Returns the last expense item type in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item type, or <code>null</code> if a matching expense item type could not be found
	 */
	@Override
	public ExpenseItemType fetchByStatus_Last(
		int status, OrderByComparator<ExpenseItemType> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<ExpenseItemType> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the expense item types before and after the current expense item type in the ordered set where status = &#63;.
	 *
	 * @param expenseItemTypeId the primary key of the current expense item type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense item type
	 * @throws NoSuchExpenseItemTypeException if a expense item type with the primary key could not be found
	 */
	@Override
	public ExpenseItemType[] findByStatus_PrevAndNext(
			long expenseItemTypeId, int status,
			OrderByComparator<ExpenseItemType> orderByComparator)
		throws NoSuchExpenseItemTypeException {

		ExpenseItemType expenseItemType = findByPrimaryKey(expenseItemTypeId);

		Session session = null;

		try {
			session = openSession();

			ExpenseItemType[] array = new ExpenseItemTypeImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, expenseItemType, status, orderByComparator, true);

			array[1] = expenseItemType;

			array[2] = getByStatus_PrevAndNext(
				session, expenseItemType, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ExpenseItemType getByStatus_PrevAndNext(
		Session session, ExpenseItemType expenseItemType, int status,
		OrderByComparator<ExpenseItemType> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EXPENSEITEMTYPE_WHERE);

		sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			sb.append(ExpenseItemTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						expenseItemType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ExpenseItemType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the expense item types where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (ExpenseItemType expenseItemType :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(expenseItemType);
		}
	}

	/**
	 * Returns the number of expense item types where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching expense item types
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EXPENSEITEMTYPE_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"expenseItemType.status = ?";

	private FinderPath _finderPathWithPaginationFindByG_S;
	private FinderPath _finderPathWithoutPaginationFindByG_S;
	private FinderPath _finderPathCountByG_S;

	/**
	 * Returns all the expense item types where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching expense item types
	 */
	@Override
	public List<ExpenseItemType> findByG_S(long groupId, int status) {
		return findByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the expense item types where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of expense item types
	 * @param end the upper bound of the range of expense item types (not inclusive)
	 * @return the range of matching expense item types
	 */
	@Override
	public List<ExpenseItemType> findByG_S(
		long groupId, int status, int start, int end) {

		return findByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the expense item types where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of expense item types
	 * @param end the upper bound of the range of expense item types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expense item types
	 */
	@Override
	public List<ExpenseItemType> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<ExpenseItemType> orderByComparator) {

		return findByG_S(groupId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the expense item types where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of expense item types
	 * @param end the upper bound of the range of expense item types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching expense item types
	 */
	@Override
	public List<ExpenseItemType> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<ExpenseItemType> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_S;
				finderArgs = new Object[] {groupId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_S;
			finderArgs = new Object[] {
				groupId, status, start, end, orderByComparator
			};
		}

		List<ExpenseItemType> list = null;

		if (useFinderCache) {
			list = (List<ExpenseItemType>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ExpenseItemType expenseItemType : list) {
					if ((groupId != expenseItemType.getGroupId()) ||
						(status != expenseItemType.getStatus())) {

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

			sb.append(_SQL_SELECT_EXPENSEITEMTYPE_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ExpenseItemTypeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				list = (List<ExpenseItemType>)QueryUtil.list(
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
	 * Returns the first expense item type in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item type
	 * @throws NoSuchExpenseItemTypeException if a matching expense item type could not be found
	 */
	@Override
	public ExpenseItemType findByG_S_First(
			long groupId, int status,
			OrderByComparator<ExpenseItemType> orderByComparator)
		throws NoSuchExpenseItemTypeException {

		ExpenseItemType expenseItemType = fetchByG_S_First(
			groupId, status, orderByComparator);

		if (expenseItemType != null) {
			return expenseItemType;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchExpenseItemTypeException(sb.toString());
	}

	/**
	 * Returns the first expense item type in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item type, or <code>null</code> if a matching expense item type could not be found
	 */
	@Override
	public ExpenseItemType fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<ExpenseItemType> orderByComparator) {

		List<ExpenseItemType> list = findByG_S(
			groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last expense item type in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item type
	 * @throws NoSuchExpenseItemTypeException if a matching expense item type could not be found
	 */
	@Override
	public ExpenseItemType findByG_S_Last(
			long groupId, int status,
			OrderByComparator<ExpenseItemType> orderByComparator)
		throws NoSuchExpenseItemTypeException {

		ExpenseItemType expenseItemType = fetchByG_S_Last(
			groupId, status, orderByComparator);

		if (expenseItemType != null) {
			return expenseItemType;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchExpenseItemTypeException(sb.toString());
	}

	/**
	 * Returns the last expense item type in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item type, or <code>null</code> if a matching expense item type could not be found
	 */
	@Override
	public ExpenseItemType fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<ExpenseItemType> orderByComparator) {

		int count = countByG_S(groupId, status);

		if (count == 0) {
			return null;
		}

		List<ExpenseItemType> list = findByG_S(
			groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the expense item types before and after the current expense item type in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param expenseItemTypeId the primary key of the current expense item type
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense item type
	 * @throws NoSuchExpenseItemTypeException if a expense item type with the primary key could not be found
	 */
	@Override
	public ExpenseItemType[] findByG_S_PrevAndNext(
			long expenseItemTypeId, long groupId, int status,
			OrderByComparator<ExpenseItemType> orderByComparator)
		throws NoSuchExpenseItemTypeException {

		ExpenseItemType expenseItemType = findByPrimaryKey(expenseItemTypeId);

		Session session = null;

		try {
			session = openSession();

			ExpenseItemType[] array = new ExpenseItemTypeImpl[3];

			array[0] = getByG_S_PrevAndNext(
				session, expenseItemType, groupId, status, orderByComparator,
				true);

			array[1] = expenseItemType;

			array[2] = getByG_S_PrevAndNext(
				session, expenseItemType, groupId, status, orderByComparator,
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

	protected ExpenseItemType getByG_S_PrevAndNext(
		Session session, ExpenseItemType expenseItemType, long groupId,
		int status, OrderByComparator<ExpenseItemType> orderByComparator,
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

		sb.append(_SQL_SELECT_EXPENSEITEMTYPE_WHERE);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

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
			sb.append(ExpenseItemTypeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						expenseItemType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ExpenseItemType> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the expense item types that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching expense item types that the user has permission to view
	 */
	@Override
	public List<ExpenseItemType> filterFindByG_S(long groupId, int status) {
		return filterFindByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the expense item types that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of expense item types
	 * @param end the upper bound of the range of expense item types (not inclusive)
	 * @return the range of matching expense item types that the user has permission to view
	 */
	@Override
	public List<ExpenseItemType> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return filterFindByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the expense item types that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemTypeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of expense item types
	 * @param end the upper bound of the range of expense item types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expense item types that the user has permission to view
	 */
	@Override
	public List<ExpenseItemType> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<ExpenseItemType> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S(groupId, status, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_EXPENSEITEMTYPE_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_EXPENSEITEMTYPE_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_EXPENSEITEMTYPE_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(ExpenseItemTypeModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(ExpenseItemTypeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ExpenseItemType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(
					_FILTER_ENTITY_ALIAS, ExpenseItemTypeImpl.class);
			}
			else {
				sqlQuery.addEntity(
					_FILTER_ENTITY_TABLE, ExpenseItemTypeImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(status);

			return (List<ExpenseItemType>)QueryUtil.list(
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
	 * Returns the expense item types before and after the current expense item type in the ordered set of expense item types that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param expenseItemTypeId the primary key of the current expense item type
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense item type
	 * @throws NoSuchExpenseItemTypeException if a expense item type with the primary key could not be found
	 */
	@Override
	public ExpenseItemType[] filterFindByG_S_PrevAndNext(
			long expenseItemTypeId, long groupId, int status,
			OrderByComparator<ExpenseItemType> orderByComparator)
		throws NoSuchExpenseItemTypeException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_PrevAndNext(
				expenseItemTypeId, groupId, status, orderByComparator);
		}

		ExpenseItemType expenseItemType = findByPrimaryKey(expenseItemTypeId);

		Session session = null;

		try {
			session = openSession();

			ExpenseItemType[] array = new ExpenseItemTypeImpl[3];

			array[0] = filterGetByG_S_PrevAndNext(
				session, expenseItemType, groupId, status, orderByComparator,
				true);

			array[1] = expenseItemType;

			array[2] = filterGetByG_S_PrevAndNext(
				session, expenseItemType, groupId, status, orderByComparator,
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

	protected ExpenseItemType filterGetByG_S_PrevAndNext(
		Session session, ExpenseItemType expenseItemType, long groupId,
		int status, OrderByComparator<ExpenseItemType> orderByComparator,
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
			sb.append(_FILTER_SQL_SELECT_EXPENSEITEMTYPE_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_EXPENSEITEMTYPE_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_EXPENSEITEMTYPE_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(ExpenseItemTypeModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(ExpenseItemTypeModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ExpenseItemType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, ExpenseItemTypeImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, ExpenseItemTypeImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						expenseItemType)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ExpenseItemType> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the expense item types where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeByG_S(long groupId, int status) {
		for (ExpenseItemType expenseItemType :
				findByG_S(
					groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(expenseItemType);
		}
	}

	/**
	 * Returns the number of expense item types where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching expense item types
	 */
	@Override
	public int countByG_S(long groupId, int status) {
		FinderPath finderPath = _finderPathCountByG_S;

		Object[] finderArgs = new Object[] {groupId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EXPENSEITEMTYPE_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

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
	 * Returns the number of expense item types that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching expense item types that the user has permission to view
	 */
	@Override
	public int filterCountByG_S(long groupId, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S(groupId, status);
		}

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_EXPENSEITEMTYPE_WHERE);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ExpenseItemType.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(status);

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

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 =
		"expenseItemType.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_STATUS_2 =
		"expenseItemType.status = ?";

	public ExpenseItemTypePersistenceImpl() {
		setModelClass(ExpenseItemType.class);

		setModelImplClass(ExpenseItemTypeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the expense item type in the entity cache if it is enabled.
	 *
	 * @param expenseItemType the expense item type
	 */
	@Override
	public void cacheResult(ExpenseItemType expenseItemType) {
		entityCache.putResult(
			ExpenseItemTypeImpl.class, expenseItemType.getPrimaryKey(),
			expenseItemType);

		finderCache.putResult(
			_finderPathFetchByExpenseItemTypeId,
			new Object[] {expenseItemType.getExpenseItemTypeId()},
			expenseItemType);
	}

	/**
	 * Caches the expense item types in the entity cache if it is enabled.
	 *
	 * @param expenseItemTypes the expense item types
	 */
	@Override
	public void cacheResult(List<ExpenseItemType> expenseItemTypes) {
		for (ExpenseItemType expenseItemType : expenseItemTypes) {
			if (entityCache.getResult(
					ExpenseItemTypeImpl.class,
					expenseItemType.getPrimaryKey()) == null) {

				cacheResult(expenseItemType);
			}
		}
	}

	/**
	 * Clears the cache for all expense item types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ExpenseItemTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the expense item type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ExpenseItemType expenseItemType) {
		entityCache.removeResult(ExpenseItemTypeImpl.class, expenseItemType);
	}

	@Override
	public void clearCache(List<ExpenseItemType> expenseItemTypes) {
		for (ExpenseItemType expenseItemType : expenseItemTypes) {
			entityCache.removeResult(
				ExpenseItemTypeImpl.class, expenseItemType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ExpenseItemTypeImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ExpenseItemTypeModelImpl expenseItemTypeModelImpl) {

		Object[] args = new Object[] {
			expenseItemTypeModelImpl.getExpenseItemTypeId()
		};

		finderCache.putResult(
			_finderPathCountByExpenseItemTypeId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByExpenseItemTypeId, args, expenseItemTypeModelImpl,
			false);
	}

	/**
	 * Creates a new expense item type with the primary key. Does not add the expense item type to the database.
	 *
	 * @param expenseItemTypeId the primary key for the new expense item type
	 * @return the new expense item type
	 */
	@Override
	public ExpenseItemType create(long expenseItemTypeId) {
		ExpenseItemType expenseItemType = new ExpenseItemTypeImpl();

		expenseItemType.setNew(true);
		expenseItemType.setPrimaryKey(expenseItemTypeId);

		expenseItemType.setCompanyId(CompanyThreadLocal.getCompanyId());

		return expenseItemType;
	}

	/**
	 * Removes the expense item type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param expenseItemTypeId the primary key of the expense item type
	 * @return the expense item type that was removed
	 * @throws NoSuchExpenseItemTypeException if a expense item type with the primary key could not be found
	 */
	@Override
	public ExpenseItemType remove(long expenseItemTypeId)
		throws NoSuchExpenseItemTypeException {

		return remove((Serializable)expenseItemTypeId);
	}

	/**
	 * Removes the expense item type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the expense item type
	 * @return the expense item type that was removed
	 * @throws NoSuchExpenseItemTypeException if a expense item type with the primary key could not be found
	 */
	@Override
	public ExpenseItemType remove(Serializable primaryKey)
		throws NoSuchExpenseItemTypeException {

		Session session = null;

		try {
			session = openSession();

			ExpenseItemType expenseItemType = (ExpenseItemType)session.get(
				ExpenseItemTypeImpl.class, primaryKey);

			if (expenseItemType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExpenseItemTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(expenseItemType);
		}
		catch (NoSuchExpenseItemTypeException noSuchEntityException) {
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
	protected ExpenseItemType removeImpl(ExpenseItemType expenseItemType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(expenseItemType)) {
				expenseItemType = (ExpenseItemType)session.get(
					ExpenseItemTypeImpl.class,
					expenseItemType.getPrimaryKeyObj());
			}

			if (expenseItemType != null) {
				session.delete(expenseItemType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (expenseItemType != null) {
			clearCache(expenseItemType);
		}

		return expenseItemType;
	}

	@Override
	public ExpenseItemType updateImpl(ExpenseItemType expenseItemType) {
		boolean isNew = expenseItemType.isNew();

		if (!(expenseItemType instanceof ExpenseItemTypeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(expenseItemType.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					expenseItemType);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in expenseItemType proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ExpenseItemType implementation " +
					expenseItemType.getClass());
		}

		ExpenseItemTypeModelImpl expenseItemTypeModelImpl =
			(ExpenseItemTypeModelImpl)expenseItemType;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (expenseItemType.getCreateDate() == null)) {
			if (serviceContext == null) {
				expenseItemType.setCreateDate(date);
			}
			else {
				expenseItemType.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!expenseItemTypeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				expenseItemType.setModifiedDate(date);
			}
			else {
				expenseItemType.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(expenseItemType);
			}
			else {
				expenseItemType = (ExpenseItemType)session.merge(
					expenseItemType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ExpenseItemTypeImpl.class, expenseItemTypeModelImpl, false, true);

		cacheUniqueFindersCache(expenseItemTypeModelImpl);

		if (isNew) {
			expenseItemType.setNew(false);
		}

		expenseItemType.resetOriginalValues();

		return expenseItemType;
	}

	/**
	 * Returns the expense item type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the expense item type
	 * @return the expense item type
	 * @throws NoSuchExpenseItemTypeException if a expense item type with the primary key could not be found
	 */
	@Override
	public ExpenseItemType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExpenseItemTypeException {

		ExpenseItemType expenseItemType = fetchByPrimaryKey(primaryKey);

		if (expenseItemType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExpenseItemTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return expenseItemType;
	}

	/**
	 * Returns the expense item type with the primary key or throws a <code>NoSuchExpenseItemTypeException</code> if it could not be found.
	 *
	 * @param expenseItemTypeId the primary key of the expense item type
	 * @return the expense item type
	 * @throws NoSuchExpenseItemTypeException if a expense item type with the primary key could not be found
	 */
	@Override
	public ExpenseItemType findByPrimaryKey(long expenseItemTypeId)
		throws NoSuchExpenseItemTypeException {

		return findByPrimaryKey((Serializable)expenseItemTypeId);
	}

	/**
	 * Returns the expense item type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param expenseItemTypeId the primary key of the expense item type
	 * @return the expense item type, or <code>null</code> if a expense item type with the primary key could not be found
	 */
	@Override
	public ExpenseItemType fetchByPrimaryKey(long expenseItemTypeId) {
		return fetchByPrimaryKey((Serializable)expenseItemTypeId);
	}

	/**
	 * Returns all the expense item types.
	 *
	 * @return the expense item types
	 */
	@Override
	public List<ExpenseItemType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the expense item types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of expense item types
	 * @param end the upper bound of the range of expense item types (not inclusive)
	 * @return the range of expense item types
	 */
	@Override
	public List<ExpenseItemType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the expense item types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of expense item types
	 * @param end the upper bound of the range of expense item types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of expense item types
	 */
	@Override
	public List<ExpenseItemType> findAll(
		int start, int end,
		OrderByComparator<ExpenseItemType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the expense item types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of expense item types
	 * @param end the upper bound of the range of expense item types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of expense item types
	 */
	@Override
	public List<ExpenseItemType> findAll(
		int start, int end,
		OrderByComparator<ExpenseItemType> orderByComparator,
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

		List<ExpenseItemType> list = null;

		if (useFinderCache) {
			list = (List<ExpenseItemType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EXPENSEITEMTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EXPENSEITEMTYPE;

				sql = sql.concat(ExpenseItemTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ExpenseItemType>)QueryUtil.list(
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
	 * Removes all the expense item types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ExpenseItemType expenseItemType : findAll()) {
			remove(expenseItemType);
		}
	}

	/**
	 * Returns the number of expense item types.
	 *
	 * @return the number of expense item types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EXPENSEITEMTYPE);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "expenseItemTypeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EXPENSEITEMTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ExpenseItemTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the expense item type persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new ExpenseItemTypeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ExpenseItemType.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

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

		_finderPathFetchByExpenseItemTypeId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByExpenseItemTypeId",
			new String[] {Long.class.getName()},
			new String[] {"expenseItemTypeId"}, true);

		_finderPathCountByExpenseItemTypeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByExpenseItemTypeId", new String[] {Long.class.getName()},
			new String[] {"expenseItemTypeId"}, false);

		_finderPathWithPaginationFindByStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"status"}, true);

		_finderPathWithoutPaginationFindByStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			true);

		_finderPathCountByStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			false);

		_finderPathWithPaginationFindByG_S = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"groupId", "status"}, true);

		_finderPathWithoutPaginationFindByG_S = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"groupId", "status"}, true);

		_finderPathCountByG_S = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"groupId", "status"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ExpenseItemTypeImpl.class.getName());

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

	private static final String _SQL_SELECT_EXPENSEITEMTYPE =
		"SELECT expenseItemType FROM ExpenseItemType expenseItemType";

	private static final String _SQL_SELECT_EXPENSEITEMTYPE_WHERE =
		"SELECT expenseItemType FROM ExpenseItemType expenseItemType WHERE ";

	private static final String _SQL_COUNT_EXPENSEITEMTYPE =
		"SELECT COUNT(expenseItemType) FROM ExpenseItemType expenseItemType";

	private static final String _SQL_COUNT_EXPENSEITEMTYPE_WHERE =
		"SELECT COUNT(expenseItemType) FROM ExpenseItemType expenseItemType WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"expenseItemType.expenseItemTypeId";

	private static final String _FILTER_SQL_SELECT_EXPENSEITEMTYPE_WHERE =
		"SELECT DISTINCT {expenseItemType.*} FROM ExpenseManager_ExpenseItemType expenseItemType WHERE ";

	private static final String
		_FILTER_SQL_SELECT_EXPENSEITEMTYPE_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {ExpenseManager_ExpenseItemType.*} FROM (SELECT DISTINCT expenseItemType.expenseItemTypeId FROM ExpenseManager_ExpenseItemType expenseItemType WHERE ";

	private static final String
		_FILTER_SQL_SELECT_EXPENSEITEMTYPE_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN ExpenseManager_ExpenseItemType ON TEMP_TABLE.expenseItemTypeId = ExpenseManager_ExpenseItemType.expenseItemTypeId";

	private static final String _FILTER_SQL_COUNT_EXPENSEITEMTYPE_WHERE =
		"SELECT COUNT(DISTINCT expenseItemType.expenseItemTypeId) AS COUNT_VALUE FROM ExpenseManager_ExpenseItemType expenseItemType WHERE ";

	private static final String _FILTER_ENTITY_ALIAS = "expenseItemType";

	private static final String _FILTER_ENTITY_TABLE =
		"ExpenseManager_ExpenseItemType";

	private static final String _ORDER_BY_ENTITY_ALIAS = "expenseItemType.";

	private static final String _ORDER_BY_ENTITY_TABLE =
		"ExpenseManager_ExpenseItemType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ExpenseItemType exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ExpenseItemType exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ExpenseItemTypePersistenceImpl.class);

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

	private static class ExpenseItemTypeModelArgumentsResolver
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

			ExpenseItemTypeModelImpl expenseItemTypeModelImpl =
				(ExpenseItemTypeModelImpl)baseModel;

			long columnBitmask = expenseItemTypeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					expenseItemTypeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						expenseItemTypeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					expenseItemTypeModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			ExpenseItemTypeModelImpl expenseItemTypeModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						expenseItemTypeModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = expenseItemTypeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}