import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import {LiferayService} from "../../../services/liferay.service";
import {Router} from "@angular/router";
import {CurrencyService} from "../../../services/currency.service";
import {baseComponent} from "../../../general/base.component";
import {TranslationService} from "../../../services/translation.service";


@Component({
    selector:'expense-item-create',
    template:
        `
            <form [formGroup]="expenseItemForm" (ngSubmit)="onSubmit()" novalidate>
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
                        <input  type="date" class="form-control form-control-sm" formControlName="dateIncurred" id="dateIncurred" placeholder='{{getLabel("Expense-Date")}}'>
                    </div>
                    <div class="col-lg-4 col-md-6 col-sm-12 d-flex mb-3">
                        <div class="form-check mry-auto">
                            <input class="form-check-input" type="checkbox" id="reimburse" formControlName="reimburse">
                            <label class="form-check-label" for="reimburse">
                                {{getLabel("Reimburse")}}
                            </label>
                        </div>
                    </div>
                </div>
                <div *ngIf="!isLoading" class="form-group row d-flex justify-content-end">
                    <button type="submit" class="btn btn-primary">{{getLabel("Create-Item")}}</button>
                </div>
            </form>
        `
})
export class CreateExpenseItemComponent extends baseComponent implements OnInit{
    expenseItemForm: FormGroup | undefined;
    private submitted :boolean =  false ;
    public isLoading:boolean  = false;
    public createdExpense :any = {};
    public expenseItemTypes : Array<any> = [];
    _componentId="Create-New-Expense-Item-Screen";
    // @ts-ignore
    @Input() expenseID : number;
    @Output() updateParent = new EventEmitter<string>();

    prepareForm()
    {
        this.expenseItemForm = this.formBuilder.group(
            {
                title: ['',Validators.required],
                description:  ['',Validators.required],
                type: ['-1',Validators.required],
                reimburse:[true,Validators.required],
                amount:['',Validators.required],
                expenseId:[this.expenseID,Validators.required],
                dateIncurred:[new Date(),[Validators.required]],
                groupId : [this.liferaySrv.getScopedGroupId()]
        });
    }
    constructor(private formBuilder: FormBuilder,
                public _translationService : TranslationService,
                private currencySrv: CurrencyService,
                private liferaySrv: LiferayService,private route:Router) {
        super(_translationService);
    }
    async onSubmit(){
        this.isLoading = true;
        var expenseItem = await this.liferaySrv.createExpenseItem(this.expenseItemForm?.value);
        console.log(expenseItem);
        this.createdExpense = expenseItem;
        this.updateParent.emit();
        this.isLoading = false;
    }
    get getControl(){
        // @ts-ignore
        return  this.expenseForm.controls;
    }
    ngOnInit(): void {
        this.getExpenseItemTypes();
        this.prepareForm();
    }

    async getExpenseTypeIdById(id:number)
    {
        var expenseTypeItem = await this.liferaySrv.getExpenseTypeById(id);
        return expenseTypeItem;
    }

    async getExpenseItemTypes()
    {
        this.isLoading = true;
        this.expenseItemTypes = await this.liferaySrv
            .getExpenseItemTypesLiferay();
        this.isLoading = false;
    }
}