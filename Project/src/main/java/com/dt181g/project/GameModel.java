package com.dt181g.project;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameModel {

    private BirdModel bird;
    private List<ObstacleModel> obstacles;
    private int WIDTH;
    private int HEIGHT;
    private int backgroundX;
    private int groundX;
    private Random rand;
    private boolean gameOver;
    private boolean started;
    private int ticks;
    private int yMotion;
    private BufferedImage obstacleImageTop;
    private BufferedImage obstacleImageBottom;
    private BufferedImage birdImage;
    private static final int GRAVITY = 1;

//    private boolean isJumping;


    public GameModel(int width, int height, BufferedImage obstacleImageTop, BufferedImage obstacleImageBottom) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.obstacles = new ArrayList<>();
        this.rand = new Random();
        this.backgroundX = 0;
        this.groundX = 0;
        this.gameOver = false;
        this.started = false;
//        isJumping = false;
        this.ticks = 0;
        this.yMotion = 0;
        this.obstacleImageTop = obstacleImageTop;
        this.obstacleImageBottom = obstacleImageBottom;
        this.birdImage = birdImage;
        this.bird = new BirdModel(WIDTH / 2 - 10, HEIGHT / 2 - 10, 40, 40);
    }

    public BirdModel getBird() {
        return bird;
    }

    public void initializeGame() {
        getBird();
        obstacles.clear();
        addObstacle(true);
    }

    public void updateGame() {
        bird.update(yMotion, bird.getJumping());
        if (yMotion > 0) {
            applyGravity();
        }
        checkCollision();
        // update score
        // generate obstacles
        // if game over, game over

    }

    private void applyGravity() {
        if (!bird.getJumping()) {
            yMotion += GRAVITY;
        }
    }

    public void checkCollision() {
        Rectangle b = new Rectangle(bird.getBounds());
        for (ObstacleModel obstacle : obstacles) {
            Rectangle o = new Rectangle(obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight());
            if (o.intersects(b)) {
                gameOver = true;
            }
            else {
                gameOver = false;
            }
        }
    }

    public void addObstacle(boolean add) {
        int spacing = 300;
        int width = 100;
        int height = 50 + rand.nextInt(300);
        if (add) {
            for (int i = 0; i < 4; i++) {
                obstacles.add(new ObstacleModel(obstacleImageTop, WIDTH + width + i * 300, HEIGHT - height - 120, width, height, true));
                obstacles.add(new ObstacleModel(obstacleImageBottom, WIDTH + width + i * 300, 0, width, HEIGHT - height - spacing, false));
            }
        }
    }


    public void newGame() {
        bird = new BirdModel(WIDTH / 2 - 10, HEIGHT / 2 - 10, 40, 40);
        obstacles.clear();
//        coins.clear();
        yMotion = 0;
//        score = 0;
//        coinsGained = 0;


        for (int i = 0; i < 4; i++) {
            addObstacle(true);
        }
    }

    public void jump() {
        if (!started) {
            started = true;
        } else if (!gameOver) {
            if (yMotion > 0) {
                yMotion = 0;
                System.out.println("Bird is Not Jumping");
                bird.setJumping(false);

            }
            yMotion -= 10;
            System.out.println("Bird is Jumping");
            bird.setJumping(true);
        }
    }

    public List<ObstacleModel> getObstacles() {
        return obstacles;
    }

//    public void setyMotion(int value) {
//        this.yMotion = value;
//    }
//
//    public int getyMotion() {
//        return yMotion;
//    }



//    public int getWidth() {
//        return width;
//    }
//
//    public int getHeight() {
//        return height;
//    }

//    public BufferedImage getImage() {
//        return image;
//    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isStarted() {
        return started;
    }

    public void setGameOver(boolean state) {
        gameOver = state;
    }

    public void setStarted(boolean state) {
        started = state;
    }






}
