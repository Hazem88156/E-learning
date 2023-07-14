import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateProfesseursComponent } from './update-professeurs.component';

describe('UpdateProfesseursComponent', () => {
  let component: UpdateProfesseursComponent;
  let fixture: ComponentFixture<UpdateProfesseursComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateProfesseursComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateProfesseursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
