import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HomeServiceService } from '../Services/data/homeService.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  proof = "ciao";
  
  constructor(
    private route: Router,
    private homeService: HomeServiceService
    ) { }

  ngOnInit() {
  }

  getQualcosa(): void
  {
    this.homeService.getGreeting().subscribe(
      response => {
        this.proof = response.toString();
      }
    );
  }

}
