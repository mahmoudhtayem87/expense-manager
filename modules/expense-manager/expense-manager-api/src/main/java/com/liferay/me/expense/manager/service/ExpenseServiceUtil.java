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

import com.liferay.me.expense.manager.model.Expense;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * Provides the remote service utility for Expense. This utility wraps
 * <code>com.liferay.me.expense.manager.service.impl.ExpenseServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseService
 * @generated
 */
public class ExpenseServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.me.expense.manager.service.impl.ExpenseServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Expense addExpense(
			long groupId, String title, String description,
			java.util.Date dueDate, String currency,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addExpense(
			groupId, title, description, dueDate, currency, serviceContext);
	}

	public static void deleteAll(long groupId) {
		getService().deleteAll(groupId);
	}

	public static void deleteExpenseById(
			long expenseId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		getService().deleteExpenseById(expenseId, serviceContext);
	}

	public static List<Expense> getExpenseByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return getService().getExpenseByGroupId(
			groupId, start, end, serviceContext);
	}

	public static List<Expense> getExpenseByGroupId(
			long groupId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return getService().getExpenseByGroupId(groupId, serviceContext);
	}

	public static Expense getExpenseById(long expenseId)
		throws com.liferay.me.expense.manager.exception.NoSuchExpenseException {

		return getService().getExpenseById(expenseId);
	}

	public static List<Expense> getExpenseByUserId(long userId) {
		return getService().getExpenseByUserId(userId);
	}

	public static List<Expense> getExpenseByUserId(
		long userId, int start, int end) {

		return getService().getExpenseByUserId(userId, start, end);
	}

	public static List<Expense> getExpenseByUserName(String userName) {
		return getService().getExpenseByUserName(userName);
	}

	public static List<Expense> getExpenseByUserName(
		String userName, int start, int end) {

		return getService().getExpenseByUserName(userName, start, end);
	}

	public static int getExpensesCount(long groupId) {
		return getService().getExpensesCount(groupId);
	}

	public static int getExpensesCountByUserId(long userId) {
		return getService().getExpensesCountByUserId(userId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Expense updateExpense(
			long expenseId, String title, String description,
			java.util.Date dueDate, String currency,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateExpense(
			expenseId, title, description, dueDate, currency, serviceContext);
	}

	public static ExpenseService getService() {
		return _service;
	}

	private static volatile ExpenseService _service;

}