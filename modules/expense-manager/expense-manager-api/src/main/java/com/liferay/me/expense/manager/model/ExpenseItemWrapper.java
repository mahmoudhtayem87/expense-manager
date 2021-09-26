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
 * This class is a wrapper for {@link ExpenseItem}.
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseItem
 * @generated
 */
public class ExpenseItemWrapper
	extends BaseModelWrapper<ExpenseItem>
	implements ExpenseItem, ModelWrapper<ExpenseItem> {

	public ExpenseItemWrapper(ExpenseItem expenseItem) {
		super(expenseItem);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("expenseItemId", getExpenseItemId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dateIncurred", getDateIncurred());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("type", getType());
		attributes.put("reimburse", isReimburse());
		attributes.put("amount", getAmount());
		attributes.put("expenseId", getExpenseId());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long expenseItemId = (Long)attributes.get("expenseItemId");

		if (expenseItemId != null) {
			setExpenseItemId(expenseItemId);
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

		Date dateIncurred = (Date)attributes.get("dateIncurred");

		if (dateIncurred != null) {
			setDateIncurred(dateIncurred);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long type = (Long)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Boolean reimburse = (Boolean)attributes.get("reimburse");

		if (reimburse != null) {
			setReimburse(reimburse);
		}

		Long amount = (Long)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Long expenseId = (Long)attributes.get("expenseId");

		if (expenseId != null) {
			setExpenseId(expenseId);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the amount of this expense item.
	 *
	 * @return the amount of this expense item
	 */
	@Override
	public Long getAmount() {
		return model.getAmount();
	}

	/**
	 * Returns the company ID of this expense item.
	 *
	 * @return the company ID of this expense item
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this expense item.
	 *
	 * @return the create date of this expense item
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the date incurred of this expense item.
	 *
	 * @return the date incurred of this expense item
	 */
	@Override
	public Date getDateIncurred() {
		return model.getDateIncurred();
	}

	/**
	 * Returns the description of this expense item.
	 *
	 * @return the description of this expense item
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the expense ID of this expense item.
	 *
	 * @return the expense ID of this expense item
	 */
	@Override
	public long getExpenseId() {
		return model.getExpenseId();
	}

	/**
	 * Returns the expense item ID of this expense item.
	 *
	 * @return the expense item ID of this expense item
	 */
	@Override
	public long getExpenseItemId() {
		return model.getExpenseItemId();
	}

	/**
	 * Returns the group ID of this expense item.
	 *
	 * @return the group ID of this expense item
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this expense item.
	 *
	 * @return the modified date of this expense item
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this expense item.
	 *
	 * @return the primary key of this expense item
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reimburse of this expense item.
	 *
	 * @return the reimburse of this expense item
	 */
	@Override
	public boolean getReimburse() {
		return model.getReimburse();
	}

	/**
	 * Returns the status of this expense item.
	 *
	 * @return the status of this expense item
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this expense item.
	 *
	 * @return the status by user ID of this expense item
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this expense item.
	 *
	 * @return the status by user name of this expense item
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this expense item.
	 *
	 * @return the status by user uuid of this expense item
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this expense item.
	 *
	 * @return the status date of this expense item
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the title of this expense item.
	 *
	 * @return the title of this expense item
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the type of this expense item.
	 *
	 * @return the type of this expense item
	 */
	@Override
	public long getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this expense item.
	 *
	 * @return the user ID of this expense item
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this expense item.
	 *
	 * @return the user name of this expense item
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this expense item.
	 *
	 * @return the user uuid of this expense item
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this expense item is approved.
	 *
	 * @return <code>true</code> if this expense item is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this expense item is denied.
	 *
	 * @return <code>true</code> if this expense item is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this expense item is a draft.
	 *
	 * @return <code>true</code> if this expense item is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this expense item is expired.
	 *
	 * @return <code>true</code> if this expense item is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this expense item is inactive.
	 *
	 * @return <code>true</code> if this expense item is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this expense item is incomplete.
	 *
	 * @return <code>true</code> if this expense item is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this expense item is pending.
	 *
	 * @return <code>true</code> if this expense item is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this expense item is reimburse.
	 *
	 * @return <code>true</code> if this expense item is reimburse; <code>false</code> otherwise
	 */
	@Override
	public boolean isReimburse() {
		return model.isReimburse();
	}

	/**
	 * Returns <code>true</code> if this expense item is scheduled.
	 *
	 * @return <code>true</code> if this expense item is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the amount of this expense item.
	 *
	 * @param amount the amount of this expense item
	 */
	@Override
	public void setAmount(Long amount) {
		model.setAmount(amount);
	}

	/**
	 * Sets the company ID of this expense item.
	 *
	 * @param companyId the company ID of this expense item
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this expense item.
	 *
	 * @param createDate the create date of this expense item
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the date incurred of this expense item.
	 *
	 * @param dateIncurred the date incurred of this expense item
	 */
	@Override
	public void setDateIncurred(Date dateIncurred) {
		model.setDateIncurred(dateIncurred);
	}

	/**
	 * Sets the description of this expense item.
	 *
	 * @param description the description of this expense item
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the expense ID of this expense item.
	 *
	 * @param expenseId the expense ID of this expense item
	 */
	@Override
	public void setExpenseId(long expenseId) {
		model.setExpenseId(expenseId);
	}

	/**
	 * Sets the expense item ID of this expense item.
	 *
	 * @param expenseItemId the expense item ID of this expense item
	 */
	@Override
	public void setExpenseItemId(long expenseItemId) {
		model.setExpenseItemId(expenseItemId);
	}

	/**
	 * Sets the group ID of this expense item.
	 *
	 * @param groupId the group ID of this expense item
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this expense item.
	 *
	 * @param modifiedDate the modified date of this expense item
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this expense item.
	 *
	 * @param primaryKey the primary key of this expense item
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this expense item is reimburse.
	 *
	 * @param reimburse the reimburse of this expense item
	 */
	@Override
	public void setReimburse(boolean reimburse) {
		model.setReimburse(reimburse);
	}

	/**
	 * Sets the status of this expense item.
	 *
	 * @param status the status of this expense item
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this expense item.
	 *
	 * @param statusByUserId the status by user ID of this expense item
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this expense item.
	 *
	 * @param statusByUserName the status by user name of this expense item
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this expense item.
	 *
	 * @param statusByUserUuid the status by user uuid of this expense item
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this expense item.
	 *
	 * @param statusDate the status date of this expense item
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this expense item.
	 *
	 * @param title the title of this expense item
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the type of this expense item.
	 *
	 * @param type the type of this expense item
	 */
	@Override
	public void setType(long type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this expense item.
	 *
	 * @param userId the user ID of this expense item
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this expense item.
	 *
	 * @param userName the user name of this expense item
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this expense item.
	 *
	 * @param userUuid the user uuid of this expense item
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected ExpenseItemWrapper wrap(ExpenseItem expenseItem) {
		return new ExpenseItemWrapper(expenseItem);
	}

}