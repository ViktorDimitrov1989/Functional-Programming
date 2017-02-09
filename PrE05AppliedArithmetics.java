import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.function.Function;

public class PrE05AppliedArithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        int[] numbers = new int[input.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        String command;
        Consumer<Integer> printer = x -> System.out.print(x + " ");
        while (!"end".equals(command = reader.readLine())){
            Function<Integer,Integer> calcNum = getCommand(command);

            for (int i = 0; i < numbers.length; i++) {
                if(command.equals("print")){
                    printer.accept(numbers[i]);
                    return;
                }
                numbers[i] = calcNum.apply(numbers[i]);
            }
        }
        printNums(numbers);
    }

    private static void printNums(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }

    private static Function<Integer, Integer> getCommand(String command) {
        switch (command){
            case "add":
                return x -> x + 1;
            case "subtract":
                return x -> x - 1;
            //case "multiply":
            default:
                return x -> x * 2;
        }
    }
}