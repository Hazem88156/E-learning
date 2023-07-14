import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PassExamenComponent } from './pass-examen.component';

describe('PassExamenComponent', () => {
  let component: PassExamenComponent;
  let fixture: ComponentFixture<PassExamenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PassExamenComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PassExamenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
