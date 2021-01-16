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
{​​

  let params = new HttpParams()

            .set('username',username);

            //.set('password',password);

  const headers = new HttpHeaders({​​ Authorization: 'Bearer ' + username}​​);
  console.log(headers)
  return this.httpClient.get("http://localhost:8080/employee/login",{​​headers,params,responseType: 'text' as 'json'}​​);

}​​

}


