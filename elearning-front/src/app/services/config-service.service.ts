import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConfigServiceService {
  STUN_SERVER!: string;
  isRecorded!: boolean;// true=recored, false = no
  clockRegister!: boolean;//true = block
  pageSize!: number;
  urlTurnServer!: string;
  username!: string;
  password!: string;
  constructor() { }
}
