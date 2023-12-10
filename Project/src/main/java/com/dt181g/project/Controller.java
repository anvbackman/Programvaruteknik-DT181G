package com.dt181g.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

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
    private boolean lastObstacleIsTop = false;

    /**
     * Constructor to create a Controller taking the Model and GamePanel as parameters
     * @param model the Model containing the game logic
     * @param gamePanel the GamePanel which renders the game
     */
    public Controller(Model model, GamePanel gamePanel) {
        this.model = model;
        view = new View();
        this.gamePanel = gamePanel;
        view.addKeyListener(this);
        model.addObserver(this);

        // Loading images for the bird to be used
        birdImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\flappy1.png");
        birdImageJump = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\flappy2.png");


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

        // Creates a rectangle of the bird to be used to check for intersects with obstacles later on
        Rectangle b = new Rectangle(model.getBird().getX(), model.getBird().getY(), model.getBird().getWidth(), model.getBird().getHeight());

        // If game is started
        if (model.getStartedStatus()) {
            // Updates the background and adds obstacles
            gamePanel.updateBackgroundPosition();
            model.addObstacle(true);

            // If number of ticks is even and the vertical motion is less than 15
            if (model.getTicks() % 2 == 0 && model.getYMotion() < 15) {
                model.setYMotion(2); // Then set the vertical motion to 2 to control the acceleration
            }

            // Changing image of bird when jumping
            if (model.getYMotion() >= 0) {
                gamePanel.setBirdImage(true, birdImage);

            } else {
                gamePanel.setBirdImage(false, birdImageJump);
            }

            // Iterates through the list of obstacles retreives current obstacle and moves the obstacle to the left at the
            // specified speed
            for (int i = 0; i < model.getObstacle().size(); i++) {
                Obstacle obstacles = model.getObstacle().get(i);
                obstacles.setX(-speed);

                // Check if obstacle has moved past the screen to be removed
                if (obstacles.getX() + obstacles.getWidth() < 0) {
                    model.getObstacle().remove(obstacles);
                }
            }

            // Checks if birds coordinates passes between the obstacles to increment the score
            for (Obstacle o : model.getObstacle()) {
                if (o.getY() == 0 && model.getBird().getX() + model.getBird().getWidth() / 2 > o.getX() + o.getWidth() / 2 - 10 && model.getBird().getX() + model.getBird().getWidth() / 2 < o.getX() + o.getWidth() / 2 + 10) {
                    model.updateScore(); // Updates the score in the Model
                }

                // Creates a rectangle based on the obstacles and checks for collisions between bird and obstacles
                Rectangle obs = new Rectangle(o.getX(), o.getY(), o.getWidth(), o.getHeight());
                if (obs.intersects(b)) {
                    // If there is a collision the game is set to game over
                    model.setGameOver(true);
                }
            }

            // Updates the birds virtical position based on current position
            model.getBird().setY(model.getBird().getY() + model.getYMotion());

            // If the bird is out of bounds (touches the top part of the screen) set game over
            if (model.getBird().getY() > gamePanel.getHeight() - 120 || model.getBird().getY() < 0) {
                model.setGameOver(true);
            }

            // If the bird touches the ground, game is set to game over
            if (model.getBird().getY() + model.getBird().getHeight() >= gamePanel.getHeight() - 120) {
                model.getBird().setY(gamePanel.getHeight() - 120 - model.getBird().getHeight());
                model.setGameOver(true);
            }

            // Updates the GamePanel with the current bird and obstacle positions
            gamePanel.updateBirdPosition(model.getBird().getX(), model.getBird().getY(), model.getBird().getWidth(), model.getBird().getHeight());
            gamePanel.updateObstaclePosition(model.getObstacle());
        }
        // Calls repaint
        gamePanel.repaint();
    }


    /**
     * Method to override the observer
     */
    @Override
    public void updateObserver() {
        System.out.println("Observer updated");
        gamePanel.updateScore(model.getScore()); // This calls the updateObserver method in the Model class
        gamePanel.repaint();
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
