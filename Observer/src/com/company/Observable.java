package com.company;

public interface Observable {
    void addObserver(Observer obs);
    void removeObserver(Observer obs);
    void notifyObserver();
}
