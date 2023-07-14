import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/Models/users';
import { AuthServiceService } from 'src/app/services/auth-service.service';

@Component({
  selector: 'app-dashboard-admin',
  templateUrl: './dashboard-admin.component.html',
  styleUrls: ['./dashboard-admin.component.css'],
  //template: `<app-footer></app-footer>`,
})
export class DashboardAdminComponent implements OnInit {
  etudiants: User[] = [];
  utilisateur: User[] = [];
  professeur: User[] = [];
  lentpro!: number;
  lenet!: number;
  lenut!: number;
  constructor(private service: AuthServiceService, private router: Router) {}

  ngOnInit(): void {
    this.service
      .getUserRoles('ETUDIANT')
      .toPromise()
      .then((etudiants) => {
        console.log(etudiants);
        this.etudiants = etudiants;
      });
    console.log(' liste users' + this.etudiants);
    this.lenet = this.etudiants.length;
    this.lenet = this.lenet + 1;
    this.service
      .getUserRoles('ASSISTANT')
      .toPromise()
      .then((utilisateur) => {
        console.log(utilisateur);
        this.utilisateur = utilisateur;
      });
    console.log(' liste users' + this.utilisateur);
    this.lenut = this.utilisateur.length;
    this.lenut = this.lenut + 1;
    this.service
      .getUserRoles('PROFESSEUR')
      .toPromise()
      .then((utilisateur) => {
        console.log(utilisateur);
        this.utilisateur = utilisateur;
      });
    console.log(' liste users' + this.utilisateur);
    this.lentpro = this.utilisateur.length;
    this.lentpro = this.lentpro + 1;
  }
}
