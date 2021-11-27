import { Component, OnInit } from '@angular/core';
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
  message: any;

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {
  }

  doLogin() {
    this.loginService.login(this.username, this.password).subscribe(
      response => {
        this.message = response;
        this.router.navigate(["/home"])
      }
    );
  }

}
