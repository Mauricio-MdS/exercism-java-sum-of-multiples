import java.util.Arrays;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SumOfMultiples {

    private final int number;
    private final Set<Integer> set;

    SumOfMultiples(int number, int[] set) {
        this.number = number;
        this.set = Arrays.stream(set).filter(i -> i != 0).boxed().collect(Collectors.toSet());
    }

    int getSum() {
        Function<Integer, IntStream> multiples = n -> IntStream.iterate(n, i -> n + i)
                .limit((number - 1) / n);

        return set.stream()
                .flatMapToInt(multiples)
                .distinct()
                .sum();
    }

}
