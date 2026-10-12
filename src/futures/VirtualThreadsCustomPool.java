package futures;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiFunction;

public class VirtualThreadsCustomPool {

    static void main() {

        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {

            CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
                return "BAC";
            }, executorService);

            CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
                return "EFD";
            }, executorService);

            BiFunction<String, String, String> biFunction = (a, b) -> {
                System.out.println("a+b = " + a + b);
                return a + b;
            };
            System.out.println(completableFuture1.thenCombine(completableFuture2, biFunction).join());



        }

    }
}
