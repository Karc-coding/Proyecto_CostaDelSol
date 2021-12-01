import { Component, OnInit } from '@angular/core';
import { Habitacion } from 'src/app/models/habitacion.model';
import { HabitacionService } from 'src/app/services/habitacion.service';

@Component({
  selector: 'app-actualize-habitacion',
  templateUrl: './actualize-habitacion.component.html',
  styleUrls: ['./actualize-habitacion.component.css']
})
export class ActualizeHabitacionComponent implements OnInit {

  habitaciones: Habitacion[] = [];

  constructor(private habitacionService: HabitacionService) {
    habitacionService.listAll().subscribe(
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

}
