import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Expense, LiferayService} from "../../services/liferay.service";
import {faFilm} from '@fortawesome/free-solid-svg-icons';
import {delay} from "rxjs";
import {Router} from "@angular/router";
import {TranslationService} from "../../services/translation.service";
import {baseComponent} from "../../general/base.component";
import { FormsModule } from '@angular/forms';
import {Location} from "@angular/common";
@Component({
    template:
        `
                <td class="table-cell-expand">
                    <span class="text-truncate-inline">
                        <span class="text-truncate" *ngIf="!isEditing && !isCreateNew">
                            {{title}}
                        </span>
                        <input  *ngIf="isEditing || isCreateNew" type="text" class="form-control form-control-sm" 
                                id="title"  
                                [(ngModel)] = "title"
                                placeholder='{{getLabel("Title")}}'>
                    </span>
                </td>
                <td class="table-cell-expand">
                    <span class="text-truncate-inline">
                        <span class="text-truncate" *ngIf="!isEditing && !isCreateNew">
                            {{value}}
                        </span>
                        <input  *ngIf="isEditing || isCreateNew" type="text" class="form-control form-control-sm"
                                id="value"
                                [(ngModel)] = "value"
                                placeholder='{{getLabel("Value")}}'>
                    </span>
                </td>
                <td class="table-column-text-end">
                    <div class="btn-group btn-group-nowrap">
                        <div class="btn-group-item" *ngIf="!isEditing && !isCreateNew">
                            <button (click)="deleteSelf()" title='{{getLabel("Delete-ExpenseType")}}'
                                    class="btn  btn-outline-danger btn-sm" type="button">
                                <fa-icon icon="trash" class=" middle"></fa-icon>
                            </button>
                        </div>
                        <div class="btn-group-item" *ngIf="!isEditing && !isCreateNew">
                            <button (click)="editSelf()" title='{{getLabel("Edit-ExpenseType")}}'
                                    class="btn  btn-outline-info btn-sm" type="button">
                                <fa-icon icon="edit" class=" middle"></fa-icon>
                            </button>
                        </div>
                        <div class="btn-group-item" *ngIf="isEditing && !isCreateNew">
                            <button (click)="editSelf()" title='{{getLabel("Cancel")}}'
                                    class="btn  btn-outline-info btn-sm" type="button">
                                <fa-icon icon="arrow-left" class=" middle"></fa-icon>
                            </button>
                        </div>
                        <div class="btn-group-item" *ngIf="isEditing || isCreateNew">
                            <button (click)="updateSelf()" title='{{getLabel("Save")}}'
                                    class="btn btn-outline-success btn-sm" type="button">
                                <fa-icon icon="save" class=" middle"></fa-icon>
                            </button>
                        </div>
                    </div>
                </td>
        `,
    selector: '[expense-type-item]'
})
export class expenseTypeItemComponent extends baseComponent implements OnInit {
    _componentId = "Expense-Item-Type-List-Row";
    @Input() Title: string = "";
    @Input() Value: string = "";
    @Input() ExpenseItemTypeId: string = "";
    @Output() Parent= new EventEmitter<any>();
    @Output() ParentDelete= new EventEmitter<string>();
    public expenseItemTypeId : string = "";
    public value = "";
    public title = "";
    isEditing: boolean = false;

    constructor(public liferaySrv: LiferayService, private route: Router,
                public _TranslationService: TranslationService,_location:Location) {
        super(_TranslationService,_location);
        this.value = this.Value;
        this.title = this.Title;
        this.expenseItemTypeId = this.ExpenseItemTypeId;
    }

    ngOnInit() {
        super.ngOnInit();
        this.value = this.Value;
        this.title = this.Title;
        this.expenseItemTypeId = this.ExpenseItemTypeId;
    }
    async deleteSelf()
    {
        await this.liferaySrv.deleteExpenseTypeItem(this.expenseItemTypeId);
        this.ParentDelete.emit(this.expenseItemTypeId);
    }
    editSelf() {
        this.isEditing = !this.isEditing;
    }
    async updateSelf()
    {
        console.log(this.expenseItemTypeId);
        // @ts-ignore
        console.log(this.expenseItemTypeId === -1);
        // @ts-ignore
        if (this.expenseItemTypeId === -1)
        {
            var expenseItemType = await this.liferaySrv.createExpenseTypeItem(this.title,this.value);
            this.isEditing = false;
            this.Parent.emit(expenseItemType);
        }
        else
        {
            this.liferaySrv.updateExpenseTypeItem(this.expenseItemTypeId,this.title,this.value);
            this.isEditing = false;
        }

    }
    public get isCreateNew():boolean
    {
        // @ts-ignore
        return this.expenseItemTypeId === -1;
    }

}