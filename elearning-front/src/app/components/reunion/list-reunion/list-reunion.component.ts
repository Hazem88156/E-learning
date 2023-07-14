import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {
  NgbModal,
  NgbModalConfig,
  NgbModalOptions,
} from '@ng-bootstrap/ng-bootstrap';
import { Reunion } from 'src/app/Models/reunion';
import { ServiceReunionService } from 'src/app/services/service-reunion.service';

@Component({
  selector: 'app-list-reunion',
  templateUrl: './list-reunion.component.html',
  styleUrls: ['./list-reunion.component.css'],
})
export class ListReunionComponent implements OnInit {
  reunions: Reunion[] = [];
  formModal: any;
  closeResult!: string;
  modalOptions!: NgbModalOptions;
  constructor(
    private service: ServiceReunionService,
    private router: Router,
    private modalService: NgbModal,
    config: NgbModalConfig
  ) {}

  ngOnInit(): void {
    this.service
      .getReunion()
      .toPromise()
      .then((reunions) => {
        console.log(reunions);
        this.reunions = reunions;
      });
    console.log(' liste des reunions' + this.reunions);
  }
  /*joinReunion(reunionId: number) {
    this.router.navigate(['dashboardreunion/', reunionId]);
  }*/
  joinReunion(reunionid: number) {
    this.router.navigate(['jitsi', reunionid]);
  }
}
