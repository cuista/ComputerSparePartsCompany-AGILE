import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ICustomer } from 'src/app/actors/customer';
import { IEmployee } from 'src/app/actors/employee';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(
    private httpClient: HttpClient
  ) { }

  getEmployee(username: string):Observable<IEmployee>
  {
    const params = new HttpParams()
              .set('username',username);
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.get<IEmployee>("http://localhost:8080//employee/by-username",{headers,params});  
  }

  getCustomer(username: string):Observable<ICustomer>
  {
    const params = new HttpParams()
              .set('username',username);
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.get<ICustomer>("http://localhost:8080//customer/by-username",{headers,params});  
  }

  deleteCustomer(username:string)
  {
    const params = new HttpParams()
              .set('username',username);
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.delete<Boolean>("http://localhost:8080//customer/del-customer",{headers,params})
  }

  getUserAmount(username: string)
  {
    return this.httpClient.get<number>(`http://localhost:8080/customer/report-totalamount?username=${username}`);  
  }

  getTotalPurchase(username: string)
  {
    return this.httpClient.get<number>(`http://localhost:8080/customer/report-totalpurchases?username=${username}`);  
  }

  getFavoriteCategory(username: string)
  {
    return this.httpClient.get<string>(`http://localhost:8080/customer/report-favoritecategory?username=${username}`,{responseType:'text' as 'json'});  
  }

  changePasswordCustomer(username: string, password:string, oldPassword:string)
  {
    const params = new HttpParams()
              .set('username',username)
              .set('password',password)
              .set('oldPassword',oldPassword);
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.post<Boolean>("http://localhost:8080/customer/change-password?"+params,{headers:headers});
  }

  changePasswordEmployee(username: string, password:string, oldPassword:string)
  {
    const params = new HttpParams()
              .set('username',username)
              .set('password',password)
              .set('oldPassword',oldPassword);
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.post<Boolean>("http://localhost:8080/employee/change-password?"+params,{headers:headers});
  }

  changeDataEmployee(username: string, name:string, surname:string,phoneNumber:string,iva:string)
  {
    const params = new HttpParams()
              .set('username',username)
              .set('name',name)
              .set('surname',surname)
              .set('phoneNumber',phoneNumber)
              .set('iva',iva);
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.post<Boolean>("http://localhost:8080/customer/update-data?"+params,{headers:headers});
  }

  getUsernames()
  {
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.get("http://localhost:8080//customer/all-usernames",{headers});
  }

  


}

