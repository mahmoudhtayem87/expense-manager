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

package com.liferay.me.expense.manager.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Translation}.
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @see Translation
 * @generated
 */
public class TranslationWrapper
	extends BaseModelWrapper<Translation>
	implements ModelWrapper<Translation>, Translation {

	public TranslationWrapper(Translation translation) {
		super(translation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("translationId", getTranslationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("portletId", getPortletId());
		attributes.put("componentId", getComponentId());
		attributes.put("key", getKey());
		attributes.put("cultureCode", getCultureCode());
		attributes.put("translationValue", getTranslationValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long translationId = (Long)attributes.get("translationId");

		if (translationId != null) {
			setTranslationId(translationId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String portletId = (String)attributes.get("portletId");

		if (portletId != null) {
			setPortletId(portletId);
		}

		String componentId = (String)attributes.get("componentId");

		if (componentId != null) {
			setComponentId(componentId);
		}

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		String cultureCode = (String)attributes.get("cultureCode");

		if (cultureCode != null) {
			setCultureCode(cultureCode);
		}

		String translationValue = (String)attributes.get("translationValue");

		if (translationValue != null) {
			setTranslationValue(translationValue);
		}
	}

	/**
	 * Returns the company ID of this translation.
	 *
	 * @return the company ID of this translation
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the component ID of this translation.
	 *
	 * @return the component ID of this translation
	 */
	@Override
	public String getComponentId() {
		return model.getComponentId();
	}

	/**
	 * Returns the create date of this translation.
	 *
	 * @return the create date of this translation
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the culture code of this translation.
	 *
	 * @return the culture code of this translation
	 */
	@Override
	public String getCultureCode() {
		return model.getCultureCode();
	}

	/**
	 * Returns the group ID of this translation.
	 *
	 * @return the group ID of this translation
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the key of this translation.
	 *
	 * @return the key of this translation
	 */
	@Override
	public String getKey() {
		return model.getKey();
	}

	/**
	 * Returns the modified date of this translation.
	 *
	 * @return the modified date of this translation
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the portlet ID of this translation.
	 *
	 * @return the portlet ID of this translation
	 */
	@Override
	public String getPortletId() {
		return model.getPortletId();
	}

	/**
	 * Returns the primary key of this translation.
	 *
	 * @return the primary key of this translation
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the translation ID of this translation.
	 *
	 * @return the translation ID of this translation
	 */
	@Override
	public long getTranslationId() {
		return model.getTranslationId();
	}

	/**
	 * Returns the translation value of this translation.
	 *
	 * @return the translation value of this translation
	 */
	@Override
	public String getTranslationValue() {
		return model.getTranslationValue();
	}

	/**
	 * Returns the user ID of this translation.
	 *
	 * @return the user ID of this translation
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this translation.
	 *
	 * @return the user name of this translation
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this translation.
	 *
	 * @return the user uuid of this translation
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this translation.
	 *
	 * @param companyId the company ID of this translation
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the component ID of this translation.
	 *
	 * @param componentId the component ID of this translation
	 */
	@Override
	public void setComponentId(String componentId) {
		model.setComponentId(componentId);
	}

	/**
	 * Sets the create date of this translation.
	 *
	 * @param createDate the create date of this translation
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the culture code of this translation.
	 *
	 * @param cultureCode the culture code of this translation
	 */
	@Override
	public void setCultureCode(String cultureCode) {
		model.setCultureCode(cultureCode);
	}

	/**
	 * Sets the group ID of this translation.
	 *
	 * @param groupId the group ID of this translation
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the key of this translation.
	 *
	 * @param key the key of this translation
	 */
	@Override
	public void setKey(String key) {
		model.setKey(key);
	}

	/**
	 * Sets the modified date of this translation.
	 *
	 * @param modifiedDate the modified date of this translation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the portlet ID of this translation.
	 *
	 * @param portletId the portlet ID of this translation
	 */
	@Override
	public void setPortletId(String portletId) {
		model.setPortletId(portletId);
	}

	/**
	 * Sets the primary key of this translation.
	 *
	 * @param primaryKey the primary key of this translation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the translation ID of this translation.
	 *
	 * @param translationId the translation ID of this translation
	 */
	@Override
	public void setTranslationId(long translationId) {
		model.setTranslationId(translationId);
	}

	/**
	 * Sets the translation value of this translation.
	 *
	 * @param translationValue the translation value of this translation
	 */
	@Override
	public void setTranslationValue(String translationValue) {
		model.setTranslationValue(translationValue);
	}

	/**
	 * Sets the user ID of this translation.
	 *
	 * @param userId the user ID of this translation
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this translation.
	 *
	 * @param userName the user name of this translation
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this translation.
	 *
	 * @param userUuid the user uuid of this translation
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected TranslationWrapper wrap(Translation translation) {
		return new TranslationWrapper(translation);
	}

}