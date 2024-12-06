import java.util.ArrayList;
import java.util.List;

public class Sample {
    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        for(char i='a';i<='z';i++){
            list.add(i);
        }
        System.out.println(list);
        String s = "abc";
    }
}
