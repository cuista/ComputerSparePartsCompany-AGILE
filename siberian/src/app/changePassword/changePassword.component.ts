import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-changePassword',
  templateUrl: './changePassword.component.html',
  styleUrls: ['./changePassword.component.scss']
})
export class ChangePasswordComponent implements OnInit {

  wrongData = false;
  errorLoginMessage = "The 2 password are not equal";
  correctFormatData = true;

  constructor(private route: Router) { }

  setBorder(id: string,idInfo:string,idLabel:string)
  {
    (document.getElementById(id) as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 border border-gray-400 dark:border-gray-700 text-gray-800 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
    (document.getElementById(idInfo)as HTMLInputElement).setAttribute("class","text-sm text-gray-500");
    (document.getElementById(idInfo)as HTMLInputElement).innerHTML = ""; 
    (document.getElementById(idLabel)as HTMLInputElement).style.visibility = "visible";
  }
  
  validatePassword(password: string)
  {
    let re = new RegExp("^[A-Za-z0-9]{8,16}$", "g");
    return(re.test(password) == true);
  }

  ngOnInit() {
  }

  hideMessage()
  {
    this.wrongData = false;
  }

  changePassword()
  {
    this.correctFormatData = true;
    let old = (document.getElementById("old") as HTMLInputElement).value as string;
    let neu = (document.getElementById("new") as HTMLInputElement).value as string;
    if(old == neu)
    {
      if(this.validatePassword(old) == false)
      {
        this.correctFormatData = false;
        (document.getElementById("old") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
        (document.getElementById("hiddenOld") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
        (document.getElementById("hiddenOld") as HTMLInputElement).innerHTML = "At least 8 characters"; 
        (document.getElementById("labelOld") as HTMLInputElement).style.visibility = "hidden"; 
      }
      if(this.validatePassword(neu) == false)
      {
        this.correctFormatData = false;
        (document.getElementById("new") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
        (document.getElementById("hiddenNew") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
        (document.getElementById("hiddenNew") as HTMLInputElement).innerHTML = "At least 8 characters"; 
        (document.getElementById("labelNew") as HTMLInputElement).style.visibility = "hidden"; 
      }
      
      if(this.correctFormatData)
      {
        /* c'è da capire che tipo di utente sta modificando la password */        
        let type = sessionStorage.getItem('type');
        /* poi viene richiamato un metodo dal service che permette di fare una post
        e inserire la nuova password */
        this.route.navigate(['/customerPage']);
      }
    }
    else
    {
      this.wrongData = true;
    }
      
  }


}
