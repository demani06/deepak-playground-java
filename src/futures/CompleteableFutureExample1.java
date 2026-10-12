package futures;

import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.sleep;

public class CompleteableFutureExample1 {

    static void main()  {

        /*CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(CompleteableFutureExample1::apiCall1);
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(CompleteableFutureExample1::apiCall2);

        var mergedFuture = completableFuture1.*/


        CompletableFuture<String> helloFuture = CompletableFuture.supplyAsync(() -> {

            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return "Hello Dee";

        });

        System.out.println("Main thread Doing other work!!!");

        String join = helloFuture.join();

        System.out.println("join = " + join);


    }



}
