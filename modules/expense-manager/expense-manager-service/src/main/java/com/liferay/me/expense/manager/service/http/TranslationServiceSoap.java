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

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>TranslationServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.me.expense.manager.model.TranslationSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.me.expense.manager.model.Translation</code>, that is translated to a
 * <code>com.liferay.me.expense.manager.model.TranslationSoap</code>. Methods that SOAP
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
 * @see TranslationServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class TranslationServiceSoap {

	public static com.liferay.me.expense.manager.model.TranslationSoap
			addTranslationItem(
				long groupId, String key, String portletId, String cultureCode,
				String translationValue, String componentId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.me.expense.manager.model.Translation returnValue =
				TranslationServiceUtil.addTranslationItem(
					groupId, key, portletId, cultureCode, translationValue,
					componentId, serviceContext);

			return com.liferay.me.expense.manager.model.TranslationSoap.
				toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.me.expense.manager.model.TranslationSoap[]
			getTranslationByPortletIdAndComponentIdAndCulture(
				long groupId, String portletId, String componentId,
				String cultureCode)
		throws RemoteException {

		try {
			java.util.List<com.liferay.me.expense.manager.model.Translation>
				returnValue =
					TranslationServiceUtil.
						getTranslationByPortletIdAndComponentIdAndCulture(
							groupId, portletId, componentId, cultureCode);

			return com.liferay.me.expense.manager.model.TranslationSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void removeByGroupId(long groupId) throws RemoteException {
		try {
			TranslationServiceUtil.removeByGroupId(groupId);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.me.expense.manager.model.TranslationSoap[]
			getTranslationByPortletIdAndCulture(
				long groupId, String portletId, String cultureCode)
		throws RemoteException {

		try {
			java.util.List<com.liferay.me.expense.manager.model.Translation>
				returnValue =
					TranslationServiceUtil.getTranslationByPortletIdAndCulture(
						groupId, portletId, cultureCode);

			return com.liferay.me.expense.manager.model.TranslationSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void removeByTranslationId(long translationId)
		throws RemoteException {

		try {
			TranslationServiceUtil.removeByTranslationId(translationId);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void updateTranslationByTranslationId(
			long translationId, String NewTranslationValue)
		throws RemoteException {

		try {
			TranslationServiceUtil.updateTranslationByTranslationId(
				translationId, NewTranslationValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.me.expense.manager.model.TranslationSoap[]
			getTranslationByGroupId(long groupId, int start, int end)
		throws RemoteException {

		try {
			java.util.List<com.liferay.me.expense.manager.model.Translation>
				returnValue = TranslationServiceUtil.getTranslationByGroupId(
					groupId, start, end);

			return com.liferay.me.expense.manager.model.TranslationSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int getTranslationCountByGroupId(long groupId)
		throws RemoteException {

		try {
			int returnValue =
				TranslationServiceUtil.getTranslationCountByGroupId(groupId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.me.expense.manager.model.TranslationSoap
			updateByTranslationId(
				long translationId, String newTranslationValue)
		throws RemoteException {

		try {
			com.liferay.me.expense.manager.model.Translation returnValue =
				TranslationServiceUtil.updateByTranslationId(
					translationId, newTranslationValue);

			return com.liferay.me.expense.manager.model.TranslationSoap.
				toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.me.expense.manager.model.TranslationSoap[]
			getTranslatedPortletsByGroupId(long groupId)
		throws RemoteException {

		try {
			java.util.List<com.liferay.me.expense.manager.model.Translation>
				returnValue =
					TranslationServiceUtil.getTranslatedPortletsByGroupId(
						groupId);

			return com.liferay.me.expense.manager.model.TranslationSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.me.expense.manager.model.TranslationSoap[]
			getTranslatedComponentsByGroupIdPortletId(
				long groupId, String portletId)
		throws RemoteException {

		try {
			java.util.List<com.liferay.me.expense.manager.model.Translation>
				returnValue =
					TranslationServiceUtil.
						getTranslatedComponentsByGroupIdPortletId(
							groupId, portletId);

			return com.liferay.me.expense.manager.model.TranslationSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.me.expense.manager.model.TranslationSoap[]
			getTranslationsByPortletIdComponentId(
				long groupId, String portletId, String componentId,
				String cultureCode, int start, int end)
		throws RemoteException {

		try {
			java.util.List<com.liferay.me.expense.manager.model.Translation>
				returnValue =
					TranslationServiceUtil.
						getTranslationsByPortletIdComponentId(
							groupId, portletId, componentId, cultureCode, start,
							end);

			return com.liferay.me.expense.manager.model.TranslationSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int getTranslationsByPortletIdComponentIdCount(
			long groupId, String portletId, String componentId,
			String cultureCode)
		throws RemoteException {

		try {
			int returnValue =
				TranslationServiceUtil.
					getTranslationsByPortletIdComponentIdCount(
						groupId, portletId, componentId, cultureCode);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		TranslationServiceSoap.class);

}