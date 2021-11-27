import { Component, OnInit } from '@angular/core';
import { Factura } from 'src/app/models/factura.model';
import { Habitacion } from 'src/app/models/habitacion.model';
import { FacturaService } from 'src/app/services/factura.service';
import { HabitacionService } from 'src/app/services/habitacion.service';

@Component({
  selector: 'app-add-factura',
  templateUrl: './add-factura.component.html',
  styleUrls: ['./add-factura.component.css']
})
export class AddFacturaComponent implements OnInit {

  habitaciones:string[] = [];

 factura:Factura = {
    numFactura:"",
    ruc:"",		
    dni:"",
    habitacion:"",
    empleadoId:"",
    precioNoche:0
	
  };

  constructor(private facturaService:FacturaService, private habitacionService:HabitacionService) { 

    this.habitacionService.listDescripHabitacion().subscribe(
      (response) => this.habitaciones = response
    );

  }

  registrar(){
    console.log("-------fact"+this.factura.numFactura);
    console.log("-------factdni"+this.factura.dni);
    console.log("-------factEmpleado"+this.factura.empleadoId);
    
    console.log("-------facthabitacion"+this.factura.habitacion);
    console.log("-------factPrecio"+this.factura.precioNoche);
    console.log("-------factRuc"+this.factura.ruc);
    this.facturaService.registrarFactura(this.factura).subscribe(
      
      response => {
        console.log(response.mensaje);
        alert(response.mensaje);

        this.factura = {
          
        }

      },
      error => {
        console.log(error);
      },

      /*response => {alert(response.mensaje);},
      error => {console.log(error);}*/

    );

  }

  ngOnInit(): void {
  }

}
