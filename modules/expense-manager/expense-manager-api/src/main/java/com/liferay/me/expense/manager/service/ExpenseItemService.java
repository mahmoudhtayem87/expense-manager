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

import com.liferay.me.expense.manager.model.ExpenseItem;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for ExpenseItem. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseItemServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ExpenseItemService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.liferay.me.expense.manager.service.impl.ExpenseItemServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the expense item remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ExpenseItemServiceUtil} if injection and service tracking are not available.
	 */
	public ExpenseItem addExpenseItem(
			long groupId, long expenseId, long amount, boolean reimburse,
			String title, String description, Date dateIncurred, long type,
			ServiceContext serviceContext)
		throws PortalException;

	public void deleteExpenseItemById(long expenseItemId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ExpenseItem> getExpenseItemsByExpenseId(long expenseId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getExpenseItemsTotalByExpenseId(long expenseId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public void removeByExpenseId(long expenseId);

	public ExpenseItem updateExpenseItem(
			long expenseItemId, long amount, boolean reimburse, String title,
			String description, Date dateIncurred, long type,
			ServiceContext serviceContext)
		throws PortalException;

}