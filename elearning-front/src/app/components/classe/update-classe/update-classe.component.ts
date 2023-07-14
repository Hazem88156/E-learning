import { Component, OnInit } from '@angular/core';
import {
  FormArray,
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { ActivatedRoute, Params } from '@angular/router';
import { Classe } from 'src/app/Models/classe';
import { Matiere } from 'src/app/Models/matiere';
import { User } from 'src/app/Models/users';
import { AuthServiceService } from 'src/app/services/auth-service.service';
import { ClasseServiceService } from 'src/app/services/classe-service.service';
import { MatiereServiceService } from 'src/app/services/matiere-service.service';

@Component({
  selector: 'app-update-classe',
  templateUrl: './update-classe.component.html',
  styleUrls: ['./update-classe.component.css'],
})
export class UpdateClasseComponent implements OnInit {
  firstName!: string;
  lastName!: string;
  nomClasse!: string;
  users!: User[];
  matieres!: Matiere[];
  users_id!: number;
  selected_users: User[] = [];
  matieres_selected: Matiere[] = [];

  classe: Classe = new Classe();
  submitted = false;
  reactiveForm!: FormGroup;
  uids: number[] = [];
  matids: number[] = [];

  constructor(
    private service: ClasseServiceService,
    private serviceUser: AuthServiceService,
    private serviceMatiere: MatiereServiceService,
    private activeRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.classe = this.service.getter();
    this.uids = this.classe.users.map((u: User) => u.id);
    this.matids = this.classe.matieres.map((m: Matiere) => m.id);
    this.serviceUser
      .getUserStatusRoles('ACTIVE', 'PROFESSEUR')
      .toPromise()
      .then((users) => {
        this.users = users;
        this.selected_users = users;
      });
    this.serviceMatiere
      .getMatiere()
      .toPromise()
      .then((matieres) => {
        this.matieres = matieres;
      });
    this.reactiveForm = this.fb.group({
      nomClasse: [this.classe.nomClasse, [Validators.required]],
      users: this.fb.array(
        this.classe.users &&
          this.classe.users.map((user: User) => this.createUser(user))
      ),
      matieres: this.fb.array(
        this.classe.matieres &&
          this.classe.matieres.map((matiere: Matiere) =>
            this.createMatiere(matiere)
          )
      ),
    });
  }
  get f() {
    return this.reactiveForm.controls;
  }
  onCheckboxChange(e: any) {
    const userCheckArray: FormArray = this.reactiveForm.get(
      'users'
    ) as FormArray;
    const user = this.users.filter((u) => u.id == e.target.value)[0];
    if (e.target.checked) {
      console.log(userCheckArray.value);
      const userControl = this.createUser(user);
      userCheckArray.push(userControl);
    } else {
      var i = -1;
      for (let index = 0; index < userCheckArray.controls.length; index++) {
        const item = userCheckArray.controls[index];
        if (userCheckArray)
          if (item.value['id'] == e.target.value) {
            i = index;
          }
      }
      if (i >= 0) userCheckArray.removeAt(i);
    }
    this.reactiveForm.setControl('users', userCheckArray);
    console.log(this.reactiveForm.value);
  }
  onCheckboxChanges(e: any) {
    const matiereCheckArray: FormArray = this.reactiveForm.get(
      'matieres'
    ) as FormArray;
    const matiere = this.matieres.filter((m) => m.id == e.target.value)[0];
    if (e.target.checked) {
      const matControl = this.createMatiere(matiere);
      matiereCheckArray.push(matControl);
    } else {
      var i = -1;
      for (let index = 0; index < matiereCheckArray.controls.length; index++) {
        const item = matiereCheckArray.controls[index];
        if (matiereCheckArray)
          if (item.value['id'] == e.target.value) {
            i = index;
          }
      }
      if (i >= 0) matiereCheckArray.removeAt(i);
    }
    this.reactiveForm.setControl('matieres', matiereCheckArray);
    console.log(this.reactiveForm.value);
  }

  updateForm() {
    this.submitted = true;
    if (this.reactiveForm.invalid) {
      return;
    }
    if (this.reactiveForm.valid) {
      const classe = this.reactiveForm.value;
      console.log(classe);

      var data = JSON.stringify(classe);
      var formData = new FormData();
      formData.append('classe', data);
      this.service.updateClasse(formData, this.classe.id).subscribe(
        (data) => {
          console.log(data);
        },
        (erreur) => {
          console.error(erreur);
        }
      );
    }
  }

  createUser(user: User): FormGroup {
    return this.fb.group({
      id: [user.id],
      firstName: [user.firstName],
      lastName: [user.lastName],
      roles: [user.roles],
      status: [user.status],
      telephone: [user.telephone],
      password: [user.password],
      apropos: [user.apropos],
      imgfile: [user.imgfile],
      addresse: [user.addresse],
      email: [user.email],
      ncin: [user.ncin],
    });
  }
  createMatiere(matiere: Matiere): FormGroup {
    return this.fb.group({
      id: [matiere.id],
      nomMatiere: [matiere.nomMatiere],
    });
  }
  isSelectedUser(userId: number) {
    return this.uids.includes(userId);
  }
  isSelectedMatiere(matId: number) {
    return this.matids.includes(matId);
  }
}
