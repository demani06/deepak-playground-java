package streams;

import java.util.List;
import java.util.stream.Collectors;

public class CollectorsThenExample {
    static void main() {
        List<String> names = List.of("alice","Christie","Bob");

        int totalChars = names.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.joining(","),
                        String::length
                ));
        System.out.println("totalChars = " + totalChars);
    }
}
