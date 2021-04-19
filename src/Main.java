import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        One one = new One();
        Integer[] type_mask = {50, 20, 10};
        int req = 95;
        System.out.println("One = " + one.getResult(Arrays.asList(type_mask), req));
        //
        Two two = new Two();
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("1-0,2");
        list.add("2-0,1");
        System.out.println("Two = " + two.getResult(list));
        //
        Tree tree = new Tree();
        Integer[] oneArr = {50, 25, 20, 10};
        Integer[] twoArr = {50, 50, 50, 50};
        System.out.println(tree.getResult(Arrays.asList(oneArr), Arrays.asList(twoArr)));
        //
        Four four = new Four();
        Integer[] steps = {1, 2, 5, 1, 1, 1, 1, 2, 1, 0};
        int goal = 9;
        System.out.println(four.getResult(Arrays.asList(steps), goal));
        //
        Five five = new Five();
        int money = 90;
        Integer[] stock = {30, 65, 20, 50};
        System.out.println(five.getResult(money, Arrays.asList(stock)));
    }


}
