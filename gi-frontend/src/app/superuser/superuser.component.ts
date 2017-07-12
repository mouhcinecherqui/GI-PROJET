import {Projet} from './projet';
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
  projets: Projet[];
  superuser = true;
  viewdetails = true;
  ifList = true;
  ifCreate = false;
  ifAdmin = false;
  constructor(private http: Http) {}
  ngOnInit() {
    this.getUsers().then(users => this.users = users);
    this.getProjets().then(projets => this.projets = projets);
  }

  getUsers(): Promise<User[]> {
    return this.http.get('/api/users')
      .toPromise()
      .then(response => response.json() as User[]);
  }
  getProjets(): Promise<Projet[]> {
    return this.http.get('/api/projets')
      .toPromise()
      .then(response => response.json() as Projet[]);
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

  logoutUser() {
  }
}

