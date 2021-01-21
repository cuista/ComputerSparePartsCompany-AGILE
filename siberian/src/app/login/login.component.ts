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
    if(sessionStorage.getItem('user')!=null)
    {
      this.route.navigate(['/404']);
    }
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
          sessionStorage.setItem("password",password); 
          /*devo andare a controllarmi il tipo di login che viene fatto*/
          sessionStorage.setItem("type","customer"); /* per il momento lascio praticamente questo */
          if(sessionStorage.getItem('fromCart') != null)
          {
            this.route.navigate(['/cart']);
            sessionStorage.removeItem('fromCart');
          }
          else if(sessionStorage.getItem('fromAddReview') != null)
          {
            this.route.navigate(['/addReview']);
            sessionStorage.removeItem('fromAddReview');
          }
          else if(sessionStorage.getItem('job') != null)
          {
            this.route.navigate(['/workWithUs']);
            sessionStorage.removeItem('job');
          }
          else
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
