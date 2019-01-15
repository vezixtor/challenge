import { Estado } from './estado';

export class Cidade {
  id: number;
  nome: string;
  estado: Estado;

  constructor() {
    this.id = 0;
    this.nome = '';
    //this.estado = Estado.SP;
  }
}
