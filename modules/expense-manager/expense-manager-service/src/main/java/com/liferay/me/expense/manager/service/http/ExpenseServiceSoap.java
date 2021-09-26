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

package com.liferay.me.expense.manager.service.http;

import com.liferay.me.expense.manager.service.ExpenseServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>ExpenseServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.me.expense.manager.model.ExpenseSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.me.expense.manager.model.Expense</code>, that is translated to a
 * <code>com.liferay.me.expense.manager.model.ExpenseSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ExpenseServiceSoap {

	public static com.liferay.me.expense.manager.model.ExpenseSoap addExpense(
			long groupId, String title, String description,
			java.util.Date dueDate, String currency,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.me.expense.manager.model.Expense returnValue =
				ExpenseServiceUtil.addExpense(
					groupId, title, description, dueDate, currency,
					serviceContext);

			return com.liferay.me.expense.manager.model.ExpenseSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.me.expense.manager.model.ExpenseSoap
			updateExpense(
				long expenseId, String title, String description,
				java.util.Date dueDate, String currency,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.me.expense.manager.model.Expense returnValue =
				ExpenseServiceUtil.updateExpense(
					expenseId, title, description, dueDate, currency,
					serviceContext);

			return com.liferay.me.expense.manager.model.ExpenseSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.me.expense.manager.model.ExpenseSoap[]
			getExpenseByGroupId(
				long groupId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			java.util.List<com.liferay.me.expense.manager.model.Expense>
				returnValue = ExpenseServiceUtil.getExpenseByGroupId(
					groupId, serviceContext);

			return com.liferay.me.expense.manager.model.ExpenseSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.me.expense.manager.model.ExpenseSoap[]
			getExpenseByGroupId(
				long groupId, int start, int end,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			java.util.List<com.liferay.me.expense.manager.model.Expense>
				returnValue = ExpenseServiceUtil.getExpenseByGroupId(
					groupId, start, end, serviceContext);

			return com.liferay.me.expense.manager.model.ExpenseSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.me.expense.manager.model.ExpenseSoap[]
			getExpenseByUserName(String userName)
		throws RemoteException {

		try {
			java.util.List<com.liferay.me.expense.manager.model.Expense>
				returnValue = ExpenseServiceUtil.getExpenseByUserName(userName);

			return com.liferay.me.expense.manager.model.ExpenseSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.me.expense.manager.model.ExpenseSoap[]
			getExpenseByUserName(String userName, int start, int end)
		throws RemoteException {

		try {
			java.util.List<com.liferay.me.expense.manager.model.Expense>
				returnValue = ExpenseServiceUtil.getExpenseByUserName(
					userName, start, end);

			return com.liferay.me.expense.manager.model.ExpenseSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.me.expense.manager.model.ExpenseSoap
			getExpenseById(long expenseId)
		throws RemoteException {

		try {
			com.liferay.me.expense.manager.model.Expense returnValue =
				ExpenseServiceUtil.getExpenseById(expenseId);

			return com.liferay.me.expense.manager.model.ExpenseSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int getExpensesCount(long groupId) throws RemoteException {
		try {
			int returnValue = ExpenseServiceUtil.getExpensesCount(groupId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int getExpensesCountByUserId(long userId)
		throws RemoteException {

		try {
			int returnValue = ExpenseServiceUtil.getExpensesCountByUserId(
				userId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.me.expense.manager.model.ExpenseSoap[]
			getExpenseByUserId(long userId, int start, int end)
		throws RemoteException {

		try {
			java.util.List<com.liferay.me.expense.manager.model.Expense>
				returnValue = ExpenseServiceUtil.getExpenseByUserId(
					userId, start, end);

			return com.liferay.me.expense.manager.model.ExpenseSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.me.expense.manager.model.ExpenseSoap[]
			getExpenseByUserId(long userId)
		throws RemoteException {

		try {
			java.util.List<com.liferay.me.expense.manager.model.Expense>
				returnValue = ExpenseServiceUtil.getExpenseByUserId(userId);

			return com.liferay.me.expense.manager.model.ExpenseSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void deleteAll(long groupId) throws RemoteException {
		try {
			ExpenseServiceUtil.deleteAll(groupId);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void deleteExpenseById(
			long expenseId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			ExpenseServiceUtil.deleteExpenseById(expenseId, serviceContext);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ExpenseServiceSoap.class);

}