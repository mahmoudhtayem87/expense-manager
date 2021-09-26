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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ExpenseItemLocalService}.
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseItemLocalService
 * @generated
 */
public class ExpenseItemLocalServiceWrapper
	implements ExpenseItemLocalService,
			   ServiceWrapper<ExpenseItemLocalService> {

	public ExpenseItemLocalServiceWrapper(
		ExpenseItemLocalService expenseItemLocalService) {

		_expenseItemLocalService = expenseItemLocalService;
	}

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
	@Override
	public com.liferay.me.expense.manager.model.ExpenseItem addExpenseItem(
		com.liferay.me.expense.manager.model.ExpenseItem expenseItem) {

		return _expenseItemLocalService.addExpenseItem(expenseItem);
	}

	@Override
	public com.liferay.me.expense.manager.model.ExpenseItem addExpenseItem(
			long groupId, long expenseId, long amount, boolean reimburse,
			String title, String description, java.util.Date dateIncurred,
			long type,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expenseItemLocalService.addExpenseItem(
			groupId, expenseId, amount, reimburse, title, description,
			dateIncurred, type, serviceContext);
	}

	/**
	 * Creates a new expense item with the primary key. Does not add the expense item to the database.
	 *
	 * @param expenseItemId the primary key for the new expense item
	 * @return the new expense item
	 */
	@Override
	public com.liferay.me.expense.manager.model.ExpenseItem createExpenseItem(
		long expenseItemId) {

		return _expenseItemLocalService.createExpenseItem(expenseItemId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expenseItemLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.liferay.me.expense.manager.model.ExpenseItem deleteExpenseItem(
		com.liferay.me.expense.manager.model.ExpenseItem expenseItem) {

		return _expenseItemLocalService.deleteExpenseItem(expenseItem);
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
	@Override
	public com.liferay.me.expense.manager.model.ExpenseItem deleteExpenseItem(
			long expenseItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expenseItemLocalService.deleteExpenseItem(expenseItemId);
	}

	@Override
	public void deleteExpenseItemById(long expenseItemId) {
		_expenseItemLocalService.deleteExpenseItemById(expenseItemId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expenseItemLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _expenseItemLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _expenseItemLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _expenseItemLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _expenseItemLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _expenseItemLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _expenseItemLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.me.expense.manager.model.ExpenseItem fetchExpenseItem(
		long expenseItemId) {

		return _expenseItemLocalService.fetchExpenseItem(expenseItemId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _expenseItemLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the expense item with the primary key.
	 *
	 * @param expenseItemId the primary key of the expense item
	 * @return the expense item
	 * @throws PortalException if a expense item with the primary key could not be found
	 */
	@Override
	public com.liferay.me.expense.manager.model.ExpenseItem getExpenseItem(
			long expenseItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expenseItemLocalService.getExpenseItem(expenseItemId);
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
	@Override
	public java.util.List<com.liferay.me.expense.manager.model.ExpenseItem>
		getExpenseItems(int start, int end) {

		return _expenseItemLocalService.getExpenseItems(start, end);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.ExpenseItem>
		getExpenseItemsByExpenseId(long expenseId) {

		return _expenseItemLocalService.getExpenseItemsByExpenseId(expenseId);
	}

	/**
	 * Returns the number of expense items.
	 *
	 * @return the number of expense items
	 */
	@Override
	public int getExpenseItemsCount() {
		return _expenseItemLocalService.getExpenseItemsCount();
	}

	@Override
	public long getExpenseItemsTotalByExpenseId(long expenseId) {
		return _expenseItemLocalService.getExpenseItemsTotalByExpenseId(
			expenseId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _expenseItemLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _expenseItemLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expenseItemLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public void removeByExpenseId(long expenseId) {
		_expenseItemLocalService.removeByExpenseId(expenseId);
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
	@Override
	public com.liferay.me.expense.manager.model.ExpenseItem updateExpenseItem(
		com.liferay.me.expense.manager.model.ExpenseItem expenseItem) {

		return _expenseItemLocalService.updateExpenseItem(expenseItem);
	}

	@Override
	public com.liferay.me.expense.manager.model.ExpenseItem updateExpenseItem(
			long expenseItemId, long amount, boolean reimburse, String title,
			String description, java.util.Date dateIncurred, long type,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expenseItemLocalService.updateExpenseItem(
			expenseItemId, amount, reimburse, title, description, dateIncurred,
			type, serviceContext);
	}

	@Override
	public ExpenseItemLocalService getWrappedService() {
		return _expenseItemLocalService;
	}

	@Override
	public void setWrappedService(
		ExpenseItemLocalService expenseItemLocalService) {

		_expenseItemLocalService = expenseItemLocalService;
	}

	private ExpenseItemLocalService _expenseItemLocalService;

}