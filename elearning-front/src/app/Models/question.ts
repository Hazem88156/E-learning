import { Options } from './options';

export class Question {
  id!: number;
  questionText!: string;
  options!: Options[];
  explanation!: string;
}
