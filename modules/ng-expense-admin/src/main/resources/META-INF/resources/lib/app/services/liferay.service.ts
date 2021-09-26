import { Injectable } from '@angular/core';
import {map, Observable} from "rxjs";
import {HttpClient, HttpParams} from "@angular/common/http";
import {promise} from "protractor";
declare const document: any;


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

    public getExpensesActionURL(start:any,end:any):string
    {
        return (decodeURI(document.getElementById("getExpenses").value));
    }
    public getExpensesCountActionURL():string
    {
        return document.getElementById("getExpensesCount").value;
    }
    public getExpenses(start : number,end:number):Promise<any[] | undefined>
    {
        var _params = new HttpParams().set("start",start).set("end",end);

        return this.http.get<any[]>
        (this.getExpensesActionURL(start.toString(),end.toString()),{params:_params}).toPromise();
    }
    public getExpensesCount():Promise<any>
    {
        return this.http.get<any>(this.getExpensesCountActionURL()).toPromise();
    }

}
