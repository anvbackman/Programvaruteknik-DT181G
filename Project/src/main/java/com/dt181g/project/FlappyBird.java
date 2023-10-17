package com.dt181g.project;

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

public class FlappyBird implements ActionListener, MouseListener, KeyListener {

    public static FlappyBird flappyBird;
    private Bird bird;
    private ArrayList<Obstacle> obstacle;
    public int WIDTH = 800;
    public int HEIGHT = 800;
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
    private int coinWidth = 40;
    private int coinHeight = 40;

    private Timer coinTimer;
    private BufferedImage birdImage;
    private BufferedImage birdImageJump;

    private boolean isJumping;

    public FlappyBird() {
//        GUI gui = new GUI();

        Timer timer = new Timer(20, this);
        renderer = new Renderer();
        JFrame frame = new JFrame();
        frame.add(renderer);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Flappy Bird");
        frame.setVisible(true);
        frame.addMouseListener(this);

//        bird = new Bird(WIDTH / 2 - 10, HEIGHT / 2 - 10, 40, 40);
//        birdImage = ImageLoader.loadIMG("flappy1.png");
//        bird = new Bird(WIDTH / 2 - birdImage.getWidth() / 2, HEIGHT / 2 - birdImage.getHeight() / 2, birdImage);

        obstacle = new ArrayList<>();
        coins = new ArrayList<>();
        rand = new Random();

        newGame();


        try {
            birdImage = ImageIO.read(new File("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\flappy1.png"));
            birdImageJump = ImageIO.read(new File("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\flappy2.png"));

        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading picture");
        }

        bird = new Bird(WIDTH / 2 - 10, HEIGHT / 2 - 10, 40, 40, birdImage, birdImageJump);
//        isJumping = false;

//        addObstacle(true);
//        addObstacle(true);
//        addObstacle(true);
//        addObstacle(true);

        coinTimer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCoin(true);
            }
        });

