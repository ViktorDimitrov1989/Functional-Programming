import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.UnaryOperator;

public class Pr04AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] text = reader.readLine().split(", ");

        UnaryOperator<Double> unary = d -> d * 1.20;

        System.out.println("Prices with VAT:");
        for (String s : text) {
            String number = String.format("%.2f", unary.apply(Double.parseDouble(s)));

            System.out.println(number.replace(".",","));
        }
    }
}
