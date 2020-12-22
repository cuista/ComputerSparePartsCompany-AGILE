import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../Services/data/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  wrongData = false;
  errorLoginMessage = "No correct data";

  constructor(
    private loginService: LoginService,
    private route: Router
  ) { }

  ngOnInit() {

  }

  hideMessage()
  {
    this.wrongData = false;
  }

  getLogin(/*qua devo andare a passargli come parametri username e password */)
  {
    let username = (document.getElementById("username") as HTMLInputElement).value;
    let password = (document.getElementById("password") as HTMLInputElement).value;
    /*qua dentro devo andare a prendermi i parametri ottenuti dalla due input */
    this.loginService.getLogin(username,password).subscribe(
      response => {
        if(response == true)
        {
          sessionStorage.setItem("user",username);
          /*devo andare a controllarmi il tipo di login che viene fatto*/
          sessionStorage.setItem("type","customer"); /* per il momento lascio praticamente questo */
          this.route.navigate(['']);
        }
        else 
        {
          this.wrongData = true;
        }
      }
    );
  }

}
