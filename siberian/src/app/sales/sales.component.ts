import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PurchaseService } from '../Services/data/purchase.service';
import { UserService } from '../Services/data/user.service';

@Component({
  selector: 'app-sales',
  templateUrl: './sales.component.html',
  styleUrls: ['./sales.component.css']
})
export class SalesComponent implements OnInit {

  purchase = [] as any;

  constructor(
    private route: Router,
    private purchaseService: PurchaseService,
    private userService: UserService
  ) { }

  pager = {
    totalItems: 0, 
    currentPage: 1,
    pageSize: 9, 
    totalPages: 1, 
    startPage: 1,
    endPage: 5,
    startIndex:0,
    endIndex:4,
    pages: []
  } as any;

  // paged items
  pagedItems = [] as any;
  usernames = [] as any;
  type = "" as any;

  ngOnInit() {
    this.userService.getUsernames().subscribe((data) =>this.usernames = data);
    if(sessionStorage.getItem("type") == null)
    {
      this.route.navigate(["/404"]);
    }
    else
    {
      this.type = sessionStorage.getItem('type') as string;
      this.getProducts(1);
    }
  }

  async getProducts(index:number)
  {
    if(sessionStorage.getItem('user') != null)
    {
      if(sessionStorage.getItem('type') == "customer")
      {
        var dateCustomer =""as any;
        if((document.getElementById("dateCustomer") as HTMLInputElement) != null)
          dateCustomer = (document.getElementById("dateCustomer") as HTMLInputElement).value as any;
        if(dateCustomer == "" || dateCustomer == null) {dateCustomer = null;}
        this.purchase = await this.purchaseService.getFilteredPurchase(sessionStorage.getItem('user')as string,dateCustomer);
        this.calcolatePagerFinals(this.purchase);
        this.setPage(index);
      }
      else if(sessionStorage.getItem('type') == "employee")
      {
        var date = "" as any;
        var username = "" as any;
        if((document.getElementById("date") as HTMLInputElement) != null)
          date = (document.getElementById("date") as HTMLInputElement).value as any;
        if((document.getElementById("users") as HTMLSelectElement) != null)
          username = (document.getElementById("users") as HTMLSelectElement).value as string;
        if(username == "All users" || username == "") {username = null;}
        if(date == "" || date == null) {date = null;}
        this.purchase = await this.purchaseService.getFilteredPurchase(username,date);
        this.calcolatePagerFinals(this.purchase);
        this.setPage(index);
      }
    }
      
  }

  
  async setPage(indexPage: number) {
    if (indexPage < 1 || indexPage > this.pager.totalPages) {
        return;
    }

      this.pager.currentPage = indexPage;
      this.calcolatePagerIndexes(indexPage);
    
      this.pagedItems = this.purchase.slice((indexPage-1)*(this.pager.pageSize),(indexPage*this.pager.pageSize));
  }

  /* questa va richiamata all'inizio quando carico l'array */
  async calcolatePagerFinals(array: any[])
  { 
    this.pager.totalItems = array.length;
    this.pager.totalPages = Math.ceil(this.pager.totalItems/(this.pager.pageSize));
    this.pager.endPage = this.pager.totalPages;
  }
  
  async calcolatePagerIndexes(current: number)
  {
    if(this.pager.totalPages<=5) /* caso in cui ho poche pagine */
    {
      this.pager.startIndex = 1;
      this.pager.endIndex = this.pager.endPage;
    }
    else /* caso in cui ne ho abbastanza */
    {
      if(current <= 3)/* caso in cui sono dietro */
      {
        this.pager.startIndex = 1;
        this.pager.endIndex = 5;
      }
      else if(current + 1 >= this.pager.totalPages) /* caso in cui sono avanti */
      {
        this.pager.startIndex = this.pager.totalPages - 4;
        this.pager.endIndex = this.pager.endPage;
      }
      else /* caso normale */
      {
        this.pager.startIndex = current-2;
        this.pager.endIndex = current+2; 
      }
    }

    this.pager.pages = [];
    for(var i = this.pager.startIndex; i<=this.pager.endIndex; i++)
    {
      this.pager.pages.push(i);
    }  
  }


}
