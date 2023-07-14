import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListVedioComponent } from './list-vedio.component';

describe('ListVedioComponent', () => {
  let component: ListVedioComponent;
  let fixture: ComponentFixture<ListVedioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListVedioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListVedioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
