import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = "";
  password: string = "";

  constructor(private loginService: LoginService) {
  }

  ngOnInit(): void {
  }

  login() {
    console.log(this.username);
    console.log(this.password);
    this.loginService.login(this.username, this.password);
  }

}