import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class DocumentServiceService {
  apiUrl = environment.apiUrl;
  constructor(private http: HttpClient) {}

  createDocument(formData: FormData): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/documents`, formData);
  }
  getDocument(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/document`);
  }
  getDocumentById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/documentdetail/` + id);
  }
  getDocumentByUserId(userId: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/document/` + userId);
  }
  getDocumentByCoursId(coursId: number): Observable<any> {
    return this.http.get<any>(
      `${this.apiUrl}/documents/cours/` + coursId
    );
  }
}
