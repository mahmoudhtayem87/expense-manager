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

package com.liferay.me.expense.manager.service.impl;

import com.liferay.me.expense.manager.exception.NoSuchTranslationException;
import com.liferay.me.expense.manager.model.Expense;
import com.liferay.me.expense.manager.model.Translation;
import com.liferay.me.expense.manager.service.base.TranslationLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * The implementation of the translation local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.me.expense.manager.service.TranslationLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @see TranslationLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.me.expense.manager.model.Translation",
	service = AopService.class
)
public class TranslationLocalServiceImpl
	extends TranslationLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.me.expense.manager.service.TranslationLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.me.expense.manager.service.TranslationLocalServiceUtil</code>.
	 */
	public List<Translation> getTranslationByGroupId(long groupId, int start, int end)
	{
		List<Translation> Data =
		translationPersistence.findByGroupId(groupId,start,end);
		return Data;
	}
	public void updateTranslationByTranslationId(long translationId, String NewTranslationValue)
			throws PortalException {
		Translation tobeUpdated = getTranslation(translationId);
		tobeUpdated.setTranslationValue(NewTranslationValue);
		super.updateTranslation(tobeUpdated);

	}
	public static <T> Predicate<T> distinctByKey(
			Function<? super T, ?> keyExtractor) {

		Map<Object, Boolean> seen = new ConcurrentHashMap<>();
		return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
	public List<Translation> getTranslatedPortletsByGroupId(long groupId)
	{
		List<Translation> data = translationPersistence.findByGroupId(groupId).stream()
				.filter(distinctByKey(p->p.getPortletId())).collect(Collectors.toList());
		return data;
	}
	public List<Translation> getTranslatedComponentsByGroupIdPortletId(long groupId,String portletId)
	{
		List<Translation> translatedComponent = translationPersistence.findByGroupIdAndPortletId(groupId,portletId);
		List<Translation> data = translatedComponent.stream()
				.filter(distinctByKey(p->p.getComponentId())).collect(Collectors.toList());
		return data;
	}
	public List<Translation> getTranslationsByPortletIdComponentId
			(long groupId,String portletId,String componentId
					,String cultureCode,int start,int end)
	{
		return translationPersistence
				.findByPortletIdComponentIdCultureCode(groupId,portletId,componentId,cultureCode,start,end);
	}
	public int getTranslationsByPortletIdComponentIdCount
			(long groupId,String portletId,String componentId
					,String cultureCode)
	{
		return translationPersistence
				.findByPortletIdComponentIdCultureCode(groupId,portletId,componentId,cultureCode).size();
	}
	public int getTranslationCountByGroupId(long groupId)
	{
		return translationPersistence.findByGroupId(groupId).size();
	}
	public Translation addTranslationItem(long groupId, String key, String portletId
			, String cultureCode,String translationValue,String componentId,
										  ServiceContext serviceContext)
			throws PortalException
	{
		Group group = groupLocalService.getGroup(groupId);
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);
		// Generate primary key for the assignment.
		long translationId = counterLocalService.increment(Translation.class.getName());
		Translation _translationItem = createTranslation(translationId);

		_translationItem.setGroupId(groupId);
		_translationItem.setUserId(userId);
		_translationItem.setUserName(user.getScreenName());
		_translationItem.setCreateDate(serviceContext.getCreateDate(new Date()));
		_translationItem.setModifiedDate(serviceContext.getModifiedDate(new Date()));

		_translationItem.setKey(key);
		_translationItem.setPortletId(portletId);
		_translationItem.setComponentId(componentId);
		_translationItem.setCultureCode(cultureCode);
		_translationItem.setTranslationValue(translationValue);

		return super.addTranslation(_translationItem);
	}
	public List<Translation> getTranslationByPortletIdAndCulture
			(long groupId, String portletId, String cultureCode)
	{
		return translationPersistence
				.findByPortletIdAndCultureCode(groupId,portletId,cultureCode);
	}
	public List<Translation> getTranslationByPortletIdAndComponentIdAndCulture
			(long groupId, String portletId,String componentId, String cultureCode)
	{
		return translationPersistence
				.findByPortletIdComponentIdCultureCode(groupId,portletId,componentId,cultureCode);
	}
	public List<Translation> getTranslationByPortletIdAndComponentIdAndCulture
			(long groupId, String portletId,String componentId, String cultureCode,List<String> keys)
	{
		return translationPersistence
				.findByPortletIdComponentIdCultureCode(groupId,portletId,componentId,cultureCode);
	}
	public void removeByTranslationId(long translationId) throws NoSuchTranslationException {
		translationPersistence.removeByTranslationId(translationId);
	}
	public Translation updateByTranslationId(long translationId, String newTranslationValue)
			throws PortalException {
		Translation toBeUpdated = getTranslation(translationId);
		toBeUpdated.setTranslationValue(newTranslationValue);;
		return translationPersistence.update(toBeUpdated);
	}
	public void removeByGroupId(long groupId)
	{
		translationPersistence.removeByGroupId(groupId);
	}
}