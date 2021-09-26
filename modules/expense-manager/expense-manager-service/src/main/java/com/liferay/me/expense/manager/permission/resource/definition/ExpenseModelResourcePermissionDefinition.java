package com.liferay.me.expense.manager.permission.resource.definition;
import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.StagedModelPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.definition.ModelResourcePermissionDefinition;
import com.liferay.me.expense.manager.constants.ExpenseConstants;
import com.liferay.me.expense.manager.model.Expense;
import com.liferay.me.expense.manager.service.ExpenseLocalService;

import java.util.function.Consumer;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = ModelResourcePermissionDefinition.class)
public class ExpenseModelResourcePermissionDefinition implements ModelResourcePermissionDefinition<Expense> {

    @Override
    public Expense getModel(long expenseId) throws PortalException {
        return _expenseLocalService.getExpense(expenseId);
    }

    @Override
    public Class<Expense> getModelClass() {
        return Expense.class;
    }

    @Override
    public PortletResourcePermission getPortletResourcePermission() {
        return _portletResourcePermission;
    }

    @Override
    public long getPrimaryKey(Expense expense) {
        return expense.getExpenseId();
    }

    @Override
    public void registerModelResourcePermissionLogics(ModelResourcePermission<Expense> modelResourcePermission,
                                                      Consumer<ModelResourcePermissionLogic<Expense>> modelResourcePermissionLogicConsumer) {
        modelResourcePermissionLogicConsumer.accept(new StagedModelPermissionLogic<>(_stagingPermission,
                ExpenseConstants.PORTLET_NAME, Expense::getExpenseId));
    }

    @Reference
    private ExpenseLocalService _expenseLocalService;

    @Reference(target = "(resource.name=" + ExpenseConstants.RESOURCE_NAME + ")")
    private PortletResourcePermission _portletResourcePermission;

    @Reference
    private StagingPermission _stagingPermission;

}
