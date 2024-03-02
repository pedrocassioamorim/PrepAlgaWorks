package app;

import entities.Banco;
import entities.Conta;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class Principal {
    public static void main(String[] args) {
        Banco banco = new Banco();

        banco.buscar(252,1).ifPresent(conta -> System.out.println(conta.getSaldo()));

        Optional<Conta> contaOptional = banco.buscar(252, 1);

        contaOptional.ifPresent(conta -> System.out.println(conta.getSaldo()));

        if (contaOptional.isPresent()) {
            Conta contaEncontrada = contaOptional.get();
            System.out.println(contaEncontrada.getSaldo());
        }

        banco.buscar(252,1).orElseThrow(() -> new RuntimeException("Conta não encontrada."));

        BigDecimal saldo = banco.buscar(252,1).map(conta -> conta.getSaldo()).orElse(BigDecimal.ZERO);
        System.out.println(saldo);

    }
}
