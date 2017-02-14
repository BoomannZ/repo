package com.company;

/**
 * Created by sbushui on 2/14/2017.
 */
public class IronArmor extends Decorator {

    private int weight;

    public IronArmor(Weightable w, int weight) {
        super(w);
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return super.getWeight() + weight;
    }
}
