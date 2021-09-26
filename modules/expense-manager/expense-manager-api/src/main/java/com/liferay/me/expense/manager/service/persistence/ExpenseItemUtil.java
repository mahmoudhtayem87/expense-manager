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

package com.liferay.me.expense.manager.service.persistence;

import com.liferay.me.expense.manager.model.ExpenseItem;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the expense item service. This utility wraps <code>com.liferay.me.expense.manager.service.persistence.impl.ExpenseItemPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseItemPersistence
 * @generated
 */
public class ExpenseItemUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ExpenseItem expenseItem) {
		getPersistence().clearCache(expenseItem);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ExpenseItem> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ExpenseItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ExpenseItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ExpenseItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ExpenseItem> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ExpenseItem update(ExpenseItem expenseItem) {
		return getPersistence().update(expenseItem);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ExpenseItem update(
		ExpenseItem expenseItem, ServiceContext serviceContext) {

		return getPersistence().update(expenseItem, serviceContext);
	}

	/**
	 * Returns all the expense items where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching expense items
	 */
	public static List<ExpenseItem> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
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
	public static List<ExpenseItem> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
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
	public static List<ExpenseItem> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ExpenseItem> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
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
	public static List<ExpenseItem> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ExpenseItem> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first expense item in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	public static ExpenseItem findByGroupId_First(
			long groupId, OrderByComparator<ExpenseItem> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first expense item in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	public static ExpenseItem fetchByGroupId_First(
		long groupId, OrderByComparator<ExpenseItem> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last expense item in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	public static ExpenseItem findByGroupId_Last(
			long groupId, OrderByComparator<ExpenseItem> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last expense item in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	public static ExpenseItem fetchByGroupId_Last(
		long groupId, OrderByComparator<ExpenseItem> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
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
	public static ExpenseItem[] findByGroupId_PrevAndNext(
			long expenseItemId, long groupId,
			OrderByComparator<ExpenseItem> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemException {

		return getPersistence().findByGroupId_PrevAndNext(
			expenseItemId, groupId, orderByComparator);
	}

	/**
	 * Returns all the expense items that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching expense items that the user has permission to view
	 */
	public static List<ExpenseItem> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
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
	public static List<ExpenseItem> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
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
	public static List<ExpenseItem> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ExpenseItem> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
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
	public static ExpenseItem[] filterFindByGroupId_PrevAndNext(
			long expenseItemId, long groupId,
			OrderByComparator<ExpenseItem> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			expenseItemId, groupId, orderByComparator);
	}

	/**
	 * Removes all the expense items where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of expense items where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching expense items
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of expense items that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching expense items that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Returns all the expense items where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @return the matching expense items
	 */
	public static List<ExpenseItem> findByExpenseId(long expenseId) {
		return getPersistence().findByExpenseId(expenseId);
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
	public static List<ExpenseItem> findByExpenseId(
		long expenseId, int start, int end) {

		return getPersistence().findByExpenseId(expenseId, start, end);
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
	public static List<ExpenseItem> findByExpenseId(
		long expenseId, int start, int end,
		OrderByComparator<ExpenseItem> orderByComparator) {

		return getPersistence().findByExpenseId(
			expenseId, start, end, orderByComparator);
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
	public static List<ExpenseItem> findByExpenseId(
		long expenseId, int start, int end,
		OrderByComparator<ExpenseItem> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByExpenseId(
			expenseId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first expense item in the ordered set where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	public static ExpenseItem findByExpenseId_First(
			long expenseId, OrderByComparator<ExpenseItem> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemException {

		return getPersistence().findByExpenseId_First(
			expenseId, orderByComparator);
	}

	/**
	 * Returns the first expense item in the ordered set where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	public static ExpenseItem fetchByExpenseId_First(
		long expenseId, OrderByComparator<ExpenseItem> orderByComparator) {

		return getPersistence().fetchByExpenseId_First(
			expenseId, orderByComparator);
	}

	/**
	 * Returns the last expense item in the ordered set where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	public static ExpenseItem findByExpenseId_Last(
			long expenseId, OrderByComparator<ExpenseItem> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemException {

		return getPersistence().findByExpenseId_Last(
			expenseId, orderByComparator);
	}

	/**
	 * Returns the last expense item in the ordered set where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	public static ExpenseItem fetchByExpenseId_Last(
		long expenseId, OrderByComparator<ExpenseItem> orderByComparator) {

		return getPersistence().fetchByExpenseId_Last(
			expenseId, orderByComparator);
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
	public static ExpenseItem[] findByExpenseId_PrevAndNext(
			long expenseItemId, long expenseId,
			OrderByComparator<ExpenseItem> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemException {

		return getPersistence().findByExpenseId_PrevAndNext(
			expenseItemId, expenseId, orderByComparator);
	}

	/**
	 * Removes all the expense items where expenseId = &#63; from the database.
	 *
	 * @param expenseId the expense ID
	 */
	public static void removeByExpenseId(long expenseId) {
		getPersistence().removeByExpenseId(expenseId);
	}

	/**
	 * Returns the number of expense items where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @return the number of matching expense items
	 */
	public static int countByExpenseId(long expenseId) {
		return getPersistence().countByExpenseId(expenseId);
	}

	/**
	 * Returns all the expense items where expenseItemId = &#63;.
	 *
	 * @param expenseItemId the expense item ID
	 * @return the matching expense items
	 */
	public static List<ExpenseItem> findByExpenseItemId(long expenseItemId) {
		return getPersistence().findByExpenseItemId(expenseItemId);
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
	public static List<ExpenseItem> findByExpenseItemId(
		long expenseItemId, int start, int end) {

		return getPersistence().findByExpenseItemId(expenseItemId, start, end);
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
	public static List<ExpenseItem> findByExpenseItemId(
		long expenseItemId, int start, int end,
		OrderByComparator<ExpenseItem> orderByComparator) {

		return getPersistence().findByExpenseItemId(
			expenseItemId, start, end, orderByComparator);
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
	public static List<ExpenseItem> findByExpenseItemId(
		long expenseItemId, int start, int end,
		OrderByComparator<ExpenseItem> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByExpenseItemId(
			expenseItemId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first expense item in the ordered set where expenseItemId = &#63;.
	 *
	 * @param expenseItemId the expense item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	public static ExpenseItem findByExpenseItemId_First(
			long expenseItemId,
			OrderByComparator<ExpenseItem> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemException {

		return getPersistence().findByExpenseItemId_First(
			expenseItemId, orderByComparator);
	}

	/**
	 * Returns the first expense item in the ordered set where expenseItemId = &#63;.
	 *
	 * @param expenseItemId the expense item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	public static ExpenseItem fetchByExpenseItemId_First(
		long expenseItemId, OrderByComparator<ExpenseItem> orderByComparator) {

		return getPersistence().fetchByExpenseItemId_First(
			expenseItemId, orderByComparator);
	}

	/**
	 * Returns the last expense item in the ordered set where expenseItemId = &#63;.
	 *
	 * @param expenseItemId the expense item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	public static ExpenseItem findByExpenseItemId_Last(
			long expenseItemId,
			OrderByComparator<ExpenseItem> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemException {

		return getPersistence().findByExpenseItemId_Last(
			expenseItemId, orderByComparator);
	}

	/**
	 * Returns the last expense item in the ordered set where expenseItemId = &#63;.
	 *
	 * @param expenseItemId the expense item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	public static ExpenseItem fetchByExpenseItemId_Last(
		long expenseItemId, OrderByComparator<ExpenseItem> orderByComparator) {

		return getPersistence().fetchByExpenseItemId_Last(
			expenseItemId, orderByComparator);
	}

	/**
	 * Removes all the expense items where expenseItemId = &#63; from the database.
	 *
	 * @param expenseItemId the expense item ID
	 */
	public static void removeByExpenseItemId(long expenseItemId) {
		getPersistence().removeByExpenseItemId(expenseItemId);
	}

	/**
	 * Returns the number of expense items where expenseItemId = &#63;.
	 *
	 * @param expenseItemId the expense item ID
	 * @return the number of matching expense items
	 */
	public static int countByExpenseItemId(long expenseItemId) {
		return getPersistence().countByExpenseItemId(expenseItemId);
	}

	/**
	 * Returns all the expense items where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching expense items
	 */
	public static List<ExpenseItem> findByStatus(int status) {
		return getPersistence().findByStatus(status);
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
	public static List<ExpenseItem> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
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
	public static List<ExpenseItem> findByStatus(
		int status, int start, int end,
		OrderByComparator<ExpenseItem> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
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
	public static List<ExpenseItem> findByStatus(
		int status, int start, int end,
		OrderByComparator<ExpenseItem> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first expense item in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	public static ExpenseItem findByStatus_First(
			int status, OrderByComparator<ExpenseItem> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first expense item in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	public static ExpenseItem fetchByStatus_First(
		int status, OrderByComparator<ExpenseItem> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last expense item in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	public static ExpenseItem findByStatus_Last(
			int status, OrderByComparator<ExpenseItem> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last expense item in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	public static ExpenseItem fetchByStatus_Last(
		int status, OrderByComparator<ExpenseItem> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
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
	public static ExpenseItem[] findByStatus_PrevAndNext(
			long expenseItemId, int status,
			OrderByComparator<ExpenseItem> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemException {

		return getPersistence().findByStatus_PrevAndNext(
			expenseItemId, status, orderByComparator);
	}

	/**
	 * Removes all the expense items where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of expense items where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching expense items
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the expense items where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching expense items
	 */
	public static List<ExpenseItem> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
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
	public static List<ExpenseItem> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
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
	public static List<ExpenseItem> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<ExpenseItem> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
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
	public static List<ExpenseItem> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<ExpenseItem> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
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
	public static ExpenseItem findByG_S_First(
			long groupId, int status,
			OrderByComparator<ExpenseItem> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first expense item in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	public static ExpenseItem fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<ExpenseItem> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
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
	public static ExpenseItem findByG_S_Last(
			long groupId, int status,
			OrderByComparator<ExpenseItem> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last expense item in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	public static ExpenseItem fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<ExpenseItem> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
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
	public static ExpenseItem[] findByG_S_PrevAndNext(
			long expenseItemId, long groupId, int status,
			OrderByComparator<ExpenseItem> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemException {

		return getPersistence().findByG_S_PrevAndNext(
			expenseItemId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the expense items that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching expense items that the user has permission to view
	 */
	public static List<ExpenseItem> filterFindByG_S(long groupId, int status) {
		return getPersistence().filterFindByG_S(groupId, status);
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
	public static List<ExpenseItem> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().filterFindByG_S(groupId, status, start, end);
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
	public static List<ExpenseItem> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<ExpenseItem> orderByComparator) {

		return getPersistence().filterFindByG_S(
			groupId, status, start, end, orderByComparator);
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
	public static ExpenseItem[] filterFindByG_S_PrevAndNext(
			long expenseItemId, long groupId, int status,
			OrderByComparator<ExpenseItem> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemException {

		return getPersistence().filterFindByG_S_PrevAndNext(
			expenseItemId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the expense items where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of expense items where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching expense items
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Returns the number of expense items that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching expense items that the user has permission to view
	 */
	public static int filterCountByG_S(long groupId, int status) {
		return getPersistence().filterCountByG_S(groupId, status);
	}

	/**
	 * Caches the expense item in the entity cache if it is enabled.
	 *
	 * @param expenseItem the expense item
	 */
	public static void cacheResult(ExpenseItem expenseItem) {
		getPersistence().cacheResult(expenseItem);
	}

	/**
	 * Caches the expense items in the entity cache if it is enabled.
	 *
	 * @param expenseItems the expense items
	 */
	public static void cacheResult(List<ExpenseItem> expenseItems) {
		getPersistence().cacheResult(expenseItems);
	}

	/**
	 * Creates a new expense item with the primary key. Does not add the expense item to the database.
	 *
	 * @param expenseItemId the primary key for the new expense item
	 * @return the new expense item
	 */
	public static ExpenseItem create(long expenseItemId) {
		return getPersistence().create(expenseItemId);
	}

	/**
	 * Removes the expense item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param expenseItemId the primary key of the expense item
	 * @return the expense item that was removed
	 * @throws NoSuchExpenseItemException if a expense item with the primary key could not be found
	 */
	public static ExpenseItem remove(long expenseItemId)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemException {

		return getPersistence().remove(expenseItemId);
	}

	public static ExpenseItem updateImpl(ExpenseItem expenseItem) {
		return getPersistence().updateImpl(expenseItem);
	}

	/**
	 * Returns the expense item with the primary key or throws a <code>NoSuchExpenseItemException</code> if it could not be found.
	 *
	 * @param expenseItemId the primary key of the expense item
	 * @return the expense item
	 * @throws NoSuchExpenseItemException if a expense item with the primary key could not be found
	 */
	public static ExpenseItem findByPrimaryKey(long expenseItemId)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemException {

		return getPersistence().findByPrimaryKey(expenseItemId);
	}

	/**
	 * Returns the expense item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param expenseItemId the primary key of the expense item
	 * @return the expense item, or <code>null</code> if a expense item with the primary key could not be found
	 */
	public static ExpenseItem fetchByPrimaryKey(long expenseItemId) {
		return getPersistence().fetchByPrimaryKey(expenseItemId);
	}

	/**
	 * Returns all the expense items.
	 *
	 * @return the expense items
	 */
	public static List<ExpenseItem> findAll() {
		return getPersistence().findAll();
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
	public static List<ExpenseItem> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<ExpenseItem> findAll(
		int start, int end, OrderByComparator<ExpenseItem> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<ExpenseItem> findAll(
		int start, int end, OrderByComparator<ExpenseItem> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the expense items from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of expense items.
	 *
	 * @return the number of expense items
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ExpenseItemPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ExpenseItemPersistence, ExpenseItemPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ExpenseItemPersistence.class);

		ServiceTracker<ExpenseItemPersistence, ExpenseItemPersistence>
			serviceTracker =
				new ServiceTracker
					<ExpenseItemPersistence, ExpenseItemPersistence>(
						bundle.getBundleContext(), ExpenseItemPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}