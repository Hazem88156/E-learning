import { Matiere } from './matiere';
import { User } from './users';

export class Classe {
  id!: number;
  nomClasse!: string;
  matieres!: Matiere[];
  users!:User[];
  section!:string;
  annee!:string;
  
}
