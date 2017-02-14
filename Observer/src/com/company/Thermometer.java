package com.company;

import java.util.ArrayList;

/**
 * Created by sbushui on 2/14/2017.
 */
public class Thermometer implements Observable{
    private int temperature;
    ArrayList<Observer> observerList;
    public Thermometer(int temperature) {

        observerList = new ArrayList();
        this.temperature = temperature;

    }


    @Override
    public void addObserver(Observer obs) {

        observerList.add(obs);

    }

    @Override
    public void removeObserver(Observer obs) {

        observerList.remove(obs);

    }

    @Override
    public void notifyObserver() {

        for (Observer o : observerList) {

            o.update(this);

        }

    }

    public int getTemperature() {
        return temperature;
    }
    public void goAhead() {

        notifyObserver();

    }
}
