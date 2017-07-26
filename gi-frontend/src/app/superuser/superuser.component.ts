import {Domaine} from './Domaine';
import {Projet} from './projet';
import {Role} from './role';
import {User} from './user';
import {Component, OnInit, ViewChild} from '@angular/core';
import {FormGroup, FormControl, Validators, NgForm} from '@angular/forms';
import {Http} from '@angular/http';
import {Angular2Csv} from 'angular2-csv';
import 'rxjs/add/operator/toPromise';
import 'rxjs/add/operator/debounceTime';


@Component({
  selector: 'app-superuser',
  templateUrl: './superuser.component.html',
  styleUrls: ['./superuser.component.css']
})
export class SuperuserComponent implements OnInit {
  allItems: any;



  searchKey: string;
  form;
  users: User[];
  projets: Projet[];
  domaines: Domaine[];
  roles: Role[];
  superuser = true;
  viewdetails = true;
  ifList = true;
  ifCreate = false;
  ifAdmin = false;
  selectedUser: User;


  public search = new FormControl();

  constructor(private http: Http) {}

  onChange(dmn: string) {
    this.getUsersByDomaine(dmn).then(users => this.users = users);
  }

  ngOnInit() {
    this.search
      .valueChanges
      .debounceTime(200)
      .subscribe(term => {
        this.searchKey = term;
        console.log(term);
      });
    this.getUsersByDomaine('').then(users => this.users = users);
    this.getRoles().then(roles => this.roles = roles);
    this.getProjets().then(projets => this.projets = projets);
    this.getDomaines().then(domaines => this.domaines = domaines);
    this.form = new FormGroup({
      firstName: new FormControl(''),
      lastName: new FormControl(''),
      password: new FormControl(''),
      CodeAlliance: new FormControl(''),
      email: new FormControl(''),
      dmn: new FormControl(''),
      role: new FormControl(''),

    });
  }
  onSelect(user: User): void {
    console.log(user.codeAlliance);
    console.log(user.dmn);
    console.log(user.email);
    console.log(user.firstName);
    console.log(user.lastName);
    console.log(user.role);
    this.selectedUser = user;
  }


  onSubmit = function(user) {
    this.http.post('/api/users', user).subscribe(response => response.json() as User[]
    );
    console.log(user);
  };
  doSomeActionOnOpen() {
    console.log('hi');
  };
    doSomeActionOnClose() {
    console.log('bye');
  };

  getRoles(): Promise<Role[]> {
    return this.http.get('/api/roles')
      .toPromise()
      .then(response => response.json() as Role[]);
  }

  getUsersByDomaine(dmn: string): Promise<User[]> {
    return this.http.get('/api/users?dmn=' + dmn)
      .toPromise()
      .then(response => response.json() as User[]);
  }
  //  getUsers(): Promise<User[]> {
  //    return this.http.get('/api/users')
  //      .toPromise()
  //      .then(response => response.json() as User[]);
  //  }
  getDomaines(): Promise<Domaine[]> {
    return this.http.get('/api/domaines')
      .toPromise()
      .then(response => response.json() as Domaine[]);
  }
  getProjets(): Promise<Projet[]> {
    return this.http.get('/api/projets')
      .toPromise()
      .then(response => response.json() as Projet[]);
  }


  deleteUser(codeAlliance: string): Promise<void> {
    console.log('ach w9e3 ' + codeAlliance);
    return this.http.delete('/api/users/' + codeAlliance)
      .toPromise()
      .then(() => null).catch(this.handleError);
  }

  onDelete = function(codeAlliance: string) {
    this.deleteUser(codeAlliance).then(() => null);
    this.http.get('/api/users')
      .toPromise()
      .then(response => response.json() as User[]);
  };

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
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
    this.ngOnInit();
  }

  showAdmin() {
    this.ifCreate = false;
    this.ifList = false;
    this.ifAdmin = true;
  }

  logoutUser() {
  }
}

