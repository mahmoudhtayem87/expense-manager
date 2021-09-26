import {ChangeDetectorRef, Component, OnInit, ViewChild} from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import {LiferayService} from "../../../services/liferay.service";
import {Router} from "@angular/router";
import {CurrencyService} from "../../../services/currency.service";
import {ViewExpenseComponent} from "./view.component";
import {TranslationService} from "../../../services/translation.service";
import {baseComponent} from "../../../general/base.component";
import {supportsPrompt} from "@angular/core/schematics/utils/schematics_prompt";


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
                                        <fa-icon icon="spinner"  [spin]="true" [rotate]="true" class=" middle"></fa-icon>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </nav>
                </div>
                <div class="panel-body">
                    <expense-view *ngIf="isCreated" [expenseId]="createdExpense.expenseId"
                    ></expense-view>
                    <form [formGroup]="expenseForm" (ngSubmit)="onSubmit()" novalidate *ngIf="!isCreated">
                        <div class="form-group row">
                            <label for="title" class="col-sm-2 col-form-label">{{getLabel("Title")}}</label>
                            <div class="col-sm-10">
                                <input   type="text" class="form-control form-control-sm" id="title" formControlName="title" placeholder='{{getLabel("Title")}}'>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="description" class="col-sm-2 col-form-label">{{getLabel("Description")}}</label>
                            <div class="col-sm-10">
                                <textarea  class="form-control form-control-sm" id="description" formControlName="description" placeholder='{{getLabel("Description")}}'></textarea>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="currency" class="col-sm-2 col-form-label">{{getLabel("Currency")}}</label>
                            <div class="col-sm-10">
                                <select  class="form-control form-control-sm" formControlName="currency"  id="currency">
                                    <option value="{{currency.Currency}}" *ngFor="let currency of Currencies">{{currency.Information.name}}</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="expenseDate" class="col-sm-2 col-form-label">{{getLabel('Expense-Date')}}</label>
                            <div class="col-sm-10">
                                <input  type="date" class="form-control form-control-sm" formControlName="expenseDate" id="expenseDate" placeholder="Expense Date">
                            </div>
                        </div>
                        <div *ngIf="!isCreated" class="form-group row d-flex justify-content-end">
                            <button type="submit" class="btn btn-primary">{{getLabel("Create-Expense")}}</button>
                        </div>
                    </form>
                    <nav *ngIf="isCreated" class="component-tbar tbar mb-4">
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
                                        <fa-icon icon="plus" title='{{getLabel("New-Item")}}' class=" middle"></fa-icon>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </nav>
                    <expense-item-create  (updateParent)="updateSelf()" [expenseID]="createdExpense.expenseId" *ngIf="isCreated && createNew">
                    </expense-item-create>

                    <div class="list-group expenses-list" *ngIf="isCreated">
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
export class CreateExpenseComponent extends baseComponent implements OnInit{
    expenseForm: FormGroup | undefined;
    _componentId = "Create-New-Expense-Project-Screen";
    private submitted :boolean =  false ;
    public isLoading:boolean  = false;
    public createNew:boolean = false;
    public createdExpense :any = {};
    public isCreated : boolean = false;
    public expenseItems : any[] | undefined = [];
    public translationsObject : any;
    @ViewChild(ViewExpenseComponent) _viewComponent: ViewExpenseComponent | undefined;

    public back() {
        this.route.navigate(['/expenselist']);
    }

    prepareForm()
    {
        this.expenseForm = this.formBuilder.group(
            {
            title: ['',Validators.required],
            description:  ['',Validators.required],
            currency: ['',Validators.required],
            expenseDate:  [Date.now(),[Validators.required]],
        });
    }
    constructor(private formBuilder: FormBuilder,private ref: ChangeDetectorRef,
                private currencySrv: CurrencyService,
                private liferaySrv: LiferayService,private route:Router,
                public _TranslationService: TranslationService) {
        super(_TranslationService);
    }

    async getExpenseItems()
    {
        this.isLoading = true;
        this.expenseItems =await this.liferaySrv
            .getExpenseItemsByExpenseID(this.createdExpense.expenseId);
        this.isLoading = false;
    }
    async onSubmit(){
        this.isLoading = true;
        var expense = await this.liferaySrv.createExpense(
            this.expenseForm?.controls['title'].value,
            this.expenseForm?.controls['description'].value,
            new Date(this.expenseForm?.controls['expenseDate'].value),
            this.expenseForm?.controls['currency'].value
        );
        this.createdExpense = expense;
        this.isLoading = false;
        this.isCreated = true;
        this.ref.detectChanges();
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
        this.prepareForm();
    }
    get Currencies()
    {
        return this.currencySrv.getCurrencyList();
    }
    public loadComponentTranslation()
    {
        this.translationsObject =
            this._TranslationService.getComponentTranslationLocalStorage(this.ComponentId);
    }
}