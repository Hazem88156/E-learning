import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cours } from 'src/app/Models/cours';
import { CoursServiceService } from 'src/app/services/cours-service.service';

@Component({
  selector: 'app-list-cour',
  templateUrl: './list-cour.component.html',
  styleUrls: ['./list-cour.component.css'],
})
export class ListCourComponent implements OnInit {
  cours: Cours[] = [];
  constructor(
    private serviceCours: CoursServiceService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.serviceCours
      .getCours()
      .toPromise()
      .then((cours) => {
        console.log(cours);
        this.cours = cours;
      });
    console.log(' liste cours' + this.cours);
  }
  updateCour(courid: number) {
    this.router.navigate(['update-cour', courid]);
  }
  key = 'id';
  reverse: boolean = false;
  sort(key: any) {
    this.key = key;
    this.reverse = !this.reverse;
  }
}
