import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class PrE13InfernoIII {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> gems = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String line;
        while (!"Forge".equals(line = reader.readLine())){
            String[] tokens = line.split(";");
            String command = tokens[0];
            String filterType = tokens[1];
            int filterParam = Integer.valueOf(tokens[2]);




        }


    }
}
