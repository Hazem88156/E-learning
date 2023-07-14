import { Component, OnInit } from '@angular/core';
import {
  FormArray,
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Classe } from 'src/app/Models/classe';
import { Matiere } from 'src/app/Models/matiere';
import { User } from 'src/app/Models/users';
import { AuthServiceService } from 'src/app/services/auth-service.service';
import { ClasseServiceService } from 'src/app/services/classe-service.service';
import { MatiereServiceService } from 'src/app/services/matiere-service.service';

@Component({
  selector: 'app-update-professeur',
  templateUrl: './update-professeur.component.html',
  styleUrls: ['./update-professeur.component.css'],
})
export class UpdateProfesseurComponent implements OnInit {
  userid!: number;
  firstName!: string;
  lastName!: string;
  roles!: string;
  email!: string;
  telephone!: string;
  addresse!: string;
  username!: string;
  password!: string;
  ncin!: string;
  apropos!: string;
  users: User = new User();
  error = '';
  pwdd!: string;
  loading = false;
  submitted = false;
  public userFile: any = File;
  public imagePath: any;
  matieres!: Matiere[];
  classes!: Classe[];
  imgURL: any;
  public message: string | undefined;
  reactiveForm!: FormGroup;
  passwordMatchValidator: any;
  matids: number[] = [];
  classeids: number[] = [];
  id!: number;
  constructor(
    public service: AuthServiceService,
    private serviceMatiere: MatiereServiceService,
    private serviceClasse: ClasseServiceService,
    public fb: FormBuilder,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.reactiveForm = this.fb.group({
      firstName: ['', [Validators.required]],
      lastName: ['', [Validators.required]],
      telephone: ['', [Validators.required]],
      ncin: ['', [Validators.required]],
      email: ['', [Validators.required]],
      apropos: ['', [Validators.required]],
      password: new FormControl('', Validators.required),
      status: ['', [Validators.required]],
      roles: ['', [Validators.required]],
      matieres: this.fb.array([this.createMatiere(new Matiere())]),
    });
    //this.id = this.route.snapshot.paramMap.get('id');
  }

  ngOnInit(): void {
    this.serviceMatiere
      .getMatiere()
      .toPromise()
      .then((matieres) => {
        this.matieres = matieres;
      });
    this.serviceClasse
      .getClasse()
      .toPromise()
      .then((classes) => {
        this.classes = classes;
      });
    var id = this.route.snapshot.paramMap.get('id');
    if (!id) return;
    this.id = parseInt(id);
    this.service
      .getUserById(this.id)
      .toPromise()
      .then((data) => {
        console.log(data);
        this.users = data;
        console.log(this.users.matieres);
        // console.log(this.users.classes);
        this.reactiveForm = this.fb.group({
          firstName: [this.users.firstName, [Validators.required]],
          lastName: [this.users.lastName, [Validators.required]],
          telephone: [this.users.telephone, [Validators.required]],
          ncin: [this.users.ncin, [Validators.required]],
          email: [this.users.email, [Validators.required]],
          apropos: [this.users.apropos, [Validators.required]],
          password: new FormControl(this.users.password, Validators.required),
          status: [this.users.status, [Validators.required]],
          roles: [this.users.roles, [Validators.required]],
          matieres: this.fb.array(
            this.users.matieres &&
              this.users.matieres.map((matiere: Matiere) =>
                this.createMatiere(matiere)
              )
          ),
        });
        //this.id = this.route.snapshot.paramMap.get('id');
        console.log(this.reactiveForm.controls);
      });
  }
  get f() {
    return this.reactiveForm.controls;
  }
  onSelectFile(event: any) {
    const file = event.target.files[0];
    this.userFile = file;
    var mimeType = event.target.files[0].type;
    if (mimeType.match(/image\/*/) == null) {
      this.message = 'Only images are supported.';
      return;
    }
    var reader = new FileReader();

    this.imagePath = file;
    reader.readAsDataURL(file);
    reader.onload = (_event) => {
      this.imgURL = reader.result;
    };
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
      const user = this.reactiveForm.value;
      var data = JSON.stringify(user);
      var formData = new FormData();
      formData.append('file', this.userFile);
      formData.append('user', data);
      console.log(formData);
      this.service.updateUser(formData, this.users.id).subscribe(
        (data) => {
          console.log('hhhhhhhhh', data);
        },
        (erreur) => {
          console.error(erreur);
        }
      );
    }
  }
  createMatiere(matiere: Matiere): FormGroup {
    return this.fb.group({
      id: [matiere.id],
      nomMatiere: [matiere.nomMatiere],
    });
  }
  createClasse(classe: Classe): FormGroup {
    return this.fb.group({
      id: [classe.id],
      nomClasse: [classe.nomClasse],
      matieres: [classe.matieres],
    });
  }
  /*isSelectedMatiere(matId: number) {
    // return this.users.matieres.map((mat) => mat['id']).includes(matId);
    return false;
  }
  isSelectedClasse(classeId: number) {
    if (this.users && this.users.classes) {
      return this.users.classes.map((klass) => klass['id']).includes(classeId);
    } else {
      return false;
    }
  }*/
}
