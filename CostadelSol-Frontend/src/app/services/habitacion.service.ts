import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Habitacion } from '../models/habitacion.model';

const baseUrl = "http://localhost:8090/habitacion"

@Injectable({
  providedIn: 'root'
})
export class HabitacionService {

  constructor(private http: HttpClient) { }

  register(data: Habitacion): Observable<any> {
    let username = "karc";
    let password = "admin123";
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ":" + password) })
    return this.http.post(baseUrl + "/create", data, { headers })
  }

  listAll(): Observable<any> {
    let username = "karc";
    let password = "admin123";
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ":" + password) })
    return this.http.get<Habitacion[]>(baseUrl + "/listAll", { headers })
  }
}
