package com.company;

/**
 * Created by sbushui on 2/14/2017.
 */
public class Human implements Weightable {
    Human(int weight) {

        this.weight = weight;

    }
    Human() {

        this.weight = 75;

    }

    private int weight;

    @Override
    public int getWeight() {

        return weight;

    }
}
