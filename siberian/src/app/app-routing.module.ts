import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddOrderComponent } from './addOrder/addOrder.component';
import { AddReviewComponent } from './addReview/addReview.component';
import { CartComponent } from './cart/cart.component';
import { ChangeDataUserComponent } from './changeDataUser/changeDataUser.component';
import { ChangePasswordComponent } from './changePassword/changePassword.component';
import { CustomerPageComponent } from './customerPage/customerPage.component';
import { FaqComponent } from './faq/faq.component';
import { HomeComponent } from './home/home.component';
import { InsertProductComponent } from './insertProduct/InsertProduct.component';
import { InsertSaleComponent } from './insertSale/insertSale.component';
import { LoginComponent } from './login/login.component';
import { LoginEmployeeComponent } from './loginEmployee/loginEmployee.component';
import { ModifyProductComponent } from './modifyProduct/modifyProduct.component';
import { MyOrdersComponent } from './myOrders/myOrders.component';
import { NavigatorComponent } from './navigator/navigator.component';
import { PageNotFoundComponent } from './PageNotFound/PageNotFound.component';
import { PaginationComponent } from './pagination/pagination.component';
import { PalladioComponent } from './palladio/palladio.component';
import { ProductComponent } from './product/product.component';
import { RegistrationComponent } from './registration/registration.component';
import { ResultsComponent } from './results/results.component';
import { SalesComponent } from './sales/sales.component';
import { SendMessageComponent } from './sendMessage/sendMessage.component';
import { WorkWithUsComponent } from './workWithUs/workWithUs.component';

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
  { path:'changeDataUser',component:ChangeDataUserComponent},
  { path:'modifyProduct',component:ModifyProductComponent},
  { path:'pagination',component:PaginationComponent},
  { path:'palladio',component:PalladioComponent},
  { path:'addReview',component:AddReviewComponent},
  { path:'addOrder',component:AddOrderComponent},
  { path:'sendMessage',component:SendMessageComponent},
  { path:'workWithUs',component:WorkWithUsComponent},
  {path: 'navigator', component:NavigatorComponent},
  {path: 'faq', component:FaqComponent},
  {path: '404', component:PageNotFoundComponent},
  {path: '**', redirectTo: '/404'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

