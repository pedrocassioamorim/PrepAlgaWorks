package app;

import entities.*;
import entities.atm.CaixaEletronico;
import entities.exceptions.SaldoInsuficienteException;
import entities.pagamentos.Boleto;
import entities.pagamentos.Holerite;
import entities.pagamentos.TipoPessoa;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Pessoa titular1 = new Pessoa("Pedro Amorim", "98363549215");

        Pessoa titular2 = new Pessoa("Maria Conce", "16939174249");

        CaixaEletronico caixaEletronico = new CaixaEletronico();

        ContaInvestimento minhaConta = new ContaInvestimento(titular1, 154, 1250,new BigDecimal("5000.0"), new BigDecimal("0.0"));
        Conta suaConta = new ContaInvestimento(titular2, null, null, new BigDecimal("0.0"), new BigDecimal("0"));
        ContaEspecial novaConta = new ContaEspecial(titular2, 0, 1, new BigDecimal("5000.0"), new BigDecimal("2000.0"));

        minhaConta.creditarRedimentos(new BigDecimal("1.5"));
        minhaConta.depositar(new BigDecimal(15000));
        minhaConta.debitarTarifa();
        try {
            suaConta.depositar(new BigDecimal(15000));
            suaConta.debitarTarifa();

            Boleto boletoEscola = new Boleto(titular1, new BigDecimal(200));
            System.out.println("Status Boleto: " + boletoEscola.estaPago());
            caixaEletronico.pagar(boletoEscola, minhaConta);

            caixaEletronico.imprimirSaldo(minhaConta);
            System.out.println();
            caixaEletronico.imprimirSaldo(novaConta);
            System.out.println();
            caixaEletronico.imprimirSaldo(suaConta);
            System.out.println();
            System.out.println("Status Boleto: " + boletoEscola.estaPago());
            System.out.println();

            Holerite salarioFuncionario = new Holerite(titular2, new BigDecimal("100"), 160);
            caixaEletronico.pagar(salarioFuncionario, minhaConta);
            System.out.println("Salario: " + salarioFuncionario.estaPago());
            caixaEletronico.estornarPagamento(boletoEscola, minhaConta);
            caixaEletronico.estornarPagamento(salarioFuncionario, minhaConta);
            titular1.setTipo(TipoPessoa.JURIDICA);
            boletoEscola.imprimirRecibo();

            salarioFuncionario.imprimirRecibo();

            System.out.println();
            System.out.println("Pessoa 1: " + titular1.getTipo());
            System.out.println();
            System.out.println("Pessoa 2: " + titular2.getTipo());

            System.out.println();
            System.out.println(titular1.getDataUltimaAtualizacao());
            titular2.setDataUltimaAtualizacao(LocalDateTime.parse("2023-06-27T13:20:01"));
            System.out.println(titular2.getDataUltimaAtualizacao());


        }
        catch (SaldoInsuficienteException | IllegalStateException | IllegalArgumentException e){
            System.out.println("Erro ao executar operação na conta: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException f){

        }


    }
}