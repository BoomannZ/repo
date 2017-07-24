package ua.nure.bushuy;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sbushui on 7/18/2017.
 */
public class Part2 {
    public static String convert(String input) {
        StringBuilder sb = new StringBuilder();
        Set<String> words = new HashSet<>();
        String regexp = "(\\b[a-zA-Z']+\\b)";
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            words.add(matcher.group(0));

        }
        String[] wordsArray = (String[])words.toArray();

        int max = wordsArray[0].length();
        int min = wordsArray[0].length();

        for (int i = 0; i < wordsArray.length; i++) {
            if(max < wordsArray[i].length()) {
                max = wordsArray[i].length();

            }
            if(min > wordsArray[i].length()) {
                min = wordsArray[i].length();
            }
        }
        sb.append("Min: ");
        for (String s : wordsArray)
        {
            if(s.length() == min) {
                sb.append(s);
                sb.append(",");
            }
        }
        sb.append(System.lineSeparator());
        sb.append("Max: ");
        for (String s : wordsArray)
        {
            if(s.length() == max) {
                sb.append(s);
                sb.append(",");
            }
        }
        sb.append(System.lineSeparator());
        return sb.toString();


    }

}
