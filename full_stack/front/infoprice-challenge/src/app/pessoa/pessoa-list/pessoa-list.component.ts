import { Component, OnInit } from '@angular/core';

import { PessoaService } from '../../service/pessoa.service';
import { Pessoa } from '../../model/pessoa';
import {Page} from '../../model/page';

@Component({
  selector: 'app-pessoa-list',
  templateUrl: './pessoa-list.component.html',
  styleUrls: ['./pessoa-list.component.css']
})
export class PessoaListComponent implements OnInit {
  
  displayedColumns: string[] = ['id', 'name', 'email', 'enderecos', 'acao'];

  pessoa: Pessoa = new Pessoa();
  pessoas: Page<Pessoa>;
  
  constructor(private pessoaService: PessoaService) {
  }

  ngOnInit() {
    this.pessoaService.read(1).then((pessoa: Pessoa) => {
      this.pessoa = pessoa;
    });
    this.pessoaService.getAll().then((pessoas: Page<Pessoa>) => {
      this.pessoas = pessoas;
    });
  }

  edit(id: Pessoa) {
    console.log('edit -> ');
    console.log(id);
  }

  addPhone(id: Pessoa) {
    console.log('addPhone -> ');
    console.log(id);
  }

  remove(id: Pessoa) {
    console.log('remove -> ');
    console.log(id);
  }
}
