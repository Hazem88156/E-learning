import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Matiere } from '../Models/matiere';

@Injectable({
  providedIn: 'root',
})
export class MatiereServiceService {
  private matiere = new Matiere();
  constructor(private http: HttpClient) {}
  getMatiere(): Observable<any> {
    return this.http.get<any>('http://localhost:8081/api/matieres');
  }
  create(matiere: Object): Observable<any> {
    return this.http.post<Matiere>(
      'http://localhost:8081/api/matiere',
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
