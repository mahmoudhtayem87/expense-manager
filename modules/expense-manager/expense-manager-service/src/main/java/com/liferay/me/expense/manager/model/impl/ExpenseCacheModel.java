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

import com.liferay.me.expense.manager.model.Expense;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Expense in entity cache.
 *
 * @author Mahmoud Hussein Tayem
 * @generated
 */
public class ExpenseCacheModel implements CacheModel<Expense>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ExpenseCacheModel)) {
			return false;
		}

		ExpenseCacheModel expenseCacheModel = (ExpenseCacheModel)object;

		if (expenseId == expenseCacheModel.expenseId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, expenseId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{expenseId=");
		sb.append(expenseId);
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
		sb.append(", description=");
		sb.append(description);
		sb.append(", currency=");
		sb.append(currency);
		sb.append(", expenseDate=");
		sb.append(expenseDate);
		sb.append(", amount=");
		sb.append(amount);
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
	public Expense toEntityModel() {
		ExpenseImpl expenseImpl = new ExpenseImpl();

		expenseImpl.setExpenseId(expenseId);
		expenseImpl.setGroupId(groupId);
		expenseImpl.setCompanyId(companyId);
		expenseImpl.setUserId(userId);

		if (userName == null) {
			expenseImpl.setUserName("");
		}
		else {
			expenseImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			expenseImpl.setCreateDate(null);
		}
		else {
			expenseImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			expenseImpl.setModifiedDate(null);
		}
		else {
			expenseImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			expenseImpl.setTitle("");
		}
		else {
			expenseImpl.setTitle(title);
		}

		if (description == null) {
			expenseImpl.setDescription("");
		}
		else {
			expenseImpl.setDescription(description);
		}

		if (currency == null) {
			expenseImpl.setCurrency("");
		}
		else {
			expenseImpl.setCurrency(currency);
		}

		if (expenseDate == Long.MIN_VALUE) {
			expenseImpl.setExpenseDate(null);
		}
		else {
			expenseImpl.setExpenseDate(new Date(expenseDate));
		}

		expenseImpl.setAmount(amount);
		expenseImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			expenseImpl.setStatusByUserName("");
		}
		else {
			expenseImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			expenseImpl.setStatusDate(null);
		}
		else {
			expenseImpl.setStatusDate(new Date(statusDate));
		}

		expenseImpl.setStatus(status);

		expenseImpl.resetOriginalValues();

		return expenseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		expenseId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		currency = objectInput.readUTF();
		expenseDate = objectInput.readLong();

		amount = objectInput.readLong();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(expenseId);

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

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (currency == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(currency);
		}

		objectOutput.writeLong(expenseDate);

		objectOutput.writeLong(amount);

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

	public long expenseId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String description;
	public String currency;
	public long expenseDate;
	public long amount;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public int status;

}