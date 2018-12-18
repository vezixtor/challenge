import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PessoaListComponent } from '../pessoa/pessoa-list/pessoa-list.component';
import { PessoaPostComponent } from '../pessoa/pessoa-post/pessoa-post.component';

const routes: Routes = [
  {
    path: '', component: PessoaListComponent, children: [
      //{path: '', component: PessoaListComponent }
    ]
  },
  { path: 'pessoa', component: PessoaPostComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class LayoutRoutingModule { }
