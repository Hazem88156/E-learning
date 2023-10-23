import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { AuthServiceService } from 'src/app/services/auth-service.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css'],
})
export class AddUserComponent implements OnInit {
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
      email: ['', [Validators.required]],
      firstName: ['', [Validators.required]],
      lastName: ['', [Validators.required]],
      telephone: ['', [Validators.required]],
      ncin: ['', [Validators.required]],
      apropos: ['', [Validators.required]],
      password: new FormControl('', Validators.required),
      // pwdd: new FormControl('', Validators.required),
      roles: ['ASSISTANT', [Validators.required]],
      status: ['INACTIVE', [Validators.required]],

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
  saveForm(submitForm: FormGroup) {
    this.submitted = true;

    if (this.reactiveForm.invalid) {
      return;
    }
    if (submitForm.valid) {
      const user = submitForm.value;
      var formData = new FormData();
      formData.append('file', this.userFile);
      formData.append('user', JSON.stringify(user));
      console.log(formData);
      console.log('hazem');
      this.service.createUser(formData).subscribe(
        (data) => {
          console.log('hazem');
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
