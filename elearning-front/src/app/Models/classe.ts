import { Matiere } from './matiere';
import { User } from './users';

export class Classe {
  id!: number;
  nomClasse!: string;
  users!: User[];
  matieres!: Matiere[];
  users_id!: number;
}
