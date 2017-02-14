package com.company;

public class Display implements Observer{
    @Override
    public void update(Observable observable) {
        System.out.println("It is " + ((Thermometer) observable).getTemperature() + " degrees.");
    }
}
