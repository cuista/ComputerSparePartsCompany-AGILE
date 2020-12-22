import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IProduct } from 'src/app/actors/product';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(
    private httpClient: HttpClient
  ) {}


/* Mi faccio la get dei miei prodotti*/
  getProducts(): Observable<IProduct[]>
  {
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.get<IProduct[]>("http://localhost:8080//products/all-products/distinct",{headers,responseType:'json'});
  }

  saveProduct(brand: string, model:string,image: string, category:string,warehouse:string,price: string,order: string, description: string)
  {
    
    const params = new HttpParams()
              .set('brand',brand)
              .set('model',model)
              .set('image',image)
              .set('category',category)
              .set('warehouse',warehouse)
              .set('price',price)
              .set('order',order)
              .set('description',description);
            

    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.post<Boolean>("http://localhost:8080/products/add-products?"+params,{headers:headers});
  }




}
