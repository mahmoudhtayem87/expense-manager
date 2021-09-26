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
 * This class is used by SOAP remote services, specifically {@link com.liferay.me.expense.manager.service.http.ExpenseItemServiceSoap}.
 *
 * @author Mahmoud Hussein Tayem
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ExpenseItemSoap implements Serializable {

	public static ExpenseItemSoap toSoapModel(ExpenseItem model) {
		ExpenseItemSoap soapModel = new ExpenseItemSoap();

		soapModel.setExpenseItemId(model.getExpenseItemId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDateIncurred(model.getDateIncurred());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setType(model.getType());
		soapModel.setReimburse(model.isReimburse());
		soapModel.setAmount(model.getAmount());
		soapModel.setExpenseId(model.getExpenseId());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static ExpenseItemSoap[] toSoapModels(ExpenseItem[] models) {
		ExpenseItemSoap[] soapModels = new ExpenseItemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ExpenseItemSoap[][] toSoapModels(ExpenseItem[][] models) {
		ExpenseItemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ExpenseItemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ExpenseItemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ExpenseItemSoap[] toSoapModels(List<ExpenseItem> models) {
		List<ExpenseItemSoap> soapModels = new ArrayList<ExpenseItemSoap>(
			models.size());

		for (ExpenseItem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ExpenseItemSoap[soapModels.size()]);
	}

	public ExpenseItemSoap() {
	}

	public long getPrimaryKey() {
		return _expenseItemId;
	}

	public void setPrimaryKey(long pk) {
		setExpenseItemId(pk);
	}

	public long getExpenseItemId() {
		return _expenseItemId;
	}

	public void setExpenseItemId(long expenseItemId) {
		_expenseItemId = expenseItemId;
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

	public Date getDateIncurred() {
		return _dateIncurred;
	}

	public void setDateIncurred(Date dateIncurred) {
		_dateIncurred = dateIncurred;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getType() {
		return _type;
	}

	public void setType(long type) {
		_type = type;
	}

	public boolean getReimburse() {
		return _reimburse;
	}

	public boolean isReimburse() {
		return _reimburse;
	}

	public void setReimburse(boolean reimburse) {
		_reimburse = reimburse;
	}

	public Long getAmount() {
		return _amount;
	}

	public void setAmount(Long amount) {
		_amount = amount;
	}

	public long getExpenseId() {
		return _expenseId;
	}

	public void setExpenseId(long expenseId) {
		_expenseId = expenseId;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _expenseItemId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _dateIncurred;
	private String _title;
	private String _description;
	private long _type;
	private boolean _reimburse;
	private Long _amount;
	private long _expenseId;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private int _status;

}