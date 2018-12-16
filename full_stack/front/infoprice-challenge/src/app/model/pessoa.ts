export class Pessoa {
  id: number;
  nome: string;
  email: string;
  enderecos: any[];

  constructor() {
    this.id = 0;
    this.nome = '';
    this.email = '';
    this.enderecos = [];
  }
}
