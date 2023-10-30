package com.dt181g.project;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.Random;

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

    public BufferedImage getObstacleImage() {
        return obstacleImage;
    }

    public Rectangle getBounds() {

        return new Rectangle(x, y, width, height);
    }

    public void addObstacle() {
        Random rand = new Random();
        int spacing = 300;
        int width = 100;
        int height = 50 + rand.nextInt(300);
        ObstacleColumn obstacleColumn = new ObstacleColumn();

        View view = new View();

        if (view.getIsRunning()) {
            obstacleList.add(new Obstacle(Window.WIDTH + width + obstacleColumn.getObstacles().size() * 300, Window.HEIGHT - height - 120));
            obstacleList.add(new Obstacle(Window.WIDTH + width + (obstacleColumn.getObstacles().size() - 1) * 300, 0));
        }
        else {
            obstacleList.add(new Obstacle(obstacleColumn.getObstacles().get(obstacleColumn.getObstacles().size() - 1).x + 600, Window.HEIGHT - height - 120));
            obstacleList.add(new Obstacle(obstacleColumn.getObstacles().get(obstacleColumn.getObstacles().size() - 1).x, 0));
        }
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
