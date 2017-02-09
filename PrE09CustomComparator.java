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

        Arrays.sort(numbers, new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                Integer num1 = Math.abs(i1 % 2);
                Integer num2 = Math.abs(i2 % 2);

                return num1.compareTo(num2);
            }
        });


        for (Integer num: numbers){
            System.out.print(num + " ");
        }
    }
}
