/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { FaqServiceService } from './faqService.service';

describe('Service: FaqService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FaqServiceService]
    });
  });

  it('should ...', inject([FaqServiceService], (service: FaqServiceService) => {
    expect(service).toBeTruthy();
  }));
});
