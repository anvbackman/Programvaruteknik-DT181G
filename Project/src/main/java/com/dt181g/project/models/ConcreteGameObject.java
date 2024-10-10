package com.dt181g.project.models;

/**
 * The ConcreteGameObject class implements the GameObjectInterface for creating Bird and Obstacle objects
 * @author Andreas Backman
 */
public class ConcreteGameObject implements GameObjectInterface {

    /**
     * Creates and returns a Bird object with coordinates and dimensions
     * @param x the x-coordinates
     * @param y the y-coordinates
     * @param width the width
     * @param height the height
     * @return the Bird coordinates
     */
    @Override
    public Bird createBird(int x, int y, int width, int height) {
        return new Bird(x, y, width, height);

    }

    /**
     * Creates and returns a Obstacle object with coordinates and dimensions
     * @param x the x-coordinates
     * @param y the y-coordinates
     * @param width the width
     * @param height the height
     * @return the Obstacle coordinates
     */
    @Override
    public Obstacle createObstacle(int x, int y, int width, int height) {
        return new Obstacle(x, y, width, height);
    }
}
