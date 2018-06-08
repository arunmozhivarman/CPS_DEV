import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AppPromotionComponent } from './app.promotion.component';
import { HttpModule } from '@angular/http';

@NgModule({
  declarations: [
    AppComponent, AppPromotionComponent,
  ],
  imports: [
    BrowserModule,
    HttpModule,
  ],
  providers: [],
  bootstrap: [AppComponent, AppPromotionComponent]
})
export class AppModule { }
