import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SidbarEtudiantComponent } from './sidbar-etudiant.component';

describe('SidbarEtudiantComponent', () => {
  let component: SidbarEtudiantComponent;
  let fixture: ComponentFixture<SidbarEtudiantComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SidbarEtudiantComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SidbarEtudiantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
