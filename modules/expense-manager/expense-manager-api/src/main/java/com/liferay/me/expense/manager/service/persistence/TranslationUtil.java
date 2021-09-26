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

package com.liferay.me.expense.manager.service.persistence;

import com.liferay.me.expense.manager.model.Translation;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the translation service. This utility wraps <code>com.liferay.me.expense.manager.service.persistence.impl.TranslationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @see TranslationPersistence
 * @generated
 */
public class TranslationUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Translation translation) {
		getPersistence().clearCache(translation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Translation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Translation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Translation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Translation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Translation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Translation update(Translation translation) {
		return getPersistence().update(translation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Translation update(
		Translation translation, ServiceContext serviceContext) {

		return getPersistence().update(translation, serviceContext);
	}

	/**
	 * Returns the translation where translationId = &#63; or throws a <code>NoSuchTranslationException</code> if it could not be found.
	 *
	 * @param translationId the translation ID
	 * @return the matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public static Translation findByTranslationId(long translationId)
		throws com.liferay.me.expense.manager.exception.
			NoSuchTranslationException {

		return getPersistence().findByTranslationId(translationId);
	}

	/**
	 * Returns the translation where translationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param translationId the translation ID
	 * @return the matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public static Translation fetchByTranslationId(long translationId) {
		return getPersistence().fetchByTranslationId(translationId);
	}

	/**
	 * Returns the translation where translationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param translationId the translation ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public static Translation fetchByTranslationId(
		long translationId, boolean useFinderCache) {

		return getPersistence().fetchByTranslationId(
			translationId, useFinderCache);
	}

	/**
	 * Removes the translation where translationId = &#63; from the database.
	 *
	 * @param translationId the translation ID
	 * @return the translation that was removed
	 */
	public static Translation removeByTranslationId(long translationId)
		throws com.liferay.me.expense.manager.exception.
			NoSuchTranslationException {

		return getPersistence().removeByTranslationId(translationId);
	}

	/**
	 * Returns the number of translations where translationId = &#63;.
	 *
	 * @param translationId the translation ID
	 * @return the number of matching translations
	 */
	public static int countByTranslationId(long translationId) {
		return getPersistence().countByTranslationId(translationId);
	}

	/**
	 * Returns all the translations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching translations
	 */
	public static List<Translation> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the translations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @return the range of matching translations
	 */
	public static List<Translation> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the translations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching translations
	 */
	public static List<Translation> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Translation> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the translations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching translations
	 */
	public static List<Translation> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Translation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first translation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public static Translation findByGroupId_First(
			long groupId, OrderByComparator<Translation> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchTranslationException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first translation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public static Translation fetchByGroupId_First(
		long groupId, OrderByComparator<Translation> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last translation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public static Translation findByGroupId_Last(
			long groupId, OrderByComparator<Translation> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchTranslationException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last translation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public static Translation fetchByGroupId_Last(
		long groupId, OrderByComparator<Translation> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the translations before and after the current translation in the ordered set where groupId = &#63;.
	 *
	 * @param translationId the primary key of the current translation
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	public static Translation[] findByGroupId_PrevAndNext(
			long translationId, long groupId,
			OrderByComparator<Translation> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchTranslationException {

		return getPersistence().findByGroupId_PrevAndNext(
			translationId, groupId, orderByComparator);
	}

	/**
	 * Returns all the translations that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching translations that the user has permission to view
	 */
	public static List<Translation> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	 * Returns a range of all the translations that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @return the range of matching translations that the user has permission to view
	 */
	public static List<Translation> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the translations that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching translations that the user has permission to view
	 */
	public static List<Translation> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Translation> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the translations before and after the current translation in the ordered set of translations that the user has permission to view where groupId = &#63;.
	 *
	 * @param translationId the primary key of the current translation
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	public static Translation[] filterFindByGroupId_PrevAndNext(
			long translationId, long groupId,
			OrderByComparator<Translation> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchTranslationException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			translationId, groupId, orderByComparator);
	}

	/**
	 * Removes all the translations where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of translations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching translations
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of translations that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching translations that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Returns all the translations where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @return the matching translations
	 */
	public static List<Translation> findByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode) {

		return getPersistence().findByPortletIdAndCultureCode(
			groupId, portletId, cultureCode);
	}

	/**
	 * Returns a range of all the translations where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @return the range of matching translations
	 */
	public static List<Translation> findByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode, int start,
		int end) {

		return getPersistence().findByPortletIdAndCultureCode(
			groupId, portletId, cultureCode, start, end);
	}

	/**
	 * Returns an ordered range of all the translations where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching translations
	 */
	public static List<Translation> findByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode, int start, int end,
		OrderByComparator<Translation> orderByComparator) {

		return getPersistence().findByPortletIdAndCultureCode(
			groupId, portletId, cultureCode, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the translations where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching translations
	 */
	public static List<Translation> findByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode, int start, int end,
		OrderByComparator<Translation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPortletIdAndCultureCode(
			groupId, portletId, cultureCode, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first translation in the ordered set where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public static Translation findByPortletIdAndCultureCode_First(
			long groupId, String portletId, String cultureCode,
			OrderByComparator<Translation> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchTranslationException {

		return getPersistence().findByPortletIdAndCultureCode_First(
			groupId, portletId, cultureCode, orderByComparator);
	}

	/**
	 * Returns the first translation in the ordered set where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public static Translation fetchByPortletIdAndCultureCode_First(
		long groupId, String portletId, String cultureCode,
		OrderByComparator<Translation> orderByComparator) {

		return getPersistence().fetchByPortletIdAndCultureCode_First(
			groupId, portletId, cultureCode, orderByComparator);
	}

	/**
	 * Returns the last translation in the ordered set where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public static Translation findByPortletIdAndCultureCode_Last(
			long groupId, String portletId, String cultureCode,
			OrderByComparator<Translation> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchTranslationException {

		return getPersistence().findByPortletIdAndCultureCode_Last(
			groupId, portletId, cultureCode, orderByComparator);
	}

	/**
	 * Returns the last translation in the ordered set where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public static Translation fetchByPortletIdAndCultureCode_Last(
		long groupId, String portletId, String cultureCode,
		OrderByComparator<Translation> orderByComparator) {

		return getPersistence().fetchByPortletIdAndCultureCode_Last(
			groupId, portletId, cultureCode, orderByComparator);
	}

	/**
	 * Returns the translations before and after the current translation in the ordered set where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * @param translationId the primary key of the current translation
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	public static Translation[] findByPortletIdAndCultureCode_PrevAndNext(
			long translationId, long groupId, String portletId,
			String cultureCode,
			OrderByComparator<Translation> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchTranslationException {

		return getPersistence().findByPortletIdAndCultureCode_PrevAndNext(
			translationId, groupId, portletId, cultureCode, orderByComparator);
	}

	/**
	 * Returns all the translations that the user has permission to view where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @return the matching translations that the user has permission to view
	 */
	public static List<Translation> filterFindByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode) {

		return getPersistence().filterFindByPortletIdAndCultureCode(
			groupId, portletId, cultureCode);
	}

	/**
	 * Returns a range of all the translations that the user has permission to view where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @return the range of matching translations that the user has permission to view
	 */
	public static List<Translation> filterFindByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode, int start,
		int end) {

		return getPersistence().filterFindByPortletIdAndCultureCode(
			groupId, portletId, cultureCode, start, end);
	}

	/**
	 * Returns an ordered range of all the translations that the user has permissions to view where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching translations that the user has permission to view
	 */
	public static List<Translation> filterFindByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode, int start, int end,
		OrderByComparator<Translation> orderByComparator) {

		return getPersistence().filterFindByPortletIdAndCultureCode(
			groupId, portletId, cultureCode, start, end, orderByComparator);
	}

	/**
	 * Returns the translations before and after the current translation in the ordered set of translations that the user has permission to view where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * @param translationId the primary key of the current translation
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	public static Translation[] filterFindByPortletIdAndCultureCode_PrevAndNext(
			long translationId, long groupId, String portletId,
			String cultureCode,
			OrderByComparator<Translation> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchTranslationException {

		return getPersistence().filterFindByPortletIdAndCultureCode_PrevAndNext(
			translationId, groupId, portletId, cultureCode, orderByComparator);
	}

	/**
	 * Removes all the translations where groupId = &#63; and portletId = &#63; and cultureCode = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 */
	public static void removeByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode) {

		getPersistence().removeByPortletIdAndCultureCode(
			groupId, portletId, cultureCode);
	}

	/**
	 * Returns the number of translations where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @return the number of matching translations
	 */
	public static int countByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode) {

		return getPersistence().countByPortletIdAndCultureCode(
			groupId, portletId, cultureCode);
	}

	/**
	 * Returns the number of translations that the user has permission to view where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @return the number of matching translations that the user has permission to view
	 */
	public static int filterCountByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode) {

		return getPersistence().filterCountByPortletIdAndCultureCode(
			groupId, portletId, cultureCode);
	}

	/**
	 * Returns all the translations where groupId = &#63; and portletId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @return the matching translations
	 */
	public static List<Translation> findByGroupIdAndPortletId(
		long groupId, String portletId) {

		return getPersistence().findByGroupIdAndPortletId(groupId, portletId);
	}

	/**
	 * Returns a range of all the translations where groupId = &#63; and portletId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @return the range of matching translations
	 */
	public static List<Translation> findByGroupIdAndPortletId(
		long groupId, String portletId, int start, int end) {

		return getPersistence().findByGroupIdAndPortletId(
			groupId, portletId, start, end);
	}

	/**
	 * Returns an ordered range of all the translations where groupId = &#63; and portletId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching translations
	 */
	public static List<Translation> findByGroupIdAndPortletId(
		long groupId, String portletId, int start, int end,
		OrderByComparator<Translation> orderByComparator) {

		return getPersistence().findByGroupIdAndPortletId(
			groupId, portletId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the translations where groupId = &#63; and portletId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching translations
	 */
	public static List<Translation> findByGroupIdAndPortletId(
		long groupId, String portletId, int start, int end,
		OrderByComparator<Translation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupIdAndPortletId(
			groupId, portletId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first translation in the ordered set where groupId = &#63; and portletId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public static Translation findByGroupIdAndPortletId_First(
			long groupId, String portletId,
			OrderByComparator<Translation> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchTranslationException {

		return getPersistence().findByGroupIdAndPortletId_First(
			groupId, portletId, orderByComparator);
	}

	/**
	 * Returns the first translation in the ordered set where groupId = &#63; and portletId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public static Translation fetchByGroupIdAndPortletId_First(
		long groupId, String portletId,
		OrderByComparator<Translation> orderByComparator) {

		return getPersistence().fetchByGroupIdAndPortletId_First(
			groupId, portletId, orderByComparator);
	}

	/**
	 * Returns the last translation in the ordered set where groupId = &#63; and portletId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public static Translation findByGroupIdAndPortletId_Last(
			long groupId, String portletId,
			OrderByComparator<Translation> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchTranslationException {

		return getPersistence().findByGroupIdAndPortletId_Last(
			groupId, portletId, orderByComparator);
	}

	/**
	 * Returns the last translation in the ordered set where groupId = &#63; and portletId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public static Translation fetchByGroupIdAndPortletId_Last(
		long groupId, String portletId,
		OrderByComparator<Translation> orderByComparator) {

		return getPersistence().fetchByGroupIdAndPortletId_Last(
			groupId, portletId, orderByComparator);
	}

	/**
	 * Returns the translations before and after the current translation in the ordered set where groupId = &#63; and portletId = &#63;.
	 *
	 * @param translationId the primary key of the current translation
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	public static Translation[] findByGroupIdAndPortletId_PrevAndNext(
			long translationId, long groupId, String portletId,
			OrderByComparator<Translation> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchTranslationException {

		return getPersistence().findByGroupIdAndPortletId_PrevAndNext(
			translationId, groupId, portletId, orderByComparator);
	}

	/**
	 * Returns all the translations that the user has permission to view where groupId = &#63; and portletId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @return the matching translations that the user has permission to view
	 */
	public static List<Translation> filterFindByGroupIdAndPortletId(
		long groupId, String portletId) {

		return getPersistence().filterFindByGroupIdAndPortletId(
			groupId, portletId);
	}

	/**
	 * Returns a range of all the translations that the user has permission to view where groupId = &#63; and portletId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @return the range of matching translations that the user has permission to view
	 */
	public static List<Translation> filterFindByGroupIdAndPortletId(
		long groupId, String portletId, int start, int end) {

		return getPersistence().filterFindByGroupIdAndPortletId(
			groupId, portletId, start, end);
	}

	/**
	 * Returns an ordered range of all the translations that the user has permissions to view where groupId = &#63; and portletId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching translations that the user has permission to view
	 */
	public static List<Translation> filterFindByGroupIdAndPortletId(
		long groupId, String portletId, int start, int end,
		OrderByComparator<Translation> orderByComparator) {

		return getPersistence().filterFindByGroupIdAndPortletId(
			groupId, portletId, start, end, orderByComparator);
	}

	/**
	 * Returns the translations before and after the current translation in the ordered set of translations that the user has permission to view where groupId = &#63; and portletId = &#63;.
	 *
	 * @param translationId the primary key of the current translation
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	public static Translation[] filterFindByGroupIdAndPortletId_PrevAndNext(
			long translationId, long groupId, String portletId,
			OrderByComparator<Translation> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchTranslationException {

		return getPersistence().filterFindByGroupIdAndPortletId_PrevAndNext(
			translationId, groupId, portletId, orderByComparator);
	}

	/**
	 * Removes all the translations where groupId = &#63; and portletId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 */
	public static void removeByGroupIdAndPortletId(
		long groupId, String portletId) {

		getPersistence().removeByGroupIdAndPortletId(groupId, portletId);
	}

	/**
	 * Returns the number of translations where groupId = &#63; and portletId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @return the number of matching translations
	 */
	public static int countByGroupIdAndPortletId(
		long groupId, String portletId) {

		return getPersistence().countByGroupIdAndPortletId(groupId, portletId);
	}

	/**
	 * Returns the number of translations that the user has permission to view where groupId = &#63; and portletId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @return the number of matching translations that the user has permission to view
	 */
	public static int filterCountByGroupIdAndPortletId(
		long groupId, String portletId) {

		return getPersistence().filterCountByGroupIdAndPortletId(
			groupId, portletId);
	}

	/**
	 * Returns all the translations where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @return the matching translations
	 */
	public static List<Translation> findByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId,
		String cultureCode) {

		return getPersistence().findByPortletIdComponentIdCultureCode(
			groupId, portletId, componentId, cultureCode);
	}

	/**
	 * Returns a range of all the translations where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @return the range of matching translations
	 */
	public static List<Translation> findByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId, String cultureCode,
		int start, int end) {

		return getPersistence().findByPortletIdComponentIdCultureCode(
			groupId, portletId, componentId, cultureCode, start, end);
	}

	/**
	 * Returns an ordered range of all the translations where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching translations
	 */
	public static List<Translation> findByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId, String cultureCode,
		int start, int end, OrderByComparator<Translation> orderByComparator) {

		return getPersistence().findByPortletIdComponentIdCultureCode(
			groupId, portletId, componentId, cultureCode, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the translations where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching translations
	 */
	public static List<Translation> findByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId, String cultureCode,
		int start, int end, OrderByComparator<Translation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByPortletIdComponentIdCultureCode(
			groupId, portletId, componentId, cultureCode, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first translation in the ordered set where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public static Translation findByPortletIdComponentIdCultureCode_First(
			long groupId, String portletId, String componentId,
			String cultureCode,
			OrderByComparator<Translation> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchTranslationException {

		return getPersistence().findByPortletIdComponentIdCultureCode_First(
			groupId, portletId, componentId, cultureCode, orderByComparator);
	}

	/**
	 * Returns the first translation in the ordered set where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public static Translation fetchByPortletIdComponentIdCultureCode_First(
		long groupId, String portletId, String componentId, String cultureCode,
		OrderByComparator<Translation> orderByComparator) {

		return getPersistence().fetchByPortletIdComponentIdCultureCode_First(
			groupId, portletId, componentId, cultureCode, orderByComparator);
	}

	/**
	 * Returns the last translation in the ordered set where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public static Translation findByPortletIdComponentIdCultureCode_Last(
			long groupId, String portletId, String componentId,
			String cultureCode,
			OrderByComparator<Translation> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchTranslationException {

		return getPersistence().findByPortletIdComponentIdCultureCode_Last(
			groupId, portletId, componentId, cultureCode, orderByComparator);
	}

	/**
	 * Returns the last translation in the ordered set where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public static Translation fetchByPortletIdComponentIdCultureCode_Last(
		long groupId, String portletId, String componentId, String cultureCode,
		OrderByComparator<Translation> orderByComparator) {

		return getPersistence().fetchByPortletIdComponentIdCultureCode_Last(
			groupId, portletId, componentId, cultureCode, orderByComparator);
	}

	/**
	 * Returns the translations before and after the current translation in the ordered set where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * @param translationId the primary key of the current translation
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	public static Translation[]
			findByPortletIdComponentIdCultureCode_PrevAndNext(
				long translationId, long groupId, String portletId,
				String componentId, String cultureCode,
				OrderByComparator<Translation> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchTranslationException {

		return getPersistence().
			findByPortletIdComponentIdCultureCode_PrevAndNext(
				translationId, groupId, portletId, componentId, cultureCode,
				orderByComparator);
	}

	/**
	 * Returns all the translations that the user has permission to view where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @return the matching translations that the user has permission to view
	 */
	public static List<Translation> filterFindByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId,
		String cultureCode) {

		return getPersistence().filterFindByPortletIdComponentIdCultureCode(
			groupId, portletId, componentId, cultureCode);
	}

	/**
	 * Returns a range of all the translations that the user has permission to view where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @return the range of matching translations that the user has permission to view
	 */
	public static List<Translation> filterFindByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId, String cultureCode,
		int start, int end) {

		return getPersistence().filterFindByPortletIdComponentIdCultureCode(
			groupId, portletId, componentId, cultureCode, start, end);
	}

	/**
	 * Returns an ordered range of all the translations that the user has permissions to view where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching translations that the user has permission to view
	 */
	public static List<Translation> filterFindByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId, String cultureCode,
		int start, int end, OrderByComparator<Translation> orderByComparator) {

		return getPersistence().filterFindByPortletIdComponentIdCultureCode(
			groupId, portletId, componentId, cultureCode, start, end,
			orderByComparator);
	}

	/**
	 * Returns the translations before and after the current translation in the ordered set of translations that the user has permission to view where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * @param translationId the primary key of the current translation
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	public static Translation[]
			filterFindByPortletIdComponentIdCultureCode_PrevAndNext(
				long translationId, long groupId, String portletId,
				String componentId, String cultureCode,
				OrderByComparator<Translation> orderByComparator)
		throws com.liferay.me.expense.manager.exception.
			NoSuchTranslationException {

		return getPersistence().
			filterFindByPortletIdComponentIdCultureCode_PrevAndNext(
				translationId, groupId, portletId, componentId, cultureCode,
				orderByComparator);
	}

	/**
	 * Removes all the translations where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 */
	public static void removeByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId,
		String cultureCode) {

		getPersistence().removeByPortletIdComponentIdCultureCode(
			groupId, portletId, componentId, cultureCode);
	}

	/**
	 * Returns the number of translations where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @return the number of matching translations
	 */
	public static int countByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId,
		String cultureCode) {

		return getPersistence().countByPortletIdComponentIdCultureCode(
			groupId, portletId, componentId, cultureCode);
	}

	/**
	 * Returns the number of translations that the user has permission to view where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @return the number of matching translations that the user has permission to view
	 */
	public static int filterCountByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId,
		String cultureCode) {

		return getPersistence().filterCountByPortletIdComponentIdCultureCode(
			groupId, portletId, componentId, cultureCode);
	}

	/**
	 * Caches the translation in the entity cache if it is enabled.
	 *
	 * @param translation the translation
	 */
	public static void cacheResult(Translation translation) {
		getPersistence().cacheResult(translation);
	}

	/**
	 * Caches the translations in the entity cache if it is enabled.
	 *
	 * @param translations the translations
	 */
	public static void cacheResult(List<Translation> translations) {
		getPersistence().cacheResult(translations);
	}

	/**
	 * Creates a new translation with the primary key. Does not add the translation to the database.
	 *
	 * @param translationId the primary key for the new translation
	 * @return the new translation
	 */
	public static Translation create(long translationId) {
		return getPersistence().create(translationId);
	}

	/**
	 * Removes the translation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param translationId the primary key of the translation
	 * @return the translation that was removed
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	public static Translation remove(long translationId)
		throws com.liferay.me.expense.manager.exception.
			NoSuchTranslationException {

		return getPersistence().remove(translationId);
	}

	public static Translation updateImpl(Translation translation) {
		return getPersistence().updateImpl(translation);
	}

	/**
	 * Returns the translation with the primary key or throws a <code>NoSuchTranslationException</code> if it could not be found.
	 *
	 * @param translationId the primary key of the translation
	 * @return the translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	public static Translation findByPrimaryKey(long translationId)
		throws com.liferay.me.expense.manager.exception.
			NoSuchTranslationException {

		return getPersistence().findByPrimaryKey(translationId);
	}

	/**
	 * Returns the translation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param translationId the primary key of the translation
	 * @return the translation, or <code>null</code> if a translation with the primary key could not be found
	 */
	public static Translation fetchByPrimaryKey(long translationId) {
		return getPersistence().fetchByPrimaryKey(translationId);
	}

	/**
	 * Returns all the translations.
	 *
	 * @return the translations
	 */
	public static List<Translation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the translations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @return the range of translations
	 */
	public static List<Translation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the translations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of translations
	 */
	public static List<Translation> findAll(
		int start, int end, OrderByComparator<Translation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the translations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TranslationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of translations
	 * @param end the upper bound of the range of translations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of translations
	 */
	public static List<Translation> findAll(
		int start, int end, OrderByComparator<Translation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the translations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of translations.
	 *
	 * @return the number of translations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TranslationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TranslationPersistence, TranslationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TranslationPersistence.class);

		ServiceTracker<TranslationPersistence, TranslationPersistence>
			serviceTracker =
				new ServiceTracker
					<TranslationPersistence, TranslationPersistence>(
						bundle.getBundleContext(), TranslationPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}