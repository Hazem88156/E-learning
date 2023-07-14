import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DocumentCours } from 'src/app/Models/documentCours';
import { DocumentServiceService } from 'src/app/services/document-service.service';

@Component({
  selector: 'app-list-document',
  templateUrl: './list-document.component.html',
  styleUrls: ['./list-document.component.css'],
})
export class ListDocumentComponent implements OnInit {
  userid!: number;
  documents: DocumentCours[] = [];
  constructor(
    private serviceDocument: DocumentServiceService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.userid = Number(localStorage.getItem('userid'));
    this.serviceDocument
      .getDocumentByUserId(this.userid)
      .toPromise()
      .then((documents) => {
        console.log(documents);
        this.documents = documents;
      });
    console.log(' liste cours' + this.documents);
  }
  DocumentDetail(documentid: number) {
    this.router.navigate(['detail-document', documentid]);
  }
}
