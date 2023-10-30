package com.dt181g.project;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.nio.Buffer;

public class Bird extends Model {

    //    public Rectangle bird;
//    public int x;
//    public int y;
//    public int width;
//    public int height;
    private BufferedImage birdImage;
    private BufferedImage birdImageJump;
    private Obstacle[] obstacle;
    private boolean isJumping;
    private int speed;

    public Bird(int x, int y) {
        super(x, y);
        if (birdImage == null) {
            birdImage = com.dt181g.project.IMG.ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\flappy1.png");
        }
        this.image = birdImage;
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
        this.x -= width;
        this.y -= height;
        obstacle = new Obstacle[1];
        obstacle[0] = new Obstacle(900, Window.HEIGHT - 60);
        this.dy = 4;
        speed = 5;
        isJumping = false;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void tick() {
//        if (dy < 5) {
//            dy += 2;
//        }
//        this.y += dy;
//        obstacle[0].tick();
//        checkWindowBorder();
    }

    public void jump() {
        if (dy > 0) {
            dy = 0;
        }
        dy -= 10;
        setJumping();
        if (isJumping) {
            System.out.println("Jumping");
        }
        System.out.println("Not jumping");
    }

    public void setJumping() {
        isJumping = !isJumping;
    }

    public boolean getJumping() {
        return isJumping;
    }

    private void checkWindowBorder() {
        if (this.x > Window.WIDTH) {
            this.x = Window.WIDTH;
        }
        if (this.x < 0) {
            this.x = 0;
        }
        if (this.y > Window.HEIGHT - 50) {
            this.y = Window.HEIGHT - 50;
        }
        if (this.y < 0) {
            this.y = 0;
        }
    }

    @Override
    public void render(Graphics g, ImageObserver observer) {
        g.drawImage(image, x, y, observer);
        obstacle[0].render(g, observer);
    }

    public Rectangle getBounds() {

        return new Rectangle(x, y, width, height);
    }
}