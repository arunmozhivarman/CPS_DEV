import {Promotion} from './promotion';
import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PromotionserviceService {

  constructor(private http: Http) {}

  getAllPromotions(): Observable<Promotion[]> {
    return this.http.get(`http://wkwin6039358.global.publicisgroupe.net:5005/promotions/getALLPromotions`)
      .pipe(map((res: Response) => res.json()));
  }

  getPromotionById(promoId: String): Observable<Promotion> {
    return this.http.get(`http://localhost:5005/promotionsclient/getPromotionById/` + promoId)
      .pipe(map((res: Response) => res.json()));
  }
}