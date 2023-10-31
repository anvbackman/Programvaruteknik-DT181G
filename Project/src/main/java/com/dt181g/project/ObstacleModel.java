package com.dt181g.project;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ObstacleModel {


    private int x;
    private int y;
    private int width;
    private int height;
    private BufferedImage obstacleImage;
    private BufferedImage obstacleImageTop;
    private BufferedImage obstacleImageBottom;

    private boolean isTop;

    public ObstacleModel(BufferedImage obstacleImage, int x, int y, int width, int height, boolean isTop) {
        this.obstacleImage = obstacleImage;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isTop = isTop;
        this.obstacleImageTop = null;
        this.obstacleImageBottom = null;
//        obstacle = new Rectangle(x, y, width, height);
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



//    public boolean collision(Coin coin) {
//        Rectangle coinBounds = coin.getBounds();
//
//        return obstacle.intersects(coinBounds);
//    }


    public Rectangle getBounds() {

        return new Rectangle(x, y, width, height);
    }

    public void setPosition(BufferedImage image) {
        obstacleImage = image;
    }

    private void updateImage() {
        if (getPosition()) {
            obstacleImage = obstacleImageTop;
        }
        else {
            obstacleImage = obstacleImageBottom;
        }
    }







    public BufferedImage getObstacleImage() {
        return obstacleImage;
    }
    public boolean getPosition() {
        return isTop;
    }


}
