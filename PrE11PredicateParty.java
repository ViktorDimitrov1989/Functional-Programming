import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.*;
import java.util.stream.Collectors;

public class PrE11PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> names = new ArrayList<>(Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList()));

        String command;

        Consumer<ArrayList<String>> consumer = (a) -> {
            String str = a.toString().substring(1,a.toString().length() - 1);
            System.out.println(str + " are going to the party!");
        };
        while (!"Party!".equals(command = reader.readLine())) {
            String[] splitedCommand = command.split(" ");
            String firstCommand = splitedCommand[0];
            String secCommand = splitedCommand[1];
            String thirdCommnad = splitedCommand[2];

            switch (firstCommand) {
                case "Remove":
                    BiPredicate<String,String> removePred = getPredicate(secCommand);
                    for (int i = 0; i < names.size(); i++) {
                        if(removePred.test(names.get(i), thirdCommnad)){
                            names.remove(i);
                        }
                    }
                break;
                case "Double":
                    BiPredicate<String,String> doublePred = getPredicate(secCommand);
                    for (int i = 0; i < names.size(); i++) {
                        if(doublePred.test(names.get(i), thirdCommnad)){
                            names.add(i,names.get(i));
                            i++;
                        }
                    }
                    break;
            }
        }
        if(names.size() != 0){
            consumer.accept(names);
            return;
        }
        System.out.println("Nobody is going to the party!");
    }

    private static BiPredicate<String, String> getPredicate(String com) {
        switch (com) {
            case "StartsWith":
                return (name,c) -> name.startsWith(c);
            case "EndsWith":
                return (name,c) -> name.endsWith(c);
            default:
                return (name, c) -> name.length() == Integer.parseInt(String.valueOf(c));
        }
    }
}
