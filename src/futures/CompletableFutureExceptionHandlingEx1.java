package futures;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExceptionHandlingEx1 {

    static void main() {
        CompletableFuture<String> future1 = CompletableFuture.<String>supplyAsync(() -> {
            throw new RuntimeException("Failed");
        }).exceptionally(ex -> "Default value");

        System.out.println("Main thread executing...");
        System.out.println("future1 return value = " + future1.join());
    }
}
