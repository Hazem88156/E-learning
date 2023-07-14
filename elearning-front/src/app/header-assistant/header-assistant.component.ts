import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header-assistant',
  templateUrl: './header-assistant.component.html',
  styleUrls: ['./header-assistant.component.css'],
})
export class HeaderAssistantComponent implements OnInit {
  userid!: number;
  firstName!: string;
  lastName!: string;
  roles!: string;
  constructor(private router: Router) {}

  ngOnInit(): void {
    this.userid = Number(localStorage.getItem('userid'));
    this.firstName = String(localStorage.getItem('firstName'));
    this.lastName = String(localStorage.getItem('lastName'));
    this.roles = String(localStorage.getItem('roles'));
  }
}
