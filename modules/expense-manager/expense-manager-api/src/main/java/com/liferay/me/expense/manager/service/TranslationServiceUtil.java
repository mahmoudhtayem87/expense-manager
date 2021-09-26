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

import com.liferay.me.expense.manager.model.Translation;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * Provides the remote service utility for Translation. This utility wraps
 * <code>com.liferay.me.expense.manager.service.impl.TranslationServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Mahmoud Hussein Tayem
 * @see TranslationService
 * @generated
 */
public class TranslationServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.me.expense.manager.service.impl.TranslationServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Translation addTranslationItem(
			long groupId, String key, String portletId, String cultureCode,
			String translationValue, String componentId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addTranslationItem(
			groupId, key, portletId, cultureCode, translationValue, componentId,
			serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static List<Translation> getTranslatedComponentsByGroupIdPortletId(
		long groupId, String portletId) {

		return getService().getTranslatedComponentsByGroupIdPortletId(
			groupId, portletId);
	}

	public static List<Translation> getTranslatedPortletsByGroupId(
		long groupId) {

		return getService().getTranslatedPortletsByGroupId(groupId);
	}

	public static List<Translation> getTranslationByGroupId(
		long groupId, int start, int end) {

		return getService().getTranslationByGroupId(groupId, start, end);
	}

	public static List<Translation>
		getTranslationByPortletIdAndComponentIdAndCulture(
			long groupId, String portletId, String componentId,
			String cultureCode) {

		return getService().getTranslationByPortletIdAndComponentIdAndCulture(
			groupId, portletId, componentId, cultureCode);
	}

	public static List<Translation> getTranslationByPortletIdAndCulture(
		long groupId, String portletId, String cultureCode) {

		return getService().getTranslationByPortletIdAndCulture(
			groupId, portletId, cultureCode);
	}

	public static int getTranslationCountByGroupId(long groupId) {
		return getService().getTranslationCountByGroupId(groupId);
	}

	public static List<Translation> getTranslationsByPortletIdComponentId(
		long groupId, String portletId, String componentId, String cultureCode,
		int start, int end) {

		return getService().getTranslationsByPortletIdComponentId(
			groupId, portletId, componentId, cultureCode, start, end);
	}

	public static int getTranslationsByPortletIdComponentIdCount(
		long groupId, String portletId, String componentId,
		String cultureCode) {

		return getService().getTranslationsByPortletIdComponentIdCount(
			groupId, portletId, componentId, cultureCode);
	}

	public static void removeByGroupId(long groupId) {
		getService().removeByGroupId(groupId);
	}

	public static void removeByTranslationId(long translationId)
		throws com.liferay.me.expense.manager.exception.
			NoSuchTranslationException {

		getService().removeByTranslationId(translationId);
	}

	public static Translation updateByTranslationId(
			long translationId, String newTranslationValue)
		throws PortalException {

		return getService().updateByTranslationId(
			translationId, newTranslationValue);
	}

	public static void updateTranslationByTranslationId(
			long translationId, String NewTranslationValue)
		throws PortalException {

		getService().updateTranslationByTranslationId(
			translationId, NewTranslationValue);
	}

	public static TranslationService getService() {
		return _service;
	}

	private static volatile TranslationService _service;

}