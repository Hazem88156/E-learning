import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Reunion } from 'src/app/Models/reunion';
import { ServiceReunionService } from 'src/app/services/service-reunion.service';

@Component({
  selector: 'app-add-reunion',
  templateUrl: './add-reunion.component.html',
  styleUrls: ['./add-reunion.component.css'],
})
export class AddReunionComponent implements OnInit {
  reunion: Reunion = new Reunion();
  submitted = false;
  reactiveForm!: FormGroup;
  constructor(
    private service: ServiceReunionService,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.reactiveForm = this.fb.group({
      reunionName: ['', [Validators.required]],
      createur: ['', [Validators.required]],
    });
  }
  saveForm(submitForm: FormGroup) {
    this.submitted = true;

    if (this.reactiveForm.invalid) {
      return;
    }
    if (submitForm.valid) {
      const reunion = submitForm.value;
      var formData = new FormData();
      var data = JSON.stringify(reunion);
      console.log(data);

      formData.append('reunion', data);

      this.service.create(formData).subscribe(
        (data) => {},
        (erreur) => {
          console.error(erreur);
        }
      );
    }
  }
}
