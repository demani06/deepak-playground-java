package threads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

    static void main() {
        Map<String,Integer> map = new ConcurrentHashMap<>();

        map.put("AAPL", 0);

        //create threads
        Thread thread = new Thread(() -> {
            int value = map.get("AAPL");
            map.put("AAPL", value + 1);

            System.out.println("value = " + value);
        });
        thread.start();


        //create 100 threads
        Thread thread1 = new Thread();
    }
}
