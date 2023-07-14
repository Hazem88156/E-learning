import { Classe } from './classe';
import { Cours } from './cours';
import { Matiere } from './matiere';

export class DocumentCours {
  id!: number;
  documentName!: string;
  documentFile!: string;
  cour!: Cours;
}
