import { Injectable } from '@angular/core';
import {ActivatedRoute, Resolve} from '@angular/router';
import {TranslationService} from './translation.service';
import { Observable, of } from 'rxjs';
import { map, catchError } from 'rxjs/operators';


@Injectable()
export class DataResolver implements Resolve<any> {
    constructor(private _translationService:TranslationService,private actRoute: ActivatedRoute) { }

    resolve() {
        console.log(this.actRoute.snapshot);
        this._translationService.loadTranslations();
        return null;
    }
}