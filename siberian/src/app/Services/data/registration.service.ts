import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(
    private httpClient: HttpClient
  ) { }

  saveCustomer(name: string, surname:string,phoneNumber: string, email:string,username: string,password: string, vatID: string)
  {
    
    const params = new HttpParams()
              .set('name',name)
              .set('surname',surname)
              .set('phoneNumber',phoneNumber)
              .set('email',email)
              .set('username',username)
              .set('password',password)
              .set('vatID',vatID);
            

    
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.post<Boolean>("http://localhost:8080/customer/register-param?"+params,{headers:headers});
  }


  getUsername(username: string)
  {
    let params = new HttpParams()
              .set('username',username);
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.get<Boolean>("http://localhost:8080/customer/user-check",{params});
  }

  getEmail(email: string)
  {
    let params = new HttpParams()
              .set('email',email);
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.get<Boolean>("http://localhost:8080/customer/email-check",{params});
  }
}
