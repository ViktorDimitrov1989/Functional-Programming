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
        BiFunction<String, String, Predicate<String>> function = (type,param) -> {
          switch (type){
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

        BiConsumer<ArrayList<String>, ArrayList<Predicate<String>>> printer = (a,pred) -> {//TODO for each name test all predicates
                for (String anA : a) {
                    for (int i = 0; i < pred.size(); i++) {
                        if (pred.get(i).test(anA)) {
                            System.out.print(anA + " ");
                        }
                    }
                }
        };

        while (!"Print".equals(input = reader.readLine())){
            String[] splittedCommands = input.split(";");
            String com = splittedCommands[0];
            String filterType = splittedCommands[1];
            String filterParam = splittedCommands[2];

            switch (com){
                case "Add filter":
                    predicates.add(function.apply(filterType,filterParam));
                    break;
                case "Remove filter":
                    predicates.remove(function.apply(filterType, filterParam));
                    break;
                default:
                    printer.accept(names,predicates);
                    break;
            }
        }
        printer.accept(names,predicates);
    }
}
