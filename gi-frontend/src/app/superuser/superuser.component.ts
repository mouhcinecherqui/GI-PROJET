import {User} from './user';
import {Component, OnInit} from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/toPromise';


@Component({
  selector: 'app-superuser',
  templateUrl: './superuser.component.html',
  styleUrls: ['./superuser.component.css']
})
export class SuperuserComponent implements OnInit {
  users: User[];
  superuser = true;
  viewdetails = true;
  ifList = true;
  ifCreate = false;
  ifAdmin = false;
  constructor(private http: Http) {}
  ngOnInit() {
    this.getUsers().then(users => this.users = users);
  }

  getUsers(): Promise<User[]> {
    return this.http.get('/api/users')
      .toPromise()
      .then(response => response.json() as User[]);
  }

  showCreation() {
    this.ifCreate = true;
    this.ifList = false;
    this.ifAdmin = false;
  }

  getDetails(codeAlliance) {
    alert(codeAlliance);
  }

  showList() {
    this.ifCreate = false;
    this.ifList = true;
    this.ifAdmin = false;

  }

  showAdmin() {
    this.ifCreate = false;
    this.ifList = false;
    this.ifAdmin = true;
  }
}

