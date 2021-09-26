package com.liferay.me.expense.manager.web.asset.model;
import com.liferay.asset.display.page.portlet.AssetDisplayPageFriendlyURLProvider;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.PortletURLFactory;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.me.expense.manager.constants.ExpenseConstants;
import com.liferay.me.expense.manager.model.Expense;
import com.liferay.me.expense.manager.service.ExpenseLocalService;
import com.liferay.me.expense.manager.constants.NgExpenseUserViewsPortletKeys;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.ServletContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = "javax.portlet.name=" + NgExpenseUserViewsPortletKeys.NgExpenseUserViews,
        service = AssetRendererFactory.class
)
public class ExpenseAssetRendererFactory extends BaseAssetRendererFactory<Expense>{
    public static final String CLASS_NAME = Expense.class.getName();
    public static final String TYPE = "assignment";
    public ExpenseAssetRendererFactory() {
        setClassName(CLASS_NAME);
        setLinkable(true);
        setPortletId(NgExpenseUserViewsPortletKeys.NgExpenseUserViews);
        setSearchable(true);
    }
    @Override
    public AssetRenderer<Expense> getAssetRenderer(long classPK, int type)
            throws PortalException {
        Expense assignment = _expenseLocalService.getExpense(classPK);
        ExpenseAssetRenderer expenseAssetRenderer =
                new ExpenseAssetRenderer(
                        assignment);
        expenseAssetRenderer.setAssetDisplayPageFriendlyURLProvider(
                _assetDisplayPageFriendlyURLProvider);
        expenseAssetRenderer.setAssetRendererType(type);
        expenseAssetRenderer.setServletContext(_servletContext);
        return expenseAssetRenderer;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public PortletURL getURLAdd(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse, long classTypeId) {
        PortletURL portletURL = _portal.getControlPanelPortletURL(
                liferayPortletRequest, getGroup(liferayPortletRequest),
                NgExpenseUserViewsPortletKeys.NgExpenseUserViews, 0, 0, PortletRequest.RENDER_PHASE);
        //portletURL.setParameter("mvcRenderCommandName", MVCCommandNames.EDIT_ASSIGNMENT);
        return portletURL;
    }

    @Override
    public PortletURL getURLView(
            LiferayPortletResponse liferayPortletResponse,
            WindowState windowState) {
        LiferayPortletURL liferayPortletURL =
                liferayPortletResponse.createLiferayPortletURL(
                        NgExpenseUserViewsPortletKeys.NgExpenseUserViews, PortletRequest.RENDER_PHASE);
        try {
            liferayPortletURL.setWindowState(windowState);
        }
        catch (WindowStateException wse) {
        }
        return liferayPortletURL;
    }
    @Override
    public boolean hasAddPermission(
            PermissionChecker permissionChecker, long groupId, long classTypeId)
            throws Exception {
        return _portletResourcePermission.contains(
                permissionChecker, groupId, ActionKeys.ADD_ENTRY);
    }
    @Override
    public boolean hasPermission(
            PermissionChecker permissionChecker, long classPK, String actionId)
            throws Exception {
        return _expenseModelResourcePermission.contains(
                permissionChecker, classPK, actionId);
    }
    @Reference
    private AssetDisplayPageFriendlyURLProvider
            _assetDisplayPageFriendlyURLProvider;

    @Reference
    private ExpenseLocalService _expenseLocalService;
    @Reference(
            target = "(model.class.name=com.liferay.training.gradebook.model.Assignment)"
    )
    private ModelResourcePermission<Expense>
            _expenseModelResourcePermission;
    @Reference
    private Portal _portal;
    @Reference(
            target = "(resource.name=" + ExpenseConstants.RESOURCE_NAME + ")"
    )
    private PortletResourcePermission _portletResourcePermission;
    @Reference
    private PortletURLFactory _portletURLFactory;
    @Reference(
            target = "(osgi.web.symbolicname=com.liferay.training.gradebook.web)"
    )
    private ServletContext _servletContext;
}
