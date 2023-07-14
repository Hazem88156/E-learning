import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cours } from 'src/app/Models/cours';
import { CoursServiceService } from 'src/app/services/cours-service.service';

@Component({
  selector: 'app-cours-document-vedio',
  templateUrl: './cours-document-vedio.component.html',
  styleUrls: ['./cours-document-vedio.component.css'],
})
export class CoursDocumentVedioComponent implements OnInit {
  id!: number;
  cours!: Cours;
  nomCours!: string;
  constructor(
    private service: CoursServiceService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    var id = this.route.snapshot.paramMap.get('id');
    if (!id) return;
    this.id = parseInt(id);
    this.service
      .getCoursById(this.id)
      .toPromise()
      .then((data) => {
        console.log(data);
        this.cours = data;
        this.nomCours = this.cours.nomCours;

        console.log('cours', this.nomCours);
      });
  }

  CoursVideo() {
    this.router.navigate([
      'coursVideo',
      parseInt(this.route.snapshot.paramMap.get('id')!),
    ]);
  }
  CoursDocument() {
    this.router.navigate([
      'coursDocument',
      parseInt(this.route.snapshot.paramMap.get('id')!),
    ]);
  }
  CoursExamen() {
    this.router.navigate([
      'coursExamen',
      parseInt(this.route.snapshot.paramMap.get('id')!),
    ]);
  }
}
