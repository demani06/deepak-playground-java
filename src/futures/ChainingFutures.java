package futures;

import java.util.concurrent.CompletableFuture;

public class ChainingFutures {

    static void main() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "123")
                .thenApply(s -> s + 456);

        System.out.println(future.join());
    }
}
