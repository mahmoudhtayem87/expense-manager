import {Component, OnInit} from '@angular/core';
import {Expense, LiferayService} from "../../../services/liferay.service";
import {faFilm} from '@fortawesome/free-solid-svg-icons';
import {delay} from "rxjs";

@Component({
    ///o/<portlet name>/<path to template>/template.html
    styleUrls: ['/o/ng-expense-admin/lib/app/views/expense/list/list.component.scss'],
    template:
        `
            <div class="card expenses">
                <div class="card-header d-flex">
                    <div class="title  h1 w-25 d-flex" style="justify-content: flex-start;"> 
                        <label class="middle h1">Title</label>
                    </div>
                    <div class="toolbar d-flex justify-content-end w-75"
                         style="justify-content: flex-end!important;display: flex;">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="basic-addon1">Page Size</span>
                            </div>
                            <select class="form-control middle" [(ngModel)]="pageSize" id="pageSize" (change)="handlePageSizeChange($event)" >
                                <option>5</option>
                                <option>25</option>
                                <option>50</option>
                                <option>75</option>
                                <option>100</option>
                            </select>
                        </div>
                        <div class="input-group" *ngIf="isLoading">
                            <div class="input-group-prepend d-flex">
                                <fa-icon icon="spinner" title="loading" class="warning middle" size="2x" [spin]="true" ></fa-icon>
                            </div>
                        </div>
                    </div>
                </div>
                <div class=" card-body">
                    <div  class="list-group expenses-list" *ngIf="expances !== null && expances.length > 0 && !isLoading">
                        <div  *ngFor="let expense of expances"
                             class="list-group-item list-group-item-action flex-column align-items-start expense-item">
                            <div class="d-flex w-100 justify-content-between">
                                <h5 class="mb-1 h2">{{expense.title}} </h5>
                                <small>{{millisecondsToDate(expense.createDate) | date:'medium' }}</small>
                            </div>
                            <p class="mb-1 blockquote">{{expense.description}}</p>
                            <small class="d-flex w-100 d-flex w-100 justify-content-between expense-actions-container">
                                {{expense.userName}}
                                <div class="expense-actions  w-100 justify-content-end">
                                    <fa-icon icon="info" title="View Claim Details" class="info"></fa-icon>
                                    <fa-icon icon="check" title="Approve" class="success"></fa-icon>
                                    <fa-icon icon="times" title="Reject" class="danger"></fa-icon>
                                </div>
                            </small>
                        </div>
                    </div>
                    <nav aria-label="Page navigation example">
                        <ul class="pagination justify-content-center">
                            <li *ngFor="let page of pages " class="page-item">
                                <a class="page-link" (click)="openPage(page)">{{page + 1}}</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        `
})

export class listComponent implements OnInit {
    public expances: any[] | undefined = [];
    public pageSize: number = 5;
    public pages: number[] = [];
    public currentPage: number = 0;
    public isLoading:boolean = false;

    constructor(public liferaySrv: LiferayService) {
    }

    ngOnInit(): void {
        this.getExpensesCount();
        this.openPage(this.currentPage);
    }

    public async getExpenses(start: number, end: number) {
        this.isLoading = true;
        this.expances = [];
        var _expenses = await this.liferaySrv.getExpenses(start, end);
        this.expances = _expenses;
        this.isLoading = false;
    }
    public async getExpensesCount() {
        this.isLoading = true;
        var count = (await this.liferaySrv.getExpensesCount()).Count;
        if (count > this.pageSize) {
            // @ts-ignore
            this.pages = Array(Math.ceil((count / this.pageSize))).fill().map((x, i) => i);
        } else
            this.pages = [0];
        this.isLoading = false;
    }
    millisecondsToDate(milliseconds: any) {
        return new Date(parseInt(milliseconds));
    }
    public openPage(pageNumber: number) {
        this.currentPage = pageNumber;
        var start = 0;
        if (this.currentPage > 0)
            start = this.currentPage * this.pageSize;
        var end = start + this.pageSize;
        this.getExpenses(start, end);
    }
    handlePageSizeChange($event: Event) {
        this.currentPage = 0;
        this.getExpensesCount();
        this.openPage(this.currentPage);
    }
}