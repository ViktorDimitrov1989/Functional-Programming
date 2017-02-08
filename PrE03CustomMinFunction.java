import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrE03CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numbers);

        Function<int[], Integer> function = x -> x[0];
        Consumer<Integer> printer = x -> System.out.println(x);

        printer.accept(function.apply(numbers));

    }
}
