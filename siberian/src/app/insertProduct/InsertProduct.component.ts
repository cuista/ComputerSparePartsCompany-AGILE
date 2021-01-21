import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductsService } from '../Services/data/products.service';

@Component({
  selector: 'app-InsertProduct',
  templateUrl: './InsertProduct.component.html',
  styleUrls: ['./InsertProduct.component.css']
})
export class InsertProductComponent implements OnInit {

  correctFormData = true;
  constructor(
    private route: Router,
    private productService: ProductsService
  ) { }

  ngOnInit() {
    if(sessionStorage.getItem("type") == "customer")
    {
      this.route.navigate(["/404"]);
    }
  }

  validateBrand(brand:string)
  {
    /* il brand deve essere valido ovvero deve presentare almeno 4 caratteri e massimo 100 caratteri */
    let re = new RegExp("^[A-Za-z0-9 ]{4,100}$", "g");
    return(re.test(brand) == true);
  }

  setBorder(id: string,idInfo:string,idLabel:string)
  {
    (document.getElementById(id) as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 border border-gray-400 dark:border-gray-700 text-gray-800 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
    (document.getElementById(idInfo)as HTMLInputElement).setAttribute("class","text-sm text-gray-500");
    if(id!="order" && id!="warehouse")
      (document.getElementById(idInfo)as HTMLInputElement).innerHTML = "Visible on product page"; 
    else
      (document.getElementById(idInfo)as HTMLInputElement).innerHTML = "Not visible on product page";
    (document.getElementById(idLabel)as HTMLInputElement).style.visibility = "visible";
  }


  validateModel(model: string)
  {
    let re = new RegExp("^[A-Za-z0-9 ]{4,100}$", "g");
    return(re.test(model) == true);
  }

  validateImage(image:string) /* incompleta */
  {
    /* link */
    // let re = new RegExp("[A-Za-z0-9]+\\.[A-Za-z0-9]{2,6}\$", "g");
    // return(re.test(image) == true);
    return image!="";
  }

  validateCategory(category: string)
  {
    /*Input */
    let re = new RegExp("^[A-Za-z0-9 ]{4,100}$", "g");
    return(re.test(category) == true);
  }

  validatePrice(price: string)
  {
    /*34.00 459.99 */
    let re = new RegExp("^[0-9]+\.[0-9]{2}$", "g");
    return(re.test(price) == true);
  }

  validateOrder(order: string)
  {
    /* 4 90 */
    let re = new RegExp("^[0-9]+$", "g");
    return(re.test(order) == true);
  }

  validateWarehouse(warehouse: string)
  {
    /* 4 90 */
    let re = new RegExp("^[0-9]+$", "g");
    return(re.test(warehouse) == true);
  }
  
  validateDescription(description: string)
  {
    /* la descrizione non deve per il momento essere sottoposta ad alcun controllo e nel caso in cui sia vuota
    deve praticamente essere inserita come 'no description' */
    return true;
  }

  setOriginalDescription()
  {
    (document.getElementById("description") as HTMLTextAreaElement).setAttribute("class","form-input resize-y w-full mt-2 py-3 px-3 bg-white dark:bg-gray-800 border border-gray-400 dark:border-gray-700 text-gray-800 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
    (document.getElementById("description") as HTMLTextAreaElement).setAttribute("rows","6");
    (document.getElementById("hiddenDescription") as HTMLDivElement).setAttribute("class","text-sm text-gray-800");
    (document.getElementById("hiddenDescription") as HTMLDivElement).innerHTML = 'Pubblicato sulla tua scheda'; 
  }

  saveProduct()
  {
    this.correctFormData = true;
    /* mi ottengo i campi */
    let brand = (document.getElementById("brand") as HTMLInputElement).value as string;
    let model = (document.getElementById("model") as HTMLInputElement).value as string;
    let image = (document.getElementById("image") as HTMLInputElement).value as string;
    let category = (document.getElementById("categories") as HTMLSelectElement).value as string;
    let warehouse = (document.getElementById("warehouse") as HTMLInputElement).value as string;
    let price = (document.getElementById("price") as HTMLInputElement).value as string;
    let order = (document.getElementById("order") as HTMLInputElement).value as string;
    let description = (document.getElementById("description") as HTMLInputElement).value as string;
    if(description == "") description = "no description";
    /* controllo */
    if(this.validateBrand(brand) == false)
    {
      this.correctFormData = false;
     (document.getElementById("brand") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
     (document.getElementById("hiddenBrand") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
     (document.getElementById("hiddenBrand") as HTMLInputElement).innerHTML = "Brand must consist of a minimum of 4 letters and a maximum of 100"; 
     (document.getElementById("labelBrand") as HTMLInputElement).style.visibility = "hidden"; 
    }
    if(this.validateModel(model) == false)
    {
      this.correctFormData = false;
     (document.getElementById("model") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
     (document.getElementById("hiddenModel") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
     (document.getElementById("hiddenModel") as HTMLInputElement).innerHTML = "Model must consist of a minimum of 4 letters and a maximum of 100"; 
     (document.getElementById("labelModel") as HTMLInputElement).style.visibility = "hidden"; 
    }
    if(this.validateImage(image) == false)
    {
      this.correctFormData = false;
     (document.getElementById("image") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
     (document.getElementById("hiddenImage") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
     (document.getElementById("hiddenImage") as HTMLInputElement).innerHTML = "It must be a url"; 
     (document.getElementById("labelImage") as HTMLInputElement).style.visibility = "hidden"; 
    }
    if(this.validateOrder(order) == false)
    {
      this.correctFormData = false;
     (document.getElementById("order") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
     (document.getElementById("hiddenOrder") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
     (document.getElementById("hiddenOrder") as HTMLInputElement).innerHTML = "Order must be a numeric id"; 
     (document.getElementById("labelOrder") as HTMLInputElement).style.visibility = "hidden"; 
    }
    if(this.validateWarehouse(warehouse) == false)
    {
      this.correctFormData = false;
     (document.getElementById("warehouse") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
     (document.getElementById("hiddenWarehouse") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
     (document.getElementById("hiddenWarehouse") as HTMLInputElement).innerHTML = "Warehouse must be a numeric id"; 
     (document.getElementById("labelWarehouse") as HTMLInputElement).style.visibility = "hidden"; 
    }
    if(this.validatePrice(price) == false)
    {
      this.correctFormData = false;
     (document.getElementById("price") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
     (document.getElementById("hiddenPrice") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
     (document.getElementById("hiddenPrice") as HTMLInputElement).innerHTML = "Insert price according this format dd.dd (Ex. 34.90)"; 
     (document.getElementById("labelPrice") as HTMLInputElement).style.visibility = "hidden"; 
    }
    if(this.validateDescription(description) == false)
    {
      this.correctFormData = false;
     (document.getElementById("description") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
     (document.getElementById("hiddenDescription") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
     (document.getElementById("hiddenDescription") as HTMLInputElement).innerHTML = "Model must consist of a minimum of 4 letters and a maximum of 100"; 
     (document.getElementById("labelDescription") as HTMLInputElement).style.visibility = "hidden"; 
    }
    else
    {
      if(description == "no description")
        (document.getElementById("description") as HTMLInputElement).innerHTML = "no description";
    }

    if(this.correctFormData)
    {
      /* se inserisco un prodotto che abbia praticamente lo stesso brand e modello 
      di uno già presente allora questo dovrà avere gli stessi campi di quello che 
      sto provando ad inserire*/
      
      /* qua dovrei andare a controllare che non esistano già quei brand e quei modelli all'interno del mio inventario*/

      /* inserimento del prodotto usando il service che devo ancora implementare */
      this.productService.saveProduct(brand,model,image,category,warehouse,price,order,description).subscribe(
        response => {
          if(response == true)
          {
            this.insertProductPopup();
            /* tutti i campi qui dovrebbero essere di nuovo vuoti */
            this.route.navigate(['/insert']);
           (document.getElementById("brand") as HTMLInputElement).value = "";
           (document.getElementById("model") as HTMLInputElement).value = "";
           (document.getElementById("image") as HTMLInputElement).value = "";
           (document.getElementById("warehouse") as HTMLInputElement).value = "";
           (document.getElementById("price") as HTMLInputElement).value = "";
           (document.getElementById("order") as HTMLInputElement).value = "";
           (document.getElementById("description") as HTMLInputElement).value = "";
    
          }
          else 
          {
            alert("c'è qualche problema");
          }
        });
    }
    



  }

  insertProductPopup(){
    (document.getElementById("alertDivOk") as HTMLElement).classList.add("show");
    (document.getElementById("alertDivOk") as HTMLElement).classList.remove("hide");
    (document.getElementById("alertDivOk") as HTMLElement).classList.add("showAlert");

    setTimeout(function(){
      (document.getElementById("alertDivOk") as HTMLElement).classList.remove("show");
      (document.getElementById("alertDivOk") as HTMLElement).classList.add("hide");},1000)
  }

}
