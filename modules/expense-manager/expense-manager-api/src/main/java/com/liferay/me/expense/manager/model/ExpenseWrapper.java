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
 * This class is a wrapper for {@link Expense}.
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @see Expense
 * @generated
 */
public class ExpenseWrapper
	extends BaseModelWrapper<Expense>
	implements Expense, ModelWrapper<Expense> {

	public ExpenseWrapper(Expense expense) {
		super(expense);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("expenseId", getExpenseId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("currency", getCurrency());
		attributes.put("expenseDate", getExpenseDate());
		attributes.put("amount", getAmount());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long expenseId = (Long)attributes.get("expenseId");

		if (expenseId != null) {
			setExpenseId(expenseId);
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

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		Date expenseDate = (Date)attributes.get("expenseDate");

		if (expenseDate != null) {
			setExpenseDate(expenseDate);
		}

		Long amount = (Long)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
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
	 * Returns the amount of this expense.
	 *
	 * @return the amount of this expense
	 */
	@Override
	public long getAmount() {
		return model.getAmount();
	}

	/**
	 * Returns the company ID of this expense.
	 *
	 * @return the company ID of this expense
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this expense.
	 *
	 * @return the create date of this expense
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the currency of this expense.
	 *
	 * @return the currency of this expense
	 */
	@Override
	public String getCurrency() {
		return model.getCurrency();
	}

	/**
	 * Returns the description of this expense.
	 *
	 * @return the description of this expense
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the expense date of this expense.
	 *
	 * @return the expense date of this expense
	 */
	@Override
	public Date getExpenseDate() {
		return model.getExpenseDate();
	}

	/**
	 * Returns the expense ID of this expense.
	 *
	 * @return the expense ID of this expense
	 */
	@Override
	public long getExpenseId() {
		return model.getExpenseId();
	}

	/**
	 * Returns the group ID of this expense.
	 *
	 * @return the group ID of this expense
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this expense.
	 *
	 * @return the modified date of this expense
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this expense.
	 *
	 * @return the primary key of this expense
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this expense.
	 *
	 * @return the status of this expense
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this expense.
	 *
	 * @return the status by user ID of this expense
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this expense.
	 *
	 * @return the status by user name of this expense
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this expense.
	 *
	 * @return the status by user uuid of this expense
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this expense.
	 *
	 * @return the status date of this expense
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the title of this expense.
	 *
	 * @return the title of this expense
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this expense.
	 *
	 * @return the user ID of this expense
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this expense.
	 *
	 * @return the user name of this expense
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this expense.
	 *
	 * @return the user uuid of this expense
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this expense is approved.
	 *
	 * @return <code>true</code> if this expense is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this expense is denied.
	 *
	 * @return <code>true</code> if this expense is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this expense is a draft.
	 *
	 * @return <code>true</code> if this expense is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this expense is expired.
	 *
	 * @return <code>true</code> if this expense is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this expense is inactive.
	 *
	 * @return <code>true</code> if this expense is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this expense is incomplete.
	 *
	 * @return <code>true</code> if this expense is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this expense is pending.
	 *
	 * @return <code>true</code> if this expense is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this expense is scheduled.
	 *
	 * @return <code>true</code> if this expense is scheduled; <code>false</code> otherwise
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
	 * Sets the amount of this expense.
	 *
	 * @param amount the amount of this expense
	 */
	@Override
	public void setAmount(long amount) {
		model.setAmount(amount);
	}

	/**
	 * Sets the company ID of this expense.
	 *
	 * @param companyId the company ID of this expense
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this expense.
	 *
	 * @param createDate the create date of this expense
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the currency of this expense.
	 *
	 * @param currency the currency of this expense
	 */
	@Override
	public void setCurrency(String currency) {
		model.setCurrency(currency);
	}

	/**
	 * Sets the description of this expense.
	 *
	 * @param description the description of this expense
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the expense date of this expense.
	 *
	 * @param expenseDate the expense date of this expense
	 */
	@Override
	public void setExpenseDate(Date expenseDate) {
		model.setExpenseDate(expenseDate);
	}

	/**
	 * Sets the expense ID of this expense.
	 *
	 * @param expenseId the expense ID of this expense
	 */
	@Override
	public void setExpenseId(long expenseId) {
		model.setExpenseId(expenseId);
	}

	/**
	 * Sets the group ID of this expense.
	 *
	 * @param groupId the group ID of this expense
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this expense.
	 *
	 * @param modifiedDate the modified date of this expense
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this expense.
	 *
	 * @param primaryKey the primary key of this expense
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this expense.
	 *
	 * @param status the status of this expense
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this expense.
	 *
	 * @param statusByUserId the status by user ID of this expense
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this expense.
	 *
	 * @param statusByUserName the status by user name of this expense
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this expense.
	 *
	 * @param statusByUserUuid the status by user uuid of this expense
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this expense.
	 *
	 * @param statusDate the status date of this expense
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this expense.
	 *
	 * @param title the title of this expense
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this expense.
	 *
	 * @param userId the user ID of this expense
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this expense.
	 *
	 * @param userName the user name of this expense
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this expense.
	 *
	 * @param userUuid the user uuid of this expense
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected ExpenseWrapper wrap(Expense expense) {
		return new ExpenseWrapper(expense);
	}

}