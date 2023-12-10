package com.dt181g.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    //    private GamePanel gamePanel;

    private int birdX;
    private int birdY;
    private int birdWidth;
    private int birdHeight;
    private int score;


    private ArrayList<Obstacle> obstacles = new ArrayList<>();

    private BufferedImage currentBirdImage;
    private BufferedImage obstacleImage;

    private boolean birdState = true;
    private boolean isGameOver;
    private boolean isStartScreen;
    private BufferedImage backgroundImage;
    private BufferedImage groundImage;
//    private BufferedImage obstacleImage;
//    private BufferedImage obstacleImageTop;
//    private BufferedImage obstacleImageBottom;

    private BufferedImage birdImage;
    private BufferedImage birdImageJump;
    //    private BufferedImage backgroundImage;
    private int backgroundX;
    private GameController gameController;

    //    private JButton startButton;
    private JButton quitButton;
    private JButton startButton;
    private static final int BACKGROUND_SCROLL_SPEED = 5; // Adjust the speed as needed
    private static final int BACKGROUND_WIDTH = 800;
    private static final int BACKGROUND_OVERLAP = 120;





    public GamePanel() {
        backgroundImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\bg.png");
        groundImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\ground.png");
        obstacleImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\pipe.png");
//        initializeButton();
        startButton = new JButton();
        quitButton = new JButton();
        isGameOver = false;
        isStartScreen = true;


        setVisible(true);
        backgroundX = 0;
    }

    public void setGameOver(boolean state) {
        isGameOver = state;
        repaint();
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
        repaint();
    }



    public void setGameController(GameController gameController) {
        this.gameController = gameController;

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

//        if (isGameOver) {
//            System.out.println("Is game over");
//            g.setColor(Color.red);
//            g.setFont(new Font("Arial", Font.BOLD, 40));
//
//            g.drawString("Game Over! Press Space to start!", getWidth() / 2, getHeight() / 2 - 50);
//        }


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

            g.drawImage(obstacleImage, obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight(), null);
//            g.setColor(Color.green.darker());
//            g.fillRect(obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight());



        }

        g.setColor(Color.white);
        g.setFont(new Font("Arial", 1, 25));
        g.drawString("Score: " + String.valueOf(score), getWidth() / 2 - 50, 50);

        repaint();
    }
}
