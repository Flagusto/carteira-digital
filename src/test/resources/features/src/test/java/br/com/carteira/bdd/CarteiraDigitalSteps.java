package br.com.carteira.bdd;

import br.com.carteira.CarteiraDigital;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CarteiraDigitalSteps {

    private CarteiraDigital carteira;
    private Exception erro;

    @Dado("que tenho uma carteira com saldo de R$ {int}")
    public void queTenhoUmaCarteiraComSaldoDe(int saldoInicial) {
        carteira = new CarteiraDigital();
        if (saldoInicial > 0) {
            carteira.depositar(new BigDecimal(saldoInicial));
        }
    }

    @Quando("eu deposito R$ {int}")
    public void euDeposito(int valor) {
        carteira.depositar(new BigDecimal(valor));
    }

    @Quando("eu pago R$ {int}")
    public void euPago(int valor) {
        carteira.pagar(new BigDecimal(valor));
    }

    @Quando("eu tento pagar R$ {int}")
    public void euTentoPagar(int valor) {
        try {
            carteira.pagar(new BigDecimal(valor));
        } catch (Exception e) {
            erro = e;
        }
    }

    @Então("o saldo deve ser R$ {int}")
    public void oSaldoDeveSer(int saldoEsperado) {
        assertEquals(0, new BigDecimal(saldoEsperado).compareTo(carteira.consultarSaldo()));
    }

    @Então("deve ocorrer um erro de operação inválida")
    public void deveOcorrerUmErroDeOperacaoInvalida() {
        assertNotNull(erro, "Era esperado um erro, mas a operação foi aceita");
        assertInstanceOf(IllegalArgumentException.class, erro);
    }
}