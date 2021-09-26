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
 * Provides a wrapper for {@link ExpenseItemService}.
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseItemService
 * @generated
 */
public class ExpenseItemServiceWrapper
	implements ExpenseItemService, ServiceWrapper<ExpenseItemService> {

	public ExpenseItemServiceWrapper(ExpenseItemService expenseItemService) {
		_expenseItemService = expenseItemService;
	}

	@Override
	public com.liferay.me.expense.manager.model.ExpenseItem addExpenseItem(
			long groupId, long expenseId, long amount, boolean reimburse,
			String title, String description, java.util.Date dateIncurred,
			long type,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expenseItemService.addExpenseItem(
			groupId, expenseId, amount, reimburse, title, description,
			dateIncurred, type, serviceContext);
	}

	@Override
	public void deleteExpenseItemById(long expenseItemId) {
		_expenseItemService.deleteExpenseItemById(expenseItemId);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.ExpenseItem>
		getExpenseItemsByExpenseId(long expenseId) {

		return _expenseItemService.getExpenseItemsByExpenseId(expenseId);
	}

	@Override
	public long getExpenseItemsTotalByExpenseId(long expenseId) {
		return _expenseItemService.getExpenseItemsTotalByExpenseId(expenseId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _expenseItemService.getOSGiServiceIdentifier();
	}

	@Override
	public void removeByExpenseId(long expenseId) {
		_expenseItemService.removeByExpenseId(expenseId);
	}

	@Override
	public com.liferay.me.expense.manager.model.ExpenseItem updateExpenseItem(
			long expenseItemId, long amount, boolean reimburse, String title,
			String description, java.util.Date dateIncurred, long type,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expenseItemService.updateExpenseItem(
			expenseItemId, amount, reimburse, title, description, dateIncurred,
			type, serviceContext);
	}

	@Override
	public ExpenseItemService getWrappedService() {
		return _expenseItemService;
	}

	@Override
	public void setWrappedService(ExpenseItemService expenseItemService) {
		_expenseItemService = expenseItemService;
	}

	private ExpenseItemService _expenseItemService;

}