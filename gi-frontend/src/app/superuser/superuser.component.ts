import {Domaine} from './Domaine';
import {Projet} from './projet';
import {Role} from './role';
import {User} from './user';
import {Component, OnInit, ViewChild} from '@angular/core';
import {FormGroup, FormControl, Validators, NgForm} from '@angular/forms';
import {Http} from '@angular/http';
import {Router} from '@angular/router';
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
  ifAdminProjet = false;
  ifAdminDomaine = false;
  selectedUser: User;
  ifDomaine = false;
  ifProjet = false;
  selecteProjet: Projet;
  selectDomaine: Domaine;
  router: Router;
  editProjet = false;
  editDomaine = false;
  openedit = false;
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
      codeAlliance: new FormControl(''),
      email: new FormControl(''),
      dmn: new FormControl(''),
      role: new FormControl(''),
      codeprojet: new FormControl(''),
      nomprojet: new FormControl(''),
      nomcomplet: new FormControl(''),
      descriptionprojet: new FormControl(''),
      nomDomaine: new FormControl(''),
      descriptiondmn: new FormControl(''),
    });
  }

  updatedomaine(dmn: string): Promise<Domaine[]> {
    console.log('mc ' + dmn);
    return this.http.put('/api/domaines?dmn=', dmn)
      .toPromise()
      .then(response => response.json() as Domaine[]).catch(this.handleError);
  }
  updateprojet(codeprojet: string): Promise<Projet[]> {
    console.log('mcp ' + codeprojet);
    return this.http.put('/api/projets?codeprojet=', codeprojet)
      .toPromise()
      .then(response => response.json() as Projet[]).catch(this.handleError);
  }
  updateuser(codeAlliance: string): Promise<User[]> {
    console.log('mcc ' + codeAlliance);
    return this.http.put('/api/users?codeAlliance=', codeAlliance)
      .toPromise()
      .then(response => response.json() as User[]).catch(this.handleError);
  }

  onSelect(user: User): void {
    console.log(user.codeAlliance);
    console.log(user.dmn);
    console.log(user.email);
    console.log(user.firstName);
    console.log(user.lastName);
    console.log(user.role);
    this.openedit = true;
    this.selectedUser = user;
  }
  onSelectep(projet: Projet): void {
    this.editProjet = true;
    this.selecteProjet = projet;
  }
  onSelected(domaine: Domaine): void {
    this.editDomaine = true;
    this.selectDomaine = domaine;
  }
  onSubmit = function(user) {
    this.http.post('/api/users', user).subscribe(response => response.json() as User[]
    );
    console.log(user);
  };
  onSubmitp = function(projet) {
    this.http.post('/api/projets', projet).subscribe(response => response.json() as Projet[]
    );
    this.ifProjet = false;
    console.log(projet);
  };
  onSubmitd = function(domaine) {
    this.http.post('/api/domaines', domaine).subscribe(response => response.json() as Domaine[]
    );
    this.ifDomaine = false;
    console.log(domaine);
  };
  doSomeActionOnOpen() {
    console.log('hi');
  }
  doSomeActionOnClose() {
    console.log('bye');
  }
  addProjet() {
    this.ifProjet = true;
    console.log('mc');
  }
  addDomaine() {
    this.ifDomaine = true;

    console.log('ch');
  }
  cancel4() {
    this.openedit = false;
  }
  cancel() {

    this.ifProjet = false;
  }
  cancel1() {
    this.ifDomaine = false;
  }
  cancel2() {

    this.editProjet = false;
  }
  cancel3() {
    this.editDomaine = false;
  }
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
  deleteProjet(codeprojet: string): Promise<void> {
    console.log('ach w9e3 ' + codeprojet);
    return this.http.delete('/api/projets/' + codeprojet)
      .toPromise()
      .then(() => null).catch(this.handleError);
  }

  onDeletep = function(codeprojet: string) {
    this.deleteProjet(codeprojet).then(() => null);
    this.http.get('/api/projets')
      .toPromise()
      .then(response => response.json() as Projet[]);
  };
  deleteDomaine(dmn: string): Promise<void> {
    console.log('ach w9e3 ' + dmn);
    return this.http.delete('/api/domaines/' + dmn)
      .toPromise()
      .then(() => null).catch(this.handleError);
  }

  onDeleted = function(dmn: string) {
    this.deleteDomaine(dmn).then(() => null);
    this.http.get('/api/domaines')
      .toPromise()
      .then(response => response.json() as Domaine[]);
  };
  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
  showCreation() {
    this.ifCreate = true;
    this.ifList = false;
    this.ifAdminProjet = false;
    this.ifAdminDomaine = false;
    this.ngOnInit();
  }

  getDetails(codeAlliance) {
    //    this.router.navigate(['/viewdetails', codeAlliance]);
    //    alert(codeAlliance);
  }

  showList() {
    this.ifCreate = false;
    this.ifList = true;
    this.ifAdminProjet = false;
    this.ifAdminDomaine = false;
    this.openedit = false;
    this.ngOnInit();
  }

  showAdminProjet() {
    this.ifCreate = false;
    this.ifList = false;
    this.ifAdminProjet = true;
    this.ifDomaine = false;
    this.ifProjet = false;
    this.ifAdminDomaine = false;
    this.ngOnInit();
  }
  showAdminDomaine() {
    this.ifCreate = false;
    this.ifList = false;
    this.ifAdminProjet = false;
    this.ifDomaine = false;
    this.ifProjet = false;
    this.ifAdminDomaine = true;
    this.ngOnInit();
  }
  logoutUser() {
  }
}

