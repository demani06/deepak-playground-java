package designpatterns.strategy;

import java.math.BigDecimal;

public class PaypalPayment implements PaymentStrategy {
    @Override
    public void pay(BigDecimal amount) {
        System.out.println("Paying Payment amount = " + amount);
    }
}
