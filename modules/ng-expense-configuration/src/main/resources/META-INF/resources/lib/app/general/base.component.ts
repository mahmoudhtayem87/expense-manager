import {TranslationService} from "../services/translation.service";
import {OnInit} from "@angular/core";
import {Location} from '@angular/common';
import {Router} from "@angular/router";

export class baseComponent implements OnInit
{
    public translationsObject = null;
    public _componentId : string = "";
    public _viewTitle : string ="viewTitle";
    public constructor(public _TranslationService: TranslationService,public _location: Location) {
    }
    public goBack()
    {

    }
    public loadComponentTranslation()
    {
        this.translationsObject =
            this._TranslationService.getComponentTranslationLocalStorage(this.ComponentId);
    }
    public  getLabel(key: string) {
        // @ts-ignore
        if (this.translationsObject === null || this.translationsObject.length <= 0)
            return key;
        // @ts-ignore
        var translationItem = this.translationsObject.filter(trasItem=>trasItem.key === key);
        if(translationItem === null || translationItem.length <= 0 )
        {
            return key;
        }else
            // @ts-ignore
            return translationItem[0].translationValue;
    }
    millisecondsToDate(milliseconds: any) {
        return new Date(parseInt(milliseconds));
    }
    public get ComponentId() {
        return this._componentId;
    }

    ngOnInit(): void {
        this.loadComponentTranslation();
    }
    public get viewTitle() {
        return this.getLabel(this._viewTitle);
    }
}