import { Component, OnInit } from '@angular/core';
import {
  FormArray,
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Classe } from 'src/app/Models/classe';
import { Cours } from 'src/app/Models/cours';
import { DocumentCours } from 'src/app/Models/documentCours';
import { Matiere } from 'src/app/Models/matiere';
import { ClasseServiceService } from 'src/app/services/classe-service.service';
import { CoursServiceService } from 'src/app/services/cours-service.service';
import { DocumentServiceService } from 'src/app/services/document-service.service';
import { MatiereServiceService } from 'src/app/services/matiere-service.service';

@Component({
  selector: 'app-document',
  templateUrl: './document.component.html',
  styleUrls: ['./document.component.css'],
})
export class DocumentComponent implements OnInit {
  cours: Cours[] = [];
  document: Document = new Document();
  submitted = false;

  documentName!: string;
  userid!: number;
  reactiveForm: FormGroup;
  public documentPath: any;
  documentURL: any;
  public documentFile: any = File;
  public message: string | undefined;
  constructor(
    public service: DocumentServiceService,
    public fb: FormBuilder,
    private serviceCours: CoursServiceService
  ) {
    this.reactiveForm = this.fb.group({
      documentName: ['', [Validators.required]],
      cour: ['', [Validators.required]],
    });
  }

  ngOnInit(): void {
    this.userid = Number(localStorage.getItem('userid'));
    console.log('hazem', this.userid);
    this.serviceCours
      .getCoursByUser(this.userid)
      .toPromise()
      .then((cours) => {
        console.log(cours);
        this.cours = cours;
      });
    console.log(' liste cours' + this.cours);
  }
  get f() {
    return this.reactiveForm.controls;
  }
  onSelectFile(event: any) {
    const file = event.target.files[0];
    this.documentFile = file;
    var mimeType = event.target.files[0].type;
    if (mimeType.match(/document\/*/) == null) {
      this.message = 'Only documents are supported.';
      return;
    }
    var reader = new FileReader();

    this.documentPath = file;
    reader.readAsDataURL(file);
    reader.onload = (_event) => {
      this.documentURL = reader.result;
    };
  }

  saveForm(submitForm: FormGroup) {
    this.submitted = true;

    if (this.reactiveForm.invalid) {
      return;
    }
    if (submitForm.valid) {
      console.log(submitForm.value);

      const document = submitForm.value as DocumentCours;
      document.cour = this.cours.filter(
        (c) => c.id == submitForm.value.cour
      )[0];
      var documents = JSON.stringify(document);
      console.log(documents);

      var formData = new FormData();
      formData.append('document', documents);
      formData.append('file', this.documentFile);
      console.log(formData, 'hhhhhhhh');

      this.service.createDocument(formData).subscribe(
        (data) => {
          console.log(data);
        },
        (erreur) => {
          console.error(erreur);
        }
      );
    } else {
      console.log('hhhhhhhh');
    }
  }
}
