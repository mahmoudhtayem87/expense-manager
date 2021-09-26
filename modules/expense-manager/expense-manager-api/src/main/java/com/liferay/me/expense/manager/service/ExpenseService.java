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

package com.liferay.me.expense.manager.service;

import com.liferay.me.expense.manager.exception.NoSuchExpenseException;
import com.liferay.me.expense.manager.model.Expense;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Expense. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ExpenseService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.liferay.me.expense.manager.service.impl.ExpenseServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the expense remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ExpenseServiceUtil} if injection and service tracking are not available.
	 */
	public Expense addExpense(
			long groupId, String title, String description, Date dueDate,
			String currency, ServiceContext serviceContext)
		throws PortalException;

	public void deleteAll(long groupId);

	public void deleteExpenseById(long expenseId, ServiceContext serviceContext)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Expense> getExpenseByGroupId(
		long groupId, int start, int end, ServiceContext serviceContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Expense> getExpenseByGroupId(
			long groupId, ServiceContext serviceContext)
		throws PrincipalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Expense getExpenseById(long expenseId) throws NoSuchExpenseException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Expense> getExpenseByUserId(long userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Expense> getExpenseByUserId(long userId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Expense> getExpenseByUserName(String userName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Expense> getExpenseByUserName(
		String userName, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getExpensesCount(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getExpensesCountByUserId(long userId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public Expense updateExpense(
			long expenseId, String title, String description, Date dueDate,
			String currency, ServiceContext serviceContext)
		throws PortalException;

}