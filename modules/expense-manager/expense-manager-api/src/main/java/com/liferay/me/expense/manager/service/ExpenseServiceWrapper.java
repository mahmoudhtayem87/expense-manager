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
 * Provides a wrapper for {@link ExpenseService}.
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseService
 * @generated
 */
public class ExpenseServiceWrapper
	implements ExpenseService, ServiceWrapper<ExpenseService> {

	public ExpenseServiceWrapper(ExpenseService expenseService) {
		_expenseService = expenseService;
	}

	@Override
	public com.liferay.me.expense.manager.model.Expense addExpense(
			long groupId, String title, String description,
			java.util.Date dueDate, String currency,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expenseService.addExpense(
			groupId, title, description, dueDate, currency, serviceContext);
	}

	@Override
	public void deleteAll(long groupId) {
		_expenseService.deleteAll(groupId);
	}

	@Override
	public void deleteExpenseById(
			long expenseId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		_expenseService.deleteExpenseById(expenseId, serviceContext);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Expense>
		getExpenseByGroupId(
			long groupId, int start, int end,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _expenseService.getExpenseByGroupId(
			groupId, start, end, serviceContext);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Expense>
			getExpenseByGroupId(
				long groupId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _expenseService.getExpenseByGroupId(groupId, serviceContext);
	}

	@Override
	public com.liferay.me.expense.manager.model.Expense getExpenseById(
			long expenseId)
		throws com.liferay.me.expense.manager.exception.NoSuchExpenseException {

		return _expenseService.getExpenseById(expenseId);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Expense>
		getExpenseByUserId(long userId) {

		return _expenseService.getExpenseByUserId(userId);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Expense>
		getExpenseByUserId(long userId, int start, int end) {

		return _expenseService.getExpenseByUserId(userId, start, end);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Expense>
		getExpenseByUserName(String userName) {

		return _expenseService.getExpenseByUserName(userName);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Expense>
		getExpenseByUserName(String userName, int start, int end) {

		return _expenseService.getExpenseByUserName(userName, start, end);
	}

	@Override
	public int getExpensesCount(long groupId) {
		return _expenseService.getExpensesCount(groupId);
	}

	@Override
	public int getExpensesCountByUserId(long userId) {
		return _expenseService.getExpensesCountByUserId(userId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _expenseService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.me.expense.manager.model.Expense updateExpense(
			long expenseId, String title, String description,
			java.util.Date dueDate, String currency,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expenseService.updateExpense(
			expenseId, title, description, dueDate, currency, serviceContext);
	}

	@Override
	public ExpenseService getWrappedService() {
		return _expenseService;
	}

	@Override
	public void setWrappedService(ExpenseService expenseService) {
		_expenseService = expenseService;
	}

	private ExpenseService _expenseService;

}