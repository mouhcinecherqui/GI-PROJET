import {Projet} from '../superuser/projet';
import {User} from '../superuser/user';
import {Calendrier} from './Calendrier';
import {Imputation} from './Imputation';
import {Imputations} from './Imputations';
import {Component, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {Http} from '@angular/http';
@Component({
  selector: 'app-simpleutilisateur',
  templateUrl: './simpleutilisateur.component.html',
  styleUrls: ['./simpleutilisateur.component.css']
})
export class SimpleutilisateurComponent implements OnInit {
  getUsers: any;
  projets: Projet[];
  imputations: Imputations;
  listeImputation: Imputation[];
  users: User[];
  form;
  selectedUser: User;
  constructor(private http: Http) {}

  ngOnInit() {
    this.getUsersBycodeAlliance('').then(users => this.users = users);
    this.getProjets().then(projets => this.projets = projets);
    this.getImputations().then(imputations => this.imputations = imputations);
    //    setTimeout(function() {
    //      console.log('VIDEO HAS STOPPED');
    //    }, 5000);
    console.log('imputations :     ===> ' + this.imputations);
    //    this.listeImputation = this.imputations.mapImputation.get('codeProjet');
    //    this.imputations.mapImputation.get("codeProjet")
    this.form = new FormGroup({
      codeProjet: new FormControl('')
    });
    if (this.imputations && this.imputations.mapImputation.size > 0) {
      console.log('map ==> ' + this.imputations.mapImputation.keys().next().value);
      this.form.codeProjet = this.imputations.mapImputation.keys().next().value;
    }
    //    this.imputations.mapImputation.get("codeProjet")
  }
  logoutUser() {

  }
  getUsersBycodeAlliance(codeAlliance: string): Promise<User[]> {
    return this.http.get('/users/{codeAlliance}' + codeAlliance)
      .toPromise()
      .then(response => response.json() as User[]);
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
  getProjets(): Promise<Projet[]> {
    return this.http.get('/api/projets')
      .toPromise()
      .then(response => response.json() as Projet[]);
  }
  getImputations(): Promise<Imputations> {
    return this.http.get('/api/imputations/mounth?codeAlliance=abcd1234&moisAnnee')
      .toPromise()
      .then(response => response.json() as Imputations).catch(this.handleError);
  }
  onSub = function(im: Imputations) {
    //    console.log("im " + im.codeprojet);
    //    this.http.post('/api/imputations', Imputation).subscribe(response => response.json() as Imputation[]
    //    );
  };
  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}
