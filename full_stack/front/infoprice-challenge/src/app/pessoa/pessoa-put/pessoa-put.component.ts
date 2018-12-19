import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

import { PessoaService } from 'src/app/service/pessoa.service';
import { Pessoa } from 'src/app/model/pessoa';

@Component({
  selector: 'app-pessoa-put',
  templateUrl: './pessoa-put.component.html',
  styleUrls: ['./pessoa-put.component.css']
})
export class PessoaPutComponent implements OnInit {

  pessoaSelected: Pessoa = new Pessoa();

  constructor(private pessoaService: PessoaService, 
    private router: Router, private route: ActivatedRoute) {
  }

  ngOnInit() {
    let id = parseInt(this.route.snapshot.paramMap.get('id'));
    this.pessoaService.read(id).then((pessoa: Pessoa) => {
      this.pessoaSelected = pessoa;
    });
  }

  onSubmit(pessoaEvent: Pessoa) {
    pessoaEvent.id = this.pessoaSelected.id;
    this.pessoaService.update(pessoaEvent)
      .then((pessoa: any) => console.log(pessoa))
      .catch(error => console.log(error));
  }
}
