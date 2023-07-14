import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/Models/users';
import { AuthServiceService } from 'src/app/services/auth-service.service';

@Component({
  selector: 'app-detail-etudiant',
  templateUrl: './detail-etudiant.component.html',
  styleUrls: ['./detail-etudiant.component.css'],
})
export class DetailEtudiantComponent implements OnInit {
  firstName!: string;
  lastName!: string;
  email!: string;
  id!: number;
  apropros!: string;
  ncin!: string;
  telephone!: string;
  status!: string;
  etudiant: User = new User();
  constructor(private service: AuthServiceService) {}

  ngOnInit(): void {
    this.etudiant = this.service.getter();
    this.firstName = this.etudiant.firstName;
    this.lastName = this.etudiant.lastName;
    this.id = this.etudiant.id;
    this.apropros = this.etudiant.apropos;
    this.email = this.etudiant.email;
    this.ncin = this.etudiant.ncin;
    this.telephone = this.etudiant.telephone;
    this.status = this.etudiant.status;
  }
}
