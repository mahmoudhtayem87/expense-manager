import {Component, Input, OnInit} from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import {LiferayService} from "../../../services/liferay.service";
import {ActivatedRoute, Router} from "@angular/router";
import {CurrencyService} from "../../../services/currency.service";
import {baseComponent} from "../../../general/base.component";
import {TranslationService} from "../../../services/translation.service";


@Component({
    template:
        `
            <div class="card" *ngIf="isLoaded">
                <div class="card-body">
                    <h5 class="card-title">{{ExpenseItem.title}}</h5>
                    <h6 class="card-subtitle mb-2 text-muted"> 
                        {{millisecondsToDate(ExpenseItem.createDate) | date:'medium'}}
                    </h6>
                    <p class="card-text">
                        {{ExpenseItem.description}}
                    </p>
                    <div class="card-footer d-flex">
                        <div class="col-auto">
                            <section class="autofit-section">
                                {{getLabel("Total-Amount")}}
                            </section>
                        </div>
                        <div class="col-auto autofit-col-expand">
                            <section class="autofit-section">
                                {{ExpenseItem.amount}} - {{ExpenseItem.currency}}
                            </section>
                        </div>
                    </div>
                </div>
            </div>
        `,
    selector:'expense-view'
})
export class ViewExpenseComponent extends baseComponent implements OnInit{
    _componentId="View-Expense-Project-Screen";
    public isLoaded = false;
    @Input() expenseId : number  = 0;
    public ExpenseItem:any = undefined;
    constructor(private formBuilder: FormBuilder,private actRoute: ActivatedRoute,
                private currencySrv: CurrencyService,_translationSrv : TranslationService,
                private liferaySrv: LiferayService,private route:Router) {
        super(_translationSrv);
    }
    ngOnInit(): void {
        super.ngOnInit();
        this.loadExpenseData(this.expenseId);
    }
    public updateSelf()
    {
        this.loadExpenseData(this.expenseId);
    }
    async loadExpenseData(expenseId: number | undefined)
    {
        this.ExpenseItem = await this.liferaySrv.getExpenseById(this.expenseId);
        this.isLoaded = true;
    }
}