import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-Slider',
  templateUrl: './Slider.component.html',
  styleUrls: ['./Slider.component.scss']
})
export class SliderComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    this.changeSlide();
  }

  changeSlide()
  {
  }

}
