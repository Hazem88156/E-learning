import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoursDocumentVedioComponent } from './cours-document-vedio.component';

describe('CoursDocumentVedioComponent', () => {
  let component: CoursDocumentVedioComponent;
  let fixture: ComponentFixture<CoursDocumentVedioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CoursDocumentVedioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CoursDocumentVedioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
