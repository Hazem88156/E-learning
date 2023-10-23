import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Resultat } from '../Models/resultat';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ResultatServiceService {
  apiUrl = environment.apiUrl;
  constructor(private http: HttpClient) {}

  addResultat(resultat: Resultat): Observable<Resultat> {
    return this.http.post<Resultat>(
      `${this.apiUrl}/resultat`,
      resultat
    );
  }
}