//        addCoin(true);
//        addCoin(true);
//        addCoin(true);
//        addCoin(true);
        timer.start();
        coinTimer.setRepeats(true);
        coinTimer.start();
    }


    public Bird getBird() {
        return bird;
    }

    public ArrayList<Obstacle> getObstacle() {
        return obstacle;
    }

    public ArrayList<Coin> getCoins() {
        return coins;
    }



    public BufferedImage getBirdImage() {
        return birdImage;
    }

    public void addObstacle(boolean start) {
        int spacing = 300;
        int width = 100;
        int height = 50 + rand.nextInt(300);

        if (start) {
            obstacle.add(new Obstacle(WIDTH + width + obstacle.size() * 300, HEIGHT - height - 120, width, height));
            obstacle.add(new Obstacle(WIDTH + width + (obstacle.size() - 1) * 300, 0, width, HEIGHT - height - spacing));
        }
        else {
            obstacle.add(new Obstacle(obstacle.get(obstacle.size() - 1).x + 600, HEIGHT - height - 120, width, height));
            obstacle.add(new Obstacle(obstacle.get(obstacle.size() - 1).x, 0, width, HEIGHT - height - spacing));
        }
    }

    public void paintObstacle(Graphics g, Obstacle obstacle) {
        g.setColor(Color.GREEN.darker());
        g.fillRect(obstacle.x, obstacle.y, obstacle.width, obstacle.height);
    }

    public void addCoin(boolean start) {
        int spacing = 300;
        int coinYPosition = rand.nextInt(HEIGHT - 120 - coinHeight);

        if (start) {
            coins.add(new Coin(WIDTH + coinWidth + obstacle.size() * 300, coinYPosition, coinWidth, coinHeight));
        }
        else {
            coins.add(new Coin(coins.get(coins.size() - 1).x + 600, coinYPosition, coinWidth, coinHeight));
        }
    }

    public void paintCoin(Graphics g, Coin coin) {
        g.setColor(Color.YELLOW);
        g.fillOval(coin.x, coin.y, coin.width, coin.height);
    }




    public void repaint(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        if (bird != null) {
            BufferedImage currentImage = bird.getCurrentImage();
            g.drawImage(currentImage, bird.x, bird.y, bird.width, bird.height, null);
        }



//        if (bird != null) {
//            g.drawImage(birdImage, bird.x, bird.y, (ImageObserver) this);
//        }
//        g.setColor(Color.RED);
//        g.setFont(new Font("Arial", Font.BOLD, 24));
//
//        g.drawString(String.valueOf(birdSymbol), bird.x, bird.y);
//        g.fillRect(bird.x, bird.y, bird.width, bird.height);
//        g.drawImage(birdImage, bird.x, bird.y, null);

        g.setColor(Color.ORANGE);
        g.fillRect(0, HEIGHT - 120, WIDTH, 150);
        g.setColor(Color.GREEN);
        g.fillRect(0, HEIGHT - 120, WIDTH, 20);



        for (Obstacle o : obstacle) {
            paintObstacle(g, o);
        }

        for (Coin coin : coins) {
            paintCoin(g, coin);
        }

        g.setColor(Color.white);
        g.setFont(new Font("Arial", 1, 100));

        if (!started) {
            g.drawString("Click to start!", 75, HEIGHT / 2 - 50);
        }
        if (gameOver) {
            g.drawString("Game Over!", 100, HEIGHT / 2 - 50);
        }
        if (!gameOver && started) {
            g.drawString(String.valueOf(score), WIDTH / 2 - 100, 100);
            g.drawString(String.valueOf(coinsGained), WIDTH / 2 -25, 100);
        }
    }

    public void addSymbol(String symbol) {
        birdSymbol += symbol;
    }

    public void removeSymbol() {
        if (birdSymbol.length() > 1) {
            birdSymbol = birdSymbol.substring(0, birdSymbol.length() - 1);
        }
    }

    public void newGame() {
        bird = new Bird(WIDTH / 2 - 10, HEIGHT / 2 - 10, 40, 40, birdImage, birdImageJump);
//        bird = new Bird(WIDTH / 2 - birdImage.getWidth() / 2, HEIGHT / 2 - birdImage.getHeight() / 2, birdImage);
        obstacle.clear();
        coins.clear();
        yMotion = 0;
        score = 0;
        coinsGained = 0;

//        addObstacle(true);
//        addObstacle(true);
//        addObstacle(true);
//        addObstacle(true);
//        addCoin(true);
//        addCoin(true);
//        addCoin(true);
//        addCoin(true);
//        addCoin(true);
//        addCoin(true);
//        addCoin(true);
    }
    public void jump() {
//        if (gameOver) {
//            bird = new Bird(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
//            obstacle.clear();
//            yMotion = 0;
//            score = 0;
//
//            addObstacle(true);
//            addObstacle(true);
//            addObstacle(true);
//            addObstacle(true);
//        }

//        if (gameOver) {
////            isJumping = false;
//        }

        if (!started) {
            started = true;
        }
        else if (!gameOver) {
            if (yMotion > 0) {
                yMotion = 0;
            }
            yMotion -= 10;
            isJumping = true;
//            isJumping = true;
//            isJumping = !isJumping;
        }
//        isJumping = true;
//        isJumping = true;
    }

    public void actionPerformed(ActionEvent e) {
        int speed = 10;
        Rectangle p = new Rectangle(bird.x, bird.y, bird.width, bird.height);
//        int gravity = 2;
        ticks++;
        coinsToRemove = new ArrayList<>();

        if (started) {

            bird.setJumping(false);


//            if (isJumping) {
//                isJumping = false;
//            }
//            else {
//                isJumping = true;
//            }


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


            for (Obstacle o : obstacle) {
                if (o.y == 0 && bird.x + bird.width / 2 > o.x + o.width / 2 - 10 && bird.x + bird.width / 2 < o.x + o.width / 2 + 10) {
                    score++;
                }
                Rectangle r = new Rectangle(o.x, o.y, o.width, o.height);

                if (r.intersects(p)) {
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

//            addCoin(false);



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
        if (gameOver) {
            gameOver = false;
            started = true;
            newGame();
        }
        jump();
//        isJumping = true;
    }


    public void keyReleased(KeyEvent e) {
//        isJumping = false;
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            jump();

        }
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


    public void keyPressed(KeyEvent e)
    {

    }
}
