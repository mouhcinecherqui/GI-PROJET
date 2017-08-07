import {User} from '../superuser/user';
import {Component, OnInit} from '@angular/core';
import {FormGroup, FormControl, Validators} from '@angular/forms';
import {Http} from '@angular/http';

@Component({
  selector: 'app-moncompte',
  templateUrl: './moncompte.component.html',
  styleUrls: ['./moncompte.component.css']
})
export class MoncompteComponent implements OnInit {

  form;
  moncompte = true;
  constructor(private http: Http) {}

  ngOnInit() {
    this.form = new FormGroup({
      password: new FormControl(''),
    });
  }
  updateuser(codeAlliance: string): Promise<User[]> {
    console.log('mcc ' + codeAlliance);
    return this.http.put('/api/users?codeAlliance=', codeAlliance)
      .toPromise()
      .then(response => response.json() as User[]).catch(this.handleError);
  }
  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}


