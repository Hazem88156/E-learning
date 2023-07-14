import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sidbar-professeur',
  templateUrl: './sidbar-professeur.component.html',
  styleUrls: ['./sidbar-professeur.component.css'],
})
export class SidbarProfesseurComponent implements OnInit {
  roles!: string;
  constructor() {}

  ngOnInit(): void {
    this.roles = String(localStorage.getItem('roles'));
  }
}
