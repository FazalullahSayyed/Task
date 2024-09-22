import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponentComponent } from './dashboard-component/dashboard-component.component';
import { EmployeeComponentComponent } from './employee-component/employee-component.component';
import { ReportsComponentComponent } from './reports-component/reports-component.component';
import { HomeComponent } from './home/home.component';
import { LoginuserService } from './loginuser.service';
import { UserLoginComponent } from './user-login/user-login.component';
const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  {path:"login",component:UserLoginComponent},
  { path: "dashboard", component: DashboardComponentComponent },
  { path: "employee", component: EmployeeComponentComponent },
  { path: "reports", component: ReportsComponentComponent },
  { path: "home", component: HomeComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
