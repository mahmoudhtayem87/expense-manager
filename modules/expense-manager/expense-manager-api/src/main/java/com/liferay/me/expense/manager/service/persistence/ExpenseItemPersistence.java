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

import com.liferay.me.expense.manager.exception.NoSuchExpenseItemException;
import com.liferay.me.expense.manager.model.ExpenseItem;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the expense item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseItemUtil
 * @generated
 */
@ProviderType
public interface ExpenseItemPersistence extends BasePersistence<ExpenseItem> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExpenseItemUtil} to access the expense item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the expense items where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching expense items
	 */
	public java.util.List<ExpenseItem> findByGroupId(long groupId);

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
	public java.util.List<ExpenseItem> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<ExpenseItem> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
			orderByComparator);

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
	public java.util.List<ExpenseItem> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first expense item in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	public ExpenseItem findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
				orderByComparator)
		throws NoSuchExpenseItemException;

	/**
	 * Returns the first expense item in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	public ExpenseItem fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
			orderByComparator);

	/**
	 * Returns the last expense item in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	public ExpenseItem findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
				orderByComparator)
		throws NoSuchExpenseItemException;

	/**
	 * Returns the last expense item in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	public ExpenseItem fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
			orderByComparator);

	/**
	 * Returns the expense items before and after the current expense item in the ordered set where groupId = &#63;.
	 *
	 * @param expenseItemId the primary key of the current expense item
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense item
	 * @throws NoSuchExpenseItemException if a expense item with the primary key could not be found
	 */
	public ExpenseItem[] findByGroupId_PrevAndNext(
			long expenseItemId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
				orderByComparator)
		throws NoSuchExpenseItemException;

	/**
	 * Returns all the expense items that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching expense items that the user has permission to view
	 */
	public java.util.List<ExpenseItem> filterFindByGroupId(long groupId);

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
	public java.util.List<ExpenseItem> filterFindByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<ExpenseItem> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
			orderByComparator);

	/**
	 * Returns the expense items before and after the current expense item in the ordered set of expense items that the user has permission to view where groupId = &#63;.
	 *
	 * @param expenseItemId the primary key of the current expense item
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense item
	 * @throws NoSuchExpenseItemException if a expense item with the primary key could not be found
	 */
	public ExpenseItem[] filterFindByGroupId_PrevAndNext(
			long expenseItemId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
				orderByComparator)
		throws NoSuchExpenseItemException;

	/**
	 * Removes all the expense items where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of expense items where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching expense items
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of expense items that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching expense items that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the expense items where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @return the matching expense items
	 */
	public java.util.List<ExpenseItem> findByExpenseId(long expenseId);

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
	public java.util.List<ExpenseItem> findByExpenseId(
		long expenseId, int start, int end);

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
	public java.util.List<ExpenseItem> findByExpenseId(
		long expenseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
			orderByComparator);

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
	public java.util.List<ExpenseItem> findByExpenseId(
		long expenseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first expense item in the ordered set where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	public ExpenseItem findByExpenseId_First(
			long expenseId,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
				orderByComparator)
		throws NoSuchExpenseItemException;

	/**
	 * Returns the first expense item in the ordered set where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	public ExpenseItem fetchByExpenseId_First(
		long expenseId,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
			orderByComparator);

	/**
	 * Returns the last expense item in the ordered set where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	public ExpenseItem findByExpenseId_Last(
			long expenseId,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
				orderByComparator)
		throws NoSuchExpenseItemException;

	/**
	 * Returns the last expense item in the ordered set where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	public ExpenseItem fetchByExpenseId_Last(
		long expenseId,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
			orderByComparator);

	/**
	 * Returns the expense items before and after the current expense item in the ordered set where expenseId = &#63;.
	 *
	 * @param expenseItemId the primary key of the current expense item
	 * @param expenseId the expense ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense item
	 * @throws NoSuchExpenseItemException if a expense item with the primary key could not be found
	 */
	public ExpenseItem[] findByExpenseId_PrevAndNext(
			long expenseItemId, long expenseId,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
				orderByComparator)
		throws NoSuchExpenseItemException;

	/**
	 * Removes all the expense items where expenseId = &#63; from the database.
	 *
	 * @param expenseId the expense ID
	 */
	public void removeByExpenseId(long expenseId);

	/**
	 * Returns the number of expense items where expenseId = &#63;.
	 *
	 * @param expenseId the expense ID
	 * @return the number of matching expense items
	 */
	public int countByExpenseId(long expenseId);

	/**
	 * Returns all the expense items where expenseItemId = &#63;.
	 *
	 * @param expenseItemId the expense item ID
	 * @return the matching expense items
	 */
	public java.util.List<ExpenseItem> findByExpenseItemId(long expenseItemId);

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
	public java.util.List<ExpenseItem> findByExpenseItemId(
		long expenseItemId, int start, int end);

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
	public java.util.List<ExpenseItem> findByExpenseItemId(
		long expenseItemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
			orderByComparator);

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
	public java.util.List<ExpenseItem> findByExpenseItemId(
		long expenseItemId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first expense item in the ordered set where expenseItemId = &#63;.
	 *
	 * @param expenseItemId the expense item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	public ExpenseItem findByExpenseItemId_First(
			long expenseItemId,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
				orderByComparator)
		throws NoSuchExpenseItemException;

	/**
	 * Returns the first expense item in the ordered set where expenseItemId = &#63;.
	 *
	 * @param expenseItemId the expense item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	public ExpenseItem fetchByExpenseItemId_First(
		long expenseItemId,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
			orderByComparator);

	/**
	 * Returns the last expense item in the ordered set where expenseItemId = &#63;.
	 *
	 * @param expenseItemId the expense item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	public ExpenseItem findByExpenseItemId_Last(
			long expenseItemId,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
				orderByComparator)
		throws NoSuchExpenseItemException;

	/**
	 * Returns the last expense item in the ordered set where expenseItemId = &#63;.
	 *
	 * @param expenseItemId the expense item ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	public ExpenseItem fetchByExpenseItemId_Last(
		long expenseItemId,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
			orderByComparator);

	/**
	 * Removes all the expense items where expenseItemId = &#63; from the database.
	 *
	 * @param expenseItemId the expense item ID
	 */
	public void removeByExpenseItemId(long expenseItemId);

	/**
	 * Returns the number of expense items where expenseItemId = &#63;.
	 *
	 * @param expenseItemId the expense item ID
	 * @return the number of matching expense items
	 */
	public int countByExpenseItemId(long expenseItemId);

	/**
	 * Returns all the expense items where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching expense items
	 */
	public java.util.List<ExpenseItem> findByStatus(int status);

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
	public java.util.List<ExpenseItem> findByStatus(
		int status, int start, int end);

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
	public java.util.List<ExpenseItem> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
			orderByComparator);

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
	public java.util.List<ExpenseItem> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first expense item in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	public ExpenseItem findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
				orderByComparator)
		throws NoSuchExpenseItemException;

	/**
	 * Returns the first expense item in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	public ExpenseItem fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
			orderByComparator);

	/**
	 * Returns the last expense item in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	public ExpenseItem findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
				orderByComparator)
		throws NoSuchExpenseItemException;

	/**
	 * Returns the last expense item in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	public ExpenseItem fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
			orderByComparator);

	/**
	 * Returns the expense items before and after the current expense item in the ordered set where status = &#63;.
	 *
	 * @param expenseItemId the primary key of the current expense item
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expense item
	 * @throws NoSuchExpenseItemException if a expense item with the primary key could not be found
	 */
	public ExpenseItem[] findByStatus_PrevAndNext(
			long expenseItemId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
				orderByComparator)
		throws NoSuchExpenseItemException;

	/**
	 * Removes all the expense items where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of expense items where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching expense items
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the expense items where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching expense items
	 */
	public java.util.List<ExpenseItem> findByG_S(long groupId, int status);

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
	public java.util.List<ExpenseItem> findByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<ExpenseItem> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
			orderByComparator);

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
	public java.util.List<ExpenseItem> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first expense item in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	public ExpenseItem findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
				orderByComparator)
		throws NoSuchExpenseItemException;

	/**
	 * Returns the first expense item in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	public ExpenseItem fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
			orderByComparator);

	/**
	 * Returns the last expense item in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item
	 * @throws NoSuchExpenseItemException if a matching expense item could not be found
	 */
	public ExpenseItem findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
				orderByComparator)
		throws NoSuchExpenseItemException;

	/**
	 * Returns the last expense item in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expense item, or <code>null</code> if a matching expense item could not be found
	 */
	public ExpenseItem fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
			orderByComparator);

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
	public ExpenseItem[] findByG_S_PrevAndNext(
			long expenseItemId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
				orderByComparator)
		throws NoSuchExpenseItemException;

	/**
	 * Returns all the expense items that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching expense items that the user has permission to view
	 */
	public java.util.List<ExpenseItem> filterFindByG_S(
		long groupId, int status);

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
	public java.util.List<ExpenseItem> filterFindByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<ExpenseItem> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
			orderByComparator);

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
	public ExpenseItem[] filterFindByG_S_PrevAndNext(
			long expenseItemId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
				orderByComparator)
		throws NoSuchExpenseItemException;

	/**
	 * Removes all the expense items where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of expense items where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching expense items
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Returns the number of expense items that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching expense items that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int status);

	/**
	 * Caches the expense item in the entity cache if it is enabled.
	 *
	 * @param expenseItem the expense item
	 */
	public void cacheResult(ExpenseItem expenseItem);

	/**
	 * Caches the expense items in the entity cache if it is enabled.
	 *
	 * @param expenseItems the expense items
	 */
	public void cacheResult(java.util.List<ExpenseItem> expenseItems);

	/**
	 * Creates a new expense item with the primary key. Does not add the expense item to the database.
	 *
	 * @param expenseItemId the primary key for the new expense item
	 * @return the new expense item
	 */
	public ExpenseItem create(long expenseItemId);

	/**
	 * Removes the expense item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param expenseItemId the primary key of the expense item
	 * @return the expense item that was removed
	 * @throws NoSuchExpenseItemException if a expense item with the primary key could not be found
	 */
	public ExpenseItem remove(long expenseItemId)
		throws NoSuchExpenseItemException;

	public ExpenseItem updateImpl(ExpenseItem expenseItem);

	/**
	 * Returns the expense item with the primary key or throws a <code>NoSuchExpenseItemException</code> if it could not be found.
	 *
	 * @param expenseItemId the primary key of the expense item
	 * @return the expense item
	 * @throws NoSuchExpenseItemException if a expense item with the primary key could not be found
	 */
	public ExpenseItem findByPrimaryKey(long expenseItemId)
		throws NoSuchExpenseItemException;

	/**
	 * Returns the expense item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param expenseItemId the primary key of the expense item
	 * @return the expense item, or <code>null</code> if a expense item with the primary key could not be found
	 */
	public ExpenseItem fetchByPrimaryKey(long expenseItemId);

	/**
	 * Returns all the expense items.
	 *
	 * @return the expense items
	 */
	public java.util.List<ExpenseItem> findAll();

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
	public java.util.List<ExpenseItem> findAll(int start, int end);

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
	public java.util.List<ExpenseItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
			orderByComparator);

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
	public java.util.List<ExpenseItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExpenseItem>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the expense items from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of expense items.
	 *
	 * @return the number of expense items
	 */
	public int countAll();

}