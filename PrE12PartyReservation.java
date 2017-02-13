import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.*;
import java.util.stream.Collectors;

public class PrE12PartyReservation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        ArrayList<String> names = new ArrayList<>(Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList()));

        String input;

        ArrayList<Predicate<String>> predicates = new ArrayList<>();
        BiFunction<String, String, Predicate<String>> function = (type, param) -> {
            switch (type) {
                case "Starts with":
                    return (s) -> s.startsWith(param);
                case "Ends with":
                    return (s) -> s.endsWith(param);
                case "Length":
                    return (s) -> s.length() == Integer.parseInt(String.valueOf(param));
                default:
                    return (s) -> s.contains(param);
            }
        };

        BiConsumer<ArrayList<String>, ArrayList<Predicate<String>>> printer = (namesList, pred) -> {
            ArrayList<String> tmp = new ArrayList<>(namesList);
            boolean isRemoved = false;
            for (int i = 0; i < tmp.size(); i++) {
                for (Predicate predicate : pred) {
                    if(isRemoved){
                        break;
                    }
                    String name = tmp.get(i);
                    if (predicate.test(name)) {
                        tmp.remove(i);
                        i--;
                        isRemoved = true;
                    }
                }
                isRemoved = false;
            }
            String result = tmp.stream().collect(Collectors.joining(" "));
            System.out.println(result);
        };

        while (!"Print".equals(input = reader.readLine())) {
            String[] splittedCommands = input.split(";");
            String com = splittedCommands[0];
            String filterType = splittedCommands[1];
            String filterParam = splittedCommands[2];

            switch (com) {
                case "Add filter":
                    predicates.add(function.apply(filterType, filterParam));
                    break;
                case "Remove filter":
                    predicates = removePredicate(filterType,filterParam, predicates);
                    break;
                default:
                    printer.accept(names, predicates);
                    break;
            }
        }
        printer.accept(names, predicates);
    }

    private static ArrayList<Predicate<String>> removePredicate(String filterType,
                                                                String filterParam,
                                                                ArrayList<Predicate<String>> predicates) {
        switch (filterType){
            case "Starts with":
                for (Predicate<String> predicate : predicates) {
                    if(predicate.test(filterParam + "abc")){
                        predicates.remove(predicate);
                        break;
                    }
                }
                break;
            case "Ends with":
                for (Predicate<String> predicate : predicates) {
                    if(predicate.test("abc" + filterParam)){
                        predicates.remove(predicate);
                        break;
                    }
                }
                break;
            default:
                predicates.remove(0);
        }
        return predicates;
    }
}
