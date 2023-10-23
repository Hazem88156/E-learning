import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ServiceReunionService {
  apiUrl = environment.apiUrl;
  constructor(private http: HttpClient) {}

  create(formData: FormData): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/reunions`, formData);
  }
  getReunion(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/reunion`);
  }
  getReunionById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/reuniono/` + id);
  }
}
