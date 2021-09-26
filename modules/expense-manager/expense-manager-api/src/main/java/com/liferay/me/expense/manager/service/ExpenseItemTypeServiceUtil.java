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

import com.liferay.me.expense.manager.model.ExpenseItemType;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * Provides the remote service utility for ExpenseItemType. This utility wraps
 * <code>com.liferay.me.expense.manager.service.impl.ExpenseItemTypeServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseItemTypeService
 * @generated
 */
public class ExpenseItemTypeServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.me.expense.manager.service.impl.ExpenseItemTypeServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static ExpenseItemType addExpenseItem(
			long groupId, String title, String value,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addExpenseItem(
			groupId, title, value, serviceContext);
	}

	public static void deleteExpenseItemType(
			long expenseTypeId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		getService().deleteExpenseItemType(expenseTypeId, serviceContext);
	}

	public static ExpenseItemType getByExpenseTypeId(long expenseTypeId)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemTypeException {

		return getService().getByExpenseTypeId(expenseTypeId);
	}

	public static List<ExpenseItemType> getExpenseItemTypes(long groupId) {
		return getService().getExpenseItemTypes(groupId);
	}

	public static List<ExpenseItemType> getExpenseItemTypes(
		long groupId, int start, int end) {

		return getService().getExpenseItemTypes(groupId, start, end);
	}

	public static int getExpenseItemTypesCount(long groupId) {
		return getService().getExpenseItemTypesCount(groupId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void updateExpenseItemType(
			long expenseTypeId, String title, String value,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		getService().updateExpenseItemType(
			expenseTypeId, title, value, serviceContext);
	}

	public static ExpenseItemTypeService getService() {
		return _service;
	}

	private static volatile ExpenseItemTypeService _service;

}