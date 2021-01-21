import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(
    private httpClient:HttpClient
  ) { }

  insert(quantity:string,brand:string,model:string,warehouse:string,house:string)
  {
    const params = new HttpParams()
    .set('productQuantity',quantity)
    .set('productBrand',brand)
    .set('productModel',model)
    .set('warehouse',warehouse)
    .set('prodHouse',house)
    .set('username',sessionStorage.getItem('user') as string)
    .set('password',sessionStorage.getItem('password') as string);
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.post("http://localhost:8080/order-requests/save-orderRequest?"+params,{headers:headers});
  }

  async getAll()
  {
    const params = new HttpParams()
    .set('username',sessionStorage.getItem('user') as string)
    .set('password',sessionStorage.getItem('password') as string);
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return await this.httpClient.get("http://localhost:8080/order-requests/get-all?"+params,{headers,responseType:'json'}).toPromise();
  }

}
