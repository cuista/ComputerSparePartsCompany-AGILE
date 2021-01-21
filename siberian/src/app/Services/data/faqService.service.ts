import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FaqServiceService {

  constructor(
    private httpClient: HttpClient
  ) { }

  getAll()
  {
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.get("http://localhost:8080//faq/get-all",{headers});
  }

  save(title: string, description:string)
  {
    const params = new HttpParams()
              .set('title',title)
              .set('text',description)
              .set('username',sessionStorage.getItem('user') as string)
              .set('password',sessionStorage.getItem('password') as string);
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.post<Boolean>("http://localhost:8080/faq/insert?"+params,{headers:headers});
  }

  delete(title: string)
  {
    const params = new HttpParams()
              .set('title',title)
              .set('username',sessionStorage.getItem('user') as string)
              .set('password',sessionStorage.getItem('password') as string);
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.delete<Boolean>("http://localhost:8080/faq/delete?"+params,{headers:headers});
  }

}
