import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Cours } from 'src/app/Models/cours';
import { VedioCours } from 'src/app/Models/vedioCours';
import { CoursServiceService } from 'src/app/services/cours-service.service';
import { VedioServiceService } from 'src/app/services/vedio-service.service';

@Component({
  selector: 'app-add-vedio',
  templateUrl: './add-vedio.component.html',
  styleUrls: ['./add-vedio.component.css'],
})
export class AddVedioComponent implements OnInit {
  cours: Cours[] = [];
  userid!: number;

  submitted = false;

  vedioName!: string;

  reactiveForm: FormGroup;
  public vedioPath: any;
  vedioURL: any;
  public vedioFile: any = File;
  public message: string | undefined;

  constructor(
    public service: VedioServiceService,
    public fb: FormBuilder,
    private serviceCours: CoursServiceService
  ) {
    this.reactiveForm = this.fb.group({
      vedioName: ['', [Validators.required]],
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
    this.vedioFile = file;
    var mimeType = event.target.files[0].type;
    if (mimeType.match(/vedio\/*/) == null) {
      this.message = 'Only documents are supported.';
      return;
    }
    var reader = new FileReader();

    this.vedioPath = file;
    reader.readAsDataURL(file);
    reader.onload = (_event) => {
      this.vedioURL = reader.result;
    };
  }

  saveForm(submitForm: FormGroup) {
    this.submitted = true;

    if (this.reactiveForm.invalid) {
      return;
    }
    if (submitForm.valid) {
      console.log(submitForm.value);

      const vedio = submitForm.value as VedioCours;
      vedio.cour = this.cours.filter((c) => c.id == submitForm.value.cour)[0];
      var vedios = JSON.stringify(vedio);
      console.log(vedios);

      var formData = new FormData();
      formData.append('vedio', vedios);
      formData.append('file', this.vedioFile);
      console.log(formData, 'hhhhhhhh');

      this.service.createVedio(formData).subscribe(
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
