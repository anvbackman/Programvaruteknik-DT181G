package com.dt181g.project.models;

public class Background {

    private int x;
    private int y;
    private int speed;

    public Background(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public void updatePosition() {
        x -= speed;
    }

    public int getX() {
        return x;
    }


}
