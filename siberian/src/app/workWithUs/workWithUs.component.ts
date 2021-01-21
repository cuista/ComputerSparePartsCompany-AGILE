import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JobRequestService } from '../Services/data/jobRequest.service';

@Component({
  selector: 'app-workWithUs',
  templateUrl: './workWithUs.component.html',
  styleUrls: ['./workWithUs.component.scss']
})

export class WorkWithUsComponent implements OnInit {

  correctFormatData = true;
  type = "" as string;
  reqs = [] as any;

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
  usernames = [] as any;
  req = null as any;

  constructor(private route: Router, private jobService: JobRequestService) { }

  ngOnInit() {
    if(sessionStorage.getItem('type') != null )
    {
      this.type = sessionStorage.getItem("type") as string;
      this.getProducts(1);
    }     
  }

  async getProducts(index:number)
  {
    if(sessionStorage.getItem('type') != null)
    {
      if(sessionStorage.getItem('type') == "employee")
      {
        this.reqs = await this.jobService.getAll();
        this.calcolatePagerFinals(this.reqs);
        this.setPage(index);
      }
    }
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
    if(this.correctFormatData == true)
    {
        if(sessionStorage.getItem('type') != "customer" || sessionStorage.getItem('user') == null)
        {
          sessionStorage.setItem('job',"job");
          this.route.navigate(['/login']);
        }
        else
        {
          
          this.jobService.existsUsername(sessionStorage.getItem('user') as string).subscribe(
            (response) => {
              if(response == true)
              {
                this.successPopupNo();
              }
              else
              {
                this.jobService.save(title,position,sessionStorage.getItem('user') as string,email,date,description).subscribe(
                  responseD => {
                    if(responseD == true)
                    {
                      this.successPopup();
                      (document.getElementById("date") as HTMLDataElement).value = "gg/mm/aaaa";
                      (document.getElementById("titles") as HTMLInputElement).value = "Five year degree";
                      (document.getElementById("roles") as HTMLInputElement).value = "Shelves department";
                      (document.getElementById("email") as HTMLInputElement).value = "";
                      (document.getElementById("description") as HTMLTextAreaElement).value = "";
                    }
                  }
                );
                
              }
            }
          );
        }
    }
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

  successPopupNo(){
    (document.getElementById("alertDivNo") as HTMLElement).classList.add("show");
    (document.getElementById("alertDivNo") as HTMLElement).classList.remove("hide");
    (document.getElementById("alertDivNo") as HTMLElement).classList.add("showAlert");

    setTimeout(function(){
      (document.getElementById("alertDivNo") as HTMLElement).classList.remove("show");
      (document.getElementById("alertDivNo") as HTMLElement).classList.add("hide");},1000)
  }

  /* */
  async setPage(indexPage: number) {
    if (indexPage < 1 || indexPage > this.pager.totalPages) {
        return;
    }

      this.pager.currentPage = indexPage;
      this.calcolatePagerIndexes(indexPage);
    
      this.pagedItems = this.reqs.slice((indexPage-1)*(this.pager.pageSize),(indexPage*this.pager.pageSize));
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

  delete(username:string)
  {
    this.jobService.delete(username).subscribe(
      response =>{
        if(response == true)
        {
          this.getProducts(1);
          this.route.navigate(['/']).then(()=>{this.route.navigate(['/workWithUs'])})
        }
      }
    );
  }

}
