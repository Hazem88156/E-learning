import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateClassesComponent } from './update-classes.component';

describe('UpdateClassesComponent', () => {
  let component: UpdateClassesComponent;
  let fixture: ComponentFixture<UpdateClassesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateClassesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateClassesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
