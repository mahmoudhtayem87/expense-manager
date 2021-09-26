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

import com.liferay.me.expense.manager.exception.NoSuchTranslationException;
import com.liferay.me.expense.manager.model.Translation;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Translation. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Mahmoud Hussein Tayem
 * @see TranslationServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface TranslationService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.liferay.me.expense.manager.service.impl.TranslationServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the translation remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link TranslationServiceUtil} if injection and service tracking are not available.
	 */
	public Translation addTranslationItem(
			long groupId, String key, String portletId, String cultureCode,
			String translationValue, String componentId,
			ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Translation> getTranslatedComponentsByGroupIdPortletId(
		long groupId, String portletId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Translation> getTranslatedPortletsByGroupId(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Translation> getTranslationByGroupId(
		long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Translation> getTranslationByPortletIdAndComponentIdAndCulture(
		long groupId, String portletId, String componentId, String cultureCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Translation> getTranslationByPortletIdAndCulture(
		long groupId, String portletId, String cultureCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTranslationCountByGroupId(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Translation> getTranslationsByPortletIdComponentId(
		long groupId, String portletId, String componentId, String cultureCode,
		int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTranslationsByPortletIdComponentIdCount(
		long groupId, String portletId, String componentId, String cultureCode);

	public void removeByGroupId(long groupId);

	public void removeByTranslationId(long translationId)
		throws NoSuchTranslationException;

	public Translation updateByTranslationId(
			long translationId, String newTranslationValue)
		throws PortalException;

	public void updateTranslationByTranslationId(
			long translationId, String NewTranslationValue)
		throws PortalException;

}