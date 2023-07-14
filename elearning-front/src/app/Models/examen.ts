import { Cours } from './cours';
import { Question } from './question';

export class Examen {
  id!: number;
  examenName!: string;
  questions!: Question[];
  cour!: Cours;
}
