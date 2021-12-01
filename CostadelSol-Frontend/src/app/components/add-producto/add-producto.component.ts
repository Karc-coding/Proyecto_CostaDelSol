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

  constructor() { }

  ngOnInit(): void {
  }

  register() {
    this.productoService.register(this.producto).subscribe(
      response => {
        alert(response.message);

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
