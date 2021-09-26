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
 * This class is used by SOAP remote services, specifically {@link com.liferay.me.expense.manager.service.http.ExpenseServiceSoap}.
 *
 * @author Mahmoud Hussein Tayem
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ExpenseSoap implements Serializable {

	public static ExpenseSoap toSoapModel(Expense model) {
		ExpenseSoap soapModel = new ExpenseSoap();

		soapModel.setExpenseId(model.getExpenseId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setCurrency(model.getCurrency());
		soapModel.setExpenseDate(model.getExpenseDate());
		soapModel.setAmount(model.getAmount());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static ExpenseSoap[] toSoapModels(Expense[] models) {
		ExpenseSoap[] soapModels = new ExpenseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ExpenseSoap[][] toSoapModels(Expense[][] models) {
		ExpenseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ExpenseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ExpenseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ExpenseSoap[] toSoapModels(List<Expense> models) {
		List<ExpenseSoap> soapModels = new ArrayList<ExpenseSoap>(
			models.size());

		for (Expense model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ExpenseSoap[soapModels.size()]);
	}

	public ExpenseSoap() {
	}

	public long getPrimaryKey() {
		return _expenseId;
	}

	public void setPrimaryKey(long pk) {
		setExpenseId(pk);
	}

	public long getExpenseId() {
		return _expenseId;
	}

	public void setExpenseId(long expenseId) {
		_expenseId = expenseId;
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

	public String getCurrency() {
		return _currency;
	}

	public void setCurrency(String currency) {
		_currency = currency;
	}

	public Date getExpenseDate() {
		return _expenseDate;
	}

	public void setExpenseDate(Date expenseDate) {
		_expenseDate = expenseDate;
	}

	public long getAmount() {
		return _amount;
	}

	public void setAmount(long amount) {
		_amount = amount;
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

	private long _expenseId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _description;
	private String _currency;
	private Date _expenseDate;
	private long _amount;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private int _status;

}