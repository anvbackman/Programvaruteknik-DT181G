package com.dt181g.project;

import com.dt181g.project.IMG.ImageLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import java.awt.event.KeyListener;

import java.awt.event.MouseListener;
import java.util.concurrent.Semaphore;

public class FlappyBird implements ActionListener, MouseListener, KeyListener {

    public static FlappyBird flappyBird;
    private Bird bird;
    private ArrayList<Obstacle> obstacle;
    public int WIDTH = 800;
    public int HEIGHT = 800;
    private int backgroundX;
    private int groundX;
    public Random rand;
    public Renderer renderer;
    private String birdSymbol = "A";

    public boolean gameOver;
    public boolean started;
    public int ticks;
    public int yMotion;
    public int score;
    public int coinsGained;

    private ArrayList<Coin> coins;
    private ArrayList<Coin> coinsToRemove;

    private ArrayList<PowerUp> powerUps;
    private ArrayList<PowerUp> powerUpsToRemove;
    private int coinWidth = 50;
    private int coinHeight = 50;
    private int powerUpWidth = 50;
    private int powerUpHeight = 50;

    private Timer coinTimer;
    private Timer powerUpTimer;
    private BufferedImage birdImage;
    private BufferedImage birdImageJump;
    private BufferedImage backgroundImage;
    private Thread birdImageThread;
    private Thread birdImageJumpThread;
    private BufferedImage obstacleImageTop;
    private BufferedImage obstacleImageBottom;
    private BufferedImage groundImage;
    private BufferedImage coinImage;
    private BufferedImage powerUpImage;

    private boolean isMoreCoins;


    private boolean isJumping;

    public FlappyBird() {

        Timer timer = new Timer(20, this);
        renderer = new Renderer();
        JFrame frame = new JFrame();
        frame.add(renderer);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Flappy Bird");
        frame.setVisible(true);
        frame.addMouseListener(this);
        frame.addKeyListener(this);


        obstacle = new ArrayList<>();
        coins = new ArrayList<>();
        powerUps = new ArrayList<>();
        rand = new Random();
        backgroundX = 0;
        groundX = 0;
        isMoreCoins = false;

        newGame();

        groundImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\ground.png");
        coinImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\coin.png");
        powerUpImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\star.png");

        backgroundImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\bg.png");
        birdImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\flappy1.png");
        birdImageJump = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\flappy2.png");
        obstacleImageTop = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\pipe1.png");
        obstacleImageBottom = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\pipe2.png");

        bird = new Bird(WIDTH / 2 - 10, HEIGHT / 2 - 10, 40, 40, birdImage, birdImageJump);

        birdImageThread = new Thread(new BirdImageRunnable(birdImage, true, "BirdImageThread"));
        birdImageJumpThread = new Thread(new BirdImageRunnable(birdImageJump, false, "BirdImageJumpThread"));

        birdImageThread.start();
        birdImageJumpThread.start();
        timer.start();
    }

    public void addObstacle(boolean start) {
//        int spacing = 300;
//        int width = 100;
//        int height = 50 + rand.nextInt(300);
//
//        if (start) {
//            obstacle.add(new Obstacle(obstacleImageTop, WIDTH + width + obstacle.size() * 300, HEIGHT - height - 120, width, height, true));
//            obstacle.add(new Obstacle(obstacleImageBottom, WIDTH + width + (obstacle.size() - 1) * 300, 0, width, HEIGHT - height - spacing, false));
//        }
//        else {
//            obstacle.add(new Obstacle(obstacleImageTop, obstacle.get(obstacle.size() - 1).x + 600, HEIGHT - height - 120, width, height, true));
//            obstacle.add(new Obstacle(obstacleImageBottom, obstacle.get(obstacle.size() - 1).x, 0, width, HEIGHT - height - spacing, false));
//        }
    }

    public void paintObstacle(Graphics g, Obstacle obstacle) {
        if (obstacle.getPosition()) {
            g.drawImage(obstacleImageBottom, obstacle.x, obstacle.y, obstacle.width, obstacle.height, null);
        }
        else {
            g.drawImage(obstacleImageTop, obstacle.x, obstacle.y, obstacle.width, obstacle.height, null);
        }
    }

