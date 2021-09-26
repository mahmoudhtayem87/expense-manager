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

import com.liferay.me.expense.manager.service.ExpenseItemServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>ExpenseItemServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.me.expense.manager.model.ExpenseItemSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.me.expense.manager.model.ExpenseItem</code>, that is translated to a
 * <code>com.liferay.me.expense.manager.model.ExpenseItemSoap</code>. Methods that SOAP
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
 * @see ExpenseItemServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ExpenseItemServiceSoap {

	public static com.liferay.me.expense.manager.model.ExpenseItemSoap
			addExpenseItem(
				long groupId, long expenseId, long amount, boolean reimburse,
				String title, String description, java.util.Date dateIncurred,
				long type,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.me.expense.manager.model.ExpenseItem returnValue =
				ExpenseItemServiceUtil.addExpenseItem(
					groupId, expenseId, amount, reimburse, title, description,
					dateIncurred, type, serviceContext);

			return com.liferay.me.expense.manager.model.ExpenseItemSoap.
				toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.me.expense.manager.model.ExpenseItemSoap[]
			getExpenseItemsByExpenseId(long expenseId)
		throws RemoteException {

		try {
			java.util.List<com.liferay.me.expense.manager.model.ExpenseItem>
				returnValue = ExpenseItemServiceUtil.getExpenseItemsByExpenseId(
					expenseId);

			return com.liferay.me.expense.manager.model.ExpenseItemSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static long getExpenseItemsTotalByExpenseId(long expenseId)
		throws RemoteException {

		try {
			long returnValue =
				ExpenseItemServiceUtil.getExpenseItemsTotalByExpenseId(
					expenseId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void deleteExpenseItemById(long expenseItemId)
		throws RemoteException {

		try {
			ExpenseItemServiceUtil.deleteExpenseItemById(expenseItemId);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.me.expense.manager.model.ExpenseItemSoap
			updateExpenseItem(
				long expenseItemId, long amount, boolean reimburse,
				String title, String description, java.util.Date dateIncurred,
				long type,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.me.expense.manager.model.ExpenseItem returnValue =
				ExpenseItemServiceUtil.updateExpenseItem(
					expenseItemId, amount, reimburse, title, description,
					dateIncurred, type, serviceContext);

			return com.liferay.me.expense.manager.model.ExpenseItemSoap.
				toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void removeByExpenseId(long expenseId)
		throws RemoteException {

		try {
			ExpenseItemServiceUtil.removeByExpenseId(expenseId);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		ExpenseItemServiceSoap.class);

}