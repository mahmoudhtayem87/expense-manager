package com.liferay.me.expense.manager.web.configurations.views.portlet;

        import com.liferay.application.list.BasePanelApp;
        import com.liferay.application.list.PanelApp;
        import com.liferay.application.list.constants.PanelCategoryKeys;
        import com.liferay.me.expense.manager.web.configurations.views.constants.NgExpenseConfigurationPortletKeys;
        import com.liferay.portal.kernel.model.Portlet;

        import org.osgi.service.component.annotations.Component;
        import org.osgi.service.component.annotations.Reference;
@Component(
        immediate = true,
        property = {
                "panel.app.order:Integer=200",
                "panel.category.key=" + PanelCategoryKeys.APPLICATIONS_MENU_APPLICATIONS_CUSTOM_APPS
        },
        service = PanelApp.class
)
public class ExpenseConfigurationPanelApp extends BasePanelApp {
    @Override
    public String getPortletId() {
        return NgExpenseConfigurationPortletKeys.NgExpenseConfiguration;
    }
    @Override
    @Reference(
            target = "(javax.portlet.name=" + NgExpenseConfigurationPortletKeys.NgExpenseConfiguration + ")",
            unbind = "-"
    )
    public void setPortlet(Portlet portlet) {
        super.setPortlet(portlet);
    }
}