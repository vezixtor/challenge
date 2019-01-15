import {EventEmitter, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {FormGroup} from '@angular/forms';

import {ApiHttpClient} from '../shared/api.http.client';
import {Estado} from '../model/estado';

@Injectable()
export class EstadoService {

  constructor(private http: ApiHttpClient) {
  }

  getAll() {
    return new Promise(resolve => {
      this.http.get<Estado[]>('/estado')
        .subscribe(success => {
          resolve(success);
        }, err => {
          console.log(err);
        });
    });
  }
}
