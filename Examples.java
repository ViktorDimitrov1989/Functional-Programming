import java.util.function.Function;

public class Examples {
    public static void main(String[] args) {
        int a = 3;
        int b = operation(a, x -> x * 2);
        System.out.println(b);



    }

    private static int operation(int a, Function<Integer,Integer> function) {
        return function.apply(a);
    }


}
