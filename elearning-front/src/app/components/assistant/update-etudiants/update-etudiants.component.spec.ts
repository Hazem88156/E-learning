import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateEtudiantsComponent } from './update-etudiants.component';

describe('UpdateEtudiantsComponent', () => {
  let component: UpdateEtudiantsComponent;
  let fixture: ComponentFixture<UpdateEtudiantsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateEtudiantsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateEtudiantsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
