import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-addOrder',
  templateUrl: './addOrder.component.html',
  styleUrls: ['./addOrder.component.scss']
})
export class AddOrderComponent implements OnInit {

  constructor() { }

  correctFormData = true;
  ngOnInit() {
  }

  validateNumber(number: string)
  {
    let re = new RegExp("^[0-9]+$", "g");
    return(re.test(number) == true);
  }

  validateName(name:string)
  {
    return (name!="");
  }

  setBorder(id: string,idInfo:string,idLabel:string)
  {
    (document.getElementById(id) as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 border border-gray-400 dark:border-gray-700 text-gray-800 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
    (document.getElementById(idInfo)as HTMLInputElement).setAttribute("class","text-sm text-gray-500");
    (document.getElementById(idLabel)as HTMLInputElement).style.visibility = "visible";
  }

  sendOrder()
  {
    this.correctFormData = true;
    var quantity = (document.getElementById("quantity") as HTMLInputElement).value;
    var brand = (document.getElementById("brand") as HTMLInputElement).value;
    var model = (document.getElementById("model") as HTMLInputElement).value;
    var warehouse = (document.getElementById("warehouse") as HTMLInputElement).value;
    if(this.validateNumber(quantity) == false)
    {
     this.correctFormData = false;
     (document.getElementById("quantity") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
     (document.getElementById("hiddenQuantity") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
     (document.getElementById("labelQuantity") as HTMLInputElement).style.visibility = "hidden"; 
    }
    if(this.validateNumber(warehouse) == false)
    {
      this.correctFormData = false;
     (document.getElementById("warehouse") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
     (document.getElementById("hiddenWarehouse") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
     (document.getElementById("labelWarehouse") as HTMLInputElement).style.visibility = "hidden"; 
    }
    if(this.validateName(brand) == false)
    {
      this.correctFormData = false;
     (document.getElementById("brand") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
     (document.getElementById("hiddenBrand") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
     (document.getElementById("labelBrand") as HTMLInputElement).style.visibility = "hidden"; 
    
    }
    if(this.validateName(model) == false)
    {
      this.correctFormData = false;
      (document.getElementById("model") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
      (document.getElementById("hiddenModel") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
      (document.getElementById("labelModel") as HTMLInputElement).style.visibility = "hidden"; 
    }
    if(this.correctFormData)
    {
      alert("fatto");
    }
  }

  successPopup(){
    (document.getElementById("alertDivOk") as HTMLElement).classList.add("show");
    (document.getElementById("alertDivOk") as HTMLElement).classList.remove("hide");
    (document.getElementById("alertDivOk") as HTMLElement).classList.add("showAlert");

    setTimeout(function(){
      (document.getElementById("alertDivOk") as HTMLElement).classList.remove("show");
      (document.getElementById("alertDivOk") as HTMLElement).classList.add("hide");},1000)
  }

}
