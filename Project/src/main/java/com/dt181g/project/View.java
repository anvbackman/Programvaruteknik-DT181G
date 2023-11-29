package com.dt181g.project;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class View extends JPanel {

    private GamePanel gamePanel;

    private int birdX;
    private int birdY;
    private int birdWidth;
    private int birdHeight;

    private int obstacleX;
    private int obstacleY;
    private int obstacleWidth;
    private int obstacleHeight;
    private ArrayList<Rectangle> obstacles;

    private BufferedImage currentBirdImage;


    private boolean birdState = true;
    private BufferedImage backgroundImage;
    private BufferedImage groundImage;
    private BufferedImage obstacleImage;
//    private BufferedImage backgroundImage;
    private int backgroundX;

    private static final int BACKGROUND_SCROLL_SPEED = 5; // Adjust the speed as needed
    private static final int BACKGROUND_WIDTH = 800;
    private static final int BACKGROUND_OVERLAP = 120;

    public View() {
        backgroundImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\bg.png");
        groundImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\ground.png");
        obstacleImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\pipe1.png");
        backgroundX = 0;
    }

    public void updateBackgroundPosition() {
        backgroundX -= BACKGROUND_SCROLL_SPEED;
        repaint();
    }

    public void setBirdImage(boolean state, BufferedImage currentBirdImage) {
        birdState = state;
        this.currentBirdImage = currentBirdImage;
        repaint();
    }



    public void updateBirdPosition(int x, int y, int width, int height) {
        // Update the bird position
        this.birdX = x;
        this.birdY = y;
        this.birdWidth = width;
        this.birdHeight = height;
//        System.out.println("Bird Position: x=" + birdX + ", y=" + birdY + ", width=" + birdWidth + ", height=" + birdHeight);


        // Trigger a repaint
        repaint();
    }

    public void updateObstaclePosition(ArrayList<Rectangle> obstacles) {
        // Update the obstacle positions
        this.obstacles = obstacles;

        // Trigger a repaint
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);



        doDraw(g);
    }

    private void doDraw(Graphics g) {


//        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
        int xPos = backgroundX;
        while (xPos < getWidth()) {
            g.drawImage(backgroundImage, xPos, 0, getWidth(), getHeight(), null);

            xPos += backgroundImage.getWidth() - BACKGROUND_OVERLAP;
        }

        xPos = backgroundX;
        while (xPos < getWidth()) {
            g.drawImage(groundImage, xPos, getHeight() - 120, getWidth(), 120, null);
            xPos += groundImage.getWidth();
        }





        if (birdState) {
            // Bird is moving downwards or not moving
            g.drawImage(currentBirdImage, birdX, birdY, birdWidth, birdHeight, null);
        } else {
            // Bird is moving upwards
            g.drawImage(currentBirdImage, birdX, birdY, birdWidth, birdHeight, null);
        }



        g.setColor(Color.green.darker());

        // Draw obstacles
        for (Rectangle obstacle : obstacles) {
            g.drawImage(obstacleImage, obstacle.x, obstacle.y, obstacle.width, obstacle.height, null);
        }
        repaint();
    }

}
