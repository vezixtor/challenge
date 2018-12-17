import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PessoaListComponent } from '../pessoa/pessoa-list/pessoa-list.component';

const routes: Routes = [{
  path: '', component: PessoaListComponent, children: [
    {path: '', component: PessoaListComponent }
  ]
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class LayoutRoutingModule { }
