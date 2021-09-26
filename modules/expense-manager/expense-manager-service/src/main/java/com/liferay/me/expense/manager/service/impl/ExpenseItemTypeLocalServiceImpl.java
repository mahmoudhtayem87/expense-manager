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

package com.liferay.me.expense.manager.service.impl;

import com.liferay.me.expense.manager.exception.NoSuchExpenseItemTypeException;
import com.liferay.me.expense.manager.model.ExpenseItem;
import com.liferay.me.expense.manager.model.ExpenseItemType;
import com.liferay.me.expense.manager.service.base.ExpenseItemTypeLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the expense item type local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.me.expense.manager.service.ExpenseItemTypeLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseItemTypeLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.me.expense.manager.model.ExpenseItemType",
	service = AopService.class
)
public class ExpenseItemTypeLocalServiceImpl
	extends ExpenseItemTypeLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.me.expense.manager.service.ExpenseItemTypeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.me.expense.manager.service.ExpenseItemTypeLocalServiceUtil</code>.
	 * */
	public ExpenseItemType getByExpenseTypeId(long expenseTypeId)
			throws NoSuchExpenseItemTypeException {
		return expenseItemTypePersistence.findByExpenseItemTypeId(expenseTypeId);
	}
	public List<ExpenseItemType> getExpenseItemTypes(long groupId)
	{
		return expenseItemTypePersistence.findByGroupId(groupId);
	}
	public int getExpenseItemTypesCount(long groupId)
	{
		return expenseItemTypePersistence.findByGroupId(groupId).size();
	}
	public List<ExpenseItemType> getExpenseItemTypes(long groupId,int start,int end)
	{
		return expenseItemTypePersistence.findByGroupId(groupId,start,end);
	}
	public void updateExpenseItemType(long expenseTypeId,String title,String value
			,ServiceContext serviceContext) throws PortalException {
		ExpenseItemType toBeUpdated =
				getExpenseItemType(expenseTypeId);
		toBeUpdated.setTitle(title);
		toBeUpdated.setValue(value);
		super.updateExpenseItemType(toBeUpdated);
	}
	public void deleteExpenseItemType(long expenseTypeId,ServiceContext serviceContext) throws PortalException {
		super.deleteExpenseItemType(expenseTypeId);
	}
	public ExpenseItemType addExpenseItem(long groupId,String title,String value,
										  ServiceContext serviceContext)
			throws PortalException
	{
		Group group = groupLocalService.getGroup(groupId);
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);
		// Generate primary key for the assignment.
		long expenseItemId = counterLocalService.increment(ExpenseItemType.class.getName());
		ExpenseItemType _expenseItemType = createExpenseItemType(expenseItemId);
		_expenseItemType.setGroupId(groupId);
		_expenseItemType.setUserId(userId);
		_expenseItemType.setUserName(user.getScreenName());
		_expenseItemType.setCreateDate(serviceContext.getCreateDate(new Date()));
		_expenseItemType.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		_expenseItemType.setTitle(title);
		_expenseItemType.setValue(value);
		return super.addExpenseItemType(_expenseItemType);
	}

}