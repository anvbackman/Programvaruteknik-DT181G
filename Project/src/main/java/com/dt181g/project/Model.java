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
    private Random rand;

    private ArrayList<Rectangle> obstacles;

    public Model() {
        rand = new Random();
        isGameOver = false;
        isStarted = true;
//        yMotion = 0;
//        ticks = 0;
        newGame();
    }

    public Bird getBird() {
        return bird;
    }

    public Obstacle getObstaclePosition() {
        return obstacle;
    }



    public void jump() {
        if (isGameOver)
        {
            bird.setY(HEIGHT / 2 - 10);

            yMotion = 0;

            isGameOver = false;
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
            yMotion -= 15;
        }
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
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
        yMotion = 0;
        obstacles = new ArrayList<>();
        bird = new Bird(WIDTH / 2 - 10, HEIGHT / 2 - 10, 40, 40);
        for (int i = 0; i < 4; i++) {
            addObstacle(true);
        }
    }

    public ArrayList<Rectangle> getObstacle() {
        return obstacles;
    }

    public void addObstacle(boolean state) {
        int space = 300;
        int width = 100;
        int height = 50 + rand.nextInt(300);

        if (isStarted) {
            obstacles.add(new Rectangle(WIDTH + width + obstacles.size() * 300, HEIGHT - height - 120, width, height));
            obstacles.add(new Rectangle(WIDTH + width + (obstacles.size() - 1) * 300, 0, width, HEIGHT - height - space));
        }
        else {
            obstacles.add(new Rectangle(obstacles.get(obstacles.size() - 1).x + 600, HEIGHT - height - 120, width, height));
            obstacles.add(new Rectangle(obstacles.get(obstacles.size() - 1).x, 0, width, HEIGHT - height - space));
        }

    }




}
