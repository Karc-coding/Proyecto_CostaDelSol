import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { AddHabitacionComponent } from './components/add-habitacion/add-habitacion.component';
import { ListHabitacionComponent } from './components/list-habitacion/list-habitacion.component';
import { ActualizeHabitacionComponent } from './components/actualize-habitacion/actualize-habitacion.component';
import { AddProductoComponent } from './components/add-producto/add-producto.component';
import { ListProductoComponent } from './components/list-producto/list-producto.component';
import { AddReservaComponent } from './components/add-reserva/add-reserva.component';
import { ListReservaComponent } from './components/list-reserva/list-reserva.component';
import { AddHuespedComponent } from './components/add-huesped/add-huesped.component';
import { ListHuespedComponent } from './components/list-huesped/list-huesped.component';
import { ActualizeHuespedComponent } from './components/actualize-huesped/actualize-huesped.component';
import { AddFacturaComponent } from './components/add-factura/add-factura.component';
import { ListFacturaComponent } from './components/list-factura/list-factura.component';
import { ActualizeFacturaComponent } from './components/actualize-factura/actualize-factura.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "", redirectTo: "login", pathMatch: "full" },
  {
    path: "home", component: HomeComponent,
    children: [
      { path: "addHabitacion", component: AddHabitacionComponent },
      { path: "listHabitacion", component: ListHabitacionComponent },
      { path: "actualizeHabitacion", component: ActualizeHabitacionComponent },
      { path: "addProducto", component: AddProductoComponent },
      { path: "listProducto", component: ListProductoComponent },
      { path: "addReserva", component: AddReservaComponent },
      { path: "listReserva", component: ListReservaComponent },
      { path: "addHuesped", component: AddHuespedComponent },
      { path: "listHuesped", component: ListHuespedComponent },
      { path: "actualizeHuesped", component: ActualizeHuespedComponent },
      { path: "addFactura", component: AddFacturaComponent },
      { path: "listFactura", component: ListFacturaComponent },
      { path: "actualizeFactura", component: ActualizeFacturaComponent }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
