import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Classe } from '../Models/classe';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ClasseServiceService {
  apiUrl = environment.apiUrl + "/classe";
  private classe = new Classe();

  constructor(private http: HttpClient) {}

  getClasse(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}`);
  }
  create(formData: FormData): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}`, formData);
  }
  updateClasse(formData: FormData, id: number): Observable<any> {
    return this.http.put<any>(
      `${this.apiUrl}/${id}`,
      formData
    );
  }

  setter(classe: Classe) {
    this.classe = classe;
  }
  getter() {
    return this.classe;
  }
  deleteClasse(id: number) {
    return this.http.delete(`${this.apiUrl}/deleteclasse/${id}`);
  }
  getClasseById(id: number): Observable<any> {
    return this.http.get<any>(
      `${this.apiUrl}/`+ id
    );
  }
}
