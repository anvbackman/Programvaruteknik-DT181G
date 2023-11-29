package com.dt181g.project;

import java.awt.*;

public class Bird {

    private int x;
    private int y;
    private int width;
    private int height;

    public Bird(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
//        System.out.println("Bird is set with: " + this.x + y + width + height);
    }

    public void setY(int value) {
        this.y = value;
    }

    public void setX(int value) {
        this.y = value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
