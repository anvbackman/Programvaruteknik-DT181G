package com.dt181g.project;

public interface GameObjectInterface {
    Bird createBird(int x, int y, int width, int height);
    Obstacle createObstacle(int x, int y, int width, int height);
}
