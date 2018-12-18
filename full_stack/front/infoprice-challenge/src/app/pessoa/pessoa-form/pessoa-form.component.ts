import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-pessoa-form',
  templateUrl: './pessoa-form.component.html',
  styleUrls: ['./pessoa-form.component.css']
})
export class PessoaFormComponent implements OnInit {

  form: FormGroup;

  @Output() submited = new EventEmitter();

  constructor() {
  }

  ngOnInit() {
  }

  onSubmit(form) {
    this.form = form;
    console.log(this.form.value);
    this.submited.emit(this.form.value);
    //this.create();
  }

}
