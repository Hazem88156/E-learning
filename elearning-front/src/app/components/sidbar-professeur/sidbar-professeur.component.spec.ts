import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SidbarProfesseurComponent } from './sidbar-professeur.component';

describe('SidbarProfesseurComponent', () => {
  let component: SidbarProfesseurComponent;
  let fixture: ComponentFixture<SidbarProfesseurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SidbarProfesseurComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SidbarProfesseurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
