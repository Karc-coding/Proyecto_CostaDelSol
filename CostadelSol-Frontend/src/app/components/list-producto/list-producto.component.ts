import { Component, OnInit } from '@angular/core';
import { Producto } from 'src/app/models/producto.model';
import { ProductoService } from 'src/app/services/producto.service';

@Component({
  selector: 'app-list-producto',
  templateUrl: './list-producto.component.html',
  styleUrls: ['./list-producto.component.css']
})
export class ListProductoComponent implements OnInit {

  description: string = "";
  idcat: string = "";
  
  productos: Producto[] = [];

  constructor(private productoService: ProductoService) {
    productoService.listAll().subscribe(
      response => {
        this.productos = response.list
      },
      error => {
        console.log(error);
      }
    );
  }

  getCategoria(categoria: string): string {
    var result = "";
    if (categoria == "H") {
      result = "Habitacion"
    } else if(categoria == "C") {
      result = "Cocina"
    } else {
      result = "NULL"
    }
    return result == null ? "" : result;
  }

  ngOnInit(): void {
  }

  filtro() {
    this.productoService.listForDescriptionOrCategoria(this.description, this.idcat).subscribe(
      response => {
        this.productos = response.list
        alert(response.message);
      },
      error => {
        console.log(error);
      }
    );
  }

}
