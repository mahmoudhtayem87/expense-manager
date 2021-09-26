<%@ include file="/init.jsp" %>
<portlet:actionURL name="newExpense" var="user_newExpense" />
<portlet:actionURL name="getExpenses" var="user_getExpenses" />
<portlet:actionURL name="getExpensesCount" var="user_getExpensesCount" />

<div id="<portlet:namespace />"></div>

<style>
	.middle
	{
		margin-top: auto!important;
		margin-bottom: auto!important;
	}
	.expense-actions
	{
		display: none;
	}
	.expenses-list > .expense-item:hover .expense-actions
	{
		display: flex;
	}
	.expense-actions > fa-icon
	{
		margin-right: var(--spacer-1) !important;
		margin-left: var(--spacer-1) !important;
		padding: 1px;
		background: var(--info);
		width: 30px;
		height: 30px;
		align-items: center;
		justify-content: center;
		display: flex;
		cursor: pointer;
		transition: all .2s ease-in-out;
	}
	.expense-actions > fa-icon.info
	{
		color:var(--light);
		background: var(--info);
	}
	.expense-actions > fa-icon.warning
	{
		color:var(--warning);
		background: var(--info);
	}
	.expense-actions > fa-icon.success
	{
		color:var(--light);
		background: var(--success);
	}
	.expense-actions > fa-icon.danger
	{
		color:var(--light);
		background: var(--danger);
	}

	.expense-actions > fa-icon:hover
	{
		transform: scale(1.2);
	}
	.expenses .input-group
	{
		width: initial;
	}
	.expenses .form-control
	{
		border-radius: 0;
	}
	.expenses .input-group-text
	{
		border-radius: 0;
	}
	.expenses .toolbar .toolbar
	{
		transform: scale(0.8);
	}




	.toolbar .input-group.info
	{
		background: var(--info);
	}
	.toolbar .input-group.warning
	{
		background: var(--warning);
	}
	.toolbar .input-group.success
	{
		background: var(--success);
	}
	.toolbar .input-group.danger
	{
		background: var(--danger);
	}
	.toolbar .input-group.action-btn
	{
		transition: all .2s ease-in-out;
		width: 30px;
		height: 30px;
		margin: 5px;
	}
	.toolbar .input-group svg
	{
		color:var(--light);
	}
	.toolbar .input-group.action-btn:hover
	{
		transform: scale(1.05);
	}
	.action-btn
	{
		margin-bottom: auto;
		margin-top: auto;
	}
	.expenses .card-header
	{
		background: transparent;
		border-bottom: solid;
		border-bottom-width: 0.1px;
		border-bottom-color: var(--light);
	}
	.mry-auto
	{
		margin-top: auto!important;
		margin-bottom: auto!important;
	}
	.paging-size-label
	{
		font-size: 0.75rem;
		height: 1.5rem;
		line-height: 1;
		padding: 0 0.625rem;
	}
</style>
<div id="<portlet:namespace />"></div>

<aui:script require="<%= mainRequire %>">
	main.default('#<portlet:namespace />');
</aui:script>
<input type="hidden" id="user_newExpense" name="user_newExpense" value="${user_newExpense}"/>
<input type="hidden" id="user_getExpenses" name="user_getExpenses" value="${user_getExpenses}"/>
<input type="hidden" id="user_getExpensesCount" name="user_getExpensesCount" value="${user_getExpensesCount}"/>