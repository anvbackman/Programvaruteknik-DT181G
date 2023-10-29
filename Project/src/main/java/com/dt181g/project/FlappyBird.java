package com.dt181g.project;

import com.dt181g.project.IMG.ImageLoader;

import javax.imageio.ImageIO;
import javax.swing.*;
//import java.awt.*;
import java.awt.*;
import java.util.List;
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

public class FlappyBird  {
//    implements ActionListener, MouseListener, KeyListener
    public static FlappyBird flappyBird;
    private Bird bird;
    private List<Obstacle> obstacle;
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
    private List<Obstacle> obstaclesToRemove;
    private List<Coin> coins;
    private List<Coin> coinsToRemove;

    private List<PowerUp> powerUps;
    private List<PowerUp> powerUpsToRemove;
    private int coinWidth = 50;
    private int coinHeight = 50;
    private int powerUpWidth = 50;
    private int powerUpHeight = 50;

    private Timer coinTimer;
    private Timer powerUpTimer;
    private BufferedImage birdImage;
    private BufferedImage birdImageJump;
    private BufferedImage backgroundImage;
    private BufferedImage obstacleImageTop;
    private BufferedImage obstacleImageBottom;
    private BufferedImage groundImage;
    private BufferedImage coinImage;
    private BufferedImage powerUpImage;
    private BufferedImage bulletImage;

    private List<Bullet> bullets;
    private List<Bullet> bulletsToRemove;

    private boolean isMoreCoins;
    private boolean isGhost;


    private boolean isJumping;

    public FlappyBird() {

//        Timer timer = new Timer(20, this);
//        renderer = new Renderer();
//        JFrame frame = new JFrame();
//        frame.add(renderer);
//        frame.setSize(800, 800);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setTitle("Flappy Bird");
//        frame.setVisible(true);
//        frame.addMouseListener(this);
//        frame.addKeyListener(this);


        obstacle = new ArrayList<>();
        coins = new ArrayList<>();
        powerUps = new ArrayList<>();
        bullets = new ArrayList<>();
        rand = new Random();
        backgroundX = 0;
        groundX = 0;
        isMoreCoins = false;
        isGhost = false;

//        newGame();

        groundImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\ground.png");
        coinImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\coin.png");
        powerUpImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\star.png");
        bulletImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\bullet.png");

        backgroundImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\bg.png");
        birdImage = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\flappy1.png");
        birdImageJump = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\flappy2.png");
        obstacleImageTop = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\pipe1.png");
        obstacleImageBottom = ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\pipe2.png");

//        bird = new Bird(WIDTH / 2 - 10, HEIGHT / 2 - 10, 40, 40, birdImage, birdImageJump);

//        birdImageThread = new Thread(new BirdImageRunnable(birdImage, true, "BirdImageThread"));
//        birdImageJumpThread = new Thread(new BirdImageRunnable(birdImageJump, false, "BirdImageJumpThread"));
//
//        birdImageThread.start();
//        birdImageJumpThread.start();
//        timer.start();
    }





//    public void addPowerUp(boolean start) {
//        int powerUpYPosition = rand.nextInt(HEIGHT - 120 - powerUpHeight);
//        if (start) {
//            powerUps.add(new PowerUp(WIDTH + coinWidth + obstacle.size() * 300, powerUpYPosition, powerUpWidth, powerUpHeight));
//        } else {
//            powerUps.add(new PowerUp(coins.get(coins.size() - 1).x + 600, powerUpYPosition, powerUpWidth, powerUpHeight));
//        }
//    }





//    public void powerUp() {
//        Thread powerUpThread = new Thread(() -> {
//            shootBullet(10, 50);
////            ghostBird();
//        });
//        powerUpThread.start();
//    }
//
//    public void shootBullet(int numberOfBullets, int delay) {
//        for (int i = 0; i < numberOfBullets; i++) {
//            Bullet bullet = new Bullet(bulletImage, bird.x + bird.width, bird.y + bird.height / 2, 50, 25);
//            bullets.add(bullet);
//
//            // Create a timer to remove the bullet after 3 hits
//            Timer bulletTimer = new Timer(1000, new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    if (bullet.getHits() >= 3) {
//                        bullets.remove(bullet);
//                        ((Timer) e.getSource()).stop();
//                    }
//                }
//            });
//            bulletTimer.start();
//
//            // Create a timer to move the bullet to the right
//            Timer moveBulletTimer = new Timer(1000, new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    bullet.move(5); // Adjust the speed as needed
//                    if (bullet.getX() > WIDTH) {
//                        bullets.remove(bullet);
//                        ((Timer) e.getSource()).stop();
//                    }
//                }
//            });
//            moveBulletTimer.start();
//
//            try {
//                Thread.sleep(delay); // Delay before shooting the next bullet
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }

//
//    public void ghostBird() {
//
//
//        isGhost = true;
//        bird.increaseSpeed(5);
//
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        bird.resetSpeed();
//        isGhost = false;
//
//    }
//
//    public void moreCoins() {
//        int originalInterval = coinTimer.getDelay();
//
//        isMoreCoins = true;
//        Timer temporaryTimer = new Timer(250, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                coinTimer.setDelay(25);
//                addCoin(true);
//            }
//        });
//
//        temporaryTimer.setRepeats(false);
//        temporaryTimer.start();
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        isMoreCoins = false;
//        coinTimer.setDelay(originalInterval);
//        coinTimer.start();
//    }


//    public void repaint(Graphics g) {
//
//        for (int x = backgroundX; x < WIDTH; x += backgroundImage.getWidth()) {
//            g.drawImage(backgroundImage, x, 0, WIDTH + 120, HEIGHT, null);
//        }
//        for (int x = groundX; x < WIDTH; x += groundImage.getWidth()) {
//            g.drawImage(groundImage, x, HEIGHT - 120, WIDTH, 150, null);
//        }
//
//        if (bird != null) {
//            BufferedImage currentImage = bird.getCurrentImage();
//            g.drawImage(currentImage, bird.x, bird.y, bird.width, bird.height, null);
//        }
//
//        for (Obstacle o : obstacle) {
//            paintObstacle(g, o);
//        }
//
//        for (Coin coin : coins) {
//            paintCoin(g, coin);
//        }
//
//        for (PowerUp powerUp : powerUps) {
//            paintPowerUp(g, powerUp);
//        }
//
//        for (Bullet bullet : bullets) {
//            paintBullet(g, bullet);
//        }
//
//        g.setColor(Color.white);
//        g.setFont(new Font("Arial", 1, 25));
//
//        if (!started) {
//            g.drawString("Press Space to start!", 75, HEIGHT / 2 - 50);
//        }
//        if (gameOver) {
//            g.drawString("Game Over! Press Space to start!", 100, HEIGHT / 2 - 50);
//        }
//        if (!gameOver && started) {
//            g.drawString(String.valueOf(score), WIDTH / 2 - 100, 100);
//            g.drawString(String.valueOf(coinsGained), WIDTH / 2 -25, 100);
//        }
//        if (isMoreCoins) {
//            g.drawString("Get ready for some fucking coins!", 75, HEIGHT / 2 - 50);
//        }
//
//        if (isGhost) {
//            g.drawString("Spookers", 75, HEIGHT / 2 - 50);
//        }
//    }







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

    }
}
