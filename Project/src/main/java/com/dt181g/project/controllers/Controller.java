package com.dt181g.project.controllers;

import com.dt181g.project.models.Model;
import com.dt181g.project.models.Obstacle;
import com.dt181g.project.observer_pattern.Observer;
import com.dt181g.project.views.ButtonPanel;
import com.dt181g.project.views.GamePanel;
import com.dt181g.project.views.View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * The Controller class represents the controller in the Flappy Bird game and manages interactions between the
 * game logic and the user interface with the use of the GameController, ActionListener, KeyListener and Observer interfaces
 * @author Andreas Backman
 */
public class Controller implements ActionListener, KeyListener, Observer {
    private Model model;
    private View view;
    private GamePanel gamePanel;
    private ButtonPanel buttonPanel;
    private Timer timer;
    private BufferedImage birdImage;
    private BufferedImage birdImageJump;
    private BufferedImage obstacleImage;
    private boolean lastObstacleIsTop = false;

    /**
     * Constructor to create a Controller taking the Model and GamePanel as parameters
     */
    public Controller() {
        this.model = new Model();
        this.view = new View();
        this.gamePanel = new GamePanel();
        view.addKeyListener(this);
        model.addObserver(this);
        gamePanel.setBackgroundImage(model.getBackgroundImage());
        gamePanel.setGroundImage(model.getGroundImage());
        gamePanel.setObstacleImage(model.getObstacleImage());

//        // Loading images for the bird to be used
//        try {
//            birdImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/IMG/flappy1.png")));
//            birdImageJump = ImageIO.read(Objects.requireNonNull(getClass().getResource("/IMG/flappy2.png")));
//            obstacleImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/IMG/pipe.png")));
//
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }


