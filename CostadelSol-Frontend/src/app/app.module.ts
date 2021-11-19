import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddHabitacionComponent } from './components/add-habitacion/add-habitacion.component';
import { AddReservaComponent } from './components/add-reserva/add-reserva.component';
import { AddHuespedComponent } from './components/add-huesped/add-huesped.component';
import { AddFacturaComponent } from './components/add-factura/add-factura.component';
import { AddProductoComponent } from './components/add-producto/add-producto.component';
import { ListHabitacionComponent } from './components/list-habitacion/list-habitacion.component';
import { ListReservaComponent } from './components/list-reserva/list-reserva.component';
import { ListHuespedComponent } from './components/list-huesped/list-huesped.component';
import { ListFacturaComponent } from './components/list-factura/list-factura.component';
import { ListProductoComponent } from './components/list-producto/list-producto.component';
import { FooterComponent } from './components/footer/footer.component';
import { NavbarComponent } from './components/navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    AddHabitacionComponent,
    AddReservaComponent,
    AddHuespedComponent,
    AddFacturaComponent,
    AddProductoComponent,
    ListHabitacionComponent,
    ListReservaComponent,
    ListHuespedComponent,
    ListFacturaComponent,
    ListProductoComponent,
    FooterComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
