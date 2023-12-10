package com.dt181g.project;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Model {

    private Bird bird;
    private GameObjectInterface gameObjectInterface;

    private int WIDTH = 800;
    private int HEIGHT = 800;
    private boolean isGameOver;
    private boolean isStarted;
    private int yMotion;
    private int ticks;
    private AtomicInteger score;
    private Random rand;

    private boolean isGameInitialized;
    private ArrayList<Obstacle> obstacles;


    public Model() {
//        bird = new Bird(WIDTH / 2 - 10, HEIGHT / 2 - 10, 40, 40);
        gameObjectInterface = new ConcreteGameObject();
        rand = new Random();
        isGameOver = false;
        isStarted = false;
        isGameInitialized = false;
        obstacles = new ArrayList<>();
        System.out.println("isStarted: " + isStarted);
        System.out.println("isGameOver: " + isGameOver);
        System.out.println("isGameInitialized: " + isGameInitialized);
        score = new AtomicInteger(0);
        newGame();
    }

    public Bird getBird() {
        return bird;
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

//    public void playJumpSound() {
//        try {
//            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\SOUND\\jump.wav"));
//            Clip clip = AudioSystem.getClip();
//            clip.open(audioInputStream);
//            clip.start();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

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
//            playJumpSound();
            yMotion -= 10;
        }
    }



    public void updateScore() {
        score.incrementAndGet();
    }

    public void resetScore() {
        score.set(0);
    }


    public int getScore() {
        return score.get();
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
        bird = gameObjectInterface.createBird(WIDTH / 2 - 10, HEIGHT / 2 - 10, 40, 40);
        yMotion = 0;
        resetScore();
        obstacles.clear();



        for (int i = 0; i < 4; i++) {
            addObstacle(true);
        }
    }

    public synchronized ArrayList<Obstacle> getObstacle() {
        return obstacles;
    }

    public synchronized void addObstacle(boolean state) {
        int space = 300;
        int width = 100;
        int height = 50 + rand.nextInt(300);

        if (state) {
            obstacles.add(gameObjectInterface.createObstacle(WIDTH + width + obstacles.size() * 300, HEIGHT - height - 195, width, height)); //
            obstacles.add(gameObjectInterface.createObstacle(WIDTH + width + (obstacles.size() - 1) * 300, 0, width, HEIGHT - height - space));
        }
        else {
            obstacles.add(gameObjectInterface.createObstacle(obstacles.get(obstacles.size() - 1).getX() + 600, height - 195, width, height)); //
            obstacles.add(gameObjectInterface.createObstacle(obstacles.get(obstacles.size() - 1).getX(), 0, width, HEIGHT - height - space));
        }

    }


}
