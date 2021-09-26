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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>ExpenseServiceUtil</code> service
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
 * @see ExpenseServiceSoap
 * @generated
 */
public class ExpenseServiceHttp {

	public static com.liferay.me.expense.manager.model.Expense addExpense(
			HttpPrincipal httpPrincipal, long groupId, String title,
			String description, java.util.Date dueDate, String currency,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ExpenseServiceUtil.class, "addExpense",
				_addExpenseParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, title, description, dueDate, currency,
				serviceContext);

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

			return (com.liferay.me.expense.manager.model.Expense)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.me.expense.manager.model.Expense updateExpense(
			HttpPrincipal httpPrincipal, long expenseId, String title,
			String description, java.util.Date dueDate, String currency,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ExpenseServiceUtil.class, "updateExpense",
				_updateExpenseParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, expenseId, title, description, dueDate, currency,
				serviceContext);

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

			return (com.liferay.me.expense.manager.model.Expense)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.me.expense.manager.model.Expense>
			getExpenseByGroupId(
				HttpPrincipal httpPrincipal, long groupId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		try {
			MethodKey methodKey = new MethodKey(
				ExpenseServiceUtil.class, "getExpenseByGroupId",
				_getExpenseByGroupIdParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.security.auth.
							PrincipalException) {

					throw (com.liferay.portal.kernel.security.auth.
						PrincipalException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.me.expense.manager.model.Expense>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.me.expense.manager.model.Expense>
		getExpenseByGroupId(
			HttpPrincipal httpPrincipal, long groupId, int start, int end,
			com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				ExpenseServiceUtil.class, "getExpenseByGroupId",
				_getExpenseByGroupIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, start, end, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.me.expense.manager.model.Expense>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.me.expense.manager.model.Expense>
		getExpenseByUserName(HttpPrincipal httpPrincipal, String userName) {

		try {
			MethodKey methodKey = new MethodKey(
				ExpenseServiceUtil.class, "getExpenseByUserName",
				_getExpenseByUserNameParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userName);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.me.expense.manager.model.Expense>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.me.expense.manager.model.Expense>
		getExpenseByUserName(
			HttpPrincipal httpPrincipal, String userName, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				ExpenseServiceUtil.class, "getExpenseByUserName",
				_getExpenseByUserNameParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userName, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.me.expense.manager.model.Expense>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.me.expense.manager.model.Expense getExpenseById(
			HttpPrincipal httpPrincipal, long expenseId)
		throws com.liferay.me.expense.manager.exception.NoSuchExpenseException {

		try {
			MethodKey methodKey = new MethodKey(
				ExpenseServiceUtil.class, "getExpenseById",
				_getExpenseByIdParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, expenseId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.me.expense.manager.exception.
							NoSuchExpenseException) {

					throw (com.liferay.me.expense.manager.exception.
						NoSuchExpenseException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.me.expense.manager.model.Expense)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getExpensesCount(
		HttpPrincipal httpPrincipal, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				ExpenseServiceUtil.class, "getExpensesCount",
				_getExpensesCountParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getExpensesCountByUserId(
		HttpPrincipal httpPrincipal, long userId) {

		try {
			MethodKey methodKey = new MethodKey(
				ExpenseServiceUtil.class, "getExpensesCountByUserId",
				_getExpensesCountByUserIdParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.me.expense.manager.model.Expense>
		getExpenseByUserId(
			HttpPrincipal httpPrincipal, long userId, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				ExpenseServiceUtil.class, "getExpenseByUserId",
				_getExpenseByUserIdParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.me.expense.manager.model.Expense>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.liferay.me.expense.manager.model.Expense>
		getExpenseByUserId(HttpPrincipal httpPrincipal, long userId) {

		try {
			MethodKey methodKey = new MethodKey(
				ExpenseServiceUtil.class, "getExpenseByUserId",
				_getExpenseByUserIdParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.me.expense.manager.model.Expense>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void deleteAll(HttpPrincipal httpPrincipal, long groupId) {
		try {
			MethodKey methodKey = new MethodKey(
				ExpenseServiceUtil.class, "deleteAll",
				_deleteAllParameterTypes11);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId);

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

	public static void deleteExpenseById(
			HttpPrincipal httpPrincipal, long expenseId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ExpenseServiceUtil.class, "deleteExpenseById",
				_deleteExpenseByIdParameterTypes12);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, expenseId, serviceContext);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
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
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ExpenseServiceHttp.class);

	private static final Class<?>[] _addExpenseParameterTypes0 = new Class[] {
		long.class, String.class, String.class, java.util.Date.class,
		String.class, com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _updateExpenseParameterTypes1 =
		new Class[] {
			long.class, String.class, String.class, java.util.Date.class,
			String.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getExpenseByGroupIdParameterTypes2 =
		new Class[] {
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getExpenseByGroupIdParameterTypes3 =
		new Class[] {
			long.class, int.class, int.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getExpenseByUserNameParameterTypes4 =
		new Class[] {String.class};
	private static final Class<?>[] _getExpenseByUserNameParameterTypes5 =
		new Class[] {String.class, int.class, int.class};
	private static final Class<?>[] _getExpenseByIdParameterTypes6 =
		new Class[] {long.class};
	private static final Class<?>[] _getExpensesCountParameterTypes7 =
		new Class[] {long.class};
	private static final Class<?>[] _getExpensesCountByUserIdParameterTypes8 =
		new Class[] {long.class};
	private static final Class<?>[] _getExpenseByUserIdParameterTypes9 =
		new Class[] {long.class, int.class, int.class};
	private static final Class<?>[] _getExpenseByUserIdParameterTypes10 =
		new Class[] {long.class};
	private static final Class<?>[] _deleteAllParameterTypes11 = new Class[] {
		long.class
	};
	private static final Class<?>[] _deleteExpenseByIdParameterTypes12 =
		new Class[] {
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};

}