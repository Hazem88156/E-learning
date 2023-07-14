import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Resultat } from '../Models/resultat';

@Injectable({
  providedIn: 'root',
})
export class ResultatServiceService {
  constructor(private http: HttpClient) {}

  addResultat(resultat: Resultat): Observable<Resultat> {
    return this.http.post<Resultat>(
      'http://localhost:8081/api/resultat',
      resultat
    );
  }
}
