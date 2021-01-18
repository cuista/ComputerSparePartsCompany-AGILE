import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

declare var grecaptcha: any; 

@Component({
  selector: 'app-sendMessage',
  templateUrl: './sendMessage.component.html',
  styleUrls: ['./sendMessage.component.css']
})
export class SendMessageComponent implements OnInit {

  recaptchaKeySite = "6Leq5REaAAAAAPSUOgTK-Ylj73t9iv3w5F02X4mv";
  recaptchaKeySecret = "6Leq5REaAAAAAD6qCQGHvCylsxUqaTmvWMLxNkBb";
  correctFormatData = true;

  constructor(
    private route: Router
  ) { }

  ngOnInit() {
    grecaptcha.render('recaptcha', {'sitekey' : '6Ldk0RYaAAAAAPkmDFrs4UgGpfGu3rlDPegrwBve'});
  }

  validateEmail(email: string)
  {
    let re = new RegExp("[A-z0-9\.\+_-]+@[A-z0-9\._-]+\.[A-z]{2,6}", "g");
    return(re.test(email) == true);  
  }

  validateDescription(description:string)
  {
    return(description!="");
  }

  setBorder(id: string,idInfo:string,idLabel:string)
  {
    (document.getElementById(id) as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 border border-gray-400 dark:border-gray-700 text-gray-800 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
    (document.getElementById(idInfo)as HTMLInputElement).setAttribute("class","text-sm text-gray-500");
    (document.getElementById(idLabel)as HTMLInputElement).style.visibility = "visible";
  }

  sendReport()
  {
    var problem = (document.getElementById("problems") as HTMLInputElement).value;
    var email = (document.getElementById("email") as HTMLInputElement).value;
    var description = (document.getElementById("description") as HTMLTextAreaElement).value;
    this.correctFormatData = true;
    if(this.validateDescription(description) == false)
    {
      this.correctFormatData = false;
      (document.getElementById("hiddenDescription") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
    }
    if(this.validateEmail(email) == false)
    {
      (document.getElementById("email") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
      (document.getElementById("hiddenEmail") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
      (document.getElementById("hiddenEmail") as HTMLInputElement).innerHTML = "Insert your email"; 
      (document.getElementById("labelEmail") as HTMLInputElement).style.visibility = "hidden"; 
      this.correctFormatData = false;
    }
    if(grecaptcha.getResponse() == "")
    {
      this.correctFormatData = false;
      (document.getElementById("hiddenRecaptcha") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
    }
    if(this.correctFormatData == true)
    {
        (document.getElementById("email") as HTMLInputElement).value = "";
        (document.getElementById("description") as HTMLInputElement).value = "";
        this.successPopup();
    }
  }

  setRecOriginal()
  {
    (document.getElementById("hiddenRecaptcha") as HTMLInputElement).setAttribute("class","text-sm text-gray-500");
  }

  setOriginalDescription()
  {
    (document.getElementById("hiddenDescription") as HTMLInputElement).setAttribute("class","text-sm text-gray-500");
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
