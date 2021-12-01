import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Factura } from '../models/factura.model';

const baseUrl = "http://localhost:8090/rest/factura";

@Injectable({
  providedIn: 'root'
})
export class FacturaService {

  constructor(private http: HttpClient) { }

  registrarFactura(data: Factura): Observable<any> {
    return this.http.post(baseUrl + "/agregarFactura", data);
  }

  listaFactura(): Observable<Factura[]> {
    return this.http.get<Factura[]>(baseUrl + "/listaFactura");
  }

  listForRucOrDniOrHabitacionId(ruc: string, dni: string, habitacion: string): Observable<any> {
    const params = new HttpParams()
      .set("ruc", ruc)
      .set("dni", dni)
      .set("habitacion", habitacion);
    return this.http.get<Factura[]>(baseUrl + "/listFacturaForRucOrDniOrHabitacion", { params })
  }

}
