import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Classe } from 'src/app/Models/classe';
import { ClasseServiceService } from 'src/app/services/classe-service.service';

@Component({
  selector: 'app-list-classe',
  templateUrl: './list-classe.component.html',
  styleUrls: ['./list-classe.component.css'],
})
export class ListClasseComponent implements OnInit {
  p: number = 1;
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
  updateUser(userid: number) {
    this.router.navigate(['edit-professeur', userid]);
  }
  updateClasse(classeid: number) {
    this.router.navigate(['update-classe',classeid]);
  }
  key = 'id';
  reverse: boolean = false;
  sort(key: any) {
    this.key = key;
    this.reverse = !this.reverse;
  }
  deleteClasse(id: number) {
    this.service.deleteClasse(id).subscribe(() => {
      // Mettre à jour la liste des classes après suppression
      this.classes = this.classes.filter(classe => classe.id !== id);
    });
  }

}
