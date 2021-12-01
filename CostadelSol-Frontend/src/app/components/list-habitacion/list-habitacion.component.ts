import { Component, OnInit } from '@angular/core';
import { Habitacion } from 'src/app/models/habitacion.model';
import { HabitacionService } from 'src/app/services/habitacion.service';

@Component({
  selector: 'app-list-habitacion',
  templateUrl: './list-habitacion.component.html',
  styleUrls: ['./list-habitacion.component.css']
})
export class ListHabitacionComponent implements OnInit {

  description: string = "";
  state: string = "";

  habitaciones: Habitacion[] = [];

  constructor(private habitacionService: HabitacionService) {
    habitacionService.listForDescriptionOrState(this.description, this.state).subscribe(
      response => {
        this.habitaciones = response.list
      },
      error => {
        console.log(error);
      }
    );
  }

  ngOnInit(): void {
  }

  filtro() {
    this.habitacionService.listForDescriptionOrState(this.description, this.state).subscribe(
      response => {
        this.habitaciones = response.list
        alert(response.message);
      },
      error => {
        console.log(error);
      }
    );
  }

}
