<%@ include file="/init.jsp" %>

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
		border-radius: 11px;
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

</style>
<aui:script require="<%= mainRequire %>">
	main.default('#<portlet:namespace />');
</aui:script>
