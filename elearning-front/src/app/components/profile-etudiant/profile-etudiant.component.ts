import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthServiceService } from 'src/app/services/auth-service.service';

@Component({
  selector: 'app-profile-etudiant',
  templateUrl: './profile-etudiant.component.html',
  styleUrls: ['./profile-etudiant.component.css'],
})
export class ProfileEtudiantComponent implements OnInit {
  id!: string;
  imgFile!: string;
  userid!: number;
  user: any = {};
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
    private router: Router
  ) {
    this.reactiveForm = this.fb.group({
      email: [String(localStorage.getItem('email')), [Validators.required]],
      firstName: [
        String(localStorage.getItem('firstName')),
        [Validators.required],
      ],
      lastName: [
        String(localStorage.getItem('lastName')),
        [Validators.required],
      ],
      telephone: [
        String(localStorage.getItem('telephone')),
        [Validators.required],
      ],
      ncin: [String(localStorage.getItem('ncin')), [Validators.required]],
      apropos: [String(localStorage.getItem('apropos')), [Validators.required]],

      // pwdd: new FormControl('', Validators.required),
      roles: ['ASSISTANT', [Validators.required]],
    });
  }

  ngOnInit(): void {
    this.userid = Number(localStorage.getItem('userid'));
    this.firstName = String(localStorage.getItem('firstName'));
    this.lastName = String(localStorage.getItem('lastName'));
    this.roles = String(localStorage.getItem('roles'));
    this.email = String(localStorage.getItem('email'));
    this.telephone = String(localStorage.getItem('telephone'));
    this.addresse = String(localStorage.getItem('addresse'));
    this.ncin = String(localStorage.getItem('ncin'));
    this.password = String(localStorage.getItem('password'));
    this.apropos = String(localStorage.getItem('apropos'));
    this.imgFile = String(localStorage.getItem('imgFile'));
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
      return;
    }
    if (submitForm.valid) {
      const user = submitForm.value;
      console.log(user.firstName);
      var formData = new FormData();
      formData.append('file', this.userFile);
      formData.append('user', JSON.stringify(user));
      this.service
        .updateUser(formData, Number(localStorage.getItem('userid')))
        .subscribe(
          (data) => {
            localStorage.setItem('firstName', user.firstName);
            this.firstName = String(localStorage.getItem('firstName'));
          },
          (erreur) => {
            console.error(erreur);
          }
        );
    }
  }
  /*  Mustmatch(password: any, pwdd: any) {
    return (formGroup: FormGroup) => {
      const passwords = formGroup.controls[password];
      const pwdds = formGroup.controls[pwdd];

      if (passwords.value !== pwdd.value) {
        pwdds.setErrors({ Mustmatch: true });
      } else {
        pwdds.setErrors(null);
      }
    };
  }*/
}
