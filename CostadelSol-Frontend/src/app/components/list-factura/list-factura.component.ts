import { Component, OnInit } from '@angular/core';
import { Factura } from 'src/app/models/factura.model';
import { FacturaService } from 'src/app/services/factura.service';

@Component({
  selector: 'app-list-factura',
  templateUrl: './list-factura.component.html',
  styleUrls: ['./list-factura.component.css']
})
export class ListFacturaComponent implements OnInit {

  facturas:Factura[] = [];
  arrayFactura:Factura[] = [];

  constructor(private facturaService:FacturaService) {
    this.facturaService.listaFactura().subscribe(
      response =>  this.arrayFactura = response
    );
   }

   lista(){
    this.facturaService.listaFactura().subscribe(
      response =>  this.facturas = response
    );
  }

  ngOnInit(): void {
  }

}
