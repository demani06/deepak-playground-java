package threads;

public class VolatileIncrementOperation {
    static volatile int counter = 0;

    static void main() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter++;
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter++;
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("counter = " + counter);
    }
}
