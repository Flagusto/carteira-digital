package br.com.carteira;

import java.math.BigDecimal;

public class CarteiraDigital {

    private BigDecimal saldo = BigDecimal.ZERO;

    public void depositar(BigDecimal valor) {
        validarValorPositivo(valor, "depósito");
        saldo = saldo.add(valor);
    }

    public void pagar(BigDecimal valor) {
        validarValorPositivo(valor, "pagamento");
        if (valor.compareTo(saldo) > 0) {
            throw new IllegalArgumentException(
                    "Saldo insuficiente: saldo atual " + saldo + ", pagamento de " + valor);
        }
        saldo = saldo.subtract(valor);
    }

    public BigDecimal consultarSaldo() {
        return saldo;
    }

    private void validarValorPositivo(BigDecimal valor, String operacao) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "O valor do " + operacao + " deve ser maior que zero");
        }
    }
}