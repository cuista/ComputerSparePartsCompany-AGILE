import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ICustomer } from '../actors/customer';
import { IEmployee } from '../actors/employee';
import { UserService } from '../Services/data/user.service';

@Component({
  selector: 'app-customerPage',
  templateUrl: './customerPage.component.html',
  styleUrls: ['./customerPage.component.scss']
})
export class CustomerPageComponent implements OnInit {

    /* commonData */
    user = null as any;
    username = "";
    name = "";
    surname = "";
    phoneNumber = "";
    email = "";
    password = "";
    /* onlyCustomerData */
    vatidentificationNumber = 0 as number;
    totalAmount = 0 as number;
    totalPurchases = 0 as number;
    favoriteCategory = "None" as string;
    /* onlyEmployeeData */
    hiringDate = "";

  constructor(
    private route: Router,
    private userService: UserService
  ) { }

  ngOnInit() {
    if(sessionStorage.getItem('user') == null || sessionStorage.getItem('user') =="")
    {
      this.route.navigate(['/404']);
    }
    if(sessionStorage.getItem("type") == "customer")
    {
      this.username = sessionStorage.getItem("user") as string;
      (document.getElementById("employeeData") as HTMLDivElement).remove();
      this.setContentData();
      this.getTotalAmount();
      this.getTotalPurchases();
      this.getFavoriteCategory();
    }
    else if(sessionStorage.getItem("type") == "employee")
    {
      this.username = sessionStorage.getItem("user") as string;
      (document.getElementById("vatID") as HTMLDivElement).remove(); 
      (document.getElementById("customerData") as HTMLDivElement).remove();
      (document.getElementById("deleteAccount") as HTMLDivElement).remove();
      (document.getElementById("change") as HTMLDivElement).remove();
      this.setContentData();      
    }
  }

  openDeleteModal()
  {
    const overlay = document.getElementById('overlay') as HTMLElement;
    overlay.classList.toggle('hidden');
    overlay.classList.toggle('flex');
  }



  logout()
  {
    sessionStorage.removeItem("user");
    sessionStorage.removeItem("type");
    this.route.navigate(['/home']);
  }

  getTotalAmount()
  {
    this.userService.getUserAmount(this.username).subscribe(data => this.totalAmount = data);
  }

  getTotalPurchases()
  {
    this.userService.getTotalPurchase(this.username).subscribe(data => this.totalPurchases = data);
  }

  getFavoriteCategory()
  {
    this.userService.getFavoriteCategory(this.username).subscribe(data => this.favoriteCategory = data);
  }

  setContentData()
  {
    if(sessionStorage.getItem("type") == "employee")
    {
      this.userService.getEmployee(this.username).subscribe((returnObject: IEmployee) => {
        this.user = (returnObject);
        this.name = returnObject.firstName;
        this.surname = returnObject.lastName;
        this.phoneNumber = "" + returnObject.telephoneNumber;
        this.hiringDate = returnObject.hiringDate;
        this.email = returnObject.email;
      })
    }
    else if(sessionStorage.getItem("type") == "customer")
    {
        this.userService.getCustomer(this.username).subscribe((returnObject: ICustomer) => {
        this.user = (returnObject);
        this.name = returnObject.name;
        this.surname = returnObject.surname;
        this.phoneNumber = returnObject.numberPhone;
        this.vatidentificationNumber = returnObject.vatidentificationNumber;
        this.email = returnObject.email;
      })
    }
  }

  deleteAccount()
  {
    /* richiamo il service */
    this.userService.deleteCustomer(sessionStorage.getItem("user") as string).subscribe(
      response =>{
        if(response == true)
        {
          sessionStorage.removeItem("user");
          sessionStorage.removeItem("type");
          this.route.navigate(['']);
        }
        else
        {

        }
      }
    );
    /* svuoto la session da user e type */
  }

  changePassword()
  {
    this.route.navigate(['/changePassword']);
  }

  changeData()
  {
    this.route.navigate(['/changeDataUser']);
  }

}
