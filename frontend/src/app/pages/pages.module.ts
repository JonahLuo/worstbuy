import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import {PagesRoutingModule} from './pages-routing.module';
import {SafePipe} from './pipe/SafePipe';
import {
  NbActionsModule, NbButtonModule,
  NbCardModule,
  NbContextMenuModule,
  NbFormFieldModule, NbIconModule,
  NbInputModule,
  NbLayoutModule, NbSelectModule, NbStepperModule, NbTabsetModule,
  NbUserModule
} from '@nebular/theme';
import { CategoryDetailComponent } from './category-detail/category-detail.component';
import { ItemDetailComponent } from './item-detail/item-detail.component';
import { CreatePosterComponent } from './create-poster/create-poster.component';
import { ProfileComponent } from './profile/profile.component';
import { OtherprofileComponent } from './otherprofile/otherprofile.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';



@NgModule({
  declarations: [
    HomeComponent,
    NavbarComponent,
    SafePipe,
    CategoryDetailComponent,
    ItemDetailComponent,
    CreatePosterComponent,
    ProfileComponent,
    OtherprofileComponent
  ],
  imports: [
    CommonModule,
    PagesRoutingModule,
    NbContextMenuModule,
    NbUserModule,
    NbLayoutModule,
    NbActionsModule,
    NbCardModule,
    NbInputModule,
    NbFormFieldModule,
    NbButtonModule,
    NbIconModule,
    NbStepperModule,
    ReactiveFormsModule,
    NbSelectModule,
    FormsModule,
    NbTabsetModule,
  ],
  exports: [
    SafePipe
  ]
})
export class PagesModule { }
