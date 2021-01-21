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

  getEmployee(): Observable<IEmployee> {
    const params = new HttpParams()
      .set('username', sessionStorage.getItem('user') as string)
      .set('password', sessionStorage.getItem('password') as string)
      .set('type', sessionStorage.getItem('type') as string);
    const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
    return this.httpClient.get<IEmployee>("http://localhost:8080//employee/by-username?" + params, { headers });
  }

  getCustomer(): Observable<ICustomer> {
    const params = new HttpParams()
      .set('username', sessionStorage.getItem('user') as string)
      .set('password', sessionStorage.getItem('password') as string)
      .set('type', sessionStorage.getItem('type') as string);
    const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
    return this.httpClient.get<ICustomer>("http://localhost:8080//customer/by-username?" + params, { headers });
  }

  deleteCustomer() {
    const params = new HttpParams()
      .set('username', sessionStorage.getItem('user') as string)
      .set('password', sessionStorage.getItem('password') as string);
    const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
    return this.httpClient.delete<Boolean>("http://localhost:8080//customer/del-customer", { headers, params })
  }

  getUserAmount() {

    const params = new HttpParams()
      .set('username', sessionStorage.getItem('user') as string)
      .set('password', sessionStorage.getItem('password') as string);
    const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
    return this.httpClient.get<number>("http://localhost:8080/customer/report-totalamount?" + params);
  }

  getTotalPurchase() {
    const params = new HttpParams()
      .set('username', sessionStorage.getItem('user') as string)
      .set('password', sessionStorage.getItem('password') as string);
    const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
    return this.httpClient.get<number>("http://localhost:8080/customer/report-totalpurchases?" + params);
  }

  getFavoriteCategory() {

    const params = new HttpParams()
      .set('username', sessionStorage.getItem('user') as string)
      .set('password', sessionStorage.getItem('password') as string);
    const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
    return this.httpClient.get<string>("http://localhost:8080/customer/report-favoritecategory?" + params, { responseType: 'text' as 'json' });
  }

  changePasswordCustomer(username: string, password: string, oldPassword: string) {
    const params = new HttpParams()
      .set('username', username)
      .set('password', password)
      .set('oldPassword', oldPassword);
    const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
    return this.httpClient.post<Boolean>("http://localhost:8080/customer/change-password?" + params, { headers: headers });
  }

  changePasswordEmployee(username: string, password: string, oldPassword: string) {
    const params = new HttpParams()
      .set('username', username)
      .set('password', password)
      .set('oldPassword', oldPassword);
    const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
    return this.httpClient.post<Boolean>("http://localhost:8080/employee/change-password?" + params, { headers: headers });
  }

  changeDataEmployee(username: string, name: string, surname: string, phoneNumber: string, iva: string) {
    const params = new HttpParams()
      .set('username', sessionStorage.getItem('user') as string)
      .set('password', sessionStorage.getItem('password') as string)
      .set('name', name)
      .set('surname', surname)
      .set('phoneNumber', phoneNumber)
      .set('iva', iva);
    const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
    return this.httpClient.post<Boolean>("http://localhost:8080/customer/update-data?" + params, { headers: headers });
  }

  getUsernames() {
    const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
    return this.httpClient.get("http://localhost:8080//customer/all-usernames?", { headers });
  }




}

