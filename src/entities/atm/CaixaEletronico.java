package entities.atm;

import entities.Conta;
import entities.pagamentos.DocumentoEstornavel;
import entities.pagamentos.DocumentoPagavel;

public class CaixaEletronico {

    public  void imprimirSaldo (Conta conta){
        System.out.println("Conta: " + conta.getAgencia() + "/" + conta.getNumero());
        System.out.println("Titular: " + conta.getTitular().getName());
        System.out.println("Saldo: " + conta.getSaldo());
        System.out.println("Saldo Disponivel: " + conta.getSaldoDisponivel());
    }

    public void pagar(DocumentoPagavel documentoPagavel, Conta conta){
        if(documentoPagavel.estaPago()){
            throw new IllegalStateException("Documento já está pago!");
        }
        conta.sacar(documentoPagavel.getValorTotal());
        documentoPagavel.quitarPagamento();




    }

    public void estornarPagamento(DocumentoEstornavel documentoEstornavel, Conta conta){
        if (!documentoEstornavel.estaPago()){
            throw new IllegalStateException("Documento não está pago, não pode ser estornado.");
        }
        conta.depositar(documentoEstornavel.getValorTotal());
        documentoEstornavel.estornarPagamento();
    }
}
