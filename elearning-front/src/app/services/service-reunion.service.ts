import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ServiceReunionService {
  constructor(private http: HttpClient) {}

  create(formData: FormData): Observable<any> {
    return this.http.post<any>('http://localhost:8081/api/reunions', formData);
  }
  getReunion(): Observable<any> {
    return this.http.get<any>('http://localhost:8081/api/reunion');
  }
  getReunionById(id: number): Observable<any> {
    return this.http.get<any>('http://localhost:8081/api/reuniono/' + id);
  }
}
