import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PurchaseService {

  constructor(
    private httpClient: HttpClient
  ) { }

  async getAll()
  {
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return await this.httpClient.get("http://localhost:8080//purchase/all",{headers,responseType:'json'}).toPromise();
  }

  async getAllByCustomer(username:string)
  {
    const params = new HttpParams()
                    .set('username',username);
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return await this.httpClient.get("http://localhost:8080//purchase/all-by-customer?"+params,{headers,responseType:'json'}).toPromise();
  }

  savePurchase(date:string,username:string,price:string,id:string)
  {
    const params = new HttpParams()
              .set('date',date)
              .set('username',username)
              .set('id',id)
              .set('price',price);
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.post<Boolean>("http://localhost:8080/purchase/add?"+params,{headers:headers});
  }

  async getFilteredPurchase(username:string,date:string)
  {
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    if(username == null && date == null)
    {
      return await this.httpClient.get("http://localhost:8080//purchase/all-by-filters",{headers,responseType:'json'}).toPromise(); 
    }
    else if(username != null && date == null)
    {
      var params = new HttpParams()
      .set('username',username)
      return await this.httpClient.get("http://localhost:8080//purchase/all-by-filters?"+params,{headers,responseType:'json'}).toPromise(); 
    }
    else if(username == null && date != null)
    {
      var params = new HttpParams()
      .set('date',date)
      return await this.httpClient.get("http://localhost:8080//purchase/all-by-filters?"+params,{headers,responseType:'json'}).toPromise(); 
    }
    var params = new HttpParams()
      .set('date',date)
      .set('username',username)
      return await this.httpClient.get("http://localhost:8080//purchase/all-by-filters?"+params,{headers,responseType:'json'}).toPromise(); 
  }

}
