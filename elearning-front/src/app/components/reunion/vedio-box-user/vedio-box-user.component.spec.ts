import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VedioBoxUserComponent } from './vedio-box-user.component';

describe('VedioBoxUserComponent', () => {
  let component: VedioBoxUserComponent;
  let fixture: ComponentFixture<VedioBoxUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VedioBoxUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(VedioBoxUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
