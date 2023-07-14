import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/Models/users';
import { AuthServiceService } from 'src/app/services/auth-service.service';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css'],
})
export class EditUserComponent implements OnInit {
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
  imgURL: any;
  public message: string | undefined;
  reactiveForm: FormGroup;
  passwordMatchValidator: any;
  constructor(
    public service: AuthServiceService,
    public fb: FormBuilder,
    private router: Router
  ) {
    this.users = this.service.getter();
    this.reactiveForm = this.fb.group({
      email: [this.users.email, [Validators.required]],
      firstName: [this.users.firstName, [Validators.required]],
      lastName: [this.users.lastName, [Validators.required]],
      telephone: [this.users.telephone, [Validators.required]],
      ncin: [this.users.ncin, [Validators.required]],
      apropos: [this.users.apropos, [Validators.required]],
      password: new FormControl(this.users.password, Validators.required),
      // pwdd: new FormControl('', Validators.required),
      roles: [this.users.roles, [Validators.required]],
      status:[this.users.status,[Validators.required]]
    });
  }

  ngOnInit(): void {}
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

      var formData = new FormData();
      formData.append('file', this.userFile);
      formData.append('user', JSON.stringify(user));
      this.service.updateUser(formData, this.users.id).subscribe(
        (data) => {
          console.log(data);
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
