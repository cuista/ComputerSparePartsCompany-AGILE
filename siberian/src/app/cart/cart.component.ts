import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PurchaseNoticeService } from '../Services/data/purchaseNotice.service';


@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})

export class CartComponent implements OnInit {

  correctFormData = true;
  products = [] as any;  
  emptyCart = true;
  quantity = [] as any;

  constructor(
    private route: Router,
    private purchaseNotice: PurchaseNoticeService
  ) { }

  ngOnInit() {
    /* posso accedere a questa parte solo nel caso in cui NON sono un amministratore */
    if(sessionStorage.getItem('type') == "employee")
    {
      this.route.navigate(['/404']);
    }
    /* mo mi faccio la prova del carrello */
    this.products = JSON.parse(sessionStorage.getItem("cartProducts") as string);
    if(sessionStorage.getItem('cartProducts') != null)
    {
      if(this.products.length <= 0)
      {
        (document.getElementById("empty") as HTMLDivElement).setAttribute("class","py-2");
        (document.getElementById("send") as HTMLDivElement).setAttribute("class","py-2 hidden");
      } 
      else
      {
        (document.getElementById("send") as HTMLDivElement).setAttribute("class","py-2");
        (document.getElementById("empty") as HTMLDivElement).setAttribute("class","py-2 hidden");
      }
    }
    
  }

  validateDate(date:string)
  {
    if(date == "")
      return false;
    return true;
  }

  setBorder(id: string,idInfo:string,idLabel:string)
  {
    (document.getElementById(id) as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 border border-gray-400 dark:border-gray-700 text-gray-800 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
    (document.getElementById(idInfo)as HTMLInputElement).setAttribute("class","text-sm text-gray-500");
    (document.getElementById(idInfo)as HTMLInputElement).innerHTML = "Insert the pick-up date"; 
    (document.getElementById(idLabel)as HTMLInputElement).style.visibility = "visible";
  }

  remove(brand:string,model:string)
  {
    /* qua dentro devo andare a prendere tutta la lista dei prodotti */
    for(var i = 0; i<this.products.length; i++)
    {
      if(brand == this.products[i].brand && model == this.products[i].model)
      {
        this.products.splice(i,1);
      }
    }
    sessionStorage.setItem("cartProducts",JSON.stringify(this.products));
    if(this.products.length == 0)
    {
      (document.getElementById("empty") as HTMLDivElement).setAttribute("class","py-2");
      (document.getElementById("send") as HTMLDivElement).setAttribute("class","py-2 hidden");
    }
  } 

  sendList()
  {
    this.correctFormData = true;
    let date = (document.getElementById("date") as HTMLInputElement).value as string;
    if(this.validateDate(date) == false)
    {
      this.correctFormData = false;
     (document.getElementById("date") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
     (document.getElementById("hiddenDate") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
     (document.getElementById("hiddenDate") as HTMLInputElement).innerHTML = "Insert the pick-up date"; 
     (document.getElementById("labelDate") as HTMLInputElement).style.visibility = "hidden"; 
    }
    
    if(this.correctFormData == true)
    {
      if(sessionStorage.getItem("user") == null)
      {
        this.route.navigate(["/login"]);
        sessionStorage.setItem("fromCart","");
      }
      else
      {
        alert("stai per inviare la tua notice");
          /* qua dentro per prova vado a stamparmi  le quantita*/
        var array = document.getElementsByClassName("form-input sm:w-1/2 w-full h-10 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border border-gray-400 dark:border-gray-700 text-gray-800 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
        for(var i = 0; i<this.products.length; i++)
        {
          /* per ogni prodotto invoco un add purchaseNotice */
          this.purchaseNotice.saveNotice(date,sessionStorage.getItem('user') as string,"0",this.products[i].brand,this.products[i].model,(array[i] as HTMLInputElement).value).subscribe(
            response =>{
              if(response == true)
              {
                alert("è stata inserita");
              }
              else
              {
                alert("c'è stato un errore");
              }
            }
          );
        } 

        /* dopodiche elimino praticamente la cartProducts dalla sessione e svuoto this.products */
        this.products = [];
        sessionStorage.removeItem("cartProducts");
        (document.getElementById("empty") as HTMLDivElement).setAttribute("class","py-2");
        (document.getElementById("send") as HTMLDivElement).setAttribute("class","py-2 hidden");
      }
    }
  }

}
