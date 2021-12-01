import { Component, OnInit } from '@angular/core';
import { Huesped } from 'src/app/models/huesped.model';
import { HuespedService } from 'src/app/services/huesped.service';

@Component({
  selector: 'app-add-huesped',
  templateUrl: './add-huesped.component.html',
  styleUrls: ['./add-huesped.component.css']
})
export class AddHuespedComponent implements OnInit {

  huesped: Huesped = {
    dni: '',
    nombre: '',
    apellido: '',
    telefono: '',
    correo: ''
  }
  
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

  register() {
    this.huespedService.register(this.huesped).subscribe(
      response => {
        alert(response.mensaje);

        this.huespedService.listAll().subscribe(
          response => {
            this.huespedes = response.list
          },
          error => {
            console.log(error);
          }
        );
        
        this.huesped = {
          dni: '',
          nombre: '',
          apellido: '',
          telefono: '',
          correo: ''
        }

      },
      error => {
        console.log(error);
      }
    );
  }

}
