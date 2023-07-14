import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Examen } from 'src/app/Models/examen';
import { ExamenServiceService } from 'src/app/services/examen-service.service';

@Component({
  selector: 'app-cours-examen',
  templateUrl: './cours-examen.component.html',
  styleUrls: ['./cours-examen.component.css'],
})
export class CoursExamenComponent implements OnInit {
  id!: number;
  examens: Examen[] = [];
  constructor(
    private service: ExamenServiceService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    var id = this.route.snapshot.paramMap.get('id');
    if (!id) return;
    this.id = parseInt(id);
    this.service
      .getExamenByCoursId(this.id)
      .toPromise()
      .then((data) => {
        console.log(data);
        this.examens = data;
      });
  }
}
