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

import com.liferay.me.expense.manager.model.ExpenseItemType;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ExpenseItemType in entity cache.
 *
 * @author Mahmoud Hussein Tayem
 * @generated
 */
public class ExpenseItemTypeCacheModel
	implements CacheModel<ExpenseItemType>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ExpenseItemTypeCacheModel)) {
			return false;
		}

		ExpenseItemTypeCacheModel expenseItemTypeCacheModel =
			(ExpenseItemTypeCacheModel)object;

		if (expenseItemTypeId == expenseItemTypeCacheModel.expenseItemTypeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, expenseItemTypeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{expenseItemTypeId=");
		sb.append(expenseItemTypeId);
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
		sb.append(", title=");
		sb.append(title);
		sb.append(", value=");
		sb.append(value);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ExpenseItemType toEntityModel() {
		ExpenseItemTypeImpl expenseItemTypeImpl = new ExpenseItemTypeImpl();

		expenseItemTypeImpl.setExpenseItemTypeId(expenseItemTypeId);
		expenseItemTypeImpl.setGroupId(groupId);
		expenseItemTypeImpl.setCompanyId(companyId);
		expenseItemTypeImpl.setUserId(userId);

		if (userName == null) {
			expenseItemTypeImpl.setUserName("");
		}
		else {
			expenseItemTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			expenseItemTypeImpl.setCreateDate(null);
		}
		else {
			expenseItemTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			expenseItemTypeImpl.setModifiedDate(null);
		}
		else {
			expenseItemTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			expenseItemTypeImpl.setTitle("");
		}
		else {
			expenseItemTypeImpl.setTitle(title);
		}

		if (value == null) {
			expenseItemTypeImpl.setValue("");
		}
		else {
			expenseItemTypeImpl.setValue(value);
		}

		expenseItemTypeImpl.setStatus(status);

		expenseItemTypeImpl.resetOriginalValues();

		return expenseItemTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		expenseItemTypeId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		value = objectInput.readUTF();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(expenseItemTypeId);

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

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (value == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(value);
		}

		objectOutput.writeInt(status);
	}

	public long expenseItemTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String value;
	public int status;

}