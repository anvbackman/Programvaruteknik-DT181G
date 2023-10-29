package com.dt181g.project;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Obstacle extends Model {

    public Rectangle obstacle;
    public int x;
    public int y;
    public int width;
    public int height;
    private BufferedImage obstacleImage;
    private boolean isTop;

    public Obstacle(int x, int y) {
        super(x, y);
        if (obstacleImage == null) {
            obstacleImage = com.dt181g.project.IMG.ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\pipe1.png");
        }
        this.image = obstacleImage;
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
    }

    @Override
    public void tick() {
        this.x -= dx;
    }

    @Override
    public void render(Graphics g, ImageObserver observer) {
        g.drawImage(image, x, y, observer);
    }


    public Rectangle getBounds() {

        return new Rectangle(x, y, width, height);
    }

//    public Obstacle(BufferedImage image, int x, int y, int width, int height, boolean isTop) {
//        this.currentImage = image;
//        this.x = x;
//        this.y = y;
//        this.width = width;
//        this.height = height;
//        this.isTop = isTop;
//        obstacle = new Rectangle(x, y, width, height);
//    }

//    public boolean collision(Coin coin) {
//        Rectangle coinBounds = coin.getBounds();
//
//        return obstacle.intersects(coinBounds);
//    }




//    public void setImage(BufferedImage image) {
//        currentImage = image;
//    }
//
//    public BufferedImage getCurrentImage() {
//        return currentImage;
//    }
//    public boolean getPosition() {
//        return isTop;
//    }

//    public int getX() {
//        return x;
//    }
//    public int getY() {
//        return y;
//    }
//    public int getWidth() {
//        return width;
//    }
//    public int getHeight() {
//        return height;
//    }

}
