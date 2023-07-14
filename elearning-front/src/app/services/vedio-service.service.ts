import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class VedioServiceService {
  constructor(private http: HttpClient) {}
  createVedio(formData: FormData): Observable<any> {
    return this.http.post<any>(`http://localhost:8081/api/vedios`, formData);
  }
  getVedio(): Observable<any> {
    return this.http.get<any>('http://localhost:8081/api/vedio');
  }
  getVedioById(id: number): Observable<any> {
    return this.http.get<any>('http://localhost:8081/api/vediodetail/' + id);
  }
  getVedioByUserId(userId: number): Observable<any> {
    return this.http.get<any>('http://localhost:8081/api/vedio/' + userId);
  }
  getVideoByCoursId(coursId: number): Observable<any> {
    return this.http.get<any>(
      'http://localhost:8081/api/vedios/cours/' + coursId
    );
  }
}
