import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class JobRequestService {

  constructor(
    private httpClient: HttpClient
  ) {}

  existsUsername(username:string)
  {
    const params = new HttpParams()
    .set('username',username);
    return this.httpClient.get("http://localhost:8080/job-request/exists-by-username",{params});
  }

  getByUsername(username:string)
  {
    const params = new HttpParams()
    .set('username',username);
    return this.httpClient.get("http://localhost:8080/job-request/get-by-username",{params});
  }

  async getAll()
  {
    const params = new HttpParams()
    .set('username',sessionStorage.getItem('user') as string)
    .set('password',sessionStorage.getItem('password') as string);
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return await this.httpClient.get("http://localhost:8080//job-request/get-all?"+params,{headers,responseType:'json'}).toPromise();
  }

  save(title:string,position:string,username:string,email:string,date:string,description:string)
  {
    const params = new HttpParams()
    .set('title',title)
    .set('position',position)
    .set('username',username)
    .set('email',email)
    .set('date',date)
    .set('description',description)
    .set('username',sessionStorage.getItem('user') as string)
    .set('password',sessionStorage.getItem('password') as string);
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.post<Boolean>("http://localhost:8080/job-request/insert?"+params,{headers:headers});
  }

  delete(username:string)
  {
    const params = new HttpParams()
    .set('username',username)
    .set('usernameE',sessionStorage.getItem('user') as string)
    .set('password',sessionStorage.getItem('password') as string);
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.delete<Boolean>("http://localhost:8080/job-request/delete?"+params,{headers:headers});
  }

}
