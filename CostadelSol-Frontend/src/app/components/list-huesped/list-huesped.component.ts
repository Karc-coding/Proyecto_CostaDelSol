import { Component, OnInit } from '@angular/core';
import { Huesped } from 'src/app/models/huesped.model';
import { HuespedService } from 'src/app/services/huesped.service';

@Component({
  selector: 'app-list-huesped',
  templateUrl: './list-huesped.component.html',
  styleUrls: ['./list-huesped.component.css']
})
export class ListHuespedComponent implements OnInit {

  nombre: string = "";
  dni: string = "";
  telefono: string = "";

  huespedes: Huesped[] = [];

  constructor(private huespedService: HuespedService) {
    huespedService.listAll().subscribe(
      response => {
        this.huespedes = response.list
      },
      error => {
        console.log(error);
      }
    );
  }

  ngOnInit(): void {
  }

  filtro() {
    this.huespedService.listForNameOrDniOrTelefono(this.nombre, this.dni, this.telefono).subscribe(
      response => {
        this.huespedes = response.list
        alert(response.message);
      },
      error => {
        console.log(error);
      }
    );
  }

}
