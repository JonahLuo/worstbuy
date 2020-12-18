import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NavbarComponent} from './pages/navbar/navbar.component';
import { HomeComponent } from './pages/home/home.component';
import {AuthGuard} from './server/auth-guard.service';
import {PagesModule} from './pages/pages.module';
import {NgxAuthModule} from './auth/auth.module';


const routes: Routes = [
  {
    path: '',
    redirectTo: '/auth/login',
    pathMatch: 'full',
  },
  {
    path: 'pages',
    // canActivate: [AuthGuard], // here we tell Angular to check the access with our AuthGuard
    loadChildren: () => PagesModule
  },
  {
    path: 'auth',
    loadChildren: () => NgxAuthModule,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
