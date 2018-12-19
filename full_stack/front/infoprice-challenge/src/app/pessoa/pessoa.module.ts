import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { MaterialModule } from '../shared/material-module';
import { PessoaService } from '../service/pessoa.service';
import { PessoaListComponent } from './pessoa-list/pessoa-list.component';
import { PessoaFormComponent } from './pessoa-form/pessoa-form.component';
import { PessoaPostComponent } from './pessoa-post/pessoa-post.component';
import { PessoaPutComponent } from './pessoa-put/pessoa-put.component';

@NgModule({
  declarations: [
    PessoaListComponent,
    PessoaPostComponent, 
    PessoaFormComponent, PessoaPutComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    MaterialModule
  ],
  providers: [
    PessoaService
  ],
  exports: [
    PessoaFormComponent
  ]
})
export class PessoaModule { }
