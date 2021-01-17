/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { LoginEmployeeService } from './loginEmployee.service';

describe('Service: LoginEmployee', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LoginEmployeeService]
    });
  });

  it('should ...', inject([LoginEmployeeService], (service: LoginEmployeeService) => {
    expect(service).toBeTruthy();
  }));
});
