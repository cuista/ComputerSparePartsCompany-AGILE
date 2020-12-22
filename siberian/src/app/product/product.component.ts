import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {

  constructor() { }

  id : string = "";
  url: string = "https://i.ebayimg.com/images/g/yYgAAOSw~X1bhwiL/s-l1600.jpg";
  name: string = "Case Shipper 3x198";
  description: string = "DESIGN STILE MINIMALISTA, PRESTAZIONI OTTIMIZZATE - NR400 dispone di pannelli frontali e superiori a mesh per ottimizzare raffreddamento e flusso d'aria interno - pannello superiore con filtro antipolvere magnetico (e filtro fisso nel pannello inferiore) PANNELLO LATERALE VETRO TEMPERATO - Le strutture sistema possono essere mostrate attraverso un pannello a paro in vetro temperato, che è discretamente fissato tramite il pannello posteriore per garantire una superficie liscia lungo il lato del chassis   SUPPORTO VENTOLA E RADIATORE - Due ventole da 120mm preinstallate pannelli anteriore e posteriore - il pannello anteriore può supportare 2 x 140mm ventole o un radiatore a 240mm. La parte superiore supporta 1 x 120/140mm ventola o un raditore 240mm.   DISPOSIZIONE STRAORDINARIA - Supporta schede madri micro-ATX e mini-ITX, dissipatori CPU fino a 166mm di altezza, schede grafiche fino a 346mm di lunghezza, e un alimentatore ATX PS2 fino a 140mm di lunghezza (325mm senza radiatore anteriore o gabbia HDD)   INTERNO SMART - Gestione cablaggio ordinato attraverso passa cavi in gomma, 22mm di spazio dietro la scheda madre per un ottima sistemazione dei cavi - gabbia HDD può essere riposizionata per un alimentatore più lungo o spazio aggiuntivo per radiatore";
  prezzo: string = "$23.00";
  availability: string = "Disponibile";

  /* dati importanti per la gestione dei bottoni */
  userType = "";

  ngOnInit() {
    this.userType = sessionStorage.getItem("type") as string;
    if(this.userType == "customer")
      (document.getElementById("addToCart") as HTMLButtonElement).setAttribute("class","h-12 bg-blue-600 w-full");
    else if(this.userType == "employee")
    {
      (document.getElementById("modify") as HTMLButtonElement).setAttribute("class","h-12 bg-blue-600 w-full");
      (document.getElementById("delete") as HTMLButtonElement).setAttribute("class","h-12 bg-blue-600 w-full");
    }  
  }

  getCurrent()
  {
    this.id = sessionStorage.getItem('p') as string;
    /* mi devo richiamare la get */
  }



}
