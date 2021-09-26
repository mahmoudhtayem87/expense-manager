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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Expense service. Represents a row in the &quot;ExpenseManager_Expense&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.me.expense.manager.model.impl.ExpenseModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.me.expense.manager.model.impl.ExpenseImpl</code>.
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @see Expense
 * @generated
 */
@ProviderType
public interface ExpenseModel
	extends BaseModel<Expense>, GroupedModel, ShardedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a expense model instance should use the {@link Expense} interface instead.
	 */

	/**
	 * Returns the primary key of this expense.
	 *
	 * @return the primary key of this expense
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this expense.
	 *
	 * @param primaryKey the primary key of this expense
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the expense ID of this expense.
	 *
	 * @return the expense ID of this expense
	 */
	public long getExpenseId();

	/**
	 * Sets the expense ID of this expense.
	 *
	 * @param expenseId the expense ID of this expense
	 */
	public void setExpenseId(long expenseId);

	/**
	 * Returns the group ID of this expense.
	 *
	 * @return the group ID of this expense
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this expense.
	 *
	 * @param groupId the group ID of this expense
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this expense.
	 *
	 * @return the company ID of this expense
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this expense.
	 *
	 * @param companyId the company ID of this expense
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this expense.
	 *
	 * @return the user ID of this expense
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this expense.
	 *
	 * @param userId the user ID of this expense
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this expense.
	 *
	 * @return the user uuid of this expense
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this expense.
	 *
	 * @param userUuid the user uuid of this expense
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this expense.
	 *
	 * @return the user name of this expense
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this expense.
	 *
	 * @param userName the user name of this expense
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this expense.
	 *
	 * @return the create date of this expense
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this expense.
	 *
	 * @param createDate the create date of this expense
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this expense.
	 *
	 * @return the modified date of this expense
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this expense.
	 *
	 * @param modifiedDate the modified date of this expense
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the title of this expense.
	 *
	 * @return the title of this expense
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this expense.
	 *
	 * @param title the title of this expense
	 */
	public void setTitle(String title);

	/**
	 * Returns the description of this expense.
	 *
	 * @return the description of this expense
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this expense.
	 *
	 * @param description the description of this expense
	 */
	public void setDescription(String description);

	/**
	 * Returns the currency of this expense.
	 *
	 * @return the currency of this expense
	 */
	@AutoEscape
	public String getCurrency();

	/**
	 * Sets the currency of this expense.
	 *
	 * @param currency the currency of this expense
	 */
	public void setCurrency(String currency);

	/**
	 * Returns the expense date of this expense.
	 *
	 * @return the expense date of this expense
	 */
	public Date getExpenseDate();

	/**
	 * Sets the expense date of this expense.
	 *
	 * @param expenseDate the expense date of this expense
	 */
	public void setExpenseDate(Date expenseDate);

	/**
	 * Returns the amount of this expense.
	 *
	 * @return the amount of this expense
	 */
	public long getAmount();

	/**
	 * Sets the amount of this expense.
	 *
	 * @param amount the amount of this expense
	 */
	public void setAmount(long amount);

	/**
	 * Returns the status by user ID of this expense.
	 *
	 * @return the status by user ID of this expense
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this expense.
	 *
	 * @param statusByUserId the status by user ID of this expense
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this expense.
	 *
	 * @return the status by user uuid of this expense
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this expense.
	 *
	 * @param statusByUserUuid the status by user uuid of this expense
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this expense.
	 *
	 * @return the status by user name of this expense
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this expense.
	 *
	 * @param statusByUserName the status by user name of this expense
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this expense.
	 *
	 * @return the status date of this expense
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this expense.
	 *
	 * @param statusDate the status date of this expense
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the status of this expense.
	 *
	 * @return the status of this expense
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this expense.
	 *
	 * @param status the status of this expense
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns <code>true</code> if this expense is approved.
	 *
	 * @return <code>true</code> if this expense is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this expense is denied.
	 *
	 * @return <code>true</code> if this expense is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this expense is a draft.
	 *
	 * @return <code>true</code> if this expense is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this expense is expired.
	 *
	 * @return <code>true</code> if this expense is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this expense is inactive.
	 *
	 * @return <code>true</code> if this expense is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this expense is incomplete.
	 *
	 * @return <code>true</code> if this expense is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this expense is pending.
	 *
	 * @return <code>true</code> if this expense is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this expense is scheduled.
	 *
	 * @return <code>true</code> if this expense is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

}