import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.function.Function;

public class PrE08FindTheSmallestNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");
        Function<String[], Integer> function = (arr) -> {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < arr.length; i++) {
                int num = Integer.parseInt(arr[i]);
                if(num <= min){
                    min = num;
                    index = i;
                }
            }
            return index;
        };
        Consumer<Integer> consumer = (x) -> {
            System.out.println(x);
        };

        consumer.accept(function.apply(input));
    }
}
