package com.dt181g.project;

import java.awt.*;

public class Obstacle {

    public Rectangle obstacle;
    public int x;
    public int y;
    public int width;
    public int height;

    public Obstacle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        obstacle = new Rectangle(x, y, width, height);
    }
}
