import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualizeHuespedComponent } from './actualize-huesped.component';

describe('ActualizeHuespedComponent', () => {
  let component: ActualizeHuespedComponent;
  let fixture: ComponentFixture<ActualizeHuespedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActualizeHuespedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ActualizeHuespedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
