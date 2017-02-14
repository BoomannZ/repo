package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Decorator humanInIronHelmetAndIronArmor = new IronArmor(new IronHelmet(new Human(85), 10), 50);
        System.out.println(humanInIronHelmetAndIronArmor.getWeight());

    }
}
