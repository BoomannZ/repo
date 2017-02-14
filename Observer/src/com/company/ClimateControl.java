package com.company;

public class ClimateControl implements Observer {

    private int lastTemperature;

    public ClimateControl(int lastTemperature) {

        this.lastTemperature = lastTemperature;

    }

    @Override
    public void update(Observable observable) {

        int currentTemperature = ((Thermometer) observable).getTemperature();

        if (currentTemperature > lastTemperature) {

            System.out.println("I need conditioner!");

        }
        if (currentTemperature < lastTemperature) {

            System.out.println("I need heater!");

        }
        if (currentTemperature == lastTemperature) {

            System.out.println("It is OK!");

        }

        lastTemperature = currentTemperature;
    }
}
