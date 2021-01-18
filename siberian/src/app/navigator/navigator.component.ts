import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navigator',
  templateUrl: './navigator.component.html',
  styleUrls: ['./navigator.component.scss']
})
export class NavigatorComponent implements OnInit {

  constructor(
    private route: Router
  ) { }

  ngOnInit() {
  }

  goToMap()
  {
    this.route.navigate(['/map']);
  }

  gotoFaq()
  {
    this.route.navigate(['/faq']);
  }

  goToOrderModule()
  {
    this.route.navigate(['/addOrder']);
  }

}
