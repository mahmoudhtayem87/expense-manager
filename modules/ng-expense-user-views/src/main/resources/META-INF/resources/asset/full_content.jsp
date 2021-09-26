<%@ page import="com.liferay.me.expense.manager.model.Expense" %>
<%@ include file="/init.jsp"%>
<%
    AssetRenderer<?> assetRenderer = (AssetRenderer<?>)request.getAttribute(WebKeys.ASSET_RENDERER);

    String viewEntryURL = assetRenderer.getURLView(liferayPortletResponse, WindowState.MAXIMIZED);

    Expense expense = (Expense) request.getAttribute("expense");
%>
<aui:a cssClass="title-link" href="<%= viewEntryURL %>">
    <h3 class="title"><%= HtmlUtil.escape(expense.getTitle()) %></h3>
</aui:a>
<div class="autofit-col autofit-col-expand">
    <%= HtmlUtil.escape(expense.getDescription()) %>
</div>