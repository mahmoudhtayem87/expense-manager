package com.liferay.me.expense.manager.web.configurations.views.portlet;

import com.liferay.me.expense.manager.web.configurations.views.constants.NgExpenseConfigurationPortletKeys;

import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author danasoftmobileapplic
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.hidden",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + NgExpenseConfigurationPortletKeys.NgExpenseConfiguration,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class NgExpenseConfigurationPortlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		renderRequest.setAttribute(
			"mainRequire",
			_npmResolver.resolveModuleName("ng-expense-configuration") + " as main");
		super.doView(renderRequest, renderResponse);
	}
	@Reference
	private NPMResolver _npmResolver;
}