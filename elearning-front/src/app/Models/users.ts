import { Classe } from './classe';
import { Matiere } from './matiere';

export class User {
  id!: number;
  username!: string;
  email!: string;
  roles!: string;
  token?: string;
  firstName!: string;
  lastName!: string;
  password!: string;
  addresse!: string;
  telephone!: string;
  status!: string;
  ncin!: string;
  apropos!: string;
  imgfile!: File;
  isselected = false;
  classe_id!: number;
  matieres!: Matiere[];
  classesEtudiant!: Classe;
}
