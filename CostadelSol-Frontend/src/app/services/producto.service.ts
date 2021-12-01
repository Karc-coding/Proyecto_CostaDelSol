import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Producto } from '../models/producto.model';

const baseUrl = "http://localhost:8090/producto"

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  constructor(private http: HttpClient) { }

  register(data: Producto): Observable<any> {
    return this.http.post(baseUrl + "/create", data)
  }
}
