package com.dt181g.project;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * The GamePanel represents the main panel used to render the game
 * @author Andreas Backman
 */
public class GamePanel extends JPanel {

    private int birdX;
    private int birdY;
    private int birdWidth;
    private int birdHeight;
    private int score;
    private ArrayList<Obstacle> obstacles = new ArrayList<>();
    private BufferedImage currentBirdImage;
    private BufferedImage obstacleImage;
    private boolean birdState = true;
    private BufferedImage backgroundImage;
    private BufferedImage groundImage;
    private int backgroundX;
    private JButton quitButton;
    private JButton startButton;
    private static final int BACKGROUND_SCROLL_SPEED = 5; // Adjust the speed as needed
    private static final int BACKGROUND_OVERLAP = 120;

    /**
     * Constructor to create images, buttons and set the backgroundX
     */
    public GamePanel() {
        backgroundImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\bg.png");
        groundImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\ground.png");
        obstacleImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\pipe.png");
        startButton = new JButton();
        quitButton = new JButton();
        backgroundX = 0;
    }

    /**
     * Method to update the background position
     */
    public void updateBackgroundPosition() {
        backgroundX -= BACKGROUND_SCROLL_SPEED;
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

    /**
     * Method to update the obstacle position to be drawn
     * @param obstacles the obstacle to be drawn
     */
    public void updateObstaclePosition(ArrayList<Obstacle> obstacles) {
        this.obstacles = obstacles;
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
        xPos = backgroundX;
        while (xPos < getWidth()) { // While less than width of screen
            g.drawImage(groundImage, xPos, getHeight() - 120, getWidth(), 120, null);
            xPos += groundImage.getWidth();
        }

        // Checks if bird is jumping or not
        if (birdState) {
            // Bird is moving downwards or not moving
            g.drawImage(currentBirdImage, birdX, birdY, birdWidth, birdHeight, null);
        } else {
            // Bird is moving upwards
            g.drawImage(currentBirdImage, birdX, birdY, birdWidth, birdHeight, null);
        }

        ArrayList<Obstacle> obstaclesCopy = new ArrayList<>(obstacles); // Creates copy of obstacles to avoid errors
        // Draws the obstacles
        for (Obstacle obstacle : obstaclesCopy) {
            g.drawImage(obstacleImage, obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight(), null);
        }

        // Draws the score
        g.setColor(Color.white);
        g.setFont(new Font("Arial", 1, 25));
        g.drawString("Score: " + score, getWidth() / 2 - 50, 50);

        repaint();
    }
}
