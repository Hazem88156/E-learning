import { Injectable } from '@angular/core';
import { webSocket, WebSocketSubject } from 'rxjs/webSocket';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class VideoChatService {
  private socket$!: WebSocketSubject<any>;

  constructor() {}

  connect(): void {
    this.socket$ = webSocket('ws://localhost:8081/video-chat');
  }

  sendMessage(message: string): void {
    this.socket$.next(message);
  }

  receiveMessage(): Observable<any> {
    return this.socket$.asObservable();
  }

  closeConnection(): void {
    this.socket$.complete();
  }
}
