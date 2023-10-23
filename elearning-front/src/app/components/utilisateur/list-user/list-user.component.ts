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
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.css'],
})
export class ListUserComponent implements OnInit {
  users: User[] = [];
  firstName!: string;
  lastName!: string;
  submitted = false;
  status!: string;
  activerUser: FormGroup;
  inactiverUser: FormGroup;
  userss: User = new User();
  formModal: any;
  closeResult!: string;
  p: number = 1;
  modalOptions!: NgbModalOptions;
  constructor(
    private service: AuthServiceService,
    private router: Router,
    private modalService: NgbModal,
    config: NgbModalConfig,
    public fb: FormBuilder
  ) {
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
  open(content: any, user: any) {
    this.modalService.open(content);
    this.activierUser(user);
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
  detailsUtilisateur(user: any) {
    this.service.setter(user);
    this.router.navigate(['detail-utilisateur']);
  }

  ngOnInit(): void {
    this.service
      .getUserRoles('ASSISTANT')
      .toPromise()
      .then((users) => {
        console.log(users);
        this.users = users;
      });
    console.log(' liste users' + this.users);
  }
  updateUser(user: any) {
    this.service.setter(user);
    this.router.navigate(['edit-user']);
  }
  useractive() {
    this.service
      .getUserStatusRoles('ACTIVE', 'ASSISTANT')
      .toPromise()
      .then((users) => {
        console.log(users);
        this.users = users;
      });
    console.log(' liste users active' + this.users);
  }
  userinactive() {
    this.service
      .getUserStatusRoles('INACTIVE', 'ASSISTANT')
      .toPromise()
      .then((users) => {
        console.log(users);
        this.users = users;
      });
    console.log(' liste users inactive' + this.users);
  }
  listuser() {
    this.service
      .getUserRoles('ASSISTANT')
      .toPromise()
      .then((users) => {
        console.log(users);
        this.users = users;
      });
    console.log(' liste users' + this.users);
  }
  key = 'id';
  reverse: boolean = false;
  sort(key: any) {
    this.key = key;
    this.reverse = !this.reverse;
  }
  deleteUser(id: number) {
    this.service.deleteUser(id).subscribe(() => {
      // Mettre à jour la liste des produits après suppression
      this.users = this.users.filter(user => user.id !== id);
    });
  }
}
