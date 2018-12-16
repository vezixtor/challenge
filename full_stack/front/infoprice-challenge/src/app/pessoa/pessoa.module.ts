import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MaterialModule } from '../shared/material-module';
import { PessoaService } from '../service/pessoa.service';
import { PessoaListComponent } from './pessoa-list/pessoa-list.component';

@NgModule({
  declarations: [PessoaListComponent],
  imports: [
    CommonModule,
    MaterialModule
  ],
  providers: [
    PessoaService
  ]
})
export class PessoaModule { }
