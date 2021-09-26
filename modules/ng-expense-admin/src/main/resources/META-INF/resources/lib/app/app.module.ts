import {ApplicationRef, DoBootstrap, NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserModule} from '@angular/platform-browser';
import {APP_BASE_HREF, CommonModule, HashLocationStrategy, LocationStrategy} from '@angular/common';
import {AppComponent} from './app.component';
import {listComponent} from './views/expense/list/list.component';
import {RouterModule, Routes} from "@angular/router";


import {ModuleWithProviders} from "@angular/core";
import {AppRoutingModule} from "./app-routing.module";
import {editExpenseComponent} from "./views/expense/crud/edit.component";
import { HttpClientModule } from '@angular/common/http';
import { CUSTOM_ELEMENTS_SCHEMA} from '@angular/core';
import { far } from '@fortawesome/free-regular-svg-icons';
import {FaIconLibrary, FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import {
    fas,
    faCoffee,
    faEdit,
    faExpand,
    faInfo,
    faCheck,
    faCross,
    faSave,
    faSpinner
} from "@fortawesome/free-solid-svg-icons";
declare const Liferay: any;
@NgModule({
    imports: [
        BrowserModule,
        CommonModule,
        FontAwesomeModule,
        FormsModule,
        ReactiveFormsModule,
        AppRoutingModule,
        HttpClientModule

    ],
    providers: [{provide: APP_BASE_HREF, useValue: "/"}],
    schemas: [CUSTOM_ELEMENTS_SCHEMA],
    entryComponents: [AppComponent],
    declarations: [
        listComponent,
        editExpenseComponent,
        AppComponent
    ],
    bootstrap: [] // Do not bootstrap anything (see ngDoBootstrap() below)
})
export class AppModule implements DoBootstrap {
    constructor(library: FaIconLibrary) {
        library.addIconPacks(fas);
        library.addIconPacks(far);
        library.addIcons(faCoffee);
        library.addIcons(faEdit);
        library.addIcons(faCross);
        library.addIcons(faInfo);
        library.addIcons(faCheck);
        library.addIcons(faSave);
        library.addIcons(faSpinner);


    }
    // Avoid bootstraping any component statically because we need to attach to
    // the portlet's DOM, which is different for each portlet instance and,
    // thus, cannot be determined until the page is rendered (during runtime).
    ngDoBootstrap() {
    }
}