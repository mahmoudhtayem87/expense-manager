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

package com.liferay.me.expense.manager.service.base;

import com.liferay.me.expense.manager.model.ExpenseItemType;
import com.liferay.me.expense.manager.service.ExpenseItemTypeLocalService;
import com.liferay.me.expense.manager.service.ExpenseItemTypeLocalServiceUtil;
import com.liferay.me.expense.manager.service.persistence.ExpenseItemPersistence;
import com.liferay.me.expense.manager.service.persistence.ExpenseItemTypePersistence;
import com.liferay.me.expense.manager.service.persistence.ExpensePersistence;
import com.liferay.me.expense.manager.service.persistence.TranslationPersistence;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the expense item type local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.me.expense.manager.service.impl.ExpenseItemTypeLocalServiceImpl}.
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @see com.liferay.me.expense.manager.service.impl.ExpenseItemTypeLocalServiceImpl
 * @generated
 */
public abstract class ExpenseItemTypeLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, ExpenseItemTypeLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ExpenseItemTypeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ExpenseItemTypeLocalServiceUtil</code>.
	 */

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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ExpenseItemType addExpenseItemType(ExpenseItemType expenseItemType) {
		expenseItemType.setNew(true);

		return expenseItemTypePersistence.update(expenseItemType);
	}

	/**
	 * Creates a new expense item type with the primary key. Does not add the expense item type to the database.
	 *
	 * @param expenseItemTypeId the primary key for the new expense item type
	 * @return the new expense item type
	 */
	@Override
	@Transactional(enabled = false)
	public ExpenseItemType createExpenseItemType(long expenseItemTypeId) {
		return expenseItemTypePersistence.create(expenseItemTypeId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ExpenseItemType deleteExpenseItemType(long expenseItemTypeId)
		throws PortalException {

		return expenseItemTypePersistence.remove(expenseItemTypeId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ExpenseItemType deleteExpenseItemType(
		ExpenseItemType expenseItemType) {

		return expenseItemTypePersistence.remove(expenseItemType);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			ExpenseItemType.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return expenseItemTypePersistence.findWithDynamicQuery(dynamicQuery);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return expenseItemTypePersistence.findWithDynamicQuery(
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return expenseItemTypePersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return expenseItemTypePersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return expenseItemTypePersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public ExpenseItemType fetchExpenseItemType(long expenseItemTypeId) {
		return expenseItemTypePersistence.fetchByPrimaryKey(expenseItemTypeId);
	}

	/**
	 * Returns the expense item type with the primary key.
	 *
	 * @param expenseItemTypeId the primary key of the expense item type
	 * @return the expense item type
	 * @throws PortalException if a expense item type with the primary key could not be found
	 */
	@Override
	public ExpenseItemType getExpenseItemType(long expenseItemTypeId)
		throws PortalException {

		return expenseItemTypePersistence.findByPrimaryKey(expenseItemTypeId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(expenseItemTypeLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ExpenseItemType.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("expenseItemTypeId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			expenseItemTypeLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(ExpenseItemType.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"expenseItemTypeId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(expenseItemTypeLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ExpenseItemType.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("expenseItemTypeId");
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return expenseItemTypePersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return expenseItemTypeLocalService.deleteExpenseItemType(
			(ExpenseItemType)persistedModel);
	}

	public BasePersistence<ExpenseItemType> getBasePersistence() {
		return expenseItemTypePersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return expenseItemTypePersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<ExpenseItemType> getExpenseItemTypes(int start, int end) {
		return expenseItemTypePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of expense item types.
	 *
	 * @return the number of expense item types
	 */
	@Override
	public int getExpenseItemTypesCount() {
		return expenseItemTypePersistence.countAll();
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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ExpenseItemType updateExpenseItemType(
		ExpenseItemType expenseItemType) {

		return expenseItemTypePersistence.update(expenseItemType);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ExpenseItemTypeLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		expenseItemTypeLocalService = (ExpenseItemTypeLocalService)aopProxy;

		_setLocalServiceUtilService(expenseItemTypeLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ExpenseItemTypeLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ExpenseItemType.class;
	}

	protected String getModelClassName() {
		return ExpenseItemType.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = expenseItemTypePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		ExpenseItemTypeLocalService expenseItemTypeLocalService) {

		try {
			Field field =
				ExpenseItemTypeLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, expenseItemTypeLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected ExpensePersistence expensePersistence;

	@Reference
	protected ExpenseItemPersistence expenseItemPersistence;

	protected ExpenseItemTypeLocalService expenseItemTypeLocalService;

	@Reference
	protected ExpenseItemTypePersistence expenseItemTypePersistence;

	@Reference
	protected TranslationPersistence translationPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.GroupLocalService
		groupLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetLinkLocalService
		assetLinkLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

}