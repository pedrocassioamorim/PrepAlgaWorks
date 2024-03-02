package entities;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ContaInvestimento extends Conta {
    private BigDecimal investimentos;

    public ContaInvestimento(Pessoa titular, Integer agencia, Integer numero, BigDecimal saldo, BigDecimal investimentos) {
        super(titular, agencia, numero, saldo);
        this.investimentos = investimentos;
    }

    public ContaInvestimento(BigDecimal investimentos) {
        this.investimentos = investimentos;
    }


    public void creditarRedimentos(BigDecimal percentualDeJuros){
        BigDecimal valorRendimentos = getSaldo().multiply(percentualDeJuros).divide(new BigDecimal("100"), 2, RoundingMode.HALF_EVEN);
        depositar(valorRendimentos);

    }

    @Override
    public void debitarTarifa() {
        if (getSaldo().compareTo(new BigDecimal("10000")) < 0){
            sacar(new BigDecimal("50"));
        }

    }
}
