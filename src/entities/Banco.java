package entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banco {
    private List<Conta> contas = new ArrayList<>();

    public Banco(){
        Pessoa pessoa1 = new Pessoa("Tarcisio Amorim", "171.171.172-49");
        Pessoa pessoa2 = new Pessoa("Maria da Conceicao", "169.391.742-49");
        Pessoa pessoa3 = new Pessoa("Pedro Amorim", "983.635.492-15");

        Conta conta1 = new ContaInvestimento(pessoa1, 252, 1, new BigDecimal("10"), new BigDecimal("1"));
        Conta conta2 = new ContaInvestimento(pessoa2, 212, 99, new BigDecimal("0"), new BigDecimal("0"));
        Conta conta3 = new ContaInvestimento(pessoa3, 232, 9599, new BigDecimal("0"), new BigDecimal("0"));
        Conta conta4 = new ContaEspecial(pessoa1, 2221, 9199, new BigDecimal("10"), new BigDecimal("30"));
        Conta conta5 = new ContaEspecial(pessoa2, 2122, 49, new BigDecimal("10"), new BigDecimal("30"));

        conta1.depositar(new BigDecimal("120"));
        conta2.depositar(new BigDecimal("150"));
        conta3.depositar(new BigDecimal("500"));
        conta5.depositar(new BigDecimal("12000"));

        contas.add(conta1);
        contas.add(conta2);
        contas.add(conta3);
        contas.add(conta4);
        contas.add(conta5);

    }

    public List<Conta> getContas(){return contas;}

//    public Conta buscar(int agencia, int numero){
//        for (Conta conta : getContas()){
//            if(conta.getAgencia() == agencia && conta.getNumero() == numero){
//                return conta;
//            }
//        }
//        return null;
//    }

    public Optional<Conta> buscar (int agencia, int numero){
        for (Conta conta : contas){
            if (conta.getAgencia() == agencia & conta.getNumero() == numero){
                return Optional.of(conta);
            }
        }
        return Optional.empty();
    }


}
