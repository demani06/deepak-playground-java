package streams;

import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class FibnocciIntSupplier {
    static void main() {
        IntSupplier intSupplier = new IntSupplier() {
            private int previous = 0;
            private int current = 1;
            @Override
            public int getAsInt() {
               int oldPrevious = this.previous;
               int nextValue = this.previous + this.current;
               this.previous = this.current;
               this.current = nextValue;
               return oldPrevious;
            }
        };

        IntStream.generate(intSupplier).limit(10).forEach(System.out::println);

    }
}
