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

import com.liferay.me.expense.manager.service.ExpenseItemTypeServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>ExpenseItemTypeServiceUtil</code> service
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
 * @see ExpenseItemTypeServiceSoap
 * @generated
 */
public class ExpenseItemTypeServiceHttp {

	public static java.util.List
		<com.liferay.me.expense.manager.model.ExpenseItemType>
			getExpenseItemTypes(HttpPrincipal httpPrincipal, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				ExpenseItemTypeServiceUtil.class, "getExpenseItemTypes",
				_getExpenseItemTypesParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.me.expense.manager.model.ExpenseItemType>)
					returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.liferay.me.expense.manager.model.ExpenseItemType>
			getExpenseItemTypes(
				HttpPrincipal httpPrincipal, long groupId, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				ExpenseItemTypeServiceUtil.class, "getExpenseItemTypes",
				_getExpenseItemTypesParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.me.expense.manager.model.ExpenseItemType>)
					returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getExpenseItemTypesCount(
		HttpPrincipal httpPrincipal, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				ExpenseItemTypeServiceUtil.class, "getExpenseItemTypesCount",
				_getExpenseItemTypesCountParameterTypes2);

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

	public static com.liferay.me.expense.manager.model.ExpenseItemType
			addExpenseItem(
				HttpPrincipal httpPrincipal, long groupId, String title,
				String value,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ExpenseItemTypeServiceUtil.class, "addExpenseItem",
				_addExpenseItemParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, title, value, serviceContext);

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

			return (com.liferay.me.expense.manager.model.ExpenseItemType)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.me.expense.manager.model.ExpenseItemType
			getByExpenseTypeId(HttpPrincipal httpPrincipal, long expenseTypeId)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemTypeException {

		try {
			MethodKey methodKey = new MethodKey(
				ExpenseItemTypeServiceUtil.class, "getByExpenseTypeId",
				_getByExpenseTypeIdParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, expenseTypeId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.me.expense.manager.exception.
							NoSuchExpenseItemTypeException) {

					throw (com.liferay.me.expense.manager.exception.
						NoSuchExpenseItemTypeException)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.me.expense.manager.model.ExpenseItemType)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void updateExpenseItemType(
			HttpPrincipal httpPrincipal, long expenseTypeId, String title,
			String value,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ExpenseItemTypeServiceUtil.class, "updateExpenseItemType",
				_updateExpenseItemTypeParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, expenseTypeId, title, value, serviceContext);

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

	public static void deleteExpenseItemType(
			HttpPrincipal httpPrincipal, long expenseTypeId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ExpenseItemTypeServiceUtil.class, "deleteExpenseItemType",
				_deleteExpenseItemTypeParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, expenseTypeId, serviceContext);

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

	private static Log _log = LogFactoryUtil.getLog(
		ExpenseItemTypeServiceHttp.class);

	private static final Class<?>[] _getExpenseItemTypesParameterTypes0 =
		new Class[] {long.class};
	private static final Class<?>[] _getExpenseItemTypesParameterTypes1 =
		new Class[] {long.class, int.class, int.class};
	private static final Class<?>[] _getExpenseItemTypesCountParameterTypes2 =
		new Class[] {long.class};
	private static final Class<?>[] _addExpenseItemParameterTypes3 =
		new Class[] {
			long.class, String.class, String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getByExpenseTypeIdParameterTypes4 =
		new Class[] {long.class};
	private static final Class<?>[] _updateExpenseItemTypeParameterTypes5 =
		new Class[] {
			long.class, String.class, String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteExpenseItemTypeParameterTypes6 =
		new Class[] {
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};

}