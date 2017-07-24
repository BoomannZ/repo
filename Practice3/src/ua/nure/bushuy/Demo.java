package ua.nure.bushuy;

public class Demo {

    public static void main(String[] args) {
	// write your code here
        String text1 = Util.readFile("part1.txt");
        String text2 = Util.readFile("part2.txt");
        System.out.println("~~~~~convert1~~~~~~");
        System.out.println(Part1.convert1(text1));
        System.out.println("~~~~~convert2~~~~~~");
        System.out.println(Part1.convert2(text1));
        System.out.println("~~~~~convert3~~~~~~");
        System.out.println(Part1.convert3(text1));
        System.out.println("~~~~~convert4~~~~~~");
        System.out.println(Part1.convert4(text1));
        System.out.println("~~~~~Part 2~~~~~~");
        System.out.println(Part2.convert(text2));
    }
}
