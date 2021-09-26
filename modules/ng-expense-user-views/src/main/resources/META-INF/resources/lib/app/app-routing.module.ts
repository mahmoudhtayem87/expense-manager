import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {listComponent} from "./views/expense/list/list.component";
import {EditExpenseComponent} from "./views/expense/crud/edit.component";
import {CreateExpenseComponent} from "./views/expense/crud/create.component";
import {guardService} from "./services/guard.service";
import {NotsignedInComponent} from "./views/general/notsignedIn.component";


const routes: Routes = [
    {path: 'expenselist', component: listComponent, canActivate: [guardService]},
    {path: 'expenseEdit/:id', component: EditExpenseComponent, canActivate: [guardService]},
    {path: 'expenseCreate', component: CreateExpenseComponent, canActivate: [guardService]},
    {path: 'notSignedIn', component: NotsignedInComponent},
    {path: '', component: listComponent},
    {path: '**', component: listComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes, {useHash: true}),],
    providers: [guardService],
    exports: [RouterModule]
})
export class AppRoutingModule {

}

