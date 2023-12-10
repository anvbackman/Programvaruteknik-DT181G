package com.dt181g.project.models;

/**
 * The Bird class represents the obstacles in the Flappy Bird game
 * It encapsulates the position and dimensions of the obstacles
 * @author Andreas Backman
 */
public class Obstacle {
    private int x;
    private int y;
    private int width;
    private int height;

    /**
     * Constructor that creates a new Obstacle object with specified position and dimensions
     * @param x the x-coordinates
     * @param y the y-coordinates
     * @param width the width
     * @param height the height
     */
    public Obstacle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Method to set the X-coordinates
     * @param value the new X-coordinate
     */
    public void setX(int value) {
        this.x += value;
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
