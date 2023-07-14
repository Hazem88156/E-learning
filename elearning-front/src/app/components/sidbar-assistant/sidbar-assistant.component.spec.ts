import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SidbarAssistantComponent } from './sidbar-assistant.component';

describe('SidbarAssistantComponent', () => {
  let component: SidbarAssistantComponent;
  let fixture: ComponentFixture<SidbarAssistantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SidbarAssistantComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SidbarAssistantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
