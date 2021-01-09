import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-topHeader',
  templateUrl: './topHeader.component.html',
  styleUrls: ['./topHeader.component.css']
})
export class TopHeaderComponent implements OnInit {

  username = "";
  type = "";
  
  constructor(
    private route: Router
  )
  {

  }

  ngOnInit(
    ) {
    this.getUser();
    if(this.type == "customer")
    {
      document.getElementById("sales")?.setAttribute("class","text-gray-800 rounded hover:bg-gray-900 hover:text-gray-100 hover:font-medium py-2 px-2 md:mx-2");
      document.getElementById("logName")?.setAttribute("class","text-gray-800 rounded hover:bg-gray-900 hover:text-gray-100 hover:font-medium py-2 px-2 md:mx-2");
      document.getElementById("login")?.setAttribute("class","text-gray-800 rounded hover:bg-gray-900 hover:text-gray-100 hover:font-medium py-2 px-2 md:mx-2 hidden");
      document.getElementById("logout")?.setAttribute("class","text-gray-800 rounded hover:bg-gray-900 hover:text-gray-100 hover:font-medium py-2 px-2 md:mx-2");
      document.getElementById("orders")?.setAttribute("class","text-gray-800 rounded hover:bg-gray-900 hover:text-gray-100 hover:font-medium py-2 px-2 md:mx-2");
      document.getElementById("cart")?.setAttribute("class","text-gray-800 rounded hover:bg-gray-900 hover:text-gray-100 hover:font-medium py-2 px-2 md:mx-2");

    }
    else if(this.type == "employee")
    {
      document.getElementById("orders")?.setAttribute("class","text-gray-800 rounded hover:bg-gray-900 hover:text-gray-100 hover:font-medium py-2 px-2 md:mx-2");
      document.getElementById("cart")?.setAttribute("class","text-gray-800 rounded hover:bg-gray-900 hover:text-gray-100 hover:font-medium py-2 px-2 md:mx-2 hidden");
      document.getElementById("logName")?.setAttribute("class","text-gray-800 rounded hover:bg-gray-900 hover:text-gray-100 hover:font-medium py-2 px-2 md:mx-2");
      document.getElementById("login")?.setAttribute("class","text-gray-800 rounded hover:bg-gray-900 hover:text-gray-100 hover:font-medium py-2 px-2 md:mx-2 hidden");
      document.getElementById("sales")?.setAttribute("class","text-gray-800 rounded hover:bg-gray-900 hover:text-gray-100 hover:font-medium py-2 px-2 md:mx-2");
      document.getElementById("insert")?.setAttribute("class","text-gray-800 rounded hover:bg-gray-900 hover:text-gray-100 hover:font-medium py-2 px-2 md:mx-2");
      document.getElementById("registerSale")?.setAttribute("class","text-gray-800 rounded hover:bg-gray-900 hover:text-gray-100 hover:font-medium py-2 px-2 md:mx-2");
      document.getElementById("logout")?.setAttribute("class","text-gray-800 rounded hover:bg-gray-900 hover:text-gray-100 hover:font-medium py-2 px-2 md:mx-2");
    }
    else if(this.type == "")
    {
      document.getElementById("logName")?.setAttribute("class","text-gray-800 rounded hover:bg-gray-900 hover:text-gray-100 hover:font-medium py-2 px-2 md:mx-2 hidden");
      document.getElementById("login")?.setAttribute("class","text-gray-800 rounded hover:bg-gray-900 hover:text-gray-100 hover:font-medium py-2 px-2 md:mx-2");
      document.getElementById("logout")?.setAttribute("class","text-gray-800 rounded hover:bg-gray-900 hover:text-gray-100 hover:font-medium py-2 px-2 md:mx-2 hidden");
      document.getElementById("orders")?.setAttribute("class","text-gray-800 rounded hover:bg-gray-900 hover:text-gray-100 hover:font-medium py-2 px-2 md:mx-2 hidden");
      document.getElementById("sales")?.setAttribute("class","text-gray-800 rounded hover:bg-gray-900 hover:text-gray-100 hover:font-medium py-2 px-2 md:mx-2 hidden");
      document.getElementById("insert")?.setAttribute("class","text-gray-800 rounded hover:bg-gray-900 hover:text-gray-100 hover:font-medium py-2 px-2 md:mx-2 hidden");
      document.getElementById("registerSale")?.setAttribute("class","text-gray-800 rounded hover:bg-gray-900 hover:text-gray-100 hover:font-medium py-2 px-2 md:mx-2 hidden ");
    }
  }


  getUser()
  {
    if(sessionStorage.getItem("user") != null)
    {
      this.username = sessionStorage.getItem("user") as string;
      /* non controllo se type è null perchè per la progettazione che ho dato sono sicuro non lo sia */
      if(sessionStorage.getItem("type") != null)
      {
         this.type = sessionStorage.getItem("type") as string;
      }
    }
  }

  logout()
  {
    sessionStorage.removeItem("user");
    sessionStorage.removeItem("type");
    this.route.navigate(['/home']);
  }



  

}
