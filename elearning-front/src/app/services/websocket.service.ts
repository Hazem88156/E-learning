import { Injectable } from '@angular/core';
import { webSocket, WebSocketSubject } from 'rxjs/webSocket';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class VideoChatService {
  apiUrl = environment.apiUrl;
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
