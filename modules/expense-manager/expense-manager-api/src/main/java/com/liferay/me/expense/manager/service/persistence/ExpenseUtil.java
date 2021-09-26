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

import com.liferay.me.expense.manager.model.Expense;
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
 * The persistence utility for the expense service. This utility wraps <code>com.liferay.me.expense.manager.service.persistence.impl.ExpensePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpensePersistence
 * @generated
 */
public class ExpenseUtil {

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
	public static void clearCache(Expense expense) {
		getPersistence().clearCache(expense);
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
	public static Map<Serializable, Expense> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Expense> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Expense> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Expense> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Expense> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Expense update(Expense expense) {
		return getPersistence().update(expense);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Expense update(
		Expense expense, ServiceContext serviceContext) {

		return getPersistence().update(expense, serviceContext);
	}

	/**
	 * Returns all the expenses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching expenses
	 */
	public static List<Expense> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the expenses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @return the range of matching expenses
	 */
	public static List<Expense> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the expenses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expenses
	 */
	public static List<Expense> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Expense> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the expenses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching expenses
	 */
	public static List<Expense> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Expense> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first expense in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense
	 * @throws NoSuchExpenseException if a matching expense could not be found
	 */
	public static Expense findByGroupId_First(
			long groupId, OrderByComparator<Expense> orderByComparator)
		throws com.liferay.me.expense.manager.exception.NoSuchExpenseException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first expense in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense, or <code>null</code> if a matching expense could not be found
	 */
	public static Expense fetchByGroupId_First(
		long groupId, OrderByComparator<Expense> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last expense in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense
	 * @throws NoSuchExpenseException if a matching expense could not be found
	 */
	public static Expense findByGroupId_Last(
			long groupId, OrderByComparator<Expense> orderByComparator)
		throws com.liferay.me.expense.manager.exception.NoSuchExpenseException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last expense in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense, or <code>null</code> if a matching expense could not be found
	 */
	public static Expense fetchByGroupId_Last(
		long groupId, OrderByComparator<Expense> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the expenses before and after the current expense in the ordered set where groupId = &#63;.
	 *
	 * @param expenseId the primary key of the current expense
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense
	 * @throws NoSuchExpenseException if a expense with the primary key could not be found
	 */
	public static Expense[] findByGroupId_PrevAndNext(
			long expenseId, long groupId,
			OrderByComparator<Expense> orderByComparator)
		throws com.liferay.me.expense.manager.exception.NoSuchExpenseException {

		return getPersistence().findByGroupId_PrevAndNext(
			expenseId, groupId, orderByComparator);
	}

	/**
	 * Returns all the expenses that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching expenses that the user has permission to view
	 */
	public static List<Expense> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	 * Returns a range of all the expenses that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @return the range of matching expenses that the user has permission to view
	 */
	public static List<Expense> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the expenses that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expenses that the user has permission to view
	 */
	public static List<Expense> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Expense> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the expenses before and after the current expense in the ordered set of expenses that the user has permission to view where groupId = &#63;.
	 *
	 * @param expenseId the primary key of the current expense
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense
	 * @throws NoSuchExpenseException if a expense with the primary key could not be found
	 */
	public static Expense[] filterFindByGroupId_PrevAndNext(
			long expenseId, long groupId,
			OrderByComparator<Expense> orderByComparator)
		throws com.liferay.me.expense.manager.exception.NoSuchExpenseException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			expenseId, groupId, orderByComparator);
	}

	/**
	 * Removes all the expenses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of expenses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching expenses
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of expenses that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching expenses that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Returns all the expenses where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the matching expenses
	 */
	public static List<Expense> findByUserName(String userName) {
		return getPersistence().findByUserName(userName);
	}

	/**
	 * Returns a range of all the expenses where userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseModelImpl</code>.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @return the range of matching expenses
	 */
	public static List<Expense> findByUserName(
		String userName, int start, int end) {

		return getPersistence().findByUserName(userName, start, end);
	}

	/**
	 * Returns an ordered range of all the expenses where userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseModelImpl</code>.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expenses
	 */
	public static List<Expense> findByUserName(
		String userName, int start, int end,
		OrderByComparator<Expense> orderByComparator) {

		return getPersistence().findByUserName(
			userName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the expenses where userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseModelImpl</code>.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching expenses
	 */
	public static List<Expense> findByUserName(
		String userName, int start, int end,
		OrderByComparator<Expense> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUserName(
			userName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first expense in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense
	 * @throws NoSuchExpenseException if a matching expense could not be found
	 */
	public static Expense findByUserName_First(
			String userName, OrderByComparator<Expense> orderByComparator)
		throws com.liferay.me.expense.manager.exception.NoSuchExpenseException {

		return getPersistence().findByUserName_First(
			userName, orderByComparator);
	}

	/**
	 * Returns the first expense in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense, or <code>null</code> if a matching expense could not be found
	 */
	public static Expense fetchByUserName_First(
		String userName, OrderByComparator<Expense> orderByComparator) {

		return getPersistence().fetchByUserName_First(
			userName, orderByComparator);
	}

	/**
	 * Returns the last expense in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense
	 * @throws NoSuchExpenseException if a matching expense could not be found
	 */
	public static Expense findByUserName_Last(
			String userName, OrderByComparator<Expense> orderByComparator)
		throws com.liferay.me.expense.manager.exception.NoSuchExpenseException {

		return getPersistence().findByUserName_Last(
			userName, orderByComparator);
	}

	/**
	 * Returns the last expense in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense, or <code>null</code> if a matching expense could not be found
	 */
	public static Expense fetchByUserName_Last(
		String userName, OrderByComparator<Expense> orderByComparator) {

		return getPersistence().fetchByUserName_Last(
			userName, orderByComparator);
	}

	/**
	 * Returns the expenses before and after the current expense in the ordered set where userName = &#63;.
	 *
	 * @param expenseId the primary key of the current expense
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense
	 * @throws NoSuchExpenseException if a expense with the primary key could not be found
	 */
	public static Expense[] findByUserName_PrevAndNext(
			long expenseId, String userName,
			OrderByComparator<Expense> orderByComparator)
		throws com.liferay.me.expense.manager.exception.NoSuchExpenseException {

		return getPersistence().findByUserName_PrevAndNext(
			expenseId, userName, orderByComparator);
	}

	/**
	 * Removes all the expenses where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 */
	public static void removeByUserName(String userName) {
		getPersistence().removeByUserName(userName);
	}

	/**
	 * Returns the number of expenses where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching expenses
	 */
	public static int countByUserName(String userName) {
		return getPersistence().countByUserName(userName);
	}

	/**
	 * Returns all the expenses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching expenses
	 */
	public static List<Expense> findByUserID(long userId) {
		return getPersistence().findByUserID(userId);
	}

	/**
	 * Returns a range of all the expenses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @return the range of matching expenses
	 */
	public static List<Expense> findByUserID(long userId, int start, int end) {
		return getPersistence().findByUserID(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the expenses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expenses
	 */
	public static List<Expense> findByUserID(
		long userId, int start, int end,
		OrderByComparator<Expense> orderByComparator) {

		return getPersistence().findByUserID(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the expenses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching expenses
	 */
	public static List<Expense> findByUserID(
		long userId, int start, int end,
		OrderByComparator<Expense> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUserID(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first expense in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense
	 * @throws NoSuchExpenseException if a matching expense could not be found
	 */
	public static Expense findByUserID_First(
			long userId, OrderByComparator<Expense> orderByComparator)
		throws com.liferay.me.expense.manager.exception.NoSuchExpenseException {

		return getPersistence().findByUserID_First(userId, orderByComparator);
	}

	/**
	 * Returns the first expense in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense, or <code>null</code> if a matching expense could not be found
	 */
	public static Expense fetchByUserID_First(
		long userId, OrderByComparator<Expense> orderByComparator) {

		return getPersistence().fetchByUserID_First(userId, orderByComparator);
	}

	/**
	 * Returns the last expense in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense
	 * @throws NoSuchExpenseException if a matching expense could not be found
	 */
	public static Expense findByUserID_Last(
			long userId, OrderByComparator<Expense> orderByComparator)
		throws com.liferay.me.expense.manager.exception.NoSuchExpenseException {

		return getPersistence().findByUserID_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last expense in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense, or <code>null</code> if a matching expense could not be found
	 */
	public static Expense fetchByUserID_Last(
		long userId, OrderByComparator<Expense> orderByComparator) {

		return getPersistence().fetchByUserID_Last(userId, orderByComparator);
	}

	/**
	 * Returns the expenses before and after the current expense in the ordered set where userId = &#63;.
	 *
	 * @param expenseId the primary key of the current expense
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense
	 * @throws NoSuchExpenseException if a expense with the primary key could not be found
	 */
	public static Expense[] findByUserID_PrevAndNext(
			long expenseId, long userId,
			OrderByComparator<Expense> orderByComparator)
		throws com.liferay.me.expense.manager.exception.NoSuchExpenseException {

		return getPersistence().findByUserID_PrevAndNext(
			expenseId, userId, orderByComparator);
	}

	/**
	 * Removes all the expenses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserID(long userId) {
		getPersistence().removeByUserID(userId);
	}

	/**
	 * Returns the number of expenses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching expenses
	 */
	public static int countByUserID(long userId) {
		return getPersistence().countByUserID(userId);
	}

	/**
	 * Returns the expense where expenseId = &#63; or throws a <code>NoSuchExpenseException</code> if it could not be found.
	 *
	 * @param expenseId the expense ID
	 * @return the matching expense
	 * @throws NoSuchExpenseException if a matching expense could not be found
	 */
	public static Expense findByExpenseId(long expenseId)
		throws com.liferay.me.expense.manager.exception.NoSuchExpenseException {

		return getPersistence().findByExpenseId(expenseId);
	}

	/**
	 * Returns the expense where expenseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param expenseId the expense ID
	 * @return the matching expense, or <code>null</code> if a matching expense could not be found
	 */
	public static Expense fetchByExpenseId(long expenseId) {
		return getPersistence().fetchByExpenseId(expenseId);
	}

	/**
	 * Returns the expense where expenseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param expenseId the expense ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching expense, or <code>null</code> if a matching expense could not be found
	 */
	public static Expense fetchByExpenseId(
		long expenseId, boolean useFinderCache) {

		return getPersistence().fetchByExpenseId(expenseId, useFinderCache);
	}

	/**
	 * Removes the expense where expenseId = &#63; from the database.
	 *
	 * @param expenseId the expense ID
	 * @return the expense that was removed
	 */
	public static Expense removeByExpenseId(long expenseId)
		throws com.liferay.me.expense.manager.exception.NoSuchExpenseException {

		return getPersistence().removeByExpenseId(expenseId);
	}

	/**
	 * Returns the number of expenses where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @return the number of matching expenses
	 */
	public static int countByExpenseId(long expenseId) {
		return getPersistence().countByExpenseId(expenseId);
	}

	/**
	 * Returns all the expenses where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching expenses
	 */
	public static List<Expense> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the expenses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @return the range of matching expenses
	 */
	public static List<Expense> findByStatus(int status, int start, int end) {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the expenses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expenses
	 */
	public static List<Expense> findByStatus(
		int status, int start, int end,
		OrderByComparator<Expense> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the expenses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching expenses
	 */
	public static List<Expense> findByStatus(
		int status, int start, int end,
		OrderByComparator<Expense> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first expense in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense
	 * @throws NoSuchExpenseException if a matching expense could not be found
	 */
	public static Expense findByStatus_First(
			int status, OrderByComparator<Expense> orderByComparator)
		throws com.liferay.me.expense.manager.exception.NoSuchExpenseException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first expense in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense, or <code>null</code> if a matching expense could not be found
	 */
	public static Expense fetchByStatus_First(
		int status, OrderByComparator<Expense> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last expense in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense
	 * @throws NoSuchExpenseException if a matching expense could not be found
	 */
	public static Expense findByStatus_Last(
			int status, OrderByComparator<Expense> orderByComparator)
		throws com.liferay.me.expense.manager.exception.NoSuchExpenseException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last expense in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense, or <code>null</code> if a matching expense could not be found
	 */
	public static Expense fetchByStatus_Last(
		int status, OrderByComparator<Expense> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the expenses before and after the current expense in the ordered set where status = &#63;.
	 *
	 * @param expenseId the primary key of the current expense
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense
	 * @throws NoSuchExpenseException if a expense with the primary key could not be found
	 */
	public static Expense[] findByStatus_PrevAndNext(
			long expenseId, int status,
			OrderByComparator<Expense> orderByComparator)
		throws com.liferay.me.expense.manager.exception.NoSuchExpenseException {

		return getPersistence().findByStatus_PrevAndNext(
			expenseId, status, orderByComparator);
	}

	/**
	 * Removes all the expenses where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of expenses where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching expenses
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the expenses where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching expenses
	 */
	public static List<Expense> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the expenses where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @return the range of matching expenses
	 */
	public static List<Expense> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the expenses where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expenses
	 */
	public static List<Expense> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Expense> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the expenses where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching expenses
	 */
	public static List<Expense> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Expense> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first expense in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense
	 * @throws NoSuchExpenseException if a matching expense could not be found
	 */
	public static Expense findByG_S_First(
			long groupId, int status,
			OrderByComparator<Expense> orderByComparator)
		throws com.liferay.me.expense.manager.exception.NoSuchExpenseException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first expense in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense, or <code>null</code> if a matching expense could not be found
	 */
	public static Expense fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<Expense> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last expense in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense
	 * @throws NoSuchExpenseException if a matching expense could not be found
	 */
	public static Expense findByG_S_Last(
			long groupId, int status,
			OrderByComparator<Expense> orderByComparator)
		throws com.liferay.me.expense.manager.exception.NoSuchExpenseException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last expense in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense, or <code>null</code> if a matching expense could not be found
	 */
	public static Expense fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<Expense> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the expenses before and after the current expense in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param expenseId the primary key of the current expense
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense
	 * @throws NoSuchExpenseException if a expense with the primary key could not be found
	 */
	public static Expense[] findByG_S_PrevAndNext(
			long expenseId, long groupId, int status,
			OrderByComparator<Expense> orderByComparator)
		throws com.liferay.me.expense.manager.exception.NoSuchExpenseException {

		return getPersistence().findByG_S_PrevAndNext(
			expenseId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the expenses that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching expenses that the user has permission to view
	 */
	public static List<Expense> filterFindByG_S(long groupId, int status) {
		return getPersistence().filterFindByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the expenses that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @return the range of matching expenses that the user has permission to view
	 */
	public static List<Expense> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().filterFindByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the expenses that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expenses that the user has permission to view
	 */
	public static List<Expense> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<Expense> orderByComparator) {

		return getPersistence().filterFindByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the expenses before and after the current expense in the ordered set of expenses that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param expenseId the primary key of the current expense
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense
	 * @throws NoSuchExpenseException if a expense with the primary key could not be found
	 */
	public static Expense[] filterFindByG_S_PrevAndNext(
			long expenseId, long groupId, int status,
			OrderByComparator<Expense> orderByComparator)
		throws com.liferay.me.expense.manager.exception.NoSuchExpenseException {

		return getPersistence().filterFindByG_S_PrevAndNext(
			expenseId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the expenses where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of expenses where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching expenses
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Returns the number of expenses that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching expenses that the user has permission to view
	 */
	public static int filterCountByG_S(long groupId, int status) {
		return getPersistence().filterCountByG_S(groupId, status);
	}

	/**
	 * Caches the expense in the entity cache if it is enabled.
	 *
	 * @param expense the expense
	 */
	public static void cacheResult(Expense expense) {
		getPersistence().cacheResult(expense);
	}

	/**
	 * Caches the expenses in the entity cache if it is enabled.
	 *
	 * @param expenses the expenses
	 */
	public static void cacheResult(List<Expense> expenses) {
		getPersistence().cacheResult(expenses);
	}

	/**
	 * Creates a new expense with the primary key. Does not add the expense to the database.
	 *
	 * @param expenseId the primary key for the new expense
	 * @return the new expense
	 */
	public static Expense create(long expenseId) {
		return getPersistence().create(expenseId);
	}

	/**
	 * Removes the expense with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param expenseId the primary key of the expense
	 * @return the expense that was removed
	 * @throws NoSuchExpenseException if a expense with the primary key could not be found
	 */
	public static Expense remove(long expenseId)
		throws com.liferay.me.expense.manager.exception.NoSuchExpenseException {

		return getPersistence().remove(expenseId);
	}

	public static Expense updateImpl(Expense expense) {
		return getPersistence().updateImpl(expense);
	}

	/**
	 * Returns the expense with the primary key or throws a <code>NoSuchExpenseException</code> if it could not be found.
	 *
	 * @param expenseId the primary key of the expense
	 * @return the expense
	 * @throws NoSuchExpenseException if a expense with the primary key could not be found
	 */
	public static Expense findByPrimaryKey(long expenseId)
		throws com.liferay.me.expense.manager.exception.NoSuchExpenseException {

		return getPersistence().findByPrimaryKey(expenseId);
	}

	/**
	 * Returns the expense with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param expenseId the primary key of the expense
	 * @return the expense, or <code>null</code> if a expense with the primary key could not be found
	 */
	public static Expense fetchByPrimaryKey(long expenseId) {
		return getPersistence().fetchByPrimaryKey(expenseId);
	}

	/**
	 * Returns all the expenses.
	 *
	 * @return the expenses
	 */
	public static List<Expense> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the expenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @return the range of expenses
	 */
	public static List<Expense> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the expenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of expenses
	 */
	public static List<Expense> findAll(
		int start, int end, OrderByComparator<Expense> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the expenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExpenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of expenses
	 */
	public static List<Expense> findAll(
		int start, int end, OrderByComparator<Expense> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the expenses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of expenses.
	 *
	 * @return the number of expenses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ExpensePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ExpensePersistence, ExpensePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ExpensePersistence.class);

		ServiceTracker<ExpensePersistence, ExpensePersistence> serviceTracker =
			new ServiceTracker<ExpensePersistence, ExpensePersistence>(
				bundle.getBundleContext(), ExpensePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}