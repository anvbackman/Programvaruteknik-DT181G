package com.dt181g.project;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BirdModel {

//    public Rectangle bird;
    private int x;
    private int y;
    private int width;
    private int height;
    private BufferedImage birdImage;
    private BufferedImage birdImageJump;
    private BufferedImage currentImage;

    private boolean isJumping;

    private int originalSpeed;
    private int newSpeed;

    private int yMotion;



    public BirdModel(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.birdImage = com.dt181g.project.IMG.ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\flappy1.png");
        this.birdImageJump = com.dt181g.project.IMG.ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\flappy2.png");
        isJumping = false;
        yMotion = 0;

    }

//    public void setJumping(boolean jumping) {
//        isJumping = jumping;
//    }
//
//    public boolean isJumping() {
//        return isJumping;
//    }


    public void update(int yMotion, boolean isJumping) {
        this.yMotion = yMotion;
        this.isJumping = isJumping;
        moveBird();
//        updateImage();


    }

    private void moveBird() {
        y += yMotion;
    }


    public void updateImage() {
        if (isJumping) {
            currentImage = birdImageJump;
        }
        else {
            currentImage = birdImage;
        }
    }




    public BufferedImage getCurrentImage() {
        return currentImage;
    }

    public Rectangle getBounds() {

        return new Rectangle(x, y, width, height);
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setJumping(boolean state) {
        isJumping = state;
    }
    public boolean getJumping() {
        return isJumping;
    }


}
