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

package com.liferay.me.expense.manager.service;

import com.liferay.me.expense.manager.model.ExpenseItem;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ExpenseItem. This utility wraps
 * <code>com.liferay.me.expense.manager.service.impl.ExpenseItemLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseItemLocalService
 * @generated
 */
public class ExpenseItemLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.me.expense.manager.service.impl.ExpenseItemLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the expense item to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExpenseItemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param expenseItem the expense item
	 * @return the expense item that was added
	 */
	public static ExpenseItem addExpenseItem(ExpenseItem expenseItem) {
		return getService().addExpenseItem(expenseItem);
	}

	public static ExpenseItem addExpenseItem(
			long groupId, long expenseId, long amount, boolean reimburse,
			String title, String description, java.util.Date dateIncurred,
			long type,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addExpenseItem(
			groupId, expenseId, amount, reimburse, title, description,
			dateIncurred, type, serviceContext);
	}

	/**
	 * Creates a new expense item with the primary key. Does not add the expense item to the database.
	 *
	 * @param expenseItemId the primary key for the new expense item
	 * @return the new expense item
	 */
	public static ExpenseItem createExpenseItem(long expenseItemId) {
		return getService().createExpenseItem(expenseItemId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the expense item from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExpenseItemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param expenseItem the expense item
	 * @return the expense item that was removed
	 */
	public static ExpenseItem deleteExpenseItem(ExpenseItem expenseItem) {
		return getService().deleteExpenseItem(expenseItem);
	}

	/**
	 * Deletes the expense item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExpenseItemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param expenseItemId the primary key of the expense item
	 * @return the expense item that was removed
	 * @throws PortalException if a expense item with the primary key could not be found
	 */
	public static ExpenseItem deleteExpenseItem(long expenseItemId)
		throws PortalException {

		return getService().deleteExpenseItem(expenseItemId);
	}

	public static void deleteExpenseItemById(long expenseItemId) {
		getService().deleteExpenseItemById(expenseItemId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.me.expense.manager.model.impl.ExpenseItemModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.me.expense.manager.model.impl.ExpenseItemModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ExpenseItem fetchExpenseItem(long expenseItemId) {
		return getService().fetchExpenseItem(expenseItemId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the expense item with the primary key.
	 *
	 * @param expenseItemId the primary key of the expense item
	 * @return the expense item
	 * @throws PortalException if a expense item with the primary key could not be found
	 */
	public static ExpenseItem getExpenseItem(long expenseItemId)
		throws PortalException {

		return getService().getExpenseItem(expenseItemId);
	}

	/**
	 * Returns a range of all the expense items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.me.expense.manager.model.impl.ExpenseItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of expense items
	 * @param end the upper bound of the range of expense items (not inclusive)
	 * @return the range of expense items
	 */
	public static List<ExpenseItem> getExpenseItems(int start, int end) {
		return getService().getExpenseItems(start, end);
	}

	public static List<ExpenseItem> getExpenseItemsByExpenseId(long expenseId) {
		return getService().getExpenseItemsByExpenseId(expenseId);
	}

	/**
	 * Returns the number of expense items.
	 *
	 * @return the number of expense items
	 */
	public static int getExpenseItemsCount() {
		return getService().getExpenseItemsCount();
	}

	public static long getExpenseItemsTotalByExpenseId(long expenseId) {
		return getService().getExpenseItemsTotalByExpenseId(expenseId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static void removeByExpenseId(long expenseId) {
		getService().removeByExpenseId(expenseId);
	}

	/**
	 * Updates the expense item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExpenseItemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param expenseItem the expense item
	 * @return the expense item that was updated
	 */
	public static ExpenseItem updateExpenseItem(ExpenseItem expenseItem) {
		return getService().updateExpenseItem(expenseItem);
	}

	public static ExpenseItem updateExpenseItem(
			long expenseItemId, long amount, boolean reimburse, String title,
			String description, java.util.Date dateIncurred, long type,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateExpenseItem(
			expenseItemId, amount, reimburse, title, description, dateIncurred,
			type, serviceContext);
	}

	public static ExpenseItemLocalService getService() {
		return _service;
	}

	private static volatile ExpenseItemLocalService _service;

}