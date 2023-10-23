import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Observable } from 'rxjs';
import { Examen } from '../Models/examen';
import { Question } from '../Models/question';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ExamenServiceService {
  apiUrl = environment.apiUrl;
  constructor(private http: HttpClient) {}
  getQuestions(): Observable<Examen[]> {
    return this.http.get<Examen[]>(`${this.apiUrl}/examen`);
  }

  addExamen(examen: Examen): Observable<Examen> {
    return this.http.post<Examen>(`${this.apiUrl}/examen`, examen);
  }
  getExamenById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/examendetail/` + id);
  }
  updateExamens(formData: FormData, id: number): Observable<any> {
    return this.http.put<any>(
      `${this.apiUrl}/examen/${id}`,
      formData
    );
  }

  getExamen(): Observable<any> {
    return this.http.get<any>('http://localhost:8081/api/examen');
  }

  getQuestionJson() {
    return this.http.get<any>('assets/questions.json');
  }
  getExamenByCoursId(coursId: number): Observable<any> {
    return this.http.get<any>(
      'http://localhost:8081/api/examens/cours/' + coursId
    );
  }
}
