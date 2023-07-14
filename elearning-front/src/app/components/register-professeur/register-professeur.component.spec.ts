import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterProfesseurComponent } from './register-professeur.component';

describe('RegisterProfesseurComponent', () => {
  let component: RegisterProfesseurComponent;
  let fixture: ComponentFixture<RegisterProfesseurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterProfesseurComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterProfesseurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
