import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.css']
})
export class AuthenticationComponent {
  authentication = true;
  login: string;
  constructor(public router: Router) { }


  connectUser(userId: string, userPwd: string) {

    if (userId === 'a') {
    this.authentication = false;
      this.router.navigate(['/superuser']);
    }

    if (userId === 'b') {
    this.authentication = false;
      this.router.navigate(['/simpleuser']);
    }
  }
}

