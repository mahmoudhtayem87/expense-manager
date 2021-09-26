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

import com.liferay.me.expense.manager.model.ExpenseItem;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ExpenseItem in entity cache.
 *
 * @author Mahmoud Hussein Tayem
 * @generated
 */
public class ExpenseItemCacheModel
	implements CacheModel<ExpenseItem>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ExpenseItemCacheModel)) {
			return false;
		}

		ExpenseItemCacheModel expenseItemCacheModel =
			(ExpenseItemCacheModel)object;

		if (expenseItemId == expenseItemCacheModel.expenseItemId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, expenseItemId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{expenseItemId=");
		sb.append(expenseItemId);
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
		sb.append(", dateIncurred=");
		sb.append(dateIncurred);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", type=");
		sb.append(type);
		sb.append(", reimburse=");
		sb.append(reimburse);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", expenseId=");
		sb.append(expenseId);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ExpenseItem toEntityModel() {
		ExpenseItemImpl expenseItemImpl = new ExpenseItemImpl();

		expenseItemImpl.setExpenseItemId(expenseItemId);
		expenseItemImpl.setGroupId(groupId);
		expenseItemImpl.setCompanyId(companyId);
		expenseItemImpl.setUserId(userId);

		if (userName == null) {
			expenseItemImpl.setUserName("");
		}
		else {
			expenseItemImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			expenseItemImpl.setCreateDate(null);
		}
		else {
			expenseItemImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			expenseItemImpl.setModifiedDate(null);
		}
		else {
			expenseItemImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (dateIncurred == Long.MIN_VALUE) {
			expenseItemImpl.setDateIncurred(null);
		}
		else {
			expenseItemImpl.setDateIncurred(new Date(dateIncurred));
		}

		if (title == null) {
			expenseItemImpl.setTitle("");
		}
		else {
			expenseItemImpl.setTitle(title);
		}

		if (description == null) {
			expenseItemImpl.setDescription("");
		}
		else {
			expenseItemImpl.setDescription(description);
		}

		expenseItemImpl.setType(type);
		expenseItemImpl.setReimburse(reimburse);
		expenseItemImpl.setAmount(amount);
		expenseItemImpl.setExpenseId(expenseId);
		expenseItemImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			expenseItemImpl.setStatusByUserName("");
		}
		else {
			expenseItemImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			expenseItemImpl.setStatusDate(null);
		}
		else {
			expenseItemImpl.setStatusDate(new Date(statusDate));
		}

		expenseItemImpl.setStatus(status);

		expenseItemImpl.resetOriginalValues();

		return expenseItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		expenseItemId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		dateIncurred = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();

		type = objectInput.readLong();

		reimburse = objectInput.readBoolean();

		amount = objectInput.readLong();

		expenseId = objectInput.readLong();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(expenseItemId);

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
		objectOutput.writeLong(dateIncurred);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(type);

		objectOutput.writeBoolean(reimburse);

		objectOutput.writeLong(amount);

		objectOutput.writeLong(expenseId);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		objectOutput.writeInt(status);
	}

	public long expenseItemId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long dateIncurred;
	public String title;
	public String description;
	public long type;
	public boolean reimburse;
	public long amount;
	public long expenseId;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public int status;

}