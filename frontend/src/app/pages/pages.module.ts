import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import {PagesRoutingModule} from './pages-routing.module';
import {SafePipe} from './pipe/SafePipe';
import {NbActionsModule, NbContextMenuModule, NbLayoutModule, NbUserModule} from '@nebular/theme';



@NgModule({
  declarations: [
    HomeComponent,
    NavbarComponent,
    SafePipe
  ],
  imports: [
    CommonModule,
    PagesRoutingModule,
    NbContextMenuModule,
    NbUserModule,
    NbLayoutModule,
    NbActionsModule,
  ],
  exports: [
    SafePipe
  ]
})
export class PagesModule { }
