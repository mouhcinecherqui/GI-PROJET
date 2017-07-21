import {Projet} from '../superuser/projet';
import {Component, OnInit} from '@angular/core';
import {FormGroup, FormControl} from '@angular/forms';
import {Http} from '@angular/http';
@Component({
  selector: 'app-simpleuser',
  templateUrl: './simpleuser.component.html',
  styleUrls: ['./simpleuser.component.css']
})
export class SimpleuserComponent implements OnInit {
  projets: Projet[];
  imputations: Imputations;
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
  getImputations(): Promise<Imputations> {
    return this.http.get('/api/imputations/mounth?codeAlliance=abcd1234&moisAnnee')
      .toPromise()
      .then(response => response.json() as Imputations);
  }
  onSub = function(im: Imputations) {
    //    console.log("im " + im.codeprojet);
    //    this.http.post('/api/imputations', Imputation).subscribe(response => response.json() as Imputation[]
    //    );
  };
}
