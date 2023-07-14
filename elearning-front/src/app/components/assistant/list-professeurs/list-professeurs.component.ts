import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import {
  NgbModal,
  NgbModalConfig,
  NgbModalOptions,
} from '@ng-bootstrap/ng-bootstrap';
import { User } from 'src/app/Models/users';
import { AuthServiceService } from 'src/app/services/auth-service.service';

@Component({
  selector: 'app-list-professeurs',
  templateUrl: './list-professeurs.component.html',
  styleUrls: ['./list-professeurs.component.css'],
})
export class ListProfesseursComponent implements OnInit {
  firstName!: string;
  lastName!: string;
  submitted = false;
  status!: string;
  activerUser: FormGroup;
  inactiverUser: FormGroup;
  userss: User = new User();
  users: User[] = [];
  formModal: any;
  closeResult!: string;
  modalOptions!: NgbModalOptions;
  dtOptions: DataTables.Settings = {};

  constructor(
    private service: AuthServiceService,
    private router: Router,
    private modalService: NgbModal,
    config: NgbModalConfig,
    public fb: FormBuilder
  ) {
    config.backdrop = 'static';
    config.keyboard = false;
    this.activierUser(this.users);
    this.userss = this.service.getter();
    this.firstName = this.userss.firstName;
    this.lastName = this.userss.lastName;
    console.log('ussssssssssss', this.userss);
    this.activerUser = this.fb.group({
      status: ['ACTIVE', [Validators.required]],
    });
    this.inactiverUser = this.fb.group({
      status: ['INACTIVE', [Validators.required]],
    });
  }

  ngOnInit(): void {
    this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 5,
      processing: true,
    };
    this.service
      .getUserRoles('PROFESSEUR')
      .toPromise()
      .then((users) => {
        console.log(users);
        this.users = users;
      });
    console.log(' liste users' + this.users);
    this.userss = this.service.getter();
    console.log(this.userss);
    this.userss = this.service.getter();
    this.firstName = this.userss.firstName;
    this.lastName = this.userss.lastName;
  }
  activierUser(user: any) {
    this.service.setter(user);
    this.userss = this.service.getter();
    console.log('ussseeeeeeeeeee', this.userss);
  }
  updateUser(user: any) {
    this.service.setter(user);
    this.router.navigate(['update-professeur-assistant']);
  }
  open(content: any, user: any) {
    this.modalService.open(content);
    this.activierUser(user);
  }
  detailsProfesseur(user: any) {
    this.service.setter(user);
    this.router.navigate(['detail-professeur-assistant']);
  }

  activeUser(submitForm: FormGroup) {
    this.submitted = true;

    const user = submitForm.value;

    var formData = new FormData();

    formData.append('user', JSON.stringify(user));
    console.log('useeeeeeeeee', this.userss.id);
    this.service.active(formData, this.userss.id).subscribe(
      (data) => {
        console.log(data);
      },
      (erreur) => {
        console.error(erreur);
      }
    );
  }
  professeuractive() {
    this.service
      .getUserStatusRoles('ACTIVE', 'PROFESSEUR')
      .toPromise()
      .then((users) => {
        console.log(users);
        this.users = users;
      });
    console.log(' liste users active' + this.users);
  }
  professeurinactive() {
    this.service
      .getUserStatusRoles('INACTIVE', 'PROFESSEUR')
      .toPromise()
      .then((users) => {
        console.log(users);
        this.users = users;
      });
    console.log(' liste users inactive' + this.users);
  }
  listprofesseur() {
    this.service
      .getUserRoles('PROFESSEUR')
      .toPromise()
      .then((users) => {
        console.log(users);
        this.users = users;
      });
    console.log(' liste users' + this.users);
  }
}
