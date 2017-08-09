import {Component} from '@angular/core';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  auth = false;
  showSimpleUser = false;
  showUser = false;
  showAdmin = false;
  showPwd = false;
  showCompte = false;

  authent() {

    this.auth = true;

    return true;

  }
  //  details() {
  //    this.auth = false;
  //  }
  //  user() {
  //    this.auth = true;
  //  }
  //  admin() {
  //    this.auth = true;
  //  }
  //  pwd() {
  //    this.auth = true;
  //  }
  //  compte() {
  //    this.auth = true;
  //  }
}
