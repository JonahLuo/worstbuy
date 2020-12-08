import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {NavbarComponent} from './navbar/navbar.component';
import {NgModule} from '@angular/core';

const routes: Routes = [
  {
    path: '',
    component: NavbarComponent,
    children: [
      {path: 'home', component: HomeComponent}
    ]
  }
  ,
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PagesRoutingModule { }
