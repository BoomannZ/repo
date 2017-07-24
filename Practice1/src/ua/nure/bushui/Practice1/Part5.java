package ua.nure.bushui.Practice1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sbushui on 6/27/2017.
 */
public class Part5 {
    private static Map<Character, Integer> dictionary = new HashMap<Character, Integer>();
    private static void initMap() {
        dictionary.put('A', 1);
        for(int i = 1; i < 27; i++) {
            dictionary.put((char)(64 + i), i);
        }
    }
    public static int chars2digits(String number) {
        char[] charsArray = number.toCharArray();
        int result = 0;
        for(int i = 0; i < charsArray.length; i++) {
            result += ((int)charsArray[i] - 64) * Math.pow(26,charsArray.length-i-1);
        }
        return result;
    }
    public static String digits2chars(int number) {
        char[] chars = new char[10];
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(number > 0) {
            if (number % 26 == 0) {
                chars[i] = (char)(26 + 64);
                number = (number / 26) - 1;
            } else {
                chars[i] = (char)((number % 26) + 64);
                number /= 26;
            }
            i++;
        }
        for(int j = chars.length - 1; j >= 0; j--) {
            sb.append(chars[j]);
        }
        return sb.toString();

    }
    public static String rightColumn(String number) {

        return digits2chars(chars2digits(number) + 1);
    }
}
