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
 * Provides a wrapper for {@link ExpenseItemTypeService}.
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseItemTypeService
 * @generated
 */
public class ExpenseItemTypeServiceWrapper
	implements ExpenseItemTypeService, ServiceWrapper<ExpenseItemTypeService> {

	public ExpenseItemTypeServiceWrapper(
		ExpenseItemTypeService expenseItemTypeService) {

		_expenseItemTypeService = expenseItemTypeService;
	}

	@Override
	public com.liferay.me.expense.manager.model.ExpenseItemType addExpenseItem(
			long groupId, String title, String value,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expenseItemTypeService.addExpenseItem(
			groupId, title, value, serviceContext);
	}

	@Override
	public void deleteExpenseItemType(
			long expenseTypeId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		_expenseItemTypeService.deleteExpenseItemType(
			expenseTypeId, serviceContext);
	}

	@Override
	public com.liferay.me.expense.manager.model.ExpenseItemType
			getByExpenseTypeId(long expenseTypeId)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemTypeException {

		return _expenseItemTypeService.getByExpenseTypeId(expenseTypeId);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.ExpenseItemType>
		getExpenseItemTypes(long groupId) {

		return _expenseItemTypeService.getExpenseItemTypes(groupId);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.ExpenseItemType>
		getExpenseItemTypes(long groupId, int start, int end) {

		return _expenseItemTypeService.getExpenseItemTypes(groupId, start, end);
	}

	@Override
	public int getExpenseItemTypesCount(long groupId) {
		return _expenseItemTypeService.getExpenseItemTypesCount(groupId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _expenseItemTypeService.getOSGiServiceIdentifier();
	}

	@Override
	public void updateExpenseItemType(
			long expenseTypeId, String title, String value,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		_expenseItemTypeService.updateExpenseItemType(
			expenseTypeId, title, value, serviceContext);
	}

	@Override
	public ExpenseItemTypeService getWrappedService() {
		return _expenseItemTypeService;
	}

	@Override
	public void setWrappedService(
		ExpenseItemTypeService expenseItemTypeService) {

		_expenseItemTypeService = expenseItemTypeService;
	}

	private ExpenseItemTypeService _expenseItemTypeService;

}