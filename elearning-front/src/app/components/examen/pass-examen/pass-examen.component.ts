import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { interval } from 'rxjs';
import { Examen } from 'src/app/Models/examen';
import { Question } from 'src/app/Models/question';
import { Resultat } from 'src/app/Models/resultat';
import { ExamenServiceService } from 'src/app/services/examen-service.service';
import { ResultatServiceService } from 'src/app/services/resultat-service.service';

@Component({
  selector: 'app-pass-examen',
  templateUrl: './pass-examen.component.html',
  styleUrls: ['./pass-examen.component.css'],
})
export class PassExamenComponent implements OnInit {
  public name: string = '';
  public questionList: Question[] = [];
  public currentQuestion: number = 0;
  public points: number = 0;
  counter = 60;
  id!: number;
  examens!: Examen;
  correctAnswer: number = 0;
  inCorrectAnswer: number = 0;
  interval$: any;
  progress: string = '0';
  isQuizCompleted: boolean = false;
  resultatForm!: FormGroup;
  constructor(
    private resultatService: ResultatServiceService,
    private examenService: ExamenServiceService,
    private formBuilder: FormBuilder,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.name =
      localStorage.getItem('firstName') +
      '' +
      localStorage.getItem('firstName');
    // this.getAllQuestions();
    this.startCounter();
    this.id = parseInt(this.route.snapshot.paramMap.get('id')!);
    this.examenService
      .getExamenById(this.id)
      .toPromise()
      .then((data) => {
        console.log(data);
        this.examens = data;
        this.questionList = this.examens.questions;
      });
    this.initResultatForm();
  }
  initResultatForm(): void {
    this.resultatForm = this.formBuilder.group({
      etudiant: this.formBuilder.group({
        id: [localStorage.getItem('userid'), Validators.required],
      }),
      point: [this.points, Validators.required],
    });
  }
  getAllQuestions() {
    this.id = parseInt(this.route.snapshot.paramMap.get('id')!);
    this.examenService
      .getExamenById(this.id)
      .toPromise()
      .then((data) => {
        console.log(data);
        this.examens = data;
        this.questionList = this.examens.questions;
      });
  }

  nextQuestion() {
    this.currentQuestion++;
  }
  previousQuestion() {
    this.currentQuestion--;
  }
  answer(currentQno: number, option: any) {
    if (currentQno === this.questionList.length) {
      this.isQuizCompleted = true;
      this.stopCounter();
    }
    if (option.correct) {
      this.points += 10;
      this.correctAnswer++;
      setTimeout(() => {
        this.currentQuestion++;
        this.resetCounter();
        this.getProgressPercent();
      }, 1000);
    } else {
      setTimeout(() => {
        this.currentQuestion++;
        this.inCorrectAnswer++;
        this.resetCounter();
        this.getProgressPercent();
      }, 1000);

      this.points -= 10;
    }
  }
  startCounter() {
    this.interval$ = interval(1000).subscribe((val) => {
      this.counter--;
      if (this.counter === 0) {
        this.currentQuestion++;
        this.counter = 60;
        this.points -= 10;
      }
    });
    setTimeout(() => {
      this.interval$.unsubscribe();
    }, 600000);
  }
  stopCounter() {
    this.interval$.unsubscribe();
    this.counter = 0;
  }
  resetCounter() {
    this.stopCounter();
    this.counter = 60;
    this.startCounter();
  }
  resetQuiz() {
    this.resetCounter();
    this.getAllQuestions();
    this.points = 0;
    this.counter = 60;
    this.currentQuestion = 0;
    this.progress = '0';
  }
  getProgressPercent() {
    this.progress = (
      (this.currentQuestion / this.questionList.length) *
      100
    ).toString();
    return this.progress;
  }
  submitResultat(): void {
    if (this.resultatForm.valid) {
      const resultat: Resultat = this.resultatForm.value as Resultat;

      this.resultatService.addResultat(resultat).subscribe(
        (response) => {
          console.log('Examen added successfully:', response);
          this.resultatForm.reset();
          //localStorage.setItem('examen', String(response.id));
          //this.router.navigate(['/add-question']);
        },
        (error) => {
          console.error('Error adding examen:', error);
        }
      );
    }
  }
}
