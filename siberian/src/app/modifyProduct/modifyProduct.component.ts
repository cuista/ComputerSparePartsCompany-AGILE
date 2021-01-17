import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IProduct } from '../actors/product';
import { ProductsService } from '../Services/data/products.service';

@Component({
  selector: 'app-modifyProduct',
  templateUrl: './modifyProduct.component.html',
  styleUrls: ['./modifyProduct.component.scss']
})
export class ModifyProductComponent implements OnInit {

  brand = sessionStorage.getItem('brand') as string;
  model = sessionStorage.getItem('model') as string;
  correctFormData = true;
  constructor(
    private route: Router,
    private productService: ProductsService
  ) { }

  ngOnInit() {

    var price = "";
    var description = "";
    var imageUrl = "";
    var category = "";
    /* ora qua dentro mi vado a prendere il mio product */
    this.productService.getProductsByBrandAndModel(this.brand,this.model).subscribe(
      (returnObject: IProduct[]) => {
        if(returnObject.length > 0)
        {
          price = returnObject[0].price;
          description = returnObject[0].description;
          imageUrl = returnObject[0].imageUrl;
          // category = returnObject[0].category.categoryName;
          if(category == null)
          {
            category = "0";
          }
          (document.getElementById("price") as HTMLInputElement).value = price;
          (document.getElementById("image") as HTMLInputElement).value = imageUrl;
          (document.getElementById("description") as HTMLTextAreaElement).value = description;
        }
      }
    );
  }

  validateBrand(brand:string)
  {
    /* il brand deve essere valido ovvero deve presentare almeno 4 caratteri e massimo 100 caratteri */
    let re = new RegExp("^[A-Za-z0-9]{4,100}$", "g");
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
    let re = new RegExp("^[A-Za-z0-9]{4,100}$", "g");
    return(re.test(model) == true);
  }

  validateImage(image:string) /* incompleta */
  {
    /* link */
    // let re = new RegExp("[A-Za-z0-9]+\\.[A-Za-z0-9]{2,6}\$", "g");
    // return(re.test(image) == true);
    return true;
  }

  validatePrice(price: string)
  {
    /*34.00 459.99 */
    let re = new RegExp("^[0-9]+\.[0-9]{2}$", "g");
    return(re.test(price) == true);
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

  updateProduct()
  {
    /* mi ottengo i campi */
    this.correctFormData = true;
    let image = (document.getElementById("image") as HTMLInputElement).value as string;
    let category = (document.getElementById("categories") as HTMLSelectElement).value as string;
    let price = (document.getElementById("price") as HTMLInputElement).value as string;
    let description = (document.getElementById("description") as HTMLInputElement).value as string;
    if(description == "") description = "no description";
    /* controllo */
    if(this.validateImage(image) == false)
    {
      this.correctFormData = false;
     (document.getElementById("image") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
     (document.getElementById("hiddenImage") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
     (document.getElementById("hiddenImage") as HTMLInputElement).innerHTML = "It must be a url"; 
     (document.getElementById("labelImage") as HTMLInputElement).style.visibility = "hidden"; 
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
      this.productService.updateProduct(this.brand,this.model,image,category,price,description).subscribe(
        response => {
          if(response == true)
          {
            alert("il prodotto è stato aggiornato")
            this.route.navigate(['/product']);
          }
          else 
          {
            alert("non è stato aggiornato")
          }
        });
    }
    



  }

}
