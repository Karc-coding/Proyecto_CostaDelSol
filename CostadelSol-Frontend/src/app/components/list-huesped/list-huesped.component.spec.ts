import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListHuespedComponent } from './list-huesped.component';

describe('ListHuespedComponent', () => {
  let component: ListHuespedComponent;
  let fixture: ComponentFixture<ListHuespedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListHuespedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListHuespedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
