import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IProduct } from 'src/app/actors/product';
import { map } from 'rxjs/operators';
import { IBrand } from 'src/app/actors/brand';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(
    private httpClient: HttpClient
  ) {}


/* Mi faccio la get dei miei prodotti*/
  async getProducts()
  {
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return await this.httpClient.get("http://localhost:8080//products/all-products/distinct",{headers,responseType:'json'}).toPromise();
  }

  getProductsByBrandAndModel(brand:string,model:string): Observable<IProduct[]>
  {
    const params = new HttpParams()
              .set('brand',brand)
              .set('model',model);
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.get<IProduct[]>(`http://localhost:8080//products/all-products/brand=${brand}/model=${model}`);
  }

  saveProduct(brand: string, model:string,image: string, category:string,warehouse:string,price: string,order: string, description: string)
  {
    const params = new HttpParams()
              .set('brand',brand)
              .set('model',model)
              .set('url',image)
              .set('categoryName',category)
              .set('idWarehouse',warehouse)
              .set('price',price)
              .set('idOrder',order)
              .set('description',description)
              .set('username', sessionStorage.getItem('user') as string)
              .set('password', sessionStorage.getItem('password') as string);
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.post<Boolean>("http://localhost:8080/products/add-product?"+params,{headers:headers});
  }

  updateProduct(brand: string, model:string,image: string, category:string,price: string, description: string)
  {
    const params = new HttpParams()
              .set('brand',brand)
              .set('model',model)
              .set('url',image)
              .set('categoryName',category)
              .set('price',price)
              .set('description',description)
              .set('username', sessionStorage.getItem('user') as string)
              .set('password', sessionStorage.getItem('password') as string);
            
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.post<Boolean>("http://localhost:8080/products/update-product-by-all?"+params,{headers:headers});
  }
  
  deleteProduct(brand: string, model:string)
  {
    const params = new HttpParams()
              .set('brand',brand)
              .set('model',model)
              .set('username', sessionStorage.getItem('user') as string)
              .set('password', sessionStorage.getItem('password') as string);

    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.post<Boolean>("http://localhost:8080/products/del-product?"+params,{headers:headers});
  }

  getBrands(): Observable<IBrand[]>
  {
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.get<IBrand[]>("http://localhost:8080//products/get-brands",{headers});

  }

  getBrandsByCategory(category:string): Observable<IBrand[]>
  {
    const params = new HttpParams()
    .set('category',category)
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.get<IBrand[]>("http://localhost:8080//products/get-brands-by-category",{headers,params});

  }

  async getProductByFilters(category:string,brand:string,min:string, max:string)
  {
    // alert(category);
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    if(category == null && brand != null)
    {
      var params = new HttpParams()
          .set('brand',brand)
          .set('min',min)
          .set('max',max);
      return await this.httpClient.get("http://localhost:8080//products/get-products-by-filters?"+params,{headers,responseType:'json'}).toPromise(); 
    }
    else if(category != null && brand == null)
    {
      var params = new HttpParams()
          .set('category',category)
          .set('min',min)
          .set('max',max);
      return await this.httpClient.get("http://localhost:8080//products/get-products-by-filters?"+params,{headers,responseType:'json'}).toPromise(); 
    }
    else if(category != null && brand != null)
    {
      var params = new HttpParams()
          .set('category',category)
          .set('brand',brand)
          .set('min',min)
          .set('max',max);
      return await this.httpClient.get("http://localhost:8080//products/get-products-by-filters?"+params,{headers,responseType:'json'}).toPromise(); 
    }
    var params = new HttpParams()
    .set('min',min)
    .set('max',max);
    return await this.httpClient.get("http://localhost:8080//products/get-products-by-filters?"+params,{headers,responseType:'json'}).toPromise(); 
  }

  async getSearchProducts(parameter:string)
  {
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return await this.httpClient.get(`http://localhost:8080//products/get-product-by-regex?s=${parameter}`,{headers,responseType:'json'}).toPromise();
  }





}