    public void addCoin(boolean start) {

        int coinYPosition = rand.nextInt(HEIGHT - 120 - coinHeight);

        if (start) {
            coins.add(new Coin(WIDTH + coinWidth + obstacle.size() * 300, coinYPosition, coinWidth, coinHeight));
        } else {
            coins.add(new Coin(coins.get(coins.size() - 1).x + 600, coinYPosition, coinWidth, coinHeight));
        }
    }

    public void paintCoin(Graphics g, Coin coin) {
        g.drawImage(coinImage, coin.x, coin.y, coin.width, coin.height, null);
    }

    public void addPowerUp(boolean start) {
        int powerUpYPosition = rand.nextInt(HEIGHT - 120 - powerUpHeight);
        if (start) {
            powerUps.add(new PowerUp(WIDTH + coinWidth + obstacle.size() * 300, powerUpYPosition, powerUpWidth, powerUpHeight));
        } else {
            powerUps.add(new PowerUp(coins.get(coins.size() - 1).x + 600, powerUpYPosition, powerUpWidth, powerUpHeight));
        }
    }

    public void paintPowerUp(Graphics g, PowerUp powerUp) {
        g.drawImage(powerUpImage, powerUp.x, powerUp.y, powerUp.width, powerUp.height, null);
    }

    public void powerUp() {
        Thread powerUpThread = new Thread(() -> {
            moreCoins();
        });
        powerUpThread.start();
    }

