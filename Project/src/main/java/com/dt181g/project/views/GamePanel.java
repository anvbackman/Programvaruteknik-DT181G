package com.dt181g.project.views;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

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
    private BufferedImage backgroundImage;
    private BufferedImage groundImage;
    private int backgroundX;
    private int groundX;
    private static final int BACKGROUND_OVERLAP = 120;
    private final JLabel scoreLabel;

    /**
     * Constructor to create a GamePanel object and create a layout for the score label
     */
    public GamePanel() {
        // Sets the score text, color and size
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("Default", Font.BOLD, 20));

        // Sets the layout for the score panel adding the score label and setting it to transparent
        JPanel scorePanel = new JPanel(new BorderLayout());
        scorePanel.add(scoreLabel, BorderLayout.CENTER);
        scorePanel.setOpaque(false);

        add(scorePanel, BorderLayout.NORTH);
        setVisible(true);
    }

    /**
     * Method to update the background position
     * @param x the x-coordinates
     */
    public void updateBackgroundXPosition(int x) {
        this.backgroundX = x;
    }

    /**
     * Method to update the ground position
     * @param x the x-coordinates
     */
    public void updateGroundXPosition(int x) {
        this.groundX = x;
    }

    /**
     * Method to set the bird image
     * @param currentBirdImage the bird image
     */
    public void setBirdImage(BufferedImage currentBirdImage) {
        this.currentBirdImage = currentBirdImage;
    }

    /**
     * Method to set the obstacle image
     * @param obstacleImage the obstacle image
     */
    public void setObstacleImage(BufferedImage obstacleImage) {
        this.obstacleImage = obstacleImage;
    }

    /**
     * Method to set the ground image
     * @param groundImage the ground image
     */
    public void setGroundImage(BufferedImage groundImage) {
        this.groundImage = groundImage;
    }

    /**
     * Method to set the background image
     * @param backgroundImage the background image
     */
    public void setBackgroundImage(BufferedImage backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    /**
     * Updates the score to be shown
     * @param value the score
     */
    public void updateScore(int value) {
        this.score = value;
        scoreLabel.setText("Score: " + score);
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
    }

    // Method to update the bottom obstacle position
    public void updateObstaclePosition(int x, int y, int width, int height) {
        this.obstacleX = x;
        this.obstacleY = y;
        this.obstacleWidth = width;
        this.obstacleHeight = height;
    }

    // Method to update the top obstacle position
    public void updateTopObstaclePosition(int x, int y, int width, int height) {
        this.topObstacleX = x;
        this.topObstacleY = y;
        this.topObstacleWidth = width;
        this.topObstacleHeight = height;
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

        // Draws the ground based on the groundX value
        int groundXPos = groundX;
        while (groundXPos < getWidth()) { // While less than width of screen
            g.drawImage(groundImage, groundXPos, getHeight() - 120, getWidth(), 120, null);
            groundXPos += groundImage.getWidth();
        }

        // Draws the bird
        g.drawImage(currentBirdImage, birdX, birdY, birdWidth, birdHeight, null);

        // Draws the obstacles
        g.drawImage(obstacleImage, obstacleX, obstacleY, obstacleWidth, obstacleHeight, null);
        g.drawImage(obstacleImage, topObstacleX, topObstacleY, topObstacleWidth, topObstacleHeight, null);
    }
}
