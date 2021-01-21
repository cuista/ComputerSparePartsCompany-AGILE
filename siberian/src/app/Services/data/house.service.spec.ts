/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { HouseService } from './house.service';

describe('Service: House', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [HouseService]
    });
  });

  it('should ...', inject([HouseService], (service: HouseService) => {
    expect(service).toBeTruthy();
  }));
});
