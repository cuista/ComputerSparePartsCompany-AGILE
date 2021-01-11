import { Component, OnInit } from '@angular/core';
import { ProductsService } from '../Services/data/products.service';

@Component({
  selector: 'app-results',
  templateUrl: './results.component.html',
  styleUrls: ['./results.component.scss']
})
export class ResultsComponent implements OnInit {

  products = [] as any;

  // pager object
  pager = {
    totalItems: 0, 
    currentPage: 1,
    pageSize: 9, 
    totalPages: 1, 
    startPage: 1,
    endPage: 5,
    startIndex:0,
    endIndex:4,
    pages: []
  } as any;

  // paged items
  pagedItems = [] as any;

  //brands
  brands = [] as any;

  constructor(
    private productService: ProductsService
  ) { }

  ngOnInit() {
    this.getProducts(1);
    this.getBrands();
  }

  async submitFilter()
  {
    var category = (document.getElementById("categories") as HTMLSelectElement).value as any;
    var brand = (document.getElementById("brands") as HTMLSelectElement).value as any; 
    var price = (document.getElementById("prices") as HTMLSelectElement).value as any;
    var min = "0";
    var max = "1000000";
    // alert(category + " " + brand + " " + price);
    if(category == "All category")
    {
      category = null ;
    }
    if(brand == "All brands")
    {
      brand = null;
    }
    if(price == "Any price")
    {
      price = null;
    }
    else if(price == "0-50 $")
    {
      min = "0"; 
      max = "50";
    }
    else if(price == "50-100 $")
    {
      min = "50";
      max = "100";
    }
    else if(price == "100-200 $")
    {
      min = "100";
      max = "200";
    }
    else if(price == "200-500 $")
    {
      min = "200";
      max = "500";
    }
    else if(price == "500 $ or more")
    {
      min = "500";
      max = "1000000";
    }
    // alert(category + " " + brand + " " + min + " " + max);
    this.products = await this.productService.getProductByFilters(category,brand,min,max);
    // alert(JSON.stringify(this.products));
    this.calcolatePagerFinals(this.products);
    this.setPage(1);
  }

  getBrands()
  {
    this.brands = this.productService.getBrands().subscribe((data) => this.brands = data );
  }

  getBrandsByCategory()
  {
    var category = (document.getElementById("categories") as HTMLSelectElement).value as string;
    if(category == "All category")
    {
      this.getBrands();
    }
    else
      this.brands = this.productService.getBrandsByCategory(category).subscribe((data) => this.brands = data );
  }

  loadSession(brand:any,model:any)
  {
    sessionStorage.setItem('brand', brand);
    sessionStorage.setItem('model', model);
  }
  
  async getProducts(index:number)
  {
    if(sessionStorage.getItem('category')!=null)
    {
      (document.getElementById("categories") as HTMLSelectElement).value = sessionStorage.getItem('category') as string;
    }
    sessionStorage.removeItem('category');
    var category = (document.getElementById("categories") as HTMLSelectElement).value as any;
    var brand = (document.getElementById("brands") as HTMLSelectElement).value as any; 
    var price = (document.getElementById("prices") as HTMLSelectElement).value as any;
    var min = "0";
    var max = "1000000";
    // alert(category + " " + brand + " " + price);
    if(category == "All category")
    {
      category = null ;
    }
    if(brand == "All brands")
    {
      brand = null;
    }
    if(price == "Any price")
    {
      price = null;
    }
    else if(price == "0-50 $")
    {
      min = "0"; 
      max = "50";
    }
    else if(price == "50-100 $")
    {
      min = "50";
      max = "100";
    }
    else if(price == "100-200 $")
    {
      min = "100";
      max = "200";
    }
    else if(price == "200-500 $")
    {
      min = "200";
      max = "500";
    }
    else if(price == "500 $ or more")
    {
      min = "500";
      max = "1000000";
    }
    // alert(category + " " + brand + " " + min + " " + max);
    // alert(category);
    // this.products = await this.productService.getProductByFilters(category,brand,min,max);
    // alert(JSON.stringify(this.products));
    if(sessionStorage.getItem('search')!=null)
      this.products = await this.productService.getSearchProducts(sessionStorage.getItem('search') as string);
    else
      this.products = await this.productService.getProductByFilters(category,brand,min,max);
    sessionStorage.removeItem('search');
    this.calcolatePagerFinals(this.products);
    this.setPage(index);
  }

  async setPage(indexPage: number) {
    if (indexPage < 1 || indexPage > this.pager.totalPages) {
        return;
    }

      this.pager.currentPage = indexPage;
      this.calcolatePagerIndexes(indexPage);
    
      this.pagedItems = this.products.slice((indexPage-1)*(this.pager.pageSize),(indexPage*this.pager.pageSize));
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

}
