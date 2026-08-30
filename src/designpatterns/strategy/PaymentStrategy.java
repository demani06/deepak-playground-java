package designpatterns.strategy;

import java.math.BigDecimal;

public interface PaymentStrategy {
    void pay(BigDecimal amount);
}
