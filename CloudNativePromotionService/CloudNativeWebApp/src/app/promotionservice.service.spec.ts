import { TestBed, inject } from '@angular/core/testing';

import { PromotionserviceService } from './promotionservice.service';

describe('PromotionserviceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PromotionserviceService]
    });
  });

  it('should be created', inject([PromotionserviceService], (service: PromotionserviceService) => {
    expect(service).toBeTruthy();
  }));
});
