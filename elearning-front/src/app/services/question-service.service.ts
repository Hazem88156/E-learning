import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Question } from '../Models/question';

@Injectable({
  providedIn: 'root',
})
export class QuestionServiceService {
  constructor(private http: HttpClient) {}

  getQuestions(): Observable<Question[]> {
    return this.http.get<Question[]>('http://localhost:8081/api/question');
  }

  addQuestion(question: Question): Observable<Question> {
    return this.http.post<Question>(
      'http://localhost:8081/api/question',
      question
    );
  }
}
