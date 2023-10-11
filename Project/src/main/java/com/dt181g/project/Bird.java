package com.dt181g.project;

import java.awt.*;

public class Bird {

    public Rectangle bird;
    public int x;
    public int y;
    public int width;
    public int height;


    public Bird(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        bird = new Rectangle(x, y, width, height);
    }
}
