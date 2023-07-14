import { TestBed } from '@angular/core/testing';

import { MuteCamMicService } from './mute-cam-mic.service';

describe('MuteCamMicService', () => {
  let service: MuteCamMicService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MuteCamMicService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
