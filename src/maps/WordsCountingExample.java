package maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordsCountingExample {
    static void main() {


        List<String> words = List.of("Orange", "Red","Orange","Green", "Orange", "Red");


        //Using Streams
        Map<String, Long> collect = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("collect = " + collect);

        //Using maps.merge
        Map<String, Long> map = new HashMap<>(12);

        for (String word : words) {
            map.merge(word, 1L, Long::sum);
        }
        System.out.println("map = " + map);

    }
}
