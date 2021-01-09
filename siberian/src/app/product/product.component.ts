import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IProduct } from '../actors/product';
import { ProductsService } from '../Services/data/products.service';
import { ReviewService } from '../Services/data/review.service';
import { UserService } from '../Services/data/user.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {

  constructor(
    private route: Router,
    private productService: ProductsService,
    private reviewService: ReviewService,
    private userService: UserService
  ) { }

  id : string = "";
  url: string = "";
  name: string = "";
  description: string = "";
  price: string = "";
  availability: string = "Available"; /* devo fare una distinzione lato customer e una lato employee */
  number: string = "";

  /* dati importanti per la gestione dei bottoni */
  userType = "";
  
  /* data */
  brand = "";
  model = "";
  averageRate = 1 as number; /* in caso non ci sia non viene visualizzato */
  product = null as any;
  username = "";
  usernames = [] as any;
  /*------------------------------------------------------------------------- */
  reviews = [] as any;
  pager = {
    totalItems: 0, 
    currentPage: 1,
    pageSize: 10, 
    totalPages: 1, 
    startPage: 1,
    endPage: 5,
    startIndex:0,
    endIndex:4,
    pages: []
  } as any;
  pagedItems = [] as any;
  
  ngOnInit() {
    
    this.userService.getUsernames().subscribe((data) =>this.usernames = data);
    
    if(sessionStorage.getItem('brand') == null || sessionStorage.getItem('model') == null)
    {
      this.route.navigate(['/404']);
    }
    if(sessionStorage.getItem('user') != null)
    {
      this.username = sessionStorage.getItem('user') as string;
    }
    /* set information product */
    this.brand = sessionStorage.getItem('brand') as string;
    this.model = sessionStorage.getItem('model') as string;
    this.productService.getProductsByBrandAndModel(this.brand,this.model).subscribe((returnObject: IProduct[]) => {
      this.product = (returnObject[0]);
      this.number = returnObject.length.toString(); /* ottengo il numero di quei prodotti */
      this.name = this.product['brand'] + " " + this.product['model'];
      this.price = this.product['price'];
      this.description = this.product['description'];
      this.url = this.product['imageUrl']

        }, (error: HttpErrorResponse) => {})
        


    this.userType = sessionStorage.getItem("type") as string;
    if(this.userType == "customer" || this.userType == null)
    {  
      (document.getElementById("addToCart") as HTMLButtonElement).setAttribute("class","h-12 bg-blue-600 w-full");
      (document.getElementById("addReview") as HTMLButtonElement).setAttribute("class","h-12 bg-blue-600 w-full");
      (document.getElementById("quantity") as HTMLDivElement).remove();
    }
    else if(this.userType == "employee")
    {
      (document.getElementById("modify") as HTMLButtonElement).setAttribute("class","h-12 bg-blue-600 w-full");
      (document.getElementById("delete") as HTMLButtonElement).setAttribute("class","h-12 bg-blue-600 w-full");
      (document.getElementById("availability") as HTMLDivElement).remove();
     
    }  
    /*review part */
    this.getReviews(1);
  }


  getCurrent()
  {
    this.id = sessionStorage.getItem('p') as string;
    /* mi devo richiamare la get */
  }

  modifyProduct()
  {
    this.route.navigate(['/modifyProduct']);
  }

  addToCart()
  {
    /**/
    this.productService.getProductsByBrandAndModel(this.brand,this.model).subscribe((returnObject: IProduct[]) => {
    /* qua devo prendere l'array di prodotti che è nella session */
    if(returnObject.length > 0)
    {
      if(sessionStorage.getItem('cartProducts') == null) 
      {
        //alert("ho aggiunto il tuo array");
        sessionStorage.setItem('cartProducts',JSON.stringify([]));
      }
      
      /* mi ottengo l'array */
      var array = JSON.parse(sessionStorage.getItem('cartProducts') as string);
      var stringToMatch = JSON.stringify({"brand":returnObject[0].brand,"model":returnObject[0].model,"imageUrl":returnObject[0].imageUrl,"price":returnObject[0].price});
      var exists = false;
      for(var p of array)
      {
        if(JSON.stringify(p) == stringToMatch)
        {
          alert("prodotto gia presente nel carrello");
          exists = true;
        }
      }
      if(array.length <=4) /* questo è il numero massimo di prodotti che possono essere inseriti in una lista */
      {
        if(exists == false)
        {
          alert("prodotto inserito nel carrello");
          array.push({"brand":returnObject[0].brand,"model":returnObject[0].model,"imageUrl":returnObject[0].imageUrl,"price":returnObject[0].price});
          sessionStorage.setItem('cartProducts',JSON.stringify(array));
        }
      }
      else
      {
        alert("Non puoi aggiungere più di 5 prodotti al carrello");
      }
    }
    }, (error: HttpErrorResponse) => {})

  }

  deleteProduct()
  {
    this.productService.deleteProduct(this.brand,this.model).subscribe(
      response => {
        if(response == true)
        {
          this.route.navigate(['/results']);
        }
        else 
        {
          console.error("delete not completed")
        }
      });
  }

  /*--------------------------------------------------------------- */
  async getReviews(index:number)
  {
        var rate = (document.getElementById("ratings") as HTMLSelectElement).value as any;
        var username = (document.getElementById("users") as HTMLSelectElement).value as any;
        if (rate == "All ratings"){rate = null;}
        else if(rate == "★"){rate = "1";}
        else if(rate == "★★") {rate = "2";}
        else if(rate == "★★★") {rate = "3";}
        else if(rate == "★★★★") {rate = "4";}
        else if(rate == "★★★★★") {rate = "5";}
        if(username == "All users") {username = null;}
        this.reviews = await this.reviewService.getFilteredReviews(username,rate,this.brand,this.model);
        alert(JSON.stringify(this.reviews))
        this.calcolatePagerFinals(this.reviews);
        this.setPage(index);
        var cont = 0;
        this.averageRate = 0;
        for(var i = 0; i<this.reviews.length; i++)
        {
          this.averageRate+=this.reviews[i].rate as number;
          cont++;
        }
        this.averageRate/=cont;
        this.averageRate = Math.round(this.averageRate);
  }

  
  async setPage(indexPage: number) {
    if (indexPage < 1 || indexPage > this.pager.totalPages) {
        return;
    }

      this.pager.currentPage = indexPage;
      this.calcolatePagerIndexes(indexPage);
    
      this.pagedItems = this.reviews.slice((indexPage-1)*(this.pager.pageSize),(indexPage*this.pager.pageSize));
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

  addReview()
  {
    if(sessionStorage.getItem('user') != null)
    {
      this.route.navigate(['/addReview']);
    }
    else
    {
      sessionStorage.setItem('fromAddReview',"fromAddReview");
      this.route.navigate(['/login']);
    }
  }

  removeReview(title:string,text:string,rate:string)
  {
    this.reviewService.delete(this.username,rate,this.model,this.brand,title,text).subscribe(
      response =>{
        if(response == true)
        {
          this.getReviews(1);
        }
        else
        {
          alert("eliminazione NON riuscita");
        }
      }
    );
  }



}
