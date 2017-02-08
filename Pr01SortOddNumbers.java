import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Pr01SortOddNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long startTime = System.currentTimeMillis();
        ArrayList<String> list = new ArrayList<>(Arrays.asList(reader.readLine().split(", ")));
        List<Integer> intList = convertList(list,s -> Integer.parseInt(s));
        intList.removeIf(n -> n % 2 != 0);
        String str = intList.toString();
        System.out.println(str.substring(1,str.length() - 1));
        intList.sort((a,b) -> a.compareTo(b));
        StringBuilder sb = new StringBuilder();
        for (Integer integer : intList) {
            sb.append(integer).append(", ");
        }
        sb.delete(sb.length()-2,sb.length()-1);
        System.out.println(sb);
    }

    public static <T, U> List<U> convertList(List<T> from, Function<T, U> func) {
        return from.stream().map(func).collect(Collectors.toList());
    }
}
