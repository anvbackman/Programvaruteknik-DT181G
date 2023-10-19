package com.dt181g.project;

import java.awt.*;

public class PowerUp {

    public Rectangle powerUp;
    public int x;
    public int y;
    public int width;
    public int height;

    public PowerUp(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        powerUp = new Rectangle(x, y, width, height);
    }

    public Rectangle getBounds() {

        return new Rectangle(x, y, width, height);
    }
}
