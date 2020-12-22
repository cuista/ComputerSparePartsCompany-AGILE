import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { TopHeaderComponent } from './topHeader/topHeader.component';
import { RegistrationComponent } from './registration/registration.component';
import { InsertProductComponent } from './insertProduct/InsertProduct.component';
import { InsertSaleComponent } from './insertSale/insertSale.component';
import { ProductComponent } from './product/product.component';
import { SliderComponent } from './Slider/Slider.component';
import { HomeComponent } from './home/home.component';
import { ResultsComponent } from './results/results.component';
import { SingleInResearchComponent } from './singleInResearch/singleInResearch.component';
import { FooterComponent } from './footer/footer.component';
import { MyOrdersComponent } from './myOrders/myOrders.component';
import { SingleOrderComponent } from './singleOrder/singleOrder.component';
import { SearchPageComponent } from './searchPage/searchPage.component';
import { SalesComponent } from './sales/sales.component';
import { CartComponent } from './cart/cart.component';
import { PageNotFoundComponent } from './PageNotFound/PageNotFound.component';
import { LoginEmployeeComponent } from './loginEmployee/loginEmployee.component';
import { CustomerPageComponent } from './customerPage/customerPage.component';
import { ChangePasswordComponent } from './changePassword/changePassword.component';

@NgModule({
  declarations: [																													
    AppComponent,
      LoginComponent,
      TopHeaderComponent,
      RegistrationComponent,
      InsertProductComponent,
      InsertSaleComponent,
      ProductComponent,
      SliderComponent,
      HomeComponent,
      ResultsComponent,
      SingleInResearchComponent,
      FooterComponent,
      MyOrdersComponent,
      SingleOrderComponent,
      SearchPageComponent,
      SalesComponent,
      CartComponent,
      PageNotFoundComponent,
      LoginEmployeeComponent,
      CustomerPageComponent,
      ChangePasswordComponent
   ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
