import { Injectable } from '@angular/core';
import {map, Observable} from "rxjs";
import {HttpClient, HttpParams} from "@angular/common/http";
import {promise} from "protractor";
declare const document: any;

declare const Liferay: any;


@Injectable({
    providedIn: 'root',
})
export class ConstantsService {
    private portletId : string = "ngexpenseconfiguration";
    private translationStorageKey : string = "translations"
    public PortletId()
    {
        return this.portletId;
    }
    public TranslationStorageKey()
    {
        return this.translationStorageKey;
    }

    public translationKeys_listTranslationsComponent =
        ["viewTitle","New-Key","key","translationValue","cultureCode","portletId"
            ,"componentId","translationValue","Delete-Translation","Edit-Translation"];

    public translationKeys_PortletsListScreen =
        ["viewTitle","Reload"];
    public translationKeys_ComponentsListScreen =
        ["viewTitle","Reload"];
    public translationKeys_TranslationsListScreen =
        ["viewTitle","Reload","back","key","translationValue","cultureCode","portletId","componentId"];

    public translationKeys_ExpenseItemTypeListScreen =
        ["viewTitle","Create-New","Reload","Key","Value"];
    public translationKeys_ExpenseItemTypeListRow =
        ["viewTitle","Title","Value","Delete-ExpenseType","Edit-ExpenseType","Cancel","Save"];

    public TranslationArray = [
        {component:"Expense-Item-Type-List-Row",translations:this.translationKeys_ExpenseItemTypeListRow},
        {component:"Expense-Item-Type-List-Screen",translations:this.translationKeys_ExpenseItemTypeListScreen},
        {component:"Portlets-List-Screen",translations:this.translationKeys_PortletsListScreen},
        {component:"Components-List-Screen",translations:this.translationKeys_ComponentsListScreen},
        {component:"Translations-List-Screen",translations:this.translationKeys_TranslationsListScreen},
    ];

}