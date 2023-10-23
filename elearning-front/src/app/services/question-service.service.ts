import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Question } from '../Models/question';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class QuestionServiceService {
  apiUrl = environment.apiUrl;
  constructor(private http: HttpClient) {}

  getQuestions(): Observable<Question[]> {
    return this.http.get<Question[]>(`${this.apiUrl}/question`);
  }

  addQuestion(question: Question): Observable<Question> {
    return this.http.post<Question>(
      `${this.apiUrl}/question`,
      question
    );
  }
}
