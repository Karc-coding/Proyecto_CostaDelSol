import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualizeHabitacionComponent } from './actualize-habitacion.component';

describe('ActualizeHabitacionComponent', () => {
  let component: ActualizeHabitacionComponent;
  let fixture: ComponentFixture<ActualizeHabitacionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActualizeHabitacionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ActualizeHabitacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
