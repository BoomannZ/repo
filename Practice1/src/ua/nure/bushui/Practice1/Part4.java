package ua.nure.bushui.Practice1;

/**
 * Created by sbushui on 6/27/2017.
 */
public class Part4 {
    public static void main(String[] args) {
        int number = Integer.parseInt(args[0]);
        int sum = 0;
        while (number != 0) {
            sum = sum + (number % 10);
            number /= 10;
        }
        System.out.println(sum);
    }
}
