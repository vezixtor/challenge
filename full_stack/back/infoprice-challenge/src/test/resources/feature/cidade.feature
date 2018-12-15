#language: pt
@Cidade
Funcionalidade: CRUD de cidade
  PO é o responsavel por criar as features e os scenario
  "Dado" define o estado presente do sistema, "Quando" interação do usuario e "Entao" o resultado
  Esta descrição não pode passar de 3 linhas e os scenario devem ser o mais curto possível

  Cenário: Cadastrar cidade
    Quando tento cadastrar os dados de cidade
    Então o serviço me retorna a cidade

  Cenário: Obter cidade por chave
    Dado 1 registro(s) de cidade preexistente
    Quando tento obter os dados de cidade pela chave
    Então o serviço me retorna a cidade

  Cenário: Alterar cidade por chave
    Dado 1 registro(s) de cidade preexistente
    Quando tento alterar os dados de cidade pela chave
    Então o serviço me retorna a cidade

  Cenário: Deletar cidade
    Dado 1 registro(s) de cidade preexistente
    Quando tento deletar o registro de cidade pela chave
    Então o serviço remove o registro de cidade

  Cenário: Listar cidade
    Dado 5 registro(s) de cidade preexistente
    Quando consulto a lista de cidade
    Então o serviço me retorna uma lista de cidade

