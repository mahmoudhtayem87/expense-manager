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

import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.me.expense.manager.exception.NoSuchExpenseException;
import com.liferay.me.expense.manager.model.Expense;
import com.liferay.me.expense.manager.service.ExpenseItemLocalService;
import com.liferay.me.expense.manager.service.base.ExpenseLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.util.ContentTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the expense local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.me.expense.manager.service.ExpenseLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.liferay.me.expense.manager.model.Expense",
	service = AopService.class
)
public class ExpenseLocalServiceImpl extends ExpenseLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.liferay.me.expense.manager.service.ExpenseLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.liferay.me.expense.manager.service.ExpenseLocalServiceUtil</code>.
	 */
	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public Expense addExpense(long groupId, String title, String description, Date dueDate
			, String currency, ServiceContext serviceContext) throws PortalException {
		// Get group and user.
		Group group = groupLocalService.getGroup(groupId);
		long userId = serviceContext.getUserId();
		User user = userLocalService.getUser(userId);
		// Generate primary key for the assignment.
		long expenseId = counterLocalService.increment(Expense.class.getName());
		// Create assigment. This doesn't yet persist the entity.
		Expense _expense = createExpense(expenseId);
		// Populate fields.
		_expense.setCompanyId(group.getCompanyId());
		_expense.setCreateDate(serviceContext.getCreateDate(new Date()));
		_expense.setExpenseDate(dueDate);
		_expense.setDescription(description);
		_expense.setGroupId(groupId);
		_expense.setCurrency(currency);
		_expense.setAmount(0);
		_expense.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		_expense.setTitle(title);
		_expense.setUserId(userId);
		_expense.setUserName(user.getScreenName());
		// Persist assignment to database.
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
				Expense.class.getName(), expenseId, false, true, true);
		updateAsset(_expense,serviceContext);
		return updateExpense(_expense);
	}
	public void deleteAll(long groupId)
	{
		expensePersistence.removeByGroupId(groupId);
	}
	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public Expense updateExpense(long expenseId, String title, String description, Date dueDate
			,String currency,ServiceContext serviceContext) throws PortalException {
		Expense _expense = getExpense(expenseId);
		// Populate fields.
		_expense.setExpenseDate(dueDate);
		_expense.setDescription(description);
		_expense.setCurrency(currency);
		_expense.setTitle(title);
		// Persist assignment to database.
		resourceLocalService.updateResources(serviceContext.getCompanyId(),
				serviceContext.getScopeGroupId(),
				Expense.class.getName(), expenseId,
				serviceContext.getModelPermissions());
		updateAsset(_expense,serviceContext);
		return super.updateExpense(_expense);
	}
	public List<Expense> getExpenseByGroupId(long groupId,ServiceContext serviceContext)
	{
		List<Expense> data = expensePersistence.findByGroupId(groupId);
		data.forEach(
				expense -> expense
						.setAmount(expenseItemLocalService
								.getExpenseItemsTotalByExpenseId(expense.getExpenseId())));
		return data;
	}
	public List<Expense> getExpenseByGroupId(long groupId, int start, int end,ServiceContext serviceContext)
	{
		List<Expense> data = expensePersistence.findByGroupId(groupId,start,end);
		data.forEach(
				expense -> expense
						.setAmount(expenseItemLocalService
								.getExpenseItemsTotalByExpenseId(expense.getExpenseId())));
		return data;
	}
	public List<Expense> getExpenseByUserName(String userName)
	{
		List<Expense> data = expensePersistence.findByUserName(userName);
		data.forEach(
				expense -> expense
						.setAmount(expenseItemLocalService
								.getExpenseItemsTotalByExpenseId(expense.getExpenseId())));
		return data;
	}
	public List<Expense> getExpenseByUserName(String userName, int start, int end)
	{
		List<Expense> data = expensePersistence.findByUserName(userName,  start,  end);
		data.forEach(
				expense -> expense
						.setAmount(expenseItemLocalService
								.getExpenseItemsTotalByExpenseId(expense.getExpenseId())));
		return data;
	}
	public Expense getExpenseById(long expenseId) throws NoSuchExpenseException {
		Expense data = expensePersistence.findByExpenseId(expenseId);
		data.setAmount(expenseItemLocalService
				.getExpenseItemsTotalByExpenseId(data.getExpenseId()));
		return data;
	}
	public List<Expense> getExpenseByUserID(long userId)
	{
		List<Expense> data = expensePersistence.findByUserID(userId);
		data.forEach(
				expense -> expense
						.setAmount(expenseItemLocalService
								.getExpenseItemsTotalByExpenseId(expense.getExpenseId())));
		return data;
	}
	public List<Expense> getExpenseByUserID(long userId, int start, int end)
	{
		List<Expense> data = expensePersistence.findByUserID(userId,  start,  end);
		data.forEach(
				expense -> expense
						.setAmount(expenseItemLocalService
								.getExpenseItemsTotalByExpenseId(expense.getExpenseId())));
		return data;
	}
	public List<Expense> getExpenseByUserName(ServiceContext serviceContext) throws PortalException {
		long userId = serviceContext.getUserId();
		List<Expense> data = expensePersistence.findByUserName(userId + "");
		data.forEach(
				expense -> expense
						.setAmount(expenseItemLocalService
								.getExpenseItemsTotalByExpenseId(expense.getExpenseId())));
		return data;
	}
	public int getExpensesCount(long groupId)
	{
		return expensePersistence.findByGroupId(groupId).size();
	}
	public int getExpensesCountByUserId(long userId)
	{
		return expensePersistence.findByUserID(userId).size();
	}

	@Indexable(type = IndexableType.DELETE)
	public void deleteExpenseById(long expenseId,ServiceContext serviceContext) throws PortalException {
		assetEntryLocalService.deleteEntry(Expense.class.getName(),expenseId);
		super.deleteExpense(expenseId);
	}
	private void updateAsset(
			Expense expense, ServiceContext serviceContext)
			throws PortalException {
		assetEntryLocalService.updateEntry(
				serviceContext.getUserId(), serviceContext.getScopeGroupId(),
				expense.getCreateDate(), expense.getModifiedDate(),
				Expense.class.getName(), expense.getExpenseId(),
				expense.getUserUuid(), 0, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, true,
				expense.getCreateDate(), null, null, null,
				ContentTypes.TEXT_HTML,
				expense.getTitle(),
				expense.getDescription(), null, null, null, 0, 0,
				serviceContext.getAssetPriority());
	}
	@Reference
	ExpenseItemLocalService expenseItemLocalService;

}