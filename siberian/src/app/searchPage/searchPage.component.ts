import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-searchPage',
  templateUrl: './searchPage.component.html',
  styleUrls: ['./searchPage.component.css']
})
export class SearchPageComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  f()
  {
    var countries = [
      {name: 'USA'},
      {name: 'India'},
      {name: 'Argentina'},
      {name: 'Armenia'}
    ];

    var searchInput = document.getElementById("bar") as HTMLInputElement;
    var suggestionsPanel = document.getElementById("suggerimenti") as HTMLDivElement;
    var input = searchInput.value;
    input = input.toLowerCase() as string;
    //il pannello del suggestion deve avere contenuto vuoto
    suggestionsPanel.innerHTML = '';
    /* filtro il mio array */
    const suggestions = countries.filter(stato => stato.name.toLowerCase().includes(input));
    // console.log(JSON.stringify(suggestions));
    suggestions.forEach(function(suggested) {
      const div = document.createElement('div');
      div.innerHTML = suggested.name;
      suggestionsPanel.appendChild(div);
    });
    if(input == "")
    {
      suggestionsPanel.innerHTML = "";
    }
  }

}
