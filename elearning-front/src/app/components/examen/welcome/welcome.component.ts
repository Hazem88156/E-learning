import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Examen } from 'src/app/Models/examen';
import { Question } from 'src/app/Models/question';
import { ExamenServiceService } from 'src/app/services/examen-service.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css'],
})
export class WelcomeComponent implements OnInit {
  @ViewChild('name') nameKey!: ElementRef;
  id!: number;
  len!: number;
  firstName!: string;
  classe!: string;
  lastName!: string;
  examens!: Examen;
  examenName!: string;
  questionList!: Question[];
  constructor(
    private route: ActivatedRoute,
    private examenService: ExamenServiceService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.id = parseInt(this.route.snapshot.paramMap.get('id')!);
    this.firstName = String(localStorage.getItem('firstName'));
    this.classe = String(localStorage.getItem('classe'));
    this.lastName = String(localStorage.getItem('lastName'));

    this.examenService
      .getExamenById(this.id)
      .toPromise()
      .then((data) => {
        console.log(data);
        this.examens = data;
        this.examenName = this.examens.examenName;
        this.questionList = this.examens.questions;
        this.len = this.questionList.length;
      });
  }
  startQuiz() {
    //localStorage.setItem('name', this.nameKey.nativeElement.value);
    //localStorage.setItem('userId', this.nameKey.nativeElement.value);
  }
  PassExamen() {
    this.router.navigate(['pass-examen', this.id]);
  }
}
