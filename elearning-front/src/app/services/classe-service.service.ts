import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Classe } from '../Models/classe';

@Injectable({
  providedIn: 'root',
})
export class ClasseServiceService {
  private classe = new Classe();

  constructor(private http: HttpClient) {}

  getClasse(): Observable<any> {
    return this.http.get<any>('http://localhost:8081/api/classe');
  }
  create(formData: FormData): Observable<any> {
    return this.http.post<any>('http://localhost:8081/api/classes', formData);
  }
  updateClasse(formData: FormData, id: number): Observable<any> {
    return this.http.put<any>(
      `http://localhost:8081/api/classesss/${id}`,
      formData
    );
  }

  setter(classe: Classe) {
    this.classe = classe;
  }
  getter() {
    return this.classe;
  }
}
