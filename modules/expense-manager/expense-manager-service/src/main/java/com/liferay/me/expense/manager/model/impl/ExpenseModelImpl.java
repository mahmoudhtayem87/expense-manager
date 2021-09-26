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

package com.liferay.me.expense.manager.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.me.expense.manager.model.Expense;
import com.liferay.me.expense.manager.model.ExpenseModel;
import com.liferay.me.expense.manager.model.ExpenseSoap;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Expense service. Represents a row in the &quot;ExpenseManager_Expense&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ExpenseModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ExpenseImpl}.
 * </p>
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseImpl
 * @generated
 */
@JSON(strict = true)
public class ExpenseModelImpl
	extends BaseModelImpl<Expense> implements ExpenseModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a expense model instance should use the <code>Expense</code> interface instead.
	 */
	public static final String TABLE_NAME = "ExpenseManager_Expense";

	public static final Object[][] TABLE_COLUMNS = {
		{"expenseId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"title", Types.VARCHAR},
		{"description", Types.VARCHAR}, {"currency_", Types.VARCHAR},
		{"expenseDate", Types.TIMESTAMP}, {"amount", Types.BIGINT},
		{"statusByUserId", Types.BIGINT}, {"statusByUserName", Types.VARCHAR},
		{"statusDate", Types.TIMESTAMP}, {"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("expenseId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("currency_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("expenseDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("amount", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table ExpenseManager_Expense (expenseId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,title VARCHAR(75) null,description STRING null,currency_ VARCHAR(75) null,expenseDate DATE null,amount LONG,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,status INTEGER)";

	public static final String TABLE_SQL_DROP =
		"drop table ExpenseManager_Expense";

	public static final String ORDER_BY_JPQL =
		" ORDER BY expense.expenseDate ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY ExpenseManager_Expense.expenseDate ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long EXPENSEID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long STATUS_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long USERID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long USERNAME_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long EXPENSEDATE_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static Expense toModel(ExpenseSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Expense model = new ExpenseImpl();

		model.setExpenseId(soapModel.getExpenseId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setTitle(soapModel.getTitle());
		model.setDescription(soapModel.getDescription());
		model.setCurrency(soapModel.getCurrency());
		model.setExpenseDate(soapModel.getExpenseDate());
		model.setAmount(soapModel.getAmount());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusByUserName(soapModel.getStatusByUserName());
		model.setStatusDate(soapModel.getStatusDate());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<Expense> toModels(ExpenseSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Expense> models = new ArrayList<Expense>(soapModels.length);

		for (ExpenseSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public ExpenseModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _expenseId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setExpenseId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _expenseId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Expense.class;
	}

	@Override
	public String getModelClassName() {
		return Expense.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Expense, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Expense, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Expense, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Expense)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Expense, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Expense, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Expense)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Expense, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Expense, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Expense>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Expense.class.getClassLoader(), Expense.class, ModelWrapper.class);

		try {
			Constructor<Expense> constructor =
				(Constructor<Expense>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<Expense, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Expense, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Expense, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Expense, Object>>();
		Map<String, BiConsumer<Expense, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Expense, ?>>();

		attributeGetterFunctions.put("expenseId", Expense::getExpenseId);
		attributeSetterBiConsumers.put(
			"expenseId", (BiConsumer<Expense, Long>)Expense::setExpenseId);
		attributeGetterFunctions.put("groupId", Expense::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<Expense, Long>)Expense::setGroupId);
		attributeGetterFunctions.put("companyId", Expense::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId", (BiConsumer<Expense, Long>)Expense::setCompanyId);
		attributeGetterFunctions.put("userId", Expense::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<Expense, Long>)Expense::setUserId);
		attributeGetterFunctions.put("userName", Expense::getUserName);
		attributeSetterBiConsumers.put(
			"userName", (BiConsumer<Expense, String>)Expense::setUserName);
		attributeGetterFunctions.put("createDate", Expense::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate", (BiConsumer<Expense, Date>)Expense::setCreateDate);
		attributeGetterFunctions.put("modifiedDate", Expense::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<Expense, Date>)Expense::setModifiedDate);
		attributeGetterFunctions.put("title", Expense::getTitle);
		attributeSetterBiConsumers.put(
			"title", (BiConsumer<Expense, String>)Expense::setTitle);
		attributeGetterFunctions.put("description", Expense::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<Expense, String>)Expense::setDescription);
		attributeGetterFunctions.put("currency", Expense::getCurrency);
		attributeSetterBiConsumers.put(
			"currency", (BiConsumer<Expense, String>)Expense::setCurrency);
		attributeGetterFunctions.put("expenseDate", Expense::getExpenseDate);
		attributeSetterBiConsumers.put(
			"expenseDate", (BiConsumer<Expense, Date>)Expense::setExpenseDate);
		attributeGetterFunctions.put("amount", Expense::getAmount);
		attributeSetterBiConsumers.put(
			"amount", (BiConsumer<Expense, Long>)Expense::setAmount);
		attributeGetterFunctions.put(
			"statusByUserId", Expense::getStatusByUserId);
		attributeSetterBiConsumers.put(
			"statusByUserId",
			(BiConsumer<Expense, Long>)Expense::setStatusByUserId);
		attributeGetterFunctions.put(
			"statusByUserName", Expense::getStatusByUserName);
		attributeSetterBiConsumers.put(
			"statusByUserName",
			(BiConsumer<Expense, String>)Expense::setStatusByUserName);
		attributeGetterFunctions.put("statusDate", Expense::getStatusDate);
		attributeSetterBiConsumers.put(
			"statusDate", (BiConsumer<Expense, Date>)Expense::setStatusDate);
		attributeGetterFunctions.put("status", Expense::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<Expense, Integer>)Expense::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getExpenseId() {
		return _expenseId;
	}

	@Override
	public void setExpenseId(long expenseId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_expenseId = expenseId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalExpenseId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("expenseId"));
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalUserId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("userId"));
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUserName() {
		return getColumnOriginalValue("userName");
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_title = title;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_description = description;
	}

	@JSON
	@Override
	public String getCurrency() {
		if (_currency == null) {
			return "";
		}
		else {
			return _currency;
		}
	}

	@Override
	public void setCurrency(String currency) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_currency = currency;
	}

	@JSON
	@Override
	public Date getExpenseDate() {
		return _expenseDate;
	}

	@Override
	public void setExpenseDate(Date expenseDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_expenseDate = expenseDate;
	}

	@JSON
	@Override
	public long getAmount() {
		return _amount;
	}

	@Override
	public void setAmount(long amount) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_amount = amount;
	}

	@JSON
	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@JSON
	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return "";
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusByUserName = statusByUserName;
	}

	@JSON
	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusDate = statusDate;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public int getOriginalStatus() {
		return GetterUtil.getInteger(
			this.<Integer>getColumnOriginalValue("status"));
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), Expense.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Expense toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Expense>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ExpenseImpl expenseImpl = new ExpenseImpl();

		expenseImpl.setExpenseId(getExpenseId());
		expenseImpl.setGroupId(getGroupId());
		expenseImpl.setCompanyId(getCompanyId());
		expenseImpl.setUserId(getUserId());
		expenseImpl.setUserName(getUserName());
		expenseImpl.setCreateDate(getCreateDate());
		expenseImpl.setModifiedDate(getModifiedDate());
		expenseImpl.setTitle(getTitle());
		expenseImpl.setDescription(getDescription());
		expenseImpl.setCurrency(getCurrency());
		expenseImpl.setExpenseDate(getExpenseDate());
		expenseImpl.setAmount(getAmount());
		expenseImpl.setStatusByUserId(getStatusByUserId());
		expenseImpl.setStatusByUserName(getStatusByUserName());
		expenseImpl.setStatusDate(getStatusDate());
		expenseImpl.setStatus(getStatus());

		expenseImpl.resetOriginalValues();

		return expenseImpl;
	}

	@Override
	public int compareTo(Expense expense) {
		int value = 0;

		value = DateUtil.compareTo(getExpenseDate(), expense.getExpenseDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Expense)) {
			return false;
		}

		Expense expense = (Expense)object;

		long primaryKey = expense.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Expense> toCacheModel() {
		ExpenseCacheModel expenseCacheModel = new ExpenseCacheModel();

		expenseCacheModel.expenseId = getExpenseId();

		expenseCacheModel.groupId = getGroupId();

		expenseCacheModel.companyId = getCompanyId();

		expenseCacheModel.userId = getUserId();

		expenseCacheModel.userName = getUserName();

		String userName = expenseCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			expenseCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			expenseCacheModel.createDate = createDate.getTime();
		}
		else {
			expenseCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			expenseCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			expenseCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		expenseCacheModel.title = getTitle();

		String title = expenseCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			expenseCacheModel.title = null;
		}

		expenseCacheModel.description = getDescription();

		String description = expenseCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			expenseCacheModel.description = null;
		}

		expenseCacheModel.currency = getCurrency();

		String currency = expenseCacheModel.currency;

		if ((currency != null) && (currency.length() == 0)) {
			expenseCacheModel.currency = null;
		}

		Date expenseDate = getExpenseDate();

		if (expenseDate != null) {
			expenseCacheModel.expenseDate = expenseDate.getTime();
		}
		else {
			expenseCacheModel.expenseDate = Long.MIN_VALUE;
		}

		expenseCacheModel.amount = getAmount();

		expenseCacheModel.statusByUserId = getStatusByUserId();

		expenseCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = expenseCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			expenseCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			expenseCacheModel.statusDate = statusDate.getTime();
		}
		else {
			expenseCacheModel.statusDate = Long.MIN_VALUE;
		}

		expenseCacheModel.status = getStatus();

		return expenseCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Expense, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Expense, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Expense, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Expense)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Expense, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Expense, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Expense, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Expense)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Expense>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _expenseId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _title;
	private String _description;
	private String _currency;
	private Date _expenseDate;
	private long _amount;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private int _status;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Expense, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Expense)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("expenseId", _expenseId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("title", _title);
		_columnOriginalValues.put("description", _description);
		_columnOriginalValues.put("currency_", _currency);
		_columnOriginalValues.put("expenseDate", _expenseDate);
		_columnOriginalValues.put("amount", _amount);
		_columnOriginalValues.put("statusByUserId", _statusByUserId);
		_columnOriginalValues.put("statusByUserName", _statusByUserName);
		_columnOriginalValues.put("statusDate", _statusDate);
		_columnOriginalValues.put("status", _status);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("currency_", "currency");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("expenseId", 1L);

		columnBitmasks.put("groupId", 2L);

		columnBitmasks.put("companyId", 4L);

		columnBitmasks.put("userId", 8L);

		columnBitmasks.put("userName", 16L);

		columnBitmasks.put("createDate", 32L);

		columnBitmasks.put("modifiedDate", 64L);

		columnBitmasks.put("title", 128L);

		columnBitmasks.put("description", 256L);

		columnBitmasks.put("currency_", 512L);

		columnBitmasks.put("expenseDate", 1024L);

		columnBitmasks.put("amount", 2048L);

		columnBitmasks.put("statusByUserId", 4096L);

		columnBitmasks.put("statusByUserName", 8192L);

		columnBitmasks.put("statusDate", 16384L);

		columnBitmasks.put("status", 32768L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Expense _escapedModel;

}