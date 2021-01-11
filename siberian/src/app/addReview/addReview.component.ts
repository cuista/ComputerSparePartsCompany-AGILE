import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ReviewService } from '../Services/data/review.service';

@Component({
  selector: 'app-addReview',
  templateUrl: './addReview.component.html',
  styleUrls: ['./addReview.component.scss']
})
export class AddReviewComponent implements OnInit {

  constructor(
    private route:  Router,
    private reviewService: ReviewService
  ) { }

  correctFormData = true;
  rate = 0;
  errorRate = false;
  

  ngOnInit() {
    if(sessionStorage.getItem('user') == null || sessionStorage.getItem('brand') == null || sessionStorage.getItem('model') == null)
    {
      this.route.navigate(['/404']);
    }
  }

  setBorder(id: string,idInfo:string,idLabel:string)
  {
    (document.getElementById(id) as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 border border-gray-400 dark:border-gray-700 text-gray-800 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
    (document.getElementById(idInfo)as HTMLInputElement).setAttribute("class","text-sm text-gray-500");
    (document.getElementById(idInfo)as HTMLInputElement).innerHTML = "Visible on product page"; 
    (document.getElementById(idLabel)as HTMLInputElement).style.visibility = "visible";
  }

  setOriginalDescription()
  {
    (document.getElementById("description") as HTMLTextAreaElement).setAttribute("class","form-input resize-y w-full mt-2 py-3 px-3 bg-white dark:bg-gray-800 border border-gray-400 dark:border-gray-700 text-gray-800 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
    (document.getElementById("description") as HTMLTextAreaElement).setAttribute("rows","6");
    (document.getElementById("hiddenDescription") as HTMLDivElement).setAttribute("class","text-sm text-gray-800");
    (document.getElementById("hiddenDescription") as HTMLDivElement).innerHTML = 'Pubblicato sulla tua scheda'; 
  }

  setRate(id:string)
  {
    this.errorRate = false;
    if(id == "star1")
    {
      (document.getElementById("star1") as HTMLDivElement).style.color = "#daa520";
      (document.getElementById("star2") as HTMLDivElement).style.color = "gray";
      (document.getElementById("star3") as HTMLDivElement).style.color = "gray";
      (document.getElementById("star4") as HTMLDivElement).style.color = "gray";
      (document.getElementById("star5") as HTMLDivElement).style.color = "gray";
      this.rate = 1;

    }
    else if(id == "star2")
    {
      (document.getElementById("star1") as HTMLDivElement).style.color = "#daa520";
      (document.getElementById("star2") as HTMLDivElement).style.color = "#daa520";
      (document.getElementById("star3") as HTMLDivElement).style.color = "gray";
      (document.getElementById("star4") as HTMLDivElement).style.color = "gray";
      (document.getElementById("star5") as HTMLDivElement).style.color = "gray";
      this.rate = 2;

    }
    else if(id == "star3")
    {
      (document.getElementById("star1") as HTMLDivElement).style.color = "#daa520";
      (document.getElementById("star2") as HTMLDivElement).style.color = "#daa520";
      (document.getElementById("star3") as HTMLDivElement).style.color = "#daa520";
      (document.getElementById("star4") as HTMLDivElement).style.color = "gray";
      (document.getElementById("star5") as HTMLDivElement).style.color = "gray";
      this.rate = 3;

    }
    else if(id == "star4")
    {
      (document.getElementById("star1") as HTMLDivElement).style.color = "#daa520";
      (document.getElementById("star2") as HTMLDivElement).style.color = "#daa520";
      (document.getElementById("star3") as HTMLDivElement).style.color = "#daa520";
      (document.getElementById("star4") as HTMLDivElement).style.color = "#daa520";
      (document.getElementById("star5") as HTMLDivElement).style.color = "gray";
      this.rate = 4;
    }
    else if(id == "star5")
    {
      (document.getElementById("star1") as HTMLDivElement).style.color = "#daa520";
      (document.getElementById("star2") as HTMLDivElement).style.color = "#daa520";
      (document.getElementById("star3") as HTMLDivElement).style.color = "#daa520";
      (document.getElementById("star4") as HTMLDivElement).style.color = "#daa520";
      (document.getElementById("star5") as HTMLDivElement).style.color = "#daa520";
      this.rate = 5;
    }
  }

  validateTitle(title: string)
  {
    let re = new RegExp("^[A-Za-z0-9 ]{4,100}$", "g");
    return(re.test(title) == true);
  }

  validateText(text: string)
  {
    let re = new RegExp("^[A-Za-z0-9 ]{4,1000}$", "g");
    return(re.test(text) == true);
  }

  validateRate(rate: string)
  {
    if(rate == "0")
      return false;
    return true;
  }

  addReview()
  {
    this.correctFormData = true;
    let title = (document.getElementById("title") as HTMLInputElement).value;
    let text = (document.getElementById("description") as HTMLTextAreaElement).value;
    if(title == "")
    {
      this.correctFormData = false;
      (document.getElementById("title") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
      (document.getElementById("hiddenTitle") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
      (document.getElementById("hiddenTitle") as HTMLInputElement).innerHTML = "It can't be empty. Min 4 characters"; 
      (document.getElementById("labelTitle") as HTMLInputElement).style.visibility = "hidden";  
    }
    else if(this.validateTitle(title) == false)
    {
      this.correctFormData = false;
     (document.getElementById("title") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
     (document.getElementById("hiddenTitle") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
     (document.getElementById("hiddenTitle") as HTMLInputElement).innerHTML = "You can insert only letters,numbers and spaces"; 
     (document.getElementById("labelTitle") as HTMLInputElement).style.visibility = "hidden"; 
    }
    if(text == "")
    {
      this.correctFormData = false;
      (document.getElementById("description") as HTMLInputElement).setAttribute("class","form-input resize-y w-full mt-2 py-1 px-3 bg-white dark:bg-gray-800 border border-gray-400 dark:border-gray-700 text-gray-800 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
      (document.getElementById("hiddenDescription") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
      (document.getElementById("hiddenDescription") as HTMLInputElement).innerHTML = "It can't be empty. Min 4 characters"; 
      (document.getElementById("labelDescription") as HTMLInputElement).style.visibility = "hidden";  
    }
    else if(this.validateText(text) == false)
    {
      this.correctFormData = false;
      (document.getElementById("description") as HTMLInputElement).setAttribute("class","form-input resize-y w-full mt-2 py-1 px-3 bg-white dark:bg-gray-800 border border-gray-400 dark:border-gray-700 text-gray-800 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
      (document.getElementById("hiddenDescription") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
      (document.getElementById("hiddenDescription") as HTMLInputElement).innerHTML = "You can insert only letters,numbers and spaces"; 
      (document.getElementById("labelDescription") as HTMLInputElement).style.visibility = "hidden";  
    }
    if(this.correctFormData == true && this.validateRate(""+this.rate) == false)
    {
      this.correctFormData = false;
      this.errorRate = true;
    }
    
    if(this.correctFormData == true)
    {
      this.reviewService.addReview(sessionStorage.getItem('user')as string,""+this.rate,sessionStorage.getItem('model')as string,sessionStorage.getItem('brand') as string,title,text).subscribe(
        response =>{
          if(response == true)
          {
            this.route.navigate(['/product']);
          }
          else
          {
            this.reviewAlreadyPresentPopup();
          }
        }
      );
    }
  }

  reviewAlreadyPresentPopup(){
    (document.getElementById("alertDivOk") as HTMLElement).classList.add("show");
    (document.getElementById("alertDivOk") as HTMLElement).classList.remove("hide");
    (document.getElementById("alertDivOk") as HTMLElement).classList.add("showAlert");

    setTimeout(function(){
      (document.getElementById("alertDivOk") as HTMLElement).classList.remove("show");
      (document.getElementById("alertDivOk") as HTMLElement).classList.add("hide");},1000)
  }

}
