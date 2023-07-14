import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardReunionComponent } from './dashboard-reunion.component';

describe('DashboardReunionComponent', () => {
  let component: DashboardReunionComponent;
  let fixture: ComponentFixture<DashboardReunionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DashboardReunionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardReunionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
