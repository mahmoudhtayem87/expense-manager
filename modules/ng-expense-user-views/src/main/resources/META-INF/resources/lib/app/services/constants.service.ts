import { Injectable } from '@angular/core';
import {map, Observable} from "rxjs";
import {HttpClient, HttpParams} from "@angular/common/http";
import {promise} from "protractor";
import {listComponent} from "../views/expense/list/list.component";
import {CreateExpenseComponent} from "../views/expense/crud/create.component";
import {CreateExpenseItemComponent} from "../views/expense/expense-item/createExpenseItem.component";
declare const document: any;

declare const Liferay: any;


@Injectable({
    providedIn: 'root',
})
export class ConstantsService {
    private portletId : string = "ngexpenseuserviews";
    private translationStorageKey : string = "translations"
    public PortletId()
    {
        return this.portletId;
    }
    public TranslationStorageKey()
    {
        return this.translationStorageKey;
    }

    public translationKeys_ExpenseListScreen = ["Title","Description","Date","Amount","View","Delete","New-Expense",
    "Reload","viewTitle"];
    public translationKeys_ViewExpenseItemScreen = ["viewTitle","Yes","No","Title","Amount","Description"
        ,"Expense-Item-Type","Expense-Date","Reimburse","Save","Delete","Cancel"];
    public translationKeys_CreateNewExpenseItemScreen = ["viewTitle","Expense-Date","Title","Amount","Description",
    "Expense-Date","Reimburse","Create-Item","Expense-Item-Type"];
    public translationKeys_ViewExpenseProjectScreen = ["viewTitle","Total-Amount","Reload","Expense-Items"];
    public trasnlationKeys_CreateNewExpenseProjectScreen = ["viewTitle","Reload","Title","Description"
        ,"Currency","Expense-Date","Create-Expense","Expense-Items","New-Item"];
    public trasnlationKeys_EditExpenseProjectScreen = ["viewTitle","Reload","Title","Description","Description"
        ,"Currency","Expense-Date","Create-Expense","Expense-Items","New-Item"];

    public TranslationArray = [
        {component:"Expense-List-Screen",translations:this.translationKeys_ExpenseListScreen},
        {component:"Create-New-Expense-Item-Screen",translations:this.translationKeys_CreateNewExpenseItemScreen},
        {component:"View-Expense-Item-Screen",translations:this.translationKeys_ViewExpenseItemScreen},
        {component:"View-Expense-Project-Screen",translations:this.translationKeys_ViewExpenseProjectScreen},
        {component: "Create-New-Expense-Project-Screen",translations: this.trasnlationKeys_CreateNewExpenseProjectScreen},
        {component: "Edit-Expense-Project-Screen",translations: this.trasnlationKeys_EditExpenseProjectScreen}
    ];

}