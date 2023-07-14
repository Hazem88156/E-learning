import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  FormArray,
  FormBuilder,
  FormGroup,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { Cours } from 'src/app/Models/cours';
import { Examen } from 'src/app/Models/examen';
import { CoursServiceService } from 'src/app/services/cours-service.service';
import { ExamenServiceService } from 'src/app/services/examen-service.service';

@Component({
  selector: 'app-add-examen',
  templateUrl: './add-examen.component.html',
  styleUrls: ['./add-examen.component.css'],
})
export class AddExamenComponent implements OnInit {
  userid!: number;
  cours: Cours[] = [];
  examenForm!: FormGroup;
  constructor(
    private formBuilder: FormBuilder,
    private examenService: ExamenServiceService,
    private serviceCours: CoursServiceService,
    private router: Router
  ) {}

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
    this.initExamenForm();
  }
  initQuestion(): FormGroup {
    return this.formBuilder.group({
      questionText: ['', Validators.required],
      options: this.formBuilder.array([this.initOption()]),
      explanation: ['', Validators.required],
    });
  }
  initOption(): FormGroup {
    return this.formBuilder.group({
      text: ['', Validators.required],
      correct: [false],
    });
  }
  getControls() {
    return (this.examenForm.get('questions') as FormArray).controls;
  }
  removeQuestion(index: number): void {
    const questions = this.examenForm.get('questions') as FormArray;
    questions.removeAt(index);
  }
  addQuestion(): void {
    const questions = this.examenForm.get('questions') as FormArray;
    questions.push(this.initQuestion());
  }

  initExamenForm(): void {
    this.examenForm = this.formBuilder.group({
      cour: ['', [Validators.required]],
      examenName: ['', Validators.required],
      questions: this.formBuilder.array([this.initQuestion()]),
    });
  }
  addOption(questionIndex: number): void {
    const questions = this.examenForm.get('questions') as FormArray;
    const question = questions.at(questionIndex) as FormGroup;
    const options = question.get('options') as FormArray;
    options.push(this.initOption());
  }
  removeOption(questionIndex: number, optionIndex: number): void {
    const questions = this.examenForm.get('questions') as FormArray;
    const question = questions.at(questionIndex) as FormGroup;
    const options = question.get('options') as FormArray;
    options.removeAt(optionIndex);
  }
  getOptionsControls(questionIndex: number): AbstractControl[] {
    const questions = this.examenForm.get('questions') as FormArray;
    const question = questions.at(questionIndex) as FormGroup;
    const options = question.get('options') as FormArray;
    return options.controls;
  }
  submitExamen(): void {
    if (this.examenForm.valid) {
      const examen: Examen = this.examenForm.value as Examen;

      const selectedCourId = this.examenForm.value.cour;
      console.log('courSeleted', selectedCourId);
      const selectedCours = this.cours.filter((c) => c.id == selectedCourId);
      console.log('lllllllll', selectedCours);

      examen.cour = selectedCours[0];
      console.log(examen.cour);
      this.examenService.addExamen(examen).subscribe(
        (response) => {
          console.log('Examen added successfully:', response);
          this.examenForm.reset();
          //localStorage.setItem('examen', String(response.id));
          //this.router.navigate(['/add-question']);
        },
        (error) => {
          console.error('Error adding examen:', error);
        }
      );
    } else {
      console.error('Invalid examen form');
    }
  }
}
