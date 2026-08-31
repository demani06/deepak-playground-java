package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
    static void main() {
        String[] wordsList = {"Hello","world"};

        List<String> chars = Arrays.stream(wordsList)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .toList();

        System.out.println("chars = " + chars);

    }
}
