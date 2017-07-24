package ua.nure.bushui.Practice1;

/**
 * Created by sbushui on 6/27/2017.
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("===part 1===");
        Part1.main(new String[] {});
        System.out.println("===part 2===");
        Part2.main(new String[] {"6", "3"});
        System.out.println("===part 3===");
        Part3.main(new String[] {"20", "5"});
        System.out.println("===part 4===");
        Part4.main(new String[] {"8954"});
        System.out.println("===part 5===");
        System.out.println("AA as digits: " + Part5.chars2digits("AA"));
        System.out.println("57 as chars: " + Part5.digits2chars(57));
        System.out.println("Next after BA is: " + Part5.rightColumn("BA"));
    }
}
