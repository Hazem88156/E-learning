import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ZoomServiceService {
  apiKey = 'YOUR_API_KEY';
  apiSecret = 'YOUR_API_SECRET';
  apiUrl = 'https://api.zoom.us/v2';
  jwtToken!: string;
  constructor(private http: HttpClient) {}
}
