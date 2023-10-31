package com.dt181g.project;

import javax.swing.*;
import java.awt.image.BufferedImage;

/**
 * The main starting point for Project Assignment.
 * @author Erik Ström
 */
public final class Project {

    //    public static FlappyBird flappyBird;
    private Project() { // Utility classes should not have a public or default constructor
        throw new IllegalStateException("Utility class");
    }

    /**
     * Simple output of the assignment's name. Be sure to replace
     * this when working with the assignment!
     * @param args command arguments.
     */
    public static void main(final String... args) {

        BufferedImage obstacleImageTop = com.dt181g.project.IMG.ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\pipe1.png");
        BufferedImage obstacleImageBottom = com.dt181g.project.IMG.ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\pipe2.png");
        BufferedImage backgroundImage = com.dt181g.project.IMG.ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\bg.png");

        // Set up the game model
        GameModel gameModel = new GameModel(800, 800, obstacleImageTop, obstacleImageBottom);
        gameModel.initializeGame();

        // Set up the game view
        GameView gameView = new GameView(gameModel.getObstacles(), gameModel.getBird(), backgroundImage);

        // Set up the game controller
        GameController gameController = new GameController(gameModel, gameView);

        // Create the game window
        JFrame frame = new JFrame("Flappy Bird");
        frame.add(gameView);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.addKeyListener(gameController);




//        SwingUtilities.invokeLater(() -> {
//            FlappyBird.flappyBird = new FlappyBird();
//        });
    }
}
