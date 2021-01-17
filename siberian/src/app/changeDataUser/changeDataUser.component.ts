import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../Services/data/user.service';

@Component({
  selector: 'app-changeDataUser',
  templateUrl: './changeDataUser.component.html',
  styleUrls: ['./changeDataUser.component.scss']
})
export class ChangeDataUserComponent implements OnInit {

  user = "";
  correctFormatData = true;
  constructor(
    private route:Router,
    private userService: UserService
  ) { }

  ngOnInit() {
    this.user = sessionStorage.getItem("user") as string;
  }

  validateIVA(iva: string)
  {
    let re = new RegExp("^[0-9]{11}", "g");
    return(re.test(iva) == true);
  }

  validatePhoneNumber(phoneNumber: string)
  {
    let re = new RegExp("^3[0-9]{9}", "g");
    return(re.test(phoneNumber) == true);
  }

  validateLenght(text: string)
  {
    let regexpNumber = new RegExp('^[0-9A-Za-z]{5,100}.*$'); /* da controllare */
      return(regexpNumber.test(text) == true);
  }

  setBorder(id: string,idInfo:string,idLabel:string)
  {
    (document.getElementById(id) as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 border border-gray-400 dark:border-gray-700 text-gray-800 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
    (document.getElementById(idInfo)as HTMLInputElement).setAttribute("class","text-sm text-gray-500");
    if(id!="password")
      (document.getElementById(idInfo)as HTMLInputElement).innerHTML = "Visible on your page"; 
      (document.getElementById(idLabel)as HTMLInputElement).style.visibility = "visible";
  }



  save()
  {
    this.correctFormatData = true;
    let name = (document.getElementById("name") as HTMLInputElement).value as string;
    let surname = (document.getElementById("surname") as HTMLInputElement).value as string;
    let phoneNumber = (document.getElementById("phoneNumber") as HTMLInputElement).value as string;
    let iva = (document.getElementById("iva") as HTMLInputElement).value as string;
    
    if(this.validateLenght(name) == false)
    {
      (document.getElementById("name") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
      (document.getElementById("hiddenName") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
      (document.getElementById("hiddenName") as HTMLInputElement).innerHTML = "Name must be composed al least by 5 character"; 
      (document.getElementById("labelName") as HTMLInputElement).style.visibility = "hidden"; 
      this.correctFormatData = false;
    }
    if(this.validateLenght(surname) == false)
    {
      (document.getElementById("surname") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
      (document.getElementById("hiddenSurname") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
      (document.getElementById("hiddenSurname") as HTMLInputElement).innerHTML = "Surname must be composed al least by 5 character"; 
      (document.getElementById("labelSurname") as HTMLInputElement).style.visibility = "hidden"; 
      this.correctFormatData = false;
    }
    if(this.validatePhoneNumber(phoneNumber) == false)
    {
      (document.getElementById("phoneNumber") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
      (document.getElementById("hiddenPhoneNumber") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
      (document.getElementById("hiddenPhoneNumber") as HTMLInputElement).innerHTML = "Number Phone must be composed by 10 characters and the first is 3"; 
      (document.getElementById("labelPhoneNumber") as HTMLInputElement).style.visibility = "hidden"; 
      this.correctFormatData = false;
    }
    if(this.validateIVA(iva) == false)
    {
      (document.getElementById("iva") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
      (document.getElementById("hiddenIva") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
      (document.getElementById("hiddenIva") as HTMLInputElement).innerHTML = "It must be composed by 11 numbers"; 
      (document.getElementById("labelIva") as HTMLInputElement).style.visibility = "hidden"; 
      this.correctFormatData = false;
    }

    if(this.correctFormatData)
    {
      this.userService.changeDataEmployee(sessionStorage.getItem('user') as string, name, surname,phoneNumber,iva).subscribe(
        response =>{
          if(response == true)
          {
            this.route.navigate(['/customerPage']);
          }
          else
          {
            /* lascio l'alert tanto qua dentro non dovrebbe mai entrare */
            alert("Qualcosa è andato storto");
          }
        }
      )

    }  
  }

  

}
