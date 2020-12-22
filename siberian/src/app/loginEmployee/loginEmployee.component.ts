import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../Services/data/login.service';
import { LoginEmployeeService } from '../Services/data/loginEmployee.service';

@Component({
  selector: 'app-loginEmployee',
  templateUrl: './loginEmployee.component.html',
  styleUrls: ['./loginEmployee.component.scss']
})
export class LoginEmployeeComponent implements OnInit {

  wrongData = false;
  errorLoginMessage = "Dati inseriti non corretti";
  constructor(
    private loginEmployeeService: LoginEmployeeService,
    private route: Router
  ) { }

  ngOnInit() {
  }

  hideMessage()
  {
    this.wrongData = false;
  }

  getLogin()
  {
    let username = (document.getElementById("username") as HTMLInputElement).value;
    let password = (document.getElementById("password") as HTMLInputElement).value;
    /*qua dentro devo andare a prendermi i parametri ottenuti dalla due input */
    this.loginEmployeeService.getLogin(username,password).subscribe(
      response => {
        if(response == true)
        {
          sessionStorage.setItem("user",username);
          /*devo andare a controllarmi il tipo di login che viene fatto*/
          sessionStorage.setItem("type","employee"); /* per il momento lascio praticamente questo */
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
