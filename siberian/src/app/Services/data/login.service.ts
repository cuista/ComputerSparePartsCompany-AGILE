import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

constructor(
  private httpClient: HttpClient
) {}

  getLogin(username: string, password:string)
  {
    let params = new HttpParams()
              .set('username',username)
              .set('password',password);
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.get<Boolean>("http://localhost:8080/customer/login",{params});
  }

}


