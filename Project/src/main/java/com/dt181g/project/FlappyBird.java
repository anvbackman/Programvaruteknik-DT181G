package com.dt181g.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import java.awt.event.KeyListener;

import java.awt.event.MouseListener;

public class FlappyBird implements ActionListener, MouseListener, KeyListener {

    public static FlappyBird flappyBird;
    private Bird bird;
    private ArrayList<Obstacle> obstacle;
    private int WIDTH = 800;
    private int HEIGHT = 800;
    public Random rand;
    public Renderer renderer;
    private String birdSymbol = "A";

    public boolean gameOver;
    public boolean started;
    public int ticks;
    public int yMotion;
    public int score;

    private ArrayList<Coin> coins;
    private int coinWidth = 20;
    private int coinHeight = 20;

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

        bird = new Bird(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
        obstacle = new ArrayList<>();
        coins = new ArrayList<>();
        rand = new Random();
        addObstacle(true);
        addObstacle(true);
        addObstacle(true);
        addObstacle(true);
        addCoin(true);
        addCoin(true);
        addCoin(true);
        addCoin(true);
        timer.start();
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

        g.setColor(Color.RED);
//        g.setFont(new Font("Arial", Font.BOLD, 24));
//
//        g.drawString(String.valueOf(birdSymbol), bird.x, bird.y);
        g.fillRect(bird.x, bird.y, bird.width, bird.height);

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
            g.drawString(String.valueOf(score), WIDTH / 2 - 25, 100);
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
        bird = new Bird(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
        obstacle.clear();
        yMotion = 0;
        score = 0;

        addObstacle(true);
        addObstacle(true);
        addObstacle(true);
        addObstacle(true);
        addCoin(true);
        addCoin(true);
        addCoin(true);
        addCoin(true);
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
        int speed = 10;
        Rectangle p = new Rectangle(bird.x, bird.y, bird.width, bird.height);
//        int gravity = 2;
        ticks++;

        if (started) {
            for (int i = 0; i < obstacle.size(); i++) {
                Obstacle o = obstacle.get(i);
                o.x -= speed;
            }

            if (ticks % 2 == 0 && yMotion < 15) {
                yMotion += 2;
            }
//            yMotion += gravity;

            for (int i = 0; i < obstacle.size(); i++) {
                Obstacle o = obstacle.get(i);
                if (o.x + o.width < 0) {
                    obstacle.remove(o);
                    if (o.y == 0) {
                        addObstacle(false);
                    }
                }
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

            addCoin(false);

            for (int i = 0; i < coins.size(); i++) {
                Coin coin = coins.get(i);
                if (coin.x + coin.width < 0) {
                    coins.remove(coin);
                }
            }

            for (Coin coin : coins) {
                Rectangle c = new Rectangle(coin.x, coin.y, coin.width, coin.height);
                if (c.intersects(p)) {
                    coins.remove(coin);
                }
            }

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
    }


    public void keyReleased(KeyEvent e) {
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
