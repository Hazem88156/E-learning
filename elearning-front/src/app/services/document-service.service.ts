import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class DocumentServiceService {
  constructor(private http: HttpClient) {}

  createDocument(formData: FormData): Observable<any> {
    return this.http.post<any>(`http://localhost:8081/api/documents`, formData);
  }
  getDocument(): Observable<any> {
    return this.http.get<any>('http://localhost:8081/api/document');
  }
  getDocumentById(id: number): Observable<any> {
    return this.http.get<any>('http://localhost:8081/api/documentdetail/' + id);
  }
  getDocumentByUserId(userId: number): Observable<any> {
    return this.http.get<any>('http://localhost:8081/api/document/' + userId);
  }
  getDocumentByCoursId(coursId: number): Observable<any> {
    return this.http.get<any>(
      'http://localhost:8081/api/documents/cours/' + coursId
    );
  }
}
