import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent implements OnInit {
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
