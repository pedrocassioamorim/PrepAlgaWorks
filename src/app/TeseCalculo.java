package app;

import java.math.BigDecimal;

public class TeseCalculo {
    public static void main(String[] args) {
//        double x = 1.0;
//
//        x = x - 0.1;
//
//        x = x - 0.2;
//
//        x = x - 0.3;
//
//        System.out.println(x);

        BigDecimal x = new BigDecimal("1");

        x = x.subtract(new BigDecimal("0.1"));
        x = x.multiply(new BigDecimal("2"));
        x = x.add(new BigDecimal("3"));
        x = x.divide(new BigDecimal("2"));
        x = x.subtract(new BigDecimal("0.3"));
        x = x.subtract(new BigDecimal("0.1"));

        System.out.println(x);
    }
}
