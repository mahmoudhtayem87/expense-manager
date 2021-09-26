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

import com.liferay.me.expense.manager.model.Expense;
import com.liferay.me.expense.manager.model.ExpenseItem;
import com.liferay.me.expense.manager.service.base.ExpenseItemLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the expense item local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.me.expense.manager.service.ExpenseItemLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseItemLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.me.expense.manager.model.ExpenseItem",
	service = AopService.class
)
public class ExpenseItemLocalServiceImpl
	extends ExpenseItemLocalServiceBaseImpl {


	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.me.expense.manager.service.ExpenseItemLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.me.expense.manager.service.ExpenseItemLocalServiceUtil</code>.
	 */
	public List<ExpenseItem> getExpenseItemsByExpenseId(long expenseId)
	{
		return expenseItemPersistence.findByExpenseId(expenseId);
	}
	public long getExpenseItemsTotalByExpenseId(long expenseId)
	{
		List<ExpenseItem> data = expenseItemPersistence.findByExpenseId(expenseId);
		long total = data.stream().mapToLong(o->o.getAmount()).sum();
		return total;
	}
	public void deleteExpenseItemById(long expenseItemId)
	{
		expenseItemPersistence.removeByExpenseItemId(expenseItemId);
	}
	public ExpenseItem addExpenseItem(long groupId, long expenseId, long amount, boolean reimburse
			, String title, String description, Date dateIncurred
			,long type
			,  ServiceContext serviceContext) throws PortalException
	{
		Group group = groupLocalService.getGroup(groupId);
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);
		// Generate primary key for the assignment.
		long expenseItemId = counterLocalService.increment(ExpenseItem.class.getName());
		// Create assigment. This doesn't yet persist the entity.
		ExpenseItem _expenseItem = createExpenseItem(expenseItemId);
		_expenseItem.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		_expenseItem.setCreateDate(serviceContext.getModifiedDate(new Date()));
		_expenseItem.setUserName(user.getScreenName());
		_expenseItem.setGroupId(groupId);
		_expenseItem.setType(type);
		_expenseItem.setCompanyId(group.getCompanyId());
		_expenseItem.setExpenseId(expenseId);
		_expenseItem.setAmount(amount);
		_expenseItem.setReimburse(reimburse);
		_expenseItem.setTitle(title);
		_expenseItem.setDescription(description);
		_expenseItem.setDateIncurred(dateIncurred);
		return super.addExpenseItem(_expenseItem);
	}
	public ExpenseItem updateExpenseItem( long expenseItemId, long amount, boolean reimburse
			, String title, String description, Date dateIncurred
			,long type
			,  ServiceContext serviceContext) throws PortalException
	{
		ExpenseItem expenseItem = getExpenseItem(expenseItemId);
		expenseItem.setTitle(title);
		expenseItem.setDescription(description);
		expenseItem.setDateIncurred(dateIncurred);
		expenseItem.setType(type);
		expenseItem.setAmount(amount);
		expenseItem.setReimburse(reimburse);
		return  super.updateExpenseItem(expenseItem);
	}
	public void removeByExpenseId(long expenseId)
	{
		expenseItemPersistence.removeByExpenseId(expenseId);
	}
}