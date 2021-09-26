package com.liferay.me.expense.manager.permission.resource.definition;
import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.StagedPortletPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.definition.PortletResourcePermissionDefinition;
import com.liferay.me.expense.manager.constants.ExpenseConstants;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = PortletResourcePermissionDefinition.class)
public class ExpenseViewPortletResourcePermissionDefinition implements PortletResourcePermissionDefinition {
    @Override
    public PortletResourcePermissionLogic[] getPortletResourcePermissionLogics() {
        return new PortletResourcePermissionLogic[] {
                new StagedPortletPermissionLogic(_stagingPermission, ExpenseConstants.PORTLET_NAME) };
    }

    @Override
    public String getResourceName() {
        return ExpenseConstants.RESOURCE_NAME;
    }

    @Reference
    private StagingPermission _stagingPermission;
}
