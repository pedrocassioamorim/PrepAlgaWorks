package entities;

import entities.exceptions.SaldoInsuficienteException;

import java.math.BigDecimal;

public abstract class Conta {
    private Pessoa titular;
    private Integer agencia;
    private Integer numero;
    private BigDecimal saldo = BigDecimal.ZERO;
    private Boolean test;



    public Conta(Pessoa titular, Integer agencia, Integer numero, BigDecimal saldo) {
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
    }

    public Conta(){};

    public Pessoa getTitular() {
        return titular;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public BigDecimal getSaldoDisponivel(){
        return getSaldo();
    }


    public void depositar(BigDecimal valor){
        if (valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Valor deve ser maior que 0.");
        }

        saldo = saldo.add(valor);
    }

    public void sacar(BigDecimal valor){
        if (valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Valor deve ser maior que 0.");
        }
        if (getSaldoDisponivel().subtract(valor).compareTo(BigDecimal.ZERO) < 0){
            throw new SaldoInsuficienteException("Saldo Insuficiente, bro!");
        }
        saldo = saldo.subtract(valor);
    }

    public void sacar(BigDecimal valor, BigDecimal taxaDeSaque){
        sacar(valor.add(taxaDeSaque));
    }

    public abstract void debitarTarifa();
}
