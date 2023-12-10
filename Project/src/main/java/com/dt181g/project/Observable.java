package com.dt181g.project;

public interface Observable {

    void addObserver(Observer o);
    void removeObserver(Observer o);
    void updateObserver();
}
