import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

public class Pr03CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] text = reader.readLine().split(" ");
        Predicate<String> pred = s -> String.valueOf(s.charAt(0)).equals(String.valueOf(s.charAt(0)).toUpperCase());
        int cnt= 0;
        StringBuilder sb = new StringBuilder();
        for(String w: text){
            if(pred.test(w)){
                cnt++;
                sb.append(w).append("\n");
            }
        }
        sb.insert(0,cnt);
        sb.insert(1,"\n");
        System.out.println(sb);
    }
}
