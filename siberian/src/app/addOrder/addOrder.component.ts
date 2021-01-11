import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-addOrder',
  templateUrl: './addOrder.component.html',
  styleUrls: ['./addOrder.component.scss']
})
export class AddOrderComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  setBorder(id: string,idInfo:string,idLabel:string)
  {
    (document.getElementById(id) as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 border border-gray-400 dark:border-gray-700 text-gray-800 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
    (document.getElementById(idInfo)as HTMLInputElement).setAttribute("class","text-sm text-gray-500");
    (document.getElementById(idInfo)as HTMLInputElement).innerHTML = "Saved in history"; 
    (document.getElementById(idLabel)as HTMLInputElement).style.visibility = "visible";
  }

  sendOrder()
  {
    
  }

}
