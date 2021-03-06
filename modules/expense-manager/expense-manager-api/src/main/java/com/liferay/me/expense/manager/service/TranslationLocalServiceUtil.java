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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Translation. This utility wraps
 * <code>com.liferay.me.expense.manager.service.impl.TranslationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Mahmoud Hussein Tayem
 * @see TranslationLocalService
 * @generated
 */
public class TranslationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.me.expense.manager.service.impl.TranslationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Translation addTranslation(Translation translation) {
		return getService().addTranslation(translation);
	}

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
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new translation with the primary key. Does not add the translation to the database.
	 *
	 * @param translationId the primary key for the new translation
	 * @return the new translation
	 */
	public static Translation createTranslation(long translationId) {
		return getService().createTranslation(translationId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static Translation deleteTranslation(long translationId)
		throws PortalException {

		return getService().deleteTranslation(translationId);
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
	public static Translation deleteTranslation(Translation translation) {
		return getService().deleteTranslation(translation);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Translation fetchTranslation(long translationId) {
		return getService().fetchTranslation(translationId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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

	/**
	 * Returns the translation with the primary key.
	 *
	 * @param translationId the primary key of the translation
	 * @return the translation
	 * @throws PortalException if a translation with the primary key could not be found
	 */
	public static Translation getTranslation(long translationId)
		throws PortalException {

		return getService().getTranslation(translationId);
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

	public static List<Translation>
		getTranslationByPortletIdAndComponentIdAndCulture(
			long groupId, String portletId, String componentId,
			String cultureCode, List<String> keys) {

		return getService().getTranslationByPortletIdAndComponentIdAndCulture(
			groupId, portletId, componentId, cultureCode, keys);
	}

	public static List<Translation> getTranslationByPortletIdAndCulture(
		long groupId, String portletId, String cultureCode) {

		return getService().getTranslationByPortletIdAndCulture(
			groupId, portletId, cultureCode);
	}

	public static int getTranslationCountByGroupId(long groupId) {
		return getService().getTranslationCountByGroupId(groupId);
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
	public static List<Translation> getTranslations(int start, int end) {
		return getService().getTranslations(start, end);
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

	/**
	 * Returns the number of translations.
	 *
	 * @return the number of translations
	 */
	public static int getTranslationsCount() {
		return getService().getTranslationsCount();
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
	public static Translation updateTranslation(Translation translation) {
		return getService().updateTranslation(translation);
	}

	public static void updateTranslationByTranslationId(
			long translationId, String NewTranslationValue)
		throws PortalException {

		getService().updateTranslationByTranslationId(
			translationId, NewTranslationValue);
	}

	public static TranslationLocalService getService() {
		return _service;
	}

	private static volatile TranslationLocalService _service;

}