import { HttpClient } from '@angular/common/http';
import {
  Component,
  ElementRef,
  OnInit,
  ViewChild,
  EventEmitter,
} from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Classe } from 'src/app/Models/classe';
import { Cours } from 'src/app/Models/cours';
import { DocumentCours } from 'src/app/Models/documentCours';
import { Matiere } from 'src/app/Models/matiere';
import { User } from 'src/app/Models/users';
import { DocumentServiceService } from 'src/app/services/document-service.service';
import { DocumentComponent } from '../document/document.component';

@Component({
  selector: 'app-detail-document',
  templateUrl: './detail-document.component.html',
  styleUrls: ['./detail-document.component.css'],
})
export class DetailDocumentComponent implements OnInit {
  document!: DocumentCours;
  id!: number;
  path!: string;
  public hostedURL =
    'https://ej2services.syncfusion.com/production/web-services/api/pdfviewer';
  num1 = 1;
  numaff = 100;
  firstName!: string;
  lastName!: string;
  nomMatiere!: string;
  nomClasse!: string;
  documentName!: string;
  cour!: Cours;
  matiere!: Matiere;
  classe!: Classe;
  professeur!: User;
  rotation = 0;

  @ViewChild('viewer') viewerRef!: ElementRef;
  download: EventEmitter<any> = new EventEmitter();
  print: EventEmitter<any> = new EventEmitter();

  constructor(
    private route: ActivatedRoute,
    private service: DocumentServiceService,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    this.id = parseInt(this.route.snapshot.paramMap.get('id')!);

    this.service
      .getDocumentById(this.id)
      .toPromise()
      .then((data) => {
        this.document = data;
        this.path = 'http://localhost:8081/api/Document/' + this.id;
        console.log(this.document);
        this.cour = this.document.cour;
        this.documentName = this.document.documentName;
        this.professeur = this.cour.user;
        this.firstName = this.professeur.firstName;
        this.lastName = this.professeur.lastName;
        this.matiere = this.cour.matiere;
        this.classe = this.cour.classe;
        this.nomClasse = this.classe.nomClasse;
        this.nomMatiere = this.matiere.nomMatiere;
      });
  }
  plus() {
    //if (this.num1 <= 0.75 && this.numaff <= 75) {
    this.num1 = this.num1 + 0.25;
    this.numaff = this.numaff + 25;
    //}
  }

  minus() {
    if (this.num1 >= 0.25 && this.numaff >= 25) {
      this.num1 = this.num1 - 0.25;
      this.numaff = this.numaff - 25;
    }
  }
  downloadPDF() {
    const pdfUrl = this.path;
    const fileName = this.documentName + '.pdf';

    this.http.get(pdfUrl, { responseType: 'blob' }).subscribe((blob: Blob) => {
      const downloadLink = document.createElement('a');
      const url = window.URL.createObjectURL(blob);

      downloadLink.href = url;
      downloadLink.download = fileName;
      downloadLink.click();

      window.URL.revokeObjectURL(url);
      downloadLink.remove();
    });
  }

  rotatePdf(): void {
    // Increase rotation by 90 degrees (clockwise)
    this.rotation += 90;
  }
}
