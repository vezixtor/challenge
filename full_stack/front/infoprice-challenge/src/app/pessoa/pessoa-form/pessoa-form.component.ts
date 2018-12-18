import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

import { PessoaService } from 'src/app/service/pessoa.service';

@Component({
  selector: 'app-pessoa-form',
  templateUrl: './pessoa-form.component.html',
  styleUrls: ['./pessoa-form.component.css']
})
export class PessoaFormComponent implements OnInit {
  form: FormGroup;
  
  constructor(private pessoaService: PessoaService) {
  }

  ngOnInit() {
  }

  onSubmit(form) {
    this.form = form;
    console.log(this.form.value);
    this.create();
  }

  create() {
    this.pessoaService.create(this.form)
      .then((pessoa: any) => console.log(pessoa))
      .catch(error => console.log(error));
  }

}
