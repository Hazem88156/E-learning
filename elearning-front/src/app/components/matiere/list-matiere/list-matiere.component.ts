import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {
  NgbModal,
  NgbModalConfig,
  NgbModalOptions,
} from '@ng-bootstrap/ng-bootstrap';
import { Matiere } from 'src/app/Models/matiere';
import { MatiereServiceService } from 'src/app/services/matiere-service.service';

@Component({
  selector: 'app-list-matiere',
  templateUrl: './list-matiere.component.html',
  styleUrls: ['./list-matiere.component.css'],
})
export class ListMatiereComponent implements OnInit {
  p: number = 1;
  matieress: Matiere = new Matiere();
  formModal: any;
  closeResult!: string;
  modalOptions!: NgbModalOptions;
  matieres: Matiere[] = [];
  constructor(
    private service: MatiereServiceService,
    private router: Router,
    private modalService: NgbModal,
    config: NgbModalConfig
  ) {
    config.backdrop = 'static';
    config.keyboard = false;
  }

  ngOnInit(): void {
    this.service
      .getMatiere()
      .toPromise()
      .then((matieres) => {
        console.log(matieres);
        this.matieres = matieres;
      });
    console.log(' liste matieress' + this.matieres);
  }
  updateMatiere(matiere: any) {
    this.service.setter(matiere);
    this.router.navigate(['update-matiere']);
  }
  open(content: any) {
    this.modalService.open(content);
  }
  key = 'id';
  reverse: boolean = false;
  sort(key: any) {
    this.key = key;
    this.reverse = !this.reverse;
  }
}
