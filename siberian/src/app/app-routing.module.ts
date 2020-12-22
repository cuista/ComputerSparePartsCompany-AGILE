import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CartComponent } from './cart/cart.component';
import { ChangePasswordComponent } from './changePassword/changePassword.component';
import { CustomerPageComponent } from './customerPage/customerPage.component';
import { HomeComponent } from './home/home.component';
import { InsertProductComponent } from './insertProduct/InsertProduct.component';
import { InsertSaleComponent } from './insertSale/insertSale.component';
import { LoginComponent } from './login/login.component';
import { LoginEmployeeComponent } from './loginEmployee/loginEmployee.component';
import { MyOrdersComponent } from './myOrders/myOrders.component';
import { PageNotFoundComponent } from './PageNotFound/PageNotFound.component';
import { ProductComponent } from './product/product.component';
import { RegistrationComponent } from './registration/registration.component';
import { ResultsComponent } from './results/results.component';
import { SalesComponent } from './sales/sales.component';

const routes: Routes = [
  { path:'', component: HomeComponent },
  { path:'home', component:HomeComponent },
  { path:'login', component:LoginComponent },
  { path:'registration',component:RegistrationComponent},
  { path:'orders',component:MyOrdersComponent},
  { path:'sales',component:SalesComponent},
  { path:'cart',component:CartComponent},
  { path:'results',component:ResultsComponent},
  { path:'product',component:ProductComponent},
  { path:'insert',component:InsertProductComponent},
  { path:'registerSale',component:InsertSaleComponent},
  { path:'loginEmployee',component:LoginEmployeeComponent},
  { path:'customerPage',component:CustomerPageComponent},
  { path:'changePassword',component:ChangePasswordComponent},
  {path: '404', component:PageNotFoundComponent},
  {path: '**', redirectTo: '/404'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

