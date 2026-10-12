package futures;

import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.sleep;

public class APICallsChaining {
    static void main() {
        APICallsChaining apiCallsChaining = new APICallsChaining();
        CompletableFuture<Customer> customerCompletableFuture = CompletableFuture.supplyAsync(apiCallsChaining::getCustomerApiCall);
        CompletableFuture<Order> orderCompletableFuture = CompletableFuture.supplyAsync(apiCallsChaining::getOrderApiCall);
        CompletableFuture<Recommendation> recommendationCompletableFuture = CompletableFuture.supplyAsync(apiCallsChaining::getRecommendationApiCall);

        System.out.println("Executing main thread");

        CompletableFuture<Void> allOf = CompletableFuture.allOf(customerCompletableFuture, orderCompletableFuture, recommendationCompletableFuture);
        //allOf.join();

        allOf.thenApply(v -> new CustomerDashboard(customerCompletableFuture.join(), orderCompletableFuture.join(), recommendationCompletableFuture.join()));


    }



    Customer getCustomerApiCall(){

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("API1 call finished");

        return new Customer(1, "adam", "douglas");
    }

    Order getOrderApiCall(){

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Order API call finished");

        return new Order(1, "Starterd");
    }

    Recommendation getRecommendationApiCall(){

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Recommendation API call finished");

        return new Recommendation(1);
    }

    record Customer(Integer id, String firstName, String lastName){}

    record Order(Integer id, String status){}

    record Recommendation(Integer id) {}

    record CustomerDashboard(Customer customer, Order order, Recommendation recommendation){}
}
