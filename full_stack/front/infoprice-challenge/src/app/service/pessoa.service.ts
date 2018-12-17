import {EventEmitter, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {FormGroup} from '@angular/forms';

import { ApiHttpClient } from '../shared/api.http.client';
import {Pessoa} from '../model/pessoa';
import {Page} from '../model/page';

@Injectable()
export class PessoaService {

  eventEmitter = new EventEmitter<Pessoa>();

  pessoa: Pessoa = new Pessoa();

  constructor(private http: ApiHttpClient) {
  }

  emitProduct(pessoa: Pessoa) {
    this.eventEmitter.emit(pessoa);
  }

  getAll() {
    console.log('getAll');
    return new Promise(resolve => {
      this.http.get<Page<Pessoa>>('/pessoa')
        .subscribe(success => {
          resolve(success);
        }, err => {
          console.log(err);
        });
    });
  }

  create(formGroup: FormGroup) {
    return new Promise(resolve => {
      this.http.post<Pessoa>('/pessoa', formGroup.value)
        .subscribe(success => {
          resolve(success);
        }, err => {
          console.log(err);
        });
    });
  }

  read(id: number) {
    return new Promise(resolve => {
      this.http.get<Pessoa>(`/pessoa/${id}`)
        .subscribe(success => {
          resolve(success);
        }, err => {
          console.log(err);
        });
    });
  }

  update(formGroup: FormGroup) {
    return new Promise(resolve => {
      this.http.put<Pessoa>('/pessoa', formGroup.value)
        .subscribe(success => {
          resolve(success);
        }, err => {
          console.log(err);
        });
    });
  }

  delete(id: number) {
    return new Promise(resolve => {
      this.http.delete(`/pessoa/${id}`)
        .subscribe(success => {
          resolve(success);
        }, err => {
          console.log(err);
        });
    });
  }

}
