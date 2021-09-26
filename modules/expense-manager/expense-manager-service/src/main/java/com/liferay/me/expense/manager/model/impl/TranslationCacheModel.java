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

package com.liferay.me.expense.manager.model.impl;

import com.liferay.me.expense.manager.model.Translation;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Translation in entity cache.
 *
 * @author Mahmoud Hussein Tayem
 * @generated
 */
public class TranslationCacheModel
	implements CacheModel<Translation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TranslationCacheModel)) {
			return false;
		}

		TranslationCacheModel translationCacheModel =
			(TranslationCacheModel)object;

		if (translationId == translationCacheModel.translationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, translationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{translationId=");
		sb.append(translationId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", portletId=");
		sb.append(portletId);
		sb.append(", componentId=");
		sb.append(componentId);
		sb.append(", key=");
		sb.append(key);
		sb.append(", cultureCode=");
		sb.append(cultureCode);
		sb.append(", translationValue=");
		sb.append(translationValue);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Translation toEntityModel() {
		TranslationImpl translationImpl = new TranslationImpl();

		translationImpl.setTranslationId(translationId);
		translationImpl.setGroupId(groupId);
		translationImpl.setCompanyId(companyId);
		translationImpl.setUserId(userId);

		if (userName == null) {
			translationImpl.setUserName("");
		}
		else {
			translationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			translationImpl.setCreateDate(null);
		}
		else {
			translationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			translationImpl.setModifiedDate(null);
		}
		else {
			translationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (portletId == null) {
			translationImpl.setPortletId("");
		}
		else {
			translationImpl.setPortletId(portletId);
		}

		if (componentId == null) {
			translationImpl.setComponentId("");
		}
		else {
			translationImpl.setComponentId(componentId);
		}

		if (key == null) {
			translationImpl.setKey("");
		}
		else {
			translationImpl.setKey(key);
		}

		if (cultureCode == null) {
			translationImpl.setCultureCode("");
		}
		else {
			translationImpl.setCultureCode(cultureCode);
		}

		if (translationValue == null) {
			translationImpl.setTranslationValue("");
		}
		else {
			translationImpl.setTranslationValue(translationValue);
		}

		translationImpl.resetOriginalValues();

		return translationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		translationId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		portletId = objectInput.readUTF();
		componentId = objectInput.readUTF();
		key = objectInput.readUTF();
		cultureCode = objectInput.readUTF();
		translationValue = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(translationId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (portletId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(portletId);
		}

		if (componentId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(componentId);
		}

		if (key == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(key);
		}

		if (cultureCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cultureCode);
		}

		if (translationValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(translationValue);
		}
	}

	public long translationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String portletId;
	public String componentId;
	public String key;
	public String cultureCode;
	public String translationValue;

}