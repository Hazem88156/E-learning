import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardProfesseurComponent } from './dashboard-professeur.component';

describe('DashboardProfesseurComponent', () => {
  let component: DashboardProfesseurComponent;
  let fixture: ComponentFixture<DashboardProfesseurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DashboardProfesseurComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardProfesseurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
