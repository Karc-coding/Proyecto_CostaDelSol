import { Component, OnInit } from '@angular/core';
import { Habitacion } from 'src/app/models/habitacion.model';
import { HabitacionService } from 'src/app/services/habitacion.service';

@Component({
  selector: 'app-add-habitacion',
  templateUrl: './add-habitacion.component.html',
  styleUrls: ['./add-habitacion.component.css']
})
export class AddHabitacionComponent implements OnInit {

  habitacion: Habitacion = {
    id: '',
    description: '',
    state: '',
    price: 0
  }

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


  register() {
    this.habitacionService.register(this.habitacion).subscribe(
      response => {
        alert(response.message);

        this.habitacionService.listAll().subscribe(
          response => {
            this.habitaciones = response.list
          },
          error => {
            console.log(error);
          }
        );

        this.habitacion = {
          id: '',
          description: '',
          state: '',
          price: 0
        }

      },
      error => {
        console.log(error);
      }
    );
  }

}
