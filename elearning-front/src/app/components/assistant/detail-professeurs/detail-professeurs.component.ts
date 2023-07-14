import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/Models/users';
import { AuthServiceService } from 'src/app/services/auth-service.service';

@Component({
  selector: 'app-detail-professeurs',
  templateUrl: './detail-professeurs.component.html',
  styleUrls: ['./detail-professeurs.component.css'],
})
export class DetailProfesseursComponent implements OnInit {
  firstName!: string;
  lastName!: string;
  email!: string;
  id!: number;
  apropros!: string;
  ncin!: string;
  telephone!: string;
  status!: string;
  professeur: User = new User();
  constructor(private service: AuthServiceService) {}

  ngOnInit(): void {
    this.professeur = this.service.getter();
    this.firstName = this.professeur.firstName;
    this.lastName = this.professeur.lastName;
    this.id = this.professeur.id;
    this.apropros = this.professeur.apropos;
    this.email = this.professeur.email;
    this.ncin = this.professeur.ncin;
    this.telephone = this.professeur.telephone;
    this.status = this.professeur.status;
  }
}
