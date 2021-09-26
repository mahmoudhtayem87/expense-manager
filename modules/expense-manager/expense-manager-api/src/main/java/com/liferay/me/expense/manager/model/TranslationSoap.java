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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.me.expense.manager.service.http.TranslationServiceSoap}.
 *
 * @author Mahmoud Hussein Tayem
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class TranslationSoap implements Serializable {

	public static TranslationSoap toSoapModel(Translation model) {
		TranslationSoap soapModel = new TranslationSoap();

		soapModel.setTranslationId(model.getTranslationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPortletId(model.getPortletId());
		soapModel.setComponentId(model.getComponentId());
		soapModel.setKey(model.getKey());
		soapModel.setCultureCode(model.getCultureCode());
		soapModel.setTranslationValue(model.getTranslationValue());

		return soapModel;
	}

	public static TranslationSoap[] toSoapModels(Translation[] models) {
		TranslationSoap[] soapModels = new TranslationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TranslationSoap[][] toSoapModels(Translation[][] models) {
		TranslationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TranslationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TranslationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TranslationSoap[] toSoapModels(List<Translation> models) {
		List<TranslationSoap> soapModels = new ArrayList<TranslationSoap>(
			models.size());

		for (Translation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TranslationSoap[soapModels.size()]);
	}

	public TranslationSoap() {
	}

	public long getPrimaryKey() {
		return _translationId;
	}

	public void setPrimaryKey(long pk) {
		setTranslationId(pk);
	}

	public long getTranslationId() {
		return _translationId;
	}

	public void setTranslationId(long translationId) {
		_translationId = translationId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getPortletId() {
		return _portletId;
	}

	public void setPortletId(String portletId) {
		_portletId = portletId;
	}

	public String getComponentId() {
		return _componentId;
	}

	public void setComponentId(String componentId) {
		_componentId = componentId;
	}

	public String getKey() {
		return _key;
	}

	public void setKey(String key) {
		_key = key;
	}

	public String getCultureCode() {
		return _cultureCode;
	}

	public void setCultureCode(String cultureCode) {
		_cultureCode = cultureCode;
	}

	public String getTranslationValue() {
		return _translationValue;
	}

	public void setTranslationValue(String translationValue) {
		_translationValue = translationValue;
	}

	private long _translationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _portletId;
	private String _componentId;
	private String _key;
	private String _cultureCode;
	private String _translationValue;

}