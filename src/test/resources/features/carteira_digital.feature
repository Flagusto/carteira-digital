# language: pt
Funcionalidade: Carteira Digital
  Como usuário de uma carteira digital
  Quero depositar e pagar valores
  Para manter meu saldo sempre correto

  Cenário: Depositar R$ 100 em saldo zero
    Dado que tenho uma carteira com saldo de R$ 0
    Quando eu deposito R$ 100
    Então o saldo deve ser R$ 100

  Cenário: Pagar R$ 40 com saldo de R$ 100
    Dado que tenho uma carteira com saldo de R$ 100
    Quando eu pago R$ 40
    Então o saldo deve ser R$ 60

  Cenário: Tentar pagar R$ 120 com saldo de R$ 100
    Dado que tenho uma carteira com saldo de R$ 100
    Quando eu tento pagar R$ 120
    Então deve ocorrer um erro de operação inválida
    E o saldo deve ser R$ 100