package com.dt181g.project.models;

import com.dt181g.project.observer_pattern.Observable;
import com.dt181g.project.observer_pattern.Observer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The Model class represents the logic of the Flappy Bird game
 * It implements the Observable interface in order to manage observers and notify them when changes are made
 * It also make use of the GameObjectInterface to create the bird and obstacles.
 * @author Andreas Backman
 */
public class Model implements Observable {

    private ArrayList<Observer> observers = new ArrayList<>();
    private Bird bird;
    private GameObjectInterface gameObjectInterface;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private boolean isGameOver;
    private boolean isStarted;
    private int yMotion;
    private int ticks;
    private AtomicInteger score;
    private Random rand;
    private ArrayList<Obstacle> obstacles;
    private Background background;
    private BufferedImage obstacleImage;
    private boolean birdState = true;
    private BufferedImage backgroundImage;
    private BufferedImage groundImage;
    private BufferedImage birdImage;
    private BufferedImage birdImageJump;

    /**
     * Constructor that starts a new game and creates game objects
     * It also loads the images used in the game
     */
    public Model() {
        gameObjectInterface = new ConcreteGameObject();
        rand = new Random();
        isGameOver = false;
        isStarted = false;
        obstacles = new ArrayList<>();
        background = new Background(0, 5);
        score = new AtomicInteger(0);

        // Load images
        try {
            backgroundImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/IMG/bg.png")));
            groundImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/IMG/ground.png")));
            obstacleImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/IMG/pipe.png")));
            birdImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/IMG/flappy1.png")));
            birdImageJump = ImageIO.read(Objects.requireNonNull(getClass().getResource("/IMG/flappy2.png")));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        newGame();
    }

    /**
     * Method that adds an observer to the list
     * @param observer the observer to be added
     */
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Method that removes an observer from the list
     * @param observer the observer to be removed
     */
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Method that notifies all observers when changes in the model are made
     */
    @Override
    public void updateObserver() {
        for (Observer observer : observers) {
            observer.updateObserver();
        }
    }

    /**
     * Retrieves the bird object
     * @return the bird object
     */
    public Bird getBird() {
        return bird;
    }

    /**
     * Method to make the bird jump in the game
     */
    public void jump() {
        if (isGameOver)
        {
            newGame();
        }
        if (!isStarted)
        {
            isStarted = true;
        }
        else if (!isGameOver)
        {
            if (yMotion > 0)
            {
                yMotion = 0;
            }
            yMotion -= 10;
        }
    }

    /**
     * Method to update the score by first incrementing the score and then notify the observer
     */
    public void updateScore() {
        score.incrementAndGet();
        updateObserver();
    }

    /**
     * Method to reset the score
     */
    public void resetScore() {
        score.set(0);
    }

    /**
     * Method to retrieve the score
     * @return the score
     */
    public int getScore() {
        return score.get();
    }

    /**
     * Method to set the ticks used to move the game elements
     * @param value the amount of ticks
     */
    public void setTicks(int value) {
        this.ticks += value;
    }

    /**
     * Method to retrieve the ticks
     * @return the ticks
     */
    public int getTicks() {
        return ticks;
    }

    /**
     * Method to set the yMotion
     * @param value the yValue
     */
    public void setYMotion(int value) {
        this.yMotion += value;
    }

    /**
     * Method to retrieve the yMotion
     * @return the yMotion
     */
    public int getYMotion() {
        return yMotion;
    }

    /**
     * Method to set the started state
     * @param state the state
     */
    public void setStarted(boolean state) {
        isStarted = state;
    }

    /**
     * Method to retrieve the started state
     * @return the state
     */
    public boolean getStartedStatus() {
        return isStarted;
    }

    /**
     * Method to set the game over state
     * @param state the state
     */
    public void setGameOver(boolean state) {
        isGameOver = state;
    }

    /**
     * Method to get the game over state
     * @return the state
     */
    public boolean getGameOverStatus() {
        return isGameOver;
    }

    /**
     * Method to initialize a new game with reset game states
     */
    public void newGame() {
        bird = gameObjectInterface.createBird(WIDTH / 2 - 10, HEIGHT / 2 - 10, 40, 40);
        yMotion = 0;
        resetScore();
        obstacles.clear();
        updateObserver();
    }

    /**
     * Gets the list of obstacles in the game
     * @return the list of obstacles
     */
    public synchronized ArrayList<Obstacle> getObstacle() {
        return obstacles;
    }

    /**
     * Method to get the bottom obstacle coordinates
     * @return the coordinates
     */
    public synchronized int[] getObstacleValue() {
        if (!obstacles.isEmpty()) {
            Obstacle obstacle = obstacles.get(0);

            int x = obstacle.getX();
            int y = obstacle.getY();
            int width = obstacle.getWidth();
            int height = obstacle.getHeight();

            return new int[]{x, y, width, height};
        }
        else {
            return new int[]{0, 0, 0, 0};
        }
    }

    /**
     * Method to get the top obstacle coordinates
     * @return the coordinates
     */
    public synchronized int[] getTopObstacleValue() {
        if (!obstacles.isEmpty() && obstacles.size() > 1) {
            Obstacle obstacle = obstacles.get(1);

            int x = obstacle.getX();
            int y = obstacle.getY();
            int width = obstacle.getWidth();
            int height = obstacle.getHeight();

            return new int[]{x, y, width, height};
        }
        else {
            return new int[]{0, 0, 0, 0};
        }
    }

    /**
     * Method to add an obstacle to the game with a randomized height
     * @param state if true, adds obstacles to the top and bottom
     *              otherwise adds obstacles to the sides
     */
    public synchronized void addObstacle(boolean state) {
        int space = 400;
        int width = 100;
        int height = 50 + rand.nextInt(300);

        if (state) {
            obstacles.add(gameObjectInterface.createObstacle(WIDTH + width + obstacles.size() * 300, HEIGHT - height - 195, width, height));
            obstacles.add(gameObjectInterface.createObstacle(WIDTH + width + (obstacles.size() - 1) * 300, 0, width, HEIGHT - height - space));

        }
        else {
            obstacles.add(gameObjectInterface.createObstacle(obstacles.get(obstacles.size() - 1).getX() + 600, height - 195, width, height));
            obstacles.add(gameObjectInterface.createObstacle(obstacles.get(obstacles.size() - 1).getX(), 0, width, HEIGHT - height - space));
        }
    }

    /**
     * Method to update the position of the background
     */
    public void updateBackgroundPosition() {
        background.updatePosition();
        updateObserver();
    }

    /**
     * Method to retrieve the background position
     * @return the position
     */
    public Background getBackground() {
        return background;
    }

    /**
     * Method to set the bird state
     * @param state the jumping state
     */
    public void setBirdState(boolean state) {
        birdState = state;
    }

    /**
     * Method to retrieve the bird state
     * @return the jumping state
     */
    public boolean getBirdState() {
        return birdState;
    }

    /**
     * Method to retrieve the bird image
     * @return the bird image
     */
    public BufferedImage getBirdImage() {
        return birdImage;
    }

    /**
     * Method to retrieve the bird jumping image
     * @return the bird jumping image
     */
    public BufferedImage getBirdJumpingImage() {
        return birdImageJump;
    }

    /**
     * Method to retrieve the background image
     * @return the background image
     */
    public BufferedImage getBackgroundImage() {
        return backgroundImage;
    }

    /**
     * Method to retrieve the obstacle image
     * @return the obstacle image
     */
    public BufferedImage getObstacleImage() {
        return obstacleImage;
    }

    /**
     * Method to retrieve the ground image
     * @return the ground image
     */
    public BufferedImage getGroundImage() {
        return groundImage;
    }
}
