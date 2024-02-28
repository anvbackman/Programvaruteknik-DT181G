package com.dt181g.project.views;

import com.dt181g.project.models.Obstacle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * The GamePanel represents the main panel used to render the game
 * @author Andreas Backman
 */
public class GamePanel extends JPanel {

    private int birdX;
    private int birdY;
    private int birdWidth;
    private int birdHeight;
    private int obstacleX;
    private int obstacleY;
    private int obstacleWidth;
    private int obstacleHeight;
    private int topObstacleX;
    private int topObstacleY;
    private int topObstacleWidth;
    private int topObstacleHeight;
    private int score;
    private BufferedImage currentBirdImage;
    private BufferedImage obstacleImage;
    private boolean birdState = true;
    private BufferedImage backgroundImage;
    private BufferedImage groundImage;
    private int backgroundX;
    private int groundX;
    private static final int BACKGROUND_SCROLL_SPEED = 5; // Adjust the speed as needed
    private static final int BACKGROUND_OVERLAP = 120;

    /**
     * Constructor to create images, buttons and set the backgroundX
     */
    public GamePanel() {
        try {
            backgroundImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/IMG/bg.png")));
            groundImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/IMG/ground.png")));
            obstacleImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/IMG/pipe.png")));

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        JButton startButton = new JButton();
        JButton quitButton = new JButton();
//        backgroundX = 0;
    }

    /**
     * Method to update the background position
     */
//    public void updateBackgroundPosition() {
//        backgroundX -= BACKGROUND_SCROLL_SPEED;
//        repaint();
//    }

    public void updateBackgroundXPosition(int x) {
        this.backgroundX = x;
        repaint();

    }
    public void updateGroundXPosition(int x) {
        this.groundX = x;
        repaint();

    }

    /**
     * Method to set which bird image to be used depending on if the bird is jumping or not
     * @param state is the bird jumping or not
     * @param currentBirdImage the image to be used
     */
    public void setBirdImage(boolean state, BufferedImage currentBirdImage) {
        birdState = state;
        this.currentBirdImage = currentBirdImage;
        repaint();
    }

    /**
     * Updates the score to be shown
     * @param value the score
     */
    public void updateScore(int value) {
        this.score = value;
        repaint();
    }

    /**
     * Update the position of the bird to be drawn
     * @param x the x-coordinates
     * @param y the y-coordinates
     * @param width the width
     * @param height the height
     */
    public void updateBirdPosition(int x, int y, int width, int height) {
        this.birdX = x;
        this.birdY = y;
        this.birdWidth = width;
        this.birdHeight = height;
        repaint();
    }


    public void updateObstaclePosition(int x, int y, int width, int height) {

        this.obstacleX = x;
        this.obstacleY = y;
        this.obstacleWidth = width;
        this.obstacleHeight = height;
        repaint();
    }

    public void updateTopObstaclePosition(int x, int y, int width, int height) {

        this.topObstacleX = x;
        this.topObstacleY = y;
        this.topObstacleWidth = width;
        this.topObstacleHeight = height;
        repaint();
    }

    /**
     * Overrides the paintComponent method to draw game elements
     * @param g the Graphics object used to draw
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDraw(g);
    }

    /**
     * Method to draw the game elements
     * @param g the Graphics object used to draw
     */
    private void doDraw(Graphics g) {

        // Draws the background based on the backgroundX value
        int xPos = backgroundX;
        while (xPos < getWidth()) { // While less than width of screen
            g.drawImage(backgroundImage, xPos, 0, getWidth(), getHeight(), null);

            xPos += backgroundImage.getWidth() - BACKGROUND_OVERLAP; // subtracts a overlap to make the image not have a gap in it
        }

        // Draws the ground based on the backgroundX value
        int groundXPos = groundX;
        while (groundXPos < getWidth()) { // While less than width of screen
            g.drawImage(groundImage, groundXPos, getHeight() - 120, getWidth(), 120, null);
            groundXPos += groundImage.getWidth();
        }

        // Checks if bird is jumping or not
        if (birdState) {
            // Bird is moving downwards or not moving
            g.drawImage(currentBirdImage, birdX, birdY, birdWidth, birdHeight, null);
        } else {
            // Bird is moving upwards
            g.drawImage(currentBirdImage, birdX, birdY, birdWidth, birdHeight, null);
        }

        g.drawImage(obstacleImage, obstacleX, obstacleY, obstacleWidth, obstacleHeight, null);
        g.drawImage(obstacleImage, topObstacleX, topObstacleY, topObstacleWidth, topObstacleHeight, null);



        // Draws the score
        g.setColor(Color.white);
        g.setFont(new Font("Arial", 1, 25));
        g.drawString("Score: " + score, getWidth() / 2 - 50, 50);


    }
}
