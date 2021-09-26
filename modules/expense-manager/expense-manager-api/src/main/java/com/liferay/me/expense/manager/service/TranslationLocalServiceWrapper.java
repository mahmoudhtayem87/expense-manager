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
 * Provides a wrapper for {@link TranslationLocalService}.
 *
 * @author Mahmoud Hussein Tayem
 * @see TranslationLocalService
 * @generated
 */
public class TranslationLocalServiceWrapper
	implements ServiceWrapper<TranslationLocalService>,
			   TranslationLocalService {

	public TranslationLocalServiceWrapper(
		TranslationLocalService translationLocalService) {

		_translationLocalService = translationLocalService;
	}

	/**
	 * Adds the translation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TranslationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param translation the translation
	 * @return the translation that was added
	 */
	@Override
	public com.liferay.me.expense.manager.model.Translation addTranslation(
		com.liferay.me.expense.manager.model.Translation translation) {

		return _translationLocalService.addTranslation(translation);
	}

	@Override
	public com.liferay.me.expense.manager.model.Translation addTranslationItem(
			long groupId, String key, String portletId, String cultureCode,
			String translationValue, String componentId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _translationLocalService.addTranslationItem(
			groupId, key, portletId, cultureCode, translationValue, componentId,
			serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _translationLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new translation with the primary key. Does not add the translation to the database.
	 *
	 * @param translationId the primary key for the new translation
	 * @return the new translation
	 */
	@Override
	public com.liferay.me.expense.manager.model.Translation createTranslation(
		long translationId) {

		return _translationLocalService.createTranslation(translationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _translationLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the translation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TranslationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param translationId the primary key of the translation
	 * @return the translation that was removed
	 * @throws PortalException if a translation with the primary key could not be found
	 */
	@Override
	public com.liferay.me.expense.manager.model.Translation deleteTranslation(
			long translationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _translationLocalService.deleteTranslation(translationId);
	}

	/**
	 * Deletes the translation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TranslationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param translation the translation
	 * @return the translation that was removed
	 */
	@Override
	public com.liferay.me.expense.manager.model.Translation deleteTranslation(
		com.liferay.me.expense.manager.model.Translation translation) {

		return _translationLocalService.deleteTranslation(translation);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _translationLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _translationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.me.expense.manager.model.impl.TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _translationLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.me.expense.manager.model.impl.TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _translationLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _translationLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _translationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.me.expense.manager.model.Translation fetchTranslation(
		long translationId) {

		return _translationLocalService.fetchTranslation(translationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _translationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _translationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _translationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _translationLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Translation>
		getTranslatedComponentsByGroupIdPortletId(
			long groupId, String portletId) {

		return _translationLocalService.
			getTranslatedComponentsByGroupIdPortletId(groupId, portletId);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Translation>
		getTranslatedPortletsByGroupId(long groupId) {

		return _translationLocalService.getTranslatedPortletsByGroupId(groupId);
	}

	/**
	 * Returns the translation with the primary key.
	 *
	 * @param translationId the primary key of the translation
	 * @return the translation
	 * @throws PortalException if a translation with the primary key could not be found
	 */
	@Override
	public com.liferay.me.expense.manager.model.Translation getTranslation(
			long translationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _translationLocalService.getTranslation(translationId);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Translation>
		getTranslationByGroupId(long groupId, int start, int end) {

		return _translationLocalService.getTranslationByGroupId(
			groupId, start, end);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Translation>
		getTranslationByPortletIdAndComponentIdAndCulture(
			long groupId, String portletId, String componentId,
			String cultureCode) {

		return _translationLocalService.
			getTranslationByPortletIdAndComponentIdAndCulture(
				groupId, portletId, componentId, cultureCode);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Translation>
		getTranslationByPortletIdAndComponentIdAndCulture(
			long groupId, String portletId, String componentId,
			String cultureCode, java.util.List<String> keys) {

		return _translationLocalService.
			getTranslationByPortletIdAndComponentIdAndCulture(
				groupId, portletId, componentId, cultureCode, keys);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Translation>
		getTranslationByPortletIdAndCulture(
			long groupId, String portletId, String cultureCode) {

		return _translationLocalService.getTranslationByPortletIdAndCulture(
			groupId, portletId, cultureCode);
	}

	@Override
	public int getTranslationCountByGroupId(long groupId) {
		return _translationLocalService.getTranslationCountByGroupId(groupId);
	}

	/**
	 * Returns a range of all the translations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.me.expense.manager.model.impl.TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @return the range of translations
	 */
	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Translation>
		getTranslations(int start, int end) {

		return _translationLocalService.getTranslations(start, end);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.Translation>
		getTranslationsByPortletIdComponentId(
			long groupId, String portletId, String componentId,
			String cultureCode, int start, int end) {

		return _translationLocalService.getTranslationsByPortletIdComponentId(
			groupId, portletId, componentId, cultureCode, start, end);
	}

	@Override
	public int getTranslationsByPortletIdComponentIdCount(
		long groupId, String portletId, String componentId,
		String cultureCode) {

		return _translationLocalService.
			getTranslationsByPortletIdComponentIdCount(
				groupId, portletId, componentId, cultureCode);
	}

	/**
	 * Returns the number of translations.
	 *
	 * @return the number of translations
	 */
	@Override
	public int getTranslationsCount() {
		return _translationLocalService.getTranslationsCount();
	}

	@Override
	public void removeByGroupId(long groupId) {
		_translationLocalService.removeByGroupId(groupId);
	}

	@Override
	public void removeByTranslationId(long translationId)
		throws com.liferay.me.expense.manager.exception.
			NoSuchTranslationException {

		_translationLocalService.removeByTranslationId(translationId);
	}

	@Override
	public com.liferay.me.expense.manager.model.Translation
			updateByTranslationId(
				long translationId, String newTranslationValue)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _translationLocalService.updateByTranslationId(
			translationId, newTranslationValue);
	}

	/**
	 * Updates the translation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TranslationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param translation the translation
	 * @return the translation that was updated
	 */
	@Override
	public com.liferay.me.expense.manager.model.Translation updateTranslation(
		com.liferay.me.expense.manager.model.Translation translation) {

		return _translationLocalService.updateTranslation(translation);
	}

	@Override
	public void updateTranslationByTranslationId(
			long translationId, String NewTranslationValue)
		throws com.liferay.portal.kernel.exception.PortalException {

		_translationLocalService.updateTranslationByTranslationId(
			translationId, NewTranslationValue);
	}

	@Override
	public TranslationLocalService getWrappedService() {
		return _translationLocalService;
	}

	@Override
	public void setWrappedService(
		TranslationLocalService translationLocalService) {

		_translationLocalService = translationLocalService;
	}

	private TranslationLocalService _translationLocalService;

}