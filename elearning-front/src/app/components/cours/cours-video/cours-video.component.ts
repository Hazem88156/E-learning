import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { VedioCours } from 'src/app/Models/vedioCours';
import { VedioServiceService } from 'src/app/services/vedio-service.service';

@Component({
  selector: 'app-cours-video',
  templateUrl: './cours-video.component.html',
  styleUrls: ['./cours-video.component.css'],
})
export class CoursVideoComponent implements OnInit {
  id!: number;
  videos: VedioCours[] = [];
  constructor(
    private service: VedioServiceService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    var id = this.route.snapshot.paramMap.get('id');
    if (!id) return;
    this.id = parseInt(id);
    this.service
      .getVideoByCoursId(this.id)
      .toPromise()
      .then((data) => {
        console.log(data);
        this.videos = data;
      });
  }
}
