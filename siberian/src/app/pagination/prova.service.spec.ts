/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { ProvaService } from './prova.service';

describe('Service: Prova', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ProvaService]
    });
  });

  it('should ...', inject([ProvaService], (service: ProvaService) => {
    expect(service).toBeTruthy();
  }));
});
