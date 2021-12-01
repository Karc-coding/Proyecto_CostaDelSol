import { Component, OnInit } from '@angular/core';
import { Huesped } from 'src/app/models/huesped.model';
import { HuespedService } from 'src/app/services/huesped.service';

@Component({
  selector: 'app-actualize-huesped',
  templateUrl: './actualize-huesped.component.html',
  styleUrls: ['./actualize-huesped.component.css']
})
export class ActualizeHuespedComponent implements OnInit {
  
  huespedes: Huesped[] = [];

  constructor(private huespedService: HuespedService) {
    huespedService.listAll().subscribe(
      response => {
        this.huespedes = response.list
      },
      error => {
        console.log(error);
      }
    );
  }

  ngOnInit(): void {
  }

}
