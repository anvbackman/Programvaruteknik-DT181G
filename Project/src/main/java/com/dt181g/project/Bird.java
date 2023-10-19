package com.dt181g.project;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Bird {

    public Rectangle bird;
    public int x;
    public int y;
    public int width;
    public int height;
    private BufferedImage birdImage;
    private BufferedImage birdImageJump;
    private BufferedImage currentImage;

    private boolean isJumping;

    private int originalSpeed;
    private int newSpeed;


    public Bird(int x, int y, int width, int height, BufferedImage birdImage, BufferedImage birdImageJump) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.birdImage = birdImage;
        this.birdImageJump = birdImageJump;
        isJumping = false;
        currentImage = birdImage;
        originalSpeed = 10;
        newSpeed = originalSpeed;
//        bird = new Rectangle(x, y, width, height);
    }

    public void setJumping(boolean jumping) {
        isJumping = jumping;
    }

    public boolean isJumping() {
        return isJumping;
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

    public void increaseSpeed(int amount) {
        newSpeed += amount;
    }
    public void resetSpeed() {
        newSpeed = originalSpeed;
    }

//    public void setSpeed(int amount) {
//        originalSpeed = amount;
//    }

    public int getSpeed() {
        return newSpeed;
    }



}
