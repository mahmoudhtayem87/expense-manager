import {Component, OnInit, ViewChild} from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import {LiferayService} from "../../../services/liferay.service";
import {ActivatedRoute, Router} from "@angular/router";
import {CurrencyService} from "../../../services/currency.service";
import {ViewExpenseComponent} from "./view.component";
import {baseComponent} from "../../../general/base.component";
import {TranslationService} from "../../../services/translation.service";


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
                                    <a (click)="back()" class="component-action" role="button">
                                        <fa-icon icon="arrow-left" title='{{getLabel("Reload")}}' class=" middle"></fa-icon>
                                    </a>
                                </li>
                                <li class="tbar-item" *ngIf="isLoading">
                                    <a class="component-action" role="button">
                                        <fa-icon icon="spinner" title="Reload" [spin]="true" [rotate]="true" class=" middle"></fa-icon>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
                <div class="panel-body">
                    <div class="expense-item">
                        <expense-view  [expenseId]="expenseId"></expense-view>
                    </div>
                    <nav  class="component-tbar tbar mb-4">
                        <div class="container-fluid container-fluid-max-xl">
                            <ul class="tbar-nav">
                                <li class="tbar-item tbar-item-expand d-flex justify-content-middle">
                                    <div class="tbar-section justify-content-start d-flex"><span
                                            class="text-truncate-inline"> <span
                                            class="text-truncate">{{getLabel("Expense-Items")}}</span> </span>
                                    </div>
                                </li>
                                <li class="tbar-item">
                                    <a (click)="addNew()" class="component-action" role="button">
                                        <fa-icon icon="plus" title="Reload" class=" middle"></fa-icon>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </nav>
                    <expense-item-create  (updateParent)="updateSelf()" [expenseID]="createdExpense.expenseId" *ngIf="createNew">
                    </expense-item-create>
                    <div class="list-group expenses-list" >
                        <expense-item-view *ngFor="let expenseItem of expenseItems"
                                           [expenseObject]="expenseItem"
                                           (updateParent)="updateSelf()"
                                           [currency]="createdExpense.currency"
                                           class="expense-item mb-2">

                        </expense-item-view>
                    </div>
                </div>
                <div class="panel-footer">
                </div>
            </div>
        `
})
export class EditExpenseComponent extends baseComponent implements OnInit{
    expenseForm: FormGroup | undefined;
    _componentId = "Edit-Expense-Project-Screen";
    private submitted :boolean =  false ;
    public isLoading:boolean  = false;
    public createNew:boolean = false;
    public createdExpense :any = {};
    public expenseItems : any[] | undefined = [];
    public expenseId : number = -1;
    @ViewChild(ViewExpenseComponent) _viewComponent: ViewExpenseComponent | undefined;
    public back() {
        this.route.navigate(['/expenselist']);
    }
    constructor(private formBuilder: FormBuilder,private actRoute: ActivatedRoute,
                private currencySrv: CurrencyService,_translationSrv : TranslationService,
                private liferaySrv: LiferayService,private route:Router) {
        super(_translationSrv);
    }
    async getExpenseItems()
    {
        this.isLoading = true;
        this.expenseItems =await this.liferaySrv
            .getExpenseItemsByExpenseID(this.createdExpense.expenseId);
        this.isLoading = false;
    }
    addNew()
    {
        this.createNew = true;
    }
    updateSelf()
    {
        this.createNew = false;
        this.getExpenseItems();
        this._viewComponent?.updateSelf();
    }
    get getControl(){
        // @ts-ignore
        return  this.expenseForm.controls;
    }
    ngOnInit(): void {
        super.ngOnInit();
        this.actRoute.paramMap.subscribe( params => {
            this.isLoading = true;
            this.expenseId = parseInt(<string>params.get('id'));
            this.loadExpenseData(this.expenseId);
            this.isLoading = false;
        });
    }
    async loadExpenseData(expenseId:number)
    {
        this.createdExpense = await this.liferaySrv.getExpenseById(this.expenseId);
        this.updateSelf();
    }
    get Currencies()
    {
        return this.currencySrv.getCurrencyList();
    }
}