package com.dt181g.project;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Model {

    private Bird bird;
    private Obstacle obstacle;
    private int WIDTH = 800;
    private int HEIGHT = 800;
    private boolean isGameOver;
    private boolean isStarted;
    private int yMotion;
    private int ticks;
    private int score;
    private Random rand;

    private boolean isGameInitialized;
    private ArrayList<Obstacle> obstacles;


    public Model() {

        rand = new Random();
        isGameOver = false;
        isStarted = false;
        isGameInitialized = false;
        obstacles = new ArrayList<>();
        System.out.println("isStarted: " + isStarted);
        System.out.println("isGameOver: " + isGameOver);
        System.out.println("isGameInitialized: " + isGameInitialized);

        newGame();
    }

    public Bird getBird() {
        return bird;
    }
    public Obstacle getObstacles() {
        return obstacle;
    }

    public Obstacle getObstaclePosition() {
        return obstacle;
    }

    public void gameOver() {
        bird.setY(HEIGHT / 2 - 10);

        yMotion = 0;
        obstacles.clear();
        score = 0;

        for (int i = 0; i < 4; i++) {
            addObstacle(true);
        }

        isGameOver = false;
    }

    public void startGame() {
        if (!isGameInitialized) {
            newGame();  // Initialize the game only if it's not already initialized
            isGameInitialized = true;
        }
    }

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
            System.out.println("Bird Jumped");
            yMotion -= 10;
        }
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public void setScore(int value) {
        if (isStarted && !isGameOver) {
            this.score += value;
        }
    }

    public int getScore() {
        return score;
    }

    public void setTicks(int value) {
        this.ticks += value;
    }
    public int getTicks() {
        return ticks;
    }

    public void setYMotion(int value) {
        this.yMotion += value;
    }
    public int getYMotion() {
        return yMotion;
    }

    public void setStarted(boolean state) {
        isStarted = state;
    }

    public boolean getStartedStatus() {
        return isStarted;
    }

    public void setGameOver(boolean state) {
        isGameOver = state;
    }

    public boolean getGameOverStatus() {
        return isGameOver;
    }

    public void newGame() {
        bird = new Bird(WIDTH / 2 - 10, HEIGHT / 2 - 10, 40, 40);
        yMotion = 0;
        setScore(0);
        obstacles.clear();



        for (int i = 0; i < 4; i++) {
            addObstacle(true);
        }
    }

    public ArrayList<Obstacle> getObstacle() {
        return obstacles;
    }

    public void addObstacle(boolean state) {
        int space = 300;
        int width = 100;
        int height = 50 + rand.nextInt(300);

        if (state) {
            obstacles.add(new Obstacle(WIDTH + width + obstacles.size() * 300, HEIGHT - height - 158, width, height)); //
            obstacles.add(new Obstacle(WIDTH + width + (obstacles.size() - 1) * 300, 0, width, HEIGHT - height - space));
        }
        else {
            obstacles.add(new Obstacle(obstacles.get(obstacles.size() - 1).getX() + 600, HEIGHT - height - 158, width, height)); //
            obstacles.add(new Obstacle(obstacles.get(obstacles.size() - 1).getX(), 0, width, HEIGHT - height - space));
        }

    }




}
