import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FaqServiceService } from '../Services/data/faqService.service';

@Component({
  selector: 'app-faq',
  templateUrl: './faq.component.html',
  styleUrls: ['./faq.component.scss']
})
export class FaqComponent implements OnInit {

  user = "customer" as string;
  correctFormatData = true;
  faqs = [] as any;
  constructor(
    private faqService: FaqServiceService,
    private route: Router
  ) { }

  ngOnInit() {
    if(sessionStorage.getItem('type') != null)
      this.user = sessionStorage.getItem('type') as string;

    this.faqService.getAll().subscribe(
      data => {
        this.faqs = data;
        // alert(JSON.stringify(this.faqs));
      }
    );
  }

  validateDescription(description:string)
  {
    return(description!="");
  }

  validateTitle(title:string)
  {
    return (title!="");
  }

  setBorder(id: string,idInfo:string,idLabel:string)
  {
    (document.getElementById(id) as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 border border-gray-400 dark:border-gray-700 text-gray-800 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
    (document.getElementById(idInfo)as HTMLInputElement).setAttribute("class","text-sm text-gray-500");
    (document.getElementById(idLabel)as HTMLInputElement).style.visibility = "visible";
  }

  

  setOriginalDescription()
  {
    (document.getElementById("hiddenDescription") as HTMLInputElement).setAttribute("class","text-sm text-gray-500");
  }

  saveNew()
  {
    var title = (document.getElementById("title") as HTMLInputElement).value;
    var description = (document.getElementById("description") as HTMLTextAreaElement).value;
    this.correctFormatData = true;
    if(this.validateDescription(description) == false)
    {
      this.correctFormatData = false;
      (document.getElementById("hiddenDescription") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
    }
    if(this.validateTitle(title) == false)
    {
      (document.getElementById("title") as HTMLInputElement).setAttribute("class","form-input w-full h-14 mt-2 py-3 px-3 bg-white dark:bg-gray-800 border-gray-400 dark:border-gray-700 text-gray-800 border-2 border-red-400 font-semibold focus:ring-2 focus:ring-blue-600 focus:outline-none placeholder-gray-500 placeholder-opacity-50");
      (document.getElementById("hiddenTitle") as HTMLInputElement).setAttribute("class","text-sm text-red-500");
      (document.getElementById("hiddenTitle") as HTMLInputElement).innerHTML = "Insert title"; 
      (document.getElementById("labelTitle") as HTMLInputElement).style.visibility = "hidden"; 
    }
    if(this.correctFormatData)
    {
      /*richiamo il service*/
      this.faqService.save(title,description).subscribe(
        response => {
          if(response)
          {
            this.cartPopup();
            this.faqService.getAll().subscribe(
              data => {
                this.faqs = data;
                // alert(JSON.stringify(this.faqs));
              }
            );
          }
        }
      );
      
      (document.getElementById("title") as HTMLInputElement).value = "";
      (document.getElementById("description") as HTMLTextAreaElement).value = "";
    }
  }

  cartPopup(){
    (document.getElementById("alertDivOk") as HTMLElement).classList.add("show");
    (document.getElementById("alertDivOk") as HTMLElement).classList.remove("hide");
    (document.getElementById("alertDivOk") as HTMLElement).classList.add("showAlert");

    setTimeout(function(){
      (document.getElementById("alertDivOk") as HTMLElement).classList.remove("show");
      (document.getElementById("alertDivOk") as HTMLElement).classList.add("hide");},1000)
  }

  delete(title:string)
  {
    this.faqService.delete(title).subscribe(
      response =>{
        if(response)
        {
          this.faqService.getAll().subscribe(
            data => {
              this.faqs = data;
              // alert(JSON.stringify(data));
            }
          );
        }
      }
    );
  }

  

}
