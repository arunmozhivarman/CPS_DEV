import {Promotion} from './promotion';
import {PromotionserviceService} from './promotionservice.service';
import {Component} from '@angular/core';

@Component({
  selector: 'app-promo-root',
  templateUrl: './promotion.component.html',
  styleUrls: ['./promotion.component.css']
})

export class AppPromotionComponent {
  private promotions: Promotion[] = null
  private promotion: Promotion
  title = 'promotion service';
  constructor(private promotionserviceService: PromotionserviceService) {

  }

  getAllPromotions() {
    this.promotionserviceService.getAllPromotions().subscribe(data => this.promotions = data);
  }

  getPromotionById(promoId: String) {
    this.promotionserviceService.getPromotionById(promoId).subscribe(data => this.promotion = data);
  }


}
