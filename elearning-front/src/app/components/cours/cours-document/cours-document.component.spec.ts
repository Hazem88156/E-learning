import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoursDocumentComponent } from './cours-document.component';

describe('CoursDocumentComponent', () => {
  let component: CoursDocumentComponent;
  let fixture: ComponentFixture<CoursDocumentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CoursDocumentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CoursDocumentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
