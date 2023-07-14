import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Classe } from 'src/app/Models/classe';
import { User } from 'src/app/Models/users';
import { AuthServiceService } from 'src/app/services/auth-service.service';
import { ClasseServiceService } from 'src/app/services/classe-service.service';

@Component({
  selector: 'app-update-etudiant',
  templateUrl: './update-etudiant.component.html',
  styleUrls: ['./update-etudiant.component.css'],
})
export class UpdateEtudiantComponent implements OnInit {
  id!: number;
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
  classes!: Classe[];
  selectedClasse: Classe = new Classe();
  error = '';
  pwdd!: string;
  loading = false;
  submitted = false;
  public userFile: any = File;
  public imagePath: any;
  imgURL: any;
  public message: string | undefined;
  reactiveForm: FormGroup;
  passwordMatchValidator: any;
  constructor(
    public service: AuthServiceService,
    public fb: FormBuilder,
    private router: Router,
    private serviceClasse: ClasseServiceService,
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
      classesEtudiant: [null, [Validators.required]],
    });
  }

  ngOnInit(): void {
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
        //console.log(this.users.classes);
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
          classesEtudiant: [this.users.classesEtudiant, [Validators.required]],
        });

        //this.id = this.route.snapshot.paramMap.get('id');
        console.log(this.reactiveForm.controls);
        this.otherSelected();
      });
  }
  otherSelected() {
    this.serviceClasse
      .getClasse()
      .toPromise()
      .then((classes) => {
        this.classes = classes;
        console.log(this.users, 'hhhh');
        if (this.users.classesEtudiant != null) {
          this.selectedClasse = this.classes.filter(
            (c: Classe) => c.id == this.users.classesEtudiant.id
          )[0];
          console.log('hhhhsss');
        }
        console.log(this.selectedClasse);
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
  updateForm(submitForm: FormGroup) {
    this.submitted = true;

    if (this.reactiveForm.invalid) {
      console.log('user');
      return;
    }
    if (submitForm.valid) {
      const user = submitForm.value;
      user.classesEtudiant = this.classes.filter(
        (c) => c.id == this.reactiveForm.value.classesEtudiant
      )[0];
      var formData = new FormData();
      formData.append('file', this.userFile);
      formData.append('user', JSON.stringify(user));
      this.service.updateEtudiant(formData, this.users.id).subscribe(
        (data) => {
          console.log(data);
        },
        (erreur) => {
          console.error(erreur);
        }
      );
    }
  }
  isClasseSelected(classe: Classe) {
    var isSelected =
      this.users.classesEtudiant != null &&
      this.users.classesEtudiant.id == classe.id;
    return isSelected;
  }
}
