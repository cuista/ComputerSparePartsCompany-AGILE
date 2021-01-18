/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { JobRequestService } from './jobRequest.service';

describe('Service: JobRequest', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [JobRequestService]
    });
  });

  it('should ...', inject([JobRequestService], (service: JobRequestService) => {
    expect(service).toBeTruthy();
  }));
});
