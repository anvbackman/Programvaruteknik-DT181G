package com.dt181g.laboration_2;

public interface Observable {
    void add(Observer observer);
    void remove(Observer observer);
    void notifyObserver();



}
