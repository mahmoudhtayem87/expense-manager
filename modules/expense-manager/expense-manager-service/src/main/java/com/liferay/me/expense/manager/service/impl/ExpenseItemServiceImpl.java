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
import com.liferay.me.expense.manager.model.impl.ExpenseItemBaseImpl;
import com.liferay.me.expense.manager.service.base.ExpenseItemServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the expense item remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.me.expense.manager.service.ExpenseItemService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseItemServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=expensemanager",
		"json.web.service.context.path=ExpenseItem"
	},
	service = AopService.class
)
public class ExpenseItemServiceImpl extends ExpenseItemServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.liferay.me.expense.manager.service.ExpenseItemServiceUtil</code> to access the expense item remote service.
	 */
	public ExpenseItem addExpenseItem(long groupId, long expenseId, long amount, boolean reimburse
			, String title, String description, Date dateIncurred
			,long type,ServiceContext serviceContext) throws PortalException {
		return expenseItemLocalService.addExpenseItem(
				groupId,
				expenseId,
				amount,
				reimburse,
				title,description,dateIncurred,type,serviceContext);
	}
	public List<ExpenseItem> getExpenseItemsByExpenseId(long expenseId)
	{
		return expenseItemLocalService.getExpenseItemsByExpenseId(expenseId);
	}
	public long getExpenseItemsTotalByExpenseId(long expenseId)
	{
		return expenseItemLocalService.getExpenseItemsTotalByExpenseId(expenseId);
	}
	public void deleteExpenseItemById(long expenseItemId)
	{
		expenseItemLocalService.deleteExpenseItemById(expenseItemId);
	}
	public ExpenseItem updateExpenseItem( long expenseItemId, long amount, boolean reimburse
			, String title, String description, Date dateIncurred
			,long type
			,  ServiceContext serviceContext) throws PortalException
	{
		return expenseItemLocalService.updateExpenseItem(expenseItemId,  amount,  reimburse
			,  title,  description,  dateIncurred
			, type
			,   serviceContext);
	}
	public void removeByExpenseId(long expenseId)
	{
		expenseItemLocalService.removeByExpenseId(expenseId);
	}

}