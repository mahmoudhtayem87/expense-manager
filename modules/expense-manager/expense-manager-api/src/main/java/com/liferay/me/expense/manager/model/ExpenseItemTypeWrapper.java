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
 * This class is a wrapper for {@link ExpenseItemType}.
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseItemType
 * @generated
 */
public class ExpenseItemTypeWrapper
	extends BaseModelWrapper<ExpenseItemType>
	implements ExpenseItemType, ModelWrapper<ExpenseItemType> {

	public ExpenseItemTypeWrapper(ExpenseItemType expenseItemType) {
		super(expenseItemType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("expenseItemTypeId", getExpenseItemTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("value", getValue());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long expenseItemTypeId = (Long)attributes.get("expenseItemTypeId");

		if (expenseItemTypeId != null) {
			setExpenseItemTypeId(expenseItemTypeId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the company ID of this expense item type.
	 *
	 * @return the company ID of this expense item type
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this expense item type.
	 *
	 * @return the create date of this expense item type
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the expense item type ID of this expense item type.
	 *
	 * @return the expense item type ID of this expense item type
	 */
	@Override
	public long getExpenseItemTypeId() {
		return model.getExpenseItemTypeId();
	}

	/**
	 * Returns the group ID of this expense item type.
	 *
	 * @return the group ID of this expense item type
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this expense item type.
	 *
	 * @return the modified date of this expense item type
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this expense item type.
	 *
	 * @return the primary key of this expense item type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this expense item type.
	 *
	 * @return the status of this expense item type
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the title of this expense item type.
	 *
	 * @return the title of this expense item type
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this expense item type.
	 *
	 * @return the user ID of this expense item type
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this expense item type.
	 *
	 * @return the user name of this expense item type
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this expense item type.
	 *
	 * @return the user uuid of this expense item type
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the value of this expense item type.
	 *
	 * @return the value of this expense item type
	 */
	@Override
	public String getValue() {
		return model.getValue();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this expense item type.
	 *
	 * @param companyId the company ID of this expense item type
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this expense item type.
	 *
	 * @param createDate the create date of this expense item type
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the expense item type ID of this expense item type.
	 *
	 * @param expenseItemTypeId the expense item type ID of this expense item type
	 */
	@Override
	public void setExpenseItemTypeId(long expenseItemTypeId) {
		model.setExpenseItemTypeId(expenseItemTypeId);
	}

	/**
	 * Sets the group ID of this expense item type.
	 *
	 * @param groupId the group ID of this expense item type
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this expense item type.
	 *
	 * @param modifiedDate the modified date of this expense item type
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this expense item type.
	 *
	 * @param primaryKey the primary key of this expense item type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this expense item type.
	 *
	 * @param status the status of this expense item type
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the title of this expense item type.
	 *
	 * @param title the title of this expense item type
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this expense item type.
	 *
	 * @param userId the user ID of this expense item type
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this expense item type.
	 *
	 * @param userName the user name of this expense item type
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this expense item type.
	 *
	 * @param userUuid the user uuid of this expense item type
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the value of this expense item type.
	 *
	 * @param value the value of this expense item type
	 */
	@Override
	public void setValue(String value) {
		model.setValue(value);
	}

	@Override
	protected ExpenseItemTypeWrapper wrap(ExpenseItemType expenseItemType) {
		return new ExpenseItemTypeWrapper(expenseItemType);
	}

}