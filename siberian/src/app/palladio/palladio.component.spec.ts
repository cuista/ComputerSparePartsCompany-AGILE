/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { PalladioComponent } from './palladio.component';

describe('PalladioComponent', () => {
  let component: PalladioComponent;
  let fixture: ComponentFixture<PalladioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PalladioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PalladioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
