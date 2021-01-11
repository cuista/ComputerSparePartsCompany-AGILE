import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-PageNotFound',
  templateUrl: './PageNotFound.component.html',
  styleUrls: ['./PageNotFound.component.scss']
})
export class PageNotFoundComponent implements OnInit {

  constructor(private route:Router) { }

  ngOnInit() {
  }

  goToResult()
  {
    var value = (document.getElementById("bar") as HTMLInputElement).value;
    sessionStorage.setItem('search',value);
    this.route.navigate(['/results']);
  }

}
