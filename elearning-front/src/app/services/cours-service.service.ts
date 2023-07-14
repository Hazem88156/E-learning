import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CoursServiceService {
  constructor(private http: HttpClient) {}
  create(formData: FormData): Observable<any> {
    return this.http.post<any>('http://localhost:8081/api/cours', formData);
  }
  getCours(): Observable<any> {
    return this.http.get<any>('http://localhost:8081/api/cour');
  }
  getCoursById(id: number): Observable<any> {
    return this.http.get<any>('http://localhost:8081/api/coursdetail/' + id);
  }
  updateCours(formData: FormData, id: number): Observable<any> {
    return this.http.put<any>(
      `http://localhost:8081/api/courss/${id}`,
      formData
    );
  }
  getCoursByUser(userId: number) {
    return this.http.get<any>('http://localhost:8081/api/cour/user/' + userId);
  }
  getCoursByClasse(classeId: number) {
    return this.http.get<any>(
      'http://localhost:8081/api/cour/classe/' + classeId
    );
  }
}
