import {Component, Input, OnInit} from '@angular/core';
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
                    <div class="table-list-title"><a class="text-truncate-inline" href="#1"> <span
                            class="text-truncate">{{Key}}</span> </a></div>
                </td>
                <td class="table-cell-expand">
                    <span class="text-truncate-inline">
                        <span class="text-truncate" *ngIf="!isEditing">
                            {{translationValue}}
                        </span>
                        <input  *ngIf="isEditing" type="text" class="form-control form-control-sm" 
                                id="title"  
                                [(ngModel)] = "translationValue"
                                placeholder='{{getLabel("TranslationValue")}}'>
                    </span>
                </td>
                <td class="table-cell-expand"><span class="text-truncate-inline"> <span
                        class="text-truncate">{{CultureCode}} </span> </span>
                </td>
                <td class="table-cell-expand"><span class="text-truncate-inline"> <span
                        class="text-truncate">{{PortletId}} </span> </span>
                </td>
                <td class="table-cell-expand"><span class="text-truncate-inline"> <span
                        class="text-truncate">{{ComponentID}} </span> </span>
                </td>
                <td class="table-column-text-end">
                    <div class="btn-group btn-group-nowrap">
                        <div class="btn-group-item" *ngIf="!isEditing">
                            <button (click)="editSelf()" title='{{getLabel("Edit-Translation")}}'
                                    class="btn  btn-outline-info btn-sm" type="button">
                                <fa-icon icon="edit" class=" middle"></fa-icon>
                            </button>
                        </div>
                        <div class="btn-group-item" *ngIf="isEditing">
                            <button (click)="editSelf()" title='{{getLabel("Edit-Translation")}}'
                                    class="btn  btn-outline-info btn-sm" type="button">
                                <fa-icon icon="arrow-left" class=" middle"></fa-icon>
                            </button>
                        </div>
                        <div class="btn-group-item" *ngIf="isEditing">
                            <button (click)="updateSelf()" title='{{getLabel("Edit-Translation")}}'
                                    class="btn btn-outline-success btn-sm" type="button">
                                <fa-icon icon="save" class=" middle"></fa-icon>
                            </button>
                        </div>
                    </div>
                </td>
        `,
    selector: '[translation-item]'
})
export class translationItemComponent extends baseComponent implements OnInit {
    _componentId = "listTranslationsComponent";
    @Input() Key: string = "";
    @Input() TranslationValue: string = "";
    @Input() CultureCode: string = "";
    @Input() PortletId: string = "";
    @Input() ComponentID: string = "";
    @Input() TranslationId: string = "";
    public translationId : string = "";
    public translationValue = "";
    isEditing: boolean = false;

    constructor(public liferaySrv: LiferayService, private route: Router,
                public _TranslationService: TranslationService,_location:Location) {
        super(_TranslationService,_location);
        this.translationValue = this.TranslationValue;
        this.translationId = this.TranslationId;
    }

    ngOnInit() {
        super.ngOnInit();
        this.translationValue = this.TranslationValue;
    }

    editSelf() {
        this.isEditing = !this.isEditing;
    }
    updateSelf()
    {
        this.liferaySrv.updateTranslationValue(this.TranslationId,this.translationValue);
        this.isEditing = false;
    }

}