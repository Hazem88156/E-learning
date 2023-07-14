import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VedioCours } from 'src/app/Models/vedioCours';
import { VedioServiceService } from 'src/app/services/vedio-service.service';

@Component({
  selector: 'app-list-vedio',
  templateUrl: './list-vedio.component.html',
  styleUrls: ['./list-vedio.component.css'],
})
export class ListVedioComponent implements OnInit {
  vedios: VedioCours[] = [];
  userid!: number;
  constructor(
    private serviceVedio: VedioServiceService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.userid = Number(localStorage.getItem('userid'));
    this.serviceVedio
      .getVedioByUserId(this.userid)
      .toPromise()
      .then((vedios) => {
        console.log(vedios);
        this.vedios = vedios;
      });
    console.log(' liste vedio' + this.vedios);
  }
  VedioDetail(courid: number) {
    this.router.navigate(['detail-vedio', courid]);
  }
}
