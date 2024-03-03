package com.dt181g.project.models;

/**
 * The Bird class represents the playable character in the Flappy Bird game
 * It encapsulates the position and dimensions of the bird
 * @author Andreas Backman
 */
public class Bird {
    private final int x;
    private int y;
    private final int width;
    private final int height;

    /**
     * Constructor that creates a new Bird object with specified position and dimensions
     * @param x the x-coordinates
     * @param y the y-coordinates
     * @param width the width
     * @param height the height
     */
    public Bird(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Method to set the Y-coordinates
     * @param value the new Y-coordinate
     */
    public void setY(int value) {
        this.y = value;
    }

    /**
     * Method to get the X-coordinates
     * @return the X-coordinates
     */
    public int getX() {
        return x;
    }

    /**
     * Method to get the Y-coordinates
     * @return the Y-coordinates
     */
    public int getY() {
        return y;
    }

    /**
     * Method to get the width
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Method to get height
     * @return the height
     */
    public int getHeight() {
        return height;
    }
}
