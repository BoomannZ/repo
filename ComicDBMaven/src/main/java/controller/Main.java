package controller;

import holder.PropertyHolder;

public class Main {

    public static void main(String[] args) {

        PropertyHolder ph = PropertyHolder.getInstance();
        System.out.println(ph.getProperty("db.login"));
        System.out.println();

    }
}
