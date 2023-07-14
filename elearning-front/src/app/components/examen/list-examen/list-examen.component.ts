import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Examen } from 'src/app/Models/examen';
import { ExamenServiceService } from 'src/app/services/examen-service.service';

@Component({
  selector: 'app-list-examen',
  templateUrl: './list-examen.component.html',
  styleUrls: ['./list-examen.component.css'],
})
export class ListExamenComponent implements OnInit {
  examens: Examen[] = [];
  constructor(private service: ExamenServiceService, private router: Router) {}

  ngOnInit(): void {
    this.service
      .getExamen()
      .toPromise()
      .then((examens) => {
        console.log(examens);
        this.examens = examens;
      });
    console.log(' liste examens' + this.examens);
  }
  welcomeExamen(id: number) {
    this.router.navigate(['welcome', id]);
  }
}
