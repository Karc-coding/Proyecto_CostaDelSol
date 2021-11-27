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
    return this.http.post(baseUrl + "/create", data)
  }

  listAll(): Observable<any> {
    return this.http.get<Habitacion[]>(baseUrl + "/listAll")
  }
  listDescripHabitacion(): Observable<string[]>{
    return this.http.get<string[]>(baseUrl+ "/listaDescripcionHabitacion");
  }
}
