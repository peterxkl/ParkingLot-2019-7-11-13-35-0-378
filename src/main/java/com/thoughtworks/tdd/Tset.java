import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tset {
    public  static void main(String[] args){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(9);
        System.out.println(Collections.max(list));
    }
}
