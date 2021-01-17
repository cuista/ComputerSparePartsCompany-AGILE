/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { PurchaseNoticeService } from './purchaseNotice.service';

describe('Service: PurchaseNotice', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PurchaseNoticeService]
    });
  });

  it('should ...', inject([PurchaseNoticeService], (service: PurchaseNoticeService) => {
    expect(service).toBeTruthy();
  }));
});
