package streams;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequentNumber {

    static void main() {
        List<Integer> numbers =
                List.of(5, 2, 8, 2, 5, 5, 9, 2);
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer number : numbers) {
            map.merge(number, 1, (x, y) -> x+y);
        }

        System.out.println("map = " + map);

        Map.Entry<Integer, Integer> integerIntegerEntry = map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow();

        System.out.println("max value entry  = " + integerIntegerEntry);

       // Return ALL numbers that have the highest frequency."
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toSet());

    }
}
