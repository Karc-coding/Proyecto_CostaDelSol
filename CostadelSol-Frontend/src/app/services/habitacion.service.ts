import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
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

  listForDescriptionOrState(description: string, state: string): Observable<any> {
    const params = new HttpParams()
      .set("description", description)
      .set("state", state);
    return this.http.get<Habitacion[]>(baseUrl + "/listHabitacionForDescriptionOrState", { params })
  }

  listDescripHabitacion(): Observable<string[]> {
    return this.http.get<string[]>(baseUrl + "/listaDescripcionHabitacion");
  }
}
