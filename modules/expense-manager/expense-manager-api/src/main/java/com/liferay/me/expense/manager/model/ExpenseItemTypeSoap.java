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
 * This class is used by SOAP remote services, specifically {@link com.liferay.me.expense.manager.service.http.ExpenseItemTypeServiceSoap}.
 *
 * @author Mahmoud Hussein Tayem
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ExpenseItemTypeSoap implements Serializable {

	public static ExpenseItemTypeSoap toSoapModel(ExpenseItemType model) {
		ExpenseItemTypeSoap soapModel = new ExpenseItemTypeSoap();

		soapModel.setExpenseItemTypeId(model.getExpenseItemTypeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setValue(model.getValue());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static ExpenseItemTypeSoap[] toSoapModels(ExpenseItemType[] models) {
		ExpenseItemTypeSoap[] soapModels =
			new ExpenseItemTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ExpenseItemTypeSoap[][] toSoapModels(
		ExpenseItemType[][] models) {

		ExpenseItemTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ExpenseItemTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ExpenseItemTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ExpenseItemTypeSoap[] toSoapModels(
		List<ExpenseItemType> models) {

		List<ExpenseItemTypeSoap> soapModels =
			new ArrayList<ExpenseItemTypeSoap>(models.size());

		for (ExpenseItemType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ExpenseItemTypeSoap[soapModels.size()]);
	}

	public ExpenseItemTypeSoap() {
	}

	public long getPrimaryKey() {
		return _expenseItemTypeId;
	}

	public void setPrimaryKey(long pk) {
		setExpenseItemTypeId(pk);
	}

	public long getExpenseItemTypeId() {
		return _expenseItemTypeId;
	}

	public void setExpenseItemTypeId(long expenseItemTypeId) {
		_expenseItemTypeId = expenseItemTypeId;
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

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _expenseItemTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _value;
	private int _status;

}