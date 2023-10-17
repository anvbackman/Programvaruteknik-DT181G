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

    public Bird(int x, int y, int width, int height, BufferedImage birdImage, BufferedImage birdImageJump) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.birdImage = birdImage;
        this.birdImageJump = birdImageJump;
        isJumping = false;
        currentImage = birdImage;
//        bird = new Rectangle(x, y, width, height);
    }

    public void setJumping(boolean jumping) {
        isJumping = jumping;
    }

    public boolean isJumping() {
        return isJumping;
    }

    public Rectangle getBounds() {
        System.out.println(new Rectangle(x, y, width, height));
        return new Rectangle(x, y, width, height);
    }

    public void setImage(BufferedImage image) {
        currentImage = image;
    }

    public BufferedImage getCurrentImage() {
//        this.image = image;

        return currentImage;
//        if (isJumping) {
//            return birdImageJump;
//        }
//        else {
//            return birdImage;
//        }
    }

}
