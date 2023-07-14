import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailVedioComponent } from './detail-vedio.component';

describe('DetailVedioComponent', () => {
  let component: DetailVedioComponent;
  let fixture: ComponentFixture<DetailVedioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailVedioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailVedioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
