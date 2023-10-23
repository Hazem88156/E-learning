import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Matiere } from '../Models/matiere';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class MatiereServiceService {
  apiUrl = environment.apiUrl;
  private matiere = new Matiere();
  constructor(private http: HttpClient) {}
  getMatiere(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/matieres`);
  }
  create(matiere: Object): Observable<any> {
    return this.http.post<Matiere>(
      `${this.apiUrl}/matiere`,
      matiere
    );
  }
  setter(matiere: Matiere) {
    this.matiere = matiere;
  }
  getter() {
    return this.matiere;
  }
}
