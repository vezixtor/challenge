#language: pt
@Pessoa
Funcionalidade: CRUD de pessoa
  PO é o responsavel por criar as features e os scenario
  "Dado" define o estado presente do sistema, "Quando" interação do usuario e "Entao" o resultado
  Esta descrição não pode passar de 3 linhas e os scenario devem ser o mais curto possível

  Cenário: Cadastrar pessoa
    Quando tento cadastrar os dados de pessoa
    Então o serviço me retorna a pessoa

  Cenário: Obter pessoa por chave
    Dado 1 registro(s) de pessoa preexistente
    Quando tento obter os dados de pessoa pela chave
    Então o serviço me retorna a pessoa

  Cenário: Alterar pessoa por chave
    Dado 1 registro(s) de pessoa preexistente
    Quando tento alterar os dados de pessoa pela chave
    Então o serviço me retorna a pessoa

  Cenário: Deletar pessoa
    Dado 1 registro(s) de pessoa preexistente
    Quando tento deletar o registro de pessoa pela chave
    Então o serviço remove o registro de pessoa

  Cenário: Listar pessoa
    Dado 5 registro(s) de pessoa preexistente
    Quando consulto a lista de pessoa
    Então o serviço me retorna uma lista de pessoa

