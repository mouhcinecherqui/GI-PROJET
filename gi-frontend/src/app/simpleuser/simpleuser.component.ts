import {Projet} from '../superuser/projet';
import { Imputation } from './Imputation';
import {Component, OnInit} from '@angular/core';
import {Http} from '@angular/http';
@Component({
  selector: 'app-simpleuser',
  templateUrl: './simpleuser.component.html',
  styleUrls: ['./simpleuser.component.css']
})
export class SimpleuserComponent {
  projets: Projet[];
  imputations: Imputation[];
  constructor(private http: Http) {}

  ngOnInit() {
    this.getProjets().then(projets => this.projets = projets);
     this.getImputations().then(imputations => this.imputations = imputations);

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
}
