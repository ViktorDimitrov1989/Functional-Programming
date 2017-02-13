import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class PrE09CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer[] numbers = Stream.of(reader.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        Comparator<Integer> comparator = (n1,n2) -> {
            Integer num1 = Math.abs(n1 % 2);
            Integer num2 = Math.abs(n2 % 2);
            return num1.compareTo(num2);
        };

        Comparator<Integer> lastComparator = comparator.thenComparing((n1,n2) -> n1 - n2);

        Arrays.stream(numbers)
                .sorted(lastComparator)
                .forEach(n -> System.out.print(n + " "));
    }
}
