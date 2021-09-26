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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ExpenseItemTypeLocalService}.
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseItemTypeLocalService
 * @generated
 */
public class ExpenseItemTypeLocalServiceWrapper
	implements ExpenseItemTypeLocalService,
			   ServiceWrapper<ExpenseItemTypeLocalService> {

	public ExpenseItemTypeLocalServiceWrapper(
		ExpenseItemTypeLocalService expenseItemTypeLocalService) {

		_expenseItemTypeLocalService = expenseItemTypeLocalService;
	}

	@Override
	public com.liferay.me.expense.manager.model.ExpenseItemType addExpenseItem(
			long groupId, String title, String value,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expenseItemTypeLocalService.addExpenseItem(
			groupId, title, value, serviceContext);
	}

	/**
	 * Adds the expense item type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExpenseItemTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param expenseItemType the expense item type
	 * @return the expense item type that was added
	 */
	@Override
	public com.liferay.me.expense.manager.model.ExpenseItemType
		addExpenseItemType(
			com.liferay.me.expense.manager.model.ExpenseItemType
				expenseItemType) {

		return _expenseItemTypeLocalService.addExpenseItemType(expenseItemType);
	}

	/**
	 * Creates a new expense item type with the primary key. Does not add the expense item type to the database.
	 *
	 * @param expenseItemTypeId the primary key for the new expense item type
	 * @return the new expense item type
	 */
	@Override
	public com.liferay.me.expense.manager.model.ExpenseItemType
		createExpenseItemType(long expenseItemTypeId) {

		return _expenseItemTypeLocalService.createExpenseItemType(
			expenseItemTypeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expenseItemTypeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the expense item type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExpenseItemTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param expenseItemType the expense item type
	 * @return the expense item type that was removed
	 */
	@Override
	public com.liferay.me.expense.manager.model.ExpenseItemType
		deleteExpenseItemType(
			com.liferay.me.expense.manager.model.ExpenseItemType
				expenseItemType) {

		return _expenseItemTypeLocalService.deleteExpenseItemType(
			expenseItemType);
	}

	/**
	 * Deletes the expense item type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExpenseItemTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param expenseItemTypeId the primary key of the expense item type
	 * @return the expense item type that was removed
	 * @throws PortalException if a expense item type with the primary key could not be found
	 */
	@Override
	public com.liferay.me.expense.manager.model.ExpenseItemType
			deleteExpenseItemType(long expenseItemTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expenseItemTypeLocalService.deleteExpenseItemType(
			expenseItemTypeId);
	}

	@Override
	public void deleteExpenseItemType(
			long expenseTypeId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		_expenseItemTypeLocalService.deleteExpenseItemType(
			expenseTypeId, serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expenseItemTypeLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _expenseItemTypeLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _expenseItemTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.me.expense.manager.model.impl.ExpenseItemTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _expenseItemTypeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.me.expense.manager.model.impl.ExpenseItemTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _expenseItemTypeLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _expenseItemTypeLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _expenseItemTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.me.expense.manager.model.ExpenseItemType
		fetchExpenseItemType(long expenseItemTypeId) {

		return _expenseItemTypeLocalService.fetchExpenseItemType(
			expenseItemTypeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _expenseItemTypeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.me.expense.manager.model.ExpenseItemType
			getByExpenseTypeId(long expenseTypeId)
		throws com.liferay.me.expense.manager.exception.
			NoSuchExpenseItemTypeException {

		return _expenseItemTypeLocalService.getByExpenseTypeId(expenseTypeId);
	}

	/**
	 * Returns the expense item type with the primary key.
	 *
	 * @param expenseItemTypeId the primary key of the expense item type
	 * @return the expense item type
	 * @throws PortalException if a expense item type with the primary key could not be found
	 */
	@Override
	public com.liferay.me.expense.manager.model.ExpenseItemType
			getExpenseItemType(long expenseItemTypeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expenseItemTypeLocalService.getExpenseItemType(
			expenseItemTypeId);
	}

	/**
	 * Returns a range of all the expense item types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.me.expense.manager.model.impl.ExpenseItemTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of expense item types
	 * @param end the upper bound of the range of expense item types (not inclusive)
	 * @return the range of expense item types
	 */
	@Override
	public java.util.List<com.liferay.me.expense.manager.model.ExpenseItemType>
		getExpenseItemTypes(int start, int end) {

		return _expenseItemTypeLocalService.getExpenseItemTypes(start, end);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.ExpenseItemType>
		getExpenseItemTypes(long groupId) {

		return _expenseItemTypeLocalService.getExpenseItemTypes(groupId);
	}

	@Override
	public java.util.List<com.liferay.me.expense.manager.model.ExpenseItemType>
		getExpenseItemTypes(long groupId, int start, int end) {

		return _expenseItemTypeLocalService.getExpenseItemTypes(
			groupId, start, end);
	}

	/**
	 * Returns the number of expense item types.
	 *
	 * @return the number of expense item types
	 */
	@Override
	public int getExpenseItemTypesCount() {
		return _expenseItemTypeLocalService.getExpenseItemTypesCount();
	}

	@Override
	public int getExpenseItemTypesCount(long groupId) {
		return _expenseItemTypeLocalService.getExpenseItemTypesCount(groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _expenseItemTypeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _expenseItemTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _expenseItemTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the expense item type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExpenseItemTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param expenseItemType the expense item type
	 * @return the expense item type that was updated
	 */
	@Override
	public com.liferay.me.expense.manager.model.ExpenseItemType
		updateExpenseItemType(
			com.liferay.me.expense.manager.model.ExpenseItemType
				expenseItemType) {

		return _expenseItemTypeLocalService.updateExpenseItemType(
			expenseItemType);
	}

	@Override
	public void updateExpenseItemType(
			long expenseTypeId, String title, String value,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		_expenseItemTypeLocalService.updateExpenseItemType(
			expenseTypeId, title, value, serviceContext);
	}

	@Override
	public ExpenseItemTypeLocalService getWrappedService() {
		return _expenseItemTypeLocalService;
	}

	@Override
	public void setWrappedService(
		ExpenseItemTypeLocalService expenseItemTypeLocalService) {

		_expenseItemTypeLocalService = expenseItemTypeLocalService;
	}

	private ExpenseItemTypeLocalService _expenseItemTypeLocalService;

}