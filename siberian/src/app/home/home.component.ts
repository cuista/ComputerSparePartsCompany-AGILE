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
  user = "";
  
  constructor(
    private route: Router,
    private homeService: HomeServiceService
    ) { }

  ngOnInit() {
    if(sessionStorage.getItem('user') != null)
    {
      this.user = sessionStorage.getItem('user') as string;
    }
  }

  getQualcosa(): void
  {
    this.homeService.getGreeting().subscribe(
      response => {
        this.proof = response.toString();
      }
    );
  }

  goToResult()
  {
    var value = (document.getElementById("bar") as HTMLInputElement).value;
    sessionStorage.setItem('search',value);
    this.route.navigate(['/results']);
  }

  getCategory(category:string)
  {
    sessionStorage.setItem('category',category);
  }

}
