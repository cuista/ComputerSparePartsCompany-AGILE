import { Component, OnInit } from '@angular/core';
import { range } from 'rxjs';

@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.scss']
})
export class PaginationComponent implements OnInit {

  

  // array of all items to be paged
  allItems = [
    {"name":"item1"},
    {"name":"item2"},
    {"name":"item3"},
    {"name":"item4"},
    {"name":"item5"},
    {"name":"item6"},
    {"name":"item7"},
    {"name":"item8"},
    {"name":"item9"},
    {"name":"item0"},
    {"name":"item11"},
    {"name":"item12"},
    {"name":"item13"},
    {"name":"item14"},
    {"name":"item15"},
    {"name":"item16"},
    {"name":"item17"},
    {"name":"item18"},
    {"name":"item19"}
  ] as any;

  // pager object
  pager = {
    totalItems: 10, 
    currentPage: 1,
    pageSize: 2,
    totalPages: 0, 
    startPage: 1,
    endPage: 5,
    startIndex:0,
    endIndex:4,
    pages: []
  } as any;

  // paged items
  pagedItems = [
    
  ] as any;

  

  constructor() { }

  ngOnInit() {
    this.calcolatePagerFinals(this.allItems);
    this.setPage(1);
  }

  /*  */
  setPage(indexPage: number) {
  if (indexPage < 1 || indexPage > this.pager.totalPages) {
      return;
  }

    this.pager.currentPage = indexPage;
    this.calcolatePagerIndexes(indexPage);

    this.pagedItems = this.allItems.slice((indexPage-1)*(this.pager.pageSize),(indexPage*this.pager.pageSize));
  }

  /* questa va richiamata all'inizio quando carico l'array */
  calcolatePagerFinals(array: any[])
  { 
    this.pager.totalItems = array.length;
    this.pager.totalPages = Math.ceil(this.pager.totalItems/(this.pager.pageSize));
    this.pager.endPage = this.pager.totalPages;
  }
  
  calcolatePagerIndexes(current: number)
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
}
