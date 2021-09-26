import {ChangeDetectorRef, Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import {LiferayService} from "../../../services/liferay.service";
import {Router} from "@angular/router";
import {CurrencyService} from "../../../services/currency.service";
import {baseComponent} from "../../../general/base.component";
import {TranslationService} from "../../../services/translation.service";


@Component({
    selector:'expense-item-view',
    template:
        `
            <div *ngIf="!isEditing && expenseObject" (click)="editItem()" class="list-group-item list-group-item-action flex-column align-items-start ">
                <div class="d-flex w-100 justify-content-between">
                    <h5 class="mb-1 font-weight-bold">{{expenseObject.title}}</h5>
                    <small><small>{{millisecondsToDate(expenseObject.dateIncurred) | date:'medium' }}</small></small>
                </div>
                <p class="mb-1">{{expenseObject.description}}</p>
                <div class="d-flex w-100 d-flex w-100 justify-content-between expense-actions-container">
                    <small>{{getCurrentExpenseType(expenseObject.type)}}</small>
                    <small>{{expenseObject.amount}} {{currency}}</small>
                    <small>Reimburse: {{expenseObject.reimburse?getLabel("Yes") : getLabel("No")}} </small>
                </div>
            </div>
            <form *ngIf="isEditing" [formGroup]="expenseItemForm" class="border border-light p-4 shadow-sm" (ngSubmit)="onSubmit()" novalidate>
                <div class="form-row">
                    <div class="col-lg-6 col-md-12 col-sm-12 mb-3">
                        <input   type="text" class="form-control form-control-sm" id="title" formControlName="title" placeholder='{{getLabel("Title")}}'>
                    </div>
                    <div class="col-lg-6 col-md-12 col-sm-12 mb-3">
                        <input  type="number" class="form-control form-control-sm" formControlName="amount" id="amount" placeholder='{{getLabel("Amount")}}'>
                    </div>
                </div>
                <div class="form-group mb-3">
                        <textarea  class="form-control form-control-sm" id="description" formControlName="description" placeholder='{{getLabel("Description")}}'></textarea>
                </div>
                <div class="form-row">
                    <div class="col-lg-4 col-md-12 col-sm-12 mb-3">
                        <select  class="form-control form-control-sm" formControlName="type"  id="type">
                            <option value="-1" >{{getLabel("Expense-Item-Type")}}</option>
                            <option value="{{type.expenseItemTypeId}}" *ngFor="let type of expenseItemTypes">{{type.title}}</option>
                        </select>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-12 mb-3">
                        <input  type="date" class="form-control form-control-sm" formControlName="dateIncurred" id="dateIncurred" value="{{ millisecondsToDate(expenseObject.dateIncurred)  | date:'yyyy-MM-dd' }}" placeholder='{{getLabel("Expense-Date")}}'>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-12 d-flex mb-3">
                        <div class="form-check mry-auto">
                            <input class="form-check-input" type="checkbox" id="reimburse" formControlName="reimburse">
                            <label class="form-check-label" for="reimburse">
                                {{getLabel("Reimburse")}}
                            </label>
                        </div>
                    </div>
                    <div class="col-lg-12 col-md-12 col-sm-12 mb-3">
                        <div class="toolbar d-flex justify-content-end w-100 "
                             style="justify-content: flex-end!important;display: flex;">
                            <div class="input-group action-btn success d-flex justify-content-center  px-2">
                                <div class="input-group-prepend d-flex" (click)="onSubmit()">
                                    <fa-icon icon="save" title='{{getLabel("Save")}}' class=" middle"   ></fa-icon>
                                </div>
                            </div>
                            <div class="input-group action-btn danger d-flex justify-content-center  px-2">
                                <div class="input-group-prepend d-flex" (click)="deleteself()">
                                    <fa-icon icon="trash" title='{{getLabel("Delete")}}' class=" middle"   ></fa-icon>
                                </div>
                            </div>
                            <div class="input-group action-btn info d-flex justify-content-center  px-2">
                                <div class="input-group-prepend d-flex" (click)="editItem()">
                                    <fa-icon icon="times" title='{{getLabel("Cancel")}}' class=" middle"   ></fa-icon>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        `
})
export class ViewExpenseItemComponent extends baseComponent implements OnInit{
    expenseItemForm: FormGroup | undefined;
    private submitted :boolean =  false ;
    public isLoading:boolean  = false;
    public expenseItemTypes : Array<any> = [];
    public isEditing : boolean = false;
    // @ts-ignore
    @Input() expenseObject : any;
    // @ts-ignore
    @Input() currency : string;

    @Output() updateParent = new EventEmitter<string>();
    _componentId="View-Expense-Item-Screen";

    prepareForm()
    {
        this.expenseItemForm = this.formBuilder.group(
            {
                title: [this.expenseObject.title,Validators.required],
                description:  [this.expenseObject.description,Validators.required],
                type: [this.expenseObject.type,Validators.required],
                reimburse:[this.expenseObject.reimburse,Validators.required],
                amount:[this.expenseObject.amount,Validators.required],
                expenseItemId:[this.expenseObject.expenseItemId,Validators.required],
                dateIncurred:[new Date(parseInt(this.expenseObject.dateIncurred))
                    ,[Validators.required]],
                groupId : [this.liferaySrv.getScopedGroupId()]
        });
    }
    editItem()
    {
        this.isEditing = !this.isEditing;
        if(this.isEditing)
        {
            this.getExpenseItemTypes();
            this.prepareForm();
        }
        this.ref.detectChanges();
    }
    constructor(private formBuilder: FormBuilder,private ref: ChangeDetectorRef,
                private currencySrv: CurrencyService,
                public _TranslationService:TranslationService,
                private liferaySrv: LiferayService,private route:Router) {
        super(_TranslationService);
    }
    async onSubmit(){
        this.isLoading = true;
        var expenseItem = await this.liferaySrv.updateExpenseItem(this.expenseItemForm?.value);
        this.getExpenseItemTypes();
        this.expenseObject = expenseItem;
        this.isLoading = false;
        this.updateParent.emit("");
        this.isEditing = false;
    }
    async deleteself()
    {
        this.isLoading = true
        await this.liferaySrv.deleteExpenseItem(
            {
                expenseItemId:this.expenseObject.expenseItemId
            });
        this.isLoading = false;
        this.isEditing = false;
        this.updateParent.emit("");
    }
    get getControl(){
        // @ts-ignore
        return  this.expenseForm.controls;
    }
    ngOnInit(): void {
        super.ngOnInit();
        this.getExpenseItemTypes();
    }
    async  getExpenseItemTypes()
    {
        this.isLoading = true;
        this.expenseItemTypes = await this.liferaySrv
            .getExpenseItemTypesLiferay();
        this.isLoading = false;
    }
    getCurrentExpenseType(expenseTypeId:number)
    {
        //expenseItemTypeId
        var data = this.expenseItemTypes.filter(type=> type.expenseItemTypeId === expenseTypeId);
        return data[0].title;
    }
}