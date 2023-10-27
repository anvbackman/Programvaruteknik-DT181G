package com.dt181g.project;

import com.dt181g.project.IMG.ImageLoader;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {

    private int yMotion;
    private boolean gameOver;
    private boolean started;
    private boolean jumping;

    private int WIDTH = 800;
    private int HEIGHT = 800;
    private int backgroundX;
    private int groundX;
    private Bird bird;
    private List<Obstacle> obstacles;
    private List<Coin> coins;
    private List<PowerUp> powerUps;
    private List<Bullet> bullets;
    private Random rand;
    private int coinWidth = 50;
    private int coinHeight = 50;
    private int powerUpWidth = 50;
    private int powerUpHeight = 50;
    private BufferedImage birdImage;
    private BufferedImage birdImageJump;
    private BufferedImage obstacleImageTop;
    private BufferedImage obstacleImageBottom;
    private BufferedImage coinImage;
    private BufferedImage powerUpImage;
    private BufferedImage bulletImage;

    private BufferedImage backgroundImage;

    private BufferedImage groundImage;



    public Model() {
        bird = null;
        obstacles = new ArrayList<>();
        coins = new ArrayList<>();
        powerUps = new ArrayList<>();
        bullets = new ArrayList<>();
        rand = new Random();
        yMotion = 0;
        backgroundX = 0;
        groundX = 0;

//        groundImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\ground.png");
//        coinImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\coin.png");
//        powerUpImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\star.png");
//        bulletImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\bullet.png");
//
//        backgroundImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\bg.png");
//        birdImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\flappy1.png");
//        birdImageJump = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\flappy2.png");
//        obstacleImageTop = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\pipe1.png");
//        obstacleImageBottom = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\pipe2.png");
    }

    public void setGroundX(int amount) {
        this.groundX = amount;
    }
    public void setBackgroundX(int amount) {
        this.backgroundX = amount;
    }
    public int getGroundX() {
        return groundX;
    }

    public int getBackgroundX() {
        return backgroundX;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    public void setStarted(boolean started) {
        this.started = started;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setYMotion(int yMotion) {
        this.yMotion = yMotion;
    }
    public int getYMotion() {
        return yMotion;
    }

    public boolean isStarted() {
        return started;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public boolean isJumping() {
        return jumping;
    }

    public void setGroundImage(BufferedImage image) {
        this.groundImage = image;
    }
    public void setCoinImage(BufferedImage image) {
        this.coinImage = image;
    }
    public void setBackgroundImage(BufferedImage image) {
        this.backgroundImage = image;
    }
    public void setBirdImage(BufferedImage image) {
        this.birdImage = image;
    }
    public void setBirdImageJump(BufferedImage image) {
        this.birdImageJump = image;
    }
    public void setObstacleImageTop(BufferedImage image) {
        this.obstacleImageTop = image;
    }
    public void setObstacleImageBottom(BufferedImage image) {
        this.obstacleImageBottom = image;
    }



    public void newGame() {
        bird = new Bird(WIDTH / 2 - 10, HEIGHT / 2 - 10, 40, 40, birdImage, birdImageJump);
        obstacles.clear();
        coins.clear();
        yMotion = 0;
//        score = 0;
//        coinsGained = 0;

        for (int i = 0; i < 4; i++) {
            addObstacle(true);
        }

//        coinTimer = new Timer(4000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                addCoin(true);
//            }
//        });
//
//        powerUpTimer = new Timer(4000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                addPowerUp(true);
//            }
//        });
//
//        coinTimer.setRepeats(true);
//        coinTimer.start();
//        powerUpTimer.setRepeats(true);
//        powerUpTimer.start();
    }

    public Bird getBird() {
        return bird;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }

    public List<Obstacle> getObstacles() {
        return obstacles;
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public List<PowerUp> getPowerUps() {
        return powerUps;
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

    public Random getRand() {
        return rand;
    }

    public int getCoinWidth() {
        return coinWidth;
    }

    public int getCoinHeight() {
        return coinHeight;
    }

    public int getPowerUpWidth() {
        return powerUpWidth;
    }

    public int getPowerUpHeight() {
        return powerUpHeight;
    }

    public BufferedImage getBirdImage() {
        return birdImage;
    }

    public BufferedImage getBirdImageJump() {
        return birdImageJump;
    }

    public BufferedImage getObstacleImageTop() {
        return obstacleImageTop;
    }

    public BufferedImage getObstacleImageBottom() {
        return obstacleImageBottom;
    }

    public BufferedImage getCoinImage() {
        return coinImage;
    }

    public BufferedImage getPowerUpImage() {
        return powerUpImage;
    }

    public BufferedImage getBulletImage() {
        return bulletImage;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public BufferedImage getBackgroundImage() {
        return backgroundImage;
    }

    public BufferedImage getGroundImage() {
        return groundImage;
    }



    public void addObstacle(boolean start) {
        int spacing = 300;
        int width = 100;
        int height = 50 + rand.nextInt(300);

        if (start) {
            obstacles.add(new Obstacle(obstacleImageTop, WIDTH + width + obstacles.size() * 300, HEIGHT - height - 120, width, height, true));
            obstacles.add(new Obstacle(obstacleImageBottom, WIDTH + width + (obstacles.size() - 1) * 300, 0, width, HEIGHT - height - spacing, false));
        }
        else {
            obstacles.add(new Obstacle(obstacleImageTop, obstacles.get(obstacles.size() - 1).x + 600, HEIGHT - height - 120, width, height, true));
            obstacles.add(new Obstacle(obstacleImageBottom, obstacles.get(obstacles.size() - 1).x, 0, width, HEIGHT - height - spacing, false));
        }
    }



    public void addCoin(boolean start) {

        int coinYPosition = rand.nextInt(HEIGHT - 120 - coinHeight);

        if (start) {
            coins.add(new Coin(WIDTH + coinWidth + obstacles.size() * 300, coinYPosition, coinWidth, coinHeight));
        } else {
            coins.add(new Coin(coins.get(coins.size() - 1).x + 600, coinYPosition, coinWidth, coinHeight));
        }
    }
}
