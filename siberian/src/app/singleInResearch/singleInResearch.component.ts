import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-singleInResearch',
  templateUrl: './singleInResearch.component.html',
  styleUrls: ['./singleInResearch.component.scss']
})
export class SingleInResearchComponent implements OnInit {

  /* poi sta roba va sostituita con il ng for*/
  url: string = "https://m.media-amazon.com/images/I/71uF-tSNIqL._AC_SL1500_.jpg";
  marca: string = "Asus";
  modello: string = "ux345";
  categoria: string = "Case";
  price: string = "23,00$";
  name = this.categoria + " " + this.marca + " " + this.modello;
  constructor() {

   }

  ngOnInit() {
  }

}
