package com.company;

/**
 * Created by sbushui on 2/14/2017.
 */
public abstract class Decorator implements Weightable{

    public Decorator(Weightable w) {

        this.w = w;

    }

    Weightable w;

    @Override
    public int getWeight() {
        return w.getWeight();
    }
}
