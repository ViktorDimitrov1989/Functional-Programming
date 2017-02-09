import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PrE06ReverseAndExecute {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(reader.readLine());

        Predicate<String> predicate = x -> Integer.parseInt(x) % n != 0;
        Consumer<String> consumer = x -> System.out.print(x + " ");

        for (int i = input.length - 1; i >= 0; i--) {
            if(predicate.test(input[i])){
                consumer.accept(input[i]);
            }
        }


    }
}
