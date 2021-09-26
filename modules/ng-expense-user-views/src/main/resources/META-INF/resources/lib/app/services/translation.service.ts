import { Injectable } from '@angular/core';
import {map, Observable} from "rxjs";
import {HttpClient, HttpParams} from "@angular/common/http";
import {promise} from "protractor";
import {ConstantsService} from "./constants.service";
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
export class TranslationService {

    constructor(private http: HttpClient,private _constantsService:ConstantsService) { }


    private translations : Array<any>  = [];
    ///expensemanager.translation/get-translation-by-portlet-id-and-culture
    public getComponentTranslation(componentId:string)
    {
        const serviceUrl = '/expensemanager.translation/get-translation-by-portlet-id-and-component-id-and-culture';
        const serviceObject = {
            groupId:this.getScopedGroupId(),
            portletId:this._constantsService.PortletId(),
            componentId:componentId,
            cultureCode:this.getCultureCode()
        };
        return this.generateServicePromise(serviceUrl,serviceObject);
    }
    public getComponentTranslationLocalStorage(componentId:string)
    {
        var translationsStr = localStorage.getItem(this.TranslationKey);
        if (translationsStr != null && translationsStr != "")
        {
            var translationObj = JSON.parse(translationsStr);
            // @ts-ignore
            return  translationObj.filter(trans => trans.componentId === componentId);
        }
        else
            return null;
    }
    public Appinit_loadTranslations():Promise<any> {
        var key = this._constantsService.TranslationStorageKey()
            + "-" +Liferay.ThemeDisplay.getLanguageId();
        return new Promise((resolve)=>{
            this.getPortletTranslation().then(result=>{
                // @ts-ignore
                localStorage.setItem(key,JSON.stringify(result) );
                // @ts-ignore
                resolve(result);
            },error=>{
                resolve(null);
            });
        });
    }
    async loadTranslations()
    {
        var translations = localStorage.getItem(this.getTranslationKey());
        if (translations === null || translations === undefined || translations ==="")
        {
            translations = await this.getPortletTranslation();
            // @ts-ignore
            localStorage.setItem(this._TranslationService.TranslationKey,translations);
        }
    }
    public  getTranslationKey():string
    {
        return this._constantsService.TranslationStorageKey()
        + "-" +Liferay.ThemeDisplay.getLanguageId();
    }
    public  get TranslationKey():string
    {
        return this._constantsService.TranslationStorageKey()
            + "-" +Liferay.ThemeDisplay.getLanguageId();
    }
    public getPortletTranslation()
    {
        const serviceUrl = '/expensemanager.translation/get-translation-by-portlet-id-and-culture';
        const serviceObject = {
            groupId:this.getScopedGroupId(),
            portletId:this._constantsService.PortletId(),
            cultureCode:this.getCultureCode()
        };
        return this.generateServicePromise(serviceUrl,serviceObject);
    }
    public addTranslationItem(key:string,value:string,componentId : string)
    {
        const serviceUrl = '/expensemanager.translation/add-translation-item';
        const serviceObject = {
            groupId:this.getScopedGroupId(),
            portletId:this._constantsService.PortletId(),
            componentId:componentId,
            cultureCode:this.getCultureCode(),
            key:key,
            translationValue:value
        };
        return this.generateServicePromise(serviceUrl,serviceObject);
    }
    //public helper methods

    public async getLabel(key: string,translations:Array<any>,componentId:string) {
        var translationItems = translations.filter(translation => translation.key === key);
        if (translationItems.length <= 0) {
            //translations.push(await this.addTranslationItem(key, key,componentId));
            return key;
        } else
            return translationItems[0].translationValue;
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
    private getScopedGroupId()
    {
        return Liferay.ThemeDisplay.getScopeGroupId();
    }
    private getCurrentUserId()
    {
        return Liferay.ThemeDisplay.getUserId();
    }
    private getCultureCode()
    {
        return Liferay.ThemeDisplay.getLanguageId();
    }
}
