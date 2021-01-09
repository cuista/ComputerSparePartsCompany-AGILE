import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-palladio',
  templateUrl: './palladio.component.html',
  styleUrls: ['./palladio.component.scss']
})
export class PalladioComponent implements OnInit {

  constructor() { }

  ngOnInit() {
      this.showSlides();
  }
  
  slideIndex = 0 as number;
  
  showSlides() {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    for (i = 0; i < slides.length; i++) {
      (slides[i] as HTMLDivElement).style.display = "none";  
    }
    this.slideIndex++;
    if (this.slideIndex > slides.length) {this.slideIndex = 1}    
    (slides[this.slideIndex-1] as HTMLDivElement).style.display = "block";  
    setTimeout(this.showSlides.bind(this), 10000); // Change image every 2 seconds
  }

}
