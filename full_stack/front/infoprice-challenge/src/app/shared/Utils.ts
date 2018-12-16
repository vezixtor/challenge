import {Injectable} from '@angular/core';

@Injectable()
export class Utils {

  constructor() {
  }

  public static getServerURL(): string {
    return 'http://localhost:8080/v1';
  }
}
