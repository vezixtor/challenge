import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { FormGroup } from '@angular/forms';

import { Pessoa } from 'src/app/model/pessoa';

@Component({
  selector: 'app-pessoa-form',
  templateUrl: './pessoa-form.component.html',
  styleUrls: ['./pessoa-form.component.css']
})
export class PessoaFormComponent implements OnInit {

  form: FormGroup;

  @Input() pessoa = new Pessoa();
  pessoaJson = JSON.stringify(this.pessoa);
  @Output() submited = new EventEmitter();

  constructor() {
  }

  ngOnInit() {
    console.log(this.pessoa);
  }

  onSubmit(form) {
    this.form = form;
    this.submited.emit(this.form.value);
  }
}
