import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PessoaListComponent } from '../pessoa/pessoa-list/pessoa-list.component';
import { PessoaPostComponent } from '../pessoa/pessoa-post/pessoa-post.component';
import { PessoaPutComponent } from '../pessoa/pessoa-put/pessoa-put.component';

const routes: Routes = [
  {
    path: '', component: PessoaListComponent, children: [
      //{path: '', component: PessoaListComponent }
    ]
  },
  { path: 'pessoa', component: PessoaPostComponent },
  { path: 'pessoa/:id/editar', component: PessoaPutComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class LayoutRoutingModule { }
