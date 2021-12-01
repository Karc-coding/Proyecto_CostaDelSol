import { Component, OnInit } from '@angular/core';
import { Factura } from 'src/app/models/factura.model';
import { FacturaService } from 'src/app/services/factura.service';

@Component({
  selector: 'app-list-factura',
  templateUrl: './list-factura.component.html',
  styleUrls: ['./list-factura.component.css']
})
export class ListFacturaComponent implements OnInit {

  ruc: string = "";
  dni: string = "";
  habitacion: string = "";

  facturas: Factura[] = [];

  constructor(private facturaService: FacturaService) {
    facturaService.listaFactura().subscribe(
      response => {
        this.facturas = response
      },
      error => {
        console.log(error);
      }
    );
  }

  ngOnInit(): void {
  }

  filtro() {
    this.facturaService.listForRucOrDniOrHabitacionId(this.ruc, this.dni, this.habitacion).subscribe(
      response => {
        this.facturas = response.list
        alert(response.message);
      },
      error => {
        console.log(error);
      }
    );
  }

}
