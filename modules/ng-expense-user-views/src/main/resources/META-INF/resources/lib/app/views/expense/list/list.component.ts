import {Component, OnInit} from '@angular/core';
import {Expense, LiferayService} from "../../../services/liferay.service";
import {faFilm} from '@fortawesome/free-solid-svg-icons';
import {delay} from "rxjs";
import {Router} from "@angular/router";
import {TranslationService} from "../../../services/translation.service";
import {baseComponent} from "../../../general/base.component";

@Component({
    template:
        `
            <div class="panel" role="tablist">
                <div class="panel-header">
                    <nav class="component-tbar tbar">
                        <div class="container-fluid container-fluid-max-xl">
                            <ul class="tbar-nav">
                                <li class="tbar-item tbar-item-expand d-flex justify-content-middle">
                                    <div class="tbar-section justify-content-start d-flex"><span
                                            class="text-truncate-inline"> <span
                                            class="text-truncate">{{viewTitle}}</span> </span>
                                    </div>
                                </li>
                                <li class="tbar-item">
                                    <a class="component-action" role="button" (click)="createNewExpence()">
                                        <fa-icon icon="plus" title='{{getLabel("New-Expense")}}' class=" middle"></fa-icon>
                                    </a>
                                </li>
                                <li class="tbar-item">
                                    <a (click)="reload()" class="component-action" role="button">
                                        <fa-icon icon="sync" title='{{getLabel("Reload")}}' class=" middle"></fa-icon>
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
                                <th class="table-cell-expand"><span class="text-truncate-inline"> <span
                                        class="text-truncate">{{getLabel("Title") }}</span> </span></th>
                                <th class="table-cell-expand"><span class="text-truncate-inline"> <span
                                        class="text-truncate"></span>{{getLabel("Description") }}</span></th>
                                <th class="table-cell-expand"><span class="text-truncate-inline"> <span
                                        class="text-truncate">{{getLabel("Date") }}</span> </span></th>
                                <th class="table-cell-expand"><span class="text-truncate-inline"> <span
                                        class="text-truncate">{{getLabel("Amount") }}</span> </span></th>
                                <th class="table-column-text-end"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr *ngFor="let expense of expances">
                                <td class="table-cell-expand">
                                    <div class="table-list-title"><a class="text-truncate-inline" href="#1"> <span
                                            class="text-truncate">{{expense.title}}</span> </a></div>
                                </td>
                                <td class="table-cell-expand"><span class="text-truncate-inline"> <span
                                        class="text-truncate">{{expense.description}}</span> </span></td>
                                <td class="table-cell-expand"><span class="text-truncate-inline"> <span
                                        class="text-truncate">{{millisecondsToDate(expense.createDate) | date:'medium' }}</span> </span>
                                </td>
                                <td class="table-cell-expand"><span class="text-truncate-inline"> <span
                                        class="text-truncate">{{expense.amount}} {{expense.currency}}</span> </span>
                                </td>
                                <td class="table-column-text-end">
                                    <div class="btn-group btn-group-nowrap">
                                        <div class="btn-group-item">
                                            <a [routerLink]="['/expenseEdit/', expense.expenseId]"
                                               class="btn btn-outline-info btn-sm" type="button">
                                                <fa-icon icon="info" class=" middle"></fa-icon>
                                                {{getLabel("View") }}
                                            </a>
                                        </div>
                                        <div class="btn-group-item">
                                            <button (click)="deleteExpense(expense.expenseId)"
                                                    class="btn btn-outline-danger btn-sm" type="button">
                                                <fa-icon icon="trash" class=" middle"></fa-icon>
                                                {{getLabel("Delete") }}
                                            </button>
                                        </div>
                                    </div>
                                </td>
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
export class listComponent extends baseComponent implements OnInit {
    public expances: any[] | undefined = [];
    public pageSize: any = 5;
    public pages: number[] = [];
    public currentPage: number = 0;
    public isLoading: boolean = false;
    public noData: boolean = false;
    public totalCount: number = 0;
    public start: number = 0;
    public end: number = 0;
    _componentId="Expense-List-Screen";

    public get PageSize() {
        return parseInt(this.pageSize);
    }
    constructor(public liferaySrv: LiferayService, private route: Router,
                public _TranslationService: TranslationService) {
        super(_TranslationService);
    }
    ngOnInit() {
        super.ngOnInit();
        this.getExpensesCount();
        this.openPage(this.currentPage);
    }
    public reload() {
        this.currentPage = 0;
        this.getExpensesCount();
        this.openPage(this.currentPage);
    }
    public createNewExpence() {
        this.route.navigate(['/expenseCreate']);
    }
    public async getExpenses(start: number, end: number) {
        this.isLoading = true;
        this.expances = [];
        try {
            var _expenses = await this.liferaySrv.getExpenses(start, end);

        } catch (error) {
            this.noData = true;
            console.log(error);
        }
        this.expances = _expenses;
        this.isLoading = false;
    }
    public async deleteExpense(expenseId: number) {
        this.isLoading = true;
        await this.liferaySrv.deleteExpenseByExpenseID(expenseId);
        this.isLoading = false;
        this.openPage(this.currentPage);
    }
    public async getExpensesCount() {
        this.isLoading = true;
        try {
            var count = parseInt((await this.liferaySrv.getExpensesCount()));
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
        this.getExpenses(start, end);
    }
    handlePageSizeChange(numberOfItems: Event) {
        this.currentPage = 0;
        this.getExpensesCount();
        this.openPage(this.currentPage);
    }
}