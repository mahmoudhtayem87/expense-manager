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

import com.liferay.me.expense.manager.exception.NoSuchTranslationException;
import com.liferay.me.expense.manager.model.Translation;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the translation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @see TranslationUtil
 * @generated
 */
@ProviderType
public interface TranslationPersistence extends BasePersistence<Translation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TranslationUtil} to access the translation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the translation where translationId = &#63; or throws a <code>NoSuchTranslationException</code> if it could not be found.
	 *
	 * @param translationId the translation ID
	 * @return the matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public Translation findByTranslationId(long translationId)
		throws NoSuchTranslationException;

	/**
	 * Returns the translation where translationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param translationId the translation ID
	 * @return the matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public Translation fetchByTranslationId(long translationId);

	/**
	 * Returns the translation where translationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param translationId the translation ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public Translation fetchByTranslationId(
		long translationId, boolean useFinderCache);

	/**
	 * Removes the translation where translationId = &#63; from the database.
	 *
	 * @param translationId the translation ID
	 * @return the translation that was removed
	 */
	public Translation removeByTranslationId(long translationId)
		throws NoSuchTranslationException;

	/**
	 * Returns the number of translations where translationId = &#63;.
	 *
	 * @param translationId the translation ID
	 * @return the number of matching translations
	 */
	public int countByTranslationId(long translationId);

	/**
	 * Returns all the translations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching translations
	 */
	public java.util.List<Translation> findByGroupId(long groupId);

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
	public java.util.List<Translation> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Translation> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator);

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
	public java.util.List<Translation> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first translation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public Translation findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Translation>
				orderByComparator)
		throws NoSuchTranslationException;

	/**
	 * Returns the first translation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public Translation fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator);

	/**
	 * Returns the last translation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public Translation findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Translation>
				orderByComparator)
		throws NoSuchTranslationException;

	/**
	 * Returns the last translation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public Translation fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator);

	/**
	 * Returns the translations before and after the current translation in the ordered set where groupId = &#63;.
	 *
	 * @param translationId the primary key of the current translation
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	public Translation[] findByGroupId_PrevAndNext(
			long translationId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Translation>
				orderByComparator)
		throws NoSuchTranslationException;

	/**
	 * Returns all the translations that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching translations that the user has permission to view
	 */
	public java.util.List<Translation> filterFindByGroupId(long groupId);

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
	public java.util.List<Translation> filterFindByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Translation> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator);

	/**
	 * Returns the translations before and after the current translation in the ordered set of translations that the user has permission to view where groupId = &#63;.
	 *
	 * @param translationId the primary key of the current translation
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	public Translation[] filterFindByGroupId_PrevAndNext(
			long translationId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Translation>
				orderByComparator)
		throws NoSuchTranslationException;

	/**
	 * Removes all the translations where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of translations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching translations
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of translations that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching translations that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the translations where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @return the matching translations
	 */
	public java.util.List<Translation> findByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode);

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
	public java.util.List<Translation> findByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode, int start, int end);

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
	public java.util.List<Translation> findByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator);

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
	public java.util.List<Translation> findByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator,
		boolean useFinderCache);

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
	public Translation findByPortletIdAndCultureCode_First(
			long groupId, String portletId, String cultureCode,
			com.liferay.portal.kernel.util.OrderByComparator<Translation>
				orderByComparator)
		throws NoSuchTranslationException;

	/**
	 * Returns the first translation in the ordered set where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public Translation fetchByPortletIdAndCultureCode_First(
		long groupId, String portletId, String cultureCode,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator);

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
	public Translation findByPortletIdAndCultureCode_Last(
			long groupId, String portletId, String cultureCode,
			com.liferay.portal.kernel.util.OrderByComparator<Translation>
				orderByComparator)
		throws NoSuchTranslationException;

	/**
	 * Returns the last translation in the ordered set where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public Translation fetchByPortletIdAndCultureCode_Last(
		long groupId, String portletId, String cultureCode,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator);

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
	public Translation[] findByPortletIdAndCultureCode_PrevAndNext(
			long translationId, long groupId, String portletId,
			String cultureCode,
			com.liferay.portal.kernel.util.OrderByComparator<Translation>
				orderByComparator)
		throws NoSuchTranslationException;

	/**
	 * Returns all the translations that the user has permission to view where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @return the matching translations that the user has permission to view
	 */
	public java.util.List<Translation> filterFindByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode);

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
	public java.util.List<Translation> filterFindByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode, int start, int end);

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
	public java.util.List<Translation> filterFindByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator);

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
	public Translation[] filterFindByPortletIdAndCultureCode_PrevAndNext(
			long translationId, long groupId, String portletId,
			String cultureCode,
			com.liferay.portal.kernel.util.OrderByComparator<Translation>
				orderByComparator)
		throws NoSuchTranslationException;

	/**
	 * Removes all the translations where groupId = &#63; and portletId = &#63; and cultureCode = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 */
	public void removeByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode);

	/**
	 * Returns the number of translations where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @return the number of matching translations
	 */
	public int countByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode);

	/**
	 * Returns the number of translations that the user has permission to view where groupId = &#63; and portletId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param cultureCode the culture code
	 * @return the number of matching translations that the user has permission to view
	 */
	public int filterCountByPortletIdAndCultureCode(
		long groupId, String portletId, String cultureCode);

	/**
	 * Returns all the translations where groupId = &#63; and portletId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @return the matching translations
	 */
	public java.util.List<Translation> findByGroupIdAndPortletId(
		long groupId, String portletId);

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
	public java.util.List<Translation> findByGroupIdAndPortletId(
		long groupId, String portletId, int start, int end);

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
	public java.util.List<Translation> findByGroupIdAndPortletId(
		long groupId, String portletId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator);

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
	public java.util.List<Translation> findByGroupIdAndPortletId(
		long groupId, String portletId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first translation in the ordered set where groupId = &#63; and portletId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public Translation findByGroupIdAndPortletId_First(
			long groupId, String portletId,
			com.liferay.portal.kernel.util.OrderByComparator<Translation>
				orderByComparator)
		throws NoSuchTranslationException;

	/**
	 * Returns the first translation in the ordered set where groupId = &#63; and portletId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public Translation fetchByGroupIdAndPortletId_First(
		long groupId, String portletId,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator);

	/**
	 * Returns the last translation in the ordered set where groupId = &#63; and portletId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation
	 * @throws NoSuchTranslationException if a matching translation could not be found
	 */
	public Translation findByGroupIdAndPortletId_Last(
			long groupId, String portletId,
			com.liferay.portal.kernel.util.OrderByComparator<Translation>
				orderByComparator)
		throws NoSuchTranslationException;

	/**
	 * Returns the last translation in the ordered set where groupId = &#63; and portletId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching translation, or <code>null</code> if a matching translation could not be found
	 */
	public Translation fetchByGroupIdAndPortletId_Last(
		long groupId, String portletId,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator);

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
	public Translation[] findByGroupIdAndPortletId_PrevAndNext(
			long translationId, long groupId, String portletId,
			com.liferay.portal.kernel.util.OrderByComparator<Translation>
				orderByComparator)
		throws NoSuchTranslationException;

	/**
	 * Returns all the translations that the user has permission to view where groupId = &#63; and portletId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @return the matching translations that the user has permission to view
	 */
	public java.util.List<Translation> filterFindByGroupIdAndPortletId(
		long groupId, String portletId);

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
	public java.util.List<Translation> filterFindByGroupIdAndPortletId(
		long groupId, String portletId, int start, int end);

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
	public java.util.List<Translation> filterFindByGroupIdAndPortletId(
		long groupId, String portletId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator);

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
	public Translation[] filterFindByGroupIdAndPortletId_PrevAndNext(
			long translationId, long groupId, String portletId,
			com.liferay.portal.kernel.util.OrderByComparator<Translation>
				orderByComparator)
		throws NoSuchTranslationException;

	/**
	 * Removes all the translations where groupId = &#63; and portletId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 */
	public void removeByGroupIdAndPortletId(long groupId, String portletId);

	/**
	 * Returns the number of translations where groupId = &#63; and portletId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @return the number of matching translations
	 */
	public int countByGroupIdAndPortletId(long groupId, String portletId);

	/**
	 * Returns the number of translations that the user has permission to view where groupId = &#63; and portletId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @return the number of matching translations that the user has permission to view
	 */
	public int filterCountByGroupIdAndPortletId(long groupId, String portletId);

	/**
	 * Returns all the translations where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @return the matching translations
	 */
	public java.util.List<Translation> findByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId, String cultureCode);

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
	public java.util.List<Translation> findByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId, String cultureCode,
		int start, int end);

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
	public java.util.List<Translation> findByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId, String cultureCode,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator);

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
	public java.util.List<Translation> findByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId, String cultureCode,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator,
		boolean useFinderCache);

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
	public Translation findByPortletIdComponentIdCultureCode_First(
			long groupId, String portletId, String componentId,
			String cultureCode,
			com.liferay.portal.kernel.util.OrderByComparator<Translation>
				orderByComparator)
		throws NoSuchTranslationException;

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
	public Translation fetchByPortletIdComponentIdCultureCode_First(
		long groupId, String portletId, String componentId, String cultureCode,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator);

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
	public Translation findByPortletIdComponentIdCultureCode_Last(
			long groupId, String portletId, String componentId,
			String cultureCode,
			com.liferay.portal.kernel.util.OrderByComparator<Translation>
				orderByComparator)
		throws NoSuchTranslationException;

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
	public Translation fetchByPortletIdComponentIdCultureCode_Last(
		long groupId, String portletId, String componentId, String cultureCode,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator);

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
	public Translation[] findByPortletIdComponentIdCultureCode_PrevAndNext(
			long translationId, long groupId, String portletId,
			String componentId, String cultureCode,
			com.liferay.portal.kernel.util.OrderByComparator<Translation>
				orderByComparator)
		throws NoSuchTranslationException;

	/**
	 * Returns all the translations that the user has permission to view where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @return the matching translations that the user has permission to view
	 */
	public java.util.List<Translation>
		filterFindByPortletIdComponentIdCultureCode(
			long groupId, String portletId, String componentId,
			String cultureCode);

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
	public java.util.List<Translation>
		filterFindByPortletIdComponentIdCultureCode(
			long groupId, String portletId, String componentId,
			String cultureCode, int start, int end);

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
	public java.util.List<Translation>
		filterFindByPortletIdComponentIdCultureCode(
			long groupId, String portletId, String componentId,
			String cultureCode, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<Translation>
				orderByComparator);

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
	public Translation[]
			filterFindByPortletIdComponentIdCultureCode_PrevAndNext(
				long translationId, long groupId, String portletId,
				String componentId, String cultureCode,
				com.liferay.portal.kernel.util.OrderByComparator<Translation>
					orderByComparator)
		throws NoSuchTranslationException;

	/**
	 * Removes all the translations where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 */
	public void removeByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId, String cultureCode);

	/**
	 * Returns the number of translations where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @return the number of matching translations
	 */
	public int countByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId, String cultureCode);

	/**
	 * Returns the number of translations that the user has permission to view where groupId = &#63; and portletId = &#63; and componentId = &#63; and cultureCode = &#63;.
	 *
	 * @param groupId the group ID
	 * @param portletId the portlet ID
	 * @param componentId the component ID
	 * @param cultureCode the culture code
	 * @return the number of matching translations that the user has permission to view
	 */
	public int filterCountByPortletIdComponentIdCultureCode(
		long groupId, String portletId, String componentId, String cultureCode);

	/**
	 * Caches the translation in the entity cache if it is enabled.
	 *
	 * @param translation the translation
	 */
	public void cacheResult(Translation translation);

	/**
	 * Caches the translations in the entity cache if it is enabled.
	 *
	 * @param translations the translations
	 */
	public void cacheResult(java.util.List<Translation> translations);

	/**
	 * Creates a new translation with the primary key. Does not add the translation to the database.
	 *
	 * @param translationId the primary key for the new translation
	 * @return the new translation
	 */
	public Translation create(long translationId);

	/**
	 * Removes the translation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param translationId the primary key of the translation
	 * @return the translation that was removed
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	public Translation remove(long translationId)
		throws NoSuchTranslationException;

	public Translation updateImpl(Translation translation);

	/**
	 * Returns the translation with the primary key or throws a <code>NoSuchTranslationException</code> if it could not be found.
	 *
	 * @param translationId the primary key of the translation
	 * @return the translation
	 * @throws NoSuchTranslationException if a translation with the primary key could not be found
	 */
	public Translation findByPrimaryKey(long translationId)
		throws NoSuchTranslationException;

	/**
	 * Returns the translation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param translationId the primary key of the translation
	 * @return the translation, or <code>null</code> if a translation with the primary key could not be found
	 */
	public Translation fetchByPrimaryKey(long translationId);

	/**
	 * Returns all the translations.
	 *
	 * @return the translations
	 */
	public java.util.List<Translation> findAll();

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
	public java.util.List<Translation> findAll(int start, int end);

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
	public java.util.List<Translation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator);

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
	public java.util.List<Translation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Translation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the translations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of translations.
	 *
	 * @return the number of translations
	 */
	public int countAll();

}