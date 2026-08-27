package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTry1 {

    private static final Semaphore SEMAPHORE = new Semaphore(2);

    private static void accessResource(int threadId){
        try {
            System.out.println("threadId = " + threadId + " waiting for permit");
            SEMAPHORE.acquire();
            System.out.println("threadId = " + threadId + " acquired permit");

            Thread.sleep(1000);

        } catch (Exception e) {
            Thread.currentThread().interrupt();

        }finally {
            System.out.println("threadId = " + threadId + " Releaseing permit");
            SEMAPHORE.release();
        }


    }

    static void main() {
        try(ExecutorService executorService =Executors.newFixedThreadPool(4)) {
            for (int i = 0; i < 4; i++) {
                int id = i;
                executorService.submit(() -> accessResource(id));
            }
        }
    }
}
