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

import com.liferay.me.expense.manager.model.ExpenseItemType;
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
 * The persistence utility for the expense item type service. This utility wraps <code>com.liferay.me.expense.manager.service.persistence.impl.ExpenseItemTypePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseItemTypePersistence
 * @generated
 */
public class ExpenseItemTypeUtil {

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
	public static void clearCache(ExpenseItemType expenseItemType) {
		getPersistence().clearCache(expenseItemType);
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
	public static Map<Serializable, ExpenseItemType> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ExpenseItemType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ExpenseItemType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ExpenseItemType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ExpenseItemType> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ExpenseItemType update(ExpenseItemType expenseItemType) {
		return getPersistence().update(expenseItemType);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ExpenseItemType update(
		ExpenseItemType expenseItemType, ServiceContext serviceContext) {

		return getPersistence().update(expenseItemType, serviceContext);
	}

	/**
	 * Returns all the expense item types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching expense item types
	 */
	public static List<ExpenseItemType> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
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
	public static List<ExpenseItemType> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
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
	public static List<ExpenseItemType> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ExpenseItemType> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
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
	public static List<ExpenseItemType> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ExpenseItemType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first expense item type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item type
	 * @throws NoSuchExpenseItemTypeException if a matching expense item type could not be found
	 */
	public static ExpenseItemType findByGroupId_First(
			long groupId, OrderByComparator<ExpenseItemType> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemTypeException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first expense item type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item type, or <code>null</code> if a matching expense item type could not be found
	 */
	public static ExpenseItemType fetchByGroupId_First(
		long groupId, OrderByComparator<ExpenseItemType> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last expense item type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item type
	 * @throws NoSuchExpenseItemTypeException if a matching expense item type could not be found
	 */
	public static ExpenseItemType findByGroupId_Last(
			long groupId, OrderByComparator<ExpenseItemType> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemTypeException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last expense item type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item type, or <code>null</code> if a matching expense item type could not be found
	 */
	public static ExpenseItemType fetchByGroupId_Last(
		long groupId, OrderByComparator<ExpenseItemType> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
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
	public static ExpenseItemType[] findByGroupId_PrevAndNext(
			long expenseItemTypeId, long groupId,
			OrderByComparator<ExpenseItemType> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemTypeException {

		return getPersistence().findByGroupId_PrevAndNext(
			expenseItemTypeId, groupId, orderByComparator);
	}

	/**
	 * Returns all the expense item types that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching expense item types that the user has permission to view
	 */
	public static List<ExpenseItemType> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
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
	public static List<ExpenseItemType> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
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
	public static List<ExpenseItemType> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ExpenseItemType> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
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
	public static ExpenseItemType[] filterFindByGroupId_PrevAndNext(
			long expenseItemTypeId, long groupId,
			OrderByComparator<ExpenseItemType> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemTypeException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			expenseItemTypeId, groupId, orderByComparator);
	}

	/**
	 * Removes all the expense item types where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of expense item types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching expense item types
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of expense item types that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching expense item types that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Returns the expense item type where expenseItemTypeId = &#63; or throws a <code>NoSuchExpenseItemTypeException</code> if it could not be found.
	 *
	 * @param expenseItemTypeId the expense item type ID
	 * @return the matching expense item type
	 * @throws NoSuchExpenseItemTypeException if a matching expense item type could not be found
	 */
	public static ExpenseItemType findByExpenseItemTypeId(
			long expenseItemTypeId)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemTypeException {

		return getPersistence().findByExpenseItemTypeId(expenseItemTypeId);
	}

	/**
	 * Returns the expense item type where expenseItemTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param expenseItemTypeId the expense item type ID
	 * @return the matching expense item type, or <code>null</code> if a matching expense item type could not be found
	 */
	public static ExpenseItemType fetchByExpenseItemTypeId(
		long expenseItemTypeId) {

		return getPersistence().fetchByExpenseItemTypeId(expenseItemTypeId);
	}

	/**
	 * Returns the expense item type where expenseItemTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param expenseItemTypeId the expense item type ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching expense item type, or <code>null</code> if a matching expense item type could not be found
	 */
	public static ExpenseItemType fetchByExpenseItemTypeId(
		long expenseItemTypeId, boolean useFinderCache) {

		return getPersistence().fetchByExpenseItemTypeId(
			expenseItemTypeId, useFinderCache);
	}

	/**
	 * Removes the expense item type where expenseItemTypeId = &#63; from the database.
	 *
	 * @param expenseItemTypeId the expense item type ID
	 * @return the expense item type that was removed
	 */
	public static ExpenseItemType removeByExpenseItemTypeId(
			long expenseItemTypeId)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemTypeException {

		return getPersistence().removeByExpenseItemTypeId(expenseItemTypeId);
	}

	/**
	 * Returns the number of expense item types where expenseItemTypeId = &#63;.
	 *
	 * @param expenseItemTypeId the expense item type ID
	 * @return the number of matching expense item types
	 */
	public static int countByExpenseItemTypeId(long expenseItemTypeId) {
		return getPersistence().countByExpenseItemTypeId(expenseItemTypeId);
	}

	/**
	 * Returns all the expense item types where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching expense item types
	 */
	public static List<ExpenseItemType> findByStatus(int status) {
		return getPersistence().findByStatus(status);
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
	public static List<ExpenseItemType> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
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
	public static List<ExpenseItemType> findByStatus(
		int status, int start, int end,
		OrderByComparator<ExpenseItemType> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
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
	public static List<ExpenseItemType> findByStatus(
		int status, int start, int end,
		OrderByComparator<ExpenseItemType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first expense item type in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item type
	 * @throws NoSuchExpenseItemTypeException if a matching expense item type could not be found
	 */
	public static ExpenseItemType findByStatus_First(
			int status, OrderByComparator<ExpenseItemType> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemTypeException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first expense item type in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item type, or <code>null</code> if a matching expense item type could not be found
	 */
	public static ExpenseItemType fetchByStatus_First(
		int status, OrderByComparator<ExpenseItemType> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last expense item type in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item type
	 * @throws NoSuchExpenseItemTypeException if a matching expense item type could not be found
	 */
	public static ExpenseItemType findByStatus_Last(
			int status, OrderByComparator<ExpenseItemType> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemTypeException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last expense item type in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item type, or <code>null</code> if a matching expense item type could not be found
	 */
	public static ExpenseItemType fetchByStatus_Last(
		int status, OrderByComparator<ExpenseItemType> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
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
	public static ExpenseItemType[] findByStatus_PrevAndNext(
			long expenseItemTypeId, int status,
			OrderByComparator<ExpenseItemType> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemTypeException {

		return getPersistence().findByStatus_PrevAndNext(
			expenseItemTypeId, status, orderByComparator);
	}

	/**
	 * Removes all the expense item types where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of expense item types where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching expense item types
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the expense item types where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching expense item types
	 */
	public static List<ExpenseItemType> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
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
	public static List<ExpenseItemType> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
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
	public static List<ExpenseItemType> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<ExpenseItemType> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
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
	public static List<ExpenseItemType> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<ExpenseItemType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
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
	public static ExpenseItemType findByG_S_First(
			long groupId, int status,
			OrderByComparator<ExpenseItemType> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemTypeException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first expense item type in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item type, or <code>null</code> if a matching expense item type could not be found
	 */
	public static ExpenseItemType fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<ExpenseItemType> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
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
	public static ExpenseItemType findByG_S_Last(
			long groupId, int status,
			OrderByComparator<ExpenseItemType> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemTypeException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last expense item type in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item type, or <code>null</code> if a matching expense item type could not be found
	 */
	public static ExpenseItemType fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<ExpenseItemType> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
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
	public static ExpenseItemType[] findByG_S_PrevAndNext(
			long expenseItemTypeId, long groupId, int status,
			OrderByComparator<ExpenseItemType> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemTypeException {

		return getPersistence().findByG_S_PrevAndNext(
			expenseItemTypeId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the expense item types that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching expense item types that the user has permission to view
	 */
	public static List<ExpenseItemType> filterFindByG_S(
		long groupId, int status) {

		return getPersistence().filterFindByG_S(groupId, status);
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
	public static List<ExpenseItemType> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().filterFindByG_S(groupId, status, start, end);
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
	public static List<ExpenseItemType> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<ExpenseItemType> orderByComparator) {

		return getPersistence().filterFindByG_S(
			groupId, status, start, end, orderByComparator);
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
	public static ExpenseItemType[] filterFindByG_S_PrevAndNext(
			long expenseItemTypeId, long groupId, int status,
			OrderByComparator<ExpenseItemType> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemTypeException {

		return getPersistence().filterFindByG_S_PrevAndNext(
			expenseItemTypeId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the expense item types where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of expense item types where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching expense item types
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Returns the number of expense item types that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching expense item types that the user has permission to view
	 */
	public static int filterCountByG_S(long groupId, int status) {
		return getPersistence().filterCountByG_S(groupId, status);
	}

	/**
	 * Caches the expense item type in the entity cache if it is enabled.
	 *
	 * @param expenseItemType the expense item type
	 */
	public static void cacheResult(ExpenseItemType expenseItemType) {
		getPersistence().cacheResult(expenseItemType);
	}

	/**
	 * Caches the expense item types in the entity cache if it is enabled.
	 *
	 * @param expenseItemTypes the expense item types
	 */
	public static void cacheResult(List<ExpenseItemType> expenseItemTypes) {
		getPersistence().cacheResult(expenseItemTypes);
	}

	/**
	 * Creates a new expense item type with the primary key. Does not add the expense item type to the database.
	 *
	 * @param expenseItemTypeId the primary key for the new expense item type
	 * @return the new expense item type
	 */
	public static ExpenseItemType create(long expenseItemTypeId) {
		return getPersistence().create(expenseItemTypeId);
	}

	/**
	 * Removes the expense item type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param expenseItemTypeId the primary key of the expense item type
	 * @return the expense item type that was removed
	 * @throws NoSuchExpenseItemTypeException if a expense item type with the primary key could not be found
	 */
	public static ExpenseItemType remove(long expenseItemTypeId)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemTypeException {

		return getPersistence().remove(expenseItemTypeId);
	}

	public static ExpenseItemType updateImpl(ExpenseItemType expenseItemType) {
		return getPersistence().updateImpl(expenseItemType);
	}

	/**
	 * Returns the expense item type with the primary key or throws a <code>NoSuchExpenseItemTypeException</code> if it could not be found.
	 *
	 * @param expenseItemTypeId the primary key of the expense item type
	 * @return the expense item type
	 * @throws NoSuchExpenseItemTypeException if a expense item type with the primary key could not be found
	 */
	public static ExpenseItemType findByPrimaryKey(long expenseItemTypeId)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemTypeException {

		return getPersistence().findByPrimaryKey(expenseItemTypeId);
	}

	/**
	 * Returns the expense item type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param expenseItemTypeId the primary key of the expense item type
	 * @return the expense item type, or <code>null</code> if a expense item type with the primary key could not be found
	 */
	public static ExpenseItemType fetchByPrimaryKey(long expenseItemTypeId) {
		return getPersistence().fetchByPrimaryKey(expenseItemTypeId);
	}

	/**
	 * Returns all the expense item types.
	 *
	 * @return the expense item types
	 */
	public static List<ExpenseItemType> findAll() {
		return getPersistence().findAll();
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
	public static List<ExpenseItemType> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<ExpenseItemType> findAll(
		int start, int end,
		OrderByComparator<ExpenseItemType> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<ExpenseItemType> findAll(
		int start, int end,
		OrderByComparator<ExpenseItemType> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the expense item types from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of expense item types.
	 *
	 * @return the number of expense item types
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ExpenseItemTypePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ExpenseItemTypePersistence, ExpenseItemTypePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ExpenseItemTypePersistence.class);

		ServiceTracker<ExpenseItemTypePersistence, ExpenseItemTypePersistence>
			serviceTracker =
				new ServiceTracker
					<ExpenseItemTypePersistence, ExpenseItemTypePersistence>(
						bundle.getBundleContext(),
						ExpenseItemTypePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}