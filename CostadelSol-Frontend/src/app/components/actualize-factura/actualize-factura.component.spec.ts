import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualizeFacturaComponent } from './actualize-factura.component';

describe('ActualizeFacturaComponent', () => {
  let component: ActualizeFacturaComponent;
  let fixture: ComponentFixture<ActualizeFacturaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActualizeFacturaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ActualizeFacturaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
