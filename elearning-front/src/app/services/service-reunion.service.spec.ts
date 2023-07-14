import { TestBed } from '@angular/core/testing';

import { ServiceReunionService } from './service-reunion.service';

describe('ServiceReunionService', () => {
  let service: ServiceReunionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceReunionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
