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
    private int score;

    private int obstacleX;
    private int obstacleY;
    private int obstacleWidth;
    private int obstacleHeight;
    private ArrayList<Obstacle> obstacles;

    private BufferedImage currentBirdImage;
    private BufferedImage obstacleImage;

    private boolean birdState = true;
    private BufferedImage backgroundImage;
    private BufferedImage groundImage;
//    private BufferedImage obstacleImage;
//    private BufferedImage obstacleImageTop;
//    private BufferedImage obstacleImageBottom;

    private BufferedImage birdImage;
    private BufferedImage birdImageJump;
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


    public void updateScore(int value) {
        this.score = value;
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

    public void updateObstaclePosition(ArrayList<Obstacle> obstacles) {
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





        // Draw obstacles
        for (Obstacle obstacle : obstacles) {

//            g.drawImage(obstacleImage, obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight(), null);
            g.setColor(Color.green.darker());
            g.fillRect(obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight());



        }

        g.setColor(Color.white);
        g.setFont(new Font("Arial", 1, 25));
        g.drawString(String.valueOf(score), getWidth() / 2 - 100, 100);

        repaint();
    }

}
