import { Component, OnInit } from '@angular/core';
import { Producto } from 'src/app/models/producto.model';
import { ProductoService } from 'src/app/services/producto.service';

@Component({
  selector: 'app-add-producto',
  templateUrl: './add-producto.component.html',
  styleUrls: ['./add-producto.component.css']
})
export class AddProductoComponent implements OnInit {

  producto: Producto = {
    id: '',
    description: '',
    stock: 0,
    price: 0,
    idcat: ''
  }

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

  register() {
    this.productoService.register(this.producto).subscribe(
      response => {
        alert(response.message);

        this.productoService.listAll().subscribe(
          response => {
            this.productos = response.list
          },
          error => {
            console.log(error);
          }
        );

        this.producto = {
          id: '',
          description: '',
          stock: 0,
          price: 0,
          idcat: ''
        }

      },
      error => {
        console.log(error);
      }
    );
  }

}
