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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TranslationService}.
 *
 * @author Mahmoud Hussein Tayem
 * @see TranslationService
 * @generated
 */
public class TranslationServiceWrapper
	implements ServiceWrapper<TranslationService>, TranslationService {

	public TranslationServiceWrapper(TranslationService translationService) {
		_translationService = translationService;
	}

	@Override
	public com.liferay.me.expense.manager.model.Translation addTranslationItem(
			long groupId, String key, String portletId, String cultureCode,
			String translationValue, String componentId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _translationService.addTranslationItem(
			groupId, key, portletId, cultureCode, translationValue, componentId,
			serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _translationService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Translation>
		getTranslatedComponentsByGroupIdPortletId(
			long groupId, String portletId) {

		return _translationService.getTranslatedComponentsByGroupIdPortletId(
			groupId, portletId);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Translation>
		getTranslatedPortletsByGroupId(long groupId) {

		return _translationService.getTranslatedPortletsByGroupId(groupId);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Translation>
		getTranslationByGroupId(long groupId, int start, int end) {

		return _translationService.getTranslationByGroupId(groupId, start, end);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Translation>
		getTranslationByPortletIdAndComponentIdAndCulture(
			long groupId, String portletId, String componentId,
			String cultureCode) {

		return _translationService.
			getTranslationByPortletIdAndComponentIdAndCulture(
				groupId, portletId, componentId, cultureCode);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Translation>
		getTranslationByPortletIdAndCulture(
			long groupId, String portletId, String cultureCode) {

		return _translationService.getTranslationByPortletIdAndCulture(
			groupId, portletId, cultureCode);
	}

	@Override
	public int getTranslationCountByGroupId(long groupId) {
		return _translationService.getTranslationCountByGroupId(groupId);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Translation>
		getTranslationsByPortletIdComponentId(
			long groupId, String portletId, String componentId,
			String cultureCode, int start, int end) {

		return _translationService.getTranslationsByPortletIdComponentId(
			groupId, portletId, componentId, cultureCode, start, end);
	}

	@Override
	public int getTranslationsByPortletIdComponentIdCount(
		long groupId, String portletId, String componentId,
		String cultureCode) {

		return _translationService.getTranslationsByPortletIdComponentIdCount(
			groupId, portletId, componentId, cultureCode);
	}

	@Override
	public void removeByGroupId(long groupId) {
		_translationService.removeByGroupId(groupId);
	}

	@Override
	public void removeByTranslationId(long translationId)
		throws com.liferay.me.expense.manager.exception.
			NoSuchTranslationException {

		_translationService.removeByTranslationId(translationId);
	}

	@Override
	public com.liferay.me.expense.manager.model.Translation
			updateByTranslationId(
				long translationId, String newTranslationValue)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _translationService.updateByTranslationId(
			translationId, newTranslationValue);
	}

	@Override
	public void updateTranslationByTranslationId(
			long translationId, String NewTranslationValue)
		throws com.liferay.portal.kernel.exception.PortalException {

		_translationService.updateTranslationByTranslationId(
			translationId, NewTranslationValue);
	}

	@Override
	public TranslationService getWrappedService() {
		return _translationService;
	}

	@Override
	public void setWrappedService(TranslationService translationService) {
		_translationService = translationService;
	}

	private TranslationService _translationService;

}