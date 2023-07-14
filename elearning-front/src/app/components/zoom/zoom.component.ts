import { DOCUMENT } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ZoomMtg } from '@zoomus/websdk';
import { ZoomServiceService } from 'src/app/services/zoom-service.service';

//ZoomMtg.setZoomJSLib('https://source.zoom.us/lib', '/av');
@Component({
  selector: 'app-zoom',
  templateUrl: './zoom.component.html',
  styleUrls: ['./zoom.component.css'],
})
export class ZoomComponent implements OnInit {
  constructor(
    public httpClient: HttpClient,
    private zoomService: ZoomServiceService
  ) {}

  ngOnInit(): void {}

  async ngAfterContentInit(): Promise<any> {
    const { ZoomMtg } = await import('@zoomus/websdk');
    ZoomMtg.setZoomJSLib('https://source.zoom.us/lib', '/av');
    ZoomMtg.preLoadWasm();
    ZoomMtg.prepareWebSDK();
    let payload = {
      meetingNumber: '81857523023',
      passWord: '8g6MGm',
      sdkKey: 'CL_MHhsfQuSEBfA5p1XGJA',
      sdkSecret: 'vIeSH9M5DDxtP4TJGChi6Hk5VnhA5RNY',
      userName: String(
        localStorage.getItem('firstName') +
          '' +
          '' +
          localStorage.getItem('lastName')
      ),
      role: '0',
      userEmail: 'hazem.nahdi31@gmail.com',
      leaveUrl: 'http://localhost:4200',
    };
    ZoomMtg.generateSDKSignature({
      meetingNumber: payload.meetingNumber,

      sdkKey: payload.sdkKey,
      sdkSecret: payload.sdkSecret,
      role: payload.role,
      success: function (signature: any) {
        ZoomMtg.init({
          leaveUrl: payload.leaveUrl,
          success: function (data: any) {
            ZoomMtg.join({
              meetingNumber: payload.meetingNumber,
              passWord: payload.passWord,
              userName: payload.userName,
              userEmail: payload.userEmail,
              sdkKey: payload.sdkKey,
              signature: signature.result,
              success: function (data: any) {
                console.log(data);
              },
              error: function (error: any) {
                console.log('error', error);
              },
            });
          },
          error: function (error: any) {
            console.log('error', error);
          },
        });
      },
      error: function (error: any) {
        console.log('error', error);
      },
    });
  }
}
