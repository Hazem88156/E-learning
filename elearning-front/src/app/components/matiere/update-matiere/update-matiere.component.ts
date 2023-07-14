import { Component, OnInit } from '@angular/core';
import { Matiere } from 'src/app/Models/matiere';
import { MatiereServiceService } from 'src/app/services/matiere-service.service';

@Component({
  selector: 'app-update-matiere',
  templateUrl: './update-matiere.component.html',
  styleUrls: ['./update-matiere.component.css'],
})
export class UpdateMatiereComponent implements OnInit {
  matiere: Matiere = new Matiere();
  submitted = false;
  constructor(private service: MatiereServiceService) {}

  ngOnInit(): void {
    this.matiere = this.service.getter();
  }
  save() {
    this.service.create(this.matiere).subscribe(
      (data) => console.log(data),
      (error) => console.log(error)
    );
    this.matiere = new Matiere();
  }
  onSubmit() {
    this.submitted = true;
    this.save();
  }
}
