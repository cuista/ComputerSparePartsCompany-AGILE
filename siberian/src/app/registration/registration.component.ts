import { Component, NgZone, OnInit, Renderer2 } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { ReCaptcha2Component } from 'ngx-captcha';
import { RegistrationService } from '../Services/data/registration.service';

declare var grecaptcha: any; 

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  correctFormatData = true;
  message = "";
  showMessage = false;
  rec = null;

  recaptchaKeySite = "6Leq5REaAAAAAPSUOgTK-Ylj73t9iv3w5F02X4mv";
  recaptchaKeySecret = "6Leq5REaAAAAAD6qCQGHvCylsxUqaTmvWMLxNkBb";

  constructor(
    private registrationService: RegistrationService,
    private route: Router) { }

  ngOnInit() {
    if(sessionStorage.getItem('user')!=null)
    {
      this.route.navigate(['/404']);
    }
    grecaptcha.render('recaptcha', {'sitekey' : '6Ldk0RYaAAAAAPkmDFrs4UgGpfGu3rlDPegrwBve'});
  }

  hiddenMessage()
  {
    this.showMessage = false;
  }

  /* controllo che la lunghezza dei parametri passati alla form siano tutti maggiori di 4 */
  validateLenght(text: string)
  {
    let regexpNumber = new RegExp('^[0-9A-Za-z]{5,100}.*$'); /* da controllare */
      return(regexpNumber.test(text) == true);
  }

  validatePassword(password: string)
  {
    let re = new RegExp("^[A-Za-z0-9]{8,16}$", "g");
    return(re.test(password) == true);
  }

  validateEmail(email: string)
  {
    let re = new RegExp("[A-z0-9\.\+_-]+@[A-z0-9\._-]+\.[A-z]{2,6}", "g");
    return(re.test(email) == true);  
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

  setBorder(id: string,idInfo:string,idLabel:string)
  {
    (document.getElementById(id) as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 border border-gray-400 dark:border-gray-700 text-gray-800 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
    (document.getElementById(idInfo)as HTMLInputElement).setAttribute("class","text-sm text-gray-500");
    if(id!="password")
      (document.getElementById(idInfo)as HTMLInputElement).innerHTML = "Visible on your page"; 
      (document.getElementById(idLabel)as HTMLInputElement).style.visibility = "visible";
  }

  existsUsername(username: string)
  {
    /* qua dentro devo andare a verificare che praticamente che non abbia gia praticamente lo stesso username ed email all'interno  */
    this.registrationService.getUsername(username).subscribe(
      response => {
        if(response == true)
        {
          this.correctFormatData = false;
          (document.getElementById("username") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
          (document.getElementById("hiddenUsername") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
          (document.getElementById("hiddenUsername") as HTMLInputElement).innerHTML = "Username already exists"; 
          (document.getElementById("labelUsername") as HTMLInputElement).style.visibility = "hidden"; 
        }
      });
  }

  setRecOriginal()
  {
    (document.getElementById("hiddenRecaptcha") as HTMLInputElement).setAttribute("class","text-sm text-gray-500");
  }

  existsEmail(email: string)
  {
    /* qua dentro devo andare a verificare che praticamente che non abbia gia praticamente lo stesso username ed email all'interno  */
    this.registrationService.getEmail(email).subscribe(
      response => {
        if(response == true)
        {
          this.correctFormatData = false;
          (document.getElementById("email") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
          (document.getElementById("hiddenEmail") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
          (document.getElementById("hiddenEmail") as HTMLInputElement).innerHTML = "Email already exists"; 
          (document.getElementById("labelEmail") as HTMLInputElement).style.visibility = "hidden"; 
        }
      });
  }

  saveCustomer()
  {
    this.correctFormatData = true;
    let name = (document.getElementById("name") as HTMLInputElement).value as string;
    let surname = (document.getElementById("surname") as HTMLInputElement).value as string;
    let phoneNumber = (document.getElementById("phoneNumber") as HTMLInputElement).value as string;
    let email = (document.getElementById("email") as HTMLInputElement).value as string;
    let username = (document.getElementById("username") as HTMLInputElement).value as string;
    let password = (document.getElementById("password") as HTMLInputElement).value as string;
    let iva = (document.getElementById("iva") as HTMLInputElement).value as string;

    /* vincoli:
      username e password non devono essere gia presenti nel database (basta fare delle get e ottenere tutto)
    */
   if(this.validatePhoneNumber(phoneNumber) == false)
   {
     /* devo andare a settare in rosso praticamente la mia input */
     (document.getElementById("phoneNumber") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
     (document.getElementById("hiddenPhoneNumber") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
     (document.getElementById("hiddenPhoneNumber") as HTMLInputElement).innerHTML = "Number Phone must be composed by 10 characters and the first is 3"; 
     (document.getElementById("labelPhoneNumber") as HTMLInputElement).style.visibility = "hidden"; 
     this.correctFormatData = false;
   }
   if(this.validateLenght(surname) == false)
   {
     /* devo andare a settare in rosso praticamente la mia input */
     (document.getElementById("surname") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
     (document.getElementById("hiddenSurname") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
     (document.getElementById("hiddenSurname") as HTMLInputElement).innerHTML = "Surname must be composed al least by 5 character"; 
     (document.getElementById("labelSurname") as HTMLInputElement).style.visibility = "hidden"; 
     this.correctFormatData = false;
   }
   if(this.validateLenght(username) == false)
   {
     /* devo andare a settare in rosso praticamente la mia input */
     (document.getElementById("username") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
     (document.getElementById("hiddenUsername") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
     (document.getElementById("hiddenUsername") as HTMLInputElement).innerHTML = "Username must be composed al least by 5 character"; 
     (document.getElementById("labelUsername") as HTMLInputElement).style.visibility = "hidden"; 
     this.correctFormatData = false;
   }
    if(this.validateLenght(name) == false)
    {
      /* devo andare a settare in rosso praticamente la mia input */
      (document.getElementById("name") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
      (document.getElementById("hiddenName") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
      (document.getElementById("hiddenName") as HTMLInputElement).innerHTML = "Name must be composed al least by 5 character"; 
      (document.getElementById("labelName") as HTMLInputElement).style.visibility = "hidden"; 
      this.correctFormatData = false;
    }
    if(this.validateEmail(email) == false)
    {
      (document.getElementById("email") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
      (document.getElementById("hiddenEmail") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
      (document.getElementById("hiddenEmail") as HTMLInputElement).innerHTML = "Insert a valid email"; 
      (document.getElementById("labelEmail") as HTMLInputElement).style.visibility = "hidden"; 
      this.correctFormatData = false;
    }
    if(this.validateIVA(iva) == false)
    {
      (document.getElementById("iva") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
      (document.getElementById("hiddenIVA") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
      (document.getElementById("hiddenIVA") as HTMLInputElement).innerHTML = "It must be composed by 11 numbers"; 
      (document.getElementById("labelIVA") as HTMLInputElement).style.visibility = "hidden"; 
      this.correctFormatData = false;
    }
    if(this.validatePassword(password) == false)
    {
      (document.getElementById("password") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
      (document.getElementById("hiddenPassword") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
      (document.getElementById("hiddenPassword") as HTMLInputElement).innerHTML = "At least 8 characters"; 
      (document.getElementById("labelPassword") as HTMLInputElement).style.visibility = "hidden"; 
      this.correctFormatData = false;
    }
    if(grecaptcha.getResponse() == "")
    {
      this.correctFormatData = false;
      (document.getElementById("hiddenRecaptcha") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
    }

    this.existsEmail(email);
    this.existsUsername(username);
    
    if(this.correctFormatData)
    {
      this.registrationService.saveCustomer(name,surname,phoneNumber,email,username,password,iva).subscribe(
        response => {
          if(response == true)
          {
            this.route.navigate(['/login']);
          }
          else 
          {
            
          }
        });
    }
  }

}
