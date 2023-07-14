import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListEtudaintComponent } from './list-etudaint.component';

describe('ListEtudaintComponent', () => {
  let component: ListEtudaintComponent;
  let fixture: ComponentFixture<ListEtudaintComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListEtudaintComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListEtudaintComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
