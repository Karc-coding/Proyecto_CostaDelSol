import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Empleado } from '../models/empleado.model';

const baseUrl = "http://localhost:8090/empleado"

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {

  constructor(private http: HttpClient) { }

  listAll(): Observable<any> {
    return this.http.get<Empleado[]>(baseUrl + "/listAll")
  }

}
