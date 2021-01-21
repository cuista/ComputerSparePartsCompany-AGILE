import { Component, OnInit } from '@angular/core';
import { HouseService } from '../Services/data/house.service';
import { OrderService } from '../Services/data/order.service';

@Component({
  selector: 'app-addOrder',
  templateUrl: './addOrder.component.html',
  styleUrls: ['./addOrder.component.scss']
})
export class AddOrderComponent implements OnInit {

  orders = [] as any;
  type = "" as string;

  pager = {
    totalItems: 0, 
    currentPage: 1,
    pageSize:5, 
    totalPages: 1, 
    startPage: 1,
    endPage: 5,
    startIndex:0,
    endIndex:4,
    pages: []
  } as any;

  // paged items
  pagedItems = [] as any;

  constructor(private houseService: HouseService,
              private orderService: OrderService) { }
  names = [] as any;
  correctFormData = true;

  ngOnInit() {

    if(sessionStorage.getItem('type') != "customer")
    {
      this.type = sessionStorage.getItem("type") as string;
      this.getProducts(1);
    }     
    this.names = this.houseService.getNames().subscribe(
      (data) =>{this.names = data}
    );

  }

  async getProducts(index:number)
  {
    if(sessionStorage.getItem('type') != null)
    {
      if(sessionStorage.getItem('type') == "employee")
      {
        this.orders = await this.orderService.getAll();
        this.calcolatePagerFinals(this.orders);
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
    
      this.pagedItems = this.orders.slice((indexPage-1)*(this.pager.pageSize),(indexPage*this.pager.pageSize));
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

  validateNumber(number: string)
  {
    let re = new RegExp("^[0-9]+$", "g");
    return(re.test(number) == true && number != "0");
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
    var house = (document.getElementById("users") as HTMLSelectElement).value;
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
      this.orderService.insert(quantity,brand,model,warehouse,house).subscribe(
        response =>
        {
          if(response == true)
          {
            (document.getElementById("quantity") as HTMLInputElement).value = "";
            (document.getElementById("brand") as HTMLInputElement).value = "";
            (document.getElementById("model") as HTMLInputElement).value = "";
            (document.getElementById("warehouse") as HTMLInputElement).value = "";
            this.successPopup();
            this.getProducts(1);
          }
          else
          {
            alert("problems"); 
          }
        }
      );
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
