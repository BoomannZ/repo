package com.company;

/**
 * Created by sbushui on 2/14/2017.
 */
public class IronHelmet extends Decorator{
    private int weight;

    public IronHelmet(Weightable w, int weight) {
        super(w);
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return w.getWeight() + weight;
    }
}
