import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddVedioComponent } from './add-vedio.component';

describe('AddVedioComponent', () => {
  let component: AddVedioComponent;
  let fixture: ComponentFixture<AddVedioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddVedioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddVedioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
