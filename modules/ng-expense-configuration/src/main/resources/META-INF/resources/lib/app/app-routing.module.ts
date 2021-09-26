import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {guardService} from "./services/guard.service";
import {NotsignedInComponent} from "./views/general/notsignedIn.component";
import {translationComponent} from "./views/translation/list.component";
import {PortletsComponent} from "./views/translation/portlets.component";
import {ComponentsListComponent} from "./views/translation/components.component";
import {expenseTypesComponent} from "./views/expenseType/listExpenseTypes.component";


const routes: Routes = [
    {path: 'portletsList', component: PortletsComponent, canActivate: [guardService]},
    {path: 'expenseTypesList', component: expenseTypesComponent, canActivate: [guardService]},
    {path: 'componentsList/:portletId', component: ComponentsListComponent, canActivate: [guardService]},
    {path: 'translationsList/:portletId/:componentId', component: translationComponent, canActivate: [guardService]},
    {path: 'notSignedIn', component: NotsignedInComponent},
    {path: '', component: PortletsComponent},
    {path: '**', component: PortletsComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes, {useHash: true}),],
    providers: [guardService],
    exports: [RouterModule]
})
export class AppRoutingModule {

}

