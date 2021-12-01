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

  messageError?: string;

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {
  }

  login() {
    this.loginService.login(this.username, this.password).subscribe(
      (resp: any) => {
        this.router.navigateByUrl("/home");
        localStorage.setItem('auth_token', resp.token);
        console.log(resp);
      },
      error => {
        console.log(error);
        this.messageError = "Invalid username or password";
      }
    );
  }

}