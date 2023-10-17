package com.dt181g.project;

import java.awt.image.BufferedImage;
import java.util.concurrent.Semaphore;

public class BirdImageRunnable implements Runnable {


    private BufferedImage image;
    private boolean isJumping;
    private String threadName;
    private Semaphore semaphore;

    public BirdImageRunnable(BufferedImage image, boolean isJumping, String threadName) {
        this.image = image;
        this.isJumping = isJumping;

        this.threadName = threadName;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (true) {
//
//                if (bird.isJumping()) {
//                    bird.setImage(image);
//                }
//                if (!bird.isJumping()) {
//                    bird.setImage(image);
//                }

            try {
                Thread.sleep(1000);
                }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
