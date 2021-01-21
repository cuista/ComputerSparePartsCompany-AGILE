import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IPurchaseNotice } from 'src/app/actors/purchaseNotice';

@Injectable({
  providedIn: 'root'
})
export class PurchaseNoticeService {

  constructor(
    private httpClient: HttpClient
  ) { }


  saveNotice(date: string, username: string, warehouse: string, brand: string, model: string, quantity: string) {
    const params = new HttpParams()
      .set('date', date)
      .set('username', sessionStorage.getItem('user') as string)
      .set('password', sessionStorage.getItem('password') as string)
      .set('idWarehouse', warehouse)
      .set('brand', brand)
      .set('model', model)
      .set('quantity', quantity);
    const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
    return this.httpClient.post<Boolean>("http://localhost:8080/purchaseNotice/add-notice?" + params, { headers: headers });
  }

  async getAll() {
    const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
    return await this.httpClient.get("http://localhost:8080//purchaseNotice/all", { headers, responseType: 'json' }).toPromise();
  }

  async getAllByCustomer(username: string) {
    const params = new HttpParams()
      .set('username', sessionStorage.getItem('user') as string)
      .set('password', sessionStorage.getItem('password') as string);
    const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
    return await this.httpClient.get("http://localhost:8080//purchaseNotice/all-by-customer?" + params, { headers, responseType: 'json' }).toPromise();
  }

  async getFilteredNotice(username: string, date: string) {
    const headers = new HttpHeaders().set('Content-Type', 'text/plain; charset=utf-8');
    if (username == null && date == null) {
      return await this.httpClient.get("http://localhost:8080//purchaseNotice/all-by-filters", { headers, responseType: 'json' }).toPromise();
    }
    else if (username != null && date == null) {
      var params = new HttpParams()
        .set('username', username)
      return await this.httpClient.get("http://localhost:8080//purchaseNotice/all-by-filters?" + params, { headers, responseType: 'json' }).toPromise();
    }
    else if (username == null && date != null) {
      var params = new HttpParams()
        .set('date', date)
      return await this.httpClient.get("http://localhost:8080//purchaseNotice/all-by-filters?" + params, { headers, responseType: 'json' }).toPromise();
    }
    var params = new HttpParams()
      .set('date', date)
      .set('username', username)
    return await this.httpClient.get("http://localhost:8080//purchaseNotice/all-by-filters?" + params, { headers, responseType: 'json' }).toPromise();
  }

}
