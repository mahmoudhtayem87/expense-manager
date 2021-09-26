import { Injectable } from '@angular/core';
import {map, Observable} from "rxjs";
import {HttpClient, HttpParams} from "@angular/common/http";
import {promise} from "protractor";
declare const document: any;

declare const Liferay: any;

export class Expense
{
    title: string | undefined;
    description: string | undefined;
    createDate:Date | undefined;
    userName:string | undefined

}
@Injectable({
    providedIn: 'root',
})
export class LiferayService {

    constructor(private http: HttpClient) { }
    //
    public updateTranslationValue(translationId : any,newTranslationValue:string)
        :Promise<any | undefined>
    {
        const serviceUrl = "/expensemanager.translation/update-by-translation-id";
        const serviceObject = {
            translationId:translationId,
            newTranslationValue:newTranslationValue
        };
        return this.generateServicePromise(serviceUrl,serviceObject);
    }
    //expensemanager.expenseitemtype/delete-expense-item-type
    public deleteExpenseTypeItem(expenseTypeId : any)
        :Promise<any | undefined>
    {
        const serviceUrl = "/expensemanager.expenseitemtype/delete-expense-item-type";
        const serviceObject = {
            expenseTypeId:expenseTypeId
        };
        return this.generateServicePromise(serviceUrl,serviceObject);
    }
    public createExpenseTypeItem(newTitle:string,newValue:string)
        :Promise<any | undefined>
    {
        const serviceUrl = "/expensemanager.expenseitemtype/add-expense-item";
        const serviceObject = {
            groupId:this.getScopedGroupId(),
            title:newTitle,
            value:newValue
        };
        return this.generateServicePromise(serviceUrl,serviceObject);
    }
    public updateExpenseTypeItem(expenseTypeId : any,newTitle:string,newValue:string)
        :Promise<any | undefined>
    {
        const serviceUrl = "/expensemanager.expenseitemtype/update-expense-item-type";
        const serviceObject = {
            expenseTypeId:expenseTypeId,
            title:newTitle,
            value:newValue
        };
        return this.generateServicePromise(serviceUrl,serviceObject);
    }
    public getExpenses(start : number,end:number):Promise<any[] | undefined>
    {
        const serviceUrl = "/expensemanager.expense/get-expense-by-user-id";
        const serviceObject = {
            userId:this.getCurrentUserId(),
            start:start,
            end:end
        };
        return this.generateServicePromise(serviceUrl,serviceObject);
    }
    public getTranslatedPortlets():Promise<any[] | undefined>
    {
        const serviceUrl = "/expensemanager.translation/get-translated-portlets-by-group-id";
        const serviceObject = {
            groupId:this.getScopedGroupId()
        };
        return this.generateServicePromise(serviceUrl,serviceObject);
    }
    public getTranslatedPortletsComponents(portletId:string):Promise<any[] | undefined>
    {
        const serviceUrl = "/expensemanager.translation/get-translated-components-by-group-id-portlet-id";
        const serviceObject = {
            groupId:this.getScopedGroupId(),
            portletId:portletId
        };
        return this.generateServicePromise(serviceUrl,serviceObject);
    }
    public getTranslations(start : number,end:number):Promise<any[] | undefined>
    {
        const serviceUrl = "/expensemanager.translation/get-translation-by-group-id";
        const serviceObject = {
            groupId:this.getScopedGroupId(),
            start:start,
            end:end
        };
        return this.generateServicePromise(serviceUrl,serviceObject);
    }
    public getTranslationsPortletIdComponentIdCultureCode
    ( portletId : string, componentId:string, cultureCode:string, start : number,end:number):Promise<any[] | undefined>
    {
        const serviceUrl = "/expensemanager.translation/get-translations-by-portlet-id-component-id";
        const serviceObject = {
            groupId:this.getScopedGroupId(),
            portletId:portletId,
            componentId:componentId,
            cultureCode:cultureCode,
            start:start,
            end:end
        };
        return this.generateServicePromise(serviceUrl,serviceObject);
    }
    public getTranslationsPortletIdComponentIdCultureCodeCount
    ( portletId : string, componentId:string, cultureCode:string):Promise<number>
    {
        const serviceUrl = "/expensemanager.translation/get-translations-by-portlet-id-component-id-count";
        const serviceObject = {
            groupId:this.getScopedGroupId(),
            portletId:portletId,
            componentId:componentId,
            cultureCode:cultureCode
        };
        return this.generateServicePromise(serviceUrl,serviceObject);
    }
    public getTranslationsCount():Promise<any>
    {
        const serviceUrl = "/expensemanager.translation/get-translation-count-by-group-id";
        const serviceObject = {
            groupId:this.getScopedGroupId()
        };
        return this.generateServicePromise(serviceUrl,serviceObject);
    }
    //
    public getExpenseById(expenseId:number)
    {
        const serviceUrl = '/expensemanager.expense/get-expense-by-id';
        const serviceObject = {
            expenseId:expenseId
        };
        return this.generateServicePromise(serviceUrl,serviceObject);
    }
    public getExpensesCount():Promise<any>
    {
        const serviceUrl = '/expensemanager.expense/get-expenses-count-by-user-id';
        const serviceObject = {
            userId : this.getCurrentUserId()
        };
        return this.generateServicePromise(serviceUrl,serviceObject);
    }
    //expensemanager.expenseitemtype/get-expense-item-types
    public getExpenseItemTypesLiferayPagged(start:number,end:number):Promise<any | undefined>
    {
        return  this.generateServicePromise(
            '/expensemanager.expenseitemtype/get-expense-item-types',
            {
                groupId:this.getScopedGroupId(),
                start:start,
                end:end
            });
    }
    public getExpenseItemTypesCount():Promise<number>
    {
        return  this.generateServicePromise(
            '/expensemanager.expenseitemtype/get-expense-item-types-count',
            {
                groupId:this.getScopedGroupId()
            });
    }
    public getExpenseItemTypesLiferay():Promise<any | undefined>
    {
        return  this.generateServicePromise(
            '/expensemanager.expenseitemtype/get-expense-item-types',
            {
                groupId:this.getScopedGroupId()
            });
    }
    public getExpensesUsingLiferay(_groupId:number):Promise<any | undefined>
    {
        return  this.generateServicePromise(
            '/expensemanager.expense/get-expense-by-group-id',
            {
                groupId:_groupId
            });
    }
    async deleteExpenseItem(value: any) {
        const serviceUrl = '/expensemanager.expenseitem/delete-expense-item-by-id';
        value.dateIncurred = (new Date(value.dateIncurred)).getTime();
        const serviceObject =value;
        return this.generateServicePromise(serviceUrl,serviceObject);
    }
    async updateExpenseItem(value: any) {
        const serviceUrl = '/expensemanager.expenseitem/update-expense-item';
        value.dateIncurred = (new Date(value.dateIncurred)).getTime();
        const serviceObject =value;
        return this.generateServicePromise(serviceUrl,serviceObject);
    }
    async createExpenseItem(value: any) {
        const serviceUrl = '/expensemanager.expenseitem/add-expense-item';
        value.dateIncurred = (new Date(value.dateIncurred)).getTime();
        const serviceObject =value;
        return this.generateServicePromise(serviceUrl,serviceObject);
    }
    //
    async deleteExpenseByExpenseID(_expenseId: any) {
        const serviceUrl = '/expensemanager.expense/delete-expense-by-id';
        const serviceObject = {
            expenseId:_expenseId
        };
        return this.generateServicePromise(serviceUrl,serviceObject);
    }
    async getExpenseItemsByExpenseID(_expenseId: any) {
        const serviceUrl = '/expensemanager.expenseitem/get-expense-items-by-expense-id';
        const serviceObject = {
            expenseId:_expenseId
        };
        return this.generateServicePromise(serviceUrl,serviceObject);
    }
    public createExpense(title:string,description:string,DueDate:Date,currency:string)
    {
        const serviceUrl = '/expensemanager.expense/add-expense';
        const serviceObject =
            {
                groupId:this.getScopedGroupId(),
                title:title,
                description:description,
                dueDate:DueDate.getTime(),
                currency:currency
            };
        return this.generateServicePromise(serviceUrl,serviceObject);
    }
    //private helper methods
    generateServicePromise(serviceURL:string,serviceObject:any):Promise<any>
    {
        const prom = new Promise((resolve,reject)=>{
                Liferay.Service(serviceURL,serviceObject,(result:any)=>{
                    resolve(result);
                },(error:any)=>{
                    reject(error);
                });
        });
        return  prom;
    }
    public getScopedGroupId()
    {
        return Liferay.ThemeDisplay.getScopeGroupId();
    }
    public getCurrentUserId()
    {
        return Liferay.ThemeDisplay.getUserId();
    }
    public getAvailableLanguages():Array<any>
    {
        var languagesArray = new Array();
        Object.keys(Liferay.Language.available).forEach((key) =>
        {
            languagesArray.push({Key :key,Value: Liferay.Language.available[key]});
        });
        return languagesArray;
    }

}
