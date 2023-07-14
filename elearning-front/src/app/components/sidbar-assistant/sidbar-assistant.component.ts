import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidbar-assistant',
  templateUrl: './sidbar-assistant.component.html',
  styleUrls: ['./sidbar-assistant.component.css'],
})
export class SidbarAssistantComponent implements OnInit {
  roles!: string;
  constructor() {}

  ngOnInit(): void {
    this.roles = String(localStorage.getItem('roles'));
  }
}
