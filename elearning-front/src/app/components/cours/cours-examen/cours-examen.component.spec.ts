import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoursExamenComponent } from './cours-examen.component';

describe('CoursExamenComponent', () => {
  let component: CoursExamenComponent;
  let fixture: ComponentFixture<CoursExamenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CoursExamenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CoursExamenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
