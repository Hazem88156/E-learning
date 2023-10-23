import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import {
  ModalDismissReasons,
  NgbModal,
  NgbModalConfig,
  NgbModalOptions,
} from '@ng-bootstrap/ng-bootstrap';

import { User } from 'src/app/Models/users';
import { AuthServiceService } from 'src/app/services/auth-service.service';

declare var window: any;

@Component({
  selector: 'app-list-professeur',
  templateUrl: './list-professeur.component.html',
  styleUrls: ['./list-professeur.component.css'],
})
export class ListProfesseurComponent implements OnInit {
  firstName!: string;
  email!: string;
  lastName!: string;
  submitted = false;
  status!: string;
  activerUser: FormGroup;
  inactiverUser: FormGroup;
  userss: User = new User();
  users: User[] = [];
  filtered_users: User[] = [];
  formModal: any;
  closeResult!: string;
  modalOptions!: NgbModalOptions;
  dtOptions: DataTables.Settings = {};
  firstNames!: any;
  p: number = 1;
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
  activierUser(user: any) {
    this.service.setter(user);
    this.userss = this.service.getter();
    console.log('ussseeeeeeeeeee', this.userss);
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
        this.filtered_users = users;
      });
    console.log(' liste users' + this.users);
    this.userss = this.service.getter();
    console.log(this.userss);
    this.userss = this.service.getter();
    this.firstName = this.userss.firstName;
    this.lastName = this.userss.lastName;
  }
  updateUser(userid: number) {
    this.router.navigate(['edit-professeur', userid]);
  }
  open(content: any, user: any) {
    this.modalService.open(content);
    this.activierUser(user);
  }
  detailsProfesseur(user: any) {
    this.service.setter(user);
    this.router.navigate(['detail-professeur']);
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
        this.filtered_users = users;
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
        this.filtered_users = users;
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
        this.filtered_users = users;
      });
    console.log(' liste users' + this.users);
  }
  SearchByfirstName() {
    if (this.firstName == '') {
      this.filtered_users = this.users;
    } else {
      let filter_user_by_firstname = this.filtered_users.filter((res) => {
        return res.firstName
          .toLocaleLowerCase()
          .match(this.firstName.toLocaleLowerCase());
      });
      this.filtered_users = filter_user_by_firstname;
    }
  }
  SearchBylastName() {
    if (this.lastName == '') {
      this.filtered_users = this.users;
    } else {
      let filter_user_by_lastname = this.filtered_users.filter((res) => {
        return res.lastName
          .toLocaleLowerCase()
          .match(this.lastName.toLocaleLowerCase());
      });
      this.filtered_users = filter_user_by_lastname;
    }
  }
  SearchByEmail() {
    if (this.email == '') {
      this.filtered_users = this.users;
    } else {
      let filter_user_by_email = this.filtered_users.filter((res) => {
        return res.email
          .toLocaleLowerCase()
          .match(this.email.toLocaleLowerCase());
      });
      this.filtered_users = filter_user_by_email;
    }
  }

  key = 'id';
  reverse: boolean = false;
  sort(key: any) {
    this.key = key;
    this.reverse = !this.reverse;
  }
  deleteUser(id: number) {
    this.service.deleteUser(id).subscribe(() => {
      // Mettre à jour la liste des users après suppression
      this.users = this.users.filter(user => user.id !== id);
    });
  }
}
