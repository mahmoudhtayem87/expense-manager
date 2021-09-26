package com.liferay.me.expense.manager.web.users.view.permission.resource.definition;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.me.expense.manager.model.Expense;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Peter Richards
 */
@Component(immediate = true, service = ExpensePermission.class)
public class ExpensePermission {
    public static boolean contains(PermissionChecker permissionChecker, Expense expense, String actionId)
            throws PortalException {

        return _expenseModelResourcePermission.contains(permissionChecker, expense, actionId);
    }

    public static boolean contains(PermissionChecker permissionChecker, long dealerId, String actionId)
            throws PortalException {

        return _expenseModelResourcePermission.contains(permissionChecker, dealerId, actionId);
    }

    @Reference(target = "(model.class.name=com.liferay.raybia.dealer.model.Dealer)", unbind = "-")
    protected void setEntryModelPermission(ModelResourcePermission<Expense> modelResourcePermission) {

        _expenseModelResourcePermission = modelResourcePermission;
    }

    private static ModelResourcePermission<Expense> _expenseModelResourcePermission;
}
