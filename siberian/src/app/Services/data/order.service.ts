import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(
    private httpClient:HttpClient
  ) { }

  insert(quantity:string,brand:string,model:string,warehouse:string)
  {
    const params = new HttpParams()
    .set('quantity',quantity)
    .set('brand',brand)
    .set('model',model)
    .set('warehouse',warehouse)
    .set('prodHouse',"Main");
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.post<Boolean>("http://localhost:8080/job-request/insert?"+params,{headers:headers});
  
  }
}
