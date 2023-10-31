package com.dt181g.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class View extends JPanel implements ActionListener {

    private boolean isRunning = false;
    private BufferedImage backgroundImage;
    private BirdModel bird;

    private int score;

    public View() {
        backgroundImage = com.dt181g.project.IMG.ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\bg.png");
        Timer timer = new Timer(20, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isRunning) {

        }

        repaint();
    }

    public void repaint(Graphics g) {
//        for (int x = backgroundX; x < WIDTH; x += backgroundImage.getWidth()) {
//            g.drawImage(backgroundImage, x, 0, WIDTH + 120, HEIGHT, null);
//        }
//        for (int x = groundX; x < WIDTH; x += groundImage.getWidth()) {
//            g.drawImage(groundImage, x, HEIGHT - 120, WIDTH, 150, null);
//        }

        if (bird != null) {
//            BufferedImage currentImage = bird.getCurrentImage();
//            g.drawImage(bird.getImage(), bird.x, bird.y, bird.width, bird.height, null);
        }


    }

}
//    private boolean isRunning = false;
//    private BufferedImage image;
//    private Image background;
//    private int backgroundX;
//    private Bird bird;
////    private List<ObstacleColumn> obstacleColumnList;
//    private List<Obstacle> obstacleList;
//    private int score;
//    private int ticks;
//    private int yMotion;
//    private int highScore;
//
//    public View() {
//        image = com.dt181g.project.IMG.ImageLoader.loadIMG("C:\\Users\\Andre\\JavaProjects\\Java2\\anba2205_solutions_ht23\\Project\\src\\main\\resources\\IMG\\bg.png");
//        background = image;
//        backgroundX = 0;
//        setFocusable(true);
//        setDoubleBuffered(false);
//        addKeyListener(new GameKeyAdapter());
//        Timer timer = new Timer(20, this);
//        timer.start();
//
//
//    }
//
//    public boolean getIsRunning() {
//        return isRunning;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
////    Toolkit.getDefaultToolkit().sync();
//
//    ticks++;
//    obstacleList = new ArrayList<>();
//
//    if (isRunning) {
////        bird.tick();
////        obstacleColumn.tick();
//        if (backgroundX < -image.getWidth()) {
//            backgroundX = 0;
//        }
//
//        backgroundX -= bird.getSpeed();
//
////        if (groundX < -groundImage.getWidth()) {
////            groundX = 0; // Reset the ground to start again.
////        }
////        groundX -= bird.getSpeed();
//
////        for (int i = 0; i < obstacleList.size(); i++) {
////            Obstacle o = obstacleList.get(i);
////            o.x -= bird.getSpeed();
////            if (o.x + o.width < 0) {
////                obstacleList.remove(o);
////                if (o.y == 0) {
////                    (false);
////                }
////            }
////        }
//
//        if (ticks % 2 == 0 && yMotion < 15) {
//            yMotion += 2;
//        }
//
//        bird.y += yMotion;
//    }
//
//    repaint();
//    }
//
//    @Override
//    public void paint(Graphics g) {
//        Graphics2D g2 = (Graphics2D) g;
//        g2.drawImage(background, 0, 0, null);
//
////        if (isRunning) {
////            this.bird.render(g, this);
////            this.obstacleColumn.render(g, this);
////            g2.setColor(Color.BLACK);
////            g.setFont(new Font("Arial", 1, 20));
////            g2.drawString("Score: " + this.obstacleColumn.getScore(), 10, 20);
////        }
////
////        else {
////            g2.setColor(Color.BLACK);
////            g.setFont(new Font("Arial", 1, 15));
////            g2.drawString("Press Enter to Start", Window.HEIGHT / 2 - 150, Window.HEIGHT / 2);
////            g2.setColor(Color.BLACK);
////            g.setFont(new Font("Arial", 1, 15));
////            g2.drawString("Created by Andreas Backman", Window.WIDTH - 200, Window.HEIGHT - 50);
////        }
////        g2.setColor(Color.BLACK);
////        g.setFont(new Font("Arial", 1, 20));
////        g2.drawString("High Score: " + highScore, Window.WIDTH - 160, 20);
////
////        g.dispose();
//    }
//
//    private void newGame() {
////        if (!isRunning) {
////            this.isRunning = true;
////            this.bird = new Bird(Window.WIDTH / 2, Window.HEIGHT / 2);
////            this.obstacleColumn = new ObstacleColumn();
////        }
//    }
//
////    private void endGame() {
////        this.isRunning = false;
////        if (this.obstacleColumn.getScore() > highScore) {
////            this.highScore = this.obstacleColumn.getScore();
////        }
////        this.obstacleColumn.setScore(0);
////    }
////
////    private void checkCollision() {
////        Rectangle b = this.bird.getBounds();
////        Rectangle o;
////        for (int i = 0; i < this.obstacleColumn.getObstacles().size(); i++) {
////            Obstacle temporaryObstacle = this.obstacleColumn.getObstacles().get(i);
////            o = temporaryObstacle.getBounds();
////            if (b.intersects(o)) {
////                endGame();
////            }
////        }
////    }
//
//    private class GameKeyAdapter extends KeyAdapter {
//
//        private final Controller controller;
//
//        public GameKeyAdapter() {
//            controller = new Controller();
//
//        }
//
//        @Override
//        public void keyPressed(KeyEvent e) {
//            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//                newGame();
//            }
//        }
//
//        @Override
//        public void keyReleased(KeyEvent e) {
//            if (isRunning) {
//                controller.releaseController(bird, e);
//            }
//        }
//    }
//
//}
//
//
//
//
//
//
//
////        Timer timer = new Timer(20, this);
////        renderer = new Renderer();
//////        JFrame frame = new JFrame();
////
////        this.setSize(800, 800);
////        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//////        frame.add(renderer);
////        this.add(renderer);
//////        this.setVisible(true);
////        obstacles = new ArrayList<>();
////        coins = new ArrayList<>();
////        backgroundX = 0;
////
////        timer.start();
////
////    }
////
////
////    public void actionPerformed(ActionEvent e) {
////        repaint();
////    }
////
////
////    public void repaint(Graphics g, int backgroundX, int WIDTH, BufferedImage backgroundImage, int groundX, BufferedImage groundImage, boolean started, boolean gameOver, int score) {
////
////        for (int x = backgroundX; x < WIDTH; x += backgroundImage.getWidth()) {
////            g.drawImage(backgroundImage, x, 0, WIDTH + 120, HEIGHT, null);
////        }
////        for (int x = groundX; x < WIDTH; x += groundImage.getWidth()) {
////            g.drawImage(groundImage, x, HEIGHT - 120, WIDTH, 150, null);
////        }
////
////        if (bird != null) {
////            BufferedImage currentImage = bird.getCurrentImage();
////            g.drawImage(currentImage, bird.x, bird.y, bird.width, bird.height, null);
////        }
////
////        for (Obstacle o : obstacles) {
////            paintObstacle(g, o);
////        }
////
//////        for (Coin coin : coins) {
//////            paintCoin(g, coin);
//////        }
////
//////        for (PowerUp powerUp : powerUps) {
//////            paintPowerUp(g, powerUp);
//////        }
//////
//////        for (Bullet bullet : bullets) {
//////            paintBullet(g, bullet);
//////        }
////
////        g.setColor(Color.white);
////        g.setFont(new Font("Arial", 1, 25));
////
////        if (!started) {
////            g.drawString("Press Space to start!", 75, HEIGHT / 2 - 50);
////        }
////        if (gameOver) {
////            g.drawString("Game Over! Press Space to start!", 100, HEIGHT / 2 - 50);
////        }
////        if (!gameOver && started) {
////            g.drawString(String.valueOf(score), WIDTH / 2 - 100, 100);
//////            g.drawString(String.valueOf(coinsGained), WIDTH / 2 -25, 100);
////        }
//////        if (isMoreCoins) {
//////            g.drawString("Get ready for some fucking coins!", 75, HEIGHT / 2 - 50);
//////        }
//////
//////        if (isGhost) {
//////            g.drawString("Spookers", 75, HEIGHT / 2 - 50);
//////        }
////    }
////
////    public void paintObstacle(Graphics g, Obstacle obstacle) {
////        if (obstacle.getPosition()) {
////            g.drawImage(obstacle.getCurrentImage(), obstacle.x, obstacle.y, obstacle.width, obstacle.height, null);
////        }
////        else {
////            g.drawImage(obstacle.getCurrentImage(), obstacle.x, obstacle.y, obstacle.width, obstacle.height, null);
////        }
////    }
//
////    public void paintCoin(Graphics g, Coin coin) {
////        g.drawImage(coinImage, coin.x, coin.y, coin.width, coin.height, null);
////    }
////
////    public void paintPowerUp(Graphics g, PowerUp powerUp) {
////        g.drawImage(powerUpImage, powerUp.x, powerUp.y, powerUp.width, powerUp.height, null);
////    }
////
////    public void paintBullet(Graphics g, Bullet bullet) {
////        g.drawImage(bulletImage, bullet.getX(), bullet.getY(), bullet.getWidth(), bullet.getHeight(), null);
////    }
//
