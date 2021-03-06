import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {RouterModule} from '@angular/router';
import {AppRoutingModule} from './app-routing.module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NbMenuModule, NbThemeModule} from '@nebular/theme';
import {NbEvaIconsModule} from '@nebular/eva-icons';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {
  NbAuthJWTToken,
  NbAuthModule,
  NbAuthTokenParceler,
  NbPasswordAuthStrategy,
  NbTokenLocalStorage,
  NbTokenService,
  NbTokenStorage
} from '@nebular/auth';
import {AuthGuard} from './server/auth-guard.service';
import {environment} from '../environments/environment';
import {NbInterceptor} from './auth/register/NbInterceptor';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    NbThemeModule.forRoot({name: 'default'}),
    NbEvaIconsModule,
    NbMenuModule.forRoot(),
    HttpClientModule,
    NbAuthModule.forRoot({
      strategies: [
        NbPasswordAuthStrategy.setup({
          name: 'email',
          baseEndpoint: `${environment.serverBaseURL}`,
          token: {
            class: NbAuthJWTToken,
            key: 'token', // this parameter tells where to look for the token
          },
          login: {
            endpoint: '/auth/login',
            method: 'post',
            redirect: {
              success: '/pages/home',
              failure: null, // stay on the same page
            },
          },
          register: {
            redirect: {
              success: '/pages/home',
              failure: null, // stay on the same page
            },
            endpoint: '/auth/sign-up',
            method: 'post',
          },
          logout: {
            endpoint: '/auth/sign-out',
            method: 'post',
          },
          requestPass: {
            endpoint: '/auth/request-pass',
            method: 'post',
          },
          resetPass: {
            endpoint: '/auth/reset-pass',
            method: 'post',
          },
        }),
      ],
      forms: {
        login: {
          redirectDelay: 0,
          showMessages: {
            success: true,
          }
        },
        register: {
          redirectDelay: 0,
          showMessages: {
            success: true,
          }
        },
        requestPassword: {
          redirectDelay: 0,
          showMessages: {
            success: true,
          },
        },
        resetPassword: {
          redirectDelay: 0,
          showMessages: {
            success: true,
          },
        },
        logout: {
          redirectDelay: 0,
        },
      },
    }),
  ],
  providers: [
    NbAuthModule,
    NbTokenService,
    NbAuthTokenParceler,
    {provide: NbTokenStorage, useClass: NbTokenLocalStorage},
    {
      provide: HTTP_INTERCEPTORS,
      useClass: NbInterceptor,
      multi: true
    },
    AuthGuard
  ],
  exports:[
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
