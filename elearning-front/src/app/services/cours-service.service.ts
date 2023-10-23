import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class CoursServiceService {
  apiUrl = environment.apiUrl;
  constructor(private http: HttpClient) {}
  create(formData: FormData): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/cours`, formData);
  }
  getCours(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/cour`);
  }
  getCoursById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/coursdetail/` + id);
  }
  updateCours(formData: FormData, id: number): Observable<any> {
    return this.http.put<any>(
      `${this.apiUrl}/courss/${id}`,
      formData
    );
  }
  getCoursByUser(userId: number) {
    return this.http.get<any>(`${this.apiUrl}/cour/user/` + userId);
  }
  getCoursByClasse(classeId: number) {
    return this.http.get<any>(
      `${this.apiUrl}/cour/classe/` + classeId
    );
  }
}
