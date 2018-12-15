#language: pt
@Endereco
Funcionalidade: CRUD de endereco
  PO é o responsavel por criar as features e os scenario
  "Dado" define o estado presente do sistema, "Quando" interação do usuario e "Entao" o resultado
  Esta descrição não pode passar de 3 linhas e os scenario devem ser o mais curto possível

  Cenário: Cadastrar endereco
    Quando tento cadastrar os dados de endereco
    Então o serviço me retorna a endereco

  Cenário: Obter endereco por chave
    Dado 1 registro(s) de endereco preexistente
    Quando tento obter os dados de endereco pela chave
    Então o serviço me retorna a endereco

  Cenário: Alterar endereco por chave
    Dado 1 registro(s) de endereco preexistente
    Quando tento alterar os dados de endereco pela chave
    Então o serviço me retorna a endereco

  Cenário: Deletar endereco
    Dado 1 registro(s) de endereco preexistente
    Quando tento deletar o registro de endereco pela chave
    Então o serviço remove o registro de endereco

  Cenário: Listar endereco
    Dado 5 registro(s) de endereco preexistente
    Quando consulto a lista de endereco
    Então o serviço me retorna uma lista de endereco

