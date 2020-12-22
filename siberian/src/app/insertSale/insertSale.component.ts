import { ClassField } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-insertSale',
  templateUrl: './insertSale.component.html',
  styleUrls: ['./insertSale.component.css']
})
export class InsertSaleComponent implements OnInit {

  correctFormData = true;
  products:string[] = []; /* lista dei prodotti che vengono inseriti nella vendita */
  constructor() { }

  ngOnInit() {
  }

  /* complete */
  addToList()
  {
    
    if((document.getElementById("products") as HTMLInputElement).value as string != "") /*devo anche verificare che stia inserendo un id e non una cosa a cazzo */
    {
      if(this.validateSingleProductId((document.getElementById("products") as HTMLInputElement).value as string))
      {
        this.products.push((document.getElementById("products") as HTMLInputElement).value as string);
        /*div iniziale*/
        var div = document.createElement('div');
        div.id = (document.getElementById("products") as HTMLInputElement).value as string;
        div.setAttribute("class","my-1 mx-0.5 inline-block");
      /*span interno*/
        var span = document.createElement('span');
        span.id = "spanTag";
        span.setAttribute("style","background-color:#4900bc; color:#FFF;");
        span.setAttribute("class","text-white bg-blue-600 rounded-md px-2 py-1 text-lg uppercase font-semibold");
        div.appendChild(span);
      /*creo il div che contiene */
        var divName = document.createElement('div');
        divName.id = "tagName";
        divName.innerHTML = (document.getElementById("products") as HTMLInputElement).value as string;
        divName.setAttribute("class","inline-block");
        span.appendChild(divName);
      /*creo il bottone*/
        var button = document.createElement('button');
        button.id = "removeTag";
        button.innerHTML = "x";
        button.setAttribute("class","text-lg ml-1");
        button.setAttribute("type","button");
        span.appendChild(button);
        var array = this.products;
        button.addEventListener('click',function()
        {
          div.remove();
          array.splice(array.indexOf(divName.innerHTML),1);
        });
        this.products = array;
        (document.getElementById("tags") as HTMLDivElement).appendChild(div);
        // alert(this.products);
        (document.getElementById("products") as HTMLInputElement).value = "";
      }
      else
      {
        (document.getElementById("products") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
        (document.getElementById("hiddenProducts") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
        (document.getElementById("hiddenProducts") as HTMLInputElement).innerHTML = "You have to insert numeric id product"; 
        (document.getElementById("labelProducts") as HTMLInputElement).style.visibility = "hidden";
      }
    }
    else
    {
        (document.getElementById("products") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
        (document.getElementById("hiddenProducts") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
        (document.getElementById("hiddenProducts") as HTMLInputElement).innerHTML = "You have to digit a numeric id product"; 
        (document.getElementById("labelProducts") as HTMLInputElement).style.visibility = "hidden";
    }
  }

  validateSingleProductId(id:string)
  {
    let re = new RegExp("^[0-9]+$", "g");
    return(re.test(id) == true);
  }

  validateDate(date:string)
  {
    if(date == "")
      return false;
    return true;
  }

  validateClient(clientId: string)
  {
    let re = new RegExp("^[0-9]+$", "g");
    return(re.test(clientId) == true);
  }

  validatePrice(price: string)
  {
    /*34.00 459.99 */
    let re = new RegExp("^[0-9]+\.[0-9]{2}$", "g");
    return(re.test(price) == true);
  }

  validateWarehouse(warehouseId:string)
  {
    let re = new RegExp("^[0-9]+$", "g");
    return(re.test(warehouseId) == true);
  }

  validateProductCodes()
  {
    /* devo andare a fare dei controlli sull'array */
    if(this.products.length == 0)
      return false;
    return true;
  }

  setBorder(id: string,idInfo:string,idLabel:string)
  {
    (document.getElementById(id) as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 border border-gray-400 dark:border-gray-700 text-gray-800 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
    (document.getElementById(idInfo)as HTMLInputElement).setAttribute("class","text-sm text-gray-500");
    (document.getElementById(idInfo)as HTMLInputElement).innerHTML = "Saved in history"; 
    (document.getElementById(idLabel)as HTMLInputElement).style.visibility = "visible";
  }

  saveSale()
  {
    /* mi ottengo i campi */
    let date = (document.getElementById("date") as HTMLInputElement).value as string;
    let clientID = (document.getElementById("client") as HTMLInputElement).value as string;
    let warehouseID = (document.getElementById("warehouse") as HTMLInputElement).value as string;
    let price = (document.getElementById("price") as HTMLInputElement).value as string;

    if(this.validateDate(date) == false)
    {
      this.correctFormData = false;
     (document.getElementById("date") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
     (document.getElementById("hiddenDate") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
     (document.getElementById("hiddenDate") as HTMLInputElement).innerHTML = "Insert date"; 
     (document.getElementById("labelDate") as HTMLInputElement).style.visibility = "hidden"; 
    }
    if(this.validateClient(clientID) == false)
    {
      this.correctFormData = false;
      (document.getElementById("client") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
      (document.getElementById("hiddenClient") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
      (document.getElementById("hiddenClient") as HTMLInputElement).innerHTML = "Client is a numeric id"; 
      (document.getElementById("labelClient") as HTMLInputElement).style.visibility = "hidden";
    }
    if(this.validatePrice(price) == false)
    {
      this.correctFormData = false;
      (document.getElementById("price") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
      (document.getElementById("hiddenPrice") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
      (document.getElementById("hiddenPrice") as HTMLInputElement).innerHTML = "Insert price according this format dd.dd (Ex. 34.90)"; 
      (document.getElementById("labelPrice") as HTMLInputElement).style.visibility = "hidden"; 
    }
    if(this.validateWarehouse(warehouseID) == false)
    {
      this.correctFormData = false;
      (document.getElementById("warehouse") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
      (document.getElementById("hiddenWarehouse") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
      (document.getElementById("hiddenWarehouse") as HTMLInputElement).innerHTML = "Warehouse is a numeric id"; 
      (document.getElementById("labelWarehouse") as HTMLInputElement).style.visibility = "hidden";
    }
    if(this.validateProductCodes() == false)
    {
      this.correctFormData = false;
      (document.getElementById("products") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
      (document.getElementById("hiddenProducts") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
      (document.getElementById("hiddenProducts") as HTMLInputElement).innerHTML = "You have to insert at least 1 product"; 
      (document.getElementById("labelProducts") as HTMLInputElement).style.visibility = "hidden";
    }

    if(this.correctFormData == true)
    {
      /* qua dentro vado ad effettuare il salvataggio per il caricamento della vendita */
    }
  }

}
