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
}
