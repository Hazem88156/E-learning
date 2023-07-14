import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { eMeet } from 'src/app/Models/eMeeting';
import { Member } from 'src/app/Models/member';
import { User } from 'src/app/Models/users';
import { VideoElement } from 'src/app/Models/video-element';
import { ConfigServiceService } from 'src/app/services/config-service.service';
import { MuteCamMicService } from 'src/app/services/mute-cam-mic.service';

@Component({
  selector: 'app-dashboard-reunion',
  templateUrl: './dashboard-reunion.component.html',
  styleUrls: ['./dashboard-reunion.component.css'],
})
export class DashboardReunionComponent implements OnInit {
  isMeeting!: boolean;
  stream!: MediaStream;
  enableVideo = true;
  enableAudio = true;
  currentRoomId = 0;
  currentUser!: User;
  currentMember!: Member;
  subscriptions = new Subscription();
  statusScreen!: eMeet;
  @ViewChild('videoPlayer') localvideoPlayer!: ElementRef;
  @ViewChild('localVideo') localVideo!: ElementRef;
  @ViewChild('remoteVideo') remoteVideo!: ElementRef;

  localStream!: MediaStream;
  remoteStream!: MediaStream;
  peerConnection!: RTCPeerConnection;
  shareScreenPeer: any;
  shareScreenStream: any;
  enableShareScreen = true; // enable or disable button sharescreen
  isStopRecord = false;
  textStopRecord = 'Start Record';
  videos: VideoElement[] = [];
  isRecorded!: boolean;
  userIsSharing!: string;

  remoteVideos: Array<any> = [];
  constructor(
    private shareScreenService: MuteCamMicService,
    private configService: ConfigServiceService,
    private route: ActivatedRoute,

    private router: Router
  ) {
    this.setupPeerConnection();
    this.getUserMedia();
  }
  id!: number;
  myPeer: any;

  ngOnInit(): void {
    this.setupWebRTC();
    this.isMeeting = true;
    this.isRecorded = this.configService.isRecorded; //enable or disable recorded

    this.isMeeting = true;
    this.isRecorded = this.configService.isRecorded; //enable or disable recorded
    const enableShareScreen = JSON.parse(
      String(localStorage.getItem('share-screen'))
    );
    if (enableShareScreen) {
      // != null
      this.enableShareScreen = enableShareScreen;
    }
    this.subscriptions.add(
      this.shareScreenService.shareScreen$.subscribe((val) => {
        if (val) {
          //true = share screen
          this.statusScreen = eMeet.SHARESCREEN;
          this.enableShareScreen = false;
          localStorage.setItem(
            'share-screen',
            JSON.stringify(this.enableShareScreen)
          );
        } else {
          // false = stop share
          this.statusScreen = eMeet.NONE;
          this.enableShareScreen = true;
          localStorage.setItem(
            'share-screen',
            JSON.stringify(this.enableShareScreen)
          );
        }
      })
    );
  }
  addOtherUserVideo(userId: Member, stream: MediaStream) {
    const alreadyExisting = this.videos.some(
      (video) => video.user.userName === userId.userName
    );
    if (alreadyExisting) {
      console.log(this.videos, userId);
      return;
    }

    this.videos.push({
      muted: false,
      srcObject: stream,
      user: userId,
    });

    if (this.videos.length <= this.maxUserDisplay) {
      this.tempvideos.push({
        muted: false,
        srcObject: stream,
        user: userId,
      });
    }
  }
  enableOrDisableVideo() {
    this.enableVideo = !this.enableVideo;
    if (this.stream && this.stream.getVideoTracks()[0]) {
      this.stream.getVideoTracks()[0].enabled = this.enableVideo;
      //this.chatHub.muteCamera(this.enableVideo)
    }
  }

