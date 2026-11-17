package br.com.carteira;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarteiraDigitalTest {

    private CarteiraDigital carteira;

    @BeforeEach
    void setUp() {
        carteira = new CarteiraDigital();
    }

    @Test
    @DisplayName("(1) Depósito de 100 em saldo zero deixa saldo 100")
    void depositoDe100DeixaSaldo100() {
        carteira.depositar(new BigDecimal("100"));

        assertEquals(0, new BigDecimal("100").compareTo(carteira.consultarSaldo()));
    }

    @Test
    @DisplayName("(2) Pagamento de 40 sobre saldo 100 deixa saldo 60")
    void pagamentoDe40Sobre100DeixaSaldo60() {
        carteira.depositar(new BigDecimal("100"));

        carteira.pagar(new BigDecimal("40"));

        assertEquals(0, new BigDecimal("60").compareTo(carteira.consultarSaldo()));
    }

    @Test
    @DisplayName("(3) Pagamento de 120 sobre saldo 100 lança exceção e mantém saldo 100")
    void pagamentoDe120Sobre100LancaExcecaoEPreservaSaldo() {
        carteira.depositar(new BigDecimal("100"));

        assertThrows(IllegalArgumentException.class,
                () -> carteira.pagar(new BigDecimal("120")));

        assertEquals(0, new BigDecimal("100").compareTo(carteira.consultarSaldo()));
    }
}