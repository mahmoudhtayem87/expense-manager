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

import com.liferay.me.expense.manager.service.TranslationServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>TranslationServiceUtil</code> service
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
 * @see TranslationServiceSoap
 * @generated
 */
public class TranslationServiceHttp {

	public static com.liferay.me.expense.manager.model.Translation
			addTranslationItem(
				HttpPrincipal httpPrincipal, long groupId, String key,
				String portletId, String cultureCode, String translationValue,
				String componentId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TranslationServiceUtil.class, "addTranslationItem",
				_addTranslationItemParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, key, portletId, cultureCode,
				translationValue, componentId, serviceContext);

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

			return (com.liferay.me.expense.manager.model.Translation)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.liferay.me.expense.manager.model.Translation>
			getTranslationByPortletIdAndComponentIdAndCulture(
				HttpPrincipal httpPrincipal, long groupId, String portletId,
				String componentId, String cultureCode) {

		try {
			MethodKey methodKey = new MethodKey(
				TranslationServiceUtil.class,
				"getTranslationByPortletIdAndComponentIdAndCulture",
				_getTranslationByPortletIdAndComponentIdAndCultureParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, portletId, componentId, cultureCode);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.me.expense.manager.model.Translation>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void removeByGroupId(
		HttpPrincipal httpPrincipal, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				TranslationServiceUtil.class, "removeByGroupId",
				_removeByGroupIdParameterTypes2);

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

	public static java.util.List
		<com.liferay.me.expense.manager.model.Translation>
			getTranslationByPortletIdAndCulture(
				HttpPrincipal httpPrincipal, long groupId, String portletId,
				String cultureCode) {

		try {
			MethodKey methodKey = new MethodKey(
				TranslationServiceUtil.class,
				"getTranslationByPortletIdAndCulture",
				_getTranslationByPortletIdAndCultureParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, portletId, cultureCode);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.me.expense.manager.model.Translation>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void removeByTranslationId(
			HttpPrincipal httpPrincipal, long translationId)
		throws com.liferay.me.expense.manager.exception.
			NoSuchTranslationException {

		try {
			MethodKey methodKey = new MethodKey(
				TranslationServiceUtil.class, "removeByTranslationId",
				_removeByTranslationIdParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, translationId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.me.expense.manager.exception.
							NoSuchTranslationException) {

					throw (com.liferay.me.expense.manager.exception.
						NoSuchTranslationException)exception;
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

	public static void updateTranslationByTranslationId(
			HttpPrincipal httpPrincipal, long translationId,
			String NewTranslationValue)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TranslationServiceUtil.class,
				"updateTranslationByTranslationId",
				_updateTranslationByTranslationIdParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, translationId, NewTranslationValue);

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

	public static java.util.List
		<com.liferay.me.expense.manager.model.Translation>
			getTranslationByGroupId(
				HttpPrincipal httpPrincipal, long groupId, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				TranslationServiceUtil.class, "getTranslationByGroupId",
				_getTranslationByGroupIdParameterTypes6);

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
				<com.liferay.me.expense.manager.model.Translation>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getTranslationCountByGroupId(
		HttpPrincipal httpPrincipal, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				TranslationServiceUtil.class, "getTranslationCountByGroupId",
				_getTranslationCountByGroupIdParameterTypes7);

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

	public static com.liferay.me.expense.manager.model.Translation
			updateByTranslationId(
				HttpPrincipal httpPrincipal, long translationId,
				String newTranslationValue)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TranslationServiceUtil.class, "updateByTranslationId",
				_updateByTranslationIdParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, translationId, newTranslationValue);

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

			return (com.liferay.me.expense.manager.model.Translation)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.liferay.me.expense.manager.model.Translation>
			getTranslatedPortletsByGroupId(
				HttpPrincipal httpPrincipal, long groupId) {

		try {
			MethodKey methodKey = new MethodKey(
				TranslationServiceUtil.class, "getTranslatedPortletsByGroupId",
				_getTranslatedPortletsByGroupIdParameterTypes9);

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
				<com.liferay.me.expense.manager.model.Translation>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.liferay.me.expense.manager.model.Translation>
			getTranslatedComponentsByGroupIdPortletId(
				HttpPrincipal httpPrincipal, long groupId, String portletId) {

		try {
			MethodKey methodKey = new MethodKey(
				TranslationServiceUtil.class,
				"getTranslatedComponentsByGroupIdPortletId",
				_getTranslatedComponentsByGroupIdPortletIdParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, portletId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.me.expense.manager.model.Translation>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.liferay.me.expense.manager.model.Translation>
			getTranslationsByPortletIdComponentId(
				HttpPrincipal httpPrincipal, long groupId, String portletId,
				String componentId, String cultureCode, int start, int end) {

		try {
			MethodKey methodKey = new MethodKey(
				TranslationServiceUtil.class,
				"getTranslationsByPortletIdComponentId",
				_getTranslationsByPortletIdComponentIdParameterTypes11);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, portletId, componentId, cultureCode, start,
				end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.me.expense.manager.model.Translation>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getTranslationsByPortletIdComponentIdCount(
		HttpPrincipal httpPrincipal, long groupId, String portletId,
		String componentId, String cultureCode) {

		try {
			MethodKey methodKey = new MethodKey(
				TranslationServiceUtil.class,
				"getTranslationsByPortletIdComponentIdCount",
				_getTranslationsByPortletIdComponentIdCountParameterTypes12);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, portletId, componentId, cultureCode);

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

	private static Log _log = LogFactoryUtil.getLog(
		TranslationServiceHttp.class);

	private static final Class<?>[] _addTranslationItemParameterTypes0 =
		new Class[] {
			long.class, String.class, String.class, String.class, String.class,
			String.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[]
		_getTranslationByPortletIdAndComponentIdAndCultureParameterTypes1 =
			new Class[] {long.class, String.class, String.class, String.class};
	private static final Class<?>[] _removeByGroupIdParameterTypes2 =
		new Class[] {long.class};
	private static final Class<?>[]
		_getTranslationByPortletIdAndCultureParameterTypes3 = new Class[] {
			long.class, String.class, String.class
		};
	private static final Class<?>[] _removeByTranslationIdParameterTypes4 =
		new Class[] {long.class};
	private static final Class<?>[]
		_updateTranslationByTranslationIdParameterTypes5 = new Class[] {
			long.class, String.class
		};
	private static final Class<?>[] _getTranslationByGroupIdParameterTypes6 =
		new Class[] {long.class, int.class, int.class};
	private static final Class<?>[]
		_getTranslationCountByGroupIdParameterTypes7 = new Class[] {long.class};
	private static final Class<?>[] _updateByTranslationIdParameterTypes8 =
		new Class[] {long.class, String.class};
	private static final Class<?>[]
		_getTranslatedPortletsByGroupIdParameterTypes9 = new Class[] {
			long.class
		};
	private static final Class<?>[]
		_getTranslatedComponentsByGroupIdPortletIdParameterTypes10 =
			new Class[] {long.class, String.class};
	private static final Class<?>[]
		_getTranslationsByPortletIdComponentIdParameterTypes11 = new Class[] {
			long.class, String.class, String.class, String.class, int.class,
			int.class
		};
	private static final Class<?>[]
		_getTranslationsByPortletIdComponentIdCountParameterTypes12 =
			new Class[] {long.class, String.class, String.class, String.class};

}