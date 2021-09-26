import {Component, OnInit} from '@angular/core';
import {Expense, LiferayService} from "../../services/liferay.service";
import {faFilm} from '@fortawesome/free-solid-svg-icons';
import {delay} from "rxjs";
import {Router} from "@angular/router";
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
                    <div *ngIf="!noData" class="row">
                        <div class="col-sm-12 col-md-3 col-lg-3" portlet *ngFor="let portlet of portlets" [portletId]="portlet.portletId" [portletName]="portlet.portletId">
                        </div>
                    </div>
                </div>
            </div>
        `
})
export class PortletsComponent extends baseComponent implements OnInit {
    public portlets: any[] | undefined = [];
    public isLoading: boolean = false;
    public noData: boolean = false;
    _componentId = "Portlets-List-Screen";

    constructor(public liferaySrv: LiferayService, private route: Router,
                public _TranslationService: TranslationService,_location:Location) {
        super(_TranslationService,_location);
    }

    ngOnInit() {
        super.ngOnInit();
        this.getPortlets();
    }

    public reload() {
        this.getPortlets();
    }

    public async getPortlets() {
        this.isLoading = true;
        this.portlets = [];
        try {
            var _portlets = await this.liferaySrv.getTranslatedPortlets();

        } catch (error) {
            this.noData = true;
            console.log(error);
        }
        this.portlets = _portlets;
        this.isLoading = false;
    }


}