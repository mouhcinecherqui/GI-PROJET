import {Projet} from '../superuser/projet';
import {User} from '../superuser/user';
import {Calendrier} from './Calendrier';
import {Imputation} from './Imputation';
import {Imputations} from './Imputations';
import {MoisAnnee} from './MoisAnnee';
import {Component, OnInit} from '@angular/core';
import {FormGroup, FormControl, FormsModule} from '@angular/forms';
import {Http} from '@angular/http';
@Component({
  selector: 'app-simpleuser',
  templateUrl: './simpleuser.component.html',
  styleUrls: ['./simpleuser.component.css']
})
export class SimpleuserComponent implements OnInit {
  getUsers: any;
  projets: Projet[];
  listeImputations: Imputations[];
  listeImputation: Imputation[];
  users: User[];
  listeMoisAnnee: MoisAnnee[];
  listeValeurs: Imputation[];
  listeValeurs2: Imputation[];
  defaultMoisAnnee: MoisAnnee;
  currentMonthYear: string;
  form;
  constructor(private http: Http) {}

  ngOnInit() {
    this.init();
    this.getProjets().then(projets => this.projets = projets);
    this.getImputations(this.defaultMoisAnnee.cle).then(listeImputations => this.listeImputations = listeImputations);

    this.form = new FormGroup({
      codeProjet: new FormControl('')
    });
  }

  init() {
    this.listeMoisAnnee = new Array();
    this.listeValeurs = new Array();
    this.listeValeurs2 = new Array();

    this.listeMoisAnnee.push(new MoisAnnee('01_2017', 'Janvier 2017'));
    this.listeMoisAnnee.push(new MoisAnnee('02_2017', 'Fevrier 2017'));
    this.listeMoisAnnee.push(new MoisAnnee('03_2017', 'Mars 2017'));
    this.listeMoisAnnee.push(new MoisAnnee('04_2017', 'Avril 2017'));
    this.listeMoisAnnee.push(new MoisAnnee('05_2017', 'Mai 2017'));
    this.listeMoisAnnee.push(new MoisAnnee('06_2017', 'Juin 2017'));
    this.listeMoisAnnee.push(new MoisAnnee('07_2017', 'Juillet 2017'));
    this.defaultMoisAnnee = this.listeMoisAnnee[6];
    this.currentMonthYear = this.defaultMoisAnnee.cle;

    this.listeValeurs.push(new Imputation('0.00'));
    this.listeValeurs.push(new Imputation('0.25'));
    this.listeValeurs.push(new Imputation('0.50'));
    this.listeValeurs.push(new Imputation('0.75'));
    this.listeValeurs.push(new Imputation('1.00'));

    this.listeValeurs2.push(new Imputation('0.00'));
    this.listeValeurs2.push(new Imputation('0.25'));
    this.listeValeurs2.push(new Imputation('0.50'));
    this.listeValeurs2.push(new Imputation('0.75'));
    this.listeValeurs2.push(new Imputation('1.00'));
  }

  logoutUser() {

  }
  doSomeActionOnClose() {

  }
  doSomeActionOnOpen() {

  }
  getImputationsByMonthYear($event) {
    //    console.log('mrs ===>  ' + $event);
    //    console.log('mrs ===>  ' + $event.target);
    //    console.log('mrs ===>  ' + $event.target.value);
    //    console.log('mrs ===>  ' + $event.target.value.cle);
    this.currentMonthYear = $event.target.value;
    this.getImputations($event.target.value).then(listeImputations => this.listeImputations = listeImputations);
  }

  getProjets(): Promise<Projet[]> {
    return this.http.get('/api/projets')
      .toPromise()
      .then(response => response.json() as Projet[]);
  }

  getImputations(value: string): Promise<Imputations[]> {
    return this.http.get('/api/imputations/mounth?codeAlliance=abcd1234&moisAnnee=' + value)
      .toPromise()
      .then(response => response.json() as Imputations[]).catch(this.handleError);
  }

  updateImputations(listeImputations: Imputations[]): Promise<Imputations[]> {
    console.log('mrs ===>  ' + listeImputations[0].listeImputation[0].jour);
    return this.http.put('/api/imputations?codeAlliance=abcd1234&moisAnnee=' + this.currentMonthYear, this.listeImputations)
      .toPromise()
      .then(response => response.json() as Imputations[]).catch(this.handleError);
  }

  setJourNewValue($event, idImputation: number) {
    //    console.log($event.target.value);
    //    console.log(date);
    for (let index = 0; index < this.listeImputations.length; index++) {
      for (let j = 0; j < this.listeImputations[index].listeImputation.length; j++) {
        if (this.listeImputations[index].listeImputation[j].id === idImputation) {
          this.listeImputations[index].listeImputation[j].jour = $event.target.value;
          console.log('old value ' + this.listeImputations[index].listeImputation[j].jour);
          console.log('new value ' + $event.target.value);
        }
      }
    }
  }

  setCodeProjetNewValue($event, idImputations: number) {
    console.log('old code projet ' + this.listeImputations[idImputations - 1].projet.codeprojet);
    console.log('new code projet ' + $event.target.value);

    for (let index = 0; index < this.listeImputations[idImputations - 1].listeImputation.length; index++) {
      this.listeImputations[idImputations - 1].listeImputation[index].codeProjet = $event.target.value;
    }
  }
  setNewValue2(valeur: string) {
    //    for (let index = 0; index < this.listeValeurs.length; index++) {
    //      if (this.listeValeurs[index].jour == valeur) {
    //        console.log('event ' + valeur);
    //        console.log('jour' + this.listeValeurs[index].jour);
    //        this.listeValeurs.splice(index, 1);
    //      }
    //    }

  }
  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}
