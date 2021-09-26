import {Component, OnInit} from '@angular/core';
import {Expense, LiferayService} from "../../services/liferay.service";
import {faFilm} from '@fortawesome/free-solid-svg-icons';
import {delay} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
import {TranslationService} from "../../services/translation.service";
import {baseComponent} from "../../general/base.component";
import {Location} from "@angular/common";

@Component({
    template:
        `
            <div class="panel" role="tablist">
                <div class="panel-header">
                    <nav class="component-tbar tbar">
                        <div class="container-fluid">
                            <ul class="tbar-nav">
                                <li class="tbar-item tbar-item-expand d-flex justify-content-middle">
                                    <div class="tbar-section justify-content-start d-flex"><span
                                            class="text-truncate-inline"> <span
                                            class="text-truncate">{{viewTitle}}</span> </span>
                                    </div>
                                </li>
                                <li class="tbar-item">
                                    <div class="button-group button-group-sm">
                                        <select class="form-control middle form-control-sm"
                                         [(ngModel)]="languageCode" id="languageCode"
                                         (change)="handleLanguageChange($event)">
                                            <option *ngFor="let language of LanguagesList" 
                                                    value="{{language.Key}}">{{language.Value}}</option>
                                        </select>
                                    </div>
                                </li>
                                <li class="tbar-item">
                                    <a (click)="reload()" class="component-action" role="button">
                                        <fa-icon icon="sync" title='{{getLabel("Reload")}}' class=" middle"></fa-icon>
                                    </a>
                                </li>
                                <li class="tbar-item">
                                    <a (click)="goBack()" class="component-action" role="button">
                                        <fa-icon icon="arrow-left" title='{{getLabel("back")}}' class=" middle"></fa-icon>
                                    </a>
                                </li>
                                <li class="tbar-item" *ngIf="isLoading">
                                    <a class="component-action" role="button">
                                        <fa-icon icon="spinner" [spin]="true" [rotate]="true"
                                                 class=" middle"></fa-icon>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
                <div class="panel-body">
                    <no-data *ngIf="noData"></no-data>
                    <div *ngIf="!noData">
                        <table class="table table-autofit table-list table-nowrap table-responsive">
                            <thead>
                            <tr>
                                <th class="table-cell-expand"><span class="text-truncate-inline"> 
                                    <span class="text-truncate">{{getLabel("key") }}</span> </span>
                                </th>
                                <th class="table-cell-expand"><span class="text-truncate-inline"> <span
                                        class="text-truncate"></span> {{getLabel("translationValue") }}</span></th>
                                <!-- <th class="table-cell-expand"><span class="text-truncate-inline"> <span
                                        class="text-truncate">{{getLabel("createDate") }}</span> </span></th> -->
                                <th class="table-cell-expand"><span class="text-truncate-inline"> <span
                                        class="text-truncate">{{getLabel("cultureCode") }}</span> </span></th>
                                <th class="table-cell-expand"><span class="text-truncate-inline"> <span
                                        class="text-truncate">{{getLabel("portletId") }}</span> </span></th>
                                <th class="table-cell-expand"><span class="text-truncate-inline"> <span
                                        class="text-truncate">{{getLabel("componentId") }}</span> </span></th>
                                <th class="table-column-text-end"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr translation-item *ngFor="let translation of translations"
                                        [ComponentID]="translation.componentId"
                                        [CultureCode]="translation.cultureCode"
                                        [Key]="translation.key"
                                        [PortletId]="translation.portletId"
                                        [TranslationId]="translation.translationId"
                                        [TranslationValue]="translation.translationValue" >
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div *ngIf="!noData || totalCount <= 0" class="panel-footer">
                    <div class="pagination-bar pagination-sm my-2">
                        <div class="button-group button-group-sm"><select class="form-control middle form-control-sm"
                                                                          [(ngModel)]="pageSize" id="pageSize"
                                                                          (change)="handlePageSizeChange($event)">
                            <option value="5">5</option>
                            <option value="10">10</option>
                            <option value="20">20</option>
                            <option value="30">30</option>
                            <option value="40">40</option>
                            <option value="50">50</option>
                        </select></div>
                        <div class="pagination-results mb-0">{{pageSize}}  Entries, Showing {{start}}
                            to {{(end > totalCount ? totalCount : end)}} of {{totalCount}} entries.
                        </div>
                        <ul class="pagination mb-0">
                            <li *ngFor="let page of pages " class='{{(currentPage == page ? "active" : "")}} page-item'>
                                <a class="page-link " (click)="openPage(page)" tabindex="-1">{{page + 1}}</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        `
})
export class translationComponent extends baseComponent implements OnInit {
    public translations: any[] | undefined = [];
    public portletId : string = "";
    public componentId : string = "";
    public pageSize: any = 5;
    public pages: number[] = [];
    public currentPage: number = 0;
    public isLoading: boolean = false;
    public noData: boolean = false;
    public totalCount: number = 0;
    public start: number = 0;
    public end: number = 0;
    public languageCode:string = "en_US";
    public LanguagesList  : Array<any> = [];
    _componentId = "Translations-List-Screen";

