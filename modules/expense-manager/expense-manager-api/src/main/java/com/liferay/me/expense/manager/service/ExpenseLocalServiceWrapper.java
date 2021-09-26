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
 * Provides a wrapper for {@link ExpenseLocalService}.
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseLocalService
 * @generated
 */
public class ExpenseLocalServiceWrapper
	implements ExpenseLocalService, ServiceWrapper<ExpenseLocalService> {

	public ExpenseLocalServiceWrapper(ExpenseLocalService expenseLocalService) {
		_expenseLocalService = expenseLocalService;
	}

	/**
	 * Adds the expense to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExpenseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param expense the expense
	 * @return the expense that was added
	 */
	@Override
	public com.liferay.me.expense.manager.model.Expense addExpense(
		com.liferay.me.expense.manager.model.Expense expense) {

		return _expenseLocalService.addExpense(expense);
	}

	@Override
	public com.liferay.me.expense.manager.model.Expense addExpense(
			long groupId, String title, String description,
			java.util.Date dueDate, String currency,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expenseLocalService.addExpense(
			groupId, title, description, dueDate, currency, serviceContext);
	}

	/**
	 * Creates a new expense with the primary key. Does not add the expense to the database.
	 *
	 * @param expenseId the primary key for the new expense
	 * @return the new expense
	 */
	@Override
	public com.liferay.me.expense.manager.model.Expense createExpense(
		long expenseId) {

		return _expenseLocalService.createExpense(expenseId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expenseLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public void deleteAll(long groupId) {
		_expenseLocalService.deleteAll(groupId);
	}

	/**
	 * Deletes the expense from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExpenseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param expense the expense
	 * @return the expense that was removed
	 */
	@Override
	public com.liferay.me.expense.manager.model.Expense deleteExpense(
		com.liferay.me.expense.manager.model.Expense expense) {

		return _expenseLocalService.deleteExpense(expense);
	}

	/**
	 * Deletes the expense with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExpenseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param expenseId the primary key of the expense
	 * @return the expense that was removed
	 * @throws PortalException if a expense with the primary key could not be found
	 */
	@Override
	public com.liferay.me.expense.manager.model.Expense deleteExpense(
			long expenseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expenseLocalService.deleteExpense(expenseId);
	}

	@Override
	public void deleteExpenseById(
			long expenseId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		_expenseLocalService.deleteExpenseById(expenseId, serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expenseLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _expenseLocalService.dynamicQuery();
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

		return _expenseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.me.expense.manager.model.impl.ExpenseModelImpl</code>.
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

		return _expenseLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.me.expense.manager.model.impl.ExpenseModelImpl</code>.
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

		return _expenseLocalService.dynamicQuery(
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

		return _expenseLocalService.dynamicQueryCount(dynamicQuery);
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

		return _expenseLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.me.expense.manager.model.Expense fetchExpense(
		long expenseId) {

		return _expenseLocalService.fetchExpense(expenseId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _expenseLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the expense with the primary key.
	 *
	 * @param expenseId the primary key of the expense
	 * @return the expense
	 * @throws PortalException if a expense with the primary key could not be found
	 */
	@Override
	public com.liferay.me.expense.manager.model.Expense getExpense(
			long expenseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expenseLocalService.getExpense(expenseId);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Expense>
		getExpenseByGroupId(
			long groupId, int start, int end,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _expenseLocalService.getExpenseByGroupId(
			groupId, start, end, serviceContext);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Expense>
		getExpenseByGroupId(
			long groupId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _expenseLocalService.getExpenseByGroupId(
			groupId, serviceContext);
	}

	@Override
	public com.liferay.me.expense.manager.model.Expense getExpenseById(
			long expenseId)
		throws com.liferay.me.expense.manager.exception.NoSuchExpenseException {

		return _expenseLocalService.getExpenseById(expenseId);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Expense>
		getExpenseByUserID(long userId) {

		return _expenseLocalService.getExpenseByUserID(userId);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Expense>
		getExpenseByUserID(long userId, int start, int end) {

		return _expenseLocalService.getExpenseByUserID(userId, start, end);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Expense>
			getExpenseByUserName(
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expenseLocalService.getExpenseByUserName(serviceContext);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Expense>
		getExpenseByUserName(String userName) {

		return _expenseLocalService.getExpenseByUserName(userName);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Expense>
		getExpenseByUserName(String userName, int start, int end) {

		return _expenseLocalService.getExpenseByUserName(userName, start, end);
	}

	/**
	 * Returns a range of all the expenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.me.expense.manager.model.impl.ExpenseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of expenses
	 * @param end the upper bound of the range of expenses (not inclusive)
	 * @return the range of expenses
	 */
	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Expense>
		getExpenses(int start, int end) {

		return _expenseLocalService.getExpenses(start, end);
	}

	/**
	 * Returns the number of expenses.
	 *
	 * @return the number of expenses
	 */
	@Override
	public int getExpensesCount() {
		return _expenseLocalService.getExpensesCount();
	}

	@Override
	public int getExpensesCount(long groupId) {
		return _expenseLocalService.getExpensesCount(groupId);
	}

	@Override
	public int getExpensesCountByUserId(long userId) {
		return _expenseLocalService.getExpensesCountByUserId(userId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _expenseLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _expenseLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expenseLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the expense in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExpenseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param expense the expense
	 * @return the expense that was updated
	 */
	@Override
	public com.liferay.me.expense.manager.model.Expense updateExpense(
		com.liferay.me.expense.manager.model.Expense expense) {

		return _expenseLocalService.updateExpense(expense);
	}

	@Override
	public com.liferay.me.expense.manager.model.Expense updateExpense(
			long expenseId, String title, String description,
			java.util.Date dueDate, String currency,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expenseLocalService.updateExpense(
			expenseId, title, description, dueDate, currency, serviceContext);
	}

	@Override
	public ExpenseLocalService getWrappedService() {
		return _expenseLocalService;
	}

	@Override
	public void setWrappedService(ExpenseLocalService expenseLocalService) {
		_expenseLocalService = expenseLocalService;
	}

	private ExpenseLocalService _expenseLocalService;

}