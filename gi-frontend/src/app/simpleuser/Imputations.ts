import {Projet} from '../superuser/projet';
import {Calendrier} from './Calendrier';
import {Imputation} from './Imputation';

export class Imputations {
  id: number;
  calendrier?: Calendrier;
  projet?: Projet;
  listeImputation?: Imputation[];

}
