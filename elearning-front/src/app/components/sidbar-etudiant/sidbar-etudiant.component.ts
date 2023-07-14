import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cours } from 'src/app/Models/cours';
import { CoursServiceService } from 'src/app/services/cours-service.service';

@Component({
  selector: 'app-sidbar-etudiant',
  templateUrl: './sidbar-etudiant.component.html',
  styleUrls: ['./sidbar-etudiant.component.css'],
})
export class SidbarEtudiantComponent implements OnInit {
  roles!: string;
  nomClasse!: string;
  userid!: number;
  classeId!: number;
  cours: Cours[] = [];
  constructor(
    private serviceCours: CoursServiceService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.roles = String(localStorage.getItem('roles'));
    this.nomClasse = String(localStorage.getItem('nomClasse'));
    this.userid = Number(localStorage.getItem('userid'));
    this.classeId = Number(localStorage.getItem('classeId'));
    console.log('classe', this.classeId);
    this.serviceCours
      .getCoursByClasse(this.classeId)
      .toPromise()
      .then((cours) => {
        console.log(cours);
        this.cours = cours;
        console.log('cours', this.cours);
      });
    console.log(' liste cours' + this.cours);
  }
  CoursDocument(courid: number) {
    this.router.navigate(['coursDocument', courid]);
  }
  CourVedio(courid: number) {
    this.router.navigate(['coursVideo', courid]);
  }
  CoursDocumentVedio(courid: number) {
    this.router.navigate(['coursDocumentVedio', courid]);
  }
}
