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
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * Provides the remote service utility for ExpenseItem. This utility wraps
 * <code>com.liferay.me.expense.manager.service.impl.ExpenseItemServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseItemService
 * @generated
 */
public class ExpenseItemServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.me.expense.manager.service.impl.ExpenseItemServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
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

	public static void deleteExpenseItemById(long expenseItemId) {
		getService().deleteExpenseItemById(expenseItemId);
	}

	public static List<ExpenseItem> getExpenseItemsByExpenseId(long expenseId) {
		return getService().getExpenseItemsByExpenseId(expenseId);
	}

	public static long getExpenseItemsTotalByExpenseId(long expenseId) {
		return getService().getExpenseItemsTotalByExpenseId(expenseId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void removeByExpenseId(long expenseId) {
		getService().removeByExpenseId(expenseId);
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

	public static ExpenseItemService getService() {
		return _service;
	}

	private static volatile ExpenseItemService _service;

}