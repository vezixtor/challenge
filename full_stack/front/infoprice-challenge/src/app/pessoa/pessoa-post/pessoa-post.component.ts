import { Component, OnInit } from '@angular/core';

import { PessoaService } from 'src/app/service/pessoa.service';
import { Pessoa } from 'src/app/model/pessoa';

@Component({
  selector: 'app-pessoa-post',
  templateUrl: './pessoa-post.component.html',
  styleUrls: ['./pessoa-post.component.css']
})
export class PessoaPostComponent implements OnInit {

  constructor(private pessoaService: PessoaService) {
  }

  ngOnInit() {
  }

  onSubmit(pessoaEvent: Pessoa) {
    this.pessoaService.create(pessoaEvent)
      .then((pessoa: any) => console.log(pessoa))
      .catch(error => console.log(error));
  }
}
