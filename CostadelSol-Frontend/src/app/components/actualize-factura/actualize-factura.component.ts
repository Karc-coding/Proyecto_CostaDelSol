import { Component, OnInit } from '@angular/core';
import { Factura } from 'src/app/models/factura.model';
import { FacturaService } from 'src/app/services/factura.service';

@Component({
  selector: 'app-actualize-factura',
  templateUrl: './actualize-factura.component.html',
  styleUrls: ['./actualize-factura.component.css']
})
export class ActualizeFacturaComponent implements OnInit {

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

}
