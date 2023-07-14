import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfileProfesseurComponent } from './profile-professeur.component';

describe('ProfileProfesseurComponent', () => {
  let component: ProfileProfesseurComponent;
  let fixture: ComponentFixture<ProfileProfesseurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfileProfesseurComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfileProfesseurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
