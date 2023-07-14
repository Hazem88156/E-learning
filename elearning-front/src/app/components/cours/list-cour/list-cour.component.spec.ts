import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListCourComponent } from './list-cour.component';

describe('ListCourComponent', () => {
  let component: ListCourComponent;
  let fixture: ComponentFixture<ListCourComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListCourComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListCourComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
