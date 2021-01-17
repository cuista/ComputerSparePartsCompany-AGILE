import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HomeServiceService {

constructor(
  private httpClient: HttpClient
) {}

  getGreeting()
  {
    const headers = new HttpHeaders().set('Content-Type','text/plain; charset=utf-8');
    return this.httpClient.get("http://localhost:8080//employee//stampa",{headers,responseType:'text'});
  }

}
