import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateMatieresComponent } from './update-matieres.component';

describe('UpdateMatieresComponent', () => {
  let component: UpdateMatieresComponent;
  let fixture: ComponentFixture<UpdateMatieresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateMatieresComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateMatieresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
