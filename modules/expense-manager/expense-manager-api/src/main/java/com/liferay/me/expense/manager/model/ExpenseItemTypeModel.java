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

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the ExpenseItemType service. Represents a row in the &quot;ExpenseManager_ExpenseItemType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.me.expense.manager.model.impl.ExpenseItemTypeModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.me.expense.manager.model.impl.ExpenseItemTypeImpl</code>.
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseItemType
 * @generated
 */
@ProviderType
public interface ExpenseItemTypeModel
	extends BaseModel<ExpenseItemType>, GroupedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a expense item type model instance should use the {@link ExpenseItemType} interface instead.
	 */

	/**
	 * Returns the primary key of this expense item type.
	 *
	 * @return the primary key of this expense item type
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this expense item type.
	 *
	 * @param primaryKey the primary key of this expense item type
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the expense item type ID of this expense item type.
	 *
	 * @return the expense item type ID of this expense item type
	 */
	public long getExpenseItemTypeId();

	/**
	 * Sets the expense item type ID of this expense item type.
	 *
	 * @param expenseItemTypeId the expense item type ID of this expense item type
	 */
	public void setExpenseItemTypeId(long expenseItemTypeId);

	/**
	 * Returns the group ID of this expense item type.
	 *
	 * @return the group ID of this expense item type
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this expense item type.
	 *
	 * @param groupId the group ID of this expense item type
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this expense item type.
	 *
	 * @return the company ID of this expense item type
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this expense item type.
	 *
	 * @param companyId the company ID of this expense item type
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this expense item type.
	 *
	 * @return the user ID of this expense item type
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this expense item type.
	 *
	 * @param userId the user ID of this expense item type
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this expense item type.
	 *
	 * @return the user uuid of this expense item type
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this expense item type.
	 *
	 * @param userUuid the user uuid of this expense item type
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this expense item type.
	 *
	 * @return the user name of this expense item type
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this expense item type.
	 *
	 * @param userName the user name of this expense item type
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this expense item type.
	 *
	 * @return the create date of this expense item type
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this expense item type.
	 *
	 * @param createDate the create date of this expense item type
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this expense item type.
	 *
	 * @return the modified date of this expense item type
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this expense item type.
	 *
	 * @param modifiedDate the modified date of this expense item type
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the title of this expense item type.
	 *
	 * @return the title of this expense item type
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this expense item type.
	 *
	 * @param title the title of this expense item type
	 */
	public void setTitle(String title);

	/**
	 * Returns the value of this expense item type.
	 *
	 * @return the value of this expense item type
	 */
	@AutoEscape
	public String getValue();

	/**
	 * Sets the value of this expense item type.
	 *
	 * @param value the value of this expense item type
	 */
	public void setValue(String value);

	/**
	 * Returns the status of this expense item type.
	 *
	 * @return the status of this expense item type
	 */
	public int getStatus();

	/**
	 * Sets the status of this expense item type.
	 *
	 * @param status the status of this expense item type
	 */
	public void setStatus(int status);

}