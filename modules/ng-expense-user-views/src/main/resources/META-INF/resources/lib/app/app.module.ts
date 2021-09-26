import { DoBootstrap, NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {BrowserModule} from '@angular/platform-browser';
import {APP_BASE_HREF, CommonModule} from '@angular/common';
import {AppComponent} from './app.component';
import {listComponent} from './views/expense/list/list.component';
import {AppRoutingModule} from "./app-routing.module";
import {EditExpenseComponent} from "./views/expense/crud/edit.component";
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
    faSpinner, faReceipt
} from "@fortawesome/free-solid-svg-icons";
import {CreateExpenseComponent} from "./views/expense/crud/create.component";
import {CreateExpenseItemComponent} from "./views/expense/expense-item/createExpenseItem.component";
import {ViewExpenseItemComponent} from "./views/expense/expense-item/viewExpenseItem.component";
import {noDataComponent} from "./views/shared/noData.component";
import {NotsignedInComponent} from "./views/general/notsignedIn.component";
import {guardService} from "./services/guard.service";
import {ViewExpenseComponent} from "./views/expense/crud/view.component";
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
    providers: [{provide: APP_BASE_HREF, useValue: "/"},guardService],
    schemas: [CUSTOM_ELEMENTS_SCHEMA],
    entryComponents: [AppComponent],
    declarations: [
        listComponent,
        ViewExpenseItemComponent,
        ViewExpenseComponent,
        noDataComponent,
        CreateExpenseItemComponent,
        EditExpenseComponent,
        CreateExpenseComponent,
        NotsignedInComponent,
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
        library.addIcons(faReceipt);
        library.addIcons(faSpinner);
    }
    ngDoBootstrap() {
    }
}