import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { LastUserJoinReunion } from '../Models/lastUserJoinRoom';
import { MuteObject } from '../Models/mute-object';

@Injectable({
  providedIn: 'root',
})
export class MuteCamMicService {
  private muteMicro!: MuteObject;
  private muteCamera!: MuteObject;

  private muteMicroSource = new Subject<MuteObject>();
  muteMicro$ = this.muteMicroSource.asObservable();

  private muteCameraSource = new Subject<MuteObject>();
  muteCamera$ = this.muteCameraSource.asObservable();

  private shareScreenSource = new Subject<boolean>();
  shareScreen$ = this.shareScreenSource.asObservable();

  private lastShareScreenSource = new Subject<LastUserJoinReunion>();
  lastShareScreen$ = this.lastShareScreenSource.asObservable();

  private shareScreenToLastUserSource = new Subject<boolean>();
  shareScreenToLastUser$ = this.shareScreenToLastUserSource.asObservable();

  private userIsSharingSource = new Subject<string>();
  userIsSharing$ = this.userIsSharingSource.asObservable();
  constructor() {}
  set Microphone(value: MuteObject) {
    this.muteMicro = value;
    this.muteMicroSource.next(value);
  }

  get Microphone(): MuteObject {
    return this.muteMicro;
  }

  set Camera(value: MuteObject) {
    this.muteCamera = value;
    this.muteCameraSource.next(value);
  }

  get Camera(): MuteObject {
    return this.muteCamera;
  }

  set ShareScreen(value: boolean) {
    this.shareScreenSource.next(value);
  }

  set LastShareScreen(value: LastUserJoinReunion) {
    this.lastShareScreenSource.next(value);
  }

  set ShareScreenToLastUser(value: boolean) {
    this.shareScreenToLastUserSource.next(value);
  }

  set UserIsSharing(value: string) {
    this.userIsSharingSource.next(value);
  }
}
