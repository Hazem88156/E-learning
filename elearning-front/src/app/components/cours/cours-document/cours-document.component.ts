import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cours } from 'src/app/Models/cours';
import { DocumentCours } from 'src/app/Models/documentCours';
import { CoursServiceService } from 'src/app/services/cours-service.service';
import { DocumentServiceService } from 'src/app/services/document-service.service';

@Component({
  selector: 'app-cours-document',
  templateUrl: './cours-document.component.html',
  styleUrls: ['./cours-document.component.css'],
})
export class CoursDocumentComponent implements OnInit {
  id!: number;
  documents: DocumentCours[] = [];
  constructor(
    private service: DocumentServiceService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    var id = this.route.snapshot.paramMap.get('id');
    if (!id) return;
    this.id = parseInt(id);
    this.service
      .getDocumentByCoursId(this.id)
      .toPromise()
      .then((data) => {
        console.log(data);
        this.documents = data;
      });
  }
}
