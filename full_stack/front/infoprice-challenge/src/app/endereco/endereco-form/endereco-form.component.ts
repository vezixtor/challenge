import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

import { EstadoService } from '../../service/estado.service';
import { Estado } from '../../model/estado';
import { CidadeService } from 'src/app/service/cidade.service';
import { Page } from 'src/app/model/page';
import { Cidade } from 'src/app/model/cidade';

@Component({
  selector: 'app-endereco-form',
  templateUrl: './endereco-form.component.html',
  styleUrls: ['./endereco-form.component.css']
})
export class EnderecoFormComponent implements OnInit {

  form: FormGroup;
  //endereco: Endereco
  estados: Estado[];
  cidades: Page<Cidade>;

  constructor(private estadoService: EstadoService, private cidadeService: CidadeService) {
  }

  ngOnInit() {
    this.estadoService.getAll().then((estados: Estado[]) => {
      this.estados = estados;
    });
  }

  onSubmit(form) {
    this.form = form;
    console.log(this.form.value);
  }

  selectEstado(estado: Estado) {
    console.log(estado);
    if (estado.toString() != '') {
      this.cidadeService.getByEstado(estado).then((cidades: Page<Cidade>) => {
        console.log(cidades);
        this.cidades = cidades;
      });
    }
  }
  
  selectCidade(cidade: any) {
    console.log(cidade);
  }
}
