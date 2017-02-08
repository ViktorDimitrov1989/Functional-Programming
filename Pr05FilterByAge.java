import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Pr05FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(", ");
            String name = line[0];
            int age = Integer.parseInt(line[1]);

            map.put(name, age);
        }
        String condition = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        String format = reader.readLine();

        Predicate<Integer> tester = createTester(condition, age);
        Consumer<Map.Entry<String, Integer>> printer = createPrinter(format);

        printFilteredStudents(map,tester,printer);

    }

    private static Consumer<Map.Entry<String, Integer>> createPrinter(String format) {
        switch (format) {
            case "name age":
                return person -> System.out.printf("%s - %d%n", person.getKey(), person.getValue());
            case "name":
                return person -> System.out.printf("%s%n", person.getKey());
            case "age":
                return person -> System.out.printf("%d%n", person.getValue());
            default:
                return person -> System.out.printf("");
        }
    }

    private static Predicate<Integer> createTester(String condition, int age) {
        switch (condition) {
            case "younger":
                return x -> x < age;
            case "older":
                return x -> x >= age;
            default:
                return x -> x == age;
        }
    }

    public static void printFilteredStudents(
            LinkedHashMap<String, Integer> students,
            Predicate<Integer> tester,
            Consumer<Map.Entry<String, Integer>> printer) {
        for (Map.Entry<String,Integer> person : students.entrySet()) {
            if(tester.test(students.get(person.getKey()))){
                printer.accept(person);
            }
        }
    }

}
