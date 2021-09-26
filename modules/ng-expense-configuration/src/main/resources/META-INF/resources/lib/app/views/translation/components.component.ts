import {Component, OnInit} from '@angular/core';
import {Expense, LiferayService} from "../../services/liferay.service";
import {faFilm} from '@fortawesome/free-solid-svg-icons';
import {delay} from "rxjs";
import {ActivatedRoute, Router} from "@angular/router";
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
                                    <a (click)="goBack()" class="component-action" role="button">
                                        <fa-icon icon="arrow-left" title='{{getLabel("back")}}' class=" middle">
                                        </fa-icon>
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
                    <div *ngIf="!noData" class="row">
                        <div class="col-sm-12 col-md-3 col-lg-3" component-lr *ngFor="let component of components" 
                             [portletId]="portletId" [componentId]="component.componentId"
                             [componentName]="component.componentId">
                        </div>
                    </div>
                </div>
            </div>
        `
})
export class ComponentsListComponent extends baseComponent implements OnInit {
    public components: any[] | undefined = [];
    public isLoading: boolean = false;
    public noData: boolean = false;
    _componentId = "Components-List-Screen";
    portletId : string = "";
    constructor(public liferaySrv: LiferayService, private route: Router,
                private actRoute: ActivatedRoute,_location:Location,
                public _TranslationService: TranslationService) {
        super(_TranslationService,_location);
    }

    ngOnInit() {
        super.ngOnInit();
        this.actRoute.paramMap.subscribe( params => {
            this.isLoading = true;
            this.portletId = <string>params.get('portletId');
            this.getPortlets();
            this.isLoading = false;
        });
        this.getPortlets();
    }

    public reload() {
        this.getPortlets();
    }

    public async getPortlets() {
        this.isLoading = true;
        this.components = [];
        try {
            var _components = await this.liferaySrv.getTranslatedPortletsComponents(this.portletId);

        } catch (error) {
            this.noData = true;
            console.log(error);
        }
        this.components = _components;
        this.isLoading = false;
    }
    public goBack() {
        super.goBack();
        this.route.navigate(["/portletsList"]);
    }
}