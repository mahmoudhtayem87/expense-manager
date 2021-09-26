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
import com.liferay.me.expense.manager.model.Translation;
import com.liferay.me.expense.manager.service.base.TranslationServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * The implementation of the translation remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.me.expense.manager.service.TranslationService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @see TranslationServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=expensemanager",
		"json.web.service.context.path=Translation"
	},
	service = AopService.class
)
public class TranslationServiceImpl extends TranslationServiceBaseImpl {

	public Translation addTranslationItem(long groupId, String key, String portletId
			, String cultureCode,String translationValue,String componentId,
										  ServiceContext serviceContext) throws PortalException {
		return translationLocalService.addTranslationItem( groupId,  key,  portletId
			,  cultureCode, translationValue,componentId,
			 serviceContext);
	}
	public List<Translation> getTranslationByPortletIdAndComponentIdAndCulture
			(long groupId, String portletId,String componentId, String cultureCode)
	{
		return translationLocalService
				.getTranslationByPortletIdAndComponentIdAndCulture(groupId,portletId,componentId,cultureCode);
	}
	public void removeByGroupId(long groupId)
	{
		translationLocalService.removeByGroupId(groupId);
	}
	public List<Translation> getTranslationByPortletIdAndCulture
	(long groupId, String portletId, String cultureCode)
	{
		return translationLocalService.getTranslationByPortletIdAndCulture( groupId,  portletId,  cultureCode);
	}
	public void removeByTranslationId(long translationId) throws NoSuchTranslationException {
		translationLocalService.removeByTranslationId(translationId);
	}
	public void updateTranslationByTranslationId(long translationId, String NewTranslationValue) throws PortalException {
		translationLocalService.updateTranslationByTranslationId(translationId,NewTranslationValue);
	}
	public List<Translation> getTranslationByGroupId(long groupId, int start, int end)
	{
		return translationLocalService.getTranslationByGroupId(groupId,start,end);
	}
	public int getTranslationCountByGroupId(long groupId)
	{
		return translationLocalService.getTranslationCountByGroupId(groupId);
	}
	public Translation updateByTranslationId(long translationId, String newTranslationValue)
			throws PortalException {
		return translationLocalService.updateByTranslationId(translationId,newTranslationValue);
	}

	public List<Translation> getTranslatedPortletsByGroupId(long groupId)
	{
		return translationLocalService.getTranslatedPortletsByGroupId(groupId);
	}
	public List<Translation> getTranslatedComponentsByGroupIdPortletId(long groupId,String portletId)
	{
		return translationLocalService.getTranslatedComponentsByGroupIdPortletId(groupId,portletId);
	}
	public List<Translation> getTranslationsByPortletIdComponentId(long groupId,String portletId,String componentId,String cultureCode,int start,int end)
	{
		return translationLocalService.getTranslationsByPortletIdComponentId( groupId, portletId, componentId, cultureCode,start,end);
	}
	public int getTranslationsByPortletIdComponentIdCount(long groupId,String portletId,String componentId,String cultureCode)
	{
		return translationLocalService.getTranslationsByPortletIdComponentIdCount( groupId, portletId, componentId, cultureCode);
	}
}