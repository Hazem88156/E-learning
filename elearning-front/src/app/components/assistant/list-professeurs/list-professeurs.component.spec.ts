import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListProfesseursComponent } from './list-professeurs.component';

describe('ListProfesseursComponent', () => {
  let component: ListProfesseursComponent;
  let fixture: ComponentFixture<ListProfesseursComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListProfesseursComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListProfesseursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
