package ua.nure.bushuy;

import java.util.*;
import java.util.logging.ConsoleHandler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by sbushui on 7/18/2017.
 */
public class Part1 {
    public static String convert1(String input) {
        StringBuilder sb = new StringBuilder();
        String regex = "(\\S+);(\\S+\\s\\S+);(\\S+@\\S+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()) {
            sb.append(matcher.group(1) +" ==> " + matcher.group(3) + System.lineSeparator());
        }
        return sb.toString();
    }
    public static String convert2(String input) {
        StringBuilder sb = new StringBuilder();
        String regex = "(\\S+);(\\S+\\s\\S+);(\\S+@\\S+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()) {
            sb.append(matcher.group(1) +" (email: " + matcher.group(3) + ")" + System.lineSeparator());
        }
        return sb.toString();
    }
    public static String convert3(String input) {
        class User {
            User(String login, String domen) {
                this.login = login;
                this.domen = domen;
            }
            String login;
            String domen;
        }
        List<User> listOfUsers = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String regex = "(\\S+);(.+)(@.+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()) {
            listOfUsers.add(new User(matcher.group(1), matcher.group(3)));
        }
        Map<String, List<User>> userListGrouped =
                listOfUsers.stream().collect(Collectors.groupingBy(w -> w.domen));

        for(Map.Entry<String, List<User>> entry : userListGrouped.entrySet()) {
            sb.append(entry.getKey());
            sb.append(" ==> ");
            for(User user : entry.getValue()) {
                if(user.domen.equals(entry.getKey())) {
                    sb.append(user.login);
                    sb.append(", ");

                }
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append(System.lineSeparator());

        }
        return sb.toString();
    }
    public static String convert4(String input) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        String regexForHeaders = "^(\\S+);(\\S+)";
        Pattern pattern = Pattern.compile(regexForHeaders);
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()) {
            sb.append(matcher.group(0) + ";Password" + System.lineSeparator());
        }
        String regex = "(\\S+);(\\S+\\s\\S+);(\\S+@\\S+)";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(input);
        while(matcher.find()) {
            sb.append(matcher.group(0) +";"+ (r.nextInt(10000) + 1) + System.lineSeparator());
        }
        return sb.toString();
    }

}
