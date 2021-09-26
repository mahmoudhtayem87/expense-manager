create table ExpenseManager_Expense (
	expenseId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	description STRING null,
	currency_ VARCHAR(75) null,
	expenseDate DATE null,
	amount LONG,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	status INTEGER
);

create table ExpenseManager_ExpenseItem (
	expenseItemId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	dateIncurred DATE null,
	title VARCHAR(75) null,
	description STRING null,
	type_ LONG,
	reimburse BOOLEAN,
	amount LONG,
	expenseId LONG,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	status INTEGER
);

create table ExpenseManager_ExpenseItemType (
	expenseItemTypeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	value VARCHAR(75) null,
	status INTEGER
);

create table ExpenseManager_Translation (
	translationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	portletId VARCHAR(75) null,
	componentId VARCHAR(75) null,
	key_ VARCHAR(75) null,
	cultureCode VARCHAR(75) null,
	translationValue VARCHAR(75) null
);