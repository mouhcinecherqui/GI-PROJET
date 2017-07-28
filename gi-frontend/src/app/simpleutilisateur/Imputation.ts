export class Imputation {
  date: Date;
  jour: string;
  id: number;
  codeProjet: string;
  codeAlliance: string;

  constructor(private lJour: string) {
    this.jour = lJour;
  }
}