    public get PageSize() {
        return parseInt(this.pageSize);
    }

    constructor(public liferaySrv: LiferayService, private route: Router,
                private actRoute: ActivatedRoute,_location:Location,
                public _TranslationService: TranslationService) {
        super(_TranslationService, _location);
        this.LanguagesList = this.liferaySrv.getAvailableLanguages();
    }

    ngOnInit() {
        super.ngOnInit();
        this.actRoute.paramMap.subscribe( params => {
            this.isLoading = true;
            this.portletId = <string>params.get('portletId');
            this.componentId = <string>params.get('componentId');
            this.isLoading = false;
        });
        this.getTranslationsCount();
        this.openPage(this.currentPage);
    }

    public reload() {
        this.currentPage = 0;
        this.getTranslationsCount();
        this.openPage(this.currentPage);
    }
    public goBack() {
        super.goBack();
        this.route.navigate(["/componentsList/"+this.portletId]);
    }

    public createNewExpence() {
        this.route.navigate(['/expenseCreate']);
    }

    public async getTranslations(start: number, end: number) {
        this.isLoading = true;
        this.translations = [];
        try {
            //var _translations2 = await this.liferaySrv.getTranslations(start, end);
            var _translations = await this.liferaySrv.getTranslationsPortletIdComponentIdCultureCode(
                this.portletId,
                this.componentId,
                this.languageCode,
                start, end);

        } catch (error) {
            this.noData = true;
        }
        this.translations = _translations;
        this.isLoading = false;
    }

    public async deleteExpense(expenseId: number) {
        this.isLoading = true;
        await this.liferaySrv.deleteExpenseByExpenseID(expenseId);
        this.isLoading = false;
        this.openPage(this.currentPage);
    }

    public async getTranslationsCount() {
        this.isLoading = true;
        try {
            var count = await this.liferaySrv.getTranslationsPortletIdComponentIdCultureCodeCount(
                this.portletId,
                this.componentId,
                this.languageCode);
            this.totalCount = count;
            if (count >= this.pageSize) {
                // @ts-ignore
                this.pages = Array(Math.ceil((count / this.pageSize))).fill().map((x, i) => i);
            } else
                this.pages = [0];
        } catch (error) {
            this.noData = true;
            console.log(error);
        }
        this.isLoading = false;
    }

    public openPage(pageNumber: number) {
        this.currentPage = pageNumber;
        var start = 0;
        if (this.currentPage > 0)
            start = this.currentPage * this.PageSize;
        var end: number = start + this.PageSize;
        this.start = start;
        this.end = end;
        this.getTranslations(start, end);
    }

    handlePageSizeChange(numberOfItems: Event) {
        this.currentPage = 0;
        this.getTranslationsCount();
        this.openPage(this.currentPage);
    }

    handleLanguageChange($event: Event) {
        this.currentPage = 0;
        this.getTranslationsCount();
        this.openPage(this.currentPage);
    }
}