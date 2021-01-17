import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../Services/data/user.service';

@Component({
  selector: 'app-changePassword',
  templateUrl: './changePassword.component.html',
  styleUrls: ['./changePassword.component.scss']
})
export class ChangePasswordComponent implements OnInit {

  wrongData = false;
  errorLoginMessage = "The 2 password are not equal";
  correctFormatData = true;

  constructor(private route: Router,
              private userService: UserService) { }

  validateOld(old:string)
  {
    if(old == "" || old == null)
      return false;
    return true;
  }

  setOld()
  {
    (document.getElementById("old") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 border border-gray-400 dark:border-gray-700 text-gray-800 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
    (document.getElementById("hiddenOld")as HTMLInputElement).setAttribute("class","text-sm text-gray-500");
    (document.getElementById("hiddenOld")as HTMLInputElement).innerHTML = "Insert current password"; 
    (document.getElementById("labelOld")as HTMLInputElement).style.visibility = "visible";
  }

  setBorder(id: string,idInfo:string,idLabel:string)
  {
    (document.getElementById(id) as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 border border-gray-400 dark:border-gray-700 text-gray-800 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
    (document.getElementById(idInfo)as HTMLInputElement).setAttribute("class","text-sm text-gray-500");
    (document.getElementById(idInfo)as HTMLInputElement).innerHTML = "At least 8 characters"; 
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
    let neu1 = (document.getElementById("new1") as HTMLInputElement).value as string;
    let neu2 = (document.getElementById("new2") as HTMLInputElement).value as string;
    
      if(this.validateOld(old) == false)
      {
        this.correctFormatData = false;
        (document.getElementById("old") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
        (document.getElementById("hiddenOld") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
        (document.getElementById("hiddenOld") as HTMLInputElement).innerHTML = "This isn't the current password"; 
        (document.getElementById("labelOld") as HTMLInputElement).style.visibility = "hidden"; 
      }
      if(this.validatePassword(neu1) == false)
      {
        this.correctFormatData = false;
        (document.getElementById("new1") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
        (document.getElementById("hiddenNew1") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
        (document.getElementById("hiddenNew1") as HTMLInputElement).innerHTML = "At least 8 characters"; 
        (document.getElementById("labelNew1") as HTMLInputElement).style.visibility = "hidden"; 
      }
      if(this.validatePassword(neu2) == false)
      {
        this.correctFormatData = false;
        (document.getElementById("new2") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
        (document.getElementById("hiddenNew2") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
        (document.getElementById("hiddenNew2") as HTMLInputElement).innerHTML = "At least 8 characters"; 
        (document.getElementById("labelNew2") as HTMLInputElement).style.visibility = "hidden"; 
      }
      
      if(this.correctFormatData)
      {
        if(neu1 == neu2)
        {
          let type = sessionStorage.getItem('type');
          if(type == "customer")
          {
            // alert("stai cambiando quella del customer");
            this.userService.changePasswordCustomer(sessionStorage.getItem('user') as string,neu1,old).subscribe(
              response=>{
                if(response == true)
                {
                  this.route.navigate(['/customerPage']);
                }
                else
                {
                  (document.getElementById("old") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
                  (document.getElementById("hiddenOld") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
                  (document.getElementById("hiddenOld") as HTMLInputElement).innerHTML = "This isn't the current password"; 
                  (document.getElementById("labelOld") as HTMLInputElement).style.visibility = "hidden"; 
                }
              }
            );
          }
          else if(type == "employee")
          {
            //alert("stai cambiando quella di un admin");
            this.userService.changePasswordEmployee(sessionStorage.getItem('user') as string,neu1,old).subscribe(
              response=>{
                if(response == true)
                {
                  this.route.navigate(['/customerPage']);
                }
                else
                {
                  (document.getElementById("old") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
                  (document.getElementById("hiddenOld") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
                  (document.getElementById("hiddenOld") as HTMLInputElement).innerHTML = "This isn't the current password"; 
                  (document.getElementById("labelOld") as HTMLInputElement).style.visibility = "hidden"; 
                }
              }
            );
          }
          //this.route.navigate(['/customerPage']);
        }
        else
        {
          this.wrongData = true;
        }
        
      }
      
    
      
  }


}
