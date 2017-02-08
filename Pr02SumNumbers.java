import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.Function;

public class Pr02SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = reader.readLine().split(", ");

        Function<String, Integer> func = n -> Integer.parseInt(n);

        int sum = 0;
        int cnt = 0;
        for (String s: arr){
            sum += func.apply(s);
            cnt++;
        }
        System.out.println("Count = " + cnt);
        System.out.println("Sum = " + sum);
    }
}
