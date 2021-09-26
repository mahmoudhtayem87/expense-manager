import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {listComponent} from "./views/expense/list/list.component";
import {editExpenseComponent} from "./views/expense/crud/edit.component";



const routes: Routes = [
    { path: 'expenselist', component: listComponent },
    { path: 'expenseEdit', component: editExpenseComponent },
    { path: '',component:listComponent },
    {path: '**',component: listComponent}

];

@NgModule({
    imports: [ RouterModule.forRoot(routes,{useHash:true}) ],
    exports: [ RouterModule ]
})
export class AppRoutingModule
{

}