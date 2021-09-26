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

import com.liferay.me.expense.manager.exception.NoSuchExpenseItemException;
import com.liferay.me.expense.manager.model.ExpenseItem;
import com.liferay.me.expense.manager.model.impl.ExpenseItemImpl;
import com.liferay.me.expense.manager.model.impl.ExpenseItemModelImpl;
import com.liferay.me.expense.manager.service.persistence.ExpenseItemPersistence;
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
 * The persistence implementation for the expense item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @generated
 */
@Component(service = ExpenseItemPersistence.class)
public class ExpenseItemPersistenceImpl
	extends BasePersistenceImpl<ExpenseItem> implements ExpenseItemPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ExpenseItemUtil</code> to access the expense item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ExpenseItemImpl.class.getName();

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
	 * Returns all the expense items where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching expense items
	 */
	@Override
	public List<ExpenseItem> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the expense items where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of expense items
	 * @param end the upper bound of the range of expense items (not inclusive)
	 * @return the range of matching expense items
	 */
	@Override
	public List<ExpenseItem> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the expense items where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of expense items
	 * @param end the upper bound of the range of expense items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expense items
	 */
	@Override
	public List<ExpenseItem> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ExpenseItem> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the expense items where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of expense items
	 * @param end the upper bound of the range of expense items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching expense items
	 */
	@Override
	public List<ExpenseItem> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ExpenseItem> orderByComparator,
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

		List<ExpenseItem> list = null;

		if (useFinderCache) {
			list = (List<ExpenseItem>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ExpenseItem expenseItem : list) {
					if (groupId != expenseItem.getGroupId()) {
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

			sb.append(_SQL_SELECT_EXPENSEITEM_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ExpenseItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<ExpenseItem>)QueryUtil.list(
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
	 * Returns the first expense item in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	@Override
	public ExpenseItem findByGroupId_First(
			long groupId, OrderByComparator<ExpenseItem> orderByComparator)
		throws NoSuchExpenseItemException {

		ExpenseItem expenseItem = fetchByGroupId_First(
			groupId, orderByComparator);

		if (expenseItem != null) {
			return expenseItem;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchExpenseItemException(sb.toString());
	}

	/**
	 * Returns the first expense item in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	@Override
	public ExpenseItem fetchByGroupId_First(
		long groupId, OrderByComparator<ExpenseItem> orderByComparator) {

		List<ExpenseItem> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last expense item in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	@Override
	public ExpenseItem findByGroupId_Last(
			long groupId, OrderByComparator<ExpenseItem> orderByComparator)
		throws NoSuchExpenseItemException {

		ExpenseItem expenseItem = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (expenseItem != null) {
			return expenseItem;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchExpenseItemException(sb.toString());
	}

	/**
	 * Returns the last expense item in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	@Override
	public ExpenseItem fetchByGroupId_Last(
		long groupId, OrderByComparator<ExpenseItem> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ExpenseItem> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the expense items before and after the current expense item in the ordered set where groupId = &#63;.
	 *
	 * @param expenseItemId the primary key of the current expense item
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense item
	 * @throws NoSuchExpenseItemException if a expense item with the primary key could not be found
	 */
	@Override
	public ExpenseItem[] findByGroupId_PrevAndNext(
			long expenseItemId, long groupId,
			OrderByComparator<ExpenseItem> orderByComparator)
		throws NoSuchExpenseItemException {

		ExpenseItem expenseItem = findByPrimaryKey(expenseItemId);

		Session session = null;

		try {
			session = openSession();

			ExpenseItem[] array = new ExpenseItemImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, expenseItem, groupId, orderByComparator, true);

			array[1] = expenseItem;

			array[2] = getByGroupId_PrevAndNext(
				session, expenseItem, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ExpenseItem getByGroupId_PrevAndNext(
		Session session, ExpenseItem expenseItem, long groupId,
		OrderByComparator<ExpenseItem> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EXPENSEITEM_WHERE);

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
			sb.append(ExpenseItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(expenseItem)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ExpenseItem> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the expense items that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching expense items that the user has permission to view
	 */
	@Override
	public List<ExpenseItem> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the expense items that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of expense items
	 * @param end the upper bound of the range of expense items (not inclusive)
	 * @return the range of matching expense items that the user has permission to view
	 */
	@Override
	public List<ExpenseItem> filterFindByGroupId(
		long groupId, int start, int end) {

		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the expense items that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of expense items
	 * @param end the upper bound of the range of expense items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expense items that the user has permission to view
	 */
	@Override
	public List<ExpenseItem> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ExpenseItem> orderByComparator) {

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
			sb.append(_FILTER_SQL_SELECT_EXPENSEITEM_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_EXPENSEITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_EXPENSEITEM_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(ExpenseItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(ExpenseItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ExpenseItem.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, ExpenseItemImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, ExpenseItemImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			return (List<ExpenseItem>)QueryUtil.list(
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
	 * Returns the expense items before and after the current expense item in the ordered set of expense items that the user has permission to view where groupId = &#63;.
	 *
	 * @param expenseItemId the primary key of the current expense item
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense item
	 * @throws NoSuchExpenseItemException if a expense item with the primary key could not be found
	 */
	@Override
	public ExpenseItem[] filterFindByGroupId_PrevAndNext(
			long expenseItemId, long groupId,
			OrderByComparator<ExpenseItem> orderByComparator)
		throws NoSuchExpenseItemException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(
				expenseItemId, groupId, orderByComparator);
		}

		ExpenseItem expenseItem = findByPrimaryKey(expenseItemId);

		Session session = null;

		try {
			session = openSession();

			ExpenseItem[] array = new ExpenseItemImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(
				session, expenseItem, groupId, orderByComparator, true);

			array[1] = expenseItem;

			array[2] = filterGetByGroupId_PrevAndNext(
				session, expenseItem, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ExpenseItem filterGetByGroupId_PrevAndNext(
		Session session, ExpenseItem expenseItem, long groupId,
		OrderByComparator<ExpenseItem> orderByComparator, boolean previous) {

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
			sb.append(_FILTER_SQL_SELECT_EXPENSEITEM_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_EXPENSEITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_EXPENSEITEM_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(ExpenseItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(ExpenseItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ExpenseItem.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, ExpenseItemImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, ExpenseItemImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(expenseItem)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ExpenseItem> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the expense items where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (ExpenseItem expenseItem :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(expenseItem);
		}
	}

	/**
	 * Returns the number of expense items where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching expense items
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EXPENSEITEM_WHERE);

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
	 * Returns the number of expense items that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching expense items that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler sb = new StringBundler(2);

		sb.append(_FILTER_SQL_COUNT_EXPENSEITEM_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ExpenseItem.class.getName(),
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
		"expenseItem.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByExpenseId;
	private FinderPath _finderPathWithoutPaginationFindByExpenseId;
	private FinderPath _finderPathCountByExpenseId;

	/**
	 * Returns all the expense items where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @return the matching expense items
	 */
	@Override
	public List<ExpenseItem> findByExpenseId(long expenseId) {
		return findByExpenseId(
			expenseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the expense items where expenseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemModelImpl</code>.
	 * </p>
	 *
	 * @param expenseId the expense ID
	 * @param start the lower bound of the range of expense items
	 * @param end the upper bound of the range of expense items (not inclusive)
	 * @return the range of matching expense items
	 */
	@Override
	public List<ExpenseItem> findByExpenseId(
		long expenseId, int start, int end) {

		return findByExpenseId(expenseId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the expense items where expenseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemModelImpl</code>.
	 * </p>
	 *
	 * @param expenseId the expense ID
	 * @param start the lower bound of the range of expense items
	 * @param end the upper bound of the range of expense items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expense items
	 */
	@Override
	public List<ExpenseItem> findByExpenseId(
		long expenseId, int start, int end,
		OrderByComparator<ExpenseItem> orderByComparator) {

		return findByExpenseId(expenseId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the expense items where expenseId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemModelImpl</code>.
	 * </p>
	 *
	 * @param expenseId the expense ID
	 * @param start the lower bound of the range of expense items
	 * @param end the upper bound of the range of expense items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching expense items
	 */
	@Override
	public List<ExpenseItem> findByExpenseId(
		long expenseId, int start, int end,
		OrderByComparator<ExpenseItem> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByExpenseId;
				finderArgs = new Object[] {expenseId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByExpenseId;
			finderArgs = new Object[] {
				expenseId, start, end, orderByComparator
			};
		}

		List<ExpenseItem> list = null;

		if (useFinderCache) {
			list = (List<ExpenseItem>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ExpenseItem expenseItem : list) {
					if (expenseId != expenseItem.getExpenseId()) {
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

			sb.append(_SQL_SELECT_EXPENSEITEM_WHERE);

			sb.append(_FINDER_COLUMN_EXPENSEID_EXPENSEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ExpenseItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(expenseId);

				list = (List<ExpenseItem>)QueryUtil.list(
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
	 * Returns the first expense item in the ordered set where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	@Override
	public ExpenseItem findByExpenseId_First(
			long expenseId, OrderByComparator<ExpenseItem> orderByComparator)
		throws NoSuchExpenseItemException {

		ExpenseItem expenseItem = fetchByExpenseId_First(
			expenseId, orderByComparator);

		if (expenseItem != null) {
			return expenseItem;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("expenseId=");
		sb.append(expenseId);

		sb.append("}");

		throw new NoSuchExpenseItemException(sb.toString());
	}

	/**
	 * Returns the first expense item in the ordered set where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	@Override
	public ExpenseItem fetchByExpenseId_First(
		long expenseId, OrderByComparator<ExpenseItem> orderByComparator) {

		List<ExpenseItem> list = findByExpenseId(
			expenseId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last expense item in the ordered set where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	@Override
	public ExpenseItem findByExpenseId_Last(
			long expenseId, OrderByComparator<ExpenseItem> orderByComparator)
		throws NoSuchExpenseItemException {

		ExpenseItem expenseItem = fetchByExpenseId_Last(
			expenseId, orderByComparator);

		if (expenseItem != null) {
			return expenseItem;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("expenseId=");
		sb.append(expenseId);

		sb.append("}");

		throw new NoSuchExpenseItemException(sb.toString());
	}

	/**
	 * Returns the last expense item in the ordered set where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	@Override
	public ExpenseItem fetchByExpenseId_Last(
		long expenseId, OrderByComparator<ExpenseItem> orderByComparator) {

		int count = countByExpenseId(expenseId);

		if (count == 0) {
			return null;
		}

		List<ExpenseItem> list = findByExpenseId(
			expenseId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the expense items before and after the current expense item in the ordered set where expenseId = &#63;.
	 *
	 * @param expenseItemId the primary key of the current expense item
	 * @param expenseId the expense ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense item
	 * @throws NoSuchExpenseItemException if a expense item with the primary key could not be found
	 */
	@Override
	public ExpenseItem[] findByExpenseId_PrevAndNext(
			long expenseItemId, long expenseId,
			OrderByComparator<ExpenseItem> orderByComparator)
		throws NoSuchExpenseItemException {

		ExpenseItem expenseItem = findByPrimaryKey(expenseItemId);

		Session session = null;

		try {
			session = openSession();

			ExpenseItem[] array = new ExpenseItemImpl[3];

			array[0] = getByExpenseId_PrevAndNext(
				session, expenseItem, expenseId, orderByComparator, true);

			array[1] = expenseItem;

			array[2] = getByExpenseId_PrevAndNext(
				session, expenseItem, expenseId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ExpenseItem getByExpenseId_PrevAndNext(
		Session session, ExpenseItem expenseItem, long expenseId,
		OrderByComparator<ExpenseItem> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EXPENSEITEM_WHERE);

		sb.append(_FINDER_COLUMN_EXPENSEID_EXPENSEID_2);

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
			sb.append(ExpenseItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(expenseId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(expenseItem)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ExpenseItem> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the expense items where expenseId = &#63; from the database.
	 *
	 * @param expenseId the expense ID
	 */
	@Override
	public void removeByExpenseId(long expenseId) {
		for (ExpenseItem expenseItem :
				findByExpenseId(
					expenseId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(expenseItem);
		}
	}

	/**
	 * Returns the number of expense items where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @return the number of matching expense items
	 */
	@Override
	public int countByExpenseId(long expenseId) {
		FinderPath finderPath = _finderPathCountByExpenseId;

		Object[] finderArgs = new Object[] {expenseId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EXPENSEITEM_WHERE);

			sb.append(_FINDER_COLUMN_EXPENSEID_EXPENSEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(expenseId);

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

	private static final String _FINDER_COLUMN_EXPENSEID_EXPENSEID_2 =
		"expenseItem.expenseId = ?";

	private FinderPath _finderPathWithPaginationFindByExpenseItemId;
	private FinderPath _finderPathWithoutPaginationFindByExpenseItemId;
	private FinderPath _finderPathCountByExpenseItemId;

	/**
	 * Returns all the expense items where expenseItemId = &#63;.
	 *
	 * @param expenseItemId the expense item ID
	 * @return the matching expense items
	 */
	@Override
	public List<ExpenseItem> findByExpenseItemId(long expenseItemId) {
		return findByExpenseItemId(
			expenseItemId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the expense items where expenseItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemModelImpl</code>.
	 * </p>
	 *
	 * @param expenseItemId the expense item ID
	 * @param start the lower bound of the range of expense items
	 * @param end the upper bound of the range of expense items (not inclusive)
	 * @return the range of matching expense items
	 */
	@Override
	public List<ExpenseItem> findByExpenseItemId(
		long expenseItemId, int start, int end) {

		return findByExpenseItemId(expenseItemId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the expense items where expenseItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemModelImpl</code>.
	 * </p>
	 *
	 * @param expenseItemId the expense item ID
	 * @param start the lower bound of the range of expense items
	 * @param end the upper bound of the range of expense items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expense items
	 */
	@Override
	public List<ExpenseItem> findByExpenseItemId(
		long expenseItemId, int start, int end,
		OrderByComparator<ExpenseItem> orderByComparator) {

		return findByExpenseItemId(
			expenseItemId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the expense items where expenseItemId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemModelImpl</code>.
	 * </p>
	 *
	 * @param expenseItemId the expense item ID
	 * @param start the lower bound of the range of expense items
	 * @param end the upper bound of the range of expense items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching expense items
	 */
	@Override
	public List<ExpenseItem> findByExpenseItemId(
		long expenseItemId, int start, int end,
		OrderByComparator<ExpenseItem> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByExpenseItemId;
				finderArgs = new Object[] {expenseItemId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByExpenseItemId;
			finderArgs = new Object[] {
				expenseItemId, start, end, orderByComparator
			};
		}

		List<ExpenseItem> list = null;

		if (useFinderCache) {
			list = (List<ExpenseItem>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ExpenseItem expenseItem : list) {
					if (expenseItemId != expenseItem.getExpenseItemId()) {
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

			sb.append(_SQL_SELECT_EXPENSEITEM_WHERE);

			sb.append(_FINDER_COLUMN_EXPENSEITEMID_EXPENSEITEMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ExpenseItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(expenseItemId);

				list = (List<ExpenseItem>)QueryUtil.list(
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
	 * Returns the first expense item in the ordered set where expenseItemId = &#63;.
	 *
	 * @param expenseItemId the expense item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	@Override
	public ExpenseItem findByExpenseItemId_First(
			long expenseItemId,
			OrderByComparator<ExpenseItem> orderByComparator)
		throws NoSuchExpenseItemException {

		ExpenseItem expenseItem = fetchByExpenseItemId_First(
			expenseItemId, orderByComparator);

		if (expenseItem != null) {
			return expenseItem;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("expenseItemId=");
		sb.append(expenseItemId);

		sb.append("}");

		throw new NoSuchExpenseItemException(sb.toString());
	}

	/**
	 * Returns the first expense item in the ordered set where expenseItemId = &#63;.
	 *
	 * @param expenseItemId the expense item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	@Override
	public ExpenseItem fetchByExpenseItemId_First(
		long expenseItemId, OrderByComparator<ExpenseItem> orderByComparator) {

		List<ExpenseItem> list = findByExpenseItemId(
			expenseItemId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last expense item in the ordered set where expenseItemId = &#63;.
	 *
	 * @param expenseItemId the expense item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	@Override
	public ExpenseItem findByExpenseItemId_Last(
			long expenseItemId,
			OrderByComparator<ExpenseItem> orderByComparator)
		throws NoSuchExpenseItemException {

		ExpenseItem expenseItem = fetchByExpenseItemId_Last(
			expenseItemId, orderByComparator);

		if (expenseItem != null) {
			return expenseItem;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("expenseItemId=");
		sb.append(expenseItemId);

		sb.append("}");

		throw new NoSuchExpenseItemException(sb.toString());
	}

	/**
	 * Returns the last expense item in the ordered set where expenseItemId = &#63;.
	 *
	 * @param expenseItemId the expense item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	@Override
	public ExpenseItem fetchByExpenseItemId_Last(
		long expenseItemId, OrderByComparator<ExpenseItem> orderByComparator) {

		int count = countByExpenseItemId(expenseItemId);

		if (count == 0) {
			return null;
		}

		List<ExpenseItem> list = findByExpenseItemId(
			expenseItemId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the expense items where expenseItemId = &#63; from the database.
	 *
	 * @param expenseItemId the expense item ID
	 */
	@Override
	public void removeByExpenseItemId(long expenseItemId) {
		for (ExpenseItem expenseItem :
				findByExpenseItemId(
					expenseItemId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(expenseItem);
		}
	}

	/**
	 * Returns the number of expense items where expenseItemId = &#63;.
	 *
	 * @param expenseItemId the expense item ID
	 * @return the number of matching expense items
	 */
	@Override
	public int countByExpenseItemId(long expenseItemId) {
		FinderPath finderPath = _finderPathCountByExpenseItemId;

		Object[] finderArgs = new Object[] {expenseItemId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EXPENSEITEM_WHERE);

			sb.append(_FINDER_COLUMN_EXPENSEITEMID_EXPENSEITEMID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(expenseItemId);

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

	private static final String _FINDER_COLUMN_EXPENSEITEMID_EXPENSEITEMID_2 =
		"expenseItem.expenseItemId = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the expense items where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching expense items
	 */
	@Override
	public List<ExpenseItem> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the expense items where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of expense items
	 * @param end the upper bound of the range of expense items (not inclusive)
	 * @return the range of matching expense items
	 */
	@Override
	public List<ExpenseItem> findByStatus(int status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the expense items where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of expense items
	 * @param end the upper bound of the range of expense items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expense items
	 */
	@Override
	public List<ExpenseItem> findByStatus(
		int status, int start, int end,
		OrderByComparator<ExpenseItem> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the expense items where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of expense items
	 * @param end the upper bound of the range of expense items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching expense items
	 */
	@Override
	public List<ExpenseItem> findByStatus(
		int status, int start, int end,
		OrderByComparator<ExpenseItem> orderByComparator,
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

		List<ExpenseItem> list = null;

		if (useFinderCache) {
			list = (List<ExpenseItem>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ExpenseItem expenseItem : list) {
					if (status != expenseItem.getStatus()) {
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

			sb.append(_SQL_SELECT_EXPENSEITEM_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ExpenseItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<ExpenseItem>)QueryUtil.list(
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
	 * Returns the first expense item in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	@Override
	public ExpenseItem findByStatus_First(
			int status, OrderByComparator<ExpenseItem> orderByComparator)
		throws NoSuchExpenseItemException {

		ExpenseItem expenseItem = fetchByStatus_First(
			status, orderByComparator);

		if (expenseItem != null) {
			return expenseItem;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchExpenseItemException(sb.toString());
	}

	/**
	 * Returns the first expense item in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	@Override
	public ExpenseItem fetchByStatus_First(
		int status, OrderByComparator<ExpenseItem> orderByComparator) {

		List<ExpenseItem> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last expense item in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	@Override
	public ExpenseItem findByStatus_Last(
			int status, OrderByComparator<ExpenseItem> orderByComparator)
		throws NoSuchExpenseItemException {

		ExpenseItem expenseItem = fetchByStatus_Last(status, orderByComparator);

		if (expenseItem != null) {
			return expenseItem;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchExpenseItemException(sb.toString());
	}

	/**
	 * Returns the last expense item in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	@Override
	public ExpenseItem fetchByStatus_Last(
		int status, OrderByComparator<ExpenseItem> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<ExpenseItem> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the expense items before and after the current expense item in the ordered set where status = &#63;.
	 *
	 * @param expenseItemId the primary key of the current expense item
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense item
	 * @throws NoSuchExpenseItemException if a expense item with the primary key could not be found
	 */
	@Override
	public ExpenseItem[] findByStatus_PrevAndNext(
			long expenseItemId, int status,
			OrderByComparator<ExpenseItem> orderByComparator)
		throws NoSuchExpenseItemException {

		ExpenseItem expenseItem = findByPrimaryKey(expenseItemId);

		Session session = null;

		try {
			session = openSession();

			ExpenseItem[] array = new ExpenseItemImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, expenseItem, status, orderByComparator, true);

			array[1] = expenseItem;

			array[2] = getByStatus_PrevAndNext(
				session, expenseItem, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ExpenseItem getByStatus_PrevAndNext(
		Session session, ExpenseItem expenseItem, int status,
		OrderByComparator<ExpenseItem> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EXPENSEITEM_WHERE);

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
			sb.append(ExpenseItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(expenseItem)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ExpenseItem> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the expense items where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (ExpenseItem expenseItem :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(expenseItem);
		}
	}

	/**
	 * Returns the number of expense items where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching expense items
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EXPENSEITEM_WHERE);

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
		"expenseItem.status = ?";

	private FinderPath _finderPathWithPaginationFindByG_S;
	private FinderPath _finderPathWithoutPaginationFindByG_S;
	private FinderPath _finderPathCountByG_S;

	/**
	 * Returns all the expense items where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching expense items
	 */
	@Override
	public List<ExpenseItem> findByG_S(long groupId, int status) {
		return findByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the expense items where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of expense items
	 * @param end the upper bound of the range of expense items (not inclusive)
	 * @return the range of matching expense items
	 */
	@Override
	public List<ExpenseItem> findByG_S(
		long groupId, int status, int start, int end) {

		return findByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the expense items where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of expense items
	 * @param end the upper bound of the range of expense items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expense items
	 */
	@Override
	public List<ExpenseItem> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<ExpenseItem> orderByComparator) {

		return findByG_S(groupId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the expense items where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of expense items
	 * @param end the upper bound of the range of expense items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching expense items
	 */
	@Override
	public List<ExpenseItem> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<ExpenseItem> orderByComparator,
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

		List<ExpenseItem> list = null;

		if (useFinderCache) {
			list = (List<ExpenseItem>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ExpenseItem expenseItem : list) {
					if ((groupId != expenseItem.getGroupId()) ||
						(status != expenseItem.getStatus())) {

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

			sb.append(_SQL_SELECT_EXPENSEITEM_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ExpenseItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				list = (List<ExpenseItem>)QueryUtil.list(
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
	 * Returns the first expense item in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	@Override
	public ExpenseItem findByG_S_First(
			long groupId, int status,
			OrderByComparator<ExpenseItem> orderByComparator)
		throws NoSuchExpenseItemException {

		ExpenseItem expenseItem = fetchByG_S_First(
			groupId, status, orderByComparator);

		if (expenseItem != null) {
			return expenseItem;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchExpenseItemException(sb.toString());
	}

	/**
	 * Returns the first expense item in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	@Override
	public ExpenseItem fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<ExpenseItem> orderByComparator) {

		List<ExpenseItem> list = findByG_S(
			groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last expense item in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	@Override
	public ExpenseItem findByG_S_Last(
			long groupId, int status,
			OrderByComparator<ExpenseItem> orderByComparator)
		throws NoSuchExpenseItemException {

		ExpenseItem expenseItem = fetchByG_S_Last(
			groupId, status, orderByComparator);

		if (expenseItem != null) {
			return expenseItem;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchExpenseItemException(sb.toString());
	}

	/**
	 * Returns the last expense item in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	@Override
	public ExpenseItem fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<ExpenseItem> orderByComparator) {

		int count = countByG_S(groupId, status);

		if (count == 0) {
			return null;
		}

		List<ExpenseItem> list = findByG_S(
			groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the expense items before and after the current expense item in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param expenseItemId the primary key of the current expense item
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense item
	 * @throws NoSuchExpenseItemException if a expense item with the primary key could not be found
	 */
	@Override
	public ExpenseItem[] findByG_S_PrevAndNext(
			long expenseItemId, long groupId, int status,
			OrderByComparator<ExpenseItem> orderByComparator)
		throws NoSuchExpenseItemException {

		ExpenseItem expenseItem = findByPrimaryKey(expenseItemId);

		Session session = null;

		try {
			session = openSession();

			ExpenseItem[] array = new ExpenseItemImpl[3];

			array[0] = getByG_S_PrevAndNext(
				session, expenseItem, groupId, status, orderByComparator, true);

			array[1] = expenseItem;

			array[2] = getByG_S_PrevAndNext(
				session, expenseItem, groupId, status, orderByComparator,
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

	protected ExpenseItem getByG_S_PrevAndNext(
		Session session, ExpenseItem expenseItem, long groupId, int status,
		OrderByComparator<ExpenseItem> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_EXPENSEITEM_WHERE);

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
			sb.append(ExpenseItemModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(expenseItem)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ExpenseItem> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the expense items that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching expense items that the user has permission to view
	 */
	@Override
	public List<ExpenseItem> filterFindByG_S(long groupId, int status) {
		return filterFindByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the expense items that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of expense items
	 * @param end the upper bound of the range of expense items (not inclusive)
	 * @return the range of matching expense items that the user has permission to view
	 */
	@Override
	public List<ExpenseItem> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return filterFindByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the expense items that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of expense items
	 * @param end the upper bound of the range of expense items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expense items that the user has permission to view
	 */
	@Override
	public List<ExpenseItem> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<ExpenseItem> orderByComparator) {

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
			sb.append(_FILTER_SQL_SELECT_EXPENSEITEM_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_EXPENSEITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_EXPENSEITEM_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(ExpenseItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(ExpenseItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ExpenseItem.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, ExpenseItemImpl.class);
			}
			else {
				sqlQuery.addEntity(_FILTER_ENTITY_TABLE, ExpenseItemImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(status);

			return (List<ExpenseItem>)QueryUtil.list(
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
	 * Returns the expense items before and after the current expense item in the ordered set of expense items that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param expenseItemId the primary key of the current expense item
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense item
	 * @throws NoSuchExpenseItemException if a expense item with the primary key could not be found
	 */
	@Override
	public ExpenseItem[] filterFindByG_S_PrevAndNext(
			long expenseItemId, long groupId, int status,
			OrderByComparator<ExpenseItem> orderByComparator)
		throws NoSuchExpenseItemException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_PrevAndNext(
				expenseItemId, groupId, status, orderByComparator);
		}

		ExpenseItem expenseItem = findByPrimaryKey(expenseItemId);

		Session session = null;

		try {
			session = openSession();

			ExpenseItem[] array = new ExpenseItemImpl[3];

			array[0] = filterGetByG_S_PrevAndNext(
				session, expenseItem, groupId, status, orderByComparator, true);

			array[1] = expenseItem;

			array[2] = filterGetByG_S_PrevAndNext(
				session, expenseItem, groupId, status, orderByComparator,
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

	protected ExpenseItem filterGetByG_S_PrevAndNext(
		Session session, ExpenseItem expenseItem, long groupId, int status,
		OrderByComparator<ExpenseItem> orderByComparator, boolean previous) {

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
			sb.append(_FILTER_SQL_SELECT_EXPENSEITEM_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_EXPENSEITEM_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_EXPENSEITEM_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(ExpenseItemModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(ExpenseItemModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ExpenseItem.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, ExpenseItemImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, ExpenseItemImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(expenseItem)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ExpenseItem> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the expense items where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeByG_S(long groupId, int status) {
		for (ExpenseItem expenseItem :
				findByG_S(
					groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(expenseItem);
		}
	}

	/**
	 * Returns the number of expense items where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching expense items
	 */
	@Override
	public int countByG_S(long groupId, int status) {
		FinderPath finderPath = _finderPathCountByG_S;

		Object[] finderArgs = new Object[] {groupId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EXPENSEITEM_WHERE);

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
	 * Returns the number of expense items that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching expense items that the user has permission to view
	 */
	@Override
	public int filterCountByG_S(long groupId, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S(groupId, status);
		}

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_EXPENSEITEM_WHERE);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), ExpenseItem.class.getName(),
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
		"expenseItem.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_STATUS_2 =
		"expenseItem.status = ?";

	public ExpenseItemPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ExpenseItem.class);

		setModelImplClass(ExpenseItemImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the expense item in the entity cache if it is enabled.
	 *
	 * @param expenseItem the expense item
	 */
	@Override
	public void cacheResult(ExpenseItem expenseItem) {
		entityCache.putResult(
			ExpenseItemImpl.class, expenseItem.getPrimaryKey(), expenseItem);
	}

	/**
	 * Caches the expense items in the entity cache if it is enabled.
	 *
	 * @param expenseItems the expense items
	 */
	@Override
	public void cacheResult(List<ExpenseItem> expenseItems) {
		for (ExpenseItem expenseItem : expenseItems) {
			if (entityCache.getResult(
					ExpenseItemImpl.class, expenseItem.getPrimaryKey()) ==
						null) {

				cacheResult(expenseItem);
			}
		}
	}

	/**
	 * Clears the cache for all expense items.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ExpenseItemImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the expense item.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ExpenseItem expenseItem) {
		entityCache.removeResult(ExpenseItemImpl.class, expenseItem);
	}

	@Override
	public void clearCache(List<ExpenseItem> expenseItems) {
		for (ExpenseItem expenseItem : expenseItems) {
			entityCache.removeResult(ExpenseItemImpl.class, expenseItem);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ExpenseItemImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new expense item with the primary key. Does not add the expense item to the database.
	 *
	 * @param expenseItemId the primary key for the new expense item
	 * @return the new expense item
	 */
	@Override
	public ExpenseItem create(long expenseItemId) {
		ExpenseItem expenseItem = new ExpenseItemImpl();

		expenseItem.setNew(true);
		expenseItem.setPrimaryKey(expenseItemId);

		expenseItem.setCompanyId(CompanyThreadLocal.getCompanyId());

		return expenseItem;
	}

	/**
	 * Removes the expense item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param expenseItemId the primary key of the expense item
	 * @return the expense item that was removed
	 * @throws NoSuchExpenseItemException if a expense item with the primary key could not be found
	 */
	@Override
	public ExpenseItem remove(long expenseItemId)
		throws NoSuchExpenseItemException {

		return remove((Serializable)expenseItemId);
	}

	/**
	 * Removes the expense item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the expense item
	 * @return the expense item that was removed
	 * @throws NoSuchExpenseItemException if a expense item with the primary key could not be found
	 */
	@Override
	public ExpenseItem remove(Serializable primaryKey)
		throws NoSuchExpenseItemException {

		Session session = null;

		try {
			session = openSession();

			ExpenseItem expenseItem = (ExpenseItem)session.get(
				ExpenseItemImpl.class, primaryKey);

			if (expenseItem == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExpenseItemException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(expenseItem);
		}
		catch (NoSuchExpenseItemException noSuchEntityException) {
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
	protected ExpenseItem removeImpl(ExpenseItem expenseItem) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(expenseItem)) {
				expenseItem = (ExpenseItem)session.get(
					ExpenseItemImpl.class, expenseItem.getPrimaryKeyObj());
			}

			if (expenseItem != null) {
				session.delete(expenseItem);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (expenseItem != null) {
			clearCache(expenseItem);
		}

		return expenseItem;
	}

	@Override
	public ExpenseItem updateImpl(ExpenseItem expenseItem) {
		boolean isNew = expenseItem.isNew();

		if (!(expenseItem instanceof ExpenseItemModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(expenseItem.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(expenseItem);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in expenseItem proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ExpenseItem implementation " +
					expenseItem.getClass());
		}

		ExpenseItemModelImpl expenseItemModelImpl =
			(ExpenseItemModelImpl)expenseItem;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (expenseItem.getCreateDate() == null)) {
			if (serviceContext == null) {
				expenseItem.setCreateDate(date);
			}
			else {
				expenseItem.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!expenseItemModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				expenseItem.setModifiedDate(date);
			}
			else {
				expenseItem.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(expenseItem);
			}
			else {
				expenseItem = (ExpenseItem)session.merge(expenseItem);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ExpenseItemImpl.class, expenseItemModelImpl, false, true);

		if (isNew) {
			expenseItem.setNew(false);
		}

		expenseItem.resetOriginalValues();

		return expenseItem;
	}

	/**
	 * Returns the expense item with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the expense item
	 * @return the expense item
	 * @throws NoSuchExpenseItemException if a expense item with the primary key could not be found
	 */
	@Override
	public ExpenseItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExpenseItemException {

		ExpenseItem expenseItem = fetchByPrimaryKey(primaryKey);

		if (expenseItem == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExpenseItemException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return expenseItem;
	}

	/**
	 * Returns the expense item with the primary key or throws a <code>NoSuchExpenseItemException</code> if it could not be found.
	 *
	 * @param expenseItemId the primary key of the expense item
	 * @return the expense item
	 * @throws NoSuchExpenseItemException if a expense item with the primary key could not be found
	 */
	@Override
	public ExpenseItem findByPrimaryKey(long expenseItemId)
		throws NoSuchExpenseItemException {

		return findByPrimaryKey((Serializable)expenseItemId);
	}

	/**
	 * Returns the expense item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param expenseItemId the primary key of the expense item
	 * @return the expense item, or <code>null</code> if a expense item with the primary key could not be found
	 */
	@Override
	public ExpenseItem fetchByPrimaryKey(long expenseItemId) {
		return fetchByPrimaryKey((Serializable)expenseItemId);
	}

	/**
	 * Returns all the expense items.
	 *
	 * @return the expense items
	 */
	@Override
	public List<ExpenseItem> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the expense items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of expense items
	 * @param end the upper bound of the range of expense items (not inclusive)
	 * @return the range of expense items
	 */
	@Override
	public List<ExpenseItem> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the expense items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of expense items
	 * @param end the upper bound of the range of expense items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of expense items
	 */
	@Override
	public List<ExpenseItem> findAll(
		int start, int end, OrderByComparator<ExpenseItem> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the expense items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of expense items
	 * @param end the upper bound of the range of expense items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of expense items
	 */
	@Override
	public List<ExpenseItem> findAll(
		int start, int end, OrderByComparator<ExpenseItem> orderByComparator,
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

		List<ExpenseItem> list = null;

		if (useFinderCache) {
			list = (List<ExpenseItem>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EXPENSEITEM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EXPENSEITEM;

				sql = sql.concat(ExpenseItemModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ExpenseItem>)QueryUtil.list(
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
	 * Removes all the expense items from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ExpenseItem expenseItem : findAll()) {
			remove(expenseItem);
		}
	}

	/**
	 * Returns the number of expense items.
	 *
	 * @return the number of expense items
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EXPENSEITEM);

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
		return "expenseItemId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EXPENSEITEM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ExpenseItemModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the expense item persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new ExpenseItemModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ExpenseItem.class.getName()));

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

		_finderPathWithPaginationFindByExpenseId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByExpenseId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"expenseId"}, true);

		_finderPathWithoutPaginationFindByExpenseId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByExpenseId",
			new String[] {Long.class.getName()}, new String[] {"expenseId"},
			true);

		_finderPathCountByExpenseId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByExpenseId",
			new String[] {Long.class.getName()}, new String[] {"expenseId"},
			false);

		_finderPathWithPaginationFindByExpenseItemId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByExpenseItemId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"expenseItemId"}, true);

		_finderPathWithoutPaginationFindByExpenseItemId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByExpenseItemId",
			new String[] {Long.class.getName()}, new String[] {"expenseItemId"},
			true);

		_finderPathCountByExpenseItemId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByExpenseItemId",
			new String[] {Long.class.getName()}, new String[] {"expenseItemId"},
			false);

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
		entityCache.removeCache(ExpenseItemImpl.class.getName());

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

	private static final String _SQL_SELECT_EXPENSEITEM =
		"SELECT expenseItem FROM ExpenseItem expenseItem";

	private static final String _SQL_SELECT_EXPENSEITEM_WHERE =
		"SELECT expenseItem FROM ExpenseItem expenseItem WHERE ";

	private static final String _SQL_COUNT_EXPENSEITEM =
		"SELECT COUNT(expenseItem) FROM ExpenseItem expenseItem";

	private static final String _SQL_COUNT_EXPENSEITEM_WHERE =
		"SELECT COUNT(expenseItem) FROM ExpenseItem expenseItem WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"expenseItem.expenseItemId";

	private static final String _FILTER_SQL_SELECT_EXPENSEITEM_WHERE =
		"SELECT DISTINCT {expenseItem.*} FROM ExpenseManager_ExpenseItem expenseItem WHERE ";

	private static final String
		_FILTER_SQL_SELECT_EXPENSEITEM_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {ExpenseManager_ExpenseItem.*} FROM (SELECT DISTINCT expenseItem.expenseItemId FROM ExpenseManager_ExpenseItem expenseItem WHERE ";

	private static final String
		_FILTER_SQL_SELECT_EXPENSEITEM_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN ExpenseManager_ExpenseItem ON TEMP_TABLE.expenseItemId = ExpenseManager_ExpenseItem.expenseItemId";

	private static final String _FILTER_SQL_COUNT_EXPENSEITEM_WHERE =
		"SELECT COUNT(DISTINCT expenseItem.expenseItemId) AS COUNT_VALUE FROM ExpenseManager_ExpenseItem expenseItem WHERE ";

	private static final String _FILTER_ENTITY_ALIAS = "expenseItem";

	private static final String _FILTER_ENTITY_TABLE =
		"ExpenseManager_ExpenseItem";

	private static final String _ORDER_BY_ENTITY_ALIAS = "expenseItem.";

	private static final String _ORDER_BY_ENTITY_TABLE =
		"ExpenseManager_ExpenseItem.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ExpenseItem exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ExpenseItem exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ExpenseItemPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"type"});

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

	private static class ExpenseItemModelArgumentsResolver
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

			ExpenseItemModelImpl expenseItemModelImpl =
				(ExpenseItemModelImpl)baseModel;

			long columnBitmask = expenseItemModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(expenseItemModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						expenseItemModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(expenseItemModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			ExpenseItemModelImpl expenseItemModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = expenseItemModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = expenseItemModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}