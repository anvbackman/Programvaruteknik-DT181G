package com.dt181g.project;

import java.awt.*;

public class Coin {

    public Rectangle coin;
    public int x;
    public int y;
    public int width;
    public int height;

    public Coin(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        coin = new Rectangle(x, y, width, height);
    }

    public Rectangle getBounds() {

        return new Rectangle(x, y, width, height);
    }

    public boolean collision(Rectangle obstacle) {
        Rectangle obstacleBounds = obstacle.getBounds();

        return coin.intersects(obstacleBounds);
    }

    
}
