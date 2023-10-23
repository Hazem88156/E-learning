import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Classe } from 'src/app/Models/classe';
import { Cours } from 'src/app/Models/cours';
import { Matiere } from 'src/app/Models/matiere';
import { User } from 'src/app/Models/users';
import { AuthServiceService } from 'src/app/services/auth-service.service';
import { ClasseServiceService } from 'src/app/services/classe-service.service';
import { CoursServiceService } from 'src/app/services/cours-service.service';
import { MatiereServiceService } from 'src/app/services/matiere-service.service';

@Component({
  selector: 'app-add-cour',
  templateUrl: './add-cour.component.html',
  styleUrls: ['./add-cour.component.css'],
})
export class AddCourComponent implements OnInit {
  selectedCategoryId!: number;
  cour: Cours = new Cours();
 // users: User[] = [];
  //matieres: Matiere[] = [];
  //classes: Classe[] = [];
  submitted = false;
  reactiveForm!: FormGroup;
  constructor(
    private service: CoursServiceService,
    private serviceUser: AuthServiceService,
    private serviceMatiere: MatiereServiceService,
    private serviceClasse: ClasseServiceService,
    private fb: FormBuilder
  ) {
    this.reactiveForm = this.fb.group({
      nomCours: ['', [Validators.required]],
     // user: ['', [Validators.required]],
      //matiere: ['', [Validators.required]],
      //classe: ['', [Validators.required]],
    });
  }

  ngOnInit(): void {
   /* this.serviceUser
      .getUserStatusRoles('ACTIVE', 'PROFESSEUR')
      .toPromise()
      .then((users) => {
        console.log(users);
        this.users = users;
      });
    console.log(' liste users active' + this.users);
    this.serviceMatiere
      .getMatiere()
      .toPromise()
      .then((matieres) => {
        console.log(matieres);
        this.matieres = matieres;
      });
    console.log(' liste des matieres' + this.matieres);
    this.serviceClasse
      .getClasse()
      .toPromise()
      .then((classes) => {
        console.log(classes);
        this.classes = classes;
      });
    console.log(' liste des matieres' + this.matieres);*/
  }
  /*onselect(user: any) {
    this.users = user.id;
  }*/
  saveForm(submitForm: FormGroup) {
    this.submitted = true;

    if (this.reactiveForm.invalid) {
      return;
    }
    if (submitForm.valid) {
      const cour = submitForm.value as Cours;
     // cour.user = this.users.filter((u) => u.id == submitForm.value.user)[0];
     /* cour.matiere = this.matieres.filter(
        (m) => m.id == submitForm.value.matiere
      )[0];
      cour.classe = this.classes.filter(
        (c) => c.id == submitForm.value.classe
      )[0];*/
      var cours = JSON.stringify(cour);
      console.log(cours);

      var formData = new FormData();
      formData.append('cours', cours);

      this.service.create(formData).subscribe(
        (cours) => {
          console.log(cours);
        },
        (erreur) => {
          console.error(erreur);
        }
      );
    }
  }
}
