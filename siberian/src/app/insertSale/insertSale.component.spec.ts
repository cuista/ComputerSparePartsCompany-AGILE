/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { InsertSaleComponent } from './insertSale.component';

describe('InsertSaleComponent', () => {
  let component: InsertSaleComponent;
  let fixture: ComponentFixture<InsertSaleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InsertSaleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertSaleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
