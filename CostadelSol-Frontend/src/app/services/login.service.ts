import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from '../models/usuario.model';

const baseUrl = "http://localhost:8090"

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  token: any;

  constructor(private http: HttpClient, private router: Router) { }

  public login(username: string, password: string) {
    return this.http.post<any>(baseUrl + "/login", { username, password })
  }

  public logout() {
    localStorage.removeItem('auth_token')
    this.router.navigateByUrl("/");
  }
}
