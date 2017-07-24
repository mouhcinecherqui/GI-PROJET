import {Projet} from '../superuser/projet';
import {User} from '../superuser/user';
import {Calendrier} from './Calendrier';
import {Imputation} from './Imputation';
import {Imputations} from './Imputations';
import {Component, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {Http} from '@angular/http';
@Component({
  selector: 'app-simpleuser',
  templateUrl: './simpleuser.component.html',
  styleUrls: ['./simpleuser.component.css']
})
export class SimpleuserComponent implements OnInit {
  getUsers: any;
  projets: Projet[];
  imputations: Imputations;
  listeImputation: Imputation[];
  users: User[];
  form;
  constructor(private http: Http) {}

  ngOnInit() {
    this.getProjets().then(projets => this.projets = projets);
    this.getImputations().then(imputations => this.imputations = imputations);
    //    setTimeout(function() {
    //      console.log('VIDEO HAS STOPPED');
    //    }, 5000);
    console.log('imputations :     ===> ' + this.imputations);
    //    this.listeImputation = this.imputations.mapImputation.get('codeProjet');
    //    this.imputations.mapImputation.get("codeProjet")
    this.form = new FormGroup({
      codeprojet: new FormControl('')
    });
  }
  logoutUser() {

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
