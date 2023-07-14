import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidbar-admin',
  templateUrl: './sidbar-admin.component.html',
  styleUrls: ['./sidbar-admin.component.css'],
})
export class SidbarAdminComponent implements OnInit {
  roles!: string;
  constructor() {}

  ngOnInit(): void {
    this.roles = String(localStorage.getItem('roles'));
  }
}
