import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

const baseUrl = "http://localhost:8090/"

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }


  public login(username: string, password: string) {
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ":" + password) })
    return this.http.get(baseUrl, { headers, responseType: 'text' as 'json' })
  }

  public getUsers() {
    let username = "karc";
    let password = "admin123";
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ":" + password) })
    return this.http.get(baseUrl + "getUsers", { headers })
  }

}
