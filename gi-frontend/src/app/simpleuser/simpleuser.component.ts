import {Projet} from '../superuser/projet';
import {Imputation} from './Imputation';
import {Component, OnInit} from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import {Http} from '@angular/http';
@Component({
  selector: 'app-simpleuser',
  templateUrl: './simpleuser.component.html',
  styleUrls: ['./simpleuser.component.css']
})
export class SimpleuserComponent implements OnInit {
  projets: Projet[];
  imputations: Imputation[];
  form;
  constructor(private http: Http) {}

  ngOnInit() {
    this.getProjets().then(projets => this.projets = projets);
    this.getImputations().then(imputations => this.imputations = imputations);
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
  getImputations(): Promise<Imputation[]> {
    return this.http.get('/api/imputations')
      .toPromise()
      .then(response => response.json() as Imputation[]);
  }
  onSub = function(Imputation) {
    console.log(Imputation);
//    this.http.post('/api/imputations', Imputation).subscribe(response => response.json() as Imputation[]
//    );
  };
}
