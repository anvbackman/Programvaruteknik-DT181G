package com.dt181g.project;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bullet {

    private Rectangle bullet;
    private int x;
    private int y;
    private int width;
    private int height;
    private BufferedImage image;
    private int hits;

    public Bullet(BufferedImage image, int x, int y, int width, int height) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.hits = 0;
    }

    public void setX(int amount) {
        x += amount;
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

    public void setHits(int amount) {
        hits += amount;
    }
    public int getHits() {
        return hits;
    }


    public Rectangle getBounds() {

        return new Rectangle(x, y, width, height);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void move(int amount) {
        x += amount;
    }


}
