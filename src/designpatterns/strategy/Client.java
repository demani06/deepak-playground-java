package designpatterns.strategy;

import java.math.BigDecimal;

public class Client {

    private final PaymentStrategy paymentStrategy;

    public Client(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    void pay(BigDecimal amount){
        paymentStrategy.pay(amount);
    }

    static void main() {
        Client cLient = new Client(new CardPayment());
        cLient.pay(BigDecimal.valueOf(32));

        Client client2 = new Client(new PaypalPayment());
        client2.pay(new BigDecimal(3));
    }
}
