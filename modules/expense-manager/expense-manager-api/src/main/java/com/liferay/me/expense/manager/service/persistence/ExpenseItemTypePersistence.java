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

import com.liferay.me.expense.manager.exception.NoSuchExpenseItemTypeException;
import com.liferay.me.expense.manager.model.ExpenseItemType;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the expense item type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseItemTypeUtil
 * @generated
 */
@ProviderType
public interface ExpenseItemTypePersistence
	extends BasePersistence<ExpenseItemType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExpenseItemTypeUtil} to access the expense item type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the expense item types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching expense item types
	 */
	public java.util.List<ExpenseItemType> findByGroupId(long groupId);

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
	public java.util.List<ExpenseItemType> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<ExpenseItemType> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
			orderByComparator);

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
	public java.util.List<ExpenseItemType> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first expense item type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item type
	 * @throws NoSuchExpenseItemTypeException if a matching expense item type could not be found
	 */
	public ExpenseItemType findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
				orderByComparator)
		throws NoSuchExpenseItemTypeException;

	/**
	 * Returns the first expense item type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item type, or <code>null</code> if a matching expense item type could not be found
	 */
	public ExpenseItemType fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
			orderByComparator);

	/**
	 * Returns the last expense item type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item type
	 * @throws NoSuchExpenseItemTypeException if a matching expense item type could not be found
	 */
	public ExpenseItemType findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
				orderByComparator)
		throws NoSuchExpenseItemTypeException;

	/**
	 * Returns the last expense item type in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item type, or <code>null</code> if a matching expense item type could not be found
	 */
	public ExpenseItemType fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
			orderByComparator);

	/**
	 * Returns the expense item types before and after the current expense item type in the ordered set where groupId = &#63;.
	 *
	 * @param expenseItemTypeId the primary key of the current expense item type
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense item type
	 * @throws NoSuchExpenseItemTypeException if a expense item type with the primary key could not be found
	 */
	public ExpenseItemType[] findByGroupId_PrevAndNext(
			long expenseItemTypeId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
				orderByComparator)
		throws NoSuchExpenseItemTypeException;

	/**
	 * Returns all the expense item types that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching expense item types that the user has permission to view
	 */
	public java.util.List<ExpenseItemType> filterFindByGroupId(long groupId);

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
	public java.util.List<ExpenseItemType> filterFindByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<ExpenseItemType> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
			orderByComparator);

	/**
	 * Returns the expense item types before and after the current expense item type in the ordered set of expense item types that the user has permission to view where groupId = &#63;.
	 *
	 * @param expenseItemTypeId the primary key of the current expense item type
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense item type
	 * @throws NoSuchExpenseItemTypeException if a expense item type with the primary key could not be found
	 */
	public ExpenseItemType[] filterFindByGroupId_PrevAndNext(
			long expenseItemTypeId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
				orderByComparator)
		throws NoSuchExpenseItemTypeException;

	/**
	 * Removes all the expense item types where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of expense item types where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching expense item types
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of expense item types that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching expense item types that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns the expense item type where expenseItemTypeId = &#63; or throws a <code>NoSuchExpenseItemTypeException</code> if it could not be found.
	 *
	 * @param expenseItemTypeId the expense item type ID
	 * @return the matching expense item type
	 * @throws NoSuchExpenseItemTypeException if a matching expense item type could not be found
	 */
	public ExpenseItemType findByExpenseItemTypeId(long expenseItemTypeId)
		throws NoSuchExpenseItemTypeException;

	/**
	 * Returns the expense item type where expenseItemTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param expenseItemTypeId the expense item type ID
	 * @return the matching expense item type, or <code>null</code> if a matching expense item type could not be found
	 */
	public ExpenseItemType fetchByExpenseItemTypeId(long expenseItemTypeId);

	/**
	 * Returns the expense item type where expenseItemTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param expenseItemTypeId the expense item type ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching expense item type, or <code>null</code> if a matching expense item type could not be found
	 */
	public ExpenseItemType fetchByExpenseItemTypeId(
		long expenseItemTypeId, boolean useFinderCache);

	/**
	 * Removes the expense item type where expenseItemTypeId = &#63; from the database.
	 *
	 * @param expenseItemTypeId the expense item type ID
	 * @return the expense item type that was removed
	 */
	public ExpenseItemType removeByExpenseItemTypeId(long expenseItemTypeId)
		throws NoSuchExpenseItemTypeException;

	/**
	 * Returns the number of expense item types where expenseItemTypeId = &#63;.
	 *
	 * @param expenseItemTypeId the expense item type ID
	 * @return the number of matching expense item types
	 */
	public int countByExpenseItemTypeId(long expenseItemTypeId);

	/**
	 * Returns all the expense item types where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching expense item types
	 */
	public java.util.List<ExpenseItemType> findByStatus(int status);

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
	public java.util.List<ExpenseItemType> findByStatus(
		int status, int start, int end);

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
	public java.util.List<ExpenseItemType> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
			orderByComparator);

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
	public java.util.List<ExpenseItemType> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first expense item type in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item type
	 * @throws NoSuchExpenseItemTypeException if a matching expense item type could not be found
	 */
	public ExpenseItemType findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
				orderByComparator)
		throws NoSuchExpenseItemTypeException;

	/**
	 * Returns the first expense item type in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item type, or <code>null</code> if a matching expense item type could not be found
	 */
	public ExpenseItemType fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
			orderByComparator);

	/**
	 * Returns the last expense item type in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item type
	 * @throws NoSuchExpenseItemTypeException if a matching expense item type could not be found
	 */
	public ExpenseItemType findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
				orderByComparator)
		throws NoSuchExpenseItemTypeException;

	/**
	 * Returns the last expense item type in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item type, or <code>null</code> if a matching expense item type could not be found
	 */
	public ExpenseItemType fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
			orderByComparator);

	/**
	 * Returns the expense item types before and after the current expense item type in the ordered set where status = &#63;.
	 *
	 * @param expenseItemTypeId the primary key of the current expense item type
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense item type
	 * @throws NoSuchExpenseItemTypeException if a expense item type with the primary key could not be found
	 */
	public ExpenseItemType[] findByStatus_PrevAndNext(
			long expenseItemTypeId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
				orderByComparator)
		throws NoSuchExpenseItemTypeException;

	/**
	 * Removes all the expense item types where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of expense item types where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching expense item types
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the expense item types where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching expense item types
	 */
	public java.util.List<ExpenseItemType> findByG_S(long groupId, int status);

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
	public java.util.List<ExpenseItemType> findByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<ExpenseItemType> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
			orderByComparator);

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
	public java.util.List<ExpenseItemType> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first expense item type in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item type
	 * @throws NoSuchExpenseItemTypeException if a matching expense item type could not be found
	 */
	public ExpenseItemType findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
				orderByComparator)
		throws NoSuchExpenseItemTypeException;

	/**
	 * Returns the first expense item type in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item type, or <code>null</code> if a matching expense item type could not be found
	 */
	public ExpenseItemType fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
			orderByComparator);

	/**
	 * Returns the last expense item type in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item type
	 * @throws NoSuchExpenseItemTypeException if a matching expense item type could not be found
	 */
	public ExpenseItemType findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
				orderByComparator)
		throws NoSuchExpenseItemTypeException;

	/**
	 * Returns the last expense item type in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item type, or <code>null</code> if a matching expense item type could not be found
	 */
	public ExpenseItemType fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
			orderByComparator);

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
	public ExpenseItemType[] findByG_S_PrevAndNext(
			long expenseItemTypeId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
				orderByComparator)
		throws NoSuchExpenseItemTypeException;

	/**
	 * Returns all the expense item types that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching expense item types that the user has permission to view
	 */
	public java.util.List<ExpenseItemType> filterFindByG_S(
		long groupId, int status);

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
	public java.util.List<ExpenseItemType> filterFindByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<ExpenseItemType> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
			orderByComparator);

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
	public ExpenseItemType[] filterFindByG_S_PrevAndNext(
			long expenseItemTypeId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
				orderByComparator)
		throws NoSuchExpenseItemTypeException;

	/**
	 * Removes all the expense item types where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of expense item types where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching expense item types
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Returns the number of expense item types that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching expense item types that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int status);

	/**
	 * Caches the expense item type in the entity cache if it is enabled.
	 *
	 * @param expenseItemType the expense item type
	 */
	public void cacheResult(ExpenseItemType expenseItemType);

	/**
	 * Caches the expense item types in the entity cache if it is enabled.
	 *
	 * @param expenseItemTypes the expense item types
	 */
	public void cacheResult(java.util.List<ExpenseItemType> expenseItemTypes);

	/**
	 * Creates a new expense item type with the primary key. Does not add the expense item type to the database.
	 *
	 * @param expenseItemTypeId the primary key for the new expense item type
	 * @return the new expense item type
	 */
	public ExpenseItemType create(long expenseItemTypeId);

	/**
	 * Removes the expense item type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param expenseItemTypeId the primary key of the expense item type
	 * @return the expense item type that was removed
	 * @throws NoSuchExpenseItemTypeException if a expense item type with the primary key could not be found
	 */
	public ExpenseItemType remove(long expenseItemTypeId)
		throws NoSuchExpenseItemTypeException;

	public ExpenseItemType updateImpl(ExpenseItemType expenseItemType);

	/**
	 * Returns the expense item type with the primary key or throws a <code>NoSuchExpenseItemTypeException</code> if it could not be found.
	 *
	 * @param expenseItemTypeId the primary key of the expense item type
	 * @return the expense item type
	 * @throws NoSuchExpenseItemTypeException if a expense item type with the primary key could not be found
	 */
	public ExpenseItemType findByPrimaryKey(long expenseItemTypeId)
		throws NoSuchExpenseItemTypeException;

	/**
	 * Returns the expense item type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param expenseItemTypeId the primary key of the expense item type
	 * @return the expense item type, or <code>null</code> if a expense item type with the primary key could not be found
	 */
	public ExpenseItemType fetchByPrimaryKey(long expenseItemTypeId);

	/**
	 * Returns all the expense item types.
	 *
	 * @return the expense item types
	 */
	public java.util.List<ExpenseItemType> findAll();

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
	public java.util.List<ExpenseItemType> findAll(int start, int end);

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
	public java.util.List<ExpenseItemType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
			orderByComparator);

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
	public java.util.List<ExpenseItemType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItemType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the expense item types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of expense item types.
	 *
	 * @return the number of expense item types
	 */
	public int countAll();

}