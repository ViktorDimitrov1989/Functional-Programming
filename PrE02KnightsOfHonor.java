import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class PrE02KnightsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] strings = reader.readLine().split(" ");

        Consumer<String> printer = x -> System.out.printf("Sir %s%n", x);

        for (String string : strings) {
            printer.accept(string);
        }
    }
}
