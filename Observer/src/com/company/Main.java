package com.company;

public class Main {
    public static void main(String[] args) {

        Thermometer thermometer = new Thermometer(65);
        ClimateControl climateControl = new ClimateControl(44);
        Display display = new Display();
        thermometer.addObserver(climateControl);
        thermometer.addObserver(display);
        thermometer.goAhead();

    }
}
