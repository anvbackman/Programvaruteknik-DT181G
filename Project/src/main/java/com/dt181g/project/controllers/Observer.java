package com.dt181g.project.controllers;

/**
 * The Observer interface is used for the object that want to be notified of changes.
 * @author Andreas Backman
 */
public interface Observer {

    /**
     * Method to be called by an observable object to notify observers of changes
     */
    void updateObserver();
}
