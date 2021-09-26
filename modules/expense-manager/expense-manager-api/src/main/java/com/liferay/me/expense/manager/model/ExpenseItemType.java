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

package com.liferay.me.expense.manager.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ExpenseItemType service. Represents a row in the &quot;ExpenseManager_ExpenseItemType&quot; database table, with each column mapped to a property of this class.
 *
 * @author Mahmoud Hussein Tayem
 * @see ExpenseItemTypeModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.me.expense.manager.model.impl.ExpenseItemTypeImpl"
)
@ProviderType
public interface ExpenseItemType extends ExpenseItemTypeModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.me.expense.manager.model.impl.ExpenseItemTypeImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ExpenseItemType, Long>
		EXPENSE_ITEM_TYPE_ID_ACCESSOR = new Accessor<ExpenseItemType, Long>() {

			@Override
			public Long get(ExpenseItemType expenseItemType) {
				return expenseItemType.getExpenseItemTypeId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ExpenseItemType> getTypeClass() {
				return ExpenseItemType.class;
			}

		};

}