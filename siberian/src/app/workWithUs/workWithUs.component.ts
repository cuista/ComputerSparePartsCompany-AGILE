import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JobRequestService } from '../Services/data/jobRequest.service';
declare var grecaptcha: any; 
@Component({
  selector: 'app-workWithUs',
  templateUrl: './workWithUs.component.html',
  styleUrls: ['./workWithUs.component.scss']
})

export class WorkWithUsComponent implements OnInit {
  recaptchaKeySite = "6Leq5REaAAAAAPSUOgTK-Ylj73t9iv3w5F02X4mv";
  recaptchaKeySecret = "6Leq5REaAAAAAD6qCQGHvCylsxUqaTmvWMLxNkBb";
  correctFormatData = true;
  constructor(private route: Router, private jobService: JobRequestService) { }

  ngOnInit() {
    grecaptcha.render('recaptcha', {'sitekey' : '6Ldk0RYaAAAAAPkmDFrs4UgGpfGu3rlDPegrwBve'});
  }

  validateEmail(email: string)
  {
    let re = new RegExp("[A-z0-9\.\+_-]+@[A-z0-9\._-]+\.[A-z]{2,6}", "g");
    return(re.test(email) == true);  
  }

  validateDate(date:string)
  {
    if(date == "")
      return false;
    return true;
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
    var date = (document.getElementById("date") as HTMLDataElement).value;
    var title = (document.getElementById("titles") as HTMLInputElement).value;
    var position = (document.getElementById("roles") as HTMLInputElement).value;
    var email = (document.getElementById("email") as HTMLInputElement).value;
    var description = (document.getElementById("description") as HTMLTextAreaElement).value;
    this.correctFormatData = true;
    if(this.validateDescription(description) == false)
    {
      this.correctFormatData = false;
      (document.getElementById("hiddenDescription") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
    }
    if(this.validateDate(date) == false)
    {
      this.correctFormatData = false;
     (document.getElementById("date") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
     (document.getElementById("hiddenDate") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
     (document.getElementById("hiddenDate") as HTMLInputElement).innerHTML = "Insert date"; 
     (document.getElementById("labelDate") as HTMLInputElement).style.visibility = "hidden"; 
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
        if(sessionStorage.getItem('type')!= "customer" ||sessionStorage.getItem('user') == null)
        {
          this.route.navigate(['/login']);
        }
        else
        {
          (document.getElementById("date") as HTMLDataElement).value = "gg/mm/aaaa";
          (document.getElementById("titles") as HTMLInputElement).value = "Five year degree";
          (document.getElementById("roles") as HTMLInputElement).value = "Shelves department";
          (document.getElementById("email") as HTMLInputElement).value = "";
          (document.getElementById("description") as HTMLTextAreaElement).value = "";
          (document.getElementById("hiddenRecaptcha") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
          this.successPopup();
          this.jobService.getByUsername(sessionStorage.getItem('user') as string).subscribe(
            data =>{
              
            }
          );
        }
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
