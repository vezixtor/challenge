import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { MaterialModule } from '../shared/material-module';
import { PessoaService } from '../service/pessoa.service';
import { PessoaListComponent } from './pessoa-list/pessoa-list.component';
import { PessoaFormComponent } from './pessoa-form/pessoa-form.component';

@NgModule({
  declarations: [
    PessoaListComponent, 
    PessoaFormComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
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