    public void ghostBird() {
        int originalInterval = coinTimer.getDelay();

        isGhost = true;
        Timer temporaryTimer = new Timer(250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coinTimer.setDelay(25);
                addCoin(true);
            }
        });

        temporaryTimer.setRepeats(false);
        temporaryTimer.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isMoreCoins = false;
        coinTimer.setDelay(originalInterval);
        coinTimer.start();
    }

    public void moreCoins() {
        int originalInterval = coinTimer.getDelay();

        isMoreCoins = true;
        Timer temporaryTimer = new Timer(250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coinTimer.setDelay(25);
                addCoin(true);
            }
        });

        temporaryTimer.setRepeats(false);
        temporaryTimer.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isMoreCoins = false;
        coinTimer.setDelay(originalInterval);
        coinTimer.start();
    }


    public void repaint(Graphics g) {

        for (int x = backgroundX; x < WIDTH; x += backgroundImage.getWidth()) {
            g.drawImage(backgroundImage, x, 0, WIDTH + 120, HEIGHT, null);
        }
        for (int x = groundX; x < WIDTH; x += groundImage.getWidth()) {
            g.drawImage(groundImage, x, HEIGHT - 120, WIDTH, 150, null);
        }

        if (bird != null) {
            BufferedImage currentImage = bird.getCurrentImage();
            g.drawImage(currentImage, bird.x, bird.y, bird.width, bird.height, null);
        }

        for (Obstacle o : obstacle) {
            paintObstacle(g, o);
        }

        for (Coin coin : coins) {
            paintCoin(g, coin);
        }

        for (PowerUp powerUp : powerUps) {
            paintPowerUp(g, powerUp);
        }

        g.setColor(Color.white);
        g.setFont(new Font("Arial", 1, 25));

        if (!started) {
            g.drawString("Press Space to start!", 75, HEIGHT / 2 - 50);
        }
        if (gameOver) {
            g.drawString("Game Over! Press Space to start!", 100, HEIGHT / 2 - 50);
        }
        if (!gameOver && started) {
            g.drawString(String.valueOf(score), WIDTH / 2 - 100, 100);
            g.drawString(String.valueOf(coinsGained), WIDTH / 2 -25, 100);
        }
        if (isMoreCoins) {
            g.drawString("Get ready for some fucking coins!", 75, HEIGHT / 2 - 50);
        }
    }

    public void newGame() {
        bird = new Bird(WIDTH / 2 - 10, HEIGHT / 2 - 10, 40, 40, birdImage, birdImageJump);
        obstacle.clear();
        coins.clear();
        yMotion = 0;
        score = 0;
        coinsGained = 0;

        for (int i = 0; i < 4; i++) {
            addObstacle(true);
        }

        coinTimer = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCoin(true);
            }
        });

        powerUpTimer = new Timer(4000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPowerUp(true);
            }
        });

        coinTimer.setRepeats(true);
        coinTimer.start();
        powerUpTimer.setRepeats(true);
        powerUpTimer.start();
    }

    public void jump() {

        System.out.println("Jumping");

        if (!started) {
            started = true;
        }
        else if (!gameOver) {
            if (yMotion > 0) {
                yMotion = 0;
            }
            yMotion -= 10;
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (gameOver) {
            bird.y = HEIGHT + 1;
            renderer.repaint();
            return;
        }

        int speed = 10;
        Rectangle p = new Rectangle(bird.x, bird.y, bird.width, bird.height);
        ticks++;
        coinsToRemove = new ArrayList<>();
        powerUpsToRemove = new ArrayList<>();


        if (started) {

            bird.setJumping(isJumping);

            if (backgroundX < -backgroundImage.getWidth()) {
                backgroundX = 0;
            }

            backgroundX -= speed;

            if (groundX < -groundImage.getWidth()) {
                groundX = 0; // Reset the ground to start again.
            }
            groundX -= speed;

            for (int i = 0; i < obstacle.size(); i++) {
                Obstacle o = obstacle.get(i);
                o.x -= speed;
                if (o.x + o.width < 0) {
                    obstacle.remove(o);
                    if (o.y == 0) {
                        addObstacle(false);
                    }
                }
            }

            if (ticks % 2 == 0 && yMotion < 15) {
                yMotion += 2;
            }

            bird.y += yMotion;

            if (yMotion >= 0) {
                isJumping = false;
                bird.setImage(birdImage);
            }
            else {
                isJumping = true;
                bird.setImage(birdImageJump);
            }


            for (Obstacle o : obstacle) {
                if (o.y == 0 && bird.x + bird.width / 2 > o.x + o.width / 2 - 10 && bird.x + bird.width / 2 < o.x + o.width / 2 + 10) {
                    score++;
                }
                Rectangle obs = new Rectangle(o.x, o.y, o.width, o.height);

                if (obs.intersects(p)) {
                    gameOver = true;

                    if (bird.x <= o.x) {
                        bird.x = o.y - bird.height;
                    }

                    else {
                        if (o.y != 0) {
                            bird.y = o.y - bird.height;
                        }
                        else if (bird.y < o.height) {
                            bird.y = o.height;
                        }

                    }
                }
            }

            for (int i = 0; i < coins.size(); i++) {
                Coin coin = coins.get(i);
                coin.x -= speed;
                if (coin.x + coin.width < 0) {
                    coins.remove(coin);
                    if (coin.y == 0) {
                        addCoin(false);
                    }
                }
            }

            for (Coin coin : coins) {
                Rectangle c = new Rectangle(coin.x, coin.y, coin.width, coin.height);
                if (c.intersects(p)) {
                    coinsGained++;
                    coinsToRemove.add(coin); // Add the coin to the removal list.
                }
            }

            // Now, remove the coins outside of the loop.
            coins.removeAll(coinsToRemove);

            for (int i = 0; i < powerUps.size(); i++) {
                PowerUp powerUp = powerUps.get(i);
                powerUp.x -= speed;
                if (powerUp.x + powerUp.width < 0) {
                    powerUps.remove(powerUp);
                    if (powerUp.y == 0) {
                        addPowerUp(false);
                    }
                }
            }

            for (PowerUp powerUp : powerUps) {
                Rectangle pu = new Rectangle(powerUp.x, powerUp.y, powerUp.width, powerUp.height);
                if (pu.intersects(p)) {
                    powerUpsToRemove.add(powerUp); // Add the coin to the removal list.
                    powerUp();
                }
            }
            // Now, remove the powerups outside of the loop.
            powerUps.removeAll(powerUpsToRemove);

            if (bird.y > HEIGHT - 120 || bird.y < 0) {
                gameOver = true;
            }
            if (bird.y + yMotion >= HEIGHT - 120) {
                bird.y = HEIGHT - 120 - bird.height;
                gameOver = true;
            }
        }
        renderer.repaint();
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void mousePressed(MouseEvent e)
    {
    }

    public void mouseReleased(MouseEvent e)
    {
    }

    public void mouseEntered(MouseEvent e)
    {
    }

    public void mouseExited(MouseEvent e)
    {
    }

    public void keyTyped(KeyEvent e)
    {
    }

    public void keyPressed(KeyEvent e) {
        if (gameOver) {
            gameOver = false;
            started = true;
            newGame();
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            jump();
        }
    }
}
