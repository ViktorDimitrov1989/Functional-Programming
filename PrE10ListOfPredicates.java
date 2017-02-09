import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class PrE10ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        int[] sequence = Stream.of(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        BiPredicate<Integer, int[]> predicate = (a, b) -> {
            for (int i = 0; i < b.length; i++) {
                double num = Double.parseDouble(String.valueOf(a)) / b[i];
                if (num % 1 != 0) {
                    return false;
                }
            }
            return true;
        };


        for (int j = 1; j <= n; j++) {
            if (predicate.test(j,sequence)) {
                System.out.print(j + " ");
            }
        }


    }
}
