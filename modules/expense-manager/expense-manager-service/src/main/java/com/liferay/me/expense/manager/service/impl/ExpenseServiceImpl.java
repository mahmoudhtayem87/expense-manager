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

import com.liferay.me.expense.manager.constants.ExpenseConstants;
import com.liferay.me.expense.manager.exception.NoSuchExpenseException;
import com.liferay.me.expense.manager.model.Expense;
import com.liferay.me.expense.manager.service.base.ExpenseServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.service.ServiceContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the expense remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.me.expense.manager.service.ExpenseService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=expensemanager",
		"json.web.service.context.path=Expense"
	},
	service = AopService.class
)
public class ExpenseServiceImpl extends ExpenseServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.liferay.me.expense.manager.service.ExpenseServiceUtil</code> to access the expense remote service.
	 */
	public Expense addExpense(long groupId, String title, String description, Date dueDate
			, String currency, ServiceContext serviceContext) throws PortalException {
		_portletResourcePermission.check(
				getPermissionChecker(), serviceContext.getScopeGroupId(),
				ActionKeys.ADD_ENTRY);
		return  expenseLocalService.addExpense( groupId,  title,  description,  dueDate
				,  currency,  serviceContext);
	}
	public Expense updateExpense(long expenseId, String title, String description, Date dueDate
			,String currency,ServiceContext serviceContext) throws PortalException
	{

		Expense _expense = expenseLocalService.getExpense(expenseId);
		_expense.setTitle(title);
		_expense.setDescription(description);
		_expense.setExpenseDate(dueDate);
		_expense.setCurrency(currency);

		/*_expenseModelResourcePermission.check(getPermissionChecker(), expenseId, ActionKeys.UPDATE);*/

		return expenseLocalService.updateExpense(_expense);
	}
	public List<Expense> getExpenseByGroupId(long groupId,ServiceContext serviceContext) throws PrincipalException {

		List<Expense> data = expenseLocalService.getExpenseByGroupId(groupId,serviceContext);

		return data;
	}

	public List<Expense> getExpenseByGroupId(long groupId,int start,int end,ServiceContext serviceContext)
	{
		return expenseLocalService.getExpenseByGroupId(groupId,start,end,serviceContext);
	}
	public List<Expense> getExpenseByUserName(String userName)
	{
		return expenseLocalService.getExpenseByUserName(userName);
	}
	public List<Expense> getExpenseByUserName(String userName, int start,int end)
	{
		return expenseLocalService.getExpenseByUserName(userName,start,end);
	}
	public Expense getExpenseById(long expenseId) throws NoSuchExpenseException {
		return expenseLocalService.getExpenseById(expenseId);
	}
	public int getExpensesCount(long groupId)
	{
		return expenseLocalService.getExpensesCount(groupId);
	}
	public int getExpensesCountByUserId(long userId)
	{
		return expenseLocalService.getExpensesCountByUserId(userId);
	}
	public List<Expense> getExpenseByUserId(long userId, int start,int end)
	{
		return expenseLocalService.getExpenseByUserID(userId,start,end);
	}
	public List<Expense> getExpenseByUserId(long userId)
	{
		return expenseLocalService.getExpenseByUserID(userId);
	}
	public void deleteAll(long groupId)
	{
		expenseLocalService.deleteAll( groupId);
	}
	public void deleteExpenseById(long expenseId,ServiceContext serviceContext) throws PortalException {
		expenseLocalService.deleteExpenseById(expenseId,serviceContext);
	}

	@Reference(policy = ReferencePolicy.DYNAMIC, policyOption = ReferencePolicyOption.GREEDY,
			target = "(model.class.name=com.liferay.me.expense.manager.model.Expense)")
	private volatile ModelResourcePermission<Expense> _expenseModelResourcePermission;

	@Reference(policy = ReferencePolicy.DYNAMIC, policyOption = ReferencePolicyOption.GREEDY,
			target = "(resource.name="
			+ ExpenseConstants.RESOURCE_NAME + ")")
	private volatile PortletResourcePermission _portletResourcePermission;

}