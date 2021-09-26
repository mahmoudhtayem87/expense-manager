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

import com.liferay.me.expense.manager.exception.NoSuchExpenseException;
import com.liferay.me.expense.manager.model.Expense;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the expense service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseUtil
 * @generated
 */
@ProviderType
public interface ExpensePersistence extends BasePersistence<Expense> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExpenseUtil} to access the expense persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the expenses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching expenses
	 */
	public java.util.List<Expense> findByGroupId(long groupId);

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
	public java.util.List<Expense> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Expense> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Expense>
			orderByComparator);

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
	public java.util.List<Expense> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Expense>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first expense in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense
	 * @throws NoSuchExpenseException if a matching expense could not be found
	 */
	public Expense findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Expense>
				orderByComparator)
		throws NoSuchExpenseException;

	/**
	 * Returns the first expense in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense, or <code>null</code> if a matching expense could not be found
	 */
	public Expense fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Expense>
			orderByComparator);

	/**
	 * Returns the last expense in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense
	 * @throws NoSuchExpenseException if a matching expense could not be found
	 */
	public Expense findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Expense>
				orderByComparator)
		throws NoSuchExpenseException;

	/**
	 * Returns the last expense in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense, or <code>null</code> if a matching expense could not be found
	 */
	public Expense fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Expense>
			orderByComparator);

	/**
	 * Returns the expenses before and after the current expense in the ordered set where groupId = &#63;.
	 *
	 * @param expenseId the primary key of the current expense
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense
	 * @throws NoSuchExpenseException if a expense with the primary key could not be found
	 */
	public Expense[] findByGroupId_PrevAndNext(
			long expenseId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Expense>
				orderByComparator)
		throws NoSuchExpenseException;

	/**
	 * Returns all the expenses that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching expenses that the user has permission to view
	 */
	public java.util.List<Expense> filterFindByGroupId(long groupId);

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
	public java.util.List<Expense> filterFindByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Expense> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Expense>
			orderByComparator);

	/**
	 * Returns the expenses before and after the current expense in the ordered set of expenses that the user has permission to view where groupId = &#63;.
	 *
	 * @param expenseId the primary key of the current expense
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense
	 * @throws NoSuchExpenseException if a expense with the primary key could not be found
	 */
	public Expense[] filterFindByGroupId_PrevAndNext(
			long expenseId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Expense>
				orderByComparator)
		throws NoSuchExpenseException;

	/**
	 * Removes all the expenses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of expenses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching expenses
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of expenses that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching expenses that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the expenses where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the matching expenses
	 */
	public java.util.List<Expense> findByUserName(String userName);

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
	public java.util.List<Expense> findByUserName(
		String userName, int start, int end);

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
	public java.util.List<Expense> findByUserName(
		String userName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Expense>
			orderByComparator);

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
	public java.util.List<Expense> findByUserName(
		String userName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Expense>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first expense in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense
	 * @throws NoSuchExpenseException if a matching expense could not be found
	 */
	public Expense findByUserName_First(
			String userName,
			com.liferay.portal.kernel.util.OrderByComparator<Expense>
				orderByComparator)
		throws NoSuchExpenseException;

	/**
	 * Returns the first expense in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense, or <code>null</code> if a matching expense could not be found
	 */
	public Expense fetchByUserName_First(
		String userName,
		com.liferay.portal.kernel.util.OrderByComparator<Expense>
			orderByComparator);

	/**
	 * Returns the last expense in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense
	 * @throws NoSuchExpenseException if a matching expense could not be found
	 */
	public Expense findByUserName_Last(
			String userName,
			com.liferay.portal.kernel.util.OrderByComparator<Expense>
				orderByComparator)
		throws NoSuchExpenseException;

	/**
	 * Returns the last expense in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense, or <code>null</code> if a matching expense could not be found
	 */
	public Expense fetchByUserName_Last(
		String userName,
		com.liferay.portal.kernel.util.OrderByComparator<Expense>
			orderByComparator);

	/**
	 * Returns the expenses before and after the current expense in the ordered set where userName = &#63;.
	 *
	 * @param expenseId the primary key of the current expense
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense
	 * @throws NoSuchExpenseException if a expense with the primary key could not be found
	 */
	public Expense[] findByUserName_PrevAndNext(
			long expenseId, String userName,
			com.liferay.portal.kernel.util.OrderByComparator<Expense>
				orderByComparator)
		throws NoSuchExpenseException;

	/**
	 * Removes all the expenses where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 */
	public void removeByUserName(String userName);

	/**
	 * Returns the number of expenses where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching expenses
	 */
	public int countByUserName(String userName);

	/**
	 * Returns all the expenses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching expenses
	 */
	public java.util.List<Expense> findByUserID(long userId);

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
	public java.util.List<Expense> findByUserID(
		long userId, int start, int end);

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
	public java.util.List<Expense> findByUserID(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Expense>
			orderByComparator);

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
	public java.util.List<Expense> findByUserID(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Expense>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first expense in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense
	 * @throws NoSuchExpenseException if a matching expense could not be found
	 */
	public Expense findByUserID_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Expense>
				orderByComparator)
		throws NoSuchExpenseException;

	/**
	 * Returns the first expense in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense, or <code>null</code> if a matching expense could not be found
	 */
	public Expense fetchByUserID_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Expense>
			orderByComparator);

	/**
	 * Returns the last expense in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense
	 * @throws NoSuchExpenseException if a matching expense could not be found
	 */
	public Expense findByUserID_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Expense>
				orderByComparator)
		throws NoSuchExpenseException;

	/**
	 * Returns the last expense in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense, or <code>null</code> if a matching expense could not be found
	 */
	public Expense fetchByUserID_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Expense>
			orderByComparator);

	/**
	 * Returns the expenses before and after the current expense in the ordered set where userId = &#63;.
	 *
	 * @param expenseId the primary key of the current expense
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense
	 * @throws NoSuchExpenseException if a expense with the primary key could not be found
	 */
	public Expense[] findByUserID_PrevAndNext(
			long expenseId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Expense>
				orderByComparator)
		throws NoSuchExpenseException;

	/**
	 * Removes all the expenses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserID(long userId);

	/**
	 * Returns the number of expenses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching expenses
	 */
	public int countByUserID(long userId);

	/**
	 * Returns the expense where expenseId = &#63; or throws a <code>NoSuchExpenseException</code> if it could not be found.
	 *
	 * @param expenseId the expense ID
	 * @return the matching expense
	 * @throws NoSuchExpenseException if a matching expense could not be found
	 */
	public Expense findByExpenseId(long expenseId)
		throws NoSuchExpenseException;

	/**
	 * Returns the expense where expenseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param expenseId the expense ID
	 * @return the matching expense, or <code>null</code> if a matching expense could not be found
	 */
	public Expense fetchByExpenseId(long expenseId);

	/**
	 * Returns the expense where expenseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param expenseId the expense ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching expense, or <code>null</code> if a matching expense could not be found
	 */
	public Expense fetchByExpenseId(long expenseId, boolean useFinderCache);

	/**
	 * Removes the expense where expenseId = &#63; from the database.
	 *
	 * @param expenseId the expense ID
	 * @return the expense that was removed
	 */
	public Expense removeByExpenseId(long expenseId)
		throws NoSuchExpenseException;

	/**
	 * Returns the number of expenses where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @return the number of matching expenses
	 */
	public int countByExpenseId(long expenseId);

	/**
	 * Returns all the expenses where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching expenses
	 */
	public java.util.List<Expense> findByStatus(int status);

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
	public java.util.List<Expense> findByStatus(int status, int start, int end);

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
	public java.util.List<Expense> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Expense>
			orderByComparator);

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
	public java.util.List<Expense> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Expense>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first expense in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense
	 * @throws NoSuchExpenseException if a matching expense could not be found
	 */
	public Expense findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Expense>
				orderByComparator)
		throws NoSuchExpenseException;

	/**
	 * Returns the first expense in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense, or <code>null</code> if a matching expense could not be found
	 */
	public Expense fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Expense>
			orderByComparator);

	/**
	 * Returns the last expense in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense
	 * @throws NoSuchExpenseException if a matching expense could not be found
	 */
	public Expense findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Expense>
				orderByComparator)
		throws NoSuchExpenseException;

	/**
	 * Returns the last expense in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense, or <code>null</code> if a matching expense could not be found
	 */
	public Expense fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Expense>
			orderByComparator);

	/**
	 * Returns the expenses before and after the current expense in the ordered set where status = &#63;.
	 *
	 * @param expenseId the primary key of the current expense
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense
	 * @throws NoSuchExpenseException if a expense with the primary key could not be found
	 */
	public Expense[] findByStatus_PrevAndNext(
			long expenseId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Expense>
				orderByComparator)
		throws NoSuchExpenseException;

	/**
	 * Removes all the expenses where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of expenses where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching expenses
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the expenses where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching expenses
	 */
	public java.util.List<Expense> findByG_S(long groupId, int status);

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
	public java.util.List<Expense> findByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<Expense> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Expense>
			orderByComparator);

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
	public java.util.List<Expense> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Expense>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first expense in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense
	 * @throws NoSuchExpenseException if a matching expense could not be found
	 */
	public Expense findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Expense>
				orderByComparator)
		throws NoSuchExpenseException;

	/**
	 * Returns the first expense in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense, or <code>null</code> if a matching expense could not be found
	 */
	public Expense fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Expense>
			orderByComparator);

	/**
	 * Returns the last expense in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense
	 * @throws NoSuchExpenseException if a matching expense could not be found
	 */
	public Expense findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Expense>
				orderByComparator)
		throws NoSuchExpenseException;

	/**
	 * Returns the last expense in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense, or <code>null</code> if a matching expense could not be found
	 */
	public Expense fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Expense>
			orderByComparator);

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
	public Expense[] findByG_S_PrevAndNext(
			long expenseId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Expense>
				orderByComparator)
		throws NoSuchExpenseException;

	/**
	 * Returns all the expenses that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching expenses that the user has permission to view
	 */
	public java.util.List<Expense> filterFindByG_S(long groupId, int status);

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
	public java.util.List<Expense> filterFindByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<Expense> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Expense>
			orderByComparator);

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
	public Expense[] filterFindByG_S_PrevAndNext(
			long expenseId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Expense>
				orderByComparator)
		throws NoSuchExpenseException;

	/**
	 * Removes all the expenses where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of expenses where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching expenses
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Returns the number of expenses that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching expenses that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int status);

	/**
	 * Caches the expense in the entity cache if it is enabled.
	 *
	 * @param expense the expense
	 */
	public void cacheResult(Expense expense);

	/**
	 * Caches the expenses in the entity cache if it is enabled.
	 *
	 * @param expenses the expenses
	 */
	public void cacheResult(java.util.List<Expense> expenses);

	/**
	 * Creates a new expense with the primary key. Does not add the expense to the database.
	 *
	 * @param expenseId the primary key for the new expense
	 * @return the new expense
	 */
	public Expense create(long expenseId);

	/**
	 * Removes the expense with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param expenseId the primary key of the expense
	 * @return the expense that was removed
	 * @throws NoSuchExpenseException if a expense with the primary key could not be found
	 */
	public Expense remove(long expenseId) throws NoSuchExpenseException;

	public Expense updateImpl(Expense expense);

	/**
	 * Returns the expense with the primary key or throws a <code>NoSuchExpenseException</code> if it could not be found.
	 *
	 * @param expenseId the primary key of the expense
	 * @return the expense
	 * @throws NoSuchExpenseException if a expense with the primary key could not be found
	 */
	public Expense findByPrimaryKey(long expenseId)
		throws NoSuchExpenseException;

	/**
	 * Returns the expense with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param expenseId the primary key of the expense
	 * @return the expense, or <code>null</code> if a expense with the primary key could not be found
	 */
	public Expense fetchByPrimaryKey(long expenseId);

	/**
	 * Returns all the expenses.
	 *
	 * @return the expenses
	 */
	public java.util.List<Expense> findAll();

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
	public java.util.List<Expense> findAll(int start, int end);

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
	public java.util.List<Expense> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Expense>
			orderByComparator);

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
	public java.util.List<Expense> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Expense>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the expenses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of expenses.
	 *
	 * @return the number of expenses
	 */
	public int countAll();

}