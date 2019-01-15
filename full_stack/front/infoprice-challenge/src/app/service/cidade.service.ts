import {EventEmitter, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {FormGroup} from '@angular/forms';

import {ApiHttpClient} from '../shared/api.http.client';
import {Cidade} from '../model/cidade';
import { Page } from '../model/page';
import { Estado } from '../model/estado';

@Injectable()
export class CidadeService {

  constructor(private http: ApiHttpClient) {
  }

  getAll() {
    return new Promise(resolve => {
      this.http.get<Page<Cidade>>('/cidade')
        .subscribe(success => {
          resolve(success);
        }, err => {
          console.log(err);
        });
    });
  }

  getByEstado(estado: Estado) {
    return new Promise(resolve => {
      this.http.get<Page<Cidade>>('/cidade/estado/' + estado)
        .subscribe(success => {
          resolve(success);
        }, err => {
          console.log(err);
        });
    });
  }
}
