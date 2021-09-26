package com.liferay.me.expense.manager.web.asset.model;
import com.liferay.asset.display.page.portlet.AssetDisplayPageFriendlyURLProvider;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.asset.util.AssetHelper;
import com.liferay.me.expense.manager.web.users.view.permission.resource.definition.ExpensePermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.LayoutConstants;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.me.expense.manager.model.Expense;
import com.liferay.me.expense.manager.constants.NgExpenseUserViewsPortletKeys;
import java.util.Locale;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ExpenseAssetRenderer extends BaseJSPAssetRenderer<Expense> {
    public ExpenseAssetRenderer(
            Expense assignment) {
        _expense = assignment;
    }
    @Override
    public Expense getAssetObject() {
        return _expense;
    }
    @Override
    public String getClassName() {
        return Expense.class.getName();
    }
    @Override
    public long getClassPK() {
        return _expense.getExpenseId();
    }
    @Override
    public long getGroupId() {
        return _expense.getGroupId();
    }
    @Override
    public String getJspPath(HttpServletRequest request, String template) {
        if (template.equals(TEMPLATE_ABSTRACT) ||
                template.equals(TEMPLATE_FULL_CONTENT)) {
            return "/META-INF/resources/asset/" + template + ".jsp";
        }
        return null;
    }
    @Override
    public int getStatus() {
        return _expense.getStatus();
    }
    @Override
    public String getSummary(
            PortletRequest portletRequest, PortletResponse portletResponse) {
        ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
        int abstractLength = AssetHelper.ASSET_ENTRY_ABSTRACT_LENGTH;
        String summary = HtmlUtil.stripHtml(
                StringUtil.shorten(
                        _expense.getDescription(),
                        abstractLength));
        return summary;
    }
    @Override
    public String getTitle(Locale locale) {
        return _expense.getTitle();
    }

    @Override
    public PortletURL getURLEdit(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse)
            throws Exception {
        Group group = GroupLocalServiceUtil.fetchGroup(_expense.getGroupId());
        if (group.isCompany()) {
            ThemeDisplay themeDisplay =
                    (ThemeDisplay)liferayPortletRequest.getAttribute(
                            WebKeys.THEME_DISPLAY);
            group = themeDisplay.getScopeGroup();
        }
        PortletURL portletURL = PortalUtil.getControlPanelPortletURL(
                liferayPortletRequest, group, NgExpenseUserViewsPortletKeys.NgExpenseUserViews, 0, 0,
                PortletRequest.RENDER_PHASE);
        portletURL.setParameter(
                "mvcRenderCommandName"," MVCCommandNames.EDIT_ASSIGNMENT");
        portletURL.setParameter(
                "expenseId", String.valueOf(_expense.getExpenseId()));
        portletURL.setParameter("showback", Boolean.FALSE.toString());
        return portletURL;
    }

    @Override
    public String getURLView(
            LiferayPortletResponse liferayPortletResponse,
            WindowState windowState)
            throws Exception {
        return super.getURLView(liferayPortletResponse, windowState);
    }
    @Override
    public String getURLViewInContext(
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            String noSuchEntryRedirect)
            throws Exception {
        if (_assetDisplayPageFriendlyURLProvider != null) {
            ThemeDisplay themeDisplay =
                    (ThemeDisplay)liferayPortletRequest.getAttribute(
                            WebKeys.THEME_DISPLAY);

            String friendlyURL =
                    _assetDisplayPageFriendlyURLProvider.getFriendlyURL(
                            getClassName(), getClassPK(), themeDisplay);
            if (Validator.isNotNull(friendlyURL)) {
                return friendlyURL;
            }
        }

        try {
            long plid = PortalUtil.getPlidFromPortletId(
                    _expense.getGroupId(), NgExpenseUserViewsPortletKeys.NgExpenseUserViews
            );
            PortletURL portletURL;
            if (plid == LayoutConstants.DEFAULT_PLID) {
                portletURL = liferayPortletResponse.createLiferayPortletURL(
                        getControlPanelPlid(liferayPortletRequest),
                        NgExpenseUserViewsPortletKeys.NgExpenseUserViews,
                        PortletRequest.RENDER_PHASE);
            }
            else {
                portletURL =
                        PortletURLFactoryUtil.getPortletURLFactory(
                        ).create(
                                liferayPortletRequest, NgExpenseUserViewsPortletKeys.NgExpenseUserViews,
                                plid, PortletRequest.RENDER_PHASE
                        );
            }
            portletURL.setParameter(
                    "mvcRenderCommandName", "MVCCommandNames.VIEW_ASSIGNMENT");
            portletURL.setParameter(
                    "expenseId", String.valueOf(_expense.getExpenseId()));
            String currentUrl = PortalUtil.getCurrentURL(
                    liferayPortletRequest
            );
            portletURL.setParameter("redirect", currentUrl);
            return portletURL.toString();
        }
        catch (PortalException pe) {
        }
        catch (SystemException se) {
        }
        return null;
    }
    @Override
    public long getUserId() {
        return _expense.getUserId();
    }
    @Override
    public String getUserName() {
        return _expense.getUserName();
    }
    @Override
    public String getUuid() {
        return _expense.getUserUuid();
    }
    @Override
    public boolean hasEditPermission(PermissionChecker permissionChecker)
            throws PortalException {
        return ExpensePermission.contains(
                permissionChecker, _expense, ActionKeys.UPDATE);
    }
    @Override
    public boolean hasViewPermission(PermissionChecker permissionChecker)
            throws PortalException {
        return ExpensePermission.contains(
                permissionChecker, _expense, ActionKeys.VIEW);
    }
    @Override
    public boolean include(
            HttpServletRequest request, HttpServletResponse response,
            String template)
            throws Exception {
        request.setAttribute("assignment", _expense);
        return super.include(request, response, template);
    }

    public void setAssetDisplayPageFriendlyURLProvider(
            AssetDisplayPageFriendlyURLProvider
                    assetDisplayPageFriendlyURLProvider) {
        _assetDisplayPageFriendlyURLProvider =
                assetDisplayPageFriendlyURLProvider;
    }

    private AssetDisplayPageFriendlyURLProvider
            _assetDisplayPageFriendlyURLProvider;
    private Expense _expense;
}
