import { Component, OnInit } from '@angular/core';
import { Matiere } from 'src/app/Models/matiere';
import { MatiereServiceService } from 'src/app/services/matiere-service.service';

@Component({
  selector: 'app-add-matieres',
  templateUrl: './add-matieres.component.html',
  styleUrls: ['./add-matieres.component.css'],
})
export class AddMatieresComponent implements OnInit {
  matiere: Matiere = new Matiere();
  submitted = false;
  constructor(private service: MatiereServiceService) {}

  ngOnInit(): void {}
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
