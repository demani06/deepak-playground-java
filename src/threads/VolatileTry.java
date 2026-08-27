package threads;

public class VolatileTry {

    static volatile boolean running = true;

    static void main() throws InterruptedException {
        Thread t = new Thread(() -> {
            while (running) {
                System.out.println("running = " + running);
            }

            System.out.println("stopped !!!!!!");
        });

        //thread run
        t.start();
        Thread.sleep(1000);
        running= false;
    }

    /*//Effective final variable access in lambdas
    static void main() {
        int x = 0;
        Runnable runnable = () -> {
            int y = 0; y++;
          // x++; //Cannot do be done because variable x is not final or effectively final
            System.out.println("y = " + y);
        };

        runnable.run();

    }*/
}
