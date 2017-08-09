import {User} from '../superuser/user';
import {Component, OnInit} from '@angular/core';
import {Http} from '@angular/http';

@Component({
  selector: 'app-forgetpwd',
  templateUrl: './forgetpwd.component.html',
  styleUrls: ['./forgetpwd.component.css']
})
export class ForgetpwdComponent implements OnInit {
  forgetpwd = true;
  users: User[];
  constructor(private http: Http) {

  }

  ngOnInit() {
    this.sendMail().then(users => this.users = users);
  }
  sendMail(): Promise<User[]> {
    console.log('hi');
    return this.http.get('/api/users')
      .toPromise()
      .then(response => response.json() as User[]);
  }
}
