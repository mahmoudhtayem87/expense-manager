package com.liferay.me.expense.manager.permission.resource.definition;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.me.expense.manager.constants.ExpenseConstants;
import com.liferay.me.expense.manager.model.Expense;
import com.liferay.me.expense.manager.model.ExpenseItem;
import com.liferay.me.expense.manager.service.ExpenseItemLocalService;
import com.liferay.me.expense.manager.service.ExpenseLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.StagedModelPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.definition.ModelResourcePermissionDefinition;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.function.Consumer;

@Component(immediate = true, service = ModelResourcePermissionDefinition.class)
public class ExpenseItemModelResourcePermissionDefinition implements ModelResourcePermissionDefinition<ExpenseItem> {

    @Override
    public ExpenseItem getModel(long expenseItemId) throws PortalException {
        return _expenseItemLocalService.getExpenseItem(expenseItemId);
    }

    @Override
    public Class<ExpenseItem> getModelClass() {
        return ExpenseItem.class;
    }

    @Override
    public PortletResourcePermission getPortletResourcePermission() {
        return _portletResourcePermission;
    }

    @Override
    public long getPrimaryKey(ExpenseItem ExpenseItem) {
        return ExpenseItem.getExpenseItemId();
    }

    @Override
    public void registerModelResourcePermissionLogics(ModelResourcePermission<ExpenseItem> modelResourcePermission,
                                                      Consumer<ModelResourcePermissionLogic<ExpenseItem>>
                                                              modelResourcePermissionLogicConsumer) {
        modelResourcePermissionLogicConsumer.accept(new StagedModelPermissionLogic<>(_stagingPermission,
                ExpenseConstants.PORTLET_NAME, ExpenseItem::getExpenseItemId));
    }

    @Reference
    private ExpenseItemLocalService _expenseItemLocalService;

    @Reference(target = "(resource.name=" + ExpenseConstants.RESOURCE_NAME + ")")
    private PortletResourcePermission _portletResourcePermission;

    @Reference
    private StagingPermission _stagingPermission;

}
