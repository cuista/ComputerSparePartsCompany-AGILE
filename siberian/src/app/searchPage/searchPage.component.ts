import { Component, OnInit } from '@angular/core';
import { ProductsService } from '../Services/data/products.service';

@Component({
  selector: 'app-searchPage',
  templateUrl: './searchPage.component.html',
  styleUrls: ['./searchPage.component.css']
})
export class SearchPageComponent implements OnInit {

  constructor(
    private productService: ProductsService
  ) { }

  ngOnInit() {
  }

  array = [] as any;

  async f()
  {
    var stringa = (document.getElementById("bar") as HTMLInputElement).value as string;
    this.array = await this.productService.getSearchProducts(stringa);
    alert(JSON.stringify(this.array))
        
  }
}
