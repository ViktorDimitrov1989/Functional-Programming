import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PrE07PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(reader.readLine());
        String[] names = reader.readLine().split(" ");

        BiPredicate<String,Integer> predicate = (x,y) -> x.length() <= y;

        for (String name : names) {
            if(predicate.test(name,length)){
                System.out.println(name);
            }
        }
    }
}
