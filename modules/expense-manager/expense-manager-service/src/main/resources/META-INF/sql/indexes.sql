create index IX_C91DC17C on ExpenseManager_Expense (groupId, status);
create index IX_BC1F0D7A on ExpenseManager_Expense (status);
create index IX_5D9E26CE on ExpenseManager_Expense (userId);
create index IX_772D2BFE on ExpenseManager_Expense (userName[$COLUMN_LENGTH:75$]);

create index IX_3CF4F61C on ExpenseManager_ExpenseItem (expenseId);
create index IX_48F35E69 on ExpenseManager_ExpenseItem (groupId, status);
create index IX_8D11C1ED on ExpenseManager_ExpenseItem (status);

create index IX_97E8D14F on ExpenseManager_ExpenseItemType (groupId, status);
create index IX_8E725447 on ExpenseManager_ExpenseItemType (status);

create index IX_839836B on ExpenseManager_Translation (groupId, portletId[$COLUMN_LENGTH:75$], componentId[$COLUMN_LENGTH:75$], cultureCode[$COLUMN_LENGTH:75$]);
create index IX_A55353C3 on ExpenseManager_Translation (groupId, portletId[$COLUMN_LENGTH:75$], cultureCode[$COLUMN_LENGTH:75$]);