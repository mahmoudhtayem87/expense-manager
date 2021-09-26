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
            <div [routerLink]="['/componentsList/', portletId]" class="card card-interactive card-interactive-primary card-type-template template-card"  tabindex="0">
                <div class="aspect-ratio">
                    <div class="aspect-ratio-item aspect-ratio-item-center-middle aspect-ratio-item-flush">
                        <fa-icon icon="code" size="6x" class="middle"></fa-icon>
                    </div>
                </div>
                <div class="card-body">
                    <h3 class="card-title">{{portletName}}</h3>
                </div>
            </div>
        `,
    selector: '[portlet]'
})
export class portletItemComponent extends baseComponent implements OnInit {
    _componentId = "listTranslationsComponent";
    @Input() portletId: string = "";
    @Input() portletName: string = "";
    constructor(public liferaySrv: LiferayService, private route: Router,
                _location:Location, public _TranslationService: TranslationService) {
        super(_TranslationService,_location);
    }

    ngOnInit() {
        super.ngOnInit();
    }


}