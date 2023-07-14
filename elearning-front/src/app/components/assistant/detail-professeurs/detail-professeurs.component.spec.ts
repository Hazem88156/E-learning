import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailProfesseursComponent } from './detail-professeurs.component';

describe('DetailProfesseursComponent', () => {
  let component: DetailProfesseursComponent;
  let fixture: ComponentFixture<DetailProfesseursComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailProfesseursComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailProfesseursComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
