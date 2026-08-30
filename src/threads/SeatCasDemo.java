package threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class SeatCasDemo {
    enum SeatStatus { AVAILABLE, HELD, BOOKED }
    static AtomicReference<SeatStatus> seatStatus = new AtomicReference<>(SeatStatus.AVAILABLE);

    static AtomicInteger successCount = new AtomicInteger(0);
    static AtomicInteger failCount = new AtomicInteger(0);

    static boolean tryHoldSeat(String userId) {
        // compareAndSet(expectedValue, newValue) -> true only if it actually swapped
        boolean won = seatStatus.compareAndSet(SeatStatus.AVAILABLE, SeatStatus.HELD);
        if (won) {
            System.out.println(userId + " WON the seat -> status is now " + seatStatus.get());
            successCount.incrementAndGet();
        } else {
            System.out.println(userId + " FAILED  -> seat already " + seatStatus.get());
            failCount.incrementAndGet();
        }
        return won;
    }

    static void main() throws InterruptedException {
        int numUsers = 50; // 50 users all clicking "book J7" at the same instant

        ExecutorService pool = Executors.newFixedThreadPool(numUsers);
        CountDownLatch startGate = new CountDownLatch(1); // used to release all threads at once
        CountDownLatch doneGate = new CountDownLatch(numUsers);

        for (int i = 1; i <= numUsers; i++) {
            String userId = "user-" + i;
            pool.submit(() -> {
                try {
                    startGate.await(); // all threads wait here, then get released together
                    tryHoldSeat(userId);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    doneGate.countDown();
                }
            });
        }

        System.out.println("=== Releasing " + numUsers + " threads at once to race for seat J7 ===\n");
        startGate.countDown(); // fire the starting gun
        doneGate.await();      // wait for all threads to finish
        pool.shutdown();

        System.out.println("\n=== RESULT ===");
        System.out.println("Final seat status: " + seatStatus.get());
        System.out.println("Successful holds : " + successCount.get() + " (must be exactly 1)");
        System.out.println("Failed attempts  : " + failCount.get() + " (must be " + (numUsers - 1) + ")");
    }
}
