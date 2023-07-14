import { Component, OnInit } from '@angular/core';
import {
  FormArray,
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Classe } from 'src/app/Models/classe';
import { Matiere } from 'src/app/Models/matiere';
import { User } from 'src/app/Models/users';
import { AuthServiceService } from 'src/app/services/auth-service.service';
import { ClasseServiceService } from 'src/app/services/classe-service.service';
import { MatiereServiceService } from 'src/app/services/matiere-service.service';

@Component({
  selector: 'app-add-classes',
  templateUrl: './add-classes.component.html',
  styleUrls: ['./add-classes.component.css'],
})
export class AddClassesComponent implements OnInit {
  users: User[] = [];
  matieres: Matiere[] = [];
  selected_users: User[] = [];
  selected_matieres: Matiere[] = [];
  classe: Classe = new Classe();
  submitted = false;
  reactiveForm!: FormGroup;
  constructor(
    private service: ClasseServiceService,
    private serviceUser: AuthServiceService,
    private serviceMatiere: MatiereServiceService,
    private fb: FormBuilder
  ) {this.reactiveForm = this.fb.group({
    nomClasse: ['', [Validators.required]],
    users: this.fb.array([]),
    matieres: this.fb.array([]),
  });}

  ngOnInit(): void {
    this.serviceUser
    .getUserStatusRoles('ACTIVE', 'PROFESSEUR')
    .toPromise()
    .then((users) => {
      console.log(users);
      this.users = users;
      // this.selected_users = users;
    });
  console.log(' liste users active' + this.users);
  this.serviceMatiere
    .getMatiere()
    .toPromise()
    .then((matieres) => {
      console.log(matieres);
      this.matieres = matieres;
    });
  console.log(' liste matieress' + this.matieres);
}
get f() {
  return this.reactiveForm.controls;
}
onCheckboxChange(e: any) {
  const userCheckArray: FormArray = this.reactiveForm.get(
    'users'
  ) as FormArray;
  if (e.target.checked) {
    console.log(userCheckArray.value);
    userCheckArray.push(new FormControl(e.target.value));
  } else {
    var i = 0;
    userCheckArray.controls.forEach((item: any) => {
      if (userCheckArray)
        if (item.value == e.target.value) {
          userCheckArray.removeAt(i);
          return;
        }
      i++;
    });
  }
  }
  onCheckboxChanges(e: any) {
    const userCheckArray: FormArray = this.reactiveForm.get(
      'matieres'
    ) as FormArray;
    if (e.target.checked) {
      console.log(userCheckArray.value);
      userCheckArray.push(new FormControl(e.target.value));
    } else {
      var i = 0;
      userCheckArray.controls.forEach((item: any) => {
        if (userCheckArray)
          if (item.value == e.target.value) {
            userCheckArray.removeAt(i);
            return;
          }
        i++;
      });
    }
  }
  _get_selected_users(classe: any) {
    let users_selected = [];
    for (const user_id in classe.users) {
      let id = classe.users[user_id];
      // chercher le user avec id #id
      let user = this.users.filter((user) => user.id == id)[0];
      users_selected.push(user);
    }
    return users_selected;
  }
  _get_selected_matieres(classe: any) {
    let matieres_selected = [];
    for (const matiere_id in classe.matieres) {
      let id = classe.matieres[matiere_id];
      // chercher le user avec id #id
      let matiere = this.matieres.filter((matiere) => matiere.id == id)[0];
      matieres_selected.push(matiere);
    }
    return matieres_selected;
  }
  saveForm(submitForm: FormGroup) {
    this.submitted = true;

    if (this.reactiveForm.invalid) {
      return;
    }
    if (submitForm.valid) {
      const classe = submitForm.value;
      var formData = new FormData();
      let users_selected = this._get_selected_users(classe);
      let matieres_selected = this._get_selected_matieres(classe);
      classe.users = users_selected;
      classe.matieres = matieres_selected;
      console.log(classe.users);
      var data = JSON.stringify(classe);
      console.log(data);

      formData.append('classe', data);

      this.service.create(formData).subscribe(
        (data) => {},
        (erreur) => {
          console.error(erreur);
        }
      );
    }
  }
}
