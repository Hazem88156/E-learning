import { Classe } from './classe';
import { DocumentCours } from './documentCours';
import { Matiere } from './matiere';
import { User } from './users';

export class Cours {
  id!: number;
  classe!: Classe;
  user!: User;
  matiere!: Matiere;
  nomCours!: string;
  documents!: DocumentCours[];
}
