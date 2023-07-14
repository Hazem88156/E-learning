import {
  Component,
  OnInit,
  Pipe,
  PipeTransform,
  ViewChild,
} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Classe } from 'src/app/Models/classe';
import { Cours } from 'src/app/Models/cours';
import { Matiere } from 'src/app/Models/matiere';
import { User } from 'src/app/Models/users';
import { VedioCours } from 'src/app/Models/vedioCours';
import { VedioServiceService } from 'src/app/services/vedio-service.service';
@Pipe({ name: 'timeFormat' })
export class TimeFormatPipe implements PipeTransform {
  transform(value: number): string {
    const minutes: number = Math.floor(value / 60);
    const seconds: number = Math.floor(value % 60);
    return `${minutes}:${seconds < 10 ? '0' + seconds : seconds}`;
  }
}

@Component({
  selector: 'app-detail-vedio',
  templateUrl: './detail-vedio.component.html',
  styleUrls: ['./detail-vedio.component.css'],
})
export class DetailVedioComponent implements OnInit {
  firstName!: string;
  lastName!: string;
  nomMatiere!: string;
  nomClasse!: string;
  vedioName!: string;
  cour!: Cours;
  matiere!: Matiere;
  classe!: Classe;
  professeur!: User;
  vedios!: VedioCours;
  id!: number;
  path!: string;
  @ViewChild('videoPlayer') videoPlayer: any;
  volume = 1;
  currentTime = 0;

  videoProgress: number = 0;
  constructor(
    private route: ActivatedRoute,
    private service: VedioServiceService
  ) {}

  ngOnInit(): void {
    this.id = parseInt(this.route.snapshot.paramMap.get('id')!);
    this.service
      .getVedioById(this.id)
      .toPromise()
      .then((data) => {
        console.log(data);
        this.vedios = data;
        this.cour = this.vedios.cour;
        this.vedioName = this.vedios.vedioName;
        this.professeur = this.cour.user;
        this.firstName = this.professeur.firstName;
        this.lastName = this.professeur.lastName;
        this.matiere = this.cour.matiere;
        this.classe = this.cour.classe;
        this.nomClasse = this.classe.nomClasse;
        this.nomMatiere = this.matiere.nomMatiere;
      });
    this.path = 'http://localhost:8081/api/Vedio/' + this.id;
  }
  playVideo() {
    this.videoPlayer.nativeElement.play();
  }

  pauseVideo() {
    this.videoPlayer.nativeElement.pause();
  }

  toggleFullscreen() {
    if (this.videoPlayer.nativeElement.requestFullscreen) {
      this.videoPlayer.nativeElement.requestFullscreen();
    } else if (this.videoPlayer.nativeElement.mozRequestFullScreen) {
      this.videoPlayer.nativeElement.mozRequestFullScreen();
    } else if (this.videoPlayer.nativeElement.webkitRequestFullscreen) {
      this.videoPlayer.nativeElement.webkitRequestFullscreen();
    } else if (this.videoPlayer.nativeElement.msRequestFullscreen) {
      this.videoPlayer.nativeElement.msRequestFullscreen();
    }
  }

  updateVolume() {
    this.videoPlayer.nativeElement.volume = this.volume;
  }
  seekVideo() {
    this.videoPlayer.nativeElement.currentTime = this.currentTime;
  }

  updateCurrentTime() {
    this.currentTime = this.videoPlayer.nativeElement.currentTime;
  }
  enterPictureInPicture(): void {
    if (this.videoPlayer.nativeElement.requestPictureInPicture) {
      this.videoPlayer.nativeElement.requestPictureInPicture();
    } else if (this.videoPlayer.nativeElement.exitPictureInPicture) {
      this.videoPlayer.nativeElement.exitPictureInPicture();
    }
  }
  onVideoTimeUpdate(): void {
    const video = this.videoPlayer.nativeElement;
    const currentTime: number = video.currentTime;
    const duration: number = video.duration;
    this.videoProgress = (currentTime / duration) * 100;
  }
}
