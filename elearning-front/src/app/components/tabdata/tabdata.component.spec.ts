import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TabdataComponent } from './tabdata.component';

describe('TabdataComponent', () => {
  let component: TabdataComponent;
  let fixture: ComponentFixture<TabdataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TabdataComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TabdataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
