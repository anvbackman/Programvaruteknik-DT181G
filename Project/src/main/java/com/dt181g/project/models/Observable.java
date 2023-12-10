package com.dt181g.project.models;

import com.dt181g.project.controllers.Observer;

/**
 * Observable interface used to define the Observers. The objects implementing this can then notify the observers
 * about changes
 * @author Andreas Backman
 */
public interface Observable {

    /**
     * Adds an observer to the list of observers
     * @param observer the observer
     */
    void addObserver(Observer observer);

    /**
     * Removes an observer to the list of observers
     * @param observer the observer
     */
    void removeObserver(Observer observer);

    /**
     * Notifies the observers about changes
     */
    void updateObserver();
}
