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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>ExpenseItemServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseItemServiceSoap
 * @generated
 */
public class ExpenseItemServiceHttp {

	public static com.liferay.me.expense.manager.model.ExpenseItem
			addExpenseItem(
				HttpPrincipal httpPrincipal, long groupId, long expenseId,
				long amount, boolean reimburse, String title,
				String description, java.util.Date dateIncurred, long type,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ExpenseItemServiceUtil.class, "addExpenseItem",
				_addExpenseItemParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, expenseId, amount, reimburse, title,
				description, dateIncurred, type, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.me.expense.manager.model.ExpenseItem)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.liferay.me.expense.manager.model.ExpenseItem>
			getExpenseItemsByExpenseId(
				HttpPrincipal httpPrincipal, long expenseId) {

		try {
			MethodKey methodKey = new MethodKey(
				ExpenseItemServiceUtil.class, "getExpenseItemsByExpenseId",
				_getExpenseItemsByExpenseIdParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, expenseId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.me.expense.manager.model.ExpenseItem>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static long getExpenseItemsTotalByExpenseId(
		HttpPrincipal httpPrincipal, long expenseId) {

		try {
			MethodKey methodKey = new MethodKey(
				ExpenseItemServiceUtil.class, "getExpenseItemsTotalByExpenseId",
				_getExpenseItemsTotalByExpenseIdParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, expenseId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Long)returnObj).longValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void deleteExpenseItemById(
		HttpPrincipal httpPrincipal, long expenseItemId) {

		try {
			MethodKey methodKey = new MethodKey(
				ExpenseItemServiceUtil.class, "deleteExpenseItemById",
				_deleteExpenseItemByIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, expenseItemId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.me.expense.manager.model.ExpenseItem
			updateExpenseItem(
				HttpPrincipal httpPrincipal, long expenseItemId, long amount,
				boolean reimburse, String title, String description,
				java.util.Date dateIncurred, long type,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ExpenseItemServiceUtil.class, "updateExpenseItem",
				_updateExpenseItemParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, expenseItemId, amount, reimburse, title, description,
				dateIncurred, type, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.me.expense.manager.model.ExpenseItem)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void removeByExpenseId(
		HttpPrincipal httpPrincipal, long expenseId) {

		try {
			MethodKey methodKey = new MethodKey(
				ExpenseItemServiceUtil.class, "removeByExpenseId",
				_removeByExpenseIdParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, expenseId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		ExpenseItemServiceHttp.class);

	private static final Class<?>[] _addExpenseItemParameterTypes0 =
		new Class[] {
			long.class, long.class, long.class, boolean.class, String.class,
			String.class, java.util.Date.class, long.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getExpenseItemsByExpenseIdParameterTypes1 =
		new Class[] {long.class};
	private static final Class<?>[]
		_getExpenseItemsTotalByExpenseIdParameterTypes2 = new Class[] {
			long.class
		};
	private static final Class<?>[] _deleteExpenseItemByIdParameterTypes3 =
		new Class[] {long.class};
	private static final Class<?>[] _updateExpenseItemParameterTypes4 =
		new Class[] {
			long.class, long.class, boolean.class, String.class, String.class,
			java.util.Date.class, long.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _removeByExpenseIdParameterTypes5 =
		new Class[] {long.class};

}