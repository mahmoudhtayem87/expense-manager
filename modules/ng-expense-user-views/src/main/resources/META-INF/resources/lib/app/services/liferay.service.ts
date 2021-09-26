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
    public getExpenseTypeById(expenseTypeId:number)
    {
        const serviceUrl = "/expensemanager.expenseitemtype/get-by-expense-type-id";
        const serviceObject = {
            expenseItemTypeId:111
        };
        return this.generateServicePromise(serviceUrl,serviceObject);
    }
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


}
