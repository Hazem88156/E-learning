import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Question } from 'src/app/Models/question';
import { ExamenServiceService } from 'src/app/services/examen-service.service';
import { QuestionServiceService } from 'src/app/services/question-service.service';

@Component({
  selector: 'app-add-question',
  templateUrl: './add-question.component.html',
  styleUrls: ['./add-question.component.css'],
})
export class AddQuestionComponent implements OnInit {
  questionForm!: FormGroup;
  idExamen!: number;
  constructor(
    private formBuilder: FormBuilder,
    private questionService: QuestionServiceService,
    private examenService: ExamenServiceService
  ) {}

  ngOnInit(): void {
    this.initQuestionForm();
    this.idExamen = Number(localStorage.getItem('examen'));
  }
  initOption(): FormGroup {
    return this.formBuilder.group({
      text: ['', Validators.required],
      correct: [false],
    });
  }
  getControls() {
    return (this.questionForm.get('options') as FormArray).controls;
  }
  initQuestionForm(): void {
    this.questionForm = this.formBuilder.group({
      questionText: ['', Validators.required],
      options: this.formBuilder.array([this.initOption()]),
      explanation: ['', Validators.required],
    });
  }
  addOption(): void {
    const options = this.questionForm.get('options') as FormArray;
    options.push(this.initOption());
  }

  removeOption(index: number): void {
    const options = this.questionForm.get('options') as FormArray;
    options.removeAt(index);
  }

  submitQuestion(): void {
    if (this.questionForm.valid) {
      const question: Question = this.questionForm.value as Question;
      this.questionService.addQuestion(question).subscribe(
        (response) => {
          console.log('Examen added successfully:', response);
          this.questionForm.reset();
          //localStorage.setItem('examen', String(response.id));
          //this.router.navigate(['/add-question']);
        },
        (error) => {
          console.error('Error adding examen:', error);
        }
      );
    }
  }
}
