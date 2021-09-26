import {Component, Input, OnInit} from '@angular/core';
import {Expense, LiferayService} from "../../services/liferay.service";
import {faFilm} from '@fortawesome/free-solid-svg-icons';
import {delay} from "rxjs";
import {Router} from "@angular/router";
import {TranslationService} from "../../services/translation.service";
import {baseComponent} from "../../general/base.component";
import {FormsModule} from '@angular/forms';
import {Location} from "@angular/common";

@Component({
    template:
        `
            <div [routerLink]="['/translationsList/', portletId,componentId]" class="card card-interactive card-interactive-primary card-type-template template-card"  tabindex="0">
                <div class="aspect-ratio">
                    <div class="aspect-ratio-item aspect-ratio-item-center-middle aspect-ratio-item-flush">
                        <fa-icon icon="file-code" size="6x" class="middle"></fa-icon>
                    </div>
                </div>
                <div class="card-body">
                    <h3 class="card-title">{{componentName}}</h3>
                </div>
            </div>
        `,
    selector: '[component-lr]'
})
export class componentItemComponent extends baseComponent implements OnInit {
    _componentId = "listTranslationsComponent";
    @Input() componentId: string = "";
    @Input() componentName: string = "";
    @Input() portletId:string = "";
    constructor(public liferaySrv: LiferayService, private route: Router,
                public _TranslationService: TranslationService,_location:Location) {
        super(_TranslationService,_location);
    }

    ngOnInit() {
        super.ngOnInit();
    }


}