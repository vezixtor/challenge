import { Component, OnInit } from '@angular/core';

import { PessoaService } from '../../service/pessoa.service';
import { Pessoa } from '../../model/pessoa';

@Component({
  selector: 'app-pessoa-list',
  templateUrl: './pessoa-list.component.html',
  styleUrls: ['./pessoa-list.component.css']
})
export class PessoaListComponent implements OnInit {

  pessoa: Pessoa = new Pessoa();
  
  constructor(pessoaService: PessoaService) {
    pessoaService.read(1).then((pessoa: Pessoa) => {
      this.pessoa = pessoa;
    });
  }

  ngOnInit() {
  }
}
