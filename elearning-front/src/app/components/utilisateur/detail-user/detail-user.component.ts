import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/Models/users';
import { AuthServiceService } from 'src/app/services/auth-service.service';

@Component({
  selector: 'app-detail-user',
  templateUrl: './detail-user.component.html',
  styleUrls: ['./detail-user.component.css'],
})
export class DetailUserComponent implements OnInit {
  firstName!: string;
  lastName!: string;
  email!: string;
  id!: number;
  apropros!: string;
  ncin!: string;
  telephone!: string;
  status!: string;
  utilisateur: User = new User();
  constructor(private service: AuthServiceService) {}

  ngOnInit(): void {
    this.utilisateur = this.service.getter();
    this.firstName = this.utilisateur.firstName;
    this.lastName = this.utilisateur.lastName;
    this.id = this.utilisateur.id;
    this.apropros = this.utilisateur.apropos;
    this.email = this.utilisateur.email;
    this.ncin = this.utilisateur.ncin;
    this.telephone = this.utilisateur.telephone;
    this.status = this.utilisateur.status;
  }
}
