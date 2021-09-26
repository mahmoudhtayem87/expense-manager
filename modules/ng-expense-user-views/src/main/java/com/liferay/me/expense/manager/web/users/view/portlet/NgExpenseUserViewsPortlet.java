package com.liferay.me.expense.manager.web.users.view.portlet;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.liferay.me.expense.manager.model.Expense;
import com.liferay.me.expense.manager.constants.NgExpenseUserViewsPortletKeys;
import com.liferay.me.expense.manager.service.ExpenseItemService;
import com.liferay.me.expense.manager.service.ExpenseService;


import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

import javax.portlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author danasoftmobileapplic
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.expenseManager",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + NgExpenseUserViewsPortletKeys.NgExpenseUserViews,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class NgExpenseUserViewsPortlet extends MVCPortlet {

	@Override
	public void doView(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {
		renderRequest.setAttribute(
			"mainRequire",
			_npmResolver.resolveModuleName("ng-expense-user-views") + " as main");
		super.doView(renderRequest, renderResponse);
	}
	@ProcessAction(name = "newExpense")
	public void newExpense(ActionRequest request, ActionResponse response)
			throws IOException, PortletException, PortalException, SystemException {
		ThemeDisplay themeDisplay =
				(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance
				(Expense.class.getName(), request);
		InputStreamReader inputStringReader = new InputStreamReader(request.getPortletInputStream());
		BufferedReader reader = new BufferedReader(inputStringReader);
		StringBuffer stringBuilder = new StringBuffer();
		String postInputstring;
		while((postInputstring = reader.readLine())!= null){
			stringBuilder.append(postInputstring);
		}
		JsonNode newExpenseObject = new ObjectMapper().readTree(stringBuilder.toString());
		Expense expense = _expenseService.addExpense(themeDisplay.getScopeGroupId(),
				newExpenseObject.get("title").textValue(),newExpenseObject.get("description").textValue(),new Date()
				,newExpenseObject.get("currency").textValue(),serviceContext);
		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(response);
		String json = new ObjectMapper()
				.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
				.writeValueAsString(expense);
		ServletResponseUtil.write(httpResponse,json);
	}
	@ProcessAction(name = "getExpenses")
	public void getExpenses(ActionRequest request, ActionResponse response)
			throws IOException, PortletException, PortalException, SystemException {
		ThemeDisplay themeDisplay =
				(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance
				(Expense.class.getName(), request);
		HttpServletRequest _req =  PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		Integer start = ParamUtil.getInteger(_req,"start");
		Integer end = ParamUtil.getInteger(_req,"end");
		List<Expense> expenses =
				_expenseService.getExpenseByUserId(themeDisplay.getUserId(),start,end);
		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(response);
		String json = new ObjectMapper()
				.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,
						false).writeValueAsString(expenses);
		ServletResponseUtil.write(httpResponse,json );
	}
	@ProcessAction(name = "getExpensesCount")
	public void getExpensesCount(ActionRequest request, ActionResponse response)
			throws IOException, PortletException, PortalException, SystemException {
		ThemeDisplay themeDisplay =
				(ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		ServiceContext serviceContext = ServiceContextFactory.getInstance
				(Expense.class.getName(), request);
		int expenses =
				_expenseService.getExpensesCountByUserId(themeDisplay.getUserId());
		HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(response);
		ExpensesCount count = new ExpensesCount();
		count.Count = expenses;
		String json = new ObjectMapper()
				.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
				.writeValueAsString(count);
		ServletResponseUtil.write(httpResponse, json );
	}
	@Reference
	private NPMResolver _npmResolver;
	@Reference
	private ExpenseService _expenseService;
	@Reference
	private ExpenseItemService _expenseItemService;

}
class ExpensesCount
{
	public int Count;

}