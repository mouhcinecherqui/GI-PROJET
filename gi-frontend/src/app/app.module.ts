import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpModule, JsonpModule} from '@angular/http';
import {RouterModule, Routes} from '@angular/router';
import {Ng2FilterPipeModule} from 'ng2-filter-pipe';
import {AppComponent} from './app.component';
import {SimpleuserComponent} from './simpleuser/simpleuser.component';
import {AuthenticationComponent} from './authentication/authentication.component';
import {ForgetpwdComponent} from './forgetpwd/forgetpwd.component';
import {MyFilterPipe} from './superuser/MyFilterPiple';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {MoncompteComponent} from './moncompte/moncompte.component';
import {DropdownModule} from 'ng2-dropdown';
import {SuperuserComponent} from './superuser/superuser.component';
import {SimpleutilisateurComponent} from './simpleutilisateur/simpleutilisateur.component';







const appRoutes: Routes = [
  {path: 'superuser', component: SuperuserComponent, pathMatch: 'full'}
  ,
  {path: 'simpleuser', component: SimpleuserComponent ,  pathMatch: 'full'}
  , 
  {path: 'logout', component: AuthenticationComponent ,  pathMatch: 'full'}
  ,
  {path: 'viewdetails', component: SimpleuserComponent ,  pathMatch: 'full'}
  , 
  {path: 'forgetpwd', component: ForgetpwdComponent ,  pathMatch: 'full'}
  , 
  {path: 'simpleutilisateur', component: SimpleutilisateurComponent ,  pathMatch: 'full'}
  ,
  {path: 'moncompte', component: MoncompteComponent ,  pathMatch: 'full'}
  ,
   {path: '#/', component: AuthenticationComponent ,  pathMatch: 'full'}
];


@NgModule({
  declarations: [
    AppComponent,
    SuperuserComponent,
    SimpleuserComponent,
    AuthenticationComponent,
    ForgetpwdComponent,
    MyFilterPipe,
    MoncompteComponent,
    SimpleutilisateurComponent,


  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes),
    Ng2FilterPipeModule,
    NgbModule.forRoot(),
    JsonpModule,
    ReactiveFormsModule,
    DropdownModule,
  ],
  exports: [
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule {}
