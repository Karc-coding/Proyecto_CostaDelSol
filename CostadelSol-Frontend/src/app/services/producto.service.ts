import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
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

  listAll(): Observable<any> {
    return this.http.get<Producto[]>(baseUrl + "/listAll")
  }

  listForDescriptionOrCategoria(description: string, categoria: string): Observable<any> {
    const params = new HttpParams()
      .set("description", description)
      .set("categoria", categoria);
    return this.http.get<Producto[]>(baseUrl + "/listProductoForDescriptionOrCategoria", { params })
  }

}
