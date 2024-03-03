package com.dt181g.project.models;

/**
 * The Background class represents the background in the Flappy Bird game
 * It encapsulates the position and speed of the background
 * @author Andreas Backman
 */
public class Background {

    private int x;
    private final int speed;

    /**
     * Constructor that creates a new Background object with specified position and speed
     * @param x the x-coordinates
     * @param speed the speed
     */
    public Background(int x, int speed) {
        this.x = x;
        this.speed = speed;
    }

    /**
     * Method to update the position of the background
     */
    public void updatePosition() {
        x -= speed;
    }

    /**
     * Method to get the X-coordinates
     * @return the X-coordinates
     */
    public int getX() {
        return x;
    }
}
