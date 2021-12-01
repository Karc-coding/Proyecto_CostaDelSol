import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Huesped } from '../models/huesped.model';

const baseUrl = "http://localhost:8090/registrarHuesped"

@Injectable({
  providedIn: 'root'
})
export class HuespedService {

  constructor(private http: HttpClient) { }

  register(data: Huesped): Observable<any> {
    return this.http.post(baseUrl + "/registrar", data)
  }

  listAll(): Observable<any> {
    return this.http.get<Huesped[]>(baseUrl + "/listAll")
  }

  listForNameOrDniOrTelefono(name: string, dni: string, telefono: string): Observable<any> {
    const params = new HttpParams()
      .set("name", name)
      .set("lastName", name)
      .set("dni", dni)
      .set("telefono", telefono);
    return this.http.get<Huesped[]>(baseUrl + "/listHuespedForNameOrDniOrTelefono", { params })
  }

}
