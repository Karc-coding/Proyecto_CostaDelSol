import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Factura } from '../models/factura.model';

const baseUrl = 'http://localhost:8090/rest/factura';

@Injectable({
  providedIn: 'root'
})
export class FacturaService {

  constructor(private http:HttpClient) { }

  registrarFactura(data:Factura): Observable<any>{
    return this.http.post(baseUrl, data);
  }

}