        // Create the infoActionListener used to show game information
        ActionListener infoActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(view, "Press space to start\nPress space to make the bird jump\nAvoid the obstacles to earn points\nAvoid the obstacles as they result in Game Over" +
                        "\nAvoid the ground and the top of the screen as they result in Game Over\nClick Quit to exit", "Game Information", JOptionPane.INFORMATION_MESSAGE);
            }
        };

        // Create the quitActionListener used to quit the game
        ActionListener quitActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Quitting the program...");
                System.exit(0);
            }
        };

        // Passes the infoActionListener and quitActionListener to the ButtonPanel
        buttonPanel = new ButtonPanel(infoActionListener, quitActionListener);

        // Setting up the layout of the components
        view.setLayout(new BorderLayout());
        view.add(gamePanel, BorderLayout.CENTER);
        view.add(buttonPanel, BorderLayout.SOUTH);

        // Also gives the game information at the start of the game
        JOptionPane.showMessageDialog(view, "Press space to start\nPress space to make the bird jump\nAvoid the obstacles to earn points\nAvoid the obstacles as they result in Game Over" +
                "\nAvoid the ground and the top of the screen as they result in Game Over\nClick Quit to exit", "Game Information", JOptionPane.INFORMATION_MESSAGE);

        // Setting up the game timer
        timer = new Timer(20, this);
        timer.start();

        // Create and start a thread for background processing
        Thread backgroundThread = new Thread(this::backgroundProcessing);
        backgroundThread.start();
    }

    /**
     * Method to perform background processing
     */
    private void backgroundProcessing() {
        while (true) {
            updateBackground();
//            model.addObstacle(true);
//            updateTopObstaclePosition();


            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateBackground() {
        model.updateBackgroundPosition();
        view.render();
    }

    private void gameOver() {
//        view.showGameOver(); ------------------------------------------------------------------
        model.setGameOver(true);
    }

    /**
     * Handles the actionPerformed event for the timer
     * @param e the ActionEvent triggered by the timer
     */
    @Override
    public void actionPerformed(ActionEvent e) {


        // Updates logic and render when game is over
        if (model.getGameOverStatus()) {
            model.getBird().setY(gamePanel.getHeight() + 1);
            model.resetScore();
            gamePanel.repaint();
            return;
        }

        // Sets the speed and ticks
        int speed = 10;
        model.setTicks(1);
        gamePanel.updateBackgroundXPosition(model.getBackground().getX());
        gamePanel.updateGroundXPosition(model.getBackground().getX());

        // Creates a rectangle of the bird to be used to check for intersects with obstacles later on
        Rectangle b = new Rectangle(model.getBird().getX(), model.getBird().getY(), model.getBird().getWidth(), model.getBird().getHeight());

        // If game is started
        if (model.getStartedStatus()) {
            // Updates the background and adds obstacles
//            gamePanel.updateBackgroundPosition();
//            model.addObstacle(true);

            if (model.getObstacle().isEmpty()) {
                model.addObstacle(true);
            }



            // If number of ticks is even and the vertical motion is less than 15
            if (model.getTicks() % 2 == 0 && model.getYMotion() < 15) {
                model.setYMotion(2); // Then set the vertical motion to 2 to control the acceleration
            }

            // Changing image of bird when jumping
            if (model.getBirdState()) {
                gamePanel.setBirdImage(model.getBirdImage());

            } else {
                gamePanel.setBirdImage(model.getBirdJumpingImage());
            }

            // Iterates through the list of obstacles retreives current obstacle and moves the obstacle to the left at the
            // specified speed
            for (int i = 0; i < model.getObstacle().size(); i++) {
                Obstacle obstacles = model.getObstacle().get(i);
                obstacles.setX(-speed);



                // Check if obstacle has moved past the screen to be removed
                if (obstacles.getX() + obstacles.getWidth() < 0) {
                    model.getObstacle().remove(obstacles);
//                    model.addObstacle(true);
                    System.out.println("width: " + view.getWidth());



                }
            }



            // Adds obstacles
            // Then checks if birds coordinates passes between the obstacles to increment the score
//            ArrayList<Point> obstacleInfo = new ArrayList<>();
            ArrayList<Obstacle> obstaclesCopy = new ArrayList<>(model.getObstacle());
            for (Obstacle o : obstaclesCopy) {


//                updateObstaclePosition();
                if (o.getY() == 0 && model.getBird().getX() + model.getBird().getWidth() / 2 > o.getX() + o.getWidth() / 2 - 10 && model.getBird().getX() + model.getBird().getWidth() / 2 < o.getX() + o.getWidth() / 2 + 10) {
                    model.updateScore(); // Updates the score in the Model
                }

                // Creates a rectangle based on the obstacles and checks for collisions between bird and obstacles
                Rectangle obs = new Rectangle(o.getX(), o.getY(), o.getWidth(), o.getHeight());
                if (obs.intersects(b)) {
                    // If there is a collision the game is set to game over
                    gameOver();
                }


            }


            // Updates the birds vertical position based on current position
            model.getBird().setY(model.getBird().getY() + model.getYMotion());


            // If the bird touches the top part of the screen, game is set to game over
            if (model.getBird().getY() > gamePanel.getHeight() - 120 || model.getBird().getY() < 0) {
                gameOver();
            }

            // If the bird touches the ground, game is set to game over
            if (model.getBird().getY() + model.getBird().getHeight() >= gamePanel.getHeight() - 120) {
                model.getBird().setY(gamePanel.getHeight() - 120 - model.getBird().getHeight());
                gameOver();
            }

            // Updates the GamePanel with the current bird and obstacle positions
            gamePanel.updateBirdPosition(model.getBird().getX(), model.getBird().getY(), model.getBird().getWidth(), model.getBird().getHeight());
            updateObstaclePosition();
            updateTopObstaclePosition();


        }
        // Calls repaint
        gamePanel.repaint();
    }

    public void updateObstaclePosition() {
        int[] obstacleInfo = model.getObstacleValue();
        gamePanel.updateObstaclePosition(obstacleInfo[0], obstacleInfo[1], obstacleInfo[2], obstacleInfo[3]);
    }

    public void updateTopObstaclePosition() {
        int[] obstacleInfo = model.getTopObstacleValue();
        gamePanel.updateTopObstaclePosition(obstacleInfo[0], obstacleInfo[1], obstacleInfo[2], obstacleInfo[3]);
    }

    /**
     * Method to override the observer
     */
    @Override
    public void updateObserver() {
        SwingUtilities.invokeLater(() -> { // Updates swing components
            System.out.println("Observer updated");
            gamePanel.updateScore(model.getScore());
            gamePanel.repaint();
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Check if game is over
        if (model.getGameOverStatus()) {
            // Then reset game states
            model.setGameOver(false);
            model.setStarted(true);
            model.newGame();
        }
        // If space key is pressed the bird jump
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            model.jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
