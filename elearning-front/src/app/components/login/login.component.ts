import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { first } from 'rxjs/operators';
import { AuthServiceService } from 'src/app/services/auth-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  isLoadingResults = false;
  loginForm!: FormGroup;
  loading = false;
  submitted = false;
  returnUrl!: string;
  error = '';
  email = '';
  password = '';
  user: any = {};
  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private authService: AuthServiceService
  ) {}

  ngOnInit(): void {
    localStorage.removeItem('token');
    localStorage.removeItem('currentUser');
    this.loginForm = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required],
    });
  }
  get f() {
    return this.loginForm.controls;
  }
  onSubmit() {
    this.submitted = true;

    if (this.loginForm.invalid) {
      return;
    }
    this.authService
      .login(this.f.email.value, this.f.password.value)
      .pipe(first())
      .subscribe((data) => {
        if (data.isauthnenticate) {
          console.log('data', data);

          localStorage.setItem('token', data.token);

          localStorage.setItem('firstname', data.firstName);
          let helper = new JwtHelperService();
          let token = localStorage.getItem('token');
          let decoded = helper.decodeToken(data.token);
          let role = decoded.role;
          let user = data.user;

          let roles = user.roles;
          let firstName = user.firstName;
          let lastName = user.lastName;
          let email = user.email;
          let addresse = user.addresse;
          let telephone = user.telephone;
          let userid = user.id;
          let ncin = user.ncin;
          let apropos = user.apropos;
          let status = user.status;

          localStorage.setItem('userid', userid);

          localStorage.setItem('firstName', firstName);
          localStorage.setItem('lastName', lastName);
          localStorage.setItem('roles', roles);
          localStorage.setItem('email', email);
          localStorage.setItem('telephone', telephone);
          localStorage.setItem('addresse', addresse);
          localStorage.setItem('ncin', ncin);
          localStorage.setItem('apropos', apropos);
          localStorage.setItem('username', data.username);
          localStorage.setItem('password', this.f.password.value);

          if (roles == 'ADMIN' && status == 'ACTIVE') {
            this.router.navigate(['dashboradadmin']);
          } else if (roles == 'ASSISTANT' && status == 'ACTIVE') {
            this.router.navigate(['dashboardassistant']);
          } else if (roles == 'PROFESSEUR' && status == 'ACTIVE') {
            this.router.navigate(['dashboardprofesseur']);
          } else if ((roles = 'ETUDIANT' && status == 'ACTIVE')) {
            let classe = user.classesEtudiant;
            console.log(classe);
            let nomClasse = classe.nomClasse;
            let classeId = classe.id;
            console.log('classe', classeId);
            console.log('nomClasse', nomClasse);
            console.log(userid);
            localStorage.setItem('nomClasse', nomClasse);
            localStorage.setItem('classe', classe);
            localStorage.setItem('classeId', classeId);
            localStorage.setItem('classe', classe);
            this.router.navigate(['dashboardetudiant']);
          }
        } else {
          console.log('email ou mot de passe incorrect', '');
        }
      });

    this.router.navigate(['']);
  }
}
