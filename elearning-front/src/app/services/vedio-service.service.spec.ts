import { TestBed } from '@angular/core/testing';

import { VedioServiceService } from './vedio-service.service';

describe('VedioServiceService', () => {
  let service: VedioServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(VedioServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
