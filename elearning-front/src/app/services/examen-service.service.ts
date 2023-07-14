import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Observable } from 'rxjs';
import { Examen } from '../Models/examen';
import { Question } from '../Models/question';

@Injectable({
  providedIn: 'root',
})
export class ExamenServiceService {
  constructor(private http: HttpClient) {}
  getQuestions(): Observable<Examen[]> {
    return this.http.get<Examen[]>('http://localhost:8081/api/examen');
  }

  addExamen(examen: Examen): Observable<Examen> {
    return this.http.post<Examen>('http://localhost:8081/api/examen', examen);
  }
  getExamenById(id: number): Observable<any> {
    return this.http.get<any>('http://localhost:8081/api/examendetail/' + id);
  }
  updateExamens(formData: FormData, id: number): Observable<any> {
    return this.http.put<any>(
      `http://localhost:8081/api/examen/${id}`,
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
