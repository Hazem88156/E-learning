import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HeaderAssistantComponent } from './header-assistant.component';

describe('HeaderAssistantComponent', () => {
  let component: HeaderAssistantComponent;
  let fixture: ComponentFixture<HeaderAssistantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HeaderAssistantComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HeaderAssistantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