  enableOrDisableAudio() {
    this.enableAudio = !this.enableAudio;
    if (this.stream && this.stream.getAudioTracks()[0]) {
      this.stream.getAudioTracks()[0].enabled = this.enableAudio;
      //this.chatHub.muteMicroPhone(this.enableAudio)
    }
  }
  maxUserDisplay = 8; // chi hien toi da la 8 user
  tempvideos: VideoElement[] = [];

  async shareScreen() {
    try {
      // @ts-ignore
      let mediaStream = await navigator.mediaDevices.getDisplayMedia({
        video: true,
      });
      this.shareScreenStream = mediaStream;
      this.enableShareScreen = false;

      this.videos.forEach((v) => {
        const call = this.shareScreenPeer.call(
          'share_' + v.user.userName,
          mediaStream
        );
        call.on('stream', (otherUserVideoStream: MediaStream) => {});
      });

      mediaStream.getVideoTracks()[0].addEventListener('ended', () => {
        this.enableShareScreen = true;
        localStorage.setItem(
          'share-screen',
          JSON.stringify(this.enableShareScreen)
        );
      });
    } catch (e) {
      console.log(e);
      alert(e);
    }
  }
  /*StartRecord() {
    this.isStopRecord = !this.isStopRecord;
    if (this.isStopRecord) {
      this.textStopRecord = 'Stop record';
      this.recordFileService.startRecording(this.stream);
    } else {
      this.textStopRecord = 'Start record';
      this.recordFileService.stopRecording();
      setTimeout(() => {
        this.recordFileService.upLoadOnServer().subscribe(() => {
          this.toastr.success('Upload file on server success');
        })
      }, 1000)
    }
  }*/
  onLoadedMetadata(event: Event) {
    (event.target as HTMLVideoElement).play();
  }
  /*startMeeting() {
    // Obtenir l'accès à la webcam et au microphone
    navigator.mediaDevices
      .getUserMedia({ video: true, audio: true })
      .then((stream) => {
        this.localVideo.nativeElement.srcObject = stream;
        // Diffuser le flux vidéo/microphone aux autres participants
        this.broadcastStream(stream);
      })
      .catch((error) => {
        console.error(
          "Erreur lors de l'obtention du flux vidéo/microphone:",
          error
        );
      });
  }*/

  /*shareScreenn() {
    // Obtenir l'accès au partage d'écran
    navigator.mediaDevices
      .getDisplayMedia({ video: true })
      .then((stream) => {
        // Diffuser le flux de partage d'écran aux autres participants
        this.broadcastStream(stream);
      })
      .catch((error: any) => {
        console.error(
          "Erreur lors de l'obtention du flux de partage d'écran:",
          error
        );
      });
  }*/

  broadcastStream(stream: MediaStream) {
    // Envoyer le flux aux autres participants (implémentation de la signalisation requise)
    // ...
  }

  setupWebRTC() {
    // Initialiser WebRTC, configurer les connexions, les événements, etc.
    // ...
  }
  setupPeerConnection() {
    const configuration = {
      iceServers: [{ urls: 'stun:stun.l.google.com:19302' }],
    };
    this.peerConnection = new RTCPeerConnection(configuration);

    this.peerConnection.onicecandidate = (event) => {
      if (event.candidate) {
        // Envoyer l'événement 'candidate' au serveur de signalisation
      }
    };

    this.peerConnection.ontrack = (event) => {
      this.remoteStream = event.streams[0];
      this.remoteVideo.nativeElement.srcObject = this.remoteStream;
    };
  }

  async getUserMedia() {
    try {
      this.localStream = await navigator.mediaDevices.getUserMedia({
        video: true,
        audio: true,
      });
      this.localVideo.nativeElement.srcObject = this.localStream;

      this.localStream.getTracks().forEach((track) => {
        this.peerConnection.addTrack(track, this.localStream);
      });
    } catch (error) {
      console.error('Error accessing media devices: ', error);
    }
  }

  startCall() {
    // Code pour initier un appel et configurer les connexions Peer-to-Peer
  }

  answerCall() {
    // Code pour répondre à un appel entrant et configurer les connexions Peer-to-Peer
  }
}
