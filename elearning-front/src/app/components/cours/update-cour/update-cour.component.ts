import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Classe } from 'src/app/Models/classe';
import { Cours } from 'src/app/Models/cours';
import { Matiere } from 'src/app/Models/matiere';
import { User } from 'src/app/Models/users';
import { AuthServiceService } from 'src/app/services/auth-service.service';
import { ClasseServiceService } from 'src/app/services/classe-service.service';
import { CoursServiceService } from 'src/app/services/cours-service.service';
import { MatiereServiceService } from 'src/app/services/matiere-service.service';

@Component({
  selector: 'app-update-cour',
  templateUrl: './update-cour.component.html',
  styleUrls: ['./update-cour.component.css'],
})
export class UpdateCourComponent implements OnInit {
  cours: Cours = new Cours();
  id!: number;
  users: User[] = [];
  matieres: Matiere[] = [];
  classes: Classe[] = [];
  submitted = false;
  reactiveForm!: FormGroup;
  selectedUser: User = new User();
  selectedMatiere: Matiere = new Matiere();
  selectedClasse: Classe = new Classe();
  constructor(
    private service: CoursServiceService,
    private serviceUser: AuthServiceService,
    private serviceMatiere: MatiereServiceService,
    private serviceClasse: ClasseServiceService,
    private fb: FormBuilder,
    private route: ActivatedRoute
  ) {
    this.reactiveForm = this.fb.group({
      nomCours: ['', [Validators.required]],
      matiere: [null, [Validators.required]],
      classe: [null, [Validators.required]],
      user: [null, [Validators.required]],
    });
  }

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
        //console.log(this.cours.matiere);
        //console.log(this.cours.classe);
        this.reactiveForm = this.fb.group({
          nomCours: [this.cours.nomCours, [Validators.required]],
         // matiere: [this.cours.matiere, [Validators.required]],
         // classe: [this.cours.classe, [Validators.required]],
          //user: [this.cours.user, [Validators.required]],
        });
        console.log(this.reactiveForm.controls);
        this.getOtherInfo();
      });
  }
  getOtherInfo() {
   /* this.serviceMatiere
      .getMatiere()
      .toPromise()
      .then((matieres) => {
        this.matieres = matieres;
        this.selectedMatiere = this.matieres.filter(
          (m: Matiere) => m.id == this.cours.matiere.id
        )[0];
      });
    this.serviceUser
      .getUserStatusRoles('ACTIVE', 'PROFESSEUR')
      .toPromise()
      .then((users) => {
        this.users = users;
        this.selectedUser = this.users.filter(
          (u: User) => u.id == this.cours.user.id
        )[0];
      });
    this.serviceClasse
      .getClasse()
      .toPromise()
      .then((classes) => {
        this.classes = classes;
        this.selectedClasse = this.classes.filter(
          (c: Classe) => c.id == this.cours.classe.id
        )[0];
      });*/
  }
  updateForm(submitForm: FormGroup) {
    this.submitted = true;
    if (this.reactiveForm.invalid) {
      return;
    }
    if (this.reactiveForm.valid) {
      console.log(this.reactiveForm.value);
      const cour = this.reactiveForm.value as Cours;
     /* cour.user = this.users.filter(
        (u) => u.id == this.reactiveForm.value.user
      )[0];*/
      /*cour.matiere = this.matieres.filter(
        (m) => m.id == this.reactiveForm.value.matiere
      )[0];*/
      /*cour.classe = this.classes.filter(
        (c) => c.id == this.reactiveForm.value.classe
      )[0];*/

      console.log(cour);

      var formData = new FormData();
      var cours = JSON.stringify(cour);
      console.log(cours);
      formData.append('cour', cours);
      console.log(formData);
      console.log(this.cours.id);

      this.service.updateCours(formData, this.cours.id).subscribe(
        (data) => {
          console.log('hhhhhhhhh', data);
        },
        (erreur) => {
          console.error(erreur);
        }
      );
    }
  }

  isMatiereSelected(matiere: Matiere) {
    /*var isSelected =
      this.cours.matiere != null && this.cours.matiere.id == matiere.id;
    return isSelected;*/
  }
  isClasseSelected(classe: Classe) {
   /* var isSelected =
      this.cours.classe != null && this.cours.classe.id == classe.id;
    return isSelected;*/
  }
}
