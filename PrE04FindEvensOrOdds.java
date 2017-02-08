import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class PrE04FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] bounds = reader.readLine().split(" ");
        int lower = Integer.parseInt(bounds[0]);
        int upper = Integer.parseInt(bounds[1]);

        String command = reader.readLine();

        Consumer<Integer> printer = x -> System.out.print(x + " ");
        for (int i = lower; i <= upper; i++) {
            if(inteprCommand(command).test(i)){
                printer.accept(i);
            }
        }
    }

    public static Predicate<Integer> inteprCommand(String command){
        switch (command){
            case "even":
                return x -> x  % 2 == 0;
            default:
                return x -> x % 2 != 0;
        }
    }
}
