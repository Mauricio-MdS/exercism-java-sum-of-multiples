import java.util.function.IntFunction;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;

class SumOfMultiples {

    private final int sum;

    SumOfMultiples(int number, int[] set) {
        IntFunction<IntStream> generateMultiples = n -> IntStream.iterate(n, x -> x < number, x -> x + n);

        sum = stream(set)
                .filter(n -> n != 0)
                .flatMap(generateMultiples)
                .distinct()
                .sum();
    }

    int getSum() {
        return sum;
    }

}
