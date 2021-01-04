import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IReview } from 'src/app/actors/review';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  constructor(
    private httpClient: HttpClient
  ) { }

  addReview(username:string,rate:string,model:string,brand:string,title:string,text:string)
  {
    const params = new HttpParams()
              .set('username',username)
              .set('rate',rate)
              .set('model',model)
              .set('brand',brand)
              .set('text',text)
              .set('title',title);
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.post<Boolean>("http://localhost:8080/review/add?"+params,{headers:headers});
  }

  async getReviewByBrandAndModel(brand:string,model:string)
  {
    const params = new HttpParams()
                  .set('brand',brand)
                  .set('model',model);
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return await this.httpClient.get("http://localhost:8080//review/by-brand-and-model?"+params,{headers,responseType:'json'}).toPromise();
  }

  delete(username:string,rate:string,model:string,brand:string,title:string,text:string)
  {
    const params = new HttpParams()
              .set('username',username)
              .set('rate',rate)
              .set('model',model)
              .set('brand',brand)
              .set('text',text)
              .set('title',title);
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.delete<Boolean>("http://localhost:8080//review/delete",{headers,params})
    
  }

  async getFilteredReviews(username:string,rate:string,brand:string,model:string)
  {
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    if(username == null && rate == null)
    {
      var params = new HttpParams()
      .set('brand',brand)
      .set('model',model);
      return await this.httpClient.get("http://localhost:8080//review/all-by-filters?"+params,{headers,responseType:'json'}).toPromise(); 
    }
    else if(username != null && rate == null)
    {
      var params = new HttpParams()
      .set('brand',brand)
      .set('username',username)
      .set('model',model);
      return await this.httpClient.get("http://localhost:8080//review/all-by-filters?"+params,{headers,responseType:'json'}).toPromise(); 
    }
    else if(username == null && rate != null)
    {
      var params = new HttpParams()
      .set('brand',brand)
      .set('rate',rate)
      .set('model',model);
      return await this.httpClient.get("http://localhost:8080//review/all-by-filters?"+params,{headers,responseType:'json'}).toPromise(); 
    }
    var params = new HttpParams()
      .set('brand',brand)
      .set('rate',rate)
      .set('username',username)
      .set('model',model);
      return await this.httpClient.get("http://localhost:8080//review/all-by-filters?"+params,{headers,responseType:'json'}).toPromise(); 
  }

}
