import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customerPage',
  templateUrl: './customerPage.component.html',
  styleUrls: ['./customerPage.component.scss']
})
export class CustomerPageComponent implements OnInit {

  constructor(
    private route: Router
  ) { }

  ngOnInit() {
    if(sessionStorage.getItem("type") == "customer")
    {
      (document.getElementById("employeeData") as HTMLDivElement).remove();
    }
    else if(sessionStorage.getItem("type") == "employee")
    {
      (document.getElementById("vatID") as HTMLDivElement).remove(); 
      (document.getElementById("customerData") as HTMLDivElement).remove();
    }
  }

  logout()
  {
    sessionStorage.removeItem("user");
    sessionStorage.removeItem("type");
    this.route.navigate(['/home']);
  }

  setContentData()
  {

  }

  deleteAccount()
  {
    
  }

  changePassword()
  {
    this.route.navigate(['/changePassword']);
  }

}
