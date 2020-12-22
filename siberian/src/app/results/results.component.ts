import { Component, OnInit } from '@angular/core';
import { ProductsService } from '../Services/data/products.service';

@Component({
  selector: 'app-results',
  templateUrl: './results.component.html',
  styleUrls: ['./results.component.scss']
})
export class ResultsComponent implements OnInit {

  public products = [] as any;

  constructor(
    private productService: ProductsService
  ) { }

  ngOnInit() {
    this.getProducts();
  }

  setCurrent(id: string)
  {
    sessionStorage.setItem('p', id);
  }

  getProducts(): void
  {
    this.productService.getProducts()
    .subscribe(data => this.products = data);
  }

}
