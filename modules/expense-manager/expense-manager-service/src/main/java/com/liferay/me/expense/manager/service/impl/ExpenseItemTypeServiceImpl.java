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
import com.liferay.me.expense.manager.model.ExpenseItemType;
import com.liferay.me.expense.manager.service.base.ExpenseItemTypeServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * The implementation of the expense item type remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.me.expense.manager.service.ExpenseItemTypeService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseItemTypeServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=expensemanager",
		"json.web.service.context.path=ExpenseItemType"
	},
	service = AopService.class
)
public class ExpenseItemTypeServiceImpl extends ExpenseItemTypeServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.liferay.me.expense.manager.service.ExpenseItemTypeServiceUtil</code> to access the expense item type remote service.
	 */
	public List<ExpenseItemType> getExpenseItemTypes(long groupId)
	{
		return expenseItemTypeLocalService.getExpenseItemTypes(groupId);
	}
	public List<ExpenseItemType> getExpenseItemTypes(long groupId,int start,int end)
	{
		return expenseItemTypeLocalService.getExpenseItemTypes(groupId,start,end);
	}
	public int getExpenseItemTypesCount(long groupId)
	{
		return expenseItemTypeLocalService.getExpenseItemTypesCount(groupId);
	}
	public ExpenseItemType addExpenseItem(long groupId,String title,String value,
										  ServiceContext serviceContext)
			throws PortalException
	{
		return expenseItemTypeLocalService.addExpenseItem(groupId,title,value,serviceContext);
	}
	public ExpenseItemType getByExpenseTypeId(long expenseTypeId)
			throws NoSuchExpenseItemTypeException
	{
		return expenseItemTypeLocalService.getByExpenseTypeId(expenseTypeId);
	}
	public void updateExpenseItemType(long expenseTypeId,String title,String value
			,ServiceContext serviceContext) throws PortalException
	{
		expenseItemTypeLocalService.updateExpenseItemType(expenseTypeId,title,value,serviceContext);
	}
	public void deleteExpenseItemType(long expenseTypeId,ServiceContext serviceContext) throws PortalException {
		expenseItemTypeLocalService.deleteExpenseItemType(expenseTypeId,serviceContext);
	}

}