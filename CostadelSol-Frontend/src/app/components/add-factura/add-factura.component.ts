import { Component, OnInit } from '@angular/core';
import { Empleado } from 'src/app/models/empleado.model';
import { Factura } from 'src/app/models/factura.model';
import { Habitacion } from 'src/app/models/habitacion.model';
import { Huesped } from 'src/app/models/huesped.model';
import { EmpleadoService } from 'src/app/services/empleado.service';
import { FacturaService } from 'src/app/services/factura.service';
import { HabitacionService } from 'src/app/services/habitacion.service';
import { HuespedService } from 'src/app/services/huesped.service';

@Component({
  selector: 'app-add-factura',
  templateUrl: './add-factura.component.html',
  styleUrls: ['./add-factura.component.css']
})
export class AddFacturaComponent implements OnInit {

  factura: Factura = {
    numFactura: '',
    ruc: '',
    dni: {
      dni: '',
    },
    habitacionId:{
      id: '',
    },
    empleadoId:{
      id: '',
    },
    precioNoche: 0
  };

  huespedes: Huesped[] = [];
  habitaciones: Habitacion[] = [];
  empleados: Empleado[] = [];

  facturas: Factura[] = [];

  constructor(private facturaService: FacturaService, private habitacionService: HabitacionService, private empleadoService: EmpleadoService, huespedService: HuespedService) {
    facturaService.listaFactura().subscribe(
      response => {
        this.facturas = response
      },
      error => {
        console.log(error);
      }
    );
    
    habitacionService.listAll().subscribe(
      response => {
        this.habitaciones = response.list
      },
      error => {
        console.log(error);
      }
    );
    empleadoService.listAll().subscribe(
      response => {
        this.empleados = response.list
      },
      error => {
        console.log(error);
      }
    );
    huespedService.listAll().subscribe(
      response => {
        this.huespedes = response.list
      },
      error => {
        console.log(error);
      }
    );
  }

  registrar() {
    this.facturaService.registrarFactura(this.factura).subscribe(

      response => {
        alert(response.mensaje);

        this.facturaService.listaFactura().subscribe(
          response => {
            this.facturas = response
          },
          error => {
            console.log(error);
          }
        );

        this.factura = {
          numFactura: '',
          ruc: '',
          dni: {
            dni: '',
          },
          habitacionId:{
            id: '',
          },
          empleadoId:{
            id: '',
          },
          precioNoche: 0
        };

      },
      error => {
        console.log(error);
      }
    );

  }

  ngOnInit(): void {
  }

}
