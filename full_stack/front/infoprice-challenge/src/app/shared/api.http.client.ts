import {Injectable} from '@angular/core';
import {HttpHandler, HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

import { environment } from "../../environments/environment";

@Injectable()
export class ApiHttpClient extends HttpClient {
  public baseUrl: string;

  public constructor(handler: HttpHandler) {
    super(handler);
    this.baseUrl = environment.baseUrl;
  }

  private changeBaseUrl(url: string) {
    url = this.baseUrl + url;
    console.log(url);
    return url;
  }

  public post<T>(url: string, options?: Object): Observable<any> {
    return super.post(this.changeBaseUrl(url), options);
  }

  public get<T>(url: string, options?: Object): Observable<any> {
    return super.get(this.changeBaseUrl(url), options);
  }

  public put<T>(url: string, options?: Object): Observable<any> {
    return super.put(this.changeBaseUrl(url), options);
  }

  public delete<T>(url: string, options?: Object): Observable<any> {
    return super.delete(this.changeBaseUrl(url), options);
  }
}
