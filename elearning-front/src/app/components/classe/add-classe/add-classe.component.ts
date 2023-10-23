import { Component, OnInit } from '@angular/core';
import {
  FormArray,
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Classe } from 'src/app/Models/classe';
import { Matiere } from 'src/app/Models/matiere';
import { AuthServiceService } from 'src/app/services/auth-service.service';
import { ClasseServiceService } from 'src/app/services/classe-service.service';
import { MatiereServiceService } from 'src/app/services/matiere-service.service';

@Component({
  selector: 'app-add-classe',
  templateUrl: './add-classe.component.html',
  styleUrls: ['./add-classe.component.css'],
})
export class AddClasseComponent implements OnInit {
 
  matieres: Matiere[] = [];
  
  selected_matieres: Matiere[] = [];
  classe: Classe = new Classe();
  submitted = false;
  reactiveForm!: FormGroup;
  constructor(
    private service: ClasseServiceService,
    private serviceMatiere: MatiereServiceService,
    private fb: FormBuilder
  ) {
    this.reactiveForm = this.fb.group({
      nomClasse: ['', [Validators.required]],
      matieres: this.fb.array([]),
      section:['',[Validators.required]],
      annee:['',[Validators.required]]
    });
  }

  ngOnInit(): void {
   
    this.serviceMatiere
      .getMatiere()
      .toPromise()
      .then((matieres) => {
        console.log(matieres);
        this.matieres = matieres;
      });
    console.log(' liste matieress' + this.matieres);
  }
  get f() {
    return this.reactiveForm.controls;
  }
 
  onCheckboxChanges(e: any) {
    const matiereCheckArray: FormArray = this.reactiveForm.get(
      'matieres'
    ) as FormArray;
    if (e.target.checked) {
      console.log(matiereCheckArray.value);
      matiereCheckArray.push(new FormControl(e.target.value));
    } else {
      var i = 0;
      matiereCheckArray.controls.forEach((item: any) => {
        if (matiereCheckArray)
          if (item.value == e.target.value) {
            matiereCheckArray.removeAt(i);
            return;
          }
        i++;
      });
    }
  }
  
  _get_selected_matieres(classe: any) {
    let matieres_selected = [];
    for (const matiere_id in classe.matieres) {
      let id = classe.matieres[matiere_id];
      // chercher le user avec id #id
      let matiere = this.matieres.filter((matiere) => matiere.id == id)[0];
      matieres_selected.push(matiere);
    }
    return matieres_selected;
  }
  saveClasse(submitForm: FormGroup) {
    this.submitted = true;

    if (this.reactiveForm.invalid) {
      return;
    }
    if (submitForm.valid) {
      const classe = submitForm.value;
      var formData = new FormData();
      let matieres_selected = this._get_selected_matieres(classe);
      classe.matieres = matieres_selected;
      console.log(classe.matieres);
      var data = JSON.stringify(classe);
      console.log(data);

      formData.append('classe', data);
      console.log(formData);
      this.service.create(formData).subscribe(
        (data) => {},
        (erreur) => {
          console.error(erreur);
        }
      );
    }
  }
}
