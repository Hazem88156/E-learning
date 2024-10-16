import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Classe } from 'src/app/Models/classe';
import { ClasseServiceService } from 'src/app/services/classe-service.service';

@Component({
  selector: 'app-list-classes',
  templateUrl: './list-classes.component.html',
  styleUrls: ['./list-classes.component.css'],
})
export class ListClassesComponent implements OnInit {
  constructor(
    private service: ClasseServiceService,
    private router: Router,
    private route: ActivatedRoute
  ) {}
  classeId!: any;
  classes: Classe[] = [];
  ngOnInit(): void {
    this.service
      .getClasse()
      .toPromise()
      .then((classes) => {
        console.log(classes);
        this.classes = classes;
      })
      .catch((error) => console.log(error));
    console.log(' liste classess' + this.classes);
  }
  updateClasse(classe: any) {
    this.service.setter(classe);
    this.router.navigate(['update-classes']);
  }
}
