import {Injectable} from '@angular/core';
import {HttpHandler, HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

import {Utils} from './Utils';

@Injectable()
export class ApiHttpClient extends HttpClient {
  public baseUrl: string;

  public constructor(handler: HttpHandler) {
    super(handler);
    this.baseUrl = Utils.getServerURL();
  }

  public get(url: string, options?: Object): Observable<any> {
    url = this.baseUrl + url;
    console.log(url);
    return super.get(url, options);
  }
}
