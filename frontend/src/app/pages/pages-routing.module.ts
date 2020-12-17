import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {NavbarComponent} from './navbar/navbar.component';
import {NgModule} from '@angular/core';
import {CategoryDetailComponent} from './category-detail/category-detail.component';
import {ProfileComponent} from './profile/profile.component';
import {OtherprofileComponent} from './otherprofile/otherprofile.component';
import {CreatePosterComponent} from './create-poster/create-poster.component';

const routes: Routes = [
  {
    path: '',
    component: NavbarComponent,
    children: [
      {path: 'home', component: HomeComponent},
      {path: 'categoryDetail/:category', component: CategoryDetailComponent},
      {path: 'profile', component: ProfileComponent},
      {path: 'profile/:id', component: OtherprofileComponent},
      {path: 'create', component: CreatePosterComponent}
    ]
  }
  ,
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PagesRoutingModule { }
