package entities;

import java.math.BigDecimal;

public class ContaEspecial extends Conta {
    private BigDecimal valorLimite;

    public ContaEspecial(Pessoa titular, Integer agencia, Integer numero, BigDecimal saldo, BigDecimal valorLimite) {
        super(titular, agencia, numero, saldo);
        this.valorLimite = valorLimite;
    }

    public ContaEspecial(BigDecimal valorLimite) {
        this.valorLimite = valorLimite;
    }

    public ContaEspecial(Pessoa pessoa1, int agencia, int numero) {
    }

    public BigDecimal getValorLimite() {
        return valorLimite;
    }

    public void setValorLimite(BigDecimal valorLimite) {
        this.valorLimite = valorLimite;
    }

    @Override
    public BigDecimal getSaldoDisponivel(){
        return getSaldo().add(getValorLimite());
    }

    @Override
    public void debitarTarifa() {
        sacar(new BigDecimal("20"));
    }
}
