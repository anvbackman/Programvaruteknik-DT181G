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
    private BufferedImage birdImageJump;

    private boolean birdState = true;


    public View() {

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

        g.setColor(Color.cyan);
        g.fillRect(0, 0, getWidth(), getHeight());

//        g.setColor(Color.red);
//        g.fillRect(birdX, birdY, birdWidth, birdHeight);

//        g.drawImage(birdImage, birdX, birdY, birdWidth, birdHeight, null);
        if (birdState) {
            // Bird is moving downwards or not moving
            g.drawImage(currentBirdImage, birdX, birdY, birdWidth, birdHeight, null);
        } else {
            // Bird is moving upwards
            g.drawImage(currentBirdImage, birdX, birdY, birdWidth, birdHeight, null);
        }

        g.setColor(Color.ORANGE);
        g.fillRect(0, getHeight() - 120, getWidth(), 120);

        g.setColor(Color.green);
        g.fillRect(0, getHeight() - 120, getWidth(), 20);

        g.setColor(Color.green.darker());

        // Draw obstacles
        for (Rectangle obstacle : obstacles) {
            g.fillRect(obstacle.x, obstacle.y, obstacle.width, obstacle.height);
        }
    }

}
