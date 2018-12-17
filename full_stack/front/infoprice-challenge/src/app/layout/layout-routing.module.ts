import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PessoaListComponent } from '../pessoa/pessoa-list/pessoa-list.component';
import { PessoaFormComponent } from '../pessoa/pessoa-form/pessoa-form.component';

const routes: Routes = [
  {
    path: '', component: PessoaListComponent, children: [
      //{path: '', component: PessoaListComponent }
    ]
  },
  { path: 'pessoa', component: PessoaFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class LayoutRoutingModule { }
