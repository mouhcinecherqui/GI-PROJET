import {Domaine} from './Domaine';
import {Projet} from './projet';
import {Role} from './role';
import {User} from './user';
import {Component, OnInit} from '@angular/core';
import {FormGroup, FormControl, Validators} from '@angular/forms';
import {Http} from '@angular/http';
import 'rxjs/add/operator/toPromise';


@Component({
  selector: 'app-superuser',
  templateUrl: './superuser.component.html',
  styleUrls: ['./superuser.component.css']
})
export class SuperuserComponent implements OnInit {
  formErrors = {
    'firstname': '',
    'lastname': '',
    'password': '',
    'email': '',
    'codeAlliance': '',
    'role': '',
    'domaine': ''
  };
  validationMessages = {
    'firstname': {
      'required': 'firstname is required.'
    },
    'lastname': {
      'required': 'lastname is required.'
    },
    'password': {
      'required': 'password is required.'
    },
    'email': {
      'required': 'email is required.'
    },
    'codeAlliance': {
      'required': 'codeAlliance is required.'
    },
    'role': {
      'required': 'role is required.'
    },
    'domaine': {
      'required': 'domaine is required.'
    }
  };
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
  constructor(private http: Http) {}
  ngOnInit() {
    this.getUsers().then(users => this.users = users);
    this.getRoles().then(roles => this.roles = roles);
    this.getProjets().then(projets => this.projets = projets);
    this.getDomaines().then(domaines => this.domaines = domaines);
    this.form = new FormGroup({
      firstname: new FormControl('', Validators.compose([
        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(12),


      ])),
      lastname: new FormControl('', Validators.compose([
        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(12),


      ])),
      codeAlliance: new FormControl('', Validators.compose([
        Validators.required,

        Validators.pattern('[a-z 1-9]{8}')


      ])),
      password: new FormControl('', Validators.compose([
        Validators.required,
        Validators.minLength(8),
        Validators.maxLength(14),


      ])),
      email: new FormControl(''),
      domaine: new FormControl(''),
      role: new FormControl('')

    }
    );
  }


  onSubmit = function(user) {
    console.log(user);
  };
  getRoles(): Promise<Role[]> {
    return this.http.get('/api/roles')
      .toPromise()
      .then(response => response.json() as Role[]);
  }
  getdmn(): Promise<User[]> {
    return this.http.get('/api/users/{dmn}')
      .toPromise()
      .then(response => response.json() as User[]);
  }
  getUsers(): Promise<User[]> {
    return this.http.get('/api/users')
      .toPromise()
      .then(response => response.json() as User[]);
  }
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

