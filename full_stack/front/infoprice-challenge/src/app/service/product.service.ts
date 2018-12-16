import {EventEmitter, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {FormGroup} from '@angular/forms';
import {Pessoa} from '../model/pessoa';

@Injectable()
export class ProductService {

  eventEmitter = new EventEmitter<Pessoa>();

  product: Pessoa = new Pessoa();

  constructor(private http: HttpClient) {
  }

  emitProduct(product: Pessoa) {
    this.eventEmitter.emit(product);
  }

  getAll() {
    return new Promise(resolve => {
      this.http.get<Pessoa[]>('/pessoa')
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
