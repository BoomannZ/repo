package ua.nure.bushui.Practice1;

/**
 * Created by sbushui on 6/27/2017.
 */
public class Part3 {
    public static void main(String[] args) {
        int firstValue = Integer.parseInt(args[0]);
        int secondValue = Integer.parseInt(args[1]);

        while (secondValue != 0)   {
            int tmp = firstValue % secondValue;
            firstValue = secondValue;
            secondValue = tmp;
        }
        System.out.println(firstValue);
    }
}
