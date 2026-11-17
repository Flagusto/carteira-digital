# Carteira Digital

Carteira digital em Java que permite depósitos e pagamentos, mantendo o saldo correto e recusando operações inválidas. Testes com BDD (Cucumber/Gherkin) e JUnit 5, usando Gradle.

## Regras de negócio
- O saldo inicial é zero.
- Depósitos e pagamentos devem ser maiores que zero.
- Pagamentos não podem ultrapassar o saldo.
- Operações inválidas lançam `IllegalArgumentException` e preservam o saldo.

## Integrantes
| Nome | GitHub | Contribuição |
|------|--------|--------------|
| Flavio Augusto | @Flagusto | Estrutura do projeto (Gradle) e README |
| Nicholas Breno | @nicholasbreno5 | Classe `CarteiraDigital` |
| Erick Oliveira | @erickol10 | Testes unitários JUnit 5 |
| Erick Oliveira | @erickol10 | Cenários BDD (Cucumber) |

## Tecnologias
Java 17+, Gradle, JUnit 5, Cucumber 7.

## Como executar
Pré-requisito: Java 17 ou superior. O Gradle não precisa estar instalado, porque o projeto usa o Gradle Wrapper (`gradlew`).

```bash
git clone https://github.com/SEU-USUARIO/carteira-digital.git
cd carteira-digital

./gradlew test                                # todos os testes (JUnit + BDD)
./gradlew test --tests '*CarteiraDigitalTest' # só JUnit
./gradlew test --tests '*RunCucumberTest'     # só BDD
```

No Windows, use `gradlew.bat` no lugar de `./gradlew`.

O relatório dos testes fica em `build/reports/tests/test/index.html` e o do Cucumber em `build/cucumber-report.html`.