import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class VedioServiceService {
  apiUrl = environment.apiUrl;
  constructor(private http: HttpClient) {}
  createVedio(formData: FormData): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/vedios`, formData);
  }
  getVedio(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/vedio`);
  }
  getVedioById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/vediodetail/`+ id);
  }
  getVedioByUserId(userId: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/vedio/`+ userId);
  }
  getVideoByCoursId(coursId: number): Observable<any> {
    return this.http.get<any>(
      `${this.apiUrl}/vedios/cours/` + coursId
    );
  }
}
