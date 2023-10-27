package com.dt181g.project;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Obstacle {

    public Rectangle obstacle;
    public int x;
    public int y;
    public int width;
    public int height;
    private BufferedImage currentImage;
    private boolean isTop;

    public Obstacle(BufferedImage image, int x, int y, int width, int height, boolean isTop) {
        this.currentImage = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isTop = isTop;
        obstacle = new Rectangle(x, y, width, height);
    }

    public boolean collision(Coin coin) {
        Rectangle coinBounds = coin.getBounds();

        return obstacle.intersects(coinBounds);
    }


    public Rectangle getBounds() {

        return new Rectangle(x, y, width, height);
    }

    public void setImage(BufferedImage image) {
        currentImage = image;
    }

    public BufferedImage getCurrentImage() {
        return currentImage;
    }
    public boolean getPosition() {
        return isTop;
    }


}
