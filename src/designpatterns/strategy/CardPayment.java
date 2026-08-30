package designpatterns.strategy;

import java.math.BigDecimal;

public class CardPayment implements PaymentStrategy {
    @Override
    public void pay(BigDecimal amount) {
        System.out.println("Paying CardPayment amount = " + amount);
    }
}
