import {
  AfterViewInit,
  Component,
  ElementRef,
  OnInit,
  ViewChild,
} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/Models/users';
import { AuthServiceService } from 'src/app/services/auth-service.service';
import { ConfigServiceService } from 'src/app/services/config-service.service';
import { MuteCamMicService } from 'src/app/services/mute-cam-mic.service';
import { SocketService } from 'src/app/services/socket.service';
declare const $: any;

@Component({
  selector: 'app-tabdata',
  templateUrl: './tabdata.component.html',
  styleUrls: ['./tabdata.component.css'],
})
export class TabdataComponent implements OnInit {
  @ViewChild('localVideo') localVideo!: ElementRef;
  remoteVideos: Array<any> = [];
  stream!: MediaStream;

  constructor(
    private shareScreenService: MuteCamMicService,
    private configService: ConfigServiceService,
    private route: ActivatedRoute,

    private router: Router
  ) {}
  id!: number;
  myPeer: any;

  ngOnInit(): void {}
}
