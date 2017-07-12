import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule, JsonpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';
import { Ng2FilterPipeModule } from 'ng2-filter-pipe';
import { AppComponent } from './app.component';
import { SuperuserComponent} from './superuser/superuser.component';
import { NewuserComponent } from './newuser/newuser.component';
import { ListwithdetComponent } from './listwithdet/listwithdet.component';
import { SimpleuserComponent } from './simpleuser/simpleuser.component';
import { AuthenticationComponent } from './authentication/authentication.component';
import { AdminComponent } from './admin/admin.component';
import { ForgetpwdComponent } from './forgetpwd/forgetpwd.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';



const appRoutes: Routes = [
  { path: 'superuser', component: SuperuserComponent }
  , { path: '#/', redirectTo: '#/superuser', pathMatch: 'full' },
  { path: 'simpleuser', component: SimpleuserComponent }
  , { path: '#/', redirectTo: '#/simpleuser', pathMatch: 'full' },
  { path: 'creation', component: NewuserComponent }
  , { path: '#/', redirectTo: '#/creation', pathMatch: 'full' },
  { path: 'logout', component: AuthenticationComponent }
  , { path: '#/', redirectTo: '#/logout', pathMatch: 'full' },
  { path: 'viewdetails', component: SimpleuserComponent }
  , { path: '#/', redirectTo: '#/viewdetails', pathMatch: 'full' },
  { path: 'forgetpwd', component: ForgetpwdComponent }
  , { path: '#/', redirectTo: '#/forgetpwd', pathMatch: 'full' }
];


@NgModule({
  declarations: [
    AppComponent,
    SuperuserComponent,
    NewuserComponent,
    ListwithdetComponent,
    SimpleuserComponent,
    AuthenticationComponent,
    AdminComponent,
    ForgetpwdComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes),
    Ng2FilterPipeModule,
    NgbModule.forRoot(),
    JsonpModule,
    ReactiveFormsModule
  ],
  exports: [
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
