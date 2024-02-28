package com.dt181g.project.models;


/**
 * The GameObjectInterface is used to create game objects such as the Bird and Obstacles
 * @author Andreas Backman
 */
public interface GameObjectInterface {

    /**
     * Method to create and return a Bird object
     * @param x the x-coordinates
     * @param y the y-coordinates
     * @param width the width
     * @param height the height
     * @return the Bird object
     */
    Bird createBird(int x, int y, int width, int height);

    /**
     * Method to create and return a Obstacle object
     * @param x the x-coordinates
     * @param y the y-coordinates
     * @param width the width
     * @param height the height
     * @return the Obstacle object
     */
    Obstacle createObstacle(int x, int y, int width, int height);
}
